/*
 * MainForm.java
 *
 * Created on 2010-12-11, 22.19.31
 */

package vaistupompa;

import java.awt.Color;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Vytautas
 */
public class MainForm extends javax.swing.JApplet {

    @Override
    public void init() {
        initComponents();
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

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanelParameters.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        jLabel1.setText("Vidutinis vaisto pareikalavimų skaičius per valandą:");

        jLabel2.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        jLabel2.setText("Vaistų išdavimo laiko limitas (sekundėmis):");

        jLabel3.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        jLabel3.setText("Delta t (sekundėmis):");

        jLabel4.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        jLabel4.setText("<html>[PKA] - kuriam laikui pompa blokuojama po vaistų išskyrimo<br>[iPKA] - per kiek laiko vaistas įšvirkščiamas</html>");

        javax.swing.GroupLayout jPanelParametersLayout = new javax.swing.GroupLayout(jPanelParameters);
        jPanelParameters.setLayout(jPanelParametersLayout);
        jPanelParametersLayout.setHorizontalGroup(
            jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelParametersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelParametersLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelParametersLayout.createSequentialGroup()
                        .addGroup(jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSpinnerLambda, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addComponent(jSpinnerT, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addComponent(jSpinnerDeltaT, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))))
                .addContainerGap())
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
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelParameters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelParameters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141)
                .addComponent(jButton1)
                .addContainerGap())
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
    // End of variables declaration//GEN-END:variables

}
