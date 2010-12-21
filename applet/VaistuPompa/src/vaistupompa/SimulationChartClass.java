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

    public PlotPanel CreateAdvacedChart(ArrayList<DataContainer> data) {
        Plot2DPanel plotpanel = new Plot2DPanel();
        if (data != null) {
            
           
            int n = data.size();
            //double[][] datas1 = new double[n][n];
            double[] datas1 = new double[n];

            

            for (int i = 0; i < n; i++) {
                datas1[i] = data.get(i).getSum2_out();
                //System.out.println(data.get(0).getGenerator_out());
                //for (int k = 0; k < n; k++) {
                //    datas1[i][k] = data.get(i).getSum1_out();
                //}
            }
            // PlotPanel construction

            plotpanel.addLegend("SOUTH");

            // Data plots addition
            //plotpanel.addGridPlot("datas1", datas1);
            //plotpanel.addStaircasePlot("some name", datas1);
            //plotpanel.addScatterPlot("name", datas1);
            plotpanel.addLinePlot("line plot", datas1);
            //plotpanel.addBarPlot(null, datas1);
            
            //plotpanel.addBarPlot("datas2", datas2);
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
