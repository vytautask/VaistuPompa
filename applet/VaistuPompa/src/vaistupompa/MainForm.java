/*
 * MainForm.java
 *
 * Created on 2010-12-11, 22.19.31
 */

package vaistupompa;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import org.jfree.chart.ChartPanel;

import org.jfree.chart.JFreeChart;

/**
 *
 * @author Vytautas
 */
public class MainForm extends javax.swing.JApplet {
    // <editor-fold defaultstate="collapsed" desc="Private Members">
        private SimulationChartClass simuChart;
    //</editor-fold>


    @Override
    public void init() {
        initComponents();

        // <editor-fold desc="Set default values">
        this.getContentPane().setBackground(Color.white);

        SpinnerNumberModel model = new SpinnerNumberModel();
        model.setMinimum(0);
        model.setMaximum(18000);
        model.setValue(1);
        model.setStepSize(1);

        SpinnerNumberModel model2 = new SpinnerNumberModel();
        model2.setMinimum(0);
        model2.setMaximum(18000);
        model2.setValue(1);
        model2.setStepSize(1);

        SpinnerNumberModel model3 = new SpinnerNumberModel();
        model3.setMinimum(0);
        model3.setMaximum(18000);
        model3.setValue(1);
        model3.setStepSize(1);

        this.jSpinnerT.setModel(model);
        this.jSpinnerDeltaT.setModel(model2);
        this.jSpinnerLambda.setModel(model3);
//</editor-fold>

        simuChart = new SimulationChartClass();
        ChartPanel panel = new ChartPanel(simuChart.CreateSampleChart());
        jTabbedPane1.addTab("Grafikas", panel);
        jTabbedPane1.addTab("Ten kur paspaust ir pažiūrėt galima", new JPanel());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanelParameters = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSpinnerDeltaT = new javax.swing.JSpinner();
        jSpinnerT = new javax.swing.JSpinner();
        jSpinnerLambda = new javax.swing.JSpinner();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanelParameters.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12));
        jLabel1.setText("Vidutinis vaisto pareikalavimų skaičius per valandą:");

        jLabel2.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12));
        jLabel2.setText("Vaistų išdavimo laiko limitas (sekundėmis):");

        jLabel3.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12));
        jLabel3.setText("Delta t (sekundėmis):");

        jLabel4.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12));
        jLabel4.setText("<html>[PKA] - kuriam laikui pompa blokuojama po vaistų išskyrimo<br>[iPKA] - per kiek laiko vaistas įšvirkščiamas</html>");

        javax.swing.GroupLayout jPanelParametersLayout = new javax.swing.GroupLayout(jPanelParameters);
        jPanelParameters.setLayout(jPanelParametersLayout);
        jPanelParametersLayout.setHorizontalGroup(
            jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelParametersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelParametersLayout.createSequentialGroup()
                        .addGroup(jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSpinnerDeltaT)
                            .addComponent(jSpinnerT)
                            .addComponent(jSpinnerLambda, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)))
                    .addGroup(jPanelParametersLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(359, Short.MAX_VALUE))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        );
        jPanelParametersLayout.setVerticalGroup(
            jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelParametersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jSpinnerLambda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jSpinnerT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jSpinnerDeltaT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(328, 328, 328))
                    .addComponent(jPanelParameters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelParameters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelParameters;
    private javax.swing.JSpinner jSpinnerDeltaT;
    private javax.swing.JSpinner jSpinnerLambda;
    private javax.swing.JSpinner jSpinnerT;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

}
