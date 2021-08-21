
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
public class Khoa {
    public Connect con = new Connect();

    public ResultSet getMakhoaByTenkhoa(String tenkhoa) throws SQLException {
        con.connectSQL();
        String sql = "SELECT MAKHOA FROM KHOA where TENKHOA=N'"+tenkhoa+"'";
        return con.LoadData(sql);
    }
    public ResultSet getKhoaByID(String mak) throws SQLException{
       con.connectSQL();
       String sql = "SELECT * FROM KHOA where MAKHOA ="+"\'" + mak +"\'";
       return con.LoadData(sql);
    }
    
    public ResultSet getMaKhoa(String tenkhoa) throws SQLException {
        con.connectSQL();
        String sql = "SELECT MAKHOA FROM KHOA where TENKHOA=N'"+tenkhoa+"'";
        return con.LoadData(sql);
    }
    public ResultSet getTenKhoa(String makhoa) throws SQLException {
        con.connectSQL();
        String sql = "SELECT TENKHOA FROM KHOA where MAKHOA=N'"+makhoa+"'";
        return con.LoadData(sql);
    }
    public ResultSet ShowTenKhoa() throws SQLException {
        con.connectSQL();
        String sql = "SELECT TENKHOA FROM KHOA";
        return con.LoadData(sql);
    }
    
    public ResultSet ShowMaKhoa() throws SQLException {
        con.connectSQL();
        String sql = "SELECT MAKHOA FROM KHOA";
        return con.LoadData(sql);
    }
    //Truy van tat ca du lieu trong Table lop hoc

    public ResultSet ShowKhoa() throws SQLException {
        con.connectSQL();
        String sql = "SELECT * FROM KHOA";
        return con.LoadData(sql);
    }

    public ResultSet getKhoa(String makhoa) throws SQLException {
        con.connectSQL();
        String sql = "SELECT * FROM KHOH where MAKHOA =" + "\'" + makhoa + "\'";
        return con.LoadData(sql);
    }

    //Theo moi 1 dong du lieu vao table LoaiSP
    public void InsertData(String mk, String tk, int ntl) throws SQLException {
        String sql = "INSERT INTO KHOA values('" + mk + "',N'" + tk + "'," + ntl + ")";
        con.UpdateData(sql);
    }

    //Dieu chinh 1 dong du lieu vao table LoaiSP

    public void EditData(String mk, String tk, int ntl) throws SQLException {
        String sql = "Update KHOA set TENKHOA=N'" + tk + "'" + ",NAMTHANHLAP=" + ntl + "where MAKHOA='" + mk + "'";
        con.UpdateData(sql);
    }

    //Xoa 1 dong du lieu vao table LoaiSP

    public void DeleteData(String mk) throws SQLException {
        String sql = "Delete from KHOA where MAKHOA='" + mk + "'";
        con.UpdateData(sql);
    }
}
