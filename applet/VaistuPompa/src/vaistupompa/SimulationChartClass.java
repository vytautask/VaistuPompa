/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vaistupompa;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author ssharunas
 */
public class SimulationChartClass {

    //API suggestions are welcome

    public JFreeChart CreateSampleChart() {

        XYSeries series = new XYSeries("A");
        series.add(1, 1);
        series.add(2, 2);
        series.add(3, 1);
        series.add(4, 9);
        series.add(5, 10);
        series.add(6, 60);

        XYSeries series2 = new XYSeries("B");
        series2.add(1, 1 / 2);
        series2.add(2, 2 / 2);
        series2.add(3, 1 / 2);
        series2.add(4, 9 / 2);
        series2.add(5, 10 / 2);
        series2.add(6, 60 / 2);

// Add the series to your data set
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        dataset.addSeries(series2);
// Generate the graph
        JFreeChart chart = ChartFactory.createXYLineChart("XY Chart", // Title
                "x-axis", // x-axis Label
                "y-axis", // y-axis Label
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Plot Orientation
                true, // Show Legend
                true, // Use tooltips
                false // Configure chart to generate URLs?
                );
        chart.setAntiAlias(true);

        return chart;
    }
}
