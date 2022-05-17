/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class Sua_Thong_Tin extends javax.swing.JFrame {

    Dao dao = new Dao();

    /**
     * Creates new form Sua_Thong_Tin
     */
    public Sua_Thong_Tin() {
        initComponents();
        this.setLocationRelativeTo(null);
        initForm();
    }

    public Sua_Thong_Tin(String id) {
        initComponents();
        this.setLocationRelativeTo(null);
        initForm();
        loadStuInfor(id);
        event();
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        epc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        stuclass = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        exitbtn = new javax.swing.JButton();
        savebtn = new javax.swing.JButton();
        sex = new javax.swing.JComboBox<>();
        birthday = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sửa Thông Tin");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mã Sinh Viên: ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 250, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("EPC:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        epc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(epc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 250, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Họ và Tên");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 250, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Ngày Sinh:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Lớp:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        stuclass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(stuclass, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 250, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Giới tính:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        exitbtn.setBackground(new java.awt.Color(255, 0, 0));
        exitbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        exitbtn.setForeground(new java.awt.Color(255, 255, 255));
        exitbtn.setText("Thoát");
        jPanel2.add(exitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 75, 25));

        savebtn.setBackground(new java.awt.Color(51, 204, 0));
        savebtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        savebtn.setForeground(new java.awt.Color(255, 255, 255));
        savebtn.setText("Lưu");
        jPanel2.add(savebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, -1, 25));

        sex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(sex, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 250, -1));
        jPanel2.add(birthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 250, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Sua_Thong_Tin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sua_Thong_Tin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sua_Thong_Tin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sua_Thong_Tin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sua_Thong_Tin("SV001").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser birthday;
    private javax.swing.JTextField epc;
    private javax.swing.JButton exitbtn;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField name;
    private javax.swing.JButton savebtn;
    private javax.swing.JComboBox<String> sex;
    private javax.swing.JTextField stuclass;
    // End of variables declaration//GEN-END:variables

    private void initForm() {
        sex.removeAllItems();
        sex.addItem("Nam");
        sex.addItem("Nữ");
    }

    private void loadStuInfor(String id) {
        Student stu = dao.getStudentById(id);
        if (stu == null) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin sinh viên");
            return;
        }
        Date date = null;

        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(stu.getBirthday());
        } catch (ParseException ex) {
            Logger.getLogger(Sua_Thong_Tin.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.id.setText(stu.getId());
        this.id.setEditable(false);
        this.epc.setText(stu.getEPC());
        this.name.setText(stu.getName());
        this.birthday.setDate(date);
        this.sex.setSelectedIndex(stu.getSex() ? 0 : 1);
        this.stuclass.setText(stu.getClasses());
    }

    private void event() {
        exitbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        savebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (epc.getText().compareTo("") == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập EPC");
                    return;
                }
                if (name.getText().compareTo("") == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập Họ tên");
                    return;
                }
                
                if (birthday.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn Ngày sinh");
                    return;
                }
                if (stuclass.getText().compareTo("") == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập Lớp");
                    return;
                }
                
                DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
                
                Student editStu = new Student(id.getText(),epc.getText(),name.getText(),dateformat.format(birthday.getDate()),(sex.getSelectedIndex() == 0) ? true:false,stuclass.getText());

                if(dao.updateStu(editStu)){
                    JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                }
            }
        });
    }
}
