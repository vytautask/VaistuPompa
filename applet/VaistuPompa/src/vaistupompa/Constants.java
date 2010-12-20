package vaistupompa;

/**
 *
 * @author Vytautas
 */
public class Constants {
    
    // <editor-fold defaultstate="collapsed" desc="Private members">

    private static double _k12 = 0.0;
    private static double _k21 = 0.0;
    private static double _k31 = 0.0;
    private static double _k13 = 0.0;
    private static double _cl = 0.0;
    private static double _vss = 0.0;
    private static double _painConst = 0.0;
    private static int _maxSeconds = 1800;
    private static double _dosage = 0.0;

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Get/Set methods">
    
    /**
     * @return the _k12
     */
    public static double getK12() {
        return _k12;
    }

    /**
     * @param k12 the _k12 to set
     */
    public static void setK12(double k12) {
        _k12 = k12;
    }

    /**
     * @return the _k21
     */
    public static double getK21() {
        return _k21;
    }

    /**
     * @param k21 the _k21 to set
     */
    public static void setK21(double k21) {
        _k21 = k21;
    }

    /**
     * @return the _k31
     */
    public static double getK31() {
        return _k31;
    }

    /**
     * @param k31 the _k31 to set
     */
    public static void setK31(double k31) {
        _k31 = k31;
    }

    /**
     * @return the _k13
     */
    public static double getK13() {
        return _k13;
    }

    /**
     * @param k13 the _k13 to set
     */
    public static void setK13(double k13) {
        _k13 = k13;
    }

    /**
     * @return the _cl
     */
    public static double getCl() {
        return _cl;
    }

    /**
     * @param cl the _cl to set
     */
    public static void setCl(double cl) {
        _cl = cl;
    }

    /**
     * @return the _vss
     */
    public static double getVss() {
        return _vss;
    }

    /**
     * @param vss the _vss to set
     */
    public static void setVss(double vss) {
        _vss = vss;
    }

    public static double getPainConst() {
        return _painConst;
    }

    public static void setPainConst(double painConst) {
        _painConst = painConst;
    }

    /**
     * @return the _maxSeconds
     */
    public static int getMaxSeconds() {
        return _maxSeconds;
    }

    /**
     * @param aMaxSeconds the _maxSeconds to set
     */
    public static void setMaxSeconds(int aMaxSeconds) {
        _maxSeconds = aMaxSeconds;
    }

    /**
     * @return the _dosage
     */
    public static double getDosage() {
        return _dosage;
    }

    /**
     * @param aDosage the _dosage to set
     */
    public static void setDosage(double aDosage) {
        _dosage = aDosage;
    }

    // </editor-fold>
}
