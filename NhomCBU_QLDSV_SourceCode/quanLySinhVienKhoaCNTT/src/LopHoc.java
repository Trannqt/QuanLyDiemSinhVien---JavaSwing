
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
public class LopHoc {

    public Connect con = new Connect();

    
    public ResultSet ShowTenLopHoc() throws SQLException {
        con.connectSQL();
        String sql = "SELECT TENLOP FROM LOP";
        return con.LoadData(sql);
    }
    
    public ResultSet ShowMaLopHoc() throws SQLException {
        con.connectSQL();
        String sql = "SELECT MALOP FROM LOP";
        return con.LoadData(sql);
    }

    //Truy van tat ca du lieu trong Table lop hoc

    public ResultSet ShowLopHoc(String makhoa) throws SQLException {
        con.connectSQL();
        String sql = "SELECT * FROM LOP Where MAKHOA='"+makhoa+"'";
        System.err.println("ShowLopHoc(makhoa): "+sql);
        return con.LoadData(sql);
    }
    
    public ResultSet showTenLopTheoMaKhoa(String makhoa) throws SQLException {
        con.connectSQL();
        String sql = "SELECT TENLOP FROM LOP where MAKHOA =" + "\'" + makhoa + "\'";
        return con.LoadData(sql);
    }
    
    public ResultSet getMaLopByTenLop(String tenlop) throws SQLException {
        con.connectSQL();
        String sql = "SELECT MALOP FROM LOP where TENLOP = N'" + tenlop + "\'";
        return con.LoadData(sql);
    }
    
    public ResultSet ShowTenLop() throws SQLException {
        con.connectSQL();
        String sql = "SELECT TENLOP FROM LOP";
        return con.LoadData(sql);
    }
    
    public ResultSet ShowLopHoc() throws SQLException {
        con.connectSQL();
        String sql = "SELECT * FROM LOP";
        return con.LoadData(sql);
    }

    public ResultSet getLop(String malop) throws SQLException {
        con.connectSQL();
        String sql = "SELECT * FROM LOP where MALOP =" + "\'" + malop + "\'";
        return con.LoadData(sql);
    }
    
    public ResultSet getLopByMaKhoa(String makhoa) throws SQLException {
        con.connectSQL();
        String sql = "SELECT * FROM LOP where MAKHOA =" + "\'" + makhoa + "\'";
        return con.LoadData(sql);
    }
    

    //Theo moi 1 dong du lieu vao table LoaiSP
    public void InsertData(String mk,String ml, String tl, int ss) throws SQLException {
        String sql = "INSERT INTO LOP values('" + ml + "',N'" + tl + "'," + ss + ",'"+mk+"')";
        con.UpdateData(sql);
    }

    //Dieu chinh 1 dong du lieu vao table LoaiSP

    public void EditData(String ml, String tl, int ss,String makhoa) throws SQLException {
        String sql = "Update Lop set TenLop=N'" + tl + "'" + ",SiSo=" + ss +",Makhoa='" +makhoa+ "' where MaLop='" + ml + "'";
        con.UpdateData(sql);
    }

    //Xoa 1 dong du lieu vao table LoaiSP

    public void DeleteData(String ml) throws SQLException {
        String sql = "Delete from LOP where MaLop='" + ml + "'";
        con.UpdateData(sql);
    }

}
