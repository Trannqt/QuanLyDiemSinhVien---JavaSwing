
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author trannqt
 */
public class formHocPhan extends javax.swing.JFrame {

    /**
     * Creates new form formHocPhan
     */
//    public formHocPhan() {
//        initComponents();
//    }
    private final HocPhan hocphan = new HocPhan();
    private final DefaultTableModel tableModel = new DefaultTableModel();
    private boolean check = true;

    public formHocPhan() throws SQLException {
        initComponents(); // Khởi tạo các components trên JFrame
        String[] colsName = {"Mã học phần", "Tên học phần", "Tín chỉ", "Học kỳ", "% quá trình", "Mã môn học"};
        tableModel.setColumnIdentifiers(colsName);
        tableHocPhan.setModel(tableModel);
        ShowData();
        addComboboxMH();
        setNull();
        setKhoa(false);
        setButton(true);
    }

    public void addComboboxMH() throws SQLException {
        MonHoc monhoc = new MonHoc();
        ResultSet res = monhoc.ShowMaMonHoc();
        while (res.next()) {
            txtMaMH.addItem(res.getString(1));
        }
    }

    public void showComboboxMH(String mamh) throws SQLException {
        for (int i = 0; i < txtMaMH.getItemCount(); i++) {
            if (txtMaMH.getItemAt(i).equals(mamh)) {
                txtMaMH.setSelectedIndex(i);
                System.err.println(txtMaMH.getItemAt(i) + "");
                return;
            }
        }
    }

    public void ShowData() throws SQLException {
        ResultSet result = hocphan.ShowHocPhan();
        try {
            while (result.next()) { // nếu còn đọc tiếp được một dòng dữ liệu
                String rows[] = new String[6];
                rows[0] = result.getString(1); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
                rows[1] = result.getString(2); // lấy dữ liệu tai cột số 2 ứng với tên hàng
                //            rows[3] = result.getString(4); 
                rows[2] = result.getString(3); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
                rows[3] = result.getString(4);
                rows[4] = result.getString(5); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
                rows[5] = result.getString(6);
                tableModel.addRow(rows); // đưa dòng dữ liệu vào tableModel
                //mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update
            }
        } catch (SQLException e) {
        }
    }

    //Ham xoa du lieu trong tableModel
    public void ClearData() throws SQLException {
        //Lay chi so dong cuoi cung
        int n = tableModel.getRowCount() - 1;
        for (int i = n; i >= 0; i--) {
            tableModel.removeRow(i);//Remove tung dong
        }
    }

    //Ham xoa cac TextField
    private void setNull() {
        //Xoa trang cac JtextField
//        this.txtMaHP1.setText(null);
        this.txtMaHP.setText(null);
        this.txtTenHP.setText(null);
        this.txtTinChiHP.setText(null);
        this.txtHocKyHP.setText(null);
        this.txtPtqtHP.setText(null);
//       this.txtMaMH.setText(null);
    }

    //Ham khoa cac TextField
    private void setKhoa(boolean a) {
        //Khoa hoac mo khoa cho Cac JTextField

//        this.txtMaHP1.setEnabled(!a);
        this.txtMaHP.setEnabled(!a);
        this.txtTenHP.setEnabled(!a);
        this.txtTinChiHP.setEnabled(!a);
        this.txtHocKyHP.setEnabled(!a);
        this.txtPtqtHP.setEnabled(!a);
        this.txtMaMH.setEnabled(!a);
    }

    //Ham khoa cac Button
    private void setButton(boolean a) {
        //Vo hieu hoac co hieu luc cho cac JButton
        this.btnLuuHP.setEnabled(a);
        this.btnXoaHP.setEnabled(a);
        this.btnSuaHP.setEnabled(a);
        this.btnLuuHP.setEnabled(!a);
        this.btnHuyHP.setEnabled(!a);
//     this.btThoat.setEnabled (a);
    }

    public void showTheoMaHP(String ml) throws SQLException {
        ResultSet result = hocphan.getHocPhanByID(ml);

        try {
            while (result.next()) { // nếu còn đọc tiếp được một dòng dữ liệu
//                String n=(String) txtMaMH.getSelectedItem();
//                txtMaHP1.setText(n);

//                System.err.println("err: " +n);
//                txtMaHP1.setText(result.getString(1));
                txtMaHP.setText(result.getString(1)); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
                txtTenHP.setText(result.getString(2)); // lấy dữ liệu tai cột số 2 ứng với tên hàng
                txtTinChiHP.setText(result.getString(3));
                txtHocKyHP.setText(result.getString(4));
                txtPtqtHP.setText(result.getString(5));
//            txtMaMH.setText(result.getString(6));
//            rows[3] = result.getString(4); 
                // đưa dòng dữ liệu vào tableModel
                //mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update
            }
        } catch (SQLException e) {
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

        txtMaHP1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHocPhan = new javax.swing.JTable();
        btnThemHP = new javax.swing.JButton();
        btnXoaHP = new javax.swing.JButton();
        btnSuaHP = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaHP = new javax.swing.JTextField();
        txtTenHP = new javax.swing.JTextField();
        txtTinChiHP = new javax.swing.JTextField();
        txtHocKyHP = new javax.swing.JTextField();
        txtPtqtHP = new javax.swing.JTextField();
        btnLuuHP = new javax.swing.JButton();
        btnHuyHP = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtMaMH = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý học phần");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("QUẢN LÝ HỌC PHẦN");

        tableHocPhan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableHocPhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableHocPhanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableHocPhan);

        btnThemHP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add-1-icon-16p.png"))); // NOI18N
        btnThemHP.setText("Thêm");
        btnThemHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHPActionPerformed(evt);
            }
        });

        btnXoaHP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button-Close-icon-16p.png"))); // NOI18N
        btnXoaHP.setText("Xóa");
        btnXoaHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHPActionPerformed(evt);
            }
        });

        btnSuaHP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/note-edit-icon.png"))); // NOI18N
        btnSuaHP.setText("Sửa");
        btnSuaHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaHPActionPerformed(evt);
            }
        });

        jLabel2.setText("Mã học phần");

        jLabel3.setText("Tên học phần");

        jLabel4.setText("Tín chỉ");

        jLabel5.setText("Học kỳ");

        jLabel6.setText("Mã môn học");

        jLabel7.setText("Phần trăm quá trình");

        btnLuuHP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/floppy-icon-16.png"))); // NOI18N
        btnLuuHP.setText("Lưu");
        btnLuuHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuHPActionPerformed(evt);
            }
        });

        btnHuyHP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/arrow-return-180-left-icon.png"))); // NOI18N
        btnHuyHP.setText("Hủy");
        btnHuyHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyHPActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clipboard-sign-out-icon-16.png"))); // NOI18N
        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTinChiHP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                            .addComponent(txtHocKyHP)
                            .addComponent(txtPtqtHP)
                            .addComponent(txtTenHP, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaMH, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaHP))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(btnSuaHP, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaHP, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemHP, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuuHP, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyHP, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnHuyHP, btnLuuHP, btnSuaHP, btnThemHP, btnXoaHP, jButton1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTinChiHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThemHP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaHP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuaHP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLuuHP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHuyHP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 161, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtHocKyHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPtqtHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnHuyHP, btnLuuHP, btnSuaHP, btnThemHP, btnXoaHP, jButton1});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tableHocPhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableHocPhanMouseClicked
        // TODO add your handling code here:

        //Hien thi du lieu len cac JTextField khi Click chuot vao JTable
        try {
            //Lay chi so dong dang chon
            int row = this.tableHocPhan.getSelectedRow();
            String ml = (this.tableHocPhan.getModel().getValueAt(row, 0)).toString();
            String m = (this.tableHocPhan.getModel().getValueAt(row, 5)).toString();
            //            System.out.print(ml);

            showTheoMaHP(ml);//Goi ham lay du lieu theo ma loai
            showComboboxMH(m);
//            if(rs.next())//Neu co du lieu
//            {
//            this.txtMaloai.setText(rs.getString("Maloai"));
//            this.txtTenloai.setText(rs.getString("Tenloai"));
//            }
        } catch (SQLException e) {
        }

    }//GEN-LAST:event_tableHocPhanMouseClicked

    private void btnThemHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHPActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Bắt đầu thêm dữ liệu!", "Thông báo", 1);

        setNull();//Xoa trang TextField
        setKhoa(false);//Mo khoa TextField
        setButton(false);//Goi ham khoa cac Button
        check = true;//Gan cothem = true de ghi nhan trang thai them moi

    }//GEN-LAST:event_btnThemHPActionPerformed

    private void btnXoaHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHPActionPerformed
        // TODO add your handling code here:
        String ma = txtMaHP.getText();
        try {
            if (ma.length() == 0) {
                JOptionPane.showMessageDialog(null, "Cần chọn 1 học phần để xoá", "Thông báo", 1);
            } else {
                if (JOptionPane.showConfirmDialog(null, "Bạn muốn xóa không?", "Thông báo", 2) == 0) {
                    hocphan.DeleteData(ma);//goi ham xoa du lieu theo ma loai
                    JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", 1);
                    ClearData();//Xoa du lieu trong tableModel
                    ShowData();//Do du lieu vao table Model
                    setNull();//Xoa trang Textfield
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(formMonHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaHPActionPerformed

    private void btnSuaHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaHPActionPerformed
        // TODO add your handling code here:
        String mh = txtMaHP.getText();
        if (mh.length() == 0) //Chua chon Ma loai
        {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn học phần cần sửa", "Thôngg báo", 1);
        } else {
            setKhoa(false);//Mo khoa cac TextField
            setButton(false); //Khoa cac Button
            txtMaHP.enable(false);
            check = false; //Gan cothem=false de ghi nhan trang thai la sua
        }

    }//GEN-LAST:event_btnSuaHPActionPerformed

    private void btnLuuHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuHPActionPerformed
        // TODO add your handling code here:
        String hp = txtMaHP.getText();
        String thp = txtTenHP.getText();
        int tc = 0, hk = 0, qt = 0;

        String ma = txtMaMH.getSelectedItem().toString();
        String mahp = null;
        String mamh = null;

        if (hp.length() == 0 || thp.length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!", "Thông báo", 1);
        } else {
            if (hp.length() < 2) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập mã học phần nhiều hơn 2 ký tự!", "Thông báo", 1);
            } else {
                mahp = hp.substring(0, 2);
                mamh = ma.substring(0, 2);

                if (mahp.equals(mamh)) {
                    try {
                        tc = Integer.parseInt(txtTinChiHP.getText());
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Tín chỉ chỉ được nhập số", "Thông báo", 1);
                    }

                    try {
                        hk = Integer.parseInt(txtHocKyHP.getText());
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Học kỳ chỉ được nhập số", "Thông báo", 1);
                    }

                    try {
                        if (!(txtPtqtHP.getText().equals(""))) {
                            qt = Integer.parseInt(txtPtqtHP.getText());
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Phần trăm quá trình chỉ được nhập số", "Thông báo", 1);
                    }
                    try {
                        if (check == true) //Luu cho tthem moi
                        {
                            hocphan.InsertData(hp, thp, tc, hk, qt, ma);
                            JOptionPane.showMessageDialog(null, "Thêm thành công!", "Thông báo", 1);
                            setKhoa(false);
                            setButton(true);
                        } else //Luu cho sua
                        {
                            hocphan.EditData(hp, thp, tc, hk, qt, ma);
                            JOptionPane.showMessageDialog(null, "Sửa thành công!", "Thông báo", 1);
                            setKhoa(false);
                            setButton(true);
                        }
                        ClearData(); //lúc thêm sẽ add cả table=table+table, nên chúng ta phải xóa bớt 1 table chỉ giữ lại cái cuối cùng
                        ShowData(); //Do lai du lieu vao Table Model
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Cập nhật dữ liệu thất bại!", "Thông báo", 1);
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Mã học phần không nằm trong môn học!", "Thông báo", 1);
                }
            }

        }


    }//GEN-LAST:event_btnLuuHPActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnHuyHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHPActionPerformed
        // TODO add your handling code here:
        setNull();
        setKhoa(false);
        setButton(true);
    }//GEN-LAST:event_btnHuyHPActionPerformed

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
            java.util.logging.Logger.getLogger(formHocPhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formHocPhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formHocPhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formHocPhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new formHocPhan().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(formHocPhan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyHP;
    private javax.swing.JButton btnLuuHP;
    private javax.swing.JButton btnSuaHP;
    private javax.swing.JButton btnThemHP;
    private javax.swing.JButton btnXoaHP;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableHocPhan;
    private javax.swing.JTextField txtHocKyHP;
    private javax.swing.JTextField txtMaHP;
    private javax.swing.JTextField txtMaHP1;
    private javax.swing.JComboBox txtMaMH;
    private javax.swing.JTextField txtPtqtHP;
    private javax.swing.JTextField txtTenHP;
    private javax.swing.JTextField txtTinChiHP;
    // End of variables declaration//GEN-END:variables
}
