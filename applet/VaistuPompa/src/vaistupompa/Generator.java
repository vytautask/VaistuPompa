package vaistupompa;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Vytautas
 */
public class Generator implements IGenerator {

    // <editor-fold defaultstate="collapsed" desc="Private members">

    private int _lambda; //vaistų išdavimo laiko limitas
    private int _t; //pareikalavimų skaičius per valandą
    private double _painConst;
    private ArrayList<IGeneratorValue> _generatedValues = new ArrayList<IGeneratorValue>();

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Ctors">

    public Generator(int lambda, int t)
    {
        _lambda = lambda;
        _t = t;
    }

    public Generator()
    {
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Generate methods">
    
    public double generate(double x1) {
        return this.generate(x1, Double.MAX_VALUE, Double.MAX_VALUE);
    }

    public double generate(double x1, double x2) {
        return this.generate(x1, x2, Double.MAX_VALUE);
    }

    public double generate(double x1, double x2, double x3) {
        double minVal = Math.min(x1, x2);
        minVal = Math.min(minVal, x3);
        
        double generated = Double.MAX_VALUE;

        if (_painConst >= minVal)
	{
            Random rnd = new Random();
            double e = (rnd.nextInt(1000) + 1)/1000;

            generated = (double)((1/_lambda)*Math.log(e));
	}

        GeneratorValue val = new GeneratorValue();
        val.setTime(generated);
        val.setX1(x1);
        val.setX2(x2);
        val.setX3(x3);

        this._generatedValues.add(val);

        return generated;
    }
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Set methods">

    public void setLambda(int lambda) {
        this._lambda = lambda;
    }

    public void setT(int t) {
        this._t = t;
    }
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Get methods">
    
    public int getLambda() {
        return this._lambda;
    }

    public int getT() {
        return this._t;
    }

    public ArrayList<IGeneratorValue> getGeneratedValues() {
        return _generatedValues;
    }

    public void setPainConst(double painConst) {
        this._painConst = painConst;
    }

    public double getPainConst() {
        return this._painConst;
    }
    
    // </editor-fold>
}
