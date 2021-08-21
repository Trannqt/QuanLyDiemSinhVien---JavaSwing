
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author trannqt
 */
public class SinhVien {
    public Connect con = new Connect();

    public ResultSet getSVTop1() throws SQLException{
       con.connectSQL();
       String sql = "SELECT TOP 1 * FROM SinhVien";
       return con.LoadData(sql);
    }
    
    public ResultSet getSVByMaLop(String ml) throws SQLException{
       con.connectSQL();
//       String sql = "SELECT  FROM SINHVIEN where MASV ="+"\'" + masv +"\'";
       
       String sql = "Select * from SinhVien where MALOP='"+ml+"'";
       System.err.println("getSVByMaLop: "+sql);
       return con.LoadData(sql);
    }
    
    public ResultSet getTenSV(String ma) throws SQLException{
        con.connectSQL();
        String sql = "SELECT HOTEN from SinhVien where MaSV='"+ma+"'";      
        return con.LoadData(sql);
    }
    
    public ResultSet SearchData(String txtSearch)throws SQLException{ 
        String sql = "Select * from SINHVIEN where MaSV like N'%"+txtSearch+"%' or HOTEN like N'%"+txtSearch+"%'";
        System.err.println("SearchData: "+sql);
        return con.LoadData(sql);
    }
        
    public ResultSet showDiemSV(String masv) throws SQLException{
        con.connectSQL();
//        String sql = "SELECT HP.MAHP,MH.MAMH,K.DIEMQT,K.DIEMTHI,K.DIEMTK,K.KQ,K.MASV " +
//"FROM MONHOC MH, HOCPHAN HP, KETQUA K " +
//"WHERE K.MAMH like MH.MAMH AND HP.MAHP like MH.MAHP AND K.MASV like '"+masv+"'"; 

        String sql = "SELECT hp.MAHP,mh.MAMH,k.DIEMQT,k.DIEMTHI,k.DIEMTK,k.KQ,k.MASV from KETQUA k "
                + "join MONHOC mh on k.MAMH=mh.MAMH join HOCPHAN hp on mh.MAMH = hp.MAMH WHERE k.MASV like \'"+masv+"\'";
        return con.LoadData(sql);
    }
    
    //Truy van tat ca du lieu trong Table lop hoc
    public ResultSet ShowSV() throws SQLException{
       con.connectSQL();
       String sql = "SELECT * FROM SinhVien";
       return con.LoadData(sql);
    }
    public ResultSet getSVByID(String masv) throws SQLException{
       con.connectSQL();
       String sql = "SELECT * FROM SINHVIEN where MASV ="+"\'" + masv +"\'";
       return con.LoadData(sql);
    }

    //Theo moi 1 dong du lieu vao table LoaiSP
    public void InsertData(String ma, String hoten,String ngaysinh,String gioitinh, String dc, String malop) throws SQLException{
       String sql = "INSERT INTO SINHVIEN values('" + ma +"',N'" + hoten+ "\',"+ ngaysinh + "," + "N'" + gioitinh + "\',"
              + "N'"+dc+"\'," + "\'" + malop +"\')";
       con.UpdateData(sql);
    }
    //Dieu chinh 1 dong du lieu vao table LoaiSP
    public void EditData(String ma, String hoten,String ngaysinh,String gioitinh, String dc, String malop) throws SQLException{
       String sql = "Update SINHVIEN set HOTEN=N'" + hoten + "',NGAYSINH='"+ngaysinh+"',GIOITINH=N'"+gioitinh+"',DIACHI='"
               +dc+"',MALOP='"+malop+"'"
               + "where MaSV='" + ma +"'";
       con.UpdateData(sql);
    }
    //Xoa 1 dong du lieu vao table LoaiSP
    public void DeleteData(String ma) throws SQLException{
       String sql = "Delete from SINHVIEN where MaSV='" + ma +"'";
       con.UpdateData(sql);
    }

    
    ResultSet showDiemSV() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
