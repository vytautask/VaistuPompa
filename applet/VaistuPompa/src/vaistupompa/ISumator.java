package vaistupompa;

/**
 *
 * @author Jonas
 */
public interface ISumator{
    public void setXValues(double _x1);
    public void setXValues(double _x1, double _x2);
    public void setXValues(double _x1, double _x2, double _x3);
    public double getSumK1();
    public double getSumK2();
    public double getSumK3();
    public void setKValues(double _ke1, double _k12, double _k21, double _k13,
            double _k31);
    public double getSum(double x, double pokytis);
}
