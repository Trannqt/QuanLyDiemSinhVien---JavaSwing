
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
public class ChiTietSinhVien extends javax.swing.JFrame {

    /**
     * Creates new form ChiTietSinhVien
     */
    private final ChiTietSV ctsv = new ChiTietSV();
    private final DefaultTableModel tableModel = new DefaultTableModel();
    private boolean check = true;
    private String mssv = null;
    private String ten = null;
    HocPhan hocphan = new HocPhan();

    public ChiTietSinhVien(String masv, String hoten) throws SQLException {
        initComponents();
//        ResultSet res = sinhvien.getTenSV(masv);
////        System.out.println(res.getString("HoTen"));
////        txtHoTenCT.setText(res.getString(2));
        mssv = masv;
        ten = hoten;
        txtHoTenCT.setText(mssv + " - " + ten);
        
        String[] colsName = {"Mã sinh viên", "Mã môn học", "Mã học phần", "Điểm quá trình", "Điểm thi", "Điểm tổng kết", "Kết quả"};
        tableModel.setColumnIdentifiers(colsName);
        tableChiTietSV.setModel(tableModel);
        ShowData();
        setNull();
        setKhoa(false);
        setButton(true);
        addComboboxMH();
        clearCombobox();
        addComboboxHPTheoMAMH(txtMamh.getSelectedItem().toString());
        txtMasv.setText(mssv);
        txtDiemTK.enable(false);
        txtKQ.enable(false);
        txtHoTenCT.enable(false);
    }
    
    public void addComboboxMH() throws SQLException{
        MonHoc monhoc = new MonHoc();
        ResultSet res = monhoc.ShowMaMonHoc();
        while(res.next()){
            txtMamh.addItem(res.getString(1));
        }
    }
    
    public void showComboboxMH(String mamh) throws SQLException{
        for(int i=0;i<txtMamh.getItemCount();i++){
            if(txtMamh.getItemAt(i).equals(mamh)){
                txtMamh.setSelectedIndex(i);
                System.err.println(txtMamh.getItemAt(i)+"");
                return;
            }
        }
    }
    
    
    public void addComboboxHPTheoMAMH(String mamh) throws SQLException{
        clearCombobox();
//        String mamh = txtMamh.getSelectedItem().toString();
        HocPhan hocphan = new HocPhan();
        ResultSet res = null;
        try {
            res = hocphan.ShowMaHocPhanTheoMH(mamh);
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(res.next()){
                txtMahp.addItem(res.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void clearCombobox(){
        txtMahp.removeAllItems();
    }
    public void showComboboxHP(String mahp) throws SQLException{
        for(int i=0;i<txtMahp.getItemCount();i++){
            if(txtMahp.getItemAt(i).equals(mahp)){
                txtMahp.setSelectedIndex(i);
                System.err.println(txtMahp.getItemAt(i)+"");
                return;
            }
        }
    }

    public void ShowData() throws SQLException {
//        System.out.println(mssv);
        ResultSet result = ctsv.showDiemSVs(mssv);
        try {
            while (result.next()) { // nếu còn đọc tiếp được một dòng dữ liệu
                String rows[] = new String[7];
                rows[0] = result.getString(1); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
                rows[1] = result.getString(2); // lấy dữ liệu tai cột số 2 ứng với tên hàng
                rows[2] = result.getString(3);
                rows[3] = result.getString(4);
                rows[4] = result.getString(5);
                rows[5] = result.getString(6);
                if(result.getString(7).equals("1"))
                    rows[6] = "Đậu" ;
                else rows[6] = "Rớt";
                
//                rows[6] = result.getString(7); 
//                rows[7] = result.getString(8); 
//                System.out.print(rows[4]);
                //            rows[3] = result.getString(4); 
                tableModel.addRow(rows); // đưa dòng dữ liệu vào tableModel
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableChiTietSV = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtHoTenCT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMasv = new javax.swing.JTextField();
        txtDiemqt = new javax.swing.JTextField();
        txtDiemthi = new javax.swing.JTextField();
        txtDiemTK = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtKQ = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnKhongluu = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtMamh = new javax.swing.JComboBox();
        txtMahp = new javax.swing.JComboBox();
        btnXoa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý điểm sinh viên");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("QUẢN LÝ ĐIỂM SINH VIÊN");

        tableChiTietSV.setModel(new javax.swing.table.DefaultTableModel(
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
        tableChiTietSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableChiTietSVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableChiTietSV);

        jLabel2.setText("Họ tên:");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        txtHoTenCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        jLabel3.setText("Mã sinh viên");

        jLabel4.setText("Mã môn học");

        jLabel5.setText("Mã học phần");

        jLabel6.setText("Điểm quá trình");

        jLabel7.setText("Điểm thi");

        jLabel8.setText("Điểm tổng kết");

        jLabel9.setText("Kết quả");

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add-1-icon-16p.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/note-edit-icon.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/floppy-icon-16.png"))); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnKhongluu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/arrow-return-180-left-icon.png"))); // NOI18N
        btnKhongluu.setText("Hủy");
        btnKhongluu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhongluuActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clipboard-sign-out-icon-16.png"))); // NOI18N
        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtMamh.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtMamhItemStateChanged(evt);
            }
        });
        txtMamh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMamhActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button-Close-icon-16p.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1)
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtMamh, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(115, 115, 115))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtMasv, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMahp, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(76, 76, 76)
                                                .addComponent(jLabel7))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addComponent(jLabel8)))))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDiemthi, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDiemTK, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(204, 204, 204)
                                .addComponent(jLabel6)
                                .addGap(27, 27, 27)
                                .addComponent(txtDiemqt, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtKQ, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnKhongluu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLuu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(253, 253, 253))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtHoTenCT, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnKhongluu, btnLuu, btnSua, btnThem, btnXoa, jButton1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtHoTenCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnLuu))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSua)
                            .addComponent(btnKhongluu))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtDiemqt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7)
                                    .addComponent(txtDiemthi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8)
                                    .addComponent(txtDiemTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMahp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtMamh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtKQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnKhongluu, btnLuu, btnSua, btnThem, btnXoa, jButton1});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void showTheoMa(String masv, String mamh, String mahp) throws SQLException {
        ResultSet result = ctsv.getSVByID(masv, mamh, mahp);
        try {
            while (result.next()) { // nếu còn đọc tiếp được một dòng dữ liệu

                txtMasv.setText(result.getString(1)); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
//                txtMamh.getSelectedItem(result.getString(2)); // lấy dữ liệu tai cột số 2 ứng với tên hàng
//                txtMahp.setText(result.getString(3));
                txtDiemqt.setText(result.getString(4));
                txtDiemthi.setText(result.getString(5));
                txtDiemTK.setText(result.getString(6));
                txtKQ.setText(result.getString(7));

    //            rows[3] = result.getString(4); 
                // đưa dòng dữ liệu vào tableModel
                //mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update
            }
        } catch (SQLException e) {
        }
    }
    
    public void showCbMH(String mh) throws SQLException{
        for(int i=0;i<txtMamh.getItemCount();i++){
            if(txtMamh.getItemAt(i).equals(mh)){
                txtMamh.setSelectedIndex(i);
                System.err.println(txtMamh.getItemAt(i)+"");
                return;
            }
        }
    }
    
    public void showCbHP(String hp) throws SQLException{
        for(int i=0;i<txtMahp.getItemCount();i++){
            if(txtMahp.getItemAt(i).equals(hp)){
                txtMahp.setSelectedIndex(i);
                System.err.println(txtMahp.getItemAt(i)+"");
                return;
            }
        }
    }

    private void tableChiTietSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableChiTietSVMouseClicked
        // TODO add your handling code here:
        //Hien thi du lieu len cac JTextField khi Click chuot vao JTable

        try {
            //Lay chi so dong dang chon
            int row = this.tableChiTietSV.getSelectedRow();
            String masv = (this.tableChiTietSV.getModel().getValueAt(row, 0)).toString();
            String mamh = (this.tableChiTietSV.getModel().getValueAt(row, 1)).toString();
            String mahp = (this.tableChiTietSV.getModel().getValueAt(row, 2)).toString();
            System.out.println(masv + " " + mamh + " " + mahp);
            
//            showTheoMa(masv,mamh,mahp);//Goi ham lay du lieu theo ma loai
            ResultSet result = ctsv.getSVByID(masv, mamh, mahp);
            try {
                while (result.next()) { // nếu còn đọc tiếp được một dòng dữ liệu

                    txtMasv.setText(result.getString(1)); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
                    String mh = result.getString(2); // lấy dữ liệu tai cột số 2 ứng với tên hàng
                    String hp = result.getString(3);
                    txtDiemqt.setText(result.getString(4));
                    txtDiemthi.setText(result.getString(5));
                    txtDiemTK.setText(result.getString(6));
                    String kq = result.getString(7);
                    System.err.println("KQ: "+kq);
                    if(kq.equals("1"))
                        txtKQ.setText("Đậu");
                    else txtKQ.setText("Rớt");

//                    txtKQ.setText(result.getString(7));
                    showCbMH(mh);
                    showCbHP(hp);
    //            rows[3] = result.getString(4); 
                    // đưa dòng dữ liệu vào tableModel
                    //mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update
                }
            } catch (SQLException e) {
                System.err.println("Khong co gi");
            }
        } catch (SQLException e) {
        }


    }//GEN-LAST:event_tableChiTietSVMouseClicked

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
        this.txtDiemTK.setText(null);
        this.txtDiemqt.setText(null);
        this.txtDiemthi.setText(null);
        this.txtKQ.setText(null);
//        this.txtMahp.setText(null);
//        this.txtMamh.setText(null);
//        this.txtMasv.setText(null);

    }

    //Ham khoa cac TextField

    private void setKhoa(boolean a) {
        //Khoa hoac mo khoa cho Cac JTextField
//        this.txtDiemTK.setEnabled(!a);
        this.txtDiemqt.setEnabled(!a);
        this.txtDiemthi.setEnabled(!a);
//        this.txtKQ.setEnabled(!a);
//        this.txtMahp.setEnabled(!a);
        this.txtMasv.setEnabled(!a);
    }

    //Ham khoa cac Button

    private void setButton(boolean a) {
        //Vo hieu hoac co hieu luc cho cac JButton
        this.btnLuu.setEnabled(a);
//        this.btnXoa.setEnabled (a);
        this.btnSua.setEnabled(a);
        this.btnLuu.setEnabled(!a);
        this.btnKhongluu.setEnabled(!a);
//     this.btThoat.setEnabled (a);
    }


    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:

        String masv = txtMasv.getText();
        String mamh = txtMamh.getSelectedItem().toString();
        String mahp = txtMahp.getSelectedItem().toString();

        if (masv.length() == 0 || mamh.length() == 0 || mahp.length() == 0) //Chua chon Ma loai
        {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn sinh viên cần sửa", "Thông báo", 1);
        } else {
            setKhoa(false);//Mo khoa cac TextField
            setButton(false); //Khoa cac Button
            txtMasv.enable(false);
            txtMahp.enable(false);
            txtMamh.enable(false);
            check = false; //Gan cothem=false de ghi nhan trang thai la sua
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        String masv = txtMasv.getText();
        String mamh = txtMamh.getSelectedItem().toString();
        String mahp = txtMahp.getSelectedItem().toString();
        float diemqt = Float.parseFloat(txtDiemqt.getText());
        float diemthi = Float.parseFloat(txtDiemthi.getText());
        float ptqt=0;
        HocPhan hp = new HocPhan();
        try {
            ResultSet res = hp.getPTQT(mahp);
            try{
                while(res.next()){
                    ptqt = Float.parseFloat(res.getString(1));
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, "Học phần chưa có phần trăm quá trình, mặc định sẽ là 50%","Thông báo",1);
                ptqt=50;
            }
            
        } catch (SQLException ex) {
            
            System.err.println("error: "+ex);
//            Logger.getLogger(ChiTietSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        System.err.println(ptqt+" ptqt");
        
     
        
        float diemtk = (diemqt*(ptqt/100))+(diemthi*(100-ptqt)/100);
        System.err.println(diemtk);
               
        int kq;
        if(diemtk<4.0)
            kq = 0;
        else
            kq=1;

        if (masv.length() == 0 || mamh.length() == 0 || mahp.length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!", "Thông báo", 1);
        } else {
            try {
                if (check == true) //Luu cho tthem moi
                {
                    ctsv.InsertData(masv, mamh, mahp, diemqt, diemthi, diemtk, kq);
                    JOptionPane.showMessageDialog(null, "Thêm thành công!", "Thông báo", 1);
                } else //Luu cho sua
                {
                    ctsv.EditData(masv, mamh, mahp, diemqt, diemthi, diemtk, kq);
                    JOptionPane.showMessageDialog(null, "Sửa thành công!", "Thông báo", 1);
                }

                ClearData(); //lúc thêm sẽ add cả table=table+table, nên chúng ta phải xóa bớt 1 table chỉ giữ lại cái cuối cùng
                ShowData(); //Do lai du lieu vao Table Model
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Cập nhật dữ liệu thất bại!", "Thông báo", 1);
            }
            setKhoa(false);
            setButton(true);
        }


    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnKhongluuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhongluuActionPerformed
        // TODO add your handling code here:
        txtMahp.enable(true);
        txtMamh.enable(true);
        setNull();
        setKhoa(false);
        setButton(true);
    }//GEN-LAST:event_btnKhongluuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtMamhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMamhActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtMamhActionPerformed

    private void txtMamhItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtMamhItemStateChanged
        // TODO add your handling code here:
        clearCombobox();
        String mamh = txtMamh.getSelectedItem().toString();
        
        ResultSet res = null;
        try {
            res = hocphan.ShowMaHocPhanTheoMH(mamh);
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(res.next()){
                txtMahp.addItem(res.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtMamhItemStateChanged

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        String ma = txtMasv.getText();
        String mamh = txtMamh.getSelectedItem().toString();
        String mahp = txtMahp.getSelectedItem().toString();
        try {
            if (ma.length() == 0) {
                JOptionPane.showMessageDialog(null, "Cần chọn 1 sinh viên để xoá", "Thông báo", 1);
            } else {
                if (JOptionPane.showConfirmDialog(null, "Bạn muốn xóa không?", "Thông báo", 2) == 0) {
                    ctsv.DeleteData(ma, mamh, mahp);//goi ham xoa du lieu theo ma loai
                    JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", 1);
                    ClearData();//Xoa du lieu trong tableModel
                    ShowData();//Do du lieu vao table Model
                    setNull();//Xoa trang Textfield
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(formMonHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        // TODO add your handling code here:
        setNull();//Xoa trang TextField
        setKhoa(false);//Mo khoa TextField
        setButton(false);//Goi ham khoa cac Button
        txtMasv.enable(false);
        check = true;//Gan cothem = true de ghi nhan trang thai them moi

    }//GEN-LAST:event_btnThemActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

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
            java.util.logging.Logger.getLogger(ChiTietSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ChiTietSinhVien("", "").setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietSinhVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKhongluu;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableChiTietSV;
    private javax.swing.JTextField txtDiemTK;
    private javax.swing.JTextField txtDiemqt;
    private javax.swing.JTextField txtDiemthi;
    private javax.swing.JTextField txtHoTenCT;
    private javax.swing.JTextField txtKQ;
    private javax.swing.JComboBox txtMahp;
    private javax.swing.JComboBox txtMamh;
    private javax.swing.JTextField txtMasv;
    // End of variables declaration//GEN-END:variables
}