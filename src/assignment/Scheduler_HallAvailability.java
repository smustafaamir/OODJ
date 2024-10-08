/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package assignment;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Scheduler_HallAvailability extends javax.swing.JFrame {
    public String selHall;
    
    ArrayList<Halls> hall = new ArrayList<>();// Encapsulation: uses ArrayList to manage hall data
    
    public Scheduler_HallAvailability() {
        initComponents();
        loadHallIds();
                       
            cboHallId.addActionListener(new java.awt.event.ActionListener() {// Abstraction
            @Override //method is overridden to update the text fields when a Hall ID is selected.
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboHallIdActionPerformed(evt);
            }
        });
            
        
            btnBackHP.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackHPActionPerformed(evt);
            }
        });        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        btnBackHP = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        btnSetDateOrTime = new javax.swing.JButton();
        cboHallId = new javax.swing.JComboBox<>();
        txtHallType = new javax.swing.JTextField();
        txtHallCapacity = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtBookingRate = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReservations = new javax.swing.JTable();
        jsEnd = new javax.swing.JSpinner();
        jsStart = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtResId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        jPanel5.setBackground(new java.awt.Color(0, 102, 204));

        btnBackHP.setBackground(new java.awt.Color(0, 102, 204));
        btnBackHP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assignment/back-24.png"))); // NOI18N
        btnBackHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackHPActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Availablity Info");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnBackHP)
                .addGap(307, 307, 307)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBackHP)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel6.setText("Hall ID");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel5.setText("Hall Type");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel7.setText("Hall Capacity");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Reservation End Date&Time");

        btnReset.setBackground(new java.awt.Color(0, 102, 204));
        btnReset.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnSetDateOrTime.setBackground(new java.awt.Color(0, 102, 204));
        btnSetDateOrTime.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSetDateOrTime.setForeground(new java.awt.Color(255, 255, 255));
        btnSetDateOrTime.setText("Set");
        btnSetDateOrTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetDateOrTimeActionPerformed(evt);
            }
        });

        cboHallId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboHallIdActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel12.setText("Booking Rate/h");

        tblReservations.setBackground(new java.awt.Color(204, 204, 204));
        tblReservations.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tblReservations.setForeground(new java.awt.Color(0, 102, 204));
        tblReservations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hall ID", "Reservation ID", "Hall Type", "Reservation Start Date&Time", "Reservation End Date&Time"
            }
        ));
        tblReservations.setToolTipText("");
        jScrollPane1.setViewportView(tblReservations);

        jsEnd.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jsEnd.setModel(new javax.swing.SpinnerDateModel());
        jsEnd.setEditor(new javax.swing.JSpinner.DateEditor(jsEnd, "dd-MM-yyyy | HH:mm"));

        jsStart.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jsStart.setModel(new javax.swing.SpinnerDateModel());
        jsStart.setEditor(new javax.swing.JSpinner.DateEditor(jsStart, "dd-MM-yyyy | HH:mm"));
        jsStart.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jsStartComponentHidden(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Reservation Start Date & Time");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel8.setText("Reservation ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(cboHallId, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel5))
                            .addComponent(txtHallType, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHallCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel7))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel8))
                            .addComponent(txtResId, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jsStart, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBookingRate, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSetDateOrTime, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jsEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)))))
                .addGap(67, 67, 67))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(7, 7, 7)
                                .addComponent(cboHallId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(7, 7, 7)
                                    .addComponent(txtHallCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(7, 7, 7)
                                    .addComponent(txtHallType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(7, 7, 7)
                                    .addComponent(txtBookingRate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnReset)
                            .addComponent(btnSetDateOrTime))
                        .addGap(25, 25, 25)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(7, 7, 7)
                        .addComponent(txtResId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jsEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jsStart, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void cboHallIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboHallIdActionPerformed
        
    int selectedIndex = cboHallId.getSelectedIndex();
    
    // Check if the ComboBox has any items and the selected index is valid
    if (selectedIndex >= 0 && selectedIndex < hall.size()) {
        Halls selectedHall = hall.get(selectedIndex);
        if (selectedHall != null) {
            System.out.println("Selected Hall ID: " + selectedHall.getHallID());
            txtHallType.setText(selectedHall.getHallType());
            txtHallCapacity.setText(String.valueOf(selectedHall.getCapacity()));
            txtBookingRate.setText(String.valueOf(selectedHall.getBookingRate()));
            selHall = selectedHall.getHallID();
        } else {
            System.out.println("Selected hall is null.");
        }
    } else {
        System.out.println("Invalid selection or hall list is empty.");
    }
    }//GEN-LAST:event_cboHallIdActionPerformed
    private void loadHallIds(){//Abstraction:
     try {                    //hides implementation details of loading hall IDs
        HallsLoader hallsLoader = new HallsLoader();
        hallsLoader.load("Halls_Info.txt");

        // Populate combo box with hall IDs
        for (Halls hall : hallsLoader.getHalls()) {
            cboHallId.addItem(hall.getHallID());
            this.hall.add(hall); // Ensure the hall list is populated
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
    }
     
    
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        //Encapsulation: to delete the content from the txt fields
        txtHallType.setText("");
        txtHallCapacity.setText("");
        txtBookingRate.setText("");        
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSetDateOrTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetDateOrTimeActionPerformed
         String hallId = cboHallId.getSelectedItem().toString();
        String halltype = txtHallType.getText();
        Date startDateTime = (Date) jsStart.getValue();
        Date endDateTime = (Date) jsEnd.getValue();
        String resId = txtResId.getText();
        
        
            // Check if the combobox & text fiels has a valid selection
        if (cboHallId.getSelectedIndex() < 0 ) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Warning",
                JOptionPane.WARNING_MESSAGE);
              return;}        
        if (txtHallType.getText().isEmpty() || 
            txtHallCapacity.getText().isEmpty() || 
            txtBookingRate.getText().isEmpty()) {
    
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Warning",
            JOptionPane.WARNING_MESSAGE);
                return;}
        
            // Update the reservation Info the Table
        DefaultTableModel reserve = (DefaultTableModel) tblReservations.getModel();
        reserve.addRow(new Object[]{hallId, halltype, startDateTime, endDateTime, resId }); 
        
            // Update reservation Info to the txt file
        try (FileWriter writer = new FileWriter("Hall_reservations.txt", true);
         BufferedWriter bw = new BufferedWriter(writer);
         PrintWriter out = new PrintWriter(bw)) {
        out.println(hallId + ";" + halltype + ";" + startDateTime + ";" + endDateTime + ";" + resId);
        
            // Show success message
        JOptionPane.showMessageDialog(this, "Reservation successfully saved.", "Success",
            JOptionPane.INFORMATION_MESSAGE);}   
        catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error writing to file: " + e.getMessage(), "Error", 
            JOptionPane.ERROR_MESSAGE);}
         
    }//GEN-LAST:event_btnSetDateOrTimeActionPerformed

    private void btnBackHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackHPActionPerformed
        // Inheritance: creates an instance of another JFrame
        Scheduler_HomePage homePage = new Scheduler_HomePage();
        homePage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackHPActionPerformed

    private void jsStartComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jsStartComponentHidden
        //btnSetDateOrTime.setEnabled(jsStart.getValue() != null);
    }//GEN-LAST:event_jsStartComponentHidden
   
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
            java.util.logging.Logger.getLogger(Scheduler_HallAvailability.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Scheduler_HallAvailability.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Scheduler_HallAvailability.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Scheduler_HallAvailability.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */ 
         //Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Scheduler_HallAvailability().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackHP;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSetDateOrTime;
    private javax.swing.JComboBox<String> cboHallId;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jsEnd;
    private javax.swing.JSpinner jsStart;
    private javax.swing.JTable tblReservations;
    private javax.swing.JTextField txtBookingRate;
    private javax.swing.JTextField txtHallCapacity;
    private javax.swing.JTextField txtHallType;
    private javax.swing.JTextField txtResId;
    // End of variables declaration//GEN-END:variables
}
