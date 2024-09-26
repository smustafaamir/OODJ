package assignment;

import javax.swing.*;

public class AdminMenu extends JFrame { // The AdminMenu class creates the admin menu window using JFrame
    
    public AdminMenu() {
        initComponents(); // To initialize components of the admin menu
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPanel1 = new javax.swing.JPanel();
        btnManageScheduler = new javax.swing.JButton();
        btnViewBookingRecord = new javax.swing.JButton();
        btnManageUser = new javax.swing.JButton();
        MenuUpPanel = new javax.swing.JPanel();
        CompanyName = new javax.swing.JLabel();
        AdminMenu = new javax.swing.JLabel();
        MenuPanel2 = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        LogoutLogo = new javax.swing.JLabel();
        MenuBottomPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MenuPanel1.setBackground(new java.awt.Color(0, 102, 204));
        MenuPanel1.setPreferredSize(new java.awt.Dimension(172, 147));

        btnManageScheduler.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnManageScheduler.setText("Manage Scheduler");
        btnManageScheduler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageSchedulerActionPerformed(evt);
            }
        });

        btnViewBookingRecord.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnViewBookingRecord.setText("View booking record");
        btnViewBookingRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewBookingRecordActionPerformed(evt);
            }
        });

        btnManageUser.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnManageUser.setText("Manage User");
        btnManageUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuPanel1Layout = new javax.swing.GroupLayout(MenuPanel1);
        MenuPanel1.setLayout(MenuPanel1Layout);
        MenuPanel1Layout.setHorizontalGroup(
            MenuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(MenuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnManageScheduler)
                    .addComponent(btnViewBookingRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnManageUser, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        MenuPanel1Layout.setVerticalGroup(
            MenuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(btnManageScheduler)
                .addGap(18, 18, 18)
                .addComponent(btnManageUser)
                .addGap(18, 18, 18)
                .addComponent(btnViewBookingRecord)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        MenuUpPanel.setBackground(new java.awt.Color(0, 102, 204));

        CompanyName.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        CompanyName.setForeground(new java.awt.Color(255, 255, 255));
        CompanyName.setText("Hall Symphony Inc.");

        AdminMenu.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        AdminMenu.setForeground(new java.awt.Color(255, 255, 255));
        AdminMenu.setText("Admin Menu");

        javax.swing.GroupLayout MenuUpPanelLayout = new javax.swing.GroupLayout(MenuUpPanel);
        MenuUpPanel.setLayout(MenuUpPanelLayout);
        MenuUpPanelLayout.setHorizontalGroup(
            MenuUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuUpPanelLayout.createSequentialGroup()
                .addGroup(MenuUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuUpPanelLayout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(CompanyName))
                    .addGroup(MenuUpPanelLayout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(AdminMenu)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MenuUpPanelLayout.setVerticalGroup(
            MenuUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuUpPanelLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(CompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AdminMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        MenuPanel2.setBackground(new java.awt.Color(0, 102, 204));
        MenuPanel2.setPreferredSize(new java.awt.Dimension(146, 70));

        btnLogout.setBackground(new java.awt.Color(153, 0, 0));
        btnLogout.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Log Out");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        LogoutLogo.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        LogoutLogo.setForeground(new java.awt.Color(255, 255, 255));
        LogoutLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assignment/log-out-24.png"))); // NOI18N

        javax.swing.GroupLayout MenuPanel2Layout = new javax.swing.GroupLayout(MenuPanel2);
        MenuPanel2.setLayout(MenuPanel2Layout);
        MenuPanel2Layout.setHorizontalGroup(
            MenuPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanel2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(LogoutLogo)
                .addGap(26, 26, 26)
                .addComponent(btnLogout)
                .addGap(32, 32, 32))
        );
        MenuPanel2Layout.setVerticalGroup(
            MenuPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(MenuPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(LogoutLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        MenuBottomPanel.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout MenuBottomPanelLayout = new javax.swing.GroupLayout(MenuBottomPanel);
        MenuBottomPanel.setLayout(MenuBottomPanelLayout);
        MenuBottomPanelLayout.setHorizontalGroup(
            MenuBottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 756, Short.MAX_VALUE)
        );
        MenuBottomPanelLayout.setVerticalGroup(
            MenuBottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuUpPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MenuBottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MenuPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(MenuPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MenuUpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(MenuPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(MenuPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(MenuBottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageSchedulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageSchedulerActionPerformed
        new ManageScheduler().setVisible(true); // Open ManageScheduler page
        this.dispose(); // Close current menu
    }//GEN-LAST:event_btnManageSchedulerActionPerformed

    private void btnViewBookingRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewBookingRecordActionPerformed
        new ViewBookingRecord().setVisible(true); // Open ViewBookingRecord page
        this.dispose();// Close current menu
    }//GEN-LAST:event_btnViewBookingRecordActionPerformed

    private void btnManageUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageUserActionPerformed
        new ManageUser().setVisible(true); // Open ManageUser page
        this.dispose();// Close current menu
    }//GEN-LAST:event_btnManageUserActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        System.exit(0); // Wait compile then connect to Login page
    }//GEN-LAST:event_btnLogoutActionPerformed

    public static void main(String[] args) {    
        new AdminMenu().setVisible(true);   // Run the AdminMenu
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdminMenu;
    private javax.swing.JLabel CompanyName;
    private javax.swing.JLabel LogoutLogo;
    private javax.swing.JPanel MenuBottomPanel;
    private javax.swing.JPanel MenuPanel1;
    private javax.swing.JPanel MenuPanel2;
    private javax.swing.JPanel MenuUpPanel;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnManageScheduler;
    private javax.swing.JButton btnManageUser;
    private javax.swing.JButton btnViewBookingRecord;
    // End of variables declaration//GEN-END:variables
}
