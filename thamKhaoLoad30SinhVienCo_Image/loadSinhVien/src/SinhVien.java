
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
       return con.LoadData(sql);
    }
}
