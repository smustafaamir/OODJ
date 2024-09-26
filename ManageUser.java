package assignment;

import javax.swing.*; // For building GUI components
import javax.swing.table.DefaultTableModel; // For managing table data in GUIs
import java.io.*; // For file input/output and object serialization
import java.util.List; // For working with ordered collections
import java.util.ArrayList; // For creating resizable dynamic arrays

interface UserManage { // Interface for managing user operations
    void loadUserData();
    void deleteUser();
    void blockUser();
    void unblockUser();
    void filterUser();
}

public class ManageUser extends JFrame implements UserManage {

    private DefaultTableModel userModel; // Table model for displaying user data
    private List<String[]> originalUserData; // Used to store the original user data
    private List<Integer> filteredUserIndexes = new ArrayList<>(); // Holds indexes of filtered users

    public ManageUser() {
        initComponents(); // Initialize UI components
        userModel = new DefaultTableModel(new String[]{"User ID", "User Name", "User Status"}, 0); // Set the column names for the user table
        tableUserList.setModel(userModel); // Assign the model to the table
        loadUserData(); // Load user data from file
        
        tableUserList.addMouseListener(new java.awt.event.MouseAdapter() { // Add mouse listener to detect row selection from the table
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = tableUserList.getSelectedRow(); // Get the selected row
                if (selectedRow != -1) {
                }
            }
        });
    }

    @Override
    public void loadUserData() {
        originalUserData = new ArrayList<>(); // Initialize list for original user data
        userModel.setRowCount(0); // Clear the table data
        String userFile = "User.txt"; // File path

        try (BufferedReader br = new BufferedReader(new FileReader(userFile))) { // Read the file and load user data
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(","); // Split the line using commas
                originalUserData.add(data); // Add the data to the original user data list
                userModel.addRow(data); // Add the data to the table model
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle any input/output errors
        }
    }

    @Override
    public void deleteUser() {
        int selectedRow = tableUserList.getSelectedRow(); // Get the selected row
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a user to delete!"); // Show error if no row is selected
            return;
        }

        int originalIndex = filteredUserIndexes.isEmpty() ? selectedRow : filteredUserIndexes.get(selectedRow);
        // Get the index of the selected row in the original data list
        originalUserData.remove(originalIndex); // Remove the selected user from the original data list

        saveUserData(); // Save the updated user data to the file
        loadUserData(); // Reload the user data to refresh the table
    }

    @Override
    public void blockUser() {
        int selectedRow = tableUserList.getSelectedRow(); // Get the selected row
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a user to block!"); // Show error if no row is selected
            return;
        }

        int originalIndex = filteredUserIndexes.isEmpty() ? selectedRow : filteredUserIndexes.get(selectedRow);
        // Get the index of the selected row in the original data list
        String[] originalRow = originalUserData.get(originalIndex); // Get the selected user’s data
        if ("Blocked".equalsIgnoreCase(originalRow[2])) {
            JOptionPane.showMessageDialog(null, "This user is already blocked!"); // Show error if user is already blocked
            return;
        }
        originalRow[2] = "Blocked"; // Set the user's status to "Blocked"

        saveUserData(); // Save the updated data to the file
        userModel.setValueAt("Blocked", selectedRow, 2); // Update the user status in the table
        loadUserData(); // Reload the data to refresh the table
    }

    @Override
    public void unblockUser() {
        int selectedRow = tableUserList.getSelectedRow(); // Get the selected row
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a user to unblock!"); // Show error if no row is selected
            return;
        }

        int originalIndex = filteredUserIndexes.isEmpty() ? selectedRow : filteredUserIndexes.get(selectedRow);
        // Get the index of the selected row in the original data list
        String[] originalRow = originalUserData.get(originalIndex);
        if ("Active".equalsIgnoreCase(originalRow[2])) {
            JOptionPane.showMessageDialog(null, "This user is in the active state!"); // Show error if user is already active
            return;
        }
        originalRow[2] = "Active"; // Set the user's status to "Active"
        
        saveUserData(); // Save the updated data to the file
        userModel.setValueAt("Active", selectedRow, 2); // Update the user status in the table
        loadUserData(); // Reload the data to refresh the table
    }

    private void saveUserData() {
        String userFile = "User.txt"; // File path
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(userFile))) {
            for (String[] row : originalUserData) { // Write each row of user data to the file
                bw.write(String.join(",", row)); // Join the data array into a comma-separated string
                bw.newLine(); // Write a new line for each user
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle any input/output errors
        }
    }

    @Override
    public void filterUser() {
        String filterText = txtUserFilter.getText(); // Get the filter text
        userModel.setRowCount(0); // Clear the table data
        filteredUserIndexes.clear(); // Clear the filtered indexes list

        for (int i = 0; i < originalUserData.size(); i++) { // Loop through the original user data
            String[] data = originalUserData.get(i); 
            if (data[0].contains(filterText) || data[1].contains(filterText) || data[2].contains(filterText)) { 
                // Check if any of the user’s fields contain the filter text
                userModel.addRow(data); // Add the matching user to the table
                filteredUserIndexes.add(i); // Save the index of the filtered user
            }
        }
        tableUserList.clearSelection(); // Clear the table selection
        txtUserFilter.setText(""); // Clear the filter text field
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnUserToAdminMenu = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnViewUser = new javax.swing.JButton();
        btnFilterUser = new javax.swing.JButton();
        btnDeleteUser = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUserList = new javax.swing.JTable();
        btnBlockUser = new javax.swing.JButton();
        txtUserFilter = new javax.swing.JTextField();
        btnUnblockUser = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jButton3.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Manage user");

        btnUserToAdminMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assignment/back-24.png"))); // NOI18N
        btnUserToAdminMenu.setToolTipText("");
        btnUserToAdminMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserToAdminMenuActionPerformed(evt);
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
                .addComponent(btnUserToAdminMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175)
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
                            .addComponent(btnUserToAdminMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        btnViewUser.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnViewUser.setText("View");
        btnViewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewUserActionPerformed(evt);
            }
        });

        btnFilterUser.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnFilterUser.setText("Filter");
        btnFilterUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterUserActionPerformed(evt);
            }
        });

        btnDeleteUser.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnDeleteUser.setText("Delete");
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });

        tableUserList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tableUserList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "Username", "User Status"
            }
        ));
        tableUserList.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tableUserList);

        btnBlockUser.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnBlockUser.setText("Block");
        btnBlockUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlockUserActionPerformed(evt);
            }
        });

        btnUnblockUser.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnUnblockUser.setText("Unblock");
        btnUnblockUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnblockUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBlockUser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUnblockUser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnViewUser, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnFilterUser, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(txtUserFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnBlockUser)
                        .addGap(31, 31, 31)
                        .addComponent(btnUnblockUser)
                        .addContainerGap(66, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUserFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteUser))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFilterUser)
                            .addComponent(btnViewUser))
                        .addGap(55, 55, 55))))
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

    private void btnViewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewUserActionPerformed
        loadUserData();
    }//GEN-LAST:event_btnViewUserActionPerformed

    private void btnFilterUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterUserActionPerformed
        filterUser();
    }//GEN-LAST:event_btnFilterUserActionPerformed

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        deleteUser();
    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void btnUserToAdminMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserToAdminMenuActionPerformed
        new AdminMenu().setVisible(true); // Open AdminMenu page
        this.dispose(); // Close current page
    }//GEN-LAST:event_btnUserToAdminMenuActionPerformed

    private void btnBlockUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlockUserActionPerformed
        blockUser();
    }//GEN-LAST:event_btnBlockUserActionPerformed

    private void btnUnblockUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnblockUserActionPerformed
        unblockUser();
    }//GEN-LAST:event_btnUnblockUserActionPerformed

    public static void main(String args[]) {
        new ManageUser().setVisible(true); // Launch the ManageUser page
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBlockUser;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnFilterUser;
    private javax.swing.JButton btnUnblockUser;
    private javax.swing.JButton btnUserToAdminMenu;
    private javax.swing.JButton btnViewUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableUserList;
    private javax.swing.JTextField txtUserFilter;
    // End of variables declaration//GEN-END:variables
}
