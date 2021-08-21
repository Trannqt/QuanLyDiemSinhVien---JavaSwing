
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
public class MonHoc {
    public Connect con = new Connect();
    
    public ResultSet ShowMaMonHoc() throws SQLException{
       con.connectSQL();
       String sql = "SELECT MAMH FROM MonHoc";
       return con.LoadData(sql);
    }
    
    //Truy van tat ca du lieu trong Table lop hoc
    public ResultSet ShowMonHoc() throws SQLException{
       con.connectSQL();
       String sql = "SELECT * FROM MonHoc";
       return con.LoadData(sql);
    }
    public ResultSet getMonHocByID(String mamh) throws SQLException{
       con.connectSQL();
       String sql = "SELECT * FROM MONHOC where MAMH ="+"\'" + mamh +"\'";
       return con.LoadData(sql);
    }

    //Theo moi 1 dong du lieu vao table LoaiSP
    public void InsertData(String mh, String tmh) throws SQLException{
       String sql = "INSERT INTO MONHOC values('" + mh +"',N'" + tmh+ "\')";
       con.UpdateData(sql);
    }
    //Dieu chinh 1 dong du lieu vao table LoaiSP
    public void EditData(String mh, String tmh) throws SQLException{
       String sql = "Update MONHOC set TenMH=N'" + tmh + "'" + "where MaMH='" + mh +"'";
       con.UpdateData(sql);
    }
    //Xoa 1 dong du lieu vao table LoaiSP
    public void DeleteData(String mh) throws SQLException{
       String sql = "Delete from MONHOC where MaMH='" + mh +"'";
       con.UpdateData(sql);
    }

}
