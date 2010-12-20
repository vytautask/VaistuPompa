package vaistupompa;

/**
 *
 * @author Jonas and Vytautas
 */
public interface IIntegrator {

    /**
     * Gauti 1 kompartamento vaistų kiekio pokytį
     * @return
     */
    public double calculate1Compartment();

    /**
     * Gauti 2 kompartamento vaistų kiekio pokytį
     * @return
     */
    public double calculate2Compartment();

    /**
     * Gauti 3 kompartamento vaistų kiekio pokytį
     * @return
     */
    public double calculate3Compartment();

    // <editor-fold defaultstate="collapsed" desc="Get/Set methods">

     /**
     * @return the _cl
     */
    double getCl();

    /**
     * @return the _k12
     */
    double getK12();

    /**
     * @return the _k13
     */
    double getK13();

    /**
     * @return the _k21
     */
    double getK21();

    /**
     * @return the _k31
     */
    double getK31();

    /**
     * @return the _x1
     */
    double getX1();

    /**
     * @return the _x2
     */
    double getX2();

    /**
     * @return the _x3
     */
    double getX3();

    /**
     * @param cl the _cl to set
     */
    void setCl(double cl);

    /**
     * @param k12 the _k12 to set
     */
    void setK12(double k12);

    /**
     * @param k13 the _k13 to set
     */
    void setK13(double k13);

    /**
     * @param k21 the _k21 to set
     */
    void setK21(double k21);

    /**
     * @param k31 the _k31 to set
     */
    void setK31(double k31);

    /**
     * @param x1 the _x1 to set
     */
    void setX1(double x1);

    /**
     * @param x2 the _x2 to set
     */
    void setX2(double x2);

    /**
     * @param x3 the _x3 to set
     */
    void setX3(double x3);

    // </editor-fold>
}
