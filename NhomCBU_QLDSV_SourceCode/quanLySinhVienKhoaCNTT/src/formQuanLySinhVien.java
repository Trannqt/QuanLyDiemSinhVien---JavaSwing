
import java.awt.Image;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DUY PC
 */
public final class formQuanLySinhVien extends javax.swing.JFrame {

    /**
     * Creates new form formQuanLySinhVien
     */
    int pos = 0;
    private final QuanLySinhVien quanlysinhvien = new QuanLySinhVien();
    private final Khoa khoa = new Khoa();
    private final LopHoc lop = new LopHoc();
    private final DefaultTableModel tableModel = new DefaultTableModel();
    private boolean check = true;
    String masosinhvien = null, hotensinhvien = null;
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String linkanh= null;
    public formQuanLySinhVien() throws SQLException {
        initComponents();
        String[] colsName = {"Mã sinh viên", "Tên sinh viên", "Ngày sinh", "Giới tính", "Quê quán", "Chỗ ở hiện nay", "Chuyên ngành", "Dân tộc", "Mã khoa", "Mã lớp"};
        tableModel.setColumnIdentifiers(colsName);
        tableSinhVien.setModel(tableModel);
//        ShowData();
        addComboboxKhoa();
        addComboboxLop();
//        ShowData(cbbKhoa.getSelectedItem().toString());
//        loadFirst();
    }
    
    public void addComboboxKhoa() throws SQLException {
//        Khoa khoa = new Khoa();0
        ResultSet res = khoa.ShowTenKhoa();
        while (res.next()) {
//            String makhoa = khoa.getMaKhoa(res.getString(1)).toString();
            cbbKhoa.addItem(res.getString(1));
//            cbbMaKhoa.setSelectedItem(makhoa);
//            System.err.println("get: "+makhoa+" "+cbbMaKhoa.getSelectedItem().toString());
        }
    }
    
    public void addComboboxLop() throws SQLException {
//        Khoa khoa = new Khoa();
        ResultSet res = lop.ShowTenLop();
        while (res.next()) {
//            String makhoa = khoa.getMaKhoa(res.getString(1)).toString();
            cbbLop.addItem(res.getString(1));
//            cbbMaKhoa.setSelectedItem(makhoa);
//            System.err.println("get: "+makhoa+" "+cbbMaKhoa.getSelectedItem().toString());
        }
    }
    
    private void setNull() {
        //Xoa trang cac JtextField
        this.txtHoTen.setText(null);
        this.txtMaSV.setText(null);
//        this.txtNgaySinh.setText(null);

        this.txtQueQuan.setText(null);
        this.txtChoO.setText(null);
//        this.txtGioTinh.setText(null);
        this.txtChuyenNganh.setText(null);
        this.txtDanToc.setText(null);
//        this.txtId.setText(null);

//       this.txtMaLopSV.setText(null); 
    }
    
    private void setKhoa(boolean a) {
        //Khoa hoac mo khoa cho Cac JTextField
        this.txtHoTen.setEnabled(!a);
        this.txtMaSV.setEnabled(!a);
//         this.txtNgaySinh.setEnabled(!a);
        this.txtQueQuan.setEnabled(!a);
        this.txtChoO.setEnabled(!a);
//        this.txtGt.setEnabled(!a);
//        this.txtGioTinh.setEnabled(!a);
        this.txtChuyenNganh.setEnabled(!a);
        this.txtDanToc.setEnabled(!a);
//        this.txtTim.setEnabled(a);
//        this.txtId.setEnabled(!a);
//        this.txtMaLopSV.setEnabled(!a);
    }
    
    private void setButton(boolean a) {
        //Vo hieu hoac co hieu luc cho cac JButton
        this.buttonThem.setEnabled(a);
        this.buttonXoa.setEnabled(a);
        this.buttonSua.setEnabled(a);
        this.buttonLuu.setEnabled(!a);
        this.buttonHuy.setEnabled(!a);
        this.buttonThoat.setEnabled(a);
//        this.txtTim.setEnabled(!a);
    }
    
    public void ClearData() throws SQLException {
        //Lay chi so dong cuoi cung
        int n = tableModel.getRowCount() - 1;
        for (int i = n; i >= 0; i--) {
            tableModel.removeRow(i);//Remove tung dong
        }
    }
    
    public void ShowData(String makhoa, String malop) throws SQLException, ParseException {
        
        ResultSet sv = quanlysinhvien.getSVByMaLop(malop);
        ClearData();
        String masv = null;
        int i = 0;
        while (sv.next()) {
            
            String rows[] = new String[10];
            rows[0] = sv.getString(1); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)      
//                masv=rows[0];

            showTheoMaSV(masv);
            
            rows[1] = sv.getString(2); // lấy dữ liệu tai cột số 2 ứng với tên hàng
            rows[2] = sv.getString(4);
            rows[3] = sv.getString(5);
            rows[4] = sv.getString(6);
            rows[5] = sv.getString(7);
            rows[6] = sv.getString(8);
            rows[7] = sv.getString(9);
            rows[8] = sv.getString(10);
            rows[9] = sv.getString(11);
            //            rows[3] = result.getString(4); 
            tableModel.addRow(rows); // đưa dòng dữ liệu vào tableModel
            //mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update
//                urlimage = result.getString(3);
        }
    }

    public String[] getImages() {
        File file;
        file = new File(getClass().getResource("/Images").getFile());
        String[] imgList = file.list();
        
        return imgList;
    }
    
    public String getImage(String img) {
        File file;
        file = new File(getClass().getResource("/Images").getFile());
//file = new File(getClass().getResource("/").getFile());
        String[] imgList = file.list();
        for (int i = 0; i < imgList.length; i++) {            
            String imgName = imgList[i];
            if (imgName.equals(img)) {
                return imgName;
            }
        }
        
        return null;
    }
    
    public void showImage(String img) {
//        String[] imgList = getImages();
//        String imgName = imgList[index];
//        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/"+imgName));
//        Image image = icon.getImage().getScaledInstance(label_Image.getWidth(), label_Image.getHeight(), Image.SCALE_SMOOTH);
//        label_Image.setIcon(new ImageIcon(image));
        try {
            System.err.println("imgname= "+img);
            String imgName = getImage(img);
            System.err.println("url: "+imgName);
            ImageIcon icon = new ImageIcon(getClass().getResource("/Images/" + imgName));
//ImageIcon icon = new ImageIcon(getClass().getResource(imgName));            
Image image = icon.getImage().getScaledInstance(label_Image.getWidth(), label_Image.getHeight(), Image.SCALE_SMOOTH);
            label_Image.setIcon(new ImageIcon(image));
        } catch (Exception e) {
            
            System.err.println("loi hinh anh");
//            JOptionPane.showMessageDialog(this, "Chưa cập nhật ảnh cho sinh viên này", "Thông báo", 1);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    public void showTheoMaSV(String m) throws SQLException, ParseException {
        ResultSet result = quanlysinhvien.getSVByID(m);
        try {
            while (result.next()) { // nếu còn đọc tiếp được một dòng dữ liệu

                txtMaSV.setText(result.getString(1)); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
                txtHoTen.setText(result.getString(2)); // lấy dữ liệu tai cột số 2 ứng với tên hàng

//                SimpleDateFormat sdf = new SimpleDateFormat();
                String txtDate = result.getString(4);

                try {
                    Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(txtDate);                    
                    System.out.println("\t" + date1);                    
                    datetimepicker.setDate(date1);
                } catch (Exception e) {
                    System.err.println("e: " + e);
                }
                String url = result.getString(3);
                
//                txtGioTinh.setText(result.getString(5));
                if(result.getString(5).equals("Nam")){
                    rdNam.setSelected(true);
                }
                else{
                    rdNu.setSelected(true);
                }
                txtQueQuan.setText(result.getString(6));
                txtChoO.setText(result.getString(7));
                txtChuyenNganh.setText(result.getString(8));
                txtDanToc.setText(result.getString(9));
                lableFileName.setText(result.getString(3));
//                txtKhoa.setText(result.getString(10));
//                txtMaLop.setText(result.getString(11));

                showImage(url);
//"Mã sinh viên", "Tên sinh viên", "Ngày sinh", "Giới tính", "Quê quán","Chỗ ở hiện nay","Chuyên ngành","Dân tộc","Mã khoa", "Mã lớp"
//            rows[3] = result.getString(4); 
                // đưa dòng dữ liệu vào tableModel
                //mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update
            }
        } catch (SQLException e) {
            System.err.println("loi: " + e);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSinhVien = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtMaSV = new javax.swing.JTextField();
        txtQueQuan = new javax.swing.JTextField();
        txtChoO = new javax.swing.JTextField();
        label_Image = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtChuyenNganh = new javax.swing.JTextField();
        txtDanToc = new javax.swing.JTextField();
        buttonThem = new javax.swing.JButton();
        buttonXoa = new javax.swing.JButton();
        buttonSua = new javax.swing.JButton();
        buttonLuu = new javax.swing.JButton();
        buttonHuy = new javax.swing.JButton();
        cbbKhoa = new javax.swing.JComboBox<String>();
        cbbLop = new javax.swing.JComboBox<String>();
        btnQLDiem = new javax.swing.JButton();
        buttonThoat = new javax.swing.JButton();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        btnUpLoadFile = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lableFileName = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        datetimepicker = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý sinh viên");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ SINH VIÊN");

        jLabel2.setText("Họ Tên");

        jLabel3.setText("Mã số sinh viên");

        jLabel4.setText("Ngày sinh");

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

        jLabel5.setText("Quê quán ");

        jLabel6.setText("Chỗ ở hiện tại");

        label_Image.setBackground(new java.awt.Color(255, 0, 51));
        label_Image.setForeground(new java.awt.Color(0, 0, 51));
        label_Image.setMaximumSize(new java.awt.Dimension(208, 212));
        label_Image.setMinimumSize(new java.awt.Dimension(208, 212));

        jLabel7.setText("Khoa");

        jLabel8.setText("Lớp");

        jLabel9.setText("Giới tính");

        jLabel10.setText("Chuyên Ngành");

        jLabel11.setText("Dân Tộc");

        txtChuyenNganh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChuyenNganhActionPerformed(evt);
            }
        });

        buttonThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add-1-icon-16p.png"))); // NOI18N
        buttonThem.setText("Thêm");
        buttonThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonThemActionPerformed(evt);
            }
        });

        buttonXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button-Close-icon-16p.png"))); // NOI18N
        buttonXoa.setText("Xóa");
        buttonXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonXoaActionPerformed(evt);
            }
        });

        buttonSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/note-edit-icon.png"))); // NOI18N
        buttonSua.setText("Sửa");
        buttonSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSuaActionPerformed(evt);
            }
        });

        buttonLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/floppy-icon-16.png"))); // NOI18N
        buttonLuu.setText("Lưu");
        buttonLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLuuActionPerformed(evt);
            }
        });

        buttonHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/arrow-return-180-left-icon.png"))); // NOI18N
        buttonHuy.setText("Hủy");
        buttonHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHuyActionPerformed(evt);
            }
        });

        cbbKhoa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbKhoaItemStateChanged(evt);
            }
        });

        cbbLop.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbLopItemStateChanged(evt);
            }
        });

        btnQLDiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/license-management-icon.png"))); // NOI18N
        btnQLDiem.setText("Quản lý điểm");
        btnQLDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLDiemActionPerformed(evt);
            }
        });

        buttonThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clipboard-sign-out-icon-16.png"))); // NOI18N
        buttonThoat.setText("Thoát");
        buttonThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonThoatActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdNam);
        rdNam.setText("Nam");

        buttonGroup1.add(rdNu);
        rdNu.setText("Nữ");

        btnUpLoadFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/upload-icon.png"))); // NOI18N
        btnUpLoadFile.setText("Tải ảnh lên");
        btnUpLoadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpLoadFileActionPerformed(evt);
            }
        });

        lableFileName.setColumns(20);
        lableFileName.setRows(5);
        jScrollPane2.setViewportView(lableFileName);

        jLabel12.setText("Đường dẫn ảnh");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(523, 523, 523)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(label_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(52, 52, 52)
                                    .addComponent(jLabel2))
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel3))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaSV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(datetimepicker, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbbKhoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbLop, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(rdNam)
                                .addGap(18, 18, 18)
                                .addComponent(rdNu))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtQueQuan, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtChoO, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel10))
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(txtChuyenNganh, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDanToc, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonSua, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonThoat))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonThem)
                        .addGap(18, 18, 18)
                        .addComponent(buttonLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnQLDiem)
                    .addComponent(btnUpLoadFile, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(141, 141, 141))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnQLDiem, btnUpLoadFile, buttonHuy, buttonLuu, buttonSua, buttonThem, buttonThoat, buttonXoa});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(buttonThem)
                                    .addComponent(buttonLuu))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(buttonXoa)
                                    .addComponent(buttonHuy)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMaSV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cbbKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel8)
                                            .addComponent(cbbLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(rdNam)
                                        .addComponent(rdNu))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(datetimepicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtChuyenNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel5)
                                .addComponent(buttonSua)
                                .addComponent(buttonThoat))
                            .addComponent(txtQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtChoO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDanToc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel6)
                            .addComponent(btnQLDiem))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel12))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnUpLoadFile)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnQLDiem, btnUpLoadFile, buttonHuy, buttonLuu, buttonSua, buttonThem, buttonThoat, buttonXoa});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtChuyenNganhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChuyenNganhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChuyenNganhActionPerformed

    private void tableSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSinhVienMouseClicked
        // TODO add your handling code here:
        try {
            //Lay chi so dong dang chon
            int row = this.tableSinhVien.getSelectedRow();
            String masv = (this.tableSinhVien.getModel().getValueAt(row, 0)).toString();
            String ht = (this.tableSinhVien.getModel().getValueAt(row, 1)).toString();
//            String m = (this.tableSinhVien.getModel().getValueAt(row, 5)).toString();
//            System.out.print(ml);
            showTheoMaSV(masv);//Goi ham lay du lieu theo ma loai
//            showCombobox(m);

            masosinhvien = masv;
            hotensinhvien = ht;
            
        } catch (SQLException e) {
        } catch (ParseException ex) {
            Logger.getLogger(formQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tableSinhVienMouseClicked
    
    public void clearCombobox() {
        cbbLop.removeAllItems();
    }
    
    public void showCbbLopTheoMaKhoa(String makhoa) throws SQLException {
        clearCombobox();
        
        ResultSet res = null;
        try {
            res = lop.showTenLopTheoMaKhoa(makhoa);
            try {
                while (res.next()) {
                    cbbLop.addItem(res.getString(1));
                }

//                System.err.println("chon cbb: "+cbbLop.getSelectedIndex());
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietSinhVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            String tenlop = cbbLop.getSelectedItem().toString();
            ResultSet ress = lop.getMaLopByTenLop(tenlop);
            String malop = null;
            while (ress.next()) {
                malop = ress.getString(1);
            }
            System.err.println("malop: " + malop);
            
            ResultSet sv = quanlysinhvien.getSVByMaLop(malop);
            ClearData();
            String masv = null;
            int i = 0;
            while (sv.next()) {
                
                String rows[] = new String[10];
                rows[0] = sv.getString(1); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)      
//                masv=rows[0];

                showTheoMaSV(masv);
                
                rows[1] = sv.getString(2); // lấy dữ liệu tai cột số 2 ứng với tên hàng
                rows[2] = sv.getString(4);
                rows[3] = sv.getString(5);
                rows[4] = sv.getString(6);
                rows[5] = sv.getString(7);
                rows[6] = sv.getString(8);
                rows[7] = sv.getString(9);
                rows[8] = sv.getString(10);
                rows[9] = sv.getString(11);
                //            rows[3] = result.getString(4); 
                tableModel.addRow(rows); // đưa dòng dữ liệu vào tableModel
                //mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update
//                urlimage = result.getString(3);
            }
        } catch (Exception ex) {
            System.err.println("error: " + ex);
        }
    }
    

    private void cbbKhoaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbKhoaItemStateChanged
        // TODO add your handling code here:
        String tenkhoa = cbbKhoa.getSelectedItem().toString();
        try {
            ResultSet res = khoa.getMakhoaByTenkhoa(tenkhoa);
            String makhoa = null;
            while (res.next()) {
                makhoa = res.getString(1);
            }
            
            showCbbLopTheoMaKhoa(makhoa);
            
        } catch (SQLException ex) {
            Logger.getLogger(formQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_cbbKhoaItemStateChanged
    
    public void getSinhVienbyMaLop(String malop) throws SQLException {
        String urlimage = null;
        ResultSet result = quanlysinhvien.getSVByMaLop(malop);
        try {
            while (result.next()) { // nếu còn đọc tiếp được một dòng dữ liệu
                String rows[] = new String[10];
                rows[0] = result.getString(1); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)      
//                masv=rows[0];
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
//                urlimage = result.getString(3);

//                ImageIcon icon = new ImageIcon(getClass().getResource("/Images/"+urlimage));
//            Image image = icon.getImage().getScaledInstance(label_Image.getWidth(), label_Image.getHeight(), Image.SCALE_SMOOTH);
//            label_Image.setIcon(new ImageIcon(image));
                showImage(urlimage);
            }
        } catch (SQLException e) {
        }
    }

    private void cbbLopItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbLopItemStateChanged
        // TODO add your handling code here:
        try {
            String tenlop = cbbLop.getSelectedItem().toString();
            System.err.println("t: " + tenlop);
            ResultSet ress = lop.getMaLopByTenLop(tenlop);
            String malop = null;
            while (ress.next()) {
                malop = ress.getString(1);
            }
            System.err.println("malop: " + malop);
            
            ResultSet sv = quanlysinhvien.getSVByMaLop(malop);
            ClearData();
            String masv = null;
            int i = 0;
            while (sv.next()) {
                
                String rows[] = new String[10];
                rows[0] = sv.getString(1); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)      
                masv = rows[0];
                if (i == 0) {
                    showTheoMaSV(masv);
                    i++;
                }
                rows[1] = sv.getString(2); // lấy dữ liệu tai cột số 2 ứng với tên hàng
                rows[2] = sv.getString(4);
                rows[3] = sv.getString(5);
                rows[4] = sv.getString(6);
                rows[5] = sv.getString(7);
                rows[6] = sv.getString(8);
                rows[7] = sv.getString(9);
                rows[8] = sv.getString(10);
                rows[9] = sv.getString(11);
                //            rows[3] = result.getString(4); 
                tableModel.addRow(rows); // đưa dòng dữ liệu vào tableModel
                //mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update
//                urlimage = result.getString(3);
            }
        } catch (Exception exx) {
            System.err.println("ex: " + exx);
        }
    }//GEN-LAST:event_cbbLopItemStateChanged

    private void buttonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonThemActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Bắt đầu thêm dữ liệu!", "Thông báo", 1);
        setNull();//Xoa trang TextField
        setKhoa(false);//Mo khoa TextField
//        this.txtTim.setEnabled(!a);
        setButton(false);//Goi ham khoa cac Button
        check = true;//Gan cothem = true de ghi nhan trang thai them moi 
    }//GEN-LAST:event_buttonThemActionPerformed

    private void buttonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonXoaActionPerformed
        // TODO add your handling code here:
        String ma = txtMaSV.getText();
        String tenkhoa = cbbKhoa.getSelectedItem().toString();
        String makhoa = null;
        try {
            ResultSet res = khoa.getMakhoaByTenkhoa(tenkhoa);
//            String makhoa = null;
            while (res.next()) {
                makhoa = res.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(formQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }        
        String tenlop = cbbLop.getSelectedItem().toString();
//            System.err.println("t: " + tenlop);
        ResultSet ress = null;
        try {
            ress = lop.getMaLopByTenLop(tenlop);
        } catch (SQLException ex) {
            Logger.getLogger(formQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        String malop = null;
        try {
            while (ress.next()) {
                malop = ress.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(formQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (ma.length() == 0) {
            JOptionPane.showMessageDialog(null, "Cần chọn 1 sinh viên để xoá", "Thông báo", 1);
        } else {
            if (JOptionPane.showConfirmDialog(null, "Bạn muốn xóa không?", "Thông báo", 2) == 0) {
                int i=0;
                try{
                    quanlysinhvien.DeleteData(ma);//goi ham xoa du lieu theo ma loaii
                    i++;
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(this, "Xóa điểm trước rồi xóa sinh viên!","Thông báo",1);
                }
                if(i!=0){
                    JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", 1);
                    try {
                        ClearData();//Xoa du lieu trong tableModel
                    } catch (SQLException ex) {
                        Logger.getLogger(formQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        ShowData(makhoa, malop);//Do du lieu vao table Model
                    } catch (SQLException ex) {
                        Logger.getLogger(formQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {
                        Logger.getLogger(formQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
//                    setNull();//Xoa trang Textfield
            }
        }
    }//GEN-LAST:event_buttonXoaActionPerformed

    private void buttonSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSuaActionPerformed
        // TODO add your handling code here:
        String mh = txtMaSV.getText();
        if (mh.length() == 0) //Chua chon Ma loai
        {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn giảng viên cần sửa", "Thôngg báo", 1);
        } else {
            setKhoa(false);//Mo khoa cac TextField
            setButton(false); //Khoa cac Button
            txtMaSV.enable(false);
            check = false; //Gan cothem=false de ghi nhan trang thai la sua
        }
    }//GEN-LAST:event_buttonSuaActionPerformed

    private void buttonHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHuyActionPerformed
        // TODO add your handling code here:
        setNull();
        setKhoa(false);
        setButton(true);
    }//GEN-LAST:event_buttonHuyActionPerformed

    private void buttonLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLuuActionPerformed
        // TODO add your handling code here:
        String ma = txtMaSV.getText();
        String hoten = txtHoTen.getText();
        String ngaysinh =  null;
        
        try{
            SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
            Date date = datetimepicker.getDate();
            ngaysinh = d.format(date);
//            ngaysinh=DateFormat.getInstance().format(ng);

        }catch(Exception e){
            System.err.println(e);
        }
        
        System.err.println("ngaysinh: "+ngaysinh);
        String gt = null;
        if(rdNam.isSelected()){
            gt="Nam";
        }
        else{
            gt="Nữ";
        }
        String quequan = txtQueQuan.getText();
        String choo = txtChoO.getText();
        String tenkhoa = cbbKhoa.getSelectedItem().toString();
        String makhoa = null;
        try {
            ResultSet res = khoa.getMakhoaByTenkhoa(tenkhoa);
//            String makhoa = null;
            while (res.next()) {
                makhoa = res.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(formQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }        
        String tenlop = cbbLop.getSelectedItem().toString();
//            System.err.println("t: " + tenlop);
        ResultSet ress = null;
        try {
            ress = lop.getMaLopByTenLop(tenlop);
        } catch (SQLException ex) {
            Logger.getLogger(formQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        String malop = null;
        try {
            while (ress.next()) {
                malop = ress.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(formQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.err.println("malop: " + malop);

//        String giotinh = txtGioTinh.getText();
        String chuyennganh = txtChuyenNganh.getText();
        String dantoc = txtDanToc.getText();
        
        System.err.println("makhoa: " + makhoa);
//        System.err.println(ma+" "+hoten+" "+ngaysinh);
        String lab = lableFileName.getText();
        if (ma.length() == 0 || hoten.length() == 0||lab.length()==0||lab.equals("null")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!", "Thông báo", 1);
        } else {
            try {
                if (check == true) //Luu cho tthem moi
                {
//                    Pattern regex  = Pattern.compile(emaila);
//                    Matcher matcher = regex.matcher(email);
                    quanlysinhvien.InsertData(ma, hoten,linkanh, ngaysinh, quequan, choo, makhoa, malop, gt, chuyennganh, dantoc);
                    JOptionPane.showMessageDialog(null, "Thêm thành công!", "Thông báo", 1);
                    setKhoa(false);
                    setButton(true);
                } else //Luu cho sua
                {
                    try {
                        System.err.println("linkanh: "+linkanh);
                    quanlysinhvien.EditData(ma, hoten,linkanh, ngaysinh, quequan, choo, makhoa, malop, gt, chuyennganh, dantoc);
                        JOptionPane.showMessageDialog(null, "Sửa thành công!", "Thông báo", 1);
                        setKhoa(false);
                        setButton(true);
                    } catch (Exception ee) {
                        System.err.println("errr: " + ee);
                    }
                }
                System.err.println("makhoa: " + makhoa);
                System.err.println("malop: " + malop);
                ClearData(); //lúc thêm sẽ add cả table=table+table, nên chúng ta phải xóa bớt 1 table chỉ giữ lại cái cuối cùng
                ShowData(makhoa, malop); //Do lai du lieu vao Table Model
            } catch (SQLException ex) {
//                System.err.println(txtMaLopSV.getSelectedItem());
                JOptionPane.showMessageDialog(null, ex, "Thông báo", 1);
            } catch (ParseException ex) {
                Logger.getLogger(formQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_buttonLuuActionPerformed

    private void btnQLDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLDiemActionPerformed
        // TODO add your handling code here:
        ChiTietSinhVien f = null;
        try {
            f = new ChiTietSinhVien(masosinhvien, hotensinhvien);
        } catch (SQLException ex) {
            Logger.getLogger(formQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        f.setVisible(true);
    }//GEN-LAST:event_btnQLDiemActionPerformed

    private void buttonThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonThoatActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_buttonThoatActionPerformed

    private void btnUpLoadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpLoadFileActionPerformed
        // TODO add your handling code here:
        try{
        JFileChooser chooser = new JFileChooser();
        
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        label_Image.setIcon(new ImageIcon(f.toString()));
        filename = f.getAbsolutePath();
        lableFileName.setText(filename);
        linkanh = lableFileName.getText();
     
        String link="";
        try{
        for(int i=linkanh.length()-1;i>=0;i--){
            
            if(linkanh.charAt(i)=='\\'){
               break;
            }
            else link=linkanh.charAt(i)+link;
        }
        linkanh=link;
        
        }
        catch(Exception e){
            System.err.println(e);
        }
        }catch(Exception ex){
            System.err.println("error: "+ex+" Không biết lỗi gì!");
        }
    }//GEN-LAST:event_btnUpLoadFileActionPerformed

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
            java.util.logging.Logger.getLogger(formQuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formQuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formQuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formQuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new formQuanLySinhVien().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(formQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQLDiem;
    private javax.swing.JButton btnUpLoadFile;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonHuy;
    private javax.swing.JButton buttonLuu;
    private javax.swing.JButton buttonSua;
    private javax.swing.JButton buttonThem;
    private javax.swing.JButton buttonThoat;
    private javax.swing.JButton buttonXoa;
    private javax.swing.JComboBox<String> cbbKhoa;
    private javax.swing.JComboBox<String> cbbLop;
    private com.toedter.calendar.JDateChooser datetimepicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_Image;
    private javax.swing.JTextArea lableFileName;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTable tableSinhVien;
    private javax.swing.JTextField txtChoO;
    private javax.swing.JTextField txtChuyenNganh;
    private javax.swing.JTextField txtDanToc;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtQueQuan;
    // End of variables declaration//GEN-END:variables

byte[] photo = null;
String filename=null;
}
