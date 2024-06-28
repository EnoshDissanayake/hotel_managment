/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author Acer
 */
public class ViewCustomers extends javax.swing.JDialog {

    Invoice i;

    public void loadCustomers() {
        try {
            ResultSet rs1 = MySQL.search("SELECT `customer`.`NIC`,`customer`.`name`,`customer`.`contact_number`,`customer`.`email`,`board_type`.`id` AS `boardtype_id`,`room_type`.`id` AS `roomtype_id`,`room`.`id` AS `room_id`,`customer`.`check_in`,`customer`.`check_out`,`customer`.`guests`,`room_price`.`id` AS `roomprice_id` FROM `customer` INNER JOIN `board_type` ON `customer`.board_type_id=`board_type`.id INNER JOIN `room_type` ON `customer`.room_type_id=`room_type`.id INNER JOIN `room` ON `customer`.room_id=`room`.id INNER JOIN `room_price` ON `customer`.room_price_id=`room_price`.id ORDER BY `customer`.`NIC` ASC;");
            rs1.next();
            String btype = rs1.getString("boardtype_id");
            String rtype = rs1.getString("roomtype_id");
            String rprice = rs1.getString("roomprice_id");

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs1.next()) {

                ResultSet rs2 = MySQL.search("SELECT * FROM `board_type` WHERE `id`='" + btype + "'");
                rs2.next();
                //String board_type = rs2.getString("name");
                ResultSet rs3 = MySQL.search("SELECT * FROM `room_type` WHERE `id`='" + rtype + "'");
                rs3.next();
                ResultSet rs4 = MySQL.search("SELECT * FROM `room_price` WHERE `id`='" + rprice + "'");
                rs4.next();

                Vector v = new Vector();
                v.add(rs1.getString("NIC"));
                v.add(rs1.getString("name"));
                v.add(rs1.getString("contact_number"));
                v.add(rs1.getString("email"));
                v.add(rs2.getString("name"));
                v.add(rs3.getString("name"));
                v.add(rs1.getString("room_id"));
                v.add(rs1.getString("check_in"));
                v.add(rs1.getString("check_out"));
                v.add(rs1.getString("guests"));
                v.add(rs4.getString("price"));

                dtm.addRow(v);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadCustomers(String text) {
        try {
            ResultSet rs1 = MySQL.search("SELECT `customer`.`NIC`,`customer`.`name`,`customer`.`contact_number`,`customer`.`email`,`board_type`.`id` AS `boardtype_id`,`room_type`.`id` AS `roomtype_id`,`room`.`id` AS `room_id`,`customer`.`check_in`,`customer`.`check_out`,`customer`.`guests`,`room_price`.`id` AS `roomprice_id` FROM `customer` INNER JOIN `board_type` ON `customer`.board_type_id=`board_type`.id INNER JOIN `room_type` ON `customer`.room_type_id=`room_type`.id INNER JOIN `room` ON `customer`.room_id=`room`.id INNER JOIN `room_price` ON `customer`.room_price_id=`room_price`.id WHERE `customer`.`NIC` LIKE '" + text + "%' OR `customer`.`name` LIKE '" + text + "%' ORDER BY `customer`.`NIC` ASC;");
            rs1.next();
            String btype = rs1.getString("boardtype_id");
            String rtype = rs1.getString("roomtype_id");
            String rprice = rs1.getString("roomprice_id");

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs1.next()) {

                ResultSet rs2 = MySQL.search("SELECT * FROM `board_type` WHERE `id`='" + btype + "'");
                rs2.next();
                //String board_type = rs2.getString("name");
                ResultSet rs3 = MySQL.search("SELECT * FROM `room_type` WHERE `id`='" + rtype + "'");
                rs3.next();
                ResultSet rs4 = MySQL.search("SELECT * FROM `room_price` WHERE `id`='" + rprice + "'");
                rs4.next();

                Vector v = new Vector();
                v.add(rs1.getString("NIC"));
                v.add(rs1.getString("name"));
                v.add(rs1.getString("contact_number"));
                v.add(rs1.getString("email"));
                v.add(rs2.getString("name"));
                v.add(rs3.getString("name"));
                v.add(rs1.getString("room_id"));
                v.add(rs1.getString("check_in"));
                v.add(rs1.getString("check_out"));
                v.add(rs1.getString("guests"));
                v.add(rs4.getString("price"));

                dtm.addRow(v);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Creates new form ViewCustomers
     */
    public ViewCustomers(Invoice i) {
        initComponents();
        loadCustomers();

        this.i = i;
    }

    public ViewCustomers(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadCustomers();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Search Users");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(268, 268, 268))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIC", "Name", "Contact Number", "Email", "Board Type", "Room Type", "Room ID", "Check In", "Check Out", "Guests", "price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(100);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(4).setMinWidth(100);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(5).setMinWidth(100);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(6).setMinWidth(100);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(7).setMinWidth(110);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(170);
            jTable1.getColumnModel().getColumn(8).setMinWidth(110);
            jTable1.getColumnModel().getColumn(8).setMaxWidth(170);
            jTable1.getColumnModel().getColumn(9).setMinWidth(100);
            jTable1.getColumnModel().getColumn(9).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(10).setMinWidth(100);
            jTable1.getColumnModel().getColumn(10).setMaxWidth(150);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int r = jTable1.getSelectedRow();

            if (r == -1) {
                JOptionPane.showMessageDialog(this, "Please Select a Customer", "warning", JOptionPane.WARNING_MESSAGE);
            } else {

                if (i != null) {
                    String nic = jTable1.getValueAt(r, 0).toString();
                    String name = jTable1.getValueAt(r, 1).toString();
                    String mobile = jTable1.getValueAt(r, 2).toString();
                    String email = jTable1.getValueAt(r, 3).toString();
                    String b_type = jTable1.getValueAt(r, 4).toString();
                    String r_type = jTable1.getValueAt(r, 5).toString();
                    String rid = jTable1.getValueAt(r, 6).toString();
                    String cin = jTable1.getValueAt(r, 7).toString();
                    String cout = jTable1.getValueAt(r, 8).toString();
                    String guest = jTable1.getValueAt(r, 9).toString();
                    String price = jTable1.getValueAt(r, 10).toString();

                    Date date1 = null;
                    Date date2 = null;
                    try {
                        date1 = new SimpleDateFormat("yyyy-MM-dd").parse(cin);
                        date2 = new SimpleDateFormat("yyyy-MM-dd").parse(cout);
                    } catch (ParseException ex) {
                        Logger.getLogger(ViewCustomers.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    i.jLabel10.setText(nic);
                    i.jLabel18.setText(name);
                    i.jLabel30.setText(mobile);
                    i.jLabel20.setText(email);
                    i.jLabel12.setText(b_type);
                    i.jLabel32.setText(r_type);
                    i.jLabel33.setText(rid);
                    i.jDateChooser1.setDate(date1);
                    i.jDateChooser2.setDate(date2);
                    i.jLabel28.setText(guest);
                    i.jLabel34.setText(price);

                    // grn.jButton1.setText("Update Supplier");
                    //grn.jButton1.setEnabled(false);
                    this.dispose();
                }

            }
        }
        {
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        String text = jTextField1.getText();
        loadCustomers(text);
    }//GEN-LAST:event_jTextField1KeyReleased

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
            java.util.logging.Logger.getLogger(ViewCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewCustomers dialog = new ViewCustomers(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
