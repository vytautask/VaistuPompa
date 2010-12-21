package vaistupompa;

import java.util.Random;

/**
 *
 * @author Vytautas
 */
public class Generator implements IGenerator {

    // <editor-fold defaultstate="collapsed" desc="Private members">


    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Ctors">

    public Generator()
    {
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Generate methods">
    
    public int generate(double x1) {
        return this.generate(x1, Double.MAX_VALUE, Double.MAX_VALUE);
    }

    public int generate(double x1, double x2) {
        return this.generate(x1, x2, Double.MAX_VALUE);
    }

    public int generate(double x1, double x2, double x3) {
        double minVal = Math.min(x1, x2);
        minVal = Math.min(minVal, x3);
        
        int generated = Integer.MAX_VALUE;

        if (Constants.getPainConst() >= minVal)
	{
            Random rnd = new Random();

            generated = rnd.nextInt(Constants.getMaxSeconds());
	}

        return generated;
    }
    
    // </editor-fold>
}
