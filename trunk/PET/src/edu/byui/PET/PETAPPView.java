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
import edu.byui.PET.images.*;
import java.util.Date;
import javax.swing.Timer;
import java.awt.image.BufferedImage;
import javaanpr.imageanalysis.Photo;
import javaanpr.intelligence.Intelligence;
import javaanpr.imageanalysis.CarSnapshot;

/**
 *
 * @author Mattthew Allen
 */
public class PETAPPView extends javax.swing.JFrame {

    // Used to store images
    BufferedImage carImage;
    BufferedImage carPanelImage;
    BufferedImage plateImage;
    BufferedImage platePanelImage;
    Intelligence reader;

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

        carPanel = new javax.swing.JPanel() {
            public void paint(java.awt.Graphics g) {
                super.paint(g);
                g.drawImage(carPanelImage,0,0,null);
            }
        };
        platePanel = new javax.swing.JPanel() {
            public void paint(java.awt.Graphics g) {
                super.paint(g);
                g.drawImage(platePanelImage,0,0,null);
            }
        };
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new ClockLabel();
        plateText = new javax.swing.JTextField();
        captureButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(edu.byui.PET.PETAPP.class).getContext().getResourceMap(PETAPPView.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setMinimumSize(new java.awt.Dimension(750, 550));
        setName("Form"); // NOI18N

        carPanel.setBackground(resourceMap.getColor("carPanel.background")); // NOI18N
        carPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        carPanel.setName("carPanel"); // NOI18N
        carPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                carPanelComponentResized(evt);
            }
        });

        javax.swing.GroupLayout carPanelLayout = new javax.swing.GroupLayout(carPanel);
        carPanel.setLayout(carPanelLayout);
        carPanelLayout.setHorizontalGroup(
            carPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
        );
        carPanelLayout.setVerticalGroup(
            carPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 313, Short.MAX_VALUE)
        );

        platePanel.setBackground(resourceMap.getColor("platePanel.background")); // NOI18N
        platePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        platePanel.setName("platePanel"); // NOI18N
        platePanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                platePanelComponentResized(evt);
            }
        });

        javax.swing.GroupLayout platePanelLayout = new javax.swing.GroupLayout(platePanel);
        platePanel.setLayout(platePanelLayout);
        platePanelLayout.setHorizontalGroup(
            platePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
        );
        platePanelLayout.setVerticalGroup(
            platePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
        );

        jPanel2.setBackground(resourceMap.getColor("jPanel2.background")); // NOI18N
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(11, 11, 11, 11, resourceMap.getColor("jPanel2.border.matteColor"))); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setForeground(resourceMap.getColor("jLabel1.foreground")); // NOI18N
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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(carPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(plateText, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(captureButton, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                    .addComponent(platePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(303, 303, 303))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(carPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(platePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(captureButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plateText, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    if (this.captureButton.getText().equals("Capture")) {
        // Get the image from the Camera
        try {
            carImage = new Photo("./resources/test.bmp").getBi();  // temporary image
        } catch (Exception e) {
            // TODO: Make GUI Error Window
            System.err.println(e.getMessage());
        }
        // Display the image
        carPanelImage = Photo.linearResizeBi(carImage,carPanel.getWidth(),carPanel.getHeight());
        carPanel.paint(carPanel.getGraphics());
        // Clear the plate image
        platePanelImage = null;
        platePanel.paint(platePanel.getGraphics());
        String plateStr = new String();

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
        platePanelImage = Photo.linearResizeBi(plateImage,platePanel.getWidth(),platePanel.getHeight());
        platePanel.paint(platePanel.getGraphics());

        // Search the permit database for the string
        // If no hits, display violation warning
        // If one hit, display the matched string
        // If multiple hits, ask the operator for clarification
        // Make sure returned permit matches lot

        // Display the plate text
        plateText.setText(plateStr);
    }
    // Lookup Mode with none-empty input
    else if (!this.plateText.getText().trim().isEmpty()) {
        // Search the permit database for the string
        // If no hits, display violation warning
        // If one hit, do nothing
        // If multiple hits, ask for clarification (states)
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
    this.captureButton.setText("<- Lookup");
}//GEN-LAST:event_plateTextChanged

private void carPanelComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_carPanelComponentResized
    carPanelImage = Photo.linearResizeBi(carImage,carPanel.getWidth(),carPanel.getHeight());
    carPanel.paint(carPanel.getGraphics());
}//GEN-LAST:event_carPanelComponentResized

private void platePanelComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_platePanelComponentResized
    platePanelImage = Photo.linearResizeBi(plateImage,platePanel.getWidth(),platePanel.getHeight());
    platePanel.paint(platePanel.getGraphics());
}//GEN-LAST:event_platePanelComponentResized

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
    private javax.swing.JButton captureButton;
    private javax.swing.JPanel carPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel platePanel;
    private javax.swing.JTextField plateText;
    // End of variables declaration//GEN-END:variables

   private void setAutoRequestFocus(boolean b)
   {
      //throw new UnsupportedOperationException("Not yet implemented");
   }
}
