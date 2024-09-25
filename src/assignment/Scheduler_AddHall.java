/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package assignment;


import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Scheduler_AddHall extends javax.swing.JFrame {
    //declaring and initializing
    private final HallAdding hallAdding;// Composition: uses HallAdding for hall management
    private final HallsLoader hallsLoader; // Composition: uses HallsLoader to load hall data

    public Scheduler_AddHall() {
        initComponents();
        hallAdding = new HallAdding("Halls_Info.txt");// Initialize HallAdding with the filename
        hallsLoader = new HallsLoader();
        
        try {
        ensureFileExists("Halls_Info.txt");// Ensure the file exists before loading
        initializeTable();// Load existing halls into the table
    } catch (IOException e) {
        System.err.println("Error ensuring file exists: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Error initializing: " 
                + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        jPanel5 = new javax.swing.JPanel();
        btnBackHP = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAddHall = new javax.swing.JTable();
        txtHallType = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCapacity = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtBookingRate = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtHallId = new javax.swing.JTextField();
        btnDelInfo = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();

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
        jLabel3.setText("Adding New Hall");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnBackHP)
                .addGap(183, 183, 183)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBackHP))
                .addContainerGap())
        );

        btnAdd.setBackground(new java.awt.Color(0, 102, 204));
        btnAdd.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        tblAddHall.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tblAddHall.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hall ID", "Hall Type", "Capacity", "Booking Rate/h"
            }
        ));
        jScrollPane1.setViewportView(tblAddHall);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel5.setText("Hall Type");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel7.setText("Hall Capacity");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel12.setText("Booking Rate/h");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel6.setText("Hall ID");

        btnDelInfo.setBackground(new java.awt.Color(0, 102, 204));
        btnDelInfo.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnDelInfo.setForeground(new java.awt.Color(255, 255, 255));
        btnDelInfo.setText("Delete");
        btnDelInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelInfoActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(0, 102, 204));
        btnEdit.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtHallId, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(39, 39, 39)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel5))
                            .addComponent(txtHallType, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel7)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(txtBookingRate, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(7, 7, 7)
                                .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(7, 7, 7)
                                .addComponent(txtBookingRate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtHallType)
                                    .addComponent(txtHallId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackHPActionPerformed
        Scheduler_HomePage homePage = new Scheduler_HomePage();
        homePage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackHPActionPerformed

    
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Get input values from text fields
        String hallId = txtHallId.getText().trim();
        String hallType = txtHallType.getText().trim();
        String capacityStr = txtCapacity.getText().trim();
        String bookingRateStr = txtBookingRate.getText().trim();

        // Validate input
        if (hallId.isEmpty() || hallType.isEmpty() || capacityStr.isEmpty() || bookingRateStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int capacity;
        double bookingRate;

        try {
            capacity = Integer.parseInt(capacityStr);
            bookingRate = Double.parseDouble(bookingRateStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid capacity or booking rate. Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create a new Hall object
        Halls newHall = new Halls(hallId, hallType, capacity, bookingRate);

        // Check if the hall already exists in the table
        if (isHallInTable(newHall.getHallID())) {
            JOptionPane.showMessageDialog(this, "A hall with this ID already exists.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Add to file using HallAdding class
        try {
            hallAdding.addHall(newHall);
            addHallToTable(newHall);
            clearInputFields();
            JOptionPane.showMessageDialog(this, "New hall added successfully!",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            System.err.println("Error in adding hall: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error adding hall: " 
                    + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed
        
    private void btnDelInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelInfoActionPerformed
       int selectedRow = tblAddHall.getSelectedRow();
       if (selectedRow == -1) {
           JOptionPane.showMessageDialog(this, "Please select a hall to delete.",
                   "Error", JOptionPane.ERROR_MESSAGE);
           return;
        }

        DefaultTableModel model = (DefaultTableModel) tblAddHall.getModel();
        String hallId = (String) model.getValueAt(selectedRow, 0);
        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete the hall with ID: " 
                        + hallId + "?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                hallAdding.removeHall(hallId);// Delegate to HallAdding for file operation
                model.removeRow(selectedRow); // Remove from the table
                JOptionPane.showMessageDialog(this, "Hall deleted successfully!",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                System.err.println("Error deleting hall: " + e.getMessage());
                JOptionPane.showMessageDialog(this, "Error deleting hall: " +
                        e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDelInfoActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int selectedRow = tblAddHall.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a hall to edit.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tblAddHall.getModel();
        
        // Get the current values
        String hallId = model.getValueAt(selectedRow, 0).toString();
        String hallType = model.getValueAt(selectedRow, 1).toString();
        int capacity = Integer.parseInt(model.getValueAt(selectedRow, 2).toString());
        double bookingRate = Double.parseDouble(model.getValueAt(selectedRow, 3).toString());

        // Create input dialogs for editing
        String newHallType = JOptionPane.showInputDialog(this,
                "Enter new Hall Type:", hallType);
        String newCapacityStr = JOptionPane.showInputDialog(this, 
                "Enter new Capacity:", capacity);
        String newBookingRateStr = JOptionPane.showInputDialog(this, 
                "Enter new Booking Rate:", bookingRate);

        // Validate and parse inputs
        try {
            int newCapacity = Integer.parseInt(newCapacityStr);
            double newBookingRate = Double.parseDouble(newBookingRateStr);

            // Update the table
            model.setValueAt(newHallType, selectedRow, 1);
            model.setValueAt(newCapacity, selectedRow, 2);
            model.setValueAt(newBookingRate, selectedRow, 3);

            // Update the hall object
            Halls updatedHall = new Halls(hallId, newHallType, newCapacity, newBookingRate);
            hallAdding.updateHall(updatedHall); // Call the update method in HallAdding

            JOptionPane.showMessageDialog(this,
                    "Hall information updated successfully!",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid input. Please enter valid numbers for Capacity and Booking Rate.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error updating hall information: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    // Abstraction: Adds a new hall to the table
    private void addHallToTable(Halls hall) {
        DefaultTableModel model = (DefaultTableModel) tblAddHall.getModel();
        model.addRow(new Object[]{
            hall.getHallID(),
            hall.getHallType(),
            hall.getCapacity(),
            hall.getBookingRate()
        });
    }
        //Abstraction: check if hallId already exists or not
    private boolean isHallInTable(String hallId) {
        DefaultTableModel model = (DefaultTableModel) tblAddHall.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0).equals(hallId)) {
                return true;// Checks if the hall ID already exists in the table
            }
        }
        return false;// Returns false if the hall ID does not exist
    }
        //Encapsulation: clear the txt fields after adding the new hall
    private void clearInputFields() {
        txtHallId.setText("");
        txtHallType.setText("");
        txtCapacity.setText("");
        txtBookingRate.setText("");
    }
        //ensure that the file is exist and writable
    private void ensureFileExists(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("Created new file: " + fileName);
        }
        if (!file.canWrite()) {
            throw new IOException("Cannot write to file: " + fileName);
        }
    }
        //Initioalize the table with the existing hall Info in txt file
    private void initializeTable() {
        try {
            List<Halls> halls = hallAdding.loadHalls();
            updateTable(halls);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error loading hall information: " 
                    + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
        //Update the table with the current hall Info
    private void updateTable(List<Halls> halls) {    
        DefaultTableModel model = (DefaultTableModel) tblAddHall.getModel();    
        model.setRowCount(0); // Clear existing rows

        for (Halls hall : hallsLoader.getHalls()) {       
            model.addRow(new Object[]{            
                hall.getHallID(),            
                hall.getHallType(),           
                hall.getCapacity(),               
                hall.getBookingRate()        
            });   
        }
    }
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
            java.util.logging.Logger.getLogger(Scheduler_AddHall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Scheduler_AddHall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Scheduler_AddHall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Scheduler_AddHall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Scheduler_AddHall().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBackHP;
    private javax.swing.JButton btnDelInfo;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAddHall;
    private javax.swing.JTextField txtBookingRate;
    private javax.swing.JTextField txtCapacity;
    private javax.swing.JTextField txtHallId;
    private javax.swing.JTextField txtHallType;
    // End of variables declaration//GEN-END:variables
}
