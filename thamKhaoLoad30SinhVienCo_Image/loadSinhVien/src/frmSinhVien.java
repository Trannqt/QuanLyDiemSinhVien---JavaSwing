
import java.awt.Image;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
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
public class frmSinhVien extends javax.swing.JFrame {

    /**
     * Creates new form frmSinhVien
     */
    int pos = 0;    
    private final SinhVien sinhvien = new SinhVien();
    private final DefaultTableModel tableModel = new DefaultTableModel();
    private boolean check = true;
    public frmSinhVien() throws SQLException {
        initComponents();
        
        String[] colsName = {"Mã sinh viên", "Tên sinh viên", "Ngày sinh", "Giới tính", "Quê quán","Chỗ ở hiện nay","Chuyên ngành","Dân tộc","Mã khoa", "Mã lớp"};
        tableModel.setColumnIdentifiers(colsName);
        tableSinhVien.setModel(tableModel);
        ShowData();
        loadFirst();
    }
    
     public void loadFirst() throws SQLException {
        String urlimage = null;
        String masv= null;
        ResultSet result = sinhvien.getSVTop1();
        try {
            while (result.next()) { // nếu còn đọc tiếp được một dòng dữ liệu
                String rows[] = new String[10];
                rows[0] = result.getString(1); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)      
                masv=rows[0];
                rows[1] = result.getString(2); // lấy dữ liệu tai cột số 2 ứng với tên hàng
                rows[2] = result.getString(4);
                rows[3] = result.getString(5);
                rows[4] = result.getString(6);
                rows[5] = result.getString(7);
                rows[6] = result.getString(8);
                rows[7] = result.getString(9);
                rows[8] = result.getString(10);
                rows[9] = result.getString(11);
                //            rows[3] = result.getString(4); 
//                tableModel.addRow(rows); // đưa dòng dữ liệu vào tableModel
                //mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update
                 urlimage = result.getString(3);
//                ImageIcon icon = new ImageIcon(getClass().getResource("/Images/"+urlimage));
//            Image image = icon.getImage().getScaledInstance(label_Image.getWidth(), label_Image.getHeight(), Image.SCALE_SMOOTH);
//            label_Image.setIcon(new ImageIcon(image));
//                showImage(urlimage);

            }
        } catch (SQLException e) {
        }
        if(urlimage!=null){
            System.err.println("link: "+getImage(urlimage));
            showImage(urlimage);
            showTheoMaSV(masv);
        }
        
    }
    
    
    public void ShowData() throws SQLException {
        String urlimage = null;
        ResultSet result = sinhvien.getSV();
        try {
            while (result.next()) { // nếu còn đọc tiếp được một dòng dữ liệu
                String rows[] = new String[10];
                rows[0] = result.getString(1); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)             
                rows[1] = result.getString(2); // lấy dữ liệu tai cột số 2 ứng với tên hàng
                rows[2] = result.getString(4);
                rows[3] = result.getString(5);
                rows[4] = result.getString(6);
                rows[5] = result.getString(7);
                rows[6] = result.getString(8);
                rows[7] = result.getString(9);
                rows[8] = result.getString(10);
                rows[9] = result.getString(11);
                //            rows[3] = result.getString(4); 
                tableModel.addRow(rows); // đưa dòng dữ liệu vào tableModel
                //mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update
                 urlimage = result.getString(3);
//                ImageIcon icon = new ImageIcon(getClass().getResource("/Images/"+urlimage));
//            Image image = icon.getImage().getScaledInstance(label_Image.getWidth(), label_Image.getHeight(), Image.SCALE_SMOOTH);
//            label_Image.setIcon(new ImageIcon(image));
//                showImage(urlimage);

            }
        } catch (SQLException e) {
        }
        if(urlimage!=null){
            System.err.println("link: "+getImage(urlimage));
            showImage(urlimage);
        }
        
    }
    
    public String[] getImages(){
        File file;
        file = new File(getClass().getResource("/Images").getFile());
        String[] imgList = file.list();
        
        return imgList;
    }
    
    public String getImage(String img){
        File file;
        file = new File(getClass().getResource("/Images").getFile());
        String[] imgList = file.list();
        
        for(int i=0;i<imgList.length;i++){
            
            String imgName = imgList[i];
            if(imgName.equals(img)){
                return imgName;
            }
        }
        
        return null;
    }
    
    public  void showImage(String img){
//        String[] imgList = getImages();
//        String imgName = imgList[index];
//        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/"+imgName));
//        Image image = icon.getImage().getScaledInstance(label_Image.getWidth(), label_Image.getHeight(), Image.SCALE_SMOOTH);
//        label_Image.setIcon(new ImageIcon(image));

        String imgName = getImage(img);
        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/"+imgName));
        Image image = icon.getImage().getScaledInstance(label_Image.getWidth(), label_Image.getHeight(), Image.SCALE_SMOOTH);
        label_Image.setIcon(new ImageIcon(image));
               
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_Image = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtGioiTinh = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtHovaTenSV = new javax.swing.JTextField();
        txtMssv = new javax.swing.JTextField();
        txtNgaySinhSV = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDiaChiSV = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtQueQuan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDanToc = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtChuyenNganh = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSinhVien = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtMaKhoa = new javax.swing.JTextField();
        txtMaLop = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("THÔNG TIN SINH VIÊN");

        jLabel2.setText("Họ và tên");

        jLabel3.setText("MSSV");

        jLabel9.setText("Mã lớp");

        jLabel4.setText("Chỗ ở hiện nay");

        jLabel7.setText("Ngày sinh");

        txtDiaChiSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiSVActionPerformed(evt);
            }
        });

        jLabel8.setText("Giới tính");

        jLabel5.setText("Quê quán");

        jLabel6.setText("Dân tộc");

        txtDanToc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDanTocActionPerformed(evt);
            }
        });

        jLabel10.setText("Chuyên ngành");

        tableSinhVien.setModel(new javax.swing.table.DefaultTableModel(
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
        tableSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSinhVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSinhVien);

        jLabel11.setText("Khoa");

        txtMaKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKhoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtQueQuan, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMssv, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgaySinhSV, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHovaTenSV, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDiaChiSV, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtGioiTinh)
                    .addComponent(txtChuyenNganh)
                    .addComponent(txtDanToc)
                    .addComponent(txtMaKhoa)
                    .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(300, 301, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(489, 489, 489))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtMaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtHovaTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel9)
                                            .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMssv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7)
                                            .addComponent(txtNgaySinhSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(3, 3, 3))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8))
                                        .addGap(4, 4, 4)))
                                .addGap(20, 20, 20))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_Image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtChuyenNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiaChiSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtDanToc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void showTheoMaSV(String m) throws SQLException {
        ResultSet result = sinhvien.getSVByID(m);
        try {
            while (result.next()) { // nếu còn đọc tiếp được một dòng dữ liệu

                txtMssv.setText(result.getString(1)); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
                txtHovaTenSV.setText(result.getString(2)); // lấy dữ liệu tai cột số 2 ứng với tên hàng
                txtNgaySinhSV.setText(result.getString(4));
                String url = result.getString(3);
                txtGioiTinh.setText(result.getString(5));
                txtQueQuan.setText(result.getString(6));
                txtDiaChiSV.setText(result.getString(7));
                txtChuyenNganh.setText(result.getString(8));
                txtDanToc.setText(result.getString(9));
                txtMaKhoa.setText(result.getString(10));
                txtMaLop.setText(result.getString(11));
                
                showImage(url);
//"Mã sinh viên", "Tên sinh viên", "Ngày sinh", "Giới tính", "Quê quán","Chỗ ở hiện nay","Chuyên ngành","Dân tộc","Mã khoa", "Mã lớp"
//            rows[3] = result.getString(4); 
                // đưa dòng dữ liệu vào tableModel
                //mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update
            }
        } catch (SQLException e) {
        }

    }
    
    private void tableSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSinhVienMouseClicked
        // TODO add your handling code here:
        try {
            //Lay chi so dong dang chon
            int row = this.tableSinhVien.getSelectedRow();
            String masv = (this.tableSinhVien.getModel().getValueAt(row, 0)).toString();
//            String m = (this.tableSinhVien.getModel().getValueAt(row, 5)).toString();
//            System.out.print(ml);
            showTheoMaSV(masv);//Goi ham lay du lieu theo ma loai
//            showCombobox(m);
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_tableSinhVienMouseClicked

    private void txtMaKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKhoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKhoaActionPerformed

    private void txtDanTocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDanTocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDanTocActionPerformed

    private void txtDiaChiSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiSVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiSVActionPerformed

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
            java.util.logging.Logger.getLogger(frmSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmSinhVien().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(frmSinhVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_Image;
    private javax.swing.JTable tableSinhVien;
    private javax.swing.JTextField txtChuyenNganh;
    private javax.swing.JTextField txtDanToc;
    private javax.swing.JTextField txtDiaChiSV;
    private javax.swing.JTextField txtGioiTinh;
    private javax.swing.JTextField txtHovaTenSV;
    private javax.swing.JTextField txtMaKhoa;
    private javax.swing.JTextField txtMaLop;
    private javax.swing.JTextField txtMssv;
    private javax.swing.JTextField txtNgaySinhSV;
    private javax.swing.JTextField txtQueQuan;
    // End of variables declaration//GEN-END:variables
}
