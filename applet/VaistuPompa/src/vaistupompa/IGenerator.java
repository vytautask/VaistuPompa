package vaistupompa;

import java.util.ArrayList;

/**
 *
 * @author Vytautas
 */
public interface IGenerator {

    public void setLambda(int lambda);
    public void setT(int t);
    public void setPainConst(double painConst);

    public int getLambda();
    public int getT();
    public double getPainConst();
    public ArrayList<IGeneratorValue> getGeneratedValues();

    public double generate(double x1);
    public double generate(double x1, double x2);
    public double generate(double x1, double x2, double x3);
}
