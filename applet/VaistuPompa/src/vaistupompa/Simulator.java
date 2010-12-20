package vaistupompa;

/**
 *
 * @author Vytautas
 */
public class Simulator {

    // <editor-fold defaultstate="collapsed" desc="Private members">

    private int _t;
    private int _deltaT;
    private double _x1; //vaisto kiekis kraujyje 1 kompartamente
    private double _x2; //vaisto kiekis kraujyje 2 kompartamente
    private double _x3; //vaisto kiekis kraujyje 3 kompartamente

    private double _x1_1; //tas pats iPKA pompoj
    private double _x2_1; //tas pats iPKA pompoj
    private double _x3_1; //tas pats iPKA pompoj

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Ctor">

    public Simulator(int t, int deltaT) {
        _t = t;
        _deltaT = deltaT;
    }

    // </editor-fold>

    public void simulate() {
        IGenerator generator = new Generator();
        int timeToNextDose = generator.generate(_x1, _x2, _x3);
        int timeToNextDose2 = generator.generate(_x1_1, _x2_1, _x3_1);

        Pump pka_pump = new Pump(_deltaT);
        Pump ipka_pump = new Pump(_deltaT);

        // <editor-fold defaultstate="collapsed" desc="PKA pompa">

        for (int i = 0; i <= _t; i++) {
            if (timeToNextDose == i) {
                if (pka_pump.allowed(i)) {
                    _x1 += Constants.getDosage();
                    timeToNextDose = i + generator.generate(_x1, _x2, _x3);
                }
            }

            IIntegrator integrator1 = new Integrator();
            integrator1.setCl(Constants.getCl());
            integrator1.setK12(Constants.getK12());
            integrator1.setK13(Constants.getK13());
            integrator1.setK21(Constants.getK21());
            integrator1.setK31(Constants.getK31());
            integrator1.setX1(_x1);
            integrator1.setX2(_x2);
            integrator1.setX3(_x3);

            double pokyt1 = integrator1.calculate1Compartment();
            double pokyt2 = integrator1.calculate2Compartment();
            double pokyt3 = integrator1.calculate3Compartment();

            ISumator sumator1 = new Sumator();
            sumator1.setKValues(Constants.getCl(), Constants.getK12(),
                    Constants.getK21(), Constants.getK13(),
                    Constants.getK31());

            sumator1.setXValues(pokyt1, pokyt2, pokyt3);

            _x1 = sumator1.getSumK1(); //vaisto kiekis kraujo plazmoje einamuoju laiko momentu (i) 1 kompartamente
            _x2 = sumator1.getSumK2(); //vaisto kiekis kraujo plazmoje einamuoju laiko momentu (i) 2 kompartamente
            _x3 = sumator1.getSumK3(); //vaisto kiekis kraujo plazmoje einamuoju laiko momentu (i) 3 kompartamente
        }

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="iPKA pompa">

        int timeToDistribute = 0;
        for (int i = 0; i <= _t; i++) {
            if (timeToNextDose2 == i) {
                if (ipka_pump.allowed(i)) {
                    timeToDistribute = _deltaT;
                    timeToNextDose2 = i + generator.generate(_x1_1, _x2_1, _x3_1);
                }
            }

            if (timeToDistribute > 0) {
                _x1_1 += Constants.getDosage()/_deltaT;
                timeToDistribute--;
            }

            IIntegrator integrator1 = new Integrator();
            integrator1.setCl(Constants.getCl());
            integrator1.setK12(Constants.getK12());
            integrator1.setK13(Constants.getK13());
            integrator1.setK21(Constants.getK21());
            integrator1.setK31(Constants.getK31());
            integrator1.setX1(_x1_1);
            integrator1.setX2(_x2_1);
            integrator1.setX3(_x3_1);

            double pokyt1 = integrator1.calculate1Compartment();
            double pokyt2 = integrator1.calculate2Compartment();
            double pokyt3 = integrator1.calculate3Compartment();

            ISumator sumator1 = new Sumator();
            sumator1.setKValues(Constants.getCl(), Constants.getK12(),
                    Constants.getK21(), Constants.getK13(),
                    Constants.getK31());

            sumator1.setXValues(pokyt1, pokyt2, pokyt3);

            _x1_1 = sumator1.getSumK1(); //vaisto kiekis kraujo plazmoje einamuoju laiko momentu (i) 1 kompartamente
            _x2_1 = sumator1.getSumK2(); //vaisto kiekis kraujo plazmoje einamuoju laiko momentu (i) 2 kompartamente
            _x3_1 = sumator1.getSumK3(); //vaisto kiekis kraujo plazmoje einamuoju laiko momentu (i) 3 kompartamente
        }

        // </editor-fold>
    }
}
