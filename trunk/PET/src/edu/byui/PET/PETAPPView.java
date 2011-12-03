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
import javax.swing.Timer;
import java.awt.image.BufferedImage;
import javaanpr.imageanalysis.Photo;
import javaanpr.intelligence.Intelligence;
import javaanpr.imageanalysis.CarSnapshot;
import javax.swing.ImageIcon;

/**
 *
 * @author Mattthew Allen
 */
public class PETAPPView extends javax.swing.JFrame {

    // Used to store images
    BufferedImage carImage;
    //BufferedImage carPanelImage;
    BufferedImage plateImage;
    //BufferedImage platePanelImage;
    Intelligence reader;
    private String currentPhoto = new String();  //Used for testing

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
        plateText = new javax.swing.JTextField();
        captureButton = new javax.swing.JButton();
        carPanel = new ImagePanel();
        jTextField1 = new javax.swing.JTextField();
        LotSelect = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(edu.byui.PET.PETAPP.class).getContext().getResourceMap(PETAPPView.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setMinimumSize(new java.awt.Dimension(750, 550));
        setName("Form"); // NOI18N

        platePanel.setBackground(resourceMap.getColor("platePanel.background")); // NOI18N
        platePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        platePanel.setName("platePanel"); // NOI18N

        javax.swing.GroupLayout platePanelLayout = new javax.swing.GroupLayout(platePanel);
        platePanel.setLayout(platePanelLayout);
        platePanelLayout.setHorizontalGroup(
            platePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );
        platePanelLayout.setVerticalGroup(
            platePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(11, 11, 11, 11, resourceMap.getColor("jPanel2.border.matteColor"))); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N

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
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addContainerGap())
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

        captureButton.setFont(resourceMap.getFont("captureButton.font")); // NOI18N
        captureButton.setText(resourceMap.getString("captureButton.text")); // NOI18N
        captureButton.setName("captureButton"); // NOI18N
        captureButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                captureButtonPressed(evt);
            }
        });
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
            .addGap(0, 598, Short.MAX_VALUE)
        );
        carPanelLayout.setVerticalGroup(
            carPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 271, Short.MAX_VALUE)
        );

        jTextField1.setText(resourceMap.getString("jTextField1.text")); // NOI18N
        jTextField1.setName("jTextField1"); // NOI18N

        LotSelect.setFont(resourceMap.getFont("LotSelect.font")); // NOI18N
        LotSelect.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "LOT  A ", "LOT  N", "LOT  S", "LOT  H", "LOT  F ", "LOT  V ", "LOT  C", "LOT  L" }));
        LotSelect.setName("LotSelect"); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setName("jComboBox1"); // NOI18N

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.setName("jComboBox2"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(carPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(platePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(plateText, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(captureButton, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))
                        .addGap(255, 255, 255)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, 154, Short.MAX_VALUE)
                            .addComponent(LotSelect, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(208, 208, 208))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(carPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(platePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(plateText, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(captureButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(LotSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
//Edited by Ashcraft
private void violationsBox(PlateInformation currentPlate)
{
   String lotChosen = "";
   String lotChosenString = (LotSelect.getSelectedItem().toString());
   lotChosen += lotChosenString.charAt(5);
   
   if(currentPlate.getPermit() != null)
   {
      if(currentPlate.getPermit().equals(lotChosen))
      {
         jTextField1.setText("No Violation");
      }
      else
      {
         jTextField1.setText("Incorrect Permit");
      }
   }
   else
   {
      jTextField1.setText("No Permit Found");
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
private void captureButtonPressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_captureButtonPressed
    // Capture Mode
    String plateStr = new String();
    H2_DB_Test h2 = new H2_DB_Test();
    String time = "";
    String location = "";
    PlateInformation newSearch = new PlateInformation();
    if (this.captureButton.getText().equals("Capture")) {
        // Get the image from the Camera
        try {
            // This code used for testing
            if (currentPhoto.equals("./resources/1.jpg"))
               currentPhoto = "./resources/3.jpg";
            else if (currentPhoto.equals("./resources/3.jpg"))
               currentPhoto = "./resources/11.jpg";
            else if (currentPhoto.equals("./resources/11.jpg"))
               currentPhoto = "./resources/53.jpg";
            else if (currentPhoto.equals("./resources/53.jpg"))
               currentPhoto = "./resources/54.jpg";
            else if (currentPhoto.equals("./resources/54.jpg"))
               currentPhoto = "./resources/55.jpg";
            else if (currentPhoto.equals("./resources/55.jpg"))
               currentPhoto = "./resources/63.jpg";
            else if (currentPhoto.equals("./resources/63.jpg"))
               currentPhoto = "./resources/69.jpg";
            else if (currentPhoto.equals("./resources/69.jpg"))
               currentPhoto = "./resources/73.jpg";
            else
               currentPhoto = "./resources/1.jpg";

            carImage = (new Photo(currentPhoto)).getBi();  // temporary image
        } catch (Exception e) {
            // TODO: Make GUI Error Window
            System.err.println(e.getMessage());
        }
        // Display the image
        ((ImagePanel) carPanel).setImageIcon(new ImageIcon(carImage));
        //carPanel.paint(carPanel.getGraphics());
        // Clear the plate image
        //((ImagePanel) platePanel).setImageIcon(null);
        //platePanel.paint(platePanel.getGraphics());
        

        try {
            // Pass the image to the recognize function
            plateStr = reader.recognize(new CarSnapshot(carImage));
            // Retrieve the plate image
            plateImage = reader.getPlate();
        } catch (Exception e) {
            // TODO: Make GUI Error Window
            System.err.println(e.getMessage());
        }

        // Display the plate image
        ((ImagePanel) platePanel).setImageIcon(new ImageIcon(plateImage));
        //platePanelImage = Photo.linearResizeBi(plateImage,platePanel.getWidth(),platePanel.getHeight());
        //platePanel.paint(platePanel.getGraphics());

        // Search the permit database for the string
        newSearch = h2.lookUp(plateStr, location, time);
        // If no hits, display violation warning
        // If one hit, display the matched string
        // If multiple hits, ask the operator for clarification
        // Make sure returned permit matches lot

        // Display the plate text
        violationsBox(newSearch);
        if(newSearch.getPlateNo() == null)
        {
           plateText.setText(plateStr);
        }
        else
        {
           plateText.setText(newSearch.getPlateNo());
           
        }
        
    }
    // Lookup Mode with none-empty input
    else if (!this.plateText.getText().trim().isEmpty()) {
        // Search the permit database for the string
        plateStr = plateText.getText();
        
        newSearch = h2.lookUp(plateStr, location, time);
        // If no hits, display violation warning
        // If one hit, display the matched string
        // If multiple hits, ask the operator for clarification
        // Make sure returned permit matches lot
        // Display the plate text
        violationsBox(newSearch);
        if(newSearch.getPlateNo() == null)
        {
           plateText.setText(plateStr);
        }
        else
        {
           plateText.setText(newSearch.getPlateNo());
           
        }
        
    }

    // Make sure the button defaults the "Capture"
    this.captureButton.setText("Capture");
}//GEN-LAST:event_captureButtonPressed


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
      // TODO add your handling code here:
   }//GEN-LAST:event_captureButtonActionPerformed

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
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel platePanel;
    private javax.swing.JTextField plateText;
    // End of variables declaration//GEN-END:variables

   /*
   public void setAutoRequestFocus(boolean b)
   {
      //throw new UnsupportedOperationException("Not yet implemented");
   }*/
}


