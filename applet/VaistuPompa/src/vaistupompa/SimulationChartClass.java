package vaistupompa;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.math.plot.Plot2DPanel;
import org.math.plot.PlotPanel;

/**
 *
 * @author ssharunas
 */
public class SimulationChartClass {

    public PlotPanel CreateAdvacedChart(ArrayList<DataContainer> pka, ArrayList<DataContainer> ipka) {
        try {
            Plot2DPanel plotpanel = new Plot2DPanel();
            if (pka != null) {

                int n = pka.size();
                double[] datas1 = new double[n];

                for (int i = 0; i < n; i++) {
                    //if(pka.get(i).getSum1_out())
                    datas1[i] = pka.get(i).getSum2_out();
                }
                // PlotPanel construction
                plotpanel.addLegend("SOUTH");

                plotpanel.addLinePlot("PKA line plot", datas1);
            }

            if (ipka != null) {

                int n = ipka.size();
                double[] datas1 = new double[n];

                for (int i = 0; i < n; i++) {
                    datas1[i] = ipka.get(i).getSum2_out();
                }
                // PlotPanel construction
                plotpanel.addLegend("SOUTH");

                plotpanel.addLinePlot("iPKA line plot", datas1);
            }

            return plotpanel;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "\r\n" + e.getMessage());
            e.printStackTrace();
            
            return null;
        }
    }
}
