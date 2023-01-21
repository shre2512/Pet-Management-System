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
public class petFoodJPanel extends javax.swing.JPanel {

    /**
     * Creates new form petFoodJPanel
     */
    int userID;
    sendEmail emailNotification;
    sendSMS smsNotification;
    databaseConnection databaseConnection;
    
    public petFoodJPanel(databaseConnection databaseConnection, int userID, sendEmail emailNotification, sendSMS smsNotification) throws Exception {
        initComponents();
        
        this.databaseConnection = databaseConnection;
        this.userID = userID;
        this.emailNotification = emailNotification;
        this.smsNotification = smsNotification;
        
        BufferedImage image1 = ImageIO.read(this.getClass().getResource("food_applaws.jpeg"));
        Image resultImage1 = image1.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        lblFoodApplaws.setIcon(new ImageIcon(resultImage1));
        
        BufferedImage image2 = ImageIO.read(this.getClass().getResource("food_naturals.jpeg"));
        Image resultImage2 = image2.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        lblFoodNaturals.setIcon(new ImageIcon(resultImage2));
        
        BufferedImage image3 = ImageIO.read(this.getClass().getResource("food_pedigree.jpeg"));
        Image resultImage3 = image3.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        lblFoodPedigree.setIcon(new ImageIcon(resultImage3));
        
        BufferedImage image4 = ImageIO.read(this.getClass().getResource("food_tiki_cat.jpeg"));
        Image resultImage4 = image4.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        lblFoodTikiCat.setIcon(new ImageIcon(resultImage4));
        
        txtItemPriceApplaws.setEditable(false);
        txtItemPricePedigree.setEditable(false);
        txtItemPriceTikiCat.setEditable(false);
        txtItemPriceNaturals.setEditable(false);
        
        txtAvailableQtyApplaws.setEditable(false);
        txtAvailableQtyNaturals.setEditable(false);
        txtAvailableQtyPedigree.setEditable(false);
        txtAvailableQtyTikiCat.setEditable(false);
        
        populateFields();
      
    }
    
    private void populateFields()
    {
        try {
            ResultSet result = databaseConnection.executeSelect("SELECT food_price, available_quantity FROM petfood");
            int count = 0;
            
            while(result.next())
            {
                int productPrice = result.getInt("food_price");
                int availableQuantity = result.getInt("available_quantity");
                
                switch (count) {
                    case 0 -> {
                        txtItemPriceApplaws.setText(String.valueOf(productPrice));
                        txtAvailableQtyApplaws.setText(String.valueOf(availableQuantity));
                        for(int i = 0; i < availableQuantity; i++)
                        {
                            qtyToBuyApplaws.addItem(Integer.toString(i)); 
                        }                        
                    }
                    case 1 -> {
                        txtItemPricePedigree.setText(String.valueOf(productPrice));
                        txtAvailableQtyPedigree.setText(String.valueOf(availableQuantity));
                        for(int i = 0; i < availableQuantity; i++)
                        {
                            qtyToBuyPedigree.addItem(Integer.toString(i)); 
                        }
                    }
                    case 2 -> {
                        txtItemPriceNaturals.setText(String.valueOf(productPrice));
                        txtAvailableQtyNaturals.setText(String.valueOf(availableQuantity));
                        for(int i = 0; i < availableQuantity; i++)
                        {
                            qtyToBuyNaturals.addItem(Integer.toString(i)); 
                        }
                    }
                    case 3 -> {
                        txtItemPriceTikiCat.setText(String.valueOf(productPrice));
                        txtAvailableQtyTikiCat.setText(String.valueOf(availableQuantity));    
                        for(int i = 0; i < availableQuantity; i++)
                        {
                            qtyToBuyTikiCat.addItem(Integer.toString(i)); 
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

        lblFoodApplaws = new javax.swing.JLabel();
        lblFoodNaturals = new javax.swing.JLabel();
        lblFoodPedigree = new javax.swing.JLabel();
        lblFoodTikiCat = new javax.swing.JLabel();
        lblPriceTikiCat = new javax.swing.JLabel();
        lblNameTikiCat = new javax.swing.JLabel();
        lblAvailableQtyTikiCat = new javax.swing.JLabel();
        lblQtyToBuyTikiCat = new javax.swing.JLabel();
        txtAvailableQtyTikiCat = new javax.swing.JTextField();
        txtItemPriceTikiCat = new javax.swing.JTextField();
        txtFoodTikiCat = new javax.swing.JLabel();
        qtyToBuyTikiCat = new javax.swing.JComboBox<>();
        lblNameNaturals = new javax.swing.JLabel();
        lblPriceNaturals = new javax.swing.JLabel();
        lblAvailableQtyNaturals = new javax.swing.JLabel();
        lblQtyToBuyNaturals = new javax.swing.JLabel();
        txtFoodNaturals = new javax.swing.JLabel();
        txtItemPriceNaturals = new javax.swing.JTextField();
        txtAvailableQtyNaturals = new javax.swing.JTextField();
        qtyToBuyNaturals = new javax.swing.JComboBox<>();
        lblNameApplaws = new javax.swing.JLabel();
        lblPriceApplaws = new javax.swing.JLabel();
        lblAvailableQtyApplaws = new javax.swing.JLabel();
        lblQtyToBuyApplaws = new javax.swing.JLabel();
        txtFoodApplaws = new javax.swing.JLabel();
        txtItemPriceApplaws = new javax.swing.JTextField();
        txtAvailableQtyApplaws = new javax.swing.JTextField();
        qtyToBuyApplaws = new javax.swing.JComboBox<>();
        lblNamePedigree = new javax.swing.JLabel();
        lblPricePedigree = new javax.swing.JLabel();
        lblAvailableQtyPedigree = new javax.swing.JLabel();
        lblQtyToBuyPedigree = new javax.swing.JLabel();
        txtFoodPedigree = new javax.swing.JLabel();
        txtItemPricePedigree = new javax.swing.JTextField();
        txtAvailableQtyPedigree = new javax.swing.JTextField();
        qtyToBuyPedigree = new javax.swing.JComboBox<>();
        btnPurchase = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 255, 255));

        lblPriceTikiCat.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPriceTikiCat.setText("Price :                 ");

        lblNameTikiCat.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNameTikiCat.setText("Name :               ");

        lblAvailableQtyTikiCat.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblAvailableQtyTikiCat.setText("Available Qty :      ");

        lblQtyToBuyTikiCat.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblQtyToBuyTikiCat.setText("Qty to Buy :");

        txtAvailableQtyTikiCat.setPreferredSize(new java.awt.Dimension(71, 30));
        txtAvailableQtyTikiCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAvailableQtyTikiCatActionPerformed(evt);
            }
        });

        txtItemPriceTikiCat.setPreferredSize(new java.awt.Dimension(71, 30));
        txtItemPriceTikiCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemPriceTikiCatActionPerformed(evt);
            }
        });

        txtFoodTikiCat.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtFoodTikiCat.setText("  Tiki Cat");

        lblNameNaturals.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNameNaturals.setText("Name :               ");

        lblPriceNaturals.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPriceNaturals.setText("Price :                 ");

        lblAvailableQtyNaturals.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblAvailableQtyNaturals.setText("Available Qty :      ");

        lblQtyToBuyNaturals.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblQtyToBuyNaturals.setText("Qty to Buy :");

        txtFoodNaturals.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtFoodNaturals.setText("  Naturals");

        txtItemPriceNaturals.setPreferredSize(new java.awt.Dimension(71, 30));
        txtItemPriceNaturals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemPriceNaturalsActionPerformed(evt);
            }
        });

        txtAvailableQtyNaturals.setPreferredSize(new java.awt.Dimension(71, 30));
        txtAvailableQtyNaturals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAvailableQtyNaturalsActionPerformed(evt);
            }
        });

        lblNameApplaws.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNameApplaws.setText("Name :               ");

        lblPriceApplaws.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPriceApplaws.setText("Price :                 ");

        lblAvailableQtyApplaws.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblAvailableQtyApplaws.setText("Available Qty :      ");

        lblQtyToBuyApplaws.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblQtyToBuyApplaws.setText("Qty to Buy :");

        txtFoodApplaws.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtFoodApplaws.setText("  Applaws");

        txtItemPriceApplaws.setPreferredSize(new java.awt.Dimension(71, 30));
        txtItemPriceApplaws.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemPriceApplawsActionPerformed(evt);
            }
        });

        txtAvailableQtyApplaws.setPreferredSize(new java.awt.Dimension(71, 30));
        txtAvailableQtyApplaws.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAvailableQtyApplawsActionPerformed(evt);
            }
        });

        lblNamePedigree.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNamePedigree.setText("Name :               ");

        lblPricePedigree.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPricePedigree.setText("Price :                 ");

        lblAvailableQtyPedigree.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblAvailableQtyPedigree.setText("Available Qty :      ");

        lblQtyToBuyPedigree.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblQtyToBuyPedigree.setText("Qty to Buy :");

        txtFoodPedigree.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtFoodPedigree.setText("  Pedigree");

        txtItemPricePedigree.setPreferredSize(new java.awt.Dimension(71, 30));
        txtItemPricePedigree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemPricePedigreeActionPerformed(evt);
            }
        });

        txtAvailableQtyPedigree.setPreferredSize(new java.awt.Dimension(71, 30));
        txtAvailableQtyPedigree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAvailableQtyPedigreeActionPerformed(evt);
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
                        .addComponent(lblFoodTikiCat, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblPriceTikiCat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblQtyToBuyTikiCat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAvailableQtyTikiCat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNameTikiCat, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtAvailableQtyTikiCat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtItemPriceTikiCat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFoodTikiCat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(qtyToBuyTikiCat, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                        .addComponent(lblFoodApplaws, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFoodNaturals, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblPriceNaturals, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblQtyToBuyNaturals, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAvailableQtyNaturals, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNameNaturals, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtAvailableQtyNaturals, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtItemPriceNaturals, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFoodNaturals, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(qtyToBuyNaturals, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFoodPedigree, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblPriceApplaws, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblQtyToBuyApplaws, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAvailableQtyApplaws, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNameApplaws, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtAvailableQtyApplaws, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtItemPriceApplaws, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFoodApplaws, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(qtyToBuyApplaws, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblPricePedigree, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblQtyToBuyPedigree, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAvailableQtyPedigree, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNamePedigree, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtAvailableQtyPedigree, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtItemPricePedigree, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFoodPedigree, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(qtyToBuyPedigree, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPurchase, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(357, 357, 357))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNameApplaws, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAvailableQtyApplaws, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAvailableQtyApplaws, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblQtyToBuyApplaws, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFoodApplaws, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtItemPriceApplaws, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPriceApplaws, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addComponent(qtyToBuyApplaws, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblFoodApplaws, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFoodTikiCat, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNameTikiCat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAvailableQtyTikiCat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAvailableQtyTikiCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblQtyToBuyTikiCat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFoodTikiCat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtItemPriceTikiCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPriceTikiCat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addComponent(qtyToBuyTikiCat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFoodNaturals, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNameNaturals, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblAvailableQtyNaturals, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAvailableQtyNaturals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblQtyToBuyNaturals, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFoodNaturals, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtItemPriceNaturals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPriceNaturals, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addComponent(qtyToBuyNaturals, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNamePedigree, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblAvailableQtyPedigree, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAvailableQtyPedigree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblQtyToBuyPedigree, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFoodPedigree, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtItemPricePedigree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPricePedigree, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addComponent(qtyToBuyPedigree, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFoodPedigree, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(btnPurchase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtAvailableQtyTikiCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAvailableQtyTikiCatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAvailableQtyTikiCatActionPerformed

    private void txtItemPriceTikiCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemPriceTikiCatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemPriceTikiCatActionPerformed

    private void txtItemPriceNaturalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemPriceNaturalsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemPriceNaturalsActionPerformed

    private void txtAvailableQtyNaturalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAvailableQtyNaturalsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAvailableQtyNaturalsActionPerformed

    private void txtItemPriceApplawsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemPriceApplawsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemPriceApplawsActionPerformed

    private void txtAvailableQtyApplawsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAvailableQtyApplawsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAvailableQtyApplawsActionPerformed

    private void txtItemPricePedigreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemPricePedigreeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemPricePedigreeActionPerformed

    private void txtAvailableQtyPedigreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAvailableQtyPedigreeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAvailableQtyPedigreeActionPerformed

    private void btnPurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaseActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Order Placed!");
        
        int pedigreeQty = Integer.parseInt(qtyToBuyPedigree.getSelectedItem().toString());
        int applawsQty = Integer.parseInt(qtyToBuyApplaws.getSelectedItem().toString());
        int naturalsQty = Integer.parseInt(qtyToBuyNaturals.getSelectedItem().toString());
        int tikiCatQty = Integer.parseInt(qtyToBuyTikiCat.getSelectedItem().toString());
        
        int pedigreePrice = Integer.parseInt(txtItemPricePedigree.getText());
        int applawsPrice = Integer.parseInt(txtItemPriceApplaws.getText());
        int naturalsPrice = Integer.parseInt(txtItemPriceNaturals.getText());
        int tikiCatPrice = Integer.parseInt(txtItemPriceTikiCat.getText());
        
        int orderTotal = (pedigreeQty*pedigreePrice) + (applawsQty * applawsPrice) + (naturalsQty * naturalsPrice) + (tikiCatQty * tikiCatPrice);
       
        try {

            databaseConnection.executePetFoodUpdate("UPDATE petfood SET available_quantity = ? WHERE food_name = ?", Integer.parseInt(txtAvailableQtyPedigree.getText()) - pedigreeQty, "Pedigree");
            databaseConnection.executePetFoodUpdate("UPDATE petfood SET available_quantity = ? WHERE food_name = ?", Integer.parseInt(txtAvailableQtyApplaws.getText()) - applawsQty, "Applaws");
            databaseConnection.executePetFoodUpdate("UPDATE petfood SET available_quantity = ? WHERE food_name = ?", Integer.parseInt(txtAvailableQtyNaturals.getText()) - naturalsQty, "Naturals");
            databaseConnection.executePetFoodUpdate("UPDATE petfood SET available_quantity = ? WHERE food_name = ?", Integer.parseInt(txtAvailableQtyTikiCat.getText()) - tikiCatQty, "Tiki Cat");
            
        } catch (Exception ex) {
            Logger.getLogger(petFoodJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        populateFields();
        
        try {
            databaseConnection.insertOrderItem(userID, applawsQty*applawsPrice, pedigreeQty*pedigreePrice, naturalsQty*naturalsPrice, tikiCatQty*tikiCatPrice);
        } catch (Exception ex) {
            Logger.getLogger(petFoodJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String emailID = getEmailID(userID);
        if(emailID != null)
        {
            try {
                emailNotification.sendEmail("Order Placed!", "Thank you for shopping with us! Your order total: $" + orderTotal, emailID);
            } catch (Exception ex) {
                Logger.getLogger(petFoodJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        String phoneNumber = getPhoneNumber(userID);
        if(phoneNumber != null)
        {
            try {
                smsNotification.sendSMS("+1" + phoneNumber, "Thank you for shopping with us! Your order total: $" + orderTotal);
            } catch (Exception ex) {
                Logger.getLogger(petFoodJPanel.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(petFoodJPanel.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(petFoodJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPurchase;
    private javax.swing.JLabel lblAvailableQtyApplaws;
    private javax.swing.JLabel lblAvailableQtyNaturals;
    private javax.swing.JLabel lblAvailableQtyPedigree;
    private javax.swing.JLabel lblAvailableQtyTikiCat;
    private javax.swing.JLabel lblFoodApplaws;
    private javax.swing.JLabel lblFoodNaturals;
    private javax.swing.JLabel lblFoodPedigree;
    private javax.swing.JLabel lblFoodTikiCat;
    private javax.swing.JLabel lblNameApplaws;
    private javax.swing.JLabel lblNameNaturals;
    private javax.swing.JLabel lblNamePedigree;
    private javax.swing.JLabel lblNameTikiCat;
    private javax.swing.JLabel lblPriceApplaws;
    private javax.swing.JLabel lblPriceNaturals;
    private javax.swing.JLabel lblPricePedigree;
    private javax.swing.JLabel lblPriceTikiCat;
    private javax.swing.JLabel lblQtyToBuyApplaws;
    private javax.swing.JLabel lblQtyToBuyNaturals;
    private javax.swing.JLabel lblQtyToBuyPedigree;
    private javax.swing.JLabel lblQtyToBuyTikiCat;
    private javax.swing.JComboBox<String> qtyToBuyApplaws;
    private javax.swing.JComboBox<String> qtyToBuyNaturals;
    private javax.swing.JComboBox<String> qtyToBuyPedigree;
    private javax.swing.JComboBox<String> qtyToBuyTikiCat;
    private javax.swing.JTextField txtAvailableQtyApplaws;
    private javax.swing.JTextField txtAvailableQtyNaturals;
    private javax.swing.JTextField txtAvailableQtyPedigree;
    private javax.swing.JTextField txtAvailableQtyTikiCat;
    private javax.swing.JLabel txtFoodApplaws;
    private javax.swing.JLabel txtFoodNaturals;
    private javax.swing.JLabel txtFoodPedigree;
    private javax.swing.JLabel txtFoodTikiCat;
    private javax.swing.JTextField txtItemPriceApplaws;
    private javax.swing.JTextField txtItemPriceNaturals;
    private javax.swing.JTextField txtItemPricePedigree;
    private javax.swing.JTextField txtItemPriceTikiCat;
    // End of variables declaration//GEN-END:variables
}
