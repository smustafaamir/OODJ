package assignment;

import javax.swing.*; // For building GUI components
import javax.swing.table.DefaultTableModel; // For managing table data in GUIs
import java.io.*; // For file input/output and object serialization
import java.util.List; // For working with ordered collections
import java.util.ArrayList; // For creating resizable dynamic arrays

interface SchedulerManage {
    void addScheduler(String id, String name, String contact);
    void editScheduler(int selectedRow, String id, String name, String contact);
    void deleteScheduler(int selectedRow);
    void loadSchedulerData();
    void viewScheduler();
    void filterScheduler();
}

public class ManageScheduler extends JFrame implements SchedulerManage {
    
    private DefaultTableModel schedulerModel; // Table model for displaying scheduler data
    private List<String[]> originalschedulerData; // List to store original data, used for editing and deleting entries
    private List<Integer> filteredschedulerIndexes = new ArrayList<>(); // List to store filtered indexes, mapping to the original data

    public ManageScheduler() {
        initComponents();
        schedulerModel = new DefaultTableModel(new String[]{"Scheduler ID", "Scheduler Name", "Contact number"}, 0); // Initialize the table model
        tableSchedulerList.setModel(schedulerModel); // Set the table model to the table component
        loadSchedulerData(); // Reload the user data to refresh the table
        
        tableSchedulerList.addMouseListener(new java.awt.event.MouseAdapter() { 
            // Add mouse click listener to the table, when a row is clicked, the data is populated into the text fields
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = tableSchedulerList.getSelectedRow();
                if (selectedRow != -1) { // Selecting information from a table
                    // Retrieve the selected scheduler information from the table and set them to the text fields
                    txtSchedulerID.setText((String) schedulerModel.getValueAt(selectedRow, 0));
                    txtSchedulerName.setText((String) schedulerModel.getValueAt(selectedRow, 1));
                    txtSchedulerContact.setText((String) schedulerModel.getValueAt(selectedRow, 2));
                }
            }
        });
    }
   
    @Override
    public void loadSchedulerData() { // Method to load scheduler data and display it in the table
        originalschedulerData = new ArrayList(); // Initialize the list to store original data
        schedulerModel.setRowCount(0); // Clear the data from the table
        String schedulerFile = "Scheduler.txt"; // File path
        
        try (BufferedReader br = new BufferedReader(new FileReader(schedulerFile))) { // Read the file using BufferedReader
            String line;
            while ((line = br.readLine()) != null) { // Read the file line by line
                String[] data = line.split(","); // Split the line using a comma to separate scheduler information
                originalschedulerData.add(data); // Add the data to the original data list
                schedulerModel.addRow(data); // Add the data to the table
                }
            } catch (IOException e) {
                e.printStackTrace(); // Handle any input/output errors
            } 
    }

    @Override
    public void addScheduler(String id, String name, String contact) {
        String[] data = {id, name, contact}; // Create a data array with the entered values
        
        if (id.isEmpty() || name.isEmpty() || contact.isEmpty()) { // Check if any field is empty then and show an alert
            JOptionPane.showMessageDialog(null, "Please fill up all the field!");
            return;
        }
        schedulerModel.addRow(data); // Add the new scheduler data to the table model

        String schedulerFile = "Scheduler.txt"; // Append the new data to the file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(schedulerFile, true))) {
            bw.write(String.join(",", data));  // Join array elements with commas
            bw.newLine();  // Write a new line
        } catch (IOException e) {
            e.printStackTrace(); // Handle any input/output errors
        }

        txtSchedulerID.setText(""); // Clear the text fields
        txtSchedulerName.setText("");
        txtSchedulerContact.setText("");
        filteredschedulerIndexes.clear(); // Clear filtered indexes
        loadSchedulerData(); // Reload the user data to refresh the table
    }

    @Override
    public void editScheduler(int selectedRow, String id, String name, String contact) {
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a scheduler to edit!"); // Show error if no row is selected
        return;
    }

    int originalIndex; // 获取原始数据索引
    if (filteredschedulerIndexes.isEmpty()) {
        originalIndex = selectedRow; // 没有过滤
    } else {
        originalIndex = filteredschedulerIndexes.get(selectedRow); // 过滤后的索引
    }

    String[] originalRow = originalschedulerData.get(originalIndex); // 获取原始数据
    originalRow[0] = id;
    originalRow[1] = name;
    originalRow[2] = contact;

    schedulerModel.setValueAt(id, selectedRow, 0); // 更新表格模型
    schedulerModel.setValueAt(name, selectedRow, 1);
    schedulerModel.setValueAt(contact, selectedRow, 2);
  
    String schedulerFile = "Scheduler.txt"; 
    // Overwrite the file with the updated data
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(schedulerFile))) {
        for (String[] row : originalschedulerData) {
            bw.write(String.join(",", row));
            bw.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace(); // Handle any input/output errors
    }

    txtSchedulerID.setText(""); // Clear the text fields
    txtSchedulerName.setText("");
    txtSchedulerContact.setText("");
    filteredschedulerIndexes.clear(); // Clear filtered indexes
    loadSchedulerData(); // Reload the user data to refresh the table
}

    @Override
    public void deleteScheduler(int selectedRow) {
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a scheduler to delete!"); // Show error if no row is selected
            return;
        }

        int originalIndex; // 获取原始数据索引
        if (filteredschedulerIndexes.isEmpty()) {
            originalIndex = selectedRow; // 没有过滤
        } else {
            originalIndex = filteredschedulerIndexes.get(selectedRow); // 过滤后的索引
        }

        originalschedulerData.remove(originalIndex); // Remove the selected row from the original data list
        schedulerModel.removeRow(selectedRow); // Remove the selected row from the table model

        String schedulerFile = "Scheduler.txt";
        // Overwrite the file with the updated data
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(schedulerFile))) {
            for (String[] row : originalschedulerData) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle any input/output errors
        }

        txtSchedulerID.setText(""); // Clear the text fields
        txtSchedulerName.setText("");
        txtSchedulerContact.setText("");
        filteredschedulerIndexes.clear(); // Clear filtered indexes
        loadSchedulerData(); // Reload the user data to refresh the table
    }

    @Override
    public void viewScheduler() {
        schedulerModel.setRowCount(0); // Clear the table data

        String schedulerFile = "Scheduler.txt";
        // Reload data from the file and display it in the table
        try (BufferedReader br = new BufferedReader(new FileReader(schedulerFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                schedulerModel.addRow(data); // 添加到表格
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle any input/output errors
        }
    }

    @Override
    public void filterScheduler() {
        String filterText = txtSchedulerFilter.getText(); // Get the filter text from the text field
        String schedulerFile = "Scheduler.txt";
        schedulerModel.setRowCount(0); // Clear the table
        originalschedulerData.clear(); // Clear the original data list
        filteredschedulerIndexes.clear(); // Clear filter index

        try (BufferedReader br = new BufferedReader(new FileReader(schedulerFile))) { // Reload the file and apply the filter
            String line;
            int index = 0;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                originalschedulerData.add(data); 
                if (data[0].contains(filterText) || data[1].contains(filterText) || data[2].contains(filterText)) { 
                    // If any field contains the filter text, add it to the table
                    schedulerModel.addRow(data); 
                    filteredschedulerIndexes.add(index); // Save original index
                }
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle any input/output errors
        }

        tableSchedulerList.clearSelection(); // Clear the selection and reset the filter text field
        txtSchedulerFilter.setText(""); // Clear the filter field
    }
    
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ManageSchedulerUpPanel = new javax.swing.JPanel();
        btnSchedulerToAdminMenu = new javax.swing.JButton();
        ManageScheduler = new javax.swing.JLabel();
        ManageSchedulerFunctionPanel = new javax.swing.JPanel();
        btnViewScheduler = new javax.swing.JButton();
        btnFilterScheduler = new javax.swing.JButton();
        SchedulerPanel = new javax.swing.JScrollPane();
        tableSchedulerList = new javax.swing.JTable();
        ManageSchedulerId = new javax.swing.JLabel();
        txtSchedulerID = new javax.swing.JTextField();
        ManageSchedulerName = new javax.swing.JLabel();
        txtSchedulerName = new javax.swing.JTextField();
        ManageContact = new javax.swing.JLabel();
        txtSchedulerContact = new javax.swing.JTextField();
        ManageSchedulerPanel = new javax.swing.JPanel();
        btnDeleteScheduler = new javax.swing.JButton();
        btnAddScheduler = new javax.swing.JButton();
        btnEditScheduler = new javax.swing.JButton();
        txtSchedulerFilter = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ManageSchedulerUpPanel.setBackground(new java.awt.Color(0, 102, 204));

        btnSchedulerToAdminMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assignment/back-24.png"))); // NOI18N
        btnSchedulerToAdminMenu.setToolTipText("");
        btnSchedulerToAdminMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSchedulerToAdminMenuActionPerformed(evt);
            }
        });

        ManageScheduler.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        ManageScheduler.setForeground(new java.awt.Color(255, 255, 255));
        ManageScheduler.setText("Manage scheduler");

        javax.swing.GroupLayout ManageSchedulerUpPanelLayout = new javax.swing.GroupLayout(ManageSchedulerUpPanel);
        ManageSchedulerUpPanel.setLayout(ManageSchedulerUpPanelLayout);
        ManageSchedulerUpPanelLayout.setHorizontalGroup(
            ManageSchedulerUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageSchedulerUpPanelLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(btnSchedulerToAdminMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139)
                .addComponent(ManageScheduler)
                .addContainerGap(234, Short.MAX_VALUE))
        );
        ManageSchedulerUpPanelLayout.setVerticalGroup(
            ManageSchedulerUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageSchedulerUpPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(ManageSchedulerUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ManageScheduler, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSchedulerToAdminMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        ManageSchedulerFunctionPanel.setBackground(new java.awt.Color(0, 102, 204));
        ManageSchedulerFunctionPanel.setPreferredSize(new java.awt.Dimension(172, 147));

        btnViewScheduler.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnViewScheduler.setText("View");
        btnViewScheduler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewSchedulerActionPerformed(evt);
            }
        });

        btnFilterScheduler.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnFilterScheduler.setText("Filter");
        btnFilterScheduler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterSchedulerActionPerformed(evt);
            }
        });

        tableSchedulerList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Scheduler ID", "Scheduler Name", "Contact number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SchedulerPanel.setViewportView(tableSchedulerList);

        ManageSchedulerId.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ManageSchedulerId.setForeground(new java.awt.Color(255, 255, 255));
        ManageSchedulerId.setText("Scheduler ID :");

        ManageSchedulerName.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ManageSchedulerName.setForeground(new java.awt.Color(255, 255, 255));
        ManageSchedulerName.setText("Scheduler name :");

        ManageContact.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ManageContact.setForeground(new java.awt.Color(255, 255, 255));
        ManageContact.setText("Contact number :");

        btnDeleteScheduler.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnDeleteScheduler.setText("Delete");
        btnDeleteScheduler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSchedulerActionPerformed(evt);
            }
        });

        btnAddScheduler.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnAddScheduler.setText("Add");
        btnAddScheduler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSchedulerActionPerformed(evt);
            }
        });

        btnEditScheduler.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnEditScheduler.setText("Edit");
        btnEditScheduler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSchedulerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ManageSchedulerPanelLayout = new javax.swing.GroupLayout(ManageSchedulerPanel);
        ManageSchedulerPanel.setLayout(ManageSchedulerPanelLayout);
        ManageSchedulerPanelLayout.setHorizontalGroup(
            ManageSchedulerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageSchedulerPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(ManageSchedulerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnDeleteScheduler)
                    .addComponent(btnAddScheduler, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditScheduler, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        ManageSchedulerPanelLayout.setVerticalGroup(
            ManageSchedulerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageSchedulerPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnAddScheduler)
                .addGap(18, 18, 18)
                .addComponent(btnEditScheduler)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteScheduler)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ManageSchedulerFunctionPanelLayout = new javax.swing.GroupLayout(ManageSchedulerFunctionPanel);
        ManageSchedulerFunctionPanel.setLayout(ManageSchedulerFunctionPanelLayout);
        ManageSchedulerFunctionPanelLayout.setHorizontalGroup(
            ManageSchedulerFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageSchedulerFunctionPanelLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(SchedulerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ManageSchedulerFunctionPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(ManageSchedulerFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ManageSchedulerId)
                    .addComponent(ManageContact)
                    .addComponent(ManageSchedulerName))
                .addGap(31, 31, 31)
                .addGroup(ManageSchedulerFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSchedulerID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSchedulerContact, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSchedulerName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(ManageSchedulerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(ManageSchedulerFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManageSchedulerFunctionPanelLayout.createSequentialGroup()
                        .addComponent(btnViewScheduler, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFilterScheduler, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSchedulerFilter))
                .addGap(45, 45, 45))
        );
        ManageSchedulerFunctionPanelLayout.setVerticalGroup(
            ManageSchedulerFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageSchedulerFunctionPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(SchedulerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(ManageSchedulerFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManageSchedulerFunctionPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(ManageSchedulerFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageSchedulerFunctionPanelLayout.createSequentialGroup()
                                .addGroup(ManageSchedulerFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ManageSchedulerId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSchedulerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(ManageSchedulerFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ManageSchedulerName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSchedulerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(ManageSchedulerFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ManageContact, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSchedulerContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(ManageSchedulerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57))
                    .addGroup(ManageSchedulerFunctionPanelLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(txtSchedulerFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(ManageSchedulerFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnViewScheduler)
                            .addComponent(btnFilterScheduler))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ManageSchedulerUpPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(ManageSchedulerFunctionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ManageSchedulerUpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(ManageSchedulerFunctionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSchedulerToAdminMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSchedulerToAdminMenuActionPerformed
        new AdminMenu().setVisible(true); // Open AdminMenu page
        this.dispose(); // Close current page
    }//GEN-LAST:event_btnSchedulerToAdminMenuActionPerformed

    private void btnEditSchedulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSchedulerActionPerformed
        int selectedRow = tableSchedulerList.getSelectedRow();
        String id = txtSchedulerID.getText();
        String name = txtSchedulerName.getText();
        String contact = txtSchedulerContact.getText();
        editScheduler(selectedRow, id, name, contact); // Call editScheduler method to update the selected scheduler
    }//GEN-LAST:event_btnEditSchedulerActionPerformed

    private void btnAddSchedulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSchedulerActionPerformed
        String id = txtSchedulerID.getText();
        String name = txtSchedulerName.getText();
        String contact = txtSchedulerContact.getText();
        addScheduler(id, name, contact); // Call addScheduler method to add a new scheduler
    }//GEN-LAST:event_btnAddSchedulerActionPerformed

    private void btnDeleteSchedulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSchedulerActionPerformed
        int selectedRow = tableSchedulerList.getSelectedRow();
        deleteScheduler(selectedRow); // Call deleteScheduler method to remove the selected scheduler
    }//GEN-LAST:event_btnDeleteSchedulerActionPerformed

    private void btnFilterSchedulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterSchedulerActionPerformed
        filterScheduler();
    }//GEN-LAST:event_btnFilterSchedulerActionPerformed

    private void btnViewSchedulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewSchedulerActionPerformed
        viewScheduler();
    }//GEN-LAST:event_btnViewSchedulerActionPerformed

    public static void main(String args[]) {
        new ManageScheduler().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ManageContact;
    private javax.swing.JLabel ManageScheduler;
    private javax.swing.JPanel ManageSchedulerFunctionPanel;
    private javax.swing.JLabel ManageSchedulerId;
    private javax.swing.JLabel ManageSchedulerName;
    private javax.swing.JPanel ManageSchedulerPanel;
    private javax.swing.JPanel ManageSchedulerUpPanel;
    private javax.swing.JScrollPane SchedulerPanel;
    private javax.swing.JButton btnAddScheduler;
    private javax.swing.JButton btnDeleteScheduler;
    private javax.swing.JButton btnEditScheduler;
    private javax.swing.JButton btnFilterScheduler;
    private javax.swing.JButton btnSchedulerToAdminMenu;
    private javax.swing.JButton btnViewScheduler;
    private javax.swing.JTable tableSchedulerList;
    private javax.swing.JTextField txtSchedulerContact;
    private javax.swing.JTextField txtSchedulerFilter;
    private javax.swing.JTextField txtSchedulerID;
    private javax.swing.JTextField txtSchedulerName;
    // End of variables declaration//GEN-END:variables
}
