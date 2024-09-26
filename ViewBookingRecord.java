package assignment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

interface BookingView{
    void loadBookingData();
    void filterBooking();
}

public class ViewBookingRecord extends JFrame implements BookingView {

    private DefaultTableModel bookingModel; // Table model for displaying booking data
    private List<String[]> originalBookingData; // Store the original booking data
    private List<Integer> filteredBookingIndexes = new ArrayList<>(); // Holds indexes of filtered bookings

    public ViewBookingRecord() {
        initComponents(); // Initialize UI components
        bookingModel = new DefaultTableModel(new String[]{"Hall ID", "Hall Type", "User ID", "Start Datetime", "End Datetime", "Reservation ID"}, 0);
        // Set the column names for the booking table
        tableBookingList.setModel(bookingModel); // Assign the model to the table
        loadBookingData(); // Load booking data from the file
    }

    @Override
    public void loadBookingData() {
        originalBookingData = new ArrayList<>(); // Initialize list for original booking data
        bookingModel.setRowCount(0); // Clear the table data
        String bookingFile = "Booking Record.txt"; // File path

        try (BufferedReader br = new BufferedReader(new FileReader(bookingFile))) { // Read the file and load booking data
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(","); // Split the line using commas
                originalBookingData.add(data); // Add the data to the original booking data list
                bookingModel.addRow(data); // Add the data to the table model
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle any input/output errors
        }
    }

    @Override
    public void filterBooking() {
        String filterText = txtBookingFilter.getText(); // Get the filter text
        bookingModel.setRowCount(0); // Clear the table data
        filteredBookingIndexes.clear(); // Clear the filtered indexes list

        for (int i = 0; i < originalBookingData.size(); i++) { // Loop through the original booking data
            String[] data = originalBookingData.get(i);
            if (data[0].contains(filterText) || data[1].contains(filterText) || data[2].contains(filterText) ||
                data[3].contains(filterText) || data[4].contains(filterText) || data[5].contains(filterText)) { // Check if any of the booking fields contain the filter text
                bookingModel.addRow(data); // Add the matching booking to the table
                filteredBookingIndexes.add(i); // Save the index of the filtered booking
            }
        }
        tableBookingList.clearSelection(); // Clear the table selection
        txtBookingFilter.setText(""); // Clear the filter text field
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnBookingToAdminMenu = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnViewBooking = new javax.swing.JButton();
        btnFilterBooking = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBookingList = new javax.swing.JTable();
        txtBookingFilter = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        jButton3.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Booking record");

        btnBookingToAdminMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assignment/back-24.png"))); // NOI18N
        btnBookingToAdminMenu.setToolTipText("");
        btnBookingToAdminMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookingToAdminMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBookingToAdminMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBookingToAdminMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));
        jPanel4.setPreferredSize(new java.awt.Dimension(172, 147));

        btnViewBooking.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnViewBooking.setText("View");
        btnViewBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewBookingActionPerformed(evt);
            }
        });

        btnFilterBooking.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnFilterBooking.setText("Filter");
        btnFilterBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterBookingActionPerformed(evt);
            }
        });

        tableBookingList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Hall ID", "Hall Type", "User ID", "Start datetime", "End Datetime", "Reservation ID"
            }
        ));
        jScrollPane1.setViewportView(tableBookingList);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(btnViewBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(txtBookingFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnFilterBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 85, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBookingFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFilterBooking)
                    .addComponent(btnViewBooking))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addGap(34, 34, 34)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewBookingActionPerformed
        loadBookingData();
    }//GEN-LAST:event_btnViewBookingActionPerformed

    private void btnFilterBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterBookingActionPerformed
        filterBooking();
    }//GEN-LAST:event_btnFilterBookingActionPerformed

    private void btnBookingToAdminMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookingToAdminMenuActionPerformed
        new AdminMenu().setVisible(true); // Open AdminMenu page
        this.dispose(); // Close current page
    }//GEN-LAST:event_btnBookingToAdminMenuActionPerformed

    public static void main(String[] args) {
        new ViewBookingRecord().setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBookingToAdminMenu;
    private javax.swing.JButton btnFilterBooking;
    private javax.swing.JButton btnViewBooking;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableBookingList;
    private javax.swing.JTextField txtBookingFilter;
    // End of variables declaration//GEN-END:variables
}
