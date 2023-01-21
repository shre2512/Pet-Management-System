/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.databaseConnection;
import model.sendEmail;
import model.sendSMS;

/**
 *
 * @author shrey
 */
public class petAccessoryJPanel extends javax.swing.JPanel {

    /**
     * Creates new form petFoodJPanel
     */
    int userID;
    sendEmail emailNotification;
    sendSMS smsNotification;
    databaseConnection databaseConnection;
    
    public petAccessoryJPanel(databaseConnection databaseConnection, int userID, sendEmail emailNotification, sendSMS smsNotification) throws Exception {
        initComponents();
        
        this.databaseConnection = databaseConnection;
        this.userID = userID;
        this.emailNotification = emailNotification;
        this.smsNotification = smsNotification;
        
        BufferedImage image1 = ImageIO.read(this.getClass().getResource("accessories_chuckit.jpeg"));
        Image resultImage1 = image1.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        lblAccessoriesChuckit.setIcon(new ImageIcon(resultImage1));
        
        BufferedImage image2 = ImageIO.read(this.getClass().getResource("accessories_collar_necklace.jpeg"));
        Image resultImage2 = image2.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        lblAccessoriesCollarNecklace.setIcon(new ImageIcon(resultImage2));
        
        BufferedImage image3 = ImageIO.read(this.getClass().getResource("accessories_latex_toys.jpeg"));
        Image resultImage3 = image3.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        lblAccessoriesLatexToys.setIcon(new ImageIcon(resultImage3));
        
        BufferedImage image4 = ImageIO.read(this.getClass().getResource("accessories_nylabone.jpeg"));
        Image resultImage4 = image4.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        lblAccessoriesNylabone.setIcon(new ImageIcon(resultImage4));
        
        txtItemPriceChuckit.setEditable(false);
        txtItemPriceLatexToys.setEditable(false);
        txtItemPriceCollarNecklace.setEditable(false);
        txtItemPriceNylabone.setEditable(false);
        
        txtAvailableQtyChuckit.setEditable(false);
        txtAvailableQtyNylabone.setEditable(false);
        txtAvailableQtyLatexToys.setEditable(false);
        txtAvailableQtyCollarNecklace.setEditable(false);
        
        populateFields();
      
    }
    
    private void populateFields()
    {
        try {
            ResultSet result = databaseConnection.executeSelect("SELECT accessory_price, available_quantity FROM petaccessories");
            int count = 0;
            
            while(result.next())
            {
                int productPrice = result.getInt("accessory_price");
                int availableQuantity = result.getInt("available_quantity");
                
                switch (count) {
                    case 0 -> {
                        txtItemPriceChuckit.setText(String.valueOf(productPrice));
                        txtAvailableQtyChuckit.setText(String.valueOf(availableQuantity));
                        for(int i = 0; i < availableQuantity; i++)
                        {
                            qtyToBuyChuckit.addItem(Integer.toString(i)); 
                        }                        
                    }
                    case 1 -> {
                        txtItemPriceLatexToys.setText(String.valueOf(productPrice));
                        txtAvailableQtyLatexToys.setText(String.valueOf(availableQuantity));
                        for(int i = 0; i < availableQuantity; i++)
                        {
                            qtyToBuyLatexToys.addItem(Integer.toString(i)); 
                        }
                    }
                    case 2 -> {
                        txtItemPriceNylabone.setText(String.valueOf(productPrice));
                        txtAvailableQtyNylabone.setText(String.valueOf(availableQuantity));
                        for(int i = 0; i < availableQuantity; i++)
                        {
                            qtyToBuyNylabone.addItem(Integer.toString(i)); 
                        }
                    }
                    case 3 -> {
                        txtItemPriceCollarNecklace.setText(String.valueOf(productPrice));
                        txtAvailableQtyCollarNecklace.setText(String.valueOf(availableQuantity));    
                        for(int i = 0; i < availableQuantity; i++)
                        {
                            qtyToBuyCollarNecklace.addItem(Integer.toString(i)); 
                        }
                    }
                }
                count++;
            }
            
         } catch (Exception ex) {
            Logger.getLogger(petFoodAdminUpdatePrice.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAccessoriesChuckit = new javax.swing.JLabel();
        lblAccessoriesNylabone = new javax.swing.JLabel();
        lblAccessoriesLatexToys = new javax.swing.JLabel();
        lblAccessoriesCollarNecklace = new javax.swing.JLabel();
        lblPriceCollarNecklace = new javax.swing.JLabel();
        lblNameCollarNecklace = new javax.swing.JLabel();
        lblQtyCollarNecklace = new javax.swing.JLabel();
        lblQtyToBuyCollarNecklace = new javax.swing.JLabel();
        txtAvailableQtyCollarNecklace = new javax.swing.JTextField();
        txtItemPriceCollarNecklace = new javax.swing.JTextField();
        txtAccessoriesCollarNecklace = new javax.swing.JLabel();
        qtyToBuyCollarNecklace = new javax.swing.JComboBox<>();
        lblNameNylabone = new javax.swing.JLabel();
        lblPriceNylabone = new javax.swing.JLabel();
        lblAvailableQtyNylabone = new javax.swing.JLabel();
        lblQtyToBuyNylabone = new javax.swing.JLabel();
        txtAccessoriesNylabone = new javax.swing.JLabel();
        txtItemPriceNylabone = new javax.swing.JTextField();
        txtAvailableQtyNylabone = new javax.swing.JTextField();
        qtyToBuyNylabone = new javax.swing.JComboBox<>();
        lblNameChuckit = new javax.swing.JLabel();
        lblPriceChuckit = new javax.swing.JLabel();
        lblAvailableQtyChuckit = new javax.swing.JLabel();
        lblQtyToBuyChuckit = new javax.swing.JLabel();
        txtAccessoriesChuckit = new javax.swing.JLabel();
        txtItemPriceChuckit = new javax.swing.JTextField();
        txtAvailableQtyChuckit = new javax.swing.JTextField();
        qtyToBuyChuckit = new javax.swing.JComboBox<>();
        lblNameLatexToys = new javax.swing.JLabel();
        lblPriceLatexToys = new javax.swing.JLabel();
        lblAvailableQtyLatexToys = new javax.swing.JLabel();
        lblQtyToBuyLatexToys = new javax.swing.JLabel();
        txtAccessoriesLatexToys = new javax.swing.JLabel();
        txtItemPriceLatexToys = new javax.swing.JTextField();
        txtAvailableQtyLatexToys = new javax.swing.JTextField();
        qtyToBuyLatexToys = new javax.swing.JComboBox<>();
        btnPurchase = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 255, 255));

        lblPriceCollarNecklace.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPriceCollarNecklace.setText("Price :                 ");

        lblNameCollarNecklace.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNameCollarNecklace.setText("Name :               ");

        lblQtyCollarNecklace.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblQtyCollarNecklace.setText("Available Qty :      ");

        lblQtyToBuyCollarNecklace.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblQtyToBuyCollarNecklace.setText("Qty to Buy :");

        txtAvailableQtyCollarNecklace.setPreferredSize(new java.awt.Dimension(71, 30));
        txtAvailableQtyCollarNecklace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAvailableQtyCollarNecklaceActionPerformed(evt);
            }
        });

        txtItemPriceCollarNecklace.setPreferredSize(new java.awt.Dimension(71, 30));
        txtItemPriceCollarNecklace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemPriceCollarNecklaceActionPerformed(evt);
            }
        });

        txtAccessoriesCollarNecklace.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtAccessoriesCollarNecklace.setText("Collar Necklace");

        lblNameNylabone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNameNylabone.setText("Name :               ");

        lblPriceNylabone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPriceNylabone.setText("Price :                 ");

        lblAvailableQtyNylabone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblAvailableQtyNylabone.setText("Available Qty :      ");

        lblQtyToBuyNylabone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblQtyToBuyNylabone.setText("Qty to Buy :");

        txtAccessoriesNylabone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtAccessoriesNylabone.setText("     Nylabone");

        txtItemPriceNylabone.setPreferredSize(new java.awt.Dimension(71, 30));
        txtItemPriceNylabone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemPriceNylaboneActionPerformed(evt);
            }
        });

        txtAvailableQtyNylabone.setPreferredSize(new java.awt.Dimension(71, 30));
        txtAvailableQtyNylabone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAvailableQtyNylaboneActionPerformed(evt);
            }
        });

        lblNameChuckit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNameChuckit.setText("Name :               ");

        lblPriceChuckit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPriceChuckit.setText("Price :                 ");

        lblAvailableQtyChuckit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblAvailableQtyChuckit.setText("Available Qty :      ");

        lblQtyToBuyChuckit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblQtyToBuyChuckit.setText("Qty to Buy :");

        txtAccessoriesChuckit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtAccessoriesChuckit.setText("       Chuckit");

        txtItemPriceChuckit.setPreferredSize(new java.awt.Dimension(71, 30));
        txtItemPriceChuckit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemPriceChuckitActionPerformed(evt);
            }
        });

        txtAvailableQtyChuckit.setPreferredSize(new java.awt.Dimension(71, 30));
        txtAvailableQtyChuckit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAvailableQtyChuckitActionPerformed(evt);
            }
        });

        lblNameLatexToys.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNameLatexToys.setText("Name :               ");

        lblPriceLatexToys.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPriceLatexToys.setText("Price :                 ");

        lblAvailableQtyLatexToys.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblAvailableQtyLatexToys.setText("Available Qty :      ");

        lblQtyToBuyLatexToys.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblQtyToBuyLatexToys.setText("Qty to Buy :");

        txtAccessoriesLatexToys.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtAccessoriesLatexToys.setText("    Latex Toys");

        txtItemPriceLatexToys.setPreferredSize(new java.awt.Dimension(71, 30));
        txtItemPriceLatexToys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemPriceLatexToysActionPerformed(evt);
            }
        });

        txtAvailableQtyLatexToys.setPreferredSize(new java.awt.Dimension(71, 30));
        txtAvailableQtyLatexToys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAvailableQtyLatexToysActionPerformed(evt);
            }
        });

        btnPurchase.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnPurchase.setForeground(new java.awt.Color(255, 0, 0));
        btnPurchase.setText("Purchase");
        btnPurchase.setPreferredSize(new java.awt.Dimension(76, 35));
        btnPurchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurchaseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAccessoriesCollarNecklace, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblPriceCollarNecklace, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblQtyToBuyCollarNecklace, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblQtyCollarNecklace, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNameCollarNecklace, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtAvailableQtyCollarNecklace, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtItemPriceCollarNecklace, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAccessoriesCollarNecklace, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(qtyToBuyCollarNecklace, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAccessoriesNylabone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblPriceNylabone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblQtyToBuyNylabone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAvailableQtyNylabone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNameNylabone, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtAccessoriesNylabone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(txtAvailableQtyNylabone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtItemPriceNylabone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(qtyToBuyNylabone, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(39, 39, 39)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAccessoriesLatexToys, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblPriceLatexToys, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblQtyToBuyLatexToys, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAvailableQtyLatexToys, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNameLatexToys, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtAvailableQtyLatexToys, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtItemPriceLatexToys, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAccessoriesLatexToys, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(qtyToBuyLatexToys, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAccessoriesChuckit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblPriceChuckit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblQtyToBuyChuckit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAvailableQtyChuckit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNameChuckit, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAccessoriesChuckit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtItemPriceChuckit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAvailableQtyChuckit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(qtyToBuyChuckit, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(86, 86, 86))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPurchase, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(357, 357, 357))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNameChuckit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblAvailableQtyChuckit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAvailableQtyChuckit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblQtyToBuyChuckit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtAccessoriesChuckit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtItemPriceChuckit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPriceChuckit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addComponent(qtyToBuyChuckit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblAccessoriesChuckit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNameLatexToys, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblAvailableQtyLatexToys, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAvailableQtyLatexToys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblQtyToBuyLatexToys, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtAccessoriesLatexToys, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtItemPriceLatexToys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPriceLatexToys, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addComponent(qtyToBuyLatexToys, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblAccessoriesLatexToys, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAccessoriesCollarNecklace, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNameCollarNecklace, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblQtyCollarNecklace, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAvailableQtyCollarNecklace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblQtyToBuyCollarNecklace, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtAccessoriesCollarNecklace, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtItemPriceCollarNecklace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPriceCollarNecklace, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addComponent(qtyToBuyCollarNecklace, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAccessoriesNylabone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNameNylabone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblAvailableQtyNylabone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAvailableQtyNylabone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblQtyToBuyNylabone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtAccessoriesNylabone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtItemPriceNylabone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPriceNylabone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addComponent(qtyToBuyNylabone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(btnPurchase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtAvailableQtyCollarNecklaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAvailableQtyCollarNecklaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAvailableQtyCollarNecklaceActionPerformed

    private void txtItemPriceCollarNecklaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemPriceCollarNecklaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemPriceCollarNecklaceActionPerformed

    private void txtItemPriceNylaboneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemPriceNylaboneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemPriceNylaboneActionPerformed

    private void txtAvailableQtyNylaboneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAvailableQtyNylaboneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAvailableQtyNylaboneActionPerformed

    private void txtItemPriceChuckitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemPriceChuckitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemPriceChuckitActionPerformed

    private void txtAvailableQtyChuckitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAvailableQtyChuckitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAvailableQtyChuckitActionPerformed

    private void txtItemPriceLatexToysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemPriceLatexToysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemPriceLatexToysActionPerformed

    private void txtAvailableQtyLatexToysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAvailableQtyLatexToysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAvailableQtyLatexToysActionPerformed

    private void btnPurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaseActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Order Placed!");
        
        int LatexToysQty = Integer.parseInt(qtyToBuyLatexToys.getSelectedItem().toString());
        int ChuckitQty = Integer.parseInt(qtyToBuyChuckit.getSelectedItem().toString());
        int NylaboneQty = Integer.parseInt(qtyToBuyNylabone.getSelectedItem().toString());
        int CollarNecklaceQty = Integer.parseInt(qtyToBuyCollarNecklace.getSelectedItem().toString());
        
        int LatexToysPrice = Integer.parseInt(txtItemPriceLatexToys.getText());
        int ChuckitPrice = Integer.parseInt(txtItemPriceChuckit.getText());
        int NylabonePrice = Integer.parseInt(txtItemPriceNylabone.getText());
        int CollarNecklacePrice = Integer.parseInt(txtItemPriceCollarNecklace.getText());
        
        int orderTotal = (LatexToysQty*LatexToysPrice) + (ChuckitQty * ChuckitPrice) + (NylaboneQty * NylabonePrice) + (CollarNecklaceQty * CollarNecklacePrice);
       
        try {

            databaseConnection.executePetAccessoryUpdate("UPDATE petaccessories SET available_quantity = ? WHERE accessory_name = ?", Integer.parseInt(txtAvailableQtyLatexToys.getText()) - LatexToysQty, "Latex Toys");
            databaseConnection.executePetAccessoryUpdate("UPDATE petaccessories SET available_quantity = ? WHERE accessory_name = ?", Integer.parseInt(txtAvailableQtyChuckit.getText()) - ChuckitQty, "Chuckit");
            databaseConnection.executePetAccessoryUpdate("UPDATE petaccessories SET available_quantity = ? WHERE accessory_name = ?", Integer.parseInt(txtAvailableQtyNylabone.getText()) - NylaboneQty, "Nylabone");
            databaseConnection.executePetAccessoryUpdate("UPDATE petaccessories SET available_quantity = ? WHERE accessory_name = ?", Integer.parseInt(txtAvailableQtyCollarNecklace.getText()) - CollarNecklaceQty, "Collar Necklace");
            
        } catch (Exception ex) {
            Logger.getLogger(petAccessoryJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        populateFields();
        
        try {
            databaseConnection.insertOrderItemA(userID, LatexToysQty*LatexToysPrice, ChuckitQty*ChuckitPrice, NylaboneQty*NylabonePrice, CollarNecklaceQty*CollarNecklacePrice);
        } catch (Exception ex) {
            Logger.getLogger(petAccessoryJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String emailID = getEmailID(userID);
        if(emailID != null)
        {
            try {
                emailNotification.sendEmail("Order Placed!", "Thank you for shopping with us! Your order total: $" + orderTotal, emailID);
            } catch (Exception ex) {
                Logger.getLogger(petAccessoryJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        String phoneNumber = getPhoneNumber(userID);
        if(phoneNumber != null)
        {
            try {
                smsNotification.sendSMS("+1" + phoneNumber, "Thank you for shopping with us! Your order total: $" + orderTotal);
            } catch (Exception ex) {
                Logger.getLogger(petAccessoryJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnPurchaseActionPerformed

    private String getEmailID(int userID)
    {
        try {
            ResultSet result = databaseConnection.executeSelect("SELECT * FROM usertable");
            
            while(result.next()){
                
                if(result.getInt("id") == userID)
                {
                    return result.getString("email_id");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(petAccessoryJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private String getPhoneNumber(int userID)
    {
        try {
            ResultSet result = databaseConnection.executeSelect("SELECT * FROM usertable");
            while(result.next()){
                
                if(result.getInt("id") == userID)
                {
                    return result.getString("phone_number");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(petAccessoryJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPurchase;
    private javax.swing.JLabel lblAccessoriesChuckit;
    private javax.swing.JLabel lblAccessoriesCollarNecklace;
    private javax.swing.JLabel lblAccessoriesLatexToys;
    private javax.swing.JLabel lblAccessoriesNylabone;
    private javax.swing.JLabel lblAvailableQtyChuckit;
    private javax.swing.JLabel lblAvailableQtyLatexToys;
    private javax.swing.JLabel lblAvailableQtyNylabone;
    private javax.swing.JLabel lblNameChuckit;
    private javax.swing.JLabel lblNameCollarNecklace;
    private javax.swing.JLabel lblNameLatexToys;
    private javax.swing.JLabel lblNameNylabone;
    private javax.swing.JLabel lblPriceChuckit;
    private javax.swing.JLabel lblPriceCollarNecklace;
    private javax.swing.JLabel lblPriceLatexToys;
    private javax.swing.JLabel lblPriceNylabone;
    private javax.swing.JLabel lblQtyCollarNecklace;
    private javax.swing.JLabel lblQtyToBuyChuckit;
    private javax.swing.JLabel lblQtyToBuyCollarNecklace;
    private javax.swing.JLabel lblQtyToBuyLatexToys;
    private javax.swing.JLabel lblQtyToBuyNylabone;
    private javax.swing.JComboBox<String> qtyToBuyChuckit;
    private javax.swing.JComboBox<String> qtyToBuyCollarNecklace;
    private javax.swing.JComboBox<String> qtyToBuyLatexToys;
    private javax.swing.JComboBox<String> qtyToBuyNylabone;
    private javax.swing.JLabel txtAccessoriesChuckit;
    private javax.swing.JLabel txtAccessoriesCollarNecklace;
    private javax.swing.JLabel txtAccessoriesLatexToys;
    private javax.swing.JLabel txtAccessoriesNylabone;
    private javax.swing.JTextField txtAvailableQtyChuckit;
    private javax.swing.JTextField txtAvailableQtyCollarNecklace;
    private javax.swing.JTextField txtAvailableQtyLatexToys;
    private javax.swing.JTextField txtAvailableQtyNylabone;
    private javax.swing.JTextField txtItemPriceChuckit;
    private javax.swing.JTextField txtItemPriceCollarNecklace;
    private javax.swing.JTextField txtItemPriceLatexToys;
    private javax.swing.JTextField txtItemPriceNylabone;
    // End of variables declaration//GEN-END:variables
}
