package vaistupompa;

/**
 *
 * @author Vytautas
 */
public class GeneratorValue implements IGeneratorValue {

    // <editor-fold defaultstate="collapsed" desc="Private members">
    private double _time;
    private double _x1;
    private double _x2;
    private double _x3;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Get methods">
    public double getTime() {
        return _time;
    }

    public double getX1() {
        return _x1;
    }

    public double getX2() {
        return _x2;
    }

    public double getX3() {
        return _x3;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Set methods">
    public void setTime(double time) {
        _time = time;
    }

    public void setX1(double x) {
        _x1 = x;
    }

    public void setX2(double x) {
        _x2 = x;
    }

    public void setX3(double x) {
        _x3 = x;
    }
    // </editor-fold>
}
