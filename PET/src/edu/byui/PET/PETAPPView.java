/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PETAPPView.java
 *
 * Created on Nov 5, 2011, 11:33:52 AM
 */
package edu.byui.PET;


import edu.byui.PET.util.*;
import edu.byui.PET.h2_db.*;
import edu.byui.PET.images.*;
import java.awt.Color;
import javax.swing.Timer;
import java.awt.image.BufferedImage;
import javaanpr.imageanalysis.Photo;
import javaanpr.intelligence.Intelligence;
import javaanpr.imageanalysis.CarSnapshot;
import javax.swing.ImageIcon;
import java.io.File;  //Used for testing
import java.util.Vector;  //Used for testing

/**
 *
 * @author Mattthew Allen
 */
public class PETAPPView extends javax.swing.JFrame {
    // Pulls the recognition into a separate thread
    // Used to prevent GUI from freezing
    public class RecognizeThread extends Thread {
        BufferedImage carImage;
        BufferedImage plateImage;
        Intelligence reader;
        String output;
        PETAPPView parent;

        public RecognizeThread(PETAPPView myParent, Intelligence rec) {
            parent = myParent;
            reader = rec;
        }

        public void loadImage(BufferedImage image) {
            carImage = image;
        }

        @ Override
        public void run() {
            try
            {
                output = reader.recognize(new CarSnapshot(carImage));
                plateImage = reader.getPlate();
            } catch (Exception e) {
                // TODO: Make GUI Error Window
                System.err.println(e.getMessage());
            }
            parent.getThreadOutput(output, plateImage);
        }
    }

    // Used to store images
    BufferedImage carImage;
    //BufferedImage carPanelImage;
    BufferedImage plateImage;
    //BufferedImage platePanelImage;
    Intelligence reader;
    private int currentTestPhoto = 0;  //Used for testing
    private File[] photoList = null;  // Used for testing

    /** Creates new form PETAPPView */
    public PETAPPView() {

        initComponents();
        try {
            reader = new Intelligence(false);   // This reads the plates
        } catch (Exception e) {
            // TODO: Handle this in the GUI
            System.err.println(e.getMessage());
        }
        Timer t = new Timer(1000, (ClockLabel) jLabel1);
        t.start();
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);

        File folder = new File("./resources/realTestImages");  //Used for testing
        photoList = folder.listFiles();  //Used for testing
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        platePanel = new ImagePanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new ClockLabel();
        captureButton = new javax.swing.JButton();
        carPanel = new ImagePanel();
        jTextField1 = new javax.swing.JTextField();
        LotSelect = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        plateText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(edu.byui.PET.PETAPP.class).getContext().getResourceMap(PETAPPView.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setForeground(resourceMap.getColor("Form.foreground")); // NOI18N
        setMinimumSize(new java.awt.Dimension(750, 550));
        setName("Form"); // NOI18N

        platePanel.setBackground(resourceMap.getColor("platePanel.background")); // NOI18N
        platePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        platePanel.setName("platePanel"); // NOI18N

        javax.swing.GroupLayout platePanelLayout = new javax.swing.GroupLayout(platePanel);
        platePanel.setLayout(platePanelLayout);
        platePanelLayout.setHorizontalGroup(
            platePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );
        platePanelLayout.setVerticalGroup(
            platePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel2.setName("jPanel2"); // NOI18N

        jLabel1.setBackground(resourceMap.getColor("jLabel1.background")); // NOI18N
        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setForeground(resourceMap.getColor("jLabel1.foreground")); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        jLabel1.setMinimumSize(new java.awt.Dimension(30, 10));
        jLabel1.setName("jLabel1"); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(200, 20));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addContainerGap())
        );

        captureButton.setFont(resourceMap.getFont("captureButton.font")); // NOI18N
        captureButton.setText(resourceMap.getString("captureButton.text")); // NOI18N
        captureButton.setName("captureButton"); // NOI18N
        captureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                captureButtonActionPerformed(evt);
            }
        });

        carPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        carPanel.setName("carPanel"); // NOI18N
        carPanel.setPreferredSize(new java.awt.Dimension(602, 239));

        javax.swing.GroupLayout carPanelLayout = new javax.swing.GroupLayout(carPanel);
        carPanel.setLayout(carPanelLayout);
        carPanelLayout.setHorizontalGroup(
            carPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );
        carPanelLayout.setVerticalGroup(
            carPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 271, Short.MAX_VALUE)
        );

        jTextField1.setBackground(resourceMap.getColor("jTextField1.background")); // NOI18N
        jTextField1.setFont(resourceMap.getFont("jTextField1.font")); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText(resourceMap.getString("jTextField1.text")); // NOI18N
        jTextField1.setName("jTextField1"); // NOI18N

        LotSelect.setFont(resourceMap.getFont("LotSelect.font")); // NOI18N
        LotSelect.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "LOT  A ", "LOT  N", "LOT  S", "LOT  H", "LOT  F  ", "LOT  C", "LOT  L" }));
        LotSelect.setName("LotSelect"); // NOI18N

        jComboBox1.setBackground(resourceMap.getColor("jComboBox1.background")); // NOI18N
        jComboBox1.setFont(resourceMap.getFont("jComboBox1.font")); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Special", "Handicap", "Timed ", "Visitor", "Service" }));
        jComboBox1.setName("jComboBox1"); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(resourceMap.getColor("jPanel1.background")); // NOI18N
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel2.setFont(resourceMap.getFont("jLabel2.font")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jTextField2.setFont(resourceMap.getFont("jTextField2.font")); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText(resourceMap.getString("jTextField2.text")); // NOI18N
        jTextField2.setName("jTextField2"); // NOI18N

        jTextField4.setFont(resourceMap.getFont("jTextField4.font")); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText(resourceMap.getString("jTextField4.text")); // NOI18N
        jTextField4.setName("jTextField4"); // NOI18N

        jLabel3.setFont(resourceMap.getFont("jLabel3.font")); // NOI18N
        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setFont(resourceMap.getFont("jLabel4.font")); // NOI18N
        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setFont(resourceMap.getFont("jLabel5.font")); // NOI18N
        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jTextField3.setFont(resourceMap.getFont("jTextField3.font")); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText(resourceMap.getString("jTextField3.text")); // NOI18N
        jTextField3.setName("jTextField3"); // NOI18N

        jTextField5.setFont(resourceMap.getFont("jTextField5.font")); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText(resourceMap.getString("jTextField5.text")); // NOI18N
        jTextField5.setName("jTextField5"); // NOI18N

        jLabel6.setFont(resourceMap.getFont("jLabel6.font")); // NOI18N
        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jTextField6.setFont(resourceMap.getFont("jTextField6.font")); // NOI18N
        jTextField6.setText(resourceMap.getString("jTextField6.text")); // NOI18N
        jTextField6.setName("jTextField6"); // NOI18N

        jLabel7.setFont(resourceMap.getFont("jLabel7.font")); // NOI18N
        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        jTextField7.setFont(resourceMap.getFont("jTextField7.font")); // NOI18N
        jTextField7.setText(resourceMap.getString("jTextField7.text")); // NOI18N
        jTextField7.setName("jTextField7"); // NOI18N

        jLabel8.setFont(resourceMap.getFont("jLabel8.font")); // NOI18N
        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N

        jTextField8.setFont(resourceMap.getFont("jTextField8.font")); // NOI18N
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setText(resourceMap.getString("jTextField8.text")); // NOI18N
        jTextField8.setName("jTextField8"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        plateText.setFont(resourceMap.getFont("plateText.font")); // NOI18N
        plateText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        plateText.setText(resourceMap.getString("plateText.text")); // NOI18N
        plateText.setName("plateText"); // NOI18N
        plateText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                plateTextChanged(evt);
            }
        });

        jButton1.setFont(resourceMap.getFont("jButton1.font")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(resourceMap.getFont("jButton2.font")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(plateText, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(captureButton, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(platePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(carPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(LotSelect, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(172, 172, 172))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LotSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(carPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(platePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(captureButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(plateText, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


//Edited by Ashcraft
private void violationsBox(PlateInformation currentPlate,
        LoggingInformation currentLookUp, H2_DB_Test h2)
{
   String lotChosen = "";
   String lotChosenString = (LotSelect.getSelectedItem().toString());
   lotChosen += lotChosenString.charAt(5);
   String special = this.jComboBox1.getSelectedItem().toString();
   if(special.charAt(1) == 'p')
   {
      if(currentPlate.getPermit() != null)
      {
         jTextField2.setText(currentPlate.getMake());
         jTextField4.setText(currentPlate.getModel());
         jTextField3.setText(currentPlate.getColor());
         jTextField5.setText(currentPlate.getNumViolations());
         jTextField8.setText(currentPlate.getState());
         if(currentPlate.getPermit().equals(lotChosen))
         {
            jTextField1.setText("No Violation");
            jTextField1.setBackground(Color.green);
         }
         else
         {
            jTextField1.setText("Incorrect Permit");
            jTextField1.setBackground(Color.red);
            captureButton.setEnabled(false);
            if(jButton2.isSelected())
            {
               h2.ticket(currentPlate);
            }



         }


         if(currentLookUp != null)
         {
            jTextField6.setText(currentLookUp.getLocation());
            jTextField7.setText(currentLookUp.getTime());
         }
      }
      else
      {
         if (!plateText.getText().equals("No Plate"))
             captureButton.setEnabled(false);
         jTextField1.setText("No Permit Found");
         jTextField2.setText("");
         jTextField4.setText("");
         jTextField3.setText("");
         jTextField5.setText("");
         jTextField6.setText("");
         jTextField7.setText("");
         jTextField8.setText("");
         jTextField1.setBackground(Color.red);
         /*while((!jButton1.isSelected()) && (!jButton2.isSelected()))
         {
            captureButton.disable();
         }
          *
          */
         if(jButton2.isSelected())
         {
             PlateInformation newPlate = new PlateInformation(jTextField1.getText(),
                     jTextField8.getText(), currentPlate.getPermit(), jTextField2.getText(),
                     jTextField4.getText(), jTextField3.getText(), "1");
             h2.writeToPermitDb(newPlate);

         }

      }
   }
   else
   {
      jTextField1.setText(special);
   }

}
/*
 * Captures and processes a picture or looks up an entered string
 *
 * When the captureButton text is "Capture", this method captures a picture
 * from the camera and processes the picture.
 * When the captureButton text is "Lookup", this method searches the database
 * for the string that was entered. This is used when the operator corrects
 * the plate text read by the system.
 *
 * @param evt MouseEvent object. Not used in this method.
 */
public void getThreadOutput(String outText, BufferedImage outImage) {
        /*try {
           tempThread.join();
        }
        catch (InterruptedException ie)
        {
           System.out.println("Main Thread Interrupted");
        }*/
        String plateStr = outText;
        PlateInformation newSearch = new PlateInformation();
        H2_DB_Test h2 = new H2_DB_Test();
        plateImage = outImage;
        plateText.setText("-");
        String time = "";
        String location = "";

        // Display the plate image
        ((ImagePanel) platePanel).setImageIcon(new ImageIcon(plateImage));
        platePanel.repaint();
        //platePanelImage = Photo.linearResizeBi(plateImage,platePanel.getWidth(),platePanel.getHeight());
        //platePanel.paint(platePanel.getGraphics());

        // Search the permit database for the string
        LoggingInformation newLookUp = null;
        if (plateStr != null)
        {
            newLookUp = h2.lookUpLogging(plateStr);
            newSearch = h2.lookUp(plateStr, location, time);
            // If no hits, display violation warning
            // If one hit, display the matched string
            // If multiple hits, ask the operator for clarification
            // Make sure returned permit matches lot

            // Display the plate text
        }
        // If 2 or less numbers or letters with any number of wildcards
        if( (plateStr != null && plateStr.matches("^(\\?*[0-9a-zA-Z]){0,2}\\?*$")) ||
                (newSearch.getPlateNo() == null))
        {
            plateText.setText(plateStr);
        }
        else
        {
            plateText.setText(newSearch.getPlateNo());
        }
        violationsBox(newSearch, newLookUp, h2);

}

/*
 * Changes the captureButton text when the Plate Text is edited
 *
 * @param evt KeyEvent object. Not used in this method.
 */
private void plateTextChanged(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_plateTextChanged
    this.captureButton.setText("Look Up");
}//GEN-LAST:event_plateTextChanged

   private void captureButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_captureButtonActionPerformed
   {//GEN-HEADEREND:event_captureButtonActionPerformed
    // Capture Mode
    H2_DB_Test h2 = new H2_DB_Test();
    //GPS gps = new GPS();

    String time = ((ClockLabel) jLabel1).getTime();
    edu.byui.PET.gps.GPS gps = new edu.byui.PET.gps.GPS();
    String location = gps.getGPSString();
    System.out.println(location);
    //String location = "";
    PlateInformation newSearch = new PlateInformation();
    RecognizeThread subThread = new RecognizeThread(this, reader);  // Used for multi-threading

    if (this.captureButton.getText().equals("Capture")) {
        // Get the image from the Camera
        try {
            // This code used for testing
            do
            {
                currentTestPhoto = (currentTestPhoto + 1) % photoList.length;
            } while (!photoList[currentTestPhoto].getAbsolutePath().toLowerCase().endsWith(".jpg") &&
                    !photoList[currentTestPhoto].getAbsolutePath().toLowerCase().endsWith(".bmp"));

            carImage = (new Photo(photoList[currentTestPhoto].getAbsolutePath())).getBi();  // temporary image
        } catch (Exception e) {
            // TODO: Make GUI Error Window
            System.err.println(e.getMessage());
        }
        // Display the image
        ((ImagePanel) carPanel).setImageIcon(new ImageIcon(carImage));
        plateText.setText("Reading...");

        // Pass the image to the recognize function (runs in new thread to keep the GUI from freezing)
        subThread.loadImage(carImage);
        subThread.start();
    }
    // Lookup Mode with none-empty input
    else if (!this.plateText.getText().trim().isEmpty()) {
        String plateStr = new String();
        // Search the permit database for the string
        plateStr = plateText.getText();
        LoggingInformation newLookUp = null;
        if (plateStr != null)
        {
            newLookUp = h2.lookUpLogging(plateStr);
            newSearch = h2.lookUp(plateStr, location, time);
            // If no hits, display violation warning
            // If one hit, display the matched string
            // If multiple hits, ask the operator for clarification
            // Make sure returned permit matches lot

            // Display the plate text
        }
        if(newSearch.getPlateNo() == null)
        {
           plateText.setText(plateStr);
        }
        else
        {
           plateText.setText(newSearch.getPlateNo());

        }
        violationsBox(newSearch, newLookUp, h2);


    }

    // Make sure the button defaults the "Capture"
    captureButton.setText("Capture");
   }//GEN-LAST:event_captureButtonActionPerformed

   private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBox1ActionPerformed
   {//GEN-HEADEREND:event_jComboBox1ActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_jComboBox1ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    captureButton.setEnabled(true);
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    captureButton.setEnabled(true);
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
            java.util.logging.Logger.getLogger(PETAPPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PETAPPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PETAPPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PETAPPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PETAPPView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox LotSelect;
    private javax.swing.JButton captureButton;
    private javax.swing.JPanel carPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JPanel platePanel;
    private javax.swing.JTextField plateText;
    // End of variables declaration//GEN-END:variables

   /*
   public void setAutoRequestFocus(boolean b)
   {
      //throw new UnsupportedOperationException("Not yet implemented");
   }*/
}


