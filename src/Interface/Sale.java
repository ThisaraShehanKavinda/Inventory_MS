/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Interface;

import inventoryms.DBConnection;
import java.awt.Image;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.sql.*;
import java.time.LocalDate;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class Sale extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddItem
     */
    
    PreparedStatement pst = null;
 
    Connection con;
    


    
    String sid;
    String iid;
    int uprice;
    int noofitems;
    int totalPrice;
    int discount;
    int payable;
    int cash;
    int balance;
    String date;
    
 
   
    
    
    
    public Sale() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        con = DBConnection.getConnection();
        BillHeader();
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        autoID();
    }
    
    
    
     public void updateItemCount(){
        String itemID = txtItemID.getText();
        try{
            con = DBConnection.getConnection();
            String sql = "update stock set no_of_items=no_of_items-1 where item_id = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, itemID);
            
            int rowCount  =  pst.executeUpdate();
           
           if(rowCount>0){
               JOptionPane.showMessageDialog(this, "Item count Updated");
               
           }else{
              JOptionPane.showMessageDialog(this, "Cannot Update Item Count");
               
           }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
    
    
    private void lorddata(){
        
        sid = lblsale.getText();
        iid = txtItemID.getText();
        uprice = Integer.parseInt(txtUnitprice.getText());
        noofitems = Integer.parseInt(txtnoofitems.getText());
        totalPrice = Integer.parseInt(txtTotalPrice.getText());
        discount = Integer.parseInt(txtDiscount.getText());
        payable = Integer.parseInt(txtPayable.getText());
        cash = Integer.parseInt(txtCash.getText());
        balance = Integer.parseInt(txtBalance.getText());
        LocalDate ndate = LocalDate.now();
        date = ndate+"";
        
        
    }

    
    
   private void itemLoard() {
    try {
        String sql = "SELECT item_id, item_name, serial_no, sale_price, image FROM stock WHERE item_id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, txtItemID.getText());
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            txtItemID.setText(rs.getString("item_id"));
            txtItemName.setText(rs.getString("item_name"));
            txtSerialNO.setText(rs.getString("serial_no"));
            txtUnitprice.setText(rs.getString("sale_price"));

            byte[] imageData = rs.getBytes("image");
            ImageIcon imageIcon = new ImageIcon(imageData);
            Image image = imageIcon.getImage();
            Image scaledImage = image.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
            lblImage.setIcon(scaledImageIcon);
        } else {
            // Handle case when no item is found
            txtItemID.setText("");
            txtItemName.setText("");
            txtSerialNO.setText("");
            txtUnitprice.setText("");
            lblImage.setIcon(null);
        }

        // Close the resources
        rs.close();
        pst.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e);
    }
}

    private void makebill(){
        txtBill.setText(txtBill.getText()+"Item Name\t"+txtItemName.getText()+"\nNo of Item\t"+txtnoofitems.getText()+"\nUnit Price\t"+txtUnitprice.getText()+"\nTotal Price\t0"+txtTotalPrice.getText()+"\n------------------------------------------\nDiscount\t"+txtDiscount.getText()+"\nPayble\t"+txtPayable.getText()+"\nCash\t"+txtCash.getText()+"\n------------------------------------------\nBalance\t"+txtBalance.getText()+"\n\nThanks for visit!"
        );
    }
    private void BillHeader(){
        txtBill.setText("ShehanZ Tech Software\nShehanzTech2000@gmail.com\n\n");
    }
    
     private void autoID() {
    try {
        String sql = "SELECT sale_id FROM sale ORDER BY sale_id DESC LIMIT 1";
        Connection con = DBConnection.getConnection();
        pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
        if (rs.next()) {
            String rnno = rs.getString("sale_id");
            int oo = rnno.length();
            String txt = rnno.substring(0, 3);
            String num = rnno.substring(3, oo);
            int n = Integer.parseInt(num);
            n++;
            String snum = Integer.toString(n);
            String ftxt = txt + snum;
            lblsale.setText(ftxt);
        } else {
            lblsale.setText("SID1000");
        }
        
        rs.close();
        pst.close();
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(rootPane, ex.getMessage());
    }
}
    
/*    private void getData(){
        iid = txtItemID.getText();
        iname = txtItemName.getText();
        category = cmbCategory.getSelectedItem().toString();
        seriolNo = txtSeriolNo.getText();
        bPrice = Integer.parseInt(txtBuyingPrice.getText());
        sPrice = Integer.parseInt(txtSellingPrice.getText());
        noOfItems = Integer.parseInt(txtNoOfItems.getText());
    } */
    
    
    
    
    
    
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panel1 = new keeptoo.KGradientPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTotalPrice = new app.bolivia.swing.JCTextField();
        txtItemID = new app.bolivia.swing.JCTextField();
        txtItemName = new app.bolivia.swing.JCTextField();
        txtSerialNO = new app.bolivia.swing.JCTextField();
        txtUnitprice = new app.bolivia.swing.JCTextField();
        txtnoofitems = new app.bolivia.swing.JCTextField();
        rSButtonMetro2 = new rojerusan.RSButtonMetro();
        rSButtonMetro3 = new rojerusan.RSButtonMetro();
        rSButtonMetro4 = new rojerusan.RSButtonMetro();
        txtDiscount = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPayable = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCash = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        txtBalance = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        lblsale = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtBill = new javax.swing.JTextArea();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(640, 520));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        panel1.setkEndColor(new java.awt.Color(153, 153, 153));
        panel1.setkStartColor(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 620, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("No Of Items");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Total Price");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Item ID");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Item Name");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Serial NO");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Unit Price");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        txtTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTotalPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPriceActionPerformed(evt);
            }
        });
        txtTotalPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTotalPriceKeyReleased(evt);
            }
        });
        jPanel3.add(txtTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 170, 30));

        txtItemID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtItemID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemIDActionPerformed(evt);
            }
        });
        txtItemID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtItemIDKeyReleased(evt);
            }
        });
        jPanel3.add(txtItemID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 170, 30));

        txtItemName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtItemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemNameActionPerformed(evt);
            }
        });
        jPanel3.add(txtItemName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 170, 30));

        txtSerialNO.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtSerialNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSerialNOActionPerformed(evt);
            }
        });
        jPanel3.add(txtSerialNO, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 170, 30));

        txtUnitprice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtUnitprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnitpriceActionPerformed(evt);
            }
        });
        jPanel3.add(txtUnitprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 170, 30));

        txtnoofitems.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtnoofitems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnoofitemsActionPerformed(evt);
            }
        });
        txtnoofitems.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnoofitemsKeyReleased(evt);
            }
        });
        jPanel3.add(txtnoofitems, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 170, 30));

        rSButtonMetro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-clear-20.png"))); // NOI18N
        rSButtonMetro2.setText("Clear");
        rSButtonMetro2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rSButtonMetro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro2ActionPerformed(evt);
            }
        });
        jPanel3.add(rSButtonMetro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 80, 30));

        rSButtonMetro3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-sell-20.png"))); // NOI18N
        rSButtonMetro3.setText("Sell");
        rSButtonMetro3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rSButtonMetro3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro3ActionPerformed(evt);
            }
        });
        jPanel3.add(rSButtonMetro3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 80, 30));

        rSButtonMetro4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-print-20.png"))); // NOI18N
        rSButtonMetro4.setText("Print");
        rSButtonMetro4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rSButtonMetro4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro4ActionPerformed(evt);
            }
        });
        jPanel3.add(rSButtonMetro4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 80, 30));

        txtDiscount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiscountActionPerformed(evt);
            }
        });
        txtDiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDiscountKeyReleased(evt);
            }
        });
        jPanel3.add(txtDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 170, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Discount");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        txtPayable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtPayable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPayableActionPerformed(evt);
            }
        });
        jPanel3.add(txtPayable, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 170, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Payble");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        txtCash.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCashActionPerformed(evt);
            }
        });
        txtCash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCashKeyReleased(evt);
            }
        });
        jPanel3.add(txtCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 170, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Cash");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        txtBalance.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBalanceActionPerformed(evt);
            }
        });
        jPanel3.add(txtBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 170, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Balance");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 300, 450));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(lblImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, 140));

        lblsale.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblsale.setForeground(new java.awt.Color(0, 0, 51));
        lblsale.setText("SID1008");
        jPanel4.add(lblsale, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, -1));

        txtBill.setColumns(20);
        txtBill.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtBill.setRows(5);
        jScrollPane2.setViewportView(txtBill);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 290, 260));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 310, 450));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTotalPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPriceActionPerformed
      
    }//GEN-LAST:event_txtTotalPriceActionPerformed

    private void txtItemIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemIDActionPerformed

    private void txtItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemNameActionPerformed

    private void txtSerialNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSerialNOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSerialNOActionPerformed

    private void txtUnitpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnitpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnitpriceActionPerformed

    private void txtnoofitemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnoofitemsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnoofitemsActionPerformed

    private void rSButtonMetro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro2ActionPerformed
      autoID();
      BillHeader();
      txtBalance.setText("");
      txtBill.setText("");
      txtCash.setText("");
      txtDiscount.setText("");
      txtItemID.setText("");
      txtItemName.setText("");
      txtPayable.setText("");
      txtSerialNO.setText("");
      txtTotalPrice.setText("");
      txtUnitprice.setText("");
      txtnoofitems.setText("");
      lblImage.setIcon(null);
      
    }//GEN-LAST:event_rSButtonMetro2ActionPerformed

    private void txtDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiscountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiscountActionPerformed

    private void txtPayableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPayableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPayableActionPerformed

    private void txtCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCashActionPerformed

    private void txtBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBalanceActionPerformed

    private void rSButtonMetro3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro3ActionPerformed
        makebill();
        
         lorddata();
        try {
            String sql = "INSERT INTO `sale`(`sale_id`, `item_id`, `unit_price`, `no_of_items`, `total_price`, `discount`, `payable`, `cash`, `balance`, `date`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";



    con = DBConnection.getConnection();
    pst = con.prepareStatement(sql);
    pst.setString(1, sid);
    pst.setString(2, iid);
    pst.setInt(3, uprice);
    pst.setInt(4, noofitems);
    pst.setInt(5, totalPrice);
    pst.setInt(6, discount);
    pst.setInt(7, payable);
    pst.setInt(8, cash);
    pst.setInt(9, balance);
    pst.setString(10, date);



    
    pst.execute();
    updateItemCount();

    JOptionPane.showMessageDialog(this, "Successfully Added!");
   


            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    
    }//GEN-LAST:event_rSButtonMetro3ActionPerformed

    private void txtItemIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtItemIDKeyReleased
        if(txtItemID.getText().length()==7){
            itemLoard();
        }
    }//GEN-LAST:event_txtItemIDKeyReleased

    private void txtnoofitemsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnoofitemsKeyReleased
      try {
        int price = Integer.parseInt(txtUnitprice.getText());
        int unit = Integer.parseInt(txtnoofitems.getText());
        int tprice = price * unit;
        txtTotalPrice.setText(String.valueOf(tprice));
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, e);
    }       
    }//GEN-LAST:event_txtnoofitemsKeyReleased

    private void txtTotalPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalPriceKeyReleased
           
    }//GEN-LAST:event_txtTotalPriceKeyReleased

    private void txtDiscountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiscountKeyReleased
     try {
        int discount = Integer.parseInt(txtDiscount.getText());
        int tprice = Integer.parseInt(txtTotalPrice.getText());
        int payable = tprice-discount;
        txtPayable.setText(String.valueOf(payable));
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, e);
    }  
    }//GEN-LAST:event_txtDiscountKeyReleased

    private void txtCashKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCashKeyReleased
       
        try {
        int cash = Integer.parseInt(txtCash.getText());
        int payable = Integer.parseInt(txtPayable.getText());
        int balance = cash-payable;
        txtBalance.setText(String.valueOf(balance));
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, e);
    }  
        
        
    }//GEN-LAST:event_txtCashKeyReleased

    private void rSButtonMetro4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro4ActionPerformed
        try {
            
            txtBill.print();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_rSButtonMetro4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblsale;
    private keeptoo.KGradientPanel panel1;
    private rojerusan.RSButtonMetro rSButtonMetro2;
    private rojerusan.RSButtonMetro rSButtonMetro3;
    private rojerusan.RSButtonMetro rSButtonMetro4;
    private app.bolivia.swing.JCTextField txtBalance;
    private javax.swing.JTextArea txtBill;
    private app.bolivia.swing.JCTextField txtCash;
    private app.bolivia.swing.JCTextField txtDiscount;
    private app.bolivia.swing.JCTextField txtItemID;
    private app.bolivia.swing.JCTextField txtItemName;
    private app.bolivia.swing.JCTextField txtPayable;
    private app.bolivia.swing.JCTextField txtSerialNO;
    private app.bolivia.swing.JCTextField txtTotalPrice;
    private app.bolivia.swing.JCTextField txtUnitprice;
    private app.bolivia.swing.JCTextField txtnoofitems;
    // End of variables declaration//GEN-END:variables
}
