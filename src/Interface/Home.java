/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;


import inventoryms.DBConnection;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;


/**
 *
 * @author PC
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    
    int x,y;
    int colorvalue;
    Color btndefault = new Color(23,35,51);
    Color btnClick = new Color(0,102,102);
    
  
    
    
    
    public Home() {
        initComponents();
        dcolor();
        curDateTime();
        showPieChart();
        
        
        panelPieChart.setVisible(false);

        setDataToCards();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Animated Gradient Panel");
        setSize(400, 200);
        //setLocationRelativeTo(null);

        // Create an instance of AnimatedGradientPanel
        Color startColor = Color.BLUE;
Color endColor = new Color(0, 100, 0); 
        int interval = 1000; // 1 second
        AnimatedGradientPanel gradientPanel = new AnimatedGradientPanel(startColor, endColor, interval);

        // Set the layout of panel1 to BorderLayout (or any other layout you desire)
        panel1.setLayout(new BorderLayout());

        // Add the gradient panel to panel1
        panel1.add(gradientPanel, BorderLayout.CENTER);

        // Add other components or content to your frame
        
        
        
        
        JLabel label = new JLabel("ShehanZ tech");
        Font font = new Font("Script MT Bold", Font.BOLD, 24);
        label.setFont(font);
        label.setForeground(Color.WHITE);
        gradientPanel.add(label);
        panel1.add(gradientPanel);
        

        pack();
        
        
        
        
        
       
        
        
        jDesktopPane1.removeAll();
        Main ma = new Main();
        jDesktopPane1.add(ma).setVisible(true);
    }
    
    
    
    
    Color mouseEnterColor = new Color(0,0,0);
    Color mouseExitColor = new Color(51,51,51);
    public void showPieChart(){
            
        //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
      
      //create dataset
      
        try{
            Connection con = DBConnection.getConnection();
            String sl = "select item_name , count(*) as no_of_items from stock group by item_id";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sl);
            
            while(rs.next()){
                barDataset.setValue(rs.getString("item_name"),new Integer(rs.getInt("no_of_items")));
            }
        }catch(Exception e){
            e.printStackTrace();
                    
                    }
      
      //create chart
        JFreeChart piechart = ChartFactory.createPieChart("Item Details",barDataset, true,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
       piePlot.setSectionPaint("IPhone 5s", new Color(255,255,102));
        piePlot.setSectionPaint("SamSung Grand", new Color(102,255,102));
        piePlot.setSectionPaint("MotoG", new Color(255,102,153));
        piePlot.setSectionPaint("Nokia Lumia", new Color(0,204,204));
      
       
        piePlot.setBackgroundPaint(new Color(0, 100, 0));
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelPieChart.removeAll();
        panelPieChart.add(barChartPanel,BorderLayout.CENTER);
        panelPieChart.validate();
    }
    
    
    
    
    
    
    
    
    
    
    
    private void dcolor(){
        btn1.setBackground(btndefault);
        btn2.setBackground(btndefault);
        btn3.setBackground(btndefault);
        btn4.setBackground(btndefault);
        btn5.setBackground(btndefault);
        btn6.setBackground(btndefault);
        
    }
    
    
    
       public void setDataToCards(){
        Statement st = null;
        ResultSet rs = null;
        
        long l = System.currentTimeMillis();
        
        try{
        Connection con = DBConnection.getConnection();
        st = con.createStatement();
        rs =  st.executeQuery("select * from stock" );
       rs.last();
       lblStock.setText( Integer.toString(rs.getRow()) ); 
        
       
       rs = st.executeQuery("select * from sale");
       rs.last();
       lblsells.setText( Integer.toString(rs.getRow()) ); 
        
       
      
        
       
        }catch(Exception ex){
            ex.printStackTrace();
        }
         
    }
    
    
    
    
    private void clickcolor(){
        if(colorvalue==1){
            btn1.setBackground(btnClick);
        }
        else if(colorvalue==2){
            btn2.setBackground(btnClick);
        }
        else if(colorvalue==3){
            btn3.setBackground(btnClick);
        }
        else if(colorvalue==4){
            btn4.setBackground(btnClick);
        } else if(colorvalue==5){
            btn5.setBackground(btnClick);
        } else if(colorvalue==6){
            btn6.setBackground(btnClick);
        
        
        
           
        
    }
    
    }
    
    
    public void curDateTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd    HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        lblDate.setText(dtf.format(now));
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
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        panel = new keeptoo.KGradientPanel();
        btn1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btn2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btn3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn4 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btn6 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn5 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        lblMenu = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panelPieChart = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblsells = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        panel1 = new keeptoo.KGradientPanel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 0, 0));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 0, 204));
        kGradientPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                kGradientPanel1MouseDragged(evt);
            }
        });
        kGradientPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kGradientPanel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                kGradientPanel1MousePressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/close.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(1048, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 30));

        panel.setkEndColor(new java.awt.Color(0, 0, 0));
        panel.setkStartColor(new java.awt.Color(0, 0, 153));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn1.setBackground(new java.awt.Color(0, 102, 102));
        btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn1MouseClicked(evt);
            }
        });
        btn1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        btn1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 5, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("HOME");
        btn1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 60, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-home-20.png"))); // NOI18N
        btn1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 30));

        panel.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 180, 30));

        btn2.setBackground(new java.awt.Color(0, 102, 102));
        btn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn2MouseClicked(evt);
            }
        });
        btn2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        btn2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 5, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ADD ITEMS");
        btn2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 90, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-add-20.png"))); // NOI18N
        btn2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 30));

        panel.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 180, -1));

        btn3.setBackground(new java.awt.Color(0, 102, 102));
        btn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn3MouseClicked(evt);
            }
        });
        btn3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        btn3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 5, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("STOCKS");
        btn3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 60, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-stock-20.png"))); // NOI18N
        btn3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 30));

        panel.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 180, -1));

        btn4.setBackground(new java.awt.Color(0, 102, 102));
        btn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn4MouseClicked(evt);
            }
        });
        btn4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        btn4.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 5, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SELL");
        btn4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 60, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-cart-20.png"))); // NOI18N
        btn4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 30));

        panel.add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 180, -1));

        btn6.setBackground(new java.awt.Color(0, 102, 102));
        btn6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn6MouseClicked(evt);
            }
        });
        btn6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        btn6.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 5, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("SETTING");
        btn6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 60, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-service-20.png"))); // NOI18N
        btn6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 30));

        panel.add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 180, -1));

        btn5.setBackground(new java.awt.Color(0, 102, 102));
        btn5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn5MouseClicked(evt);
            }
        });
        btn5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        btn5.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 5, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("REPORT");
        btn5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 60, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-graph-20.png"))); // NOI18N
        btn5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 30));

        panel.add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 180, -1));

        kGradientPanel3.setkEndColor(new java.awt.Color(0, 0, 0));
        kGradientPanel3.setkStartColor(new java.awt.Color(0, 0, 102));

        lblMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-menu-22.png"))); // NOI18N
        lblMenu.setText("jLabel18");
        lblMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMenuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel.add(kGradientPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 40));

        jPanel1.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 180, 560));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-user-30.png"))); // NOI18N
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 6, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Thisara Shehan Kavinda");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 6, -1, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("USER NAME :");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 6, -1, 30));

        lblDate.setFont(new java.awt.Font("Lucida Console", 1, 13)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setText("2022.05.04   23:34:45");
        jPanel3.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 20));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 640, 40));

        jDesktopPane1.setBackground(new java.awt.Color(0, 0, 51));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        jPanel1.add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 640, 520));

        jPanel4.setBackground(new java.awt.Color(0, 255, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 250, -1));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPieChart.setLayout(new java.awt.BorderLayout());
        jPanel2.add(panelPieChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 210, 190));

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("View Stock");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 110, 40));

        kGradientPanel2.setkStartColor(new java.awt.Color(0, 153, 153));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Stock");
        kGradientPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-send-100.png"))); // NOI18N
        kGradientPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 110, 110));

        lblStock.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        lblStock.setForeground(new java.awt.Color(255, 255, 255));
        lblStock.setText("9");
        kGradientPanel2.add(lblStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 43, -1));

        jPanel2.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 230, 110));

        kGradientPanel4.setkStartColor(new java.awt.Color(0, 153, 153));
        kGradientPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Sells");
        kGradientPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-money-100.png"))); // NOI18N
        kGradientPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 110, 110));

        lblsells.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        lblsells.setForeground(new java.awt.Color(255, 255, 255));
        lblsells.setText("9");
        kGradientPanel4.add(lblsells, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 43, -1));

        jPanel2.add(kGradientPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 230, 110));

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Pie Chart");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 110, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 250, 520));

        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Script MT Bold", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("ShehanZ Tech");
        panel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 190, 40));

        jPanel1.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 250, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1070, 590));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void kGradientPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MouseDragged
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();
        this.setLocation(xx=x,yy=y);
    }//GEN-LAST:event_kGradientPanel1MouseDragged

    private void kGradientPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MouseClicked
        
    }//GEN-LAST:event_kGradientPanel1MouseClicked

    private void kGradientPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_kGradientPanel1MousePressed

    private void btn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn2MouseClicked

        
       
        colorvalue = 2;
        jDesktopPane1.removeAll();
        AddItem ad = new AddItem();
        jDesktopPane1.add(ad).setVisible(true);
          dcolor();
        clickcolor();
        setDataToCards();
    }//GEN-LAST:event_btn2MouseClicked

    private void btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn1MouseClicked

        
        
        
        colorvalue = 1;
        jDesktopPane1.removeAll();
        Main ma = new Main();
        jDesktopPane1.add(ma).setVisible(true);
        dcolor();
        clickcolor();
        setDataToCards();
    }//GEN-LAST:event_btn1MouseClicked

    private void btn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn3MouseClicked

 
        colorvalue = 3;
        jDesktopPane1.removeAll();
        Stock stock = new Stock();
        jDesktopPane1.add(stock).setVisible(true);
        dcolor();
        clickcolor();
        setDataToCards();
    }//GEN-LAST:event_btn3MouseClicked

    private void btn4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn4MouseClicked
        
        colorvalue = 4;
        jDesktopPane1.removeAll();
        Sale sale = new Sale();
        jDesktopPane1.add(sale).setVisible(true);
         dcolor();
        clickcolor();
        setDataToCards();
    }//GEN-LAST:event_btn4MouseClicked

    private void btn5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn5MouseClicked
       
         
        colorvalue = 5;
        jDesktopPane1.removeAll();
        Report report = new Report();
        jDesktopPane1.add(report).setVisible(true);
         dcolor();
        clickcolor();
        setDataToCards();
    }//GEN-LAST:event_btn5MouseClicked

    private void btn6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn6MouseClicked
       
         
        colorvalue = 6;
        Register register = new Register();
       register.setVisible(true);
       this.dispose();
        dcolor();
        clickcolor();
        setDataToCards();
    }//GEN-LAST:event_btn6MouseClicked

    
    
    private boolean isMinimized = false; // Declare the 'isMinimized' variable outside the method


    private void lblMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuMouseClicked

         if (isMinimized) {
        panel.setPreferredSize(new Dimension(180, panel.getHeight()));
        isMinimized = false;
    } else {
        panel.setPreferredSize(new Dimension(50, panel.getHeight()));
        isMinimized = true;
    }

    panel.revalidate();
    panel.repaint();
    
    }//GEN-LAST:event_lblMenuMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Gallery gallery = new Gallery();
       gallery.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(panelPieChart.isVisible()){
        panelPieChart.setVisible(false);
    }
    else{
        panelPieChart.setVisible(true);
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
       
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
                 Color startColor = Color.RED;
       
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn1;
    private javax.swing.JPanel btn2;
    private javax.swing.JPanel btn3;
    private javax.swing.JPanel btn4;
    private javax.swing.JPanel btn5;
    private javax.swing.JPanel btn6;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblsells;
    public keeptoo.KGradientPanel panel;
    private keeptoo.KGradientPanel panel1;
    private javax.swing.JPanel panelPieChart;
    // End of variables declaration//GEN-END:variables
}
