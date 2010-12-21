package vaistupompa;

import java.util.ArrayList;

/**
 *
 * @author Vytautas
 */
public class Simulator {

    // <editor-fold defaultstate="collapsed" desc="Private members">

    private int _t;
    private int _deltaT;
    private double _x1 = 0.01; //vaisto kiekis kraujyje 1 kompartamente
    private double _x2 = 0.01; //vaisto kiekis kraujyje 2 kompartamente
    private double _x3 = 0.01; //vaisto kiekis kraujyje 3 kompartamente

    private double _x1_1 = _x1; //tas pats iPKA pompoj
    private double _x2_1 = _x2; //tas pats iPKA pompoj
    private double _x3_1 = _x3; //tas pats iPKA pompoj

    private ArrayList<DataContainer> _valuesList_PKA;
    private ArrayList<DataContainer> _valuesList_iPKA;
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

        setValuesList_PKA(new ArrayList<DataContainer>());

        for (int i = 0; i <= _t; i++) {
            DataContainer cont = new DataContainer();

            cont.setGenerator_x1(_x1);
            cont.setGenerator_x2(_x2);
            cont.setGenerator_x3(_x3);

            timeToNextDose = generator.generate(_x1, _x2, _x3);

            cont.setGenerator_out(timeToNextDose - i);

            if (timeToNextDose == i) {
                if (pka_pump.allowed(i)) {
                    _x1 += Constants.getDosage();
                    cont.setGenerator_x1(_x1);

                    cont.setPompa_out(true);
                } else {
                    cont.setPompa_out(false);
                    cont.setGenerator_out(Integer.MAX_VALUE);
                }
            } else {
                cont.setGenerator_out(Integer.MAX_VALUE);
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

            cont.setInteg1_x1(_x1);
            cont.setInteg1_x2(_x2);
            cont.setInteg2_x1(_x1);
            cont.setInteg3_x1(_x1);

            double pokyt1 = integrator1.calculate1Compartment();
            double pokyt2 = integrator1.calculate2Compartment();
            double pokyt3 = integrator1.calculate3Compartment();

            cont.setInteg1_out(pokyt1);
            cont.setInteg2_out(pokyt2);
            cont.setInteg3_out(pokyt3);

            cont.setSum1_x1(pokyt2);
            cont.setSum1_x2(pokyt1);
            cont.setSum1_x3(pokyt1);
            cont.setSum1_x4(pokyt3);
            cont.setSum1_x5(pokyt1);

            cont.setSum2_x1(pokyt1);
            cont.setSum2_x2(pokyt2);

            cont.setSum3_x1(pokyt1);
            cont.setSum3_x2(pokyt3);

            ISumator sumator1 = new Sumator();
            sumator1.setKValues(Constants.getCl(), Constants.getK12(),
                    Constants.getK21(), Constants.getK13(),
                    Constants.getK31());

            sumator1.setXValues(pokyt1, pokyt2, pokyt3);

            //_x1 = sumator1.getSumK1(); //vaisto kiekis kraujo plazmoje einamuoju laiko momentu (i) 1 kompartamente
            //_x2 = sumator1.getSumK2(); //vaisto kiekis kraujo plazmoje einamuoju laiko momentu (i) 2 kompartamente
            //_x3 = sumator1.getSumK3(); //vaisto kiekis kraujo plazmoje einamuoju laiko momentu (i) 3 kompartamente

            _x1 += pokyt1;
            _x2 += pokyt2;
            _x3 += pokyt3;

            cont.setSum1_out(_x1);
            cont.setSum2_out(_x2);
            cont.setSum3_out(_x3);

            getValuesList_PKA().add(cont);
        }

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="iPKA pompa">

        setValuesList_iPKA(new ArrayList<DataContainer>());

        int timeToDistribute = 0;
        for (int i = 0; i <= _t; i++) {
            DataContainer cont = new DataContainer();

            cont.setGenerator_x1(_x1_1);
            cont.setGenerator_x2(_x2_1);
            cont.setGenerator_x3(_x3_1);

            if (timeToNextDose2 == i) {
                if (ipka_pump.allowed(i)) {
                    timeToDistribute = _deltaT;

                    timeToNextDose2 = i + generator.generate(_x1_1, _x2_1, _x3_1);

                    cont.setGenerator_out(timeToNextDose2 - i);

                    cont.setPompa_out(true);
                } else {
                    cont.setPompa_out(false);
                    cont.setGenerator_out(Integer.MAX_VALUE);
                }
            } else {
                cont.setGenerator_out(Integer.MAX_VALUE);
            }

            if (timeToDistribute > 0) {
                _x1_1 += Constants.getDosage()/_deltaT;
                timeToDistribute--;
            }

            cont.setGenerator_x1(_x1_1);

            IIntegrator integrator1 = new Integrator();
            integrator1.setCl(Constants.getCl());
            integrator1.setK12(Constants.getK12());
            integrator1.setK13(Constants.getK13());
            integrator1.setK21(Constants.getK21());
            integrator1.setK31(Constants.getK31());
            integrator1.setX1(_x1_1);
            integrator1.setX2(_x2_1);
            integrator1.setX3(_x3_1);

            cont.setInteg1_x1(_x1_1);
            cont.setInteg1_x2(_x2_1);
            cont.setInteg2_x1(_x1_1);
            cont.setInteg3_x1(_x1_1);

            double pokyt1 = integrator1.calculate1Compartment();
            double pokyt2 = integrator1.calculate2Compartment();
            double pokyt3 = integrator1.calculate3Compartment();

            cont.setInteg1_out(pokyt1);
            cont.setInteg2_out(pokyt2);
            cont.setInteg3_out(pokyt3);

            cont.setSum1_x1(pokyt2);
            cont.setSum1_x2(pokyt1);
            cont.setSum1_x3(pokyt1);
            cont.setSum1_x4(pokyt3);
            cont.setSum1_x5(pokyt1);

            cont.setSum2_x1(pokyt1);
            cont.setSum2_x2(pokyt2);

            cont.setSum3_x1(pokyt1);
            cont.setSum3_x2(pokyt3);

            ISumator sumator1 = new Sumator();
            sumator1.setKValues(Constants.getCl(), Constants.getK12(),
                    Constants.getK21(), Constants.getK13(),
                    Constants.getK31());

            sumator1.setXValues(pokyt1, pokyt2, pokyt3);

            _x1_1 = sumator1.getSumK1(); //vaisto kiekis kraujo plazmoje einamuoju laiko momentu (i) 1 kompartamente
            _x2_1 = sumator1.getSumK2(); //vaisto kiekis kraujo plazmoje einamuoju laiko momentu (i) 2 kompartamente
            _x3_1 = sumator1.getSumK3(); //vaisto kiekis kraujo plazmoje einamuoju laiko momentu (i) 3 kompartamente

            cont.setSum1_out(_x1_1);
            cont.setSum2_out(_x2_1);
            cont.setSum3_out(_x3_1);

            getValuesList_iPKA().add(cont);
        }

        // </editor-fold>
    }

    /**
     * @return the _valuesList_PKA
     */
    public ArrayList<DataContainer> getValuesList_PKA() {
        return _valuesList_PKA;
    }

    /**
     * @param valuesList_PKA the _valuesList_PKA to set
     */
    public void setValuesList_PKA(ArrayList<DataContainer> valuesList_PKA) {
        this._valuesList_PKA = valuesList_PKA;
    }

    /**
     * @return the _valuesList_iPKA
     */
    public ArrayList<DataContainer> getValuesList_iPKA() {
        return _valuesList_iPKA;
    }

    /**
     * @param valuesList_iPKA the _valuesList_iPKA to set
     */
    public void setValuesList_iPKA(ArrayList<DataContainer> valuesList_iPKA) {
        this._valuesList_iPKA = valuesList_iPKA;
    }
}
