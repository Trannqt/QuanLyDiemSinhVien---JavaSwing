
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DUY PC
 */
public class QuanLySinhVien {
     public Connect con = new Connect();
    
     public ResultSet getSVByMaLop(String ml) throws SQLException{
       con.connectSQL();
//       String sql = "SELECT  FROM SINHVIEN where MASV ="+"\'" + masv +"\'";
       
       String sql = "Select * from SinhVien where MALOP='"+ml+"'";
       System.err.println("getSVByMaLop: "+sql);
       return con.LoadData(sql);
    }
    //Truy van tat ca du lieu trong Table lop hoc
    public ResultSet getSV() throws SQLException{
       con.connectSQL();
       String sql = "SELECT * FROM SinhVien";
       return con.LoadData(sql);
    }
    
    public ResultSet getSVTop1() throws SQLException{
       con.connectSQL();
       String sql = "SELECT TOP 1 * FROM SinhVien";
       return con.LoadData(sql);
    }
    

    public ResultSet getSVByID(String masv) throws SQLException{
       con.connectSQL();
       String sql = "SELECT * FROM SINHVIEN where MASV ="+"\'" + masv +"\'";
        System.err.println("getSVBYID: "+sql );
       return con.LoadData(sql);
    }
    
    public void DeleteData(String ma) throws SQLException{
       String sql = "Delete from SINHVIEN where MASV='" + ma +"'";
        System.err.println("xoa: "+sql);
       con.UpdateData(sql);
    }
    public void InsertData(String ma, String hoten,String link,String ngaysinh,String quequan,String choo, String khoa,String malop,String giotinh,String chuyennganh,String dantoc) throws SQLException{
    String sql = "INSERT INTO SINHVIEN(MASV,HOTEN,URLANH,NGAYSINH,QUEQUAN,CHOOHIENTAI,MAKHOA,MALOP,GIOITINH,CHUYENNGANH,DANTOC) values('" + ma +"',N'" + hoten+ "','"+ link +"','" + ngaysinh + "',N'" + quequan + "',N'" + choo + "','" + khoa + "','" + malop+ "',N'" +giotinh+ "',N'" +chuyennganh+ "',N'" +dantoc + "')";
        System.err.println("insertData: "+sql);
    con.UpdateData(sql);
 }
    public void EditData(String ma, String hoten,String link,String ngaysinh,String quequan,String choo, String khoa,String malop,String giotinh,String chuyennganh,String dantoc) throws SQLException{
    String sql = "Update SINHVIEN set MASV='" + ma + "', HOTEN=N'" + hoten + "',URLANH='"+link+"',NGAYSINH='"+ ngaysinh +"',GIOITINH=N'"+ giotinh +"',QUEQUAN=N'"+ quequan + "',CHOOHIENTAI=N'"+choo+"',CHUYENNGANH=N'"+chuyennganh+ "',DANTOC=N'"+dantoc+"',MAKHOA='"+khoa+"',MALOP='"+malop+"' WHERE MASV='" + ma +"'";
    System.err.println("editData: "+sql);
    con.UpdateData(sql);
 }
}
