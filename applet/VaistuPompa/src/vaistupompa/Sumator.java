package vaistupompa;

/**
 *
 * @author Jonas
 */
public class Sumator implements ISumator {

    /**
     * Private members
     */
    private double KE1 = 0;
    private double K12 = 0;
    private double K21 = 0;
    private double K13 = 0;
    private double K31 = 0;
    private double X1 = 0;
    private double X2 = 0;
    private double X3 = 0;
    private double B1[] = new double[3];
    private double B2[] = new double[2];
    private double B3[] = new double[2];

    /**
     * Constructor
     */
    public Sumator()
    {
    }

    /**
     * Set X values
     * @param _x1
     */
    public void setXValues(double _x1)
    {
        X1 = _x1;
        X2 = 0; //Double.MIN_VALUE;
        X3 = 0; //Double.MIN_VALUE;
    }
    
    /**
     * Set X values
     * @param _x1
     * @param _x2
     */
    public void setXValues(double _x1, double _x2)
    {
        X1 = _x1;
        X2 = _x2;
        X3 = 0; //Double.MIN_VALUE;
    }
    
    /**
     * Set X values
     * @param _x1
     * @param _x2
     * @param _x3
     */
    public void setXValues(double _x1, double _x2, double _x3)
    {
        X1 = _x1;
        X2 = _x2;
        X3 = _x3;
    }

    /**
     * Calculates sum value
     * @return 1 kompartament sum value
     */
    public double getSumK1()
    {
        double sum = 0;
        sum = X1 * B1[0] + X2 * B1[1] + X3 * B1[2];

        return sum;
    }

    /**
     * Calculates sum value
     * @return 2 kompartament sum value
     */
    public double getSumK2()
    {
        double sum = 0;
        sum = X1 * B2[0] + X2 * B2[1];

        return sum;
    }

    /**
     * Calculates sum value
     * @return 3 kompartament sum value
     */
    public double getSumK3()
    {
        double sum = 0;
        sum = X1 * B3[0] + X3 * B3[1];

        return sum;
    }

    /**
     * Calculates B1, B2, B3 values
     */
    private void calculateBValues()
    {
        B1[0] = -1 * K12 - KE1;
        B1[1] = K21;
        B1[2] = K31;
        B2[0] = K12;
        B2[1] = -1 * K21;
        B3[0] = K13;
        B3[1] = -1 * K31;
    }

    /**
     * Set values
     * @param _ke1
     * @param _k12
     * @param _k21
     * @param _k13
     * @param _k31
     */
    public void setKValues(double _ke1, double _k12, double _k21,
            double _k13, double _k31)
    {
        KE1 = _ke1;
        K12 = _k12;
        K21 = _k21;
        K13 = _k13;
        K31 = _k31;

        calculateBValues();
    }
}
