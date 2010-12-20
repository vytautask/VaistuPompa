package vaistupompa;

/**
 *
 * @author Vytautas
 */
public class IntegratorValue {

    // <editor-fold defaultstate="collapsed" desc="Private members">

    private int _compartmentNo = 0;
    private double _x1 = 0;
    private double _x2 = 0;
    private double _x3 = 0;
    private double _k12 = Double.MIN_VALUE;
    private double _k21 = Double.MIN_VALUE;
    private double _k13 = Double.MIN_VALUE;
    private double _k31 = Double.MIN_VALUE;
    private double _cl = Double.MIN_VALUE;
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Ctors">

    public IntegratorValue(int compartmentNo, int x1, int x2, int x3,
            double k12, double k21, double k13, double k31, double cl) {
        _compartmentNo = compartmentNo;
        _x1 = x1;
        _x2 = x2;
        _x3 = x3;
        _k12 = k12;
        _k21 = k21;
        _k13 = k13;
        _k31 = k31;
        _cl = cl;
    }

    public IntegratorValue() {
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Get/Set methods">
    
    /**
     * @return the _compartmentNo
     */
    public int getCompartmentNo() {
        return _compartmentNo;
    }

    /**
     * @param compartmentNo the _compartmentNo to set
     */
    public void setCompartmentNo(int compartmentNo) {
        this._compartmentNo = compartmentNo;
    }

    /**
     * @return the _x1
     */
    public double getX1() {
        return _x1;
    }

    /**
     * @param x1 the _x1 to set
     */
    public void setX1(double x1) {
        this._x1 = x1;
    }

    /**
     * @return the _x2
     */
    public double getX2() {
        return _x2;
    }

    /**
     * @param x2 the _x2 to set
     */
    public void setX2(double x2) {
        this._x2 = x2;
    }

    /**
     * @return the _x3
     */
    public double getX3() {
        return _x3;
    }

    /**
     * @param x3 the _x3 to set
     */
    public void setX3(double x3) {
        this._x3 = x3;
    }

    /**
     * @return the _k12
     */
    public double getK12() {
        return _k12;
    }

    /**
     * @param k12 the _k12 to set
     */
    public void setK12(double k12) {
        this._k12 = k12;
    }

    /**
     * @return the _k21
     */
    public double getK21() {
        return _k21;
    }

    /**
     * @param k21 the _k21 to set
     */
    public void setK21(double k21) {
        this._k21 = k21;
    }

    /**
     * @return the _k13
     */
    public double getK13() {
        return _k13;
    }

    /**
     * @param k13 the _k13 to set
     */
    public void setK13(double k13) {
        this._k13 = k13;
    }

    /**
     * @return the _k31
     */
    public double getK31() {
        return _k31;
    }

    /**
     * @param k31 the _k31 to set
     */
    public void setK31(double k31) {
        this._k31 = k31;
    }

    /**
     * @return the _cl
     */
    public double getCl() {
        return _cl;
    }

    /**
     * @param cl the _cl to set
     */
    public void setCl(double cl) {
        this._cl = cl;
    }

    // </editor-fold>
}
