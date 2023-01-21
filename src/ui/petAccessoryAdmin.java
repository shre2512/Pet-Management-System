/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import model.databaseConnection;

/**
 *
 * @author shrey
 */
public class petAccessoryAdmin extends javax.swing.JPanel {

    /**
     * Creates new form petFoodAdmin
     */
    databaseConnection databaseConnection;
    
    public petAccessoryAdmin(databaseConnection databaseConnection) {
        initComponents();
        this.databaseConnection = databaseConnection;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        petAccessoryAdminSplitPane = new javax.swing.JSplitPane();
        petAccessoryAdminControlArea = new javax.swing.JPanel();
        btnUpdatePrice = new javax.swing.JButton();
        btnOrderProduct = new javax.swing.JButton();
        petAccessoryAdminWorkArea = new javax.swing.JPanel();

        petAccessoryAdminSplitPane.setDividerLocation(120);

        petAccessoryAdminControlArea.setBackground(new java.awt.Color(102, 255, 102));

        btnUpdatePrice.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnUpdatePrice.setForeground(new java.awt.Color(255, 0, 0));
        btnUpdatePrice.setText("Update Price");
        btnUpdatePrice.setPreferredSize(new java.awt.Dimension(76, 30));
        btnUpdatePrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePriceActionPerformed(evt);
            }
        });

        btnOrderProduct.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnOrderProduct.setForeground(new java.awt.Color(255, 0, 0));
        btnOrderProduct.setText("Order Product");
        btnOrderProduct.setPreferredSize(new java.awt.Dimension(76, 30));
        btnOrderProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout petAccessoryAdminControlAreaLayout = new javax.swing.GroupLayout(petAccessoryAdminControlArea);
        petAccessoryAdminControlArea.setLayout(petAccessoryAdminControlAreaLayout);
        petAccessoryAdminControlAreaLayout.setHorizontalGroup(
            petAccessoryAdminControlAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(petAccessoryAdminControlAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnUpdatePrice, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(petAccessoryAdminControlAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(petAccessoryAdminControlAreaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnOrderProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        petAccessoryAdminControlAreaLayout.setVerticalGroup(
            petAccessoryAdminControlAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(petAccessoryAdminControlAreaLayout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(btnUpdatePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(391, Short.MAX_VALUE))
            .addGroup(petAccessoryAdminControlAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, petAccessoryAdminControlAreaLayout.createSequentialGroup()
                    .addContainerGap(305, Short.MAX_VALUE)
                    .addComponent(btnOrderProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(289, 289, 289)))
        );

        petAccessoryAdminSplitPane.setLeftComponent(petAccessoryAdminControlArea);

        petAccessoryAdminWorkArea.setBackground(new java.awt.Color(0, 255, 255));

        javax.swing.GroupLayout petAccessoryAdminWorkAreaLayout = new javax.swing.GroupLayout(petAccessoryAdminWorkArea);
        petAccessoryAdminWorkArea.setLayout(petAccessoryAdminWorkAreaLayout);
        petAccessoryAdminWorkAreaLayout.setHorizontalGroup(
            petAccessoryAdminWorkAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 851, Short.MAX_VALUE)
        );
        petAccessoryAdminWorkAreaLayout.setVerticalGroup(
            petAccessoryAdminWorkAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 624, Short.MAX_VALUE)
        );

        petAccessoryAdminSplitPane.setRightComponent(petAccessoryAdminWorkArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(petAccessoryAdminSplitPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(petAccessoryAdminSplitPane)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdatePriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePriceActionPerformed
        // TODO add your handling code here:
        petAccessoryAdminUpdatePrice petAccessoryUpdatePrice = new petAccessoryAdminUpdatePrice(databaseConnection);
        petAccessoryAdminSplitPane.setRightComponent(petAccessoryUpdatePrice);
    }//GEN-LAST:event_btnUpdatePriceActionPerformed

    private void btnOrderProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderProductActionPerformed
        // TODO add your handling code here:
        petAccessoryAdminOrderProductQuantity petAccessoryAdminOrderProduct = new petAccessoryAdminOrderProductQuantity(databaseConnection);
        petAccessoryAdminSplitPane.setRightComponent(petAccessoryAdminOrderProduct);
    }//GEN-LAST:event_btnOrderProductActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOrderProduct;
    private javax.swing.JButton btnUpdatePrice;
    private javax.swing.JPanel petAccessoryAdminControlArea;
    private javax.swing.JSplitPane petAccessoryAdminSplitPane;
    private javax.swing.JPanel petAccessoryAdminWorkArea;
    // End of variables declaration//GEN-END:variables
}