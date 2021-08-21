
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class GV {
    public Connect con = new Connect();

    
//    public ResultSet getSVByMaLop(String ml) throws SQLException{
//       con.connectSQL();
////       String sql = "SELECT  FROM SINHVIEN where MASV ="+"\'" + masv +"\'";
//       
//       String sql = "Select * from SinhVien where MALOP='"+ml+"'";
//       System.err.println("getSVByMaLop: "+sql);
//       return con.LoadData(sql);
//    }
    
    public ResultSet getTenGV(String ma) throws SQLException{
        con.connectSQL();
        String sql = "SELECT TENGV from GIANGVIEN where MaGV='"+ma+"'";      
        return con.LoadData(sql);
    }
    
    public ResultSet SearchData(String txtSearch)throws SQLException{ 
        String sql = "Select * from GIANGVIEN where MaGV like N'%"+txtSearch+"%' or TENGV like N'%"+txtSearch+"%'";
        System.err.println("SearchData: "+sql);
        return con.LoadData(sql);
    }
        
//    public ResultSet showDiemSV(String masv) throws SQLException{
//        con.connectSQL();
////        String sql = "SELECT HP.MAHP,MH.MAMH,K.DIEMQT,K.DIEMTHI,K.DIEMTK,K.KQ,K.MASV " +
////"FROM MONHOC MH, HOCPHAN HP, KETQUA K " +
////"WHERE K.MAMH like MH.MAMH AND HP.MAHP like MH.MAHP AND K.MASV like '"+masv+"'"; 
//
//        String sql = "SELECT hp.MAHP,mh.MAMH,k.DIEMQT,k.DIEMTHI,k.DIEMTK,k.KQ,k.MASV from KETQUA k "
//                + "join MONHOC mh on k.MAMH=mh.MAMH join HOCPHAN hp on mh.MAMH = hp.MAMH WHERE k.MASV like \'"+masv+"\'";
//        return con.LoadData(sql);
//    }
    
    //Truy van tat ca du lieu trong Table lop hoc
    public ResultSet ShowGV() throws SQLException{
       con.connectSQL();
       String sql = "SELECT * FROM GIANGVIEN";
       return con.LoadData(sql);
    }
    public ResultSet getGVByID(String masv) throws SQLException{
       con.connectSQL();
       String sql = "SELECT * FROM GIANGVIEN where MAGV ="+"\'" + masv +"\'";
       return con.LoadData(sql);
    }

    //Theo moi 1 dong du lieu vao table LoaiSP
    public void InsertData(String ma, String hoten,String gioitinh, String dc, String cv,String email,String id) throws SQLException{
       String sql = "INSERT INTO GIANGVIEN values('" + ma +"',N'" + hoten+ "\'," + "N'" + gioitinh + "\',"
              + "N'"+dc+"\',N'" + hoten+ "\','"+ email+"',"+ id +")";
       con.UpdateData(sql);
    }
    //Dieu chinh 1 dong du lieu vao table LoaiSP
    public void EditData(String ma, String hoten,String gioitinh, String dc, String cv,String email,String id) throws SQLException{
       String sql = "Update GIANGVIEN set TENGV=N'" + hoten + "',GIOITINH=N'"+gioitinh+"',DIACHI=N'"
               +dc+"',CHUCVU=N'" + cv + "',EMAIL='" + email + "',ID=" + id + " where MAGV='" + ma +"'";
       con.UpdateData(sql);
    }
//    '" + ma +"'";
    //Xoa 1 dong du lieu vao table LoaiSP
    public void DeleteData(String ma) throws SQLException{
       String sql = "Delete from GIANGVIEN where MAGV='" + ma +"'";
       con.UpdateData(sql);
    }

    
    ResultSet showDiemSV() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
