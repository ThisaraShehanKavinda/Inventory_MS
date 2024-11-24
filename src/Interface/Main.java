/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Interface;

import inventoryms.DBConnection;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.sql.*;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
/**
 *
 * @author PC
 */
public class Main extends javax.swing.JInternalFrame {

    /**
     * Creates new form Main
     */
    
    private Timer timer1 ,timer2,timer3;
    private JLabel[] starLabels1,starLabels2,startLabels3;
    private int currentLabelIndex = 0;
    
    
    private List<String> photos;
    private List<Double> prices;
    private Timer timer4;

    
    
    
    public Main() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        initializeAnimation();
        initializeAnimation1();
        initializeAnimation2();
        
        
        
        
        
        
        
        
        
        SlideshowController slideshowController1 = new SlideshowController(lblphoto3, lblphoto2, lblphoto11);
        slideshowController1.startSlideshow();
        
        SlideshowController slideshowController2 = new SlideshowController(lblphoto8, lblphoto1, lblphoto5);
        slideshowController2.startSlideshow();
        
        SlideshowController slideshowController3 = new SlideshowController(lblphoto9, lblphoto7, lblphoto4);
        slideshowController3.startSlideshow();
        
        SlideshowController slideshowController4 = new SlideshowController(lblprice3, lblprice1, lblprice);
        slideshowController4.startSlideshow();
        
        SlideshowController slideshowController5 = new SlideshowController(lblprice2, lblprice5, lblprice6);
        slideshowController5.startSlideshow();
        
        SlideshowController slideshowController6 = new SlideshowController(lblprice7, lblprice4, lblprice8);
        slideshowController6.startSlideshow();
        
        lblprice1.setVisible(false);
        lblprice.setVisible(false);
        lblprice5.setVisible(false);
        lblprice6.setVisible(false);
        lblprice4.setVisible(false);
        lblprice8.setVisible(false);
        
        
        
        
      

     
        
        
        
        
        
        
         // Initialize lists to store photos and prices
        photos = new ArrayList<>();
        prices = new ArrayList<>();

        // Connect to the database and retrieve stock information
        connectToDatabase();
        retrieveStockInformation();

        // Create the timer with a 3-second interval
        timer4 = new Timer(3000, new TimerHandler());
        
    }
    
    
    private AnimatedGradientPanel createAnimatedGradientPanel() {
        // Define the start and end colors for the gradient
        Color startColor = Color.RED;
        Color endColor = Color.YELLOW;

        // Set the interval for the animation (1 second)
        int interval = 1000;

        // Create an instance of AnimatedGradientPanel
        AnimatedGradientPanel gradientPanel = new AnimatedGradientPanel(startColor, endColor, interval);

        return gradientPanel;
    }
    
    
    
    
     private void connectToDatabase() {
    try {
        Connection con = DBConnection.getConnection();

        // Create a statement and execute queries to retrieve stock information
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT image, sale_price FROM stock");

        // Store the retrieved photo paths and prices in the lists
        while (rs.next()) {
            String photo = rs.getString("image");
            double price = rs.getDouble("sale_price");
            photos.add(photo);
            prices.add(price);
        }

        // Close the result set, statement, and connection
        rs.close();
        stmt.close();
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

private void retrieveStockInformation() {
    try {
        Connection con = DBConnection.getConnection();

        // Create a statement and execute queries to retrieve stock information
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT image, sale_price FROM stock");

        // Clear the lists before populating with new data
        photos.clear();
        prices.clear();

        // Add retrieved photo paths and prices to the lists
        while (rs.next()) {
            String photo = rs.getString("image");
            double price = rs.getDouble("sale_price");
            photos.add(photo);
            prices.add(price);
        }

        // Close the result set, statement, and connection
        rs.close();
        stmt.close();
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void startDisplay() {
    // Start the timer to trigger the display update
    timer4.start();
}

public void stopDisplay() {
    // Stop the timer
    timer4.stop();
}

private class TimerHandler implements ActionListener {
    private Random random = new Random();

    @Override
    public void actionPerformed(ActionEvent e) {
        // Generate a random index within the range of available stock items
        int randomIndex = random.nextInt(photos.size());

        // Retrieve the photo and price using the random index
        String photoPath = photos.get(randomIndex);
        Double price = prices.get(randomIndex);

        // Create an ImageIcon from the photo path
        ImageIcon icon = new ImageIcon(photoPath);
        // Scale the image to fit the label
        Image image = icon.getImage().getScaledInstance(lblphoto1.getWidth(), lblphoto1.getHeight(), Image.SCALE_SMOOTH);
        // Update the lblphoto label with the scaled image
        lblphoto1.setIcon(new ImageIcon(image));

        // Update the lblprice label with the price
        lblprice.setText(String.valueOf(price));
    }
}


    
    
    
    
    private void initializeAnimation() {
    starLabels1 = new JLabel[]{lbl1, lbl2, lbl3, lbl4, lbl5};

    int delay = 1000; // Initial delay before animation starts (in milliseconds)
    int interval = 500; // Interval between each label's appearance (in milliseconds)
    int showTime = 200; // Time to display each star label before resetting (in milliseconds)

    timer1 = new Timer(interval, new ActionListener() {
        private int animationCount = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            // Show the current star label
            starLabels1[animationCount].setVisible(true);

            // Increment the animation count
            animationCount++;

            // Reset the animation and hide all star labels if all labels have been shown
            if (animationCount == starLabels1.length) {
                Timer resetTimer = new Timer(showTime, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        animationCount = 0;
                        for (JLabel label : starLabels1) {
                            label.setVisible(false);
                        }
                    }
                });
                resetTimer.setRepeats(false);
                resetTimer.start();
            }
        }
    });

    timer1.setInitialDelay(delay);
    timer1.start();
}

   
    private void initializeAnimation1() {
    starLabels2 = new JLabel[]{lbl6, lbl7, lbl8, lbl9, lbl10};

    int delay = 1000; // Initial delay before animation starts (in milliseconds)
    int interval = 500; // Interval between each label's appearance (in milliseconds)
    int showTime = 200; // Time to display each star label before resetting (in milliseconds)

    timer2 = new Timer(interval, new ActionListener() {
        private int animationCount = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            // Show the current star label
            starLabels2[animationCount].setVisible(true);

            // Increment the animation count
            animationCount++;

            // Reset the animation and hide all star labels if all labels have been shown
            if (animationCount == starLabels2.length) {
                Timer resetTimer = new Timer(showTime, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        animationCount = 0;
                        for (JLabel label : starLabels2) {
                            label.setVisible(false);
                        }
                    }
                });
                resetTimer.setRepeats(false);
                resetTimer.start();
            }
        }
    });

    timer2.setInitialDelay(delay);
    timer2.start();
}
  
    
    private void initializeAnimation2() {
    startLabels3 = new JLabel[]{lbl11, lbl12, lbl13, lbl14, lbl15};

    int delay = 1000; // Initial delay before animation starts (in milliseconds)
    int interval = 500; // Interval between each label's appearance (in milliseconds)
    int showTime = 200; // Time to display each star label before resetting (in milliseconds)

    timer3 = new Timer(interval, new ActionListener() {
        private int animationCount = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            // Show the current star label
            startLabels3[animationCount].setVisible(true);

            // Increment the animation count
            animationCount++;

            // Reset the animation and hide all star labels if all labels have been shown
            if (animationCount == startLabels3.length) {
                Timer resetTimer = new Timer(showTime, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        animationCount = 0;
                        for (JLabel label : startLabels3) {
                            label.setVisible(false);
                        }
                    }
                });
                resetTimer.setRepeats(false);
                resetTimer.start();
            }
        }
    });

    timer3.setInitialDelay(delay);
    timer3.start();
}
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl5 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblprice = new javax.swing.JLabel();
        lblphoto11 = new javax.swing.JLabel();
        lblphoto2 = new javax.swing.JLabel();
        lblphoto3 = new javax.swing.JLabel();
        lblprice3 = new javax.swing.JLabel();
        lblprice1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbl6 = new javax.swing.JLabel();
        lbl7 = new javax.swing.JLabel();
        lbl8 = new javax.swing.JLabel();
        lbl9 = new javax.swing.JLabel();
        lbl10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblphoto8 = new javax.swing.JLabel();
        lblphoto1 = new javax.swing.JLabel();
        lblphoto5 = new javax.swing.JLabel();
        lblprice2 = new javax.swing.JLabel();
        lblprice5 = new javax.swing.JLabel();
        lblprice6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbl11 = new javax.swing.JLabel();
        lbl12 = new javax.swing.JLabel();
        lbl13 = new javax.swing.JLabel();
        lbl14 = new javax.swing.JLabel();
        lbl15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblphoto7 = new javax.swing.JLabel();
        lblphoto9 = new javax.swing.JLabel();
        lblphoto4 = new javax.swing.JLabel();
        lblprice4 = new javax.swing.JLabel();
        lblprice7 = new javax.swing.JLabel();
        lblprice8 = new javax.swing.JLabel();
        panel1 = new keeptoo.KGradientPanel();

        setMinimumSize(new java.awt.Dimension(640, 520));
        setPreferredSize(new java.awt.Dimension(640, 520));

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(640, 520));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/wallpaperflare.com_wallpaper (9).jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 242, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("BRANDED PRODUCT");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 23, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Expert");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Trustive");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Original");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 620, 200));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-star-30.png"))); // NOI18N
        lbl5.setText("jLabel9");
        jPanel4.add(lbl5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 30, 40));

        lbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-star-30.png"))); // NOI18N
        lbl1.setText("jLabel9");
        jPanel4.add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 30, 40));

        lbl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-star-30.png"))); // NOI18N
        lbl2.setText("jLabel9");
        jPanel4.add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 30, 40));

        lbl3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-star-30.png"))); // NOI18N
        lbl3.setText("jLabel9");
        jPanel4.add(lbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 30, 40));

        lbl4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-star-30.png"))); // NOI18N
        lbl4.setText("jLabel9");
        jPanel4.add(lbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 30, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Price :  RS");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        lblprice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblprice.setForeground(new java.awt.Color(255, 255, 255));
        lblprice.setText("10000000");
        jPanel4.add(lblprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        lblphoto11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/OIP (3) (1).jpg"))); // NOI18N
        lblphoto11.setText("jLabel6");
        jPanel4.add(lblphoto11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, 144));

        lblphoto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/R (2) (1).jpg"))); // NOI18N
        lblphoto2.setText("jLabel6");
        jPanel4.add(lblphoto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, -1));

        lblphoto3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/R (3) (1).jpg"))); // NOI18N
        lblphoto3.setText("jLabel6");
        jPanel4.add(lblphoto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, -1));

        lblprice3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblprice3.setForeground(new java.awt.Color(255, 255, 255));
        lblprice3.setText("25000");
        jPanel4.add(lblprice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        lblprice1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblprice1.setForeground(new java.awt.Color(255, 255, 255));
        lblprice1.setText("300000");
        jPanel4.add(lblprice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 190, 230));

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-star-30.png"))); // NOI18N
        lbl6.setText("jLabel9");
        jPanel5.add(lbl6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 30, 40));

        lbl7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-star-30.png"))); // NOI18N
        lbl7.setText("jLabel9");
        jPanel5.add(lbl7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 30, 40));

        lbl8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-star-30.png"))); // NOI18N
        lbl8.setText("jLabel9");
        jPanel5.add(lbl8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 30, 40));

        lbl9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-star-30.png"))); // NOI18N
        lbl9.setText("jLabel9");
        jPanel5.add(lbl9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 30, 40));

        lbl10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-star-30.png"))); // NOI18N
        lbl10.setText("jLabel9");
        jPanel5.add(lbl10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 30, 40));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Price :  RS");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        lblphoto8.setBackground(new java.awt.Color(255, 255, 255));
        lblphoto8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/R (2) (1).jpg"))); // NOI18N
        lblphoto8.setText("jLabel6");
        jPanel5.add(lblphoto8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, 144));

        lblphoto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/OIP (3) (1).jpg"))); // NOI18N
        lblphoto1.setText("jLabel6");
        jPanel5.add(lblphoto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, -1));

        lblphoto5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/R (3) (1).jpg"))); // NOI18N
        lblphoto5.setText("jLabel6");
        jPanel5.add(lblphoto5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, 144));

        lblprice2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblprice2.setForeground(new java.awt.Color(255, 255, 255));
        lblprice2.setText("300000");
        jPanel5.add(lblprice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        lblprice5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblprice5.setForeground(new java.awt.Color(255, 255, 255));
        lblprice5.setText("10000000");
        jPanel5.add(lblprice5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        lblprice6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblprice6.setForeground(new java.awt.Color(255, 255, 255));
        lblprice6.setText("25000");
        jPanel5.add(lblprice6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 190, 230));

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-star-30.png"))); // NOI18N
        lbl11.setText("jLabel9");
        jPanel6.add(lbl11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 30, 40));

        lbl12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-star-30.png"))); // NOI18N
        lbl12.setText("jLabel9");
        jPanel6.add(lbl12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 30, 40));

        lbl13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-star-30.png"))); // NOI18N
        lbl13.setText("jLabel9");
        jPanel6.add(lbl13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 30, 40));

        lbl14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-star-30.png"))); // NOI18N
        lbl14.setText("jLabel9");
        jPanel6.add(lbl14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 30, 40));

        lbl15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-star-30.png"))); // NOI18N
        lbl15.setText("jLabel9");
        jPanel6.add(lbl15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 30, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Price :  RS");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        lblphoto7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/R (3) (1).jpg"))); // NOI18N
        lblphoto7.setText("jLabel6");
        jPanel6.add(lblphoto7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, 144));

        lblphoto9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/OIP (3) (1).jpg"))); // NOI18N
        lblphoto9.setText("jLabel6");
        jPanel6.add(lblphoto9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, -1));

        lblphoto4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/R (2) (1).jpg"))); // NOI18N
        lblphoto4.setText("jLabel6");
        jPanel6.add(lblphoto4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 150, 160));

        lblprice4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblprice4.setForeground(new java.awt.Color(255, 255, 255));
        lblprice4.setText("25000");
        jPanel6.add(lblprice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        lblprice7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblprice7.setForeground(new java.awt.Color(255, 255, 255));
        lblprice7.setText("10000000");
        jPanel6.add(lblprice7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        lblprice8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblprice8.setForeground(new java.awt.Color(255, 255, 255));
        lblprice8.setText("300000");
        jPanel6.add(lblprice8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 190, 230));

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

        jPanel1.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 620, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl10;
    private javax.swing.JLabel lbl11;
    private javax.swing.JLabel lbl12;
    private javax.swing.JLabel lbl13;
    private javax.swing.JLabel lbl14;
    private javax.swing.JLabel lbl15;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lbl9;
    private javax.swing.JLabel lblphoto1;
    private javax.swing.JLabel lblphoto11;
    private javax.swing.JLabel lblphoto2;
    private javax.swing.JLabel lblphoto3;
    private javax.swing.JLabel lblphoto4;
    private javax.swing.JLabel lblphoto5;
    private javax.swing.JLabel lblphoto7;
    private javax.swing.JLabel lblphoto8;
    private javax.swing.JLabel lblphoto9;
    private javax.swing.JLabel lblprice;
    private javax.swing.JLabel lblprice1;
    private javax.swing.JLabel lblprice2;
    private javax.swing.JLabel lblprice3;
    private javax.swing.JLabel lblprice4;
    private javax.swing.JLabel lblprice5;
    private javax.swing.JLabel lblprice6;
    private javax.swing.JLabel lblprice7;
    private javax.swing.JLabel lblprice8;
    private keeptoo.KGradientPanel panel1;
    // End of variables declaration//GEN-END:variables
}
