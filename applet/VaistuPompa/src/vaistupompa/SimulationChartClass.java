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
                plotpanel.addLinePlot("PKA line plot", getSum1PlotData(pka));
            }

            if (ipka != null) {
                plotpanel.addLinePlot("iPKA line plot", getSum1PlotData(ipka));
            }

            plotpanel.addLegend("WEST");

            return plotpanel;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "\r\n" + e.getMessage());
            e.printStackTrace();
            
            return null;
        }
    }

    private double [] getSum1PlotData(ArrayList<DataContainer> data) {
        double[] result = null;

        if (data != null) {
            int n = data.size();
            result = new double[n];
            for (int i = 0; i < n; i++) {
                result[i] = data.get(i).getSum1_out();
            }
        }

        return result;
    }


    private double [] getSum2PlotData(ArrayList<DataContainer> data) {
        double[] result = null;

        if (data != null) {
            int n = data.size();
            result = new double[n];
            for (int i = 0; i < n; i++) {
                result[i] = data.get(i).getSum2_out();
            }
        }

        return result;
    }


    private double [] getSum3PlotData(ArrayList<DataContainer> data) {
        double[] result = null;

        if (data != null) {
            int n = data.size();
            result = new double[n];
            for (int i = 0; i < n; i++) {
                result[i] = data.get(i).getSum3_out();
            }
        }

        return result;
    }
}
