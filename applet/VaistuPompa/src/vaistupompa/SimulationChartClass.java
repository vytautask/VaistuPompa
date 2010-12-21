/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vaistupompa;

import java.util.ArrayList;
import org.math.plot.Plot2DPanel;
import org.math.plot.Plot3DPanel;
import org.math.plot.PlotPanel;

/**
 *
 * @author ssharunas
 */
public class SimulationChartClass {

    public PlotPanel CreateAdvacedChart(ArrayList<DataContainer> pka, ArrayList<DataContainer> ipka) {
        Plot2DPanel plotpanel = new Plot2DPanel();
        if (pka != null) {
            
            int n = pka.size();
            double[] datas1 = new double[n];

            for (int i = 0; i < n; i++) {
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

            plotpanel.addLinePlot("PKA line plot", datas1);
        }

        return plotpanel;
    }
    //API suggestions are welcome

    public Plot3DPanel CreateSampleChart() {
        // Data definition
        int n = 10;
        double[][] datas1 = new double[n][n];
        double[][] datas2 = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                datas1[i][j] = Math.random();
                datas2[i][j] = Math.random();
            }
        }

        // PlotPanel construction
        Plot3DPanel plotpanel = new Plot3DPanel();
        plotpanel.addLegend("SOUTH");

        // Data plots addition
        plotpanel.addGridPlot("datas1", datas1);
        //plotpanel.addBarPlot("datas2", datas2);

        // include plot in applet
        return (plotpanel);
    }
}
