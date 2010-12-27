package vaistupompa;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.math.plot.Plot2DPanel;
import org.math.plot.Plot3DPanel;
import org.math.plot.PlotPanel;

/**
 *
 * @author ssharunas
 */
public class SimulationChartClass {

    private boolean threeD = false;
    private JPanel mainPanel = null;
    private JComboBox combo = new JComboBox();
    private PlotPanel plotPanel = new Plot2DPanel();
    private ArrayList<DataContainer> pka = null, ipka = null;

    private void createConents() {
        combo.addItem("Sumatorius 1");
        combo.addItem("Sumatorius 2");
        combo.addItem("Sumatorius 3");


        combo.addItem("Integratorius 1");
        combo.addItem("Integratorius 2");
        combo.addItem("Integratorius 3");
        combo.setSelectedIndex(0);

        combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                if(evt.getStateChange() == ItemEvent.SELECTED){
                    RedrawChart();
                }
            }
        });

        BorderLayout layout = new BorderLayout();
        layout.addLayoutComponent(combo, BorderLayout.NORTH);
        
        mainPanel = new JPanel(layout);
        mainPanel.add(combo);
        CreatePlotPanel();
    }

    private void RedrawChart(){
        CreateAdvacedChart(pka, ipka);
    }

    private void CreatePlotPanel(){

        if(plotPanel != null){
            mainPanel.remove(plotPanel);
            mainPanel.getLayout().removeLayoutComponent(plotPanel);
        }

        if(threeD)
            plotPanel = new Plot3DPanel();
        else
            plotPanel = new Plot2DPanel();

        ((BorderLayout)mainPanel.getLayout()).addLayoutComponent(plotPanel, BorderLayout.CENTER);
        mainPanel.add(plotPanel);
        plotPanel.addLegend("EAST");
    }

    public JPanel getMainPanel() {
        if (mainPanel == null) {
            createConents();
        }

        return mainPanel;
    }

    public void CreateAdvacedChart(ArrayList<DataContainer> pka, ArrayList<DataContainer> ipka) {
        this.pka = pka;
        this.ipka = ipka;
        try {
            plotPanel.removeAllPlots();

            if (threeD) {
                Plot3DPanel plot = (Plot3DPanel)plotPanel;

                if (pka != null) {
                    plot.addLinePlot("PKA grafikas", get3DPlotData(pka, 0));
                }

                if (ipka != null) {
                    plot.addLinePlot("iPKA grafikas", get3DPlotData(ipka, 5));
                }

            } else {
                Plot2DPanel plot = (Plot2DPanel)plotPanel;
                if (pka != null) {
                    plot.addLinePlot("PKA grafikas", getPlotData(pka));
                }

                if (ipka != null) {
                    plot.addLinePlot("iPKA grafikas", getPlotData(ipka));
                }
            }

            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e + "\r\n" + e.getMessage());
        }
    }
    
    private double[][] get3DPlotData(ArrayList<DataContainer> data, int shift) {

        int n = data.size();
        int m = 50;

        double[][] result = new double[m][];
        double[] empty = new double[n];

        for(int i = 0; i < m; i++)
            result[i] = empty;

        result[shift]= getPlotData(data);

        return result;
    }

    private double[] getPlotData(ArrayList<DataContainer> data) {
        switch (combo.getSelectedIndex()) {
            case 0:
                return getSum1PlotData(data);
            case 1:
                return getSum2PlotData(data);
            case 2:
                return getSum3PlotData(data);

            case 3:
                return getInteg1PlotData(data);
            case 4:
                return getInteg2PlotData(data);
            case 5:
                return getInteg3PlotData(data);
        }

        return getSum1PlotData(data);
    }

    private double[] getSum1PlotData(ArrayList<DataContainer> data) {
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

    private double[] getSum2PlotData(ArrayList<DataContainer> data) {
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

    private double[] getSum3PlotData(ArrayList<DataContainer> data) {
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

    private double[] getInteg1PlotData(ArrayList<DataContainer> data) {
        double[] result = null;

        if (data != null) {
            int n = data.size();
            result = new double[n];
            for (int i = 0; i < n; i++) {
                result[i] = data.get(i).getInteg1_out();
            }
        }

        return result;
    }

    private double[] getInteg2PlotData(ArrayList<DataContainer> data) {
        double[] result = null;

        if (data != null) {
            int n = data.size();
            result = new double[n];
            for (int i = 0; i < n; i++) {
                result[i] = data.get(i).getInteg2_out();
            }
        }

        return result;
    }

    private double[] getInteg3PlotData(ArrayList<DataContainer> data) {
        double[] result = null;

        if (data != null) {
            int n = data.size();
            result = new double[n];
            for (int i = 0; i < n; i++) {
                result[i] = data.get(i).getInteg3_out();
            }
        }

        return result;
    }
}
