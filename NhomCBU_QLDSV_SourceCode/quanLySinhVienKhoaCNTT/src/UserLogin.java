
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
public class UserLogin {
     public Connect con = new Connect();

     
    public ResultSet getQuyenByIDUser(String ID) throws SQLException{
        String sql = "Select PHANQUYEN From TAIKHOAN where id='"+ID+"'";
        System.err.println("getQuyenByIDUser: "+sql );
        return con.LoadData(sql);
    }
    
     public ResultSet getQuyen() throws SQLException{
        String sql = "Select PHANQUYEN From TAIKHOAN";
        System.err.println("getQuyen: "+sql );
        return con.LoadData(sql);
    }
     
    public ResultSet showTheoQuyen(int quyen) throws SQLException{
        String sql = "Select ID, TENTK From TAIKHOAN where PHANQUYEN="+quyen;
        System.err.println("showTheoQuyen: "+sql );
        return con.LoadData(sql);
    }
     
     
    public ResultSet SearchData(String txtSearch)throws SQLException{ 
        String sql = "Select ID, TENTK from TAIKHOAN where ID like N'%"+txtSearch+"%' or TENTK like N'%"+txtSearch+"%'";
        System.err.println("SearchData: "+sql);
        return con.LoadData(sql);
    }
        
    public ResultSet getUser() throws SQLException{
        String sql = "Select ID, TENTK From TAIKHOAN";
        System.err.println("getUser: "+sql );
        return con.LoadData(sql);
    }
    
    public ResultSet getUserByID(String id) throws SQLException{
        String sql = "Select ID, TENTK From TAIKHOAN where ID='"+id+"'";
        System.err.println("getUserbyid: "+sql );
        return con.LoadData(sql);
    }
     
    public void InsertData(String id,String tentk, String mk, int quyen) throws SQLException{
       String sql = "INSERT INTO TAIKHOAN values('" + id +"','" + tentk+ "','"+mk+"',"+quyen+")";
        System.err.println("insert: "+sql);
       con.UpdateData(sql);
    }
    
    public void EditData(String id, String tentk,String mk,int quyen) throws SQLException{
       String sql = "Update TAIKHOAN set id='" + id + "',tentk='"+tentk+"',matkhau='"+mk+"',phanquyen="
               +quyen+"where id='" + id +"'";
       con.UpdateData(sql);
    }
    //Xoa 1 dong du lieu vao table LoaiSP
    public void DeleteData(String id) throws SQLException{
       String sql = "Delete from TAIKHOAN where id='" + id +"'";
       con.UpdateData(sql);
    }
}
