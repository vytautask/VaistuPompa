/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vaistupompa;

import java.io.Console;
import java.util.ArrayList;
import org.math.plot.Plot3DPanel;

/**
 *
 * @author ssharunas
 */
public class SimulationChartClass {

    public Plot3DPanel CreateAdvacedChart(ArrayList<DataContainer> data) {
        Plot3DPanel plotpanel = new Plot3DPanel();
        if (data != null) {
            
           
            int n = data.size();
            double[][] datas1 = new double[n][n];

            

            for (int i = 0; i < n; i++) {
                System.out.println(data.get(0).getGenerator_out());
                for (int k = 0; k < n; k++) {
                    datas1[i][k] = data.get(i).getSum1_out();
                }
            }
            // PlotPanel construction

            plotpanel.addLegend("SOUTH");

            // Data plots addition
            plotpanel.addGridPlot("datas1", datas1);
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
