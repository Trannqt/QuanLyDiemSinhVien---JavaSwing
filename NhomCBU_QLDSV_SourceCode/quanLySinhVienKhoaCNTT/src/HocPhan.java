
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
public class HocPhan {
    public Connect con = new Connect();
    
    public ResultSet getSinhVienRot(String masv,int hocky) throws SQLException{
        con.connectSQL();
        String sql = "select DISTINCT  sv.MASV\n" +
"from SINHVIEN sv join KETQUA kq on sv.MASV = kq.MASV \n" +
"join MONHOC mh on kq.MAMH = mh.MAMH \n" +
"join HOCPHAN hp on hp.MAHP = kq.MAHP \n" +
"join KHOA on sv.MAKHOA = KHOA.MAKHOA\n" +
"where kq.KQ = 0 and hp.HOCKY="+hocky +" and sv.MASV='"+masv+"'\n"+
"group by sv.MASV,sv.HOTEN, KHOA.TENKHOA";
        System.err.println("getsinhvienrot: "+sql);
        return con.LoadData(sql);
    }
    
    public ResultSet getHocKy() throws SQLException{
        con.connectSQL();
        String sql = "SELECT DISTINCT HOCKY FROM HocPhan";
        return con.LoadData(sql);
    }
    
    public ResultSet ShowMaHocPhanTheoMH(String mamh) throws SQLException{
        con.connectSQL();
        String sql = "SELECT MAHP FROM HocPhan WHERE MAMH='"+mamh+"'";
        return con.LoadData(sql);
    }
    
    public ResultSet ShowMaHocPhan() throws SQLException{
        con.connectSQL();
        String sql = "SELECT MAHP FROM HocPhan";
        return con.LoadData(sql);
    }
    
    //Truy van tat ca du lieu trong Table lop hoc
    public ResultSet ShowHocPhan() throws SQLException{
       con.connectSQL();
       String sql = "SELECT * FROM HocPhan";
       return con.LoadData(sql);
    }
 public ResultSet getHocPhanByID(String ma) throws SQLException{
    con.connectSQL();
    String sql = "SELECT * FROM HocPhan where MaHP ="+"\'" + ma +"\'";
    return con.LoadData(sql);
 }
 
 public ResultSet getPTQT(String ma) throws SQLException{
    con.connectSQL();
    String sql = "SELECT PTQUATRINH FROM HocPhan where MaHP ="+"\'" + ma +"\'";
     System.err.println("getPTQT: "+sql);
    return con.LoadData(sql);
 }
 
 //Theo moi 1 dong du lieu vao table LoaiSP
 public void InsertData(String ma, String ten,int tc, int hk,int pt,String mh) throws SQLException{
    String sql =null;
     if(pt==0){
         sql = "INSERT INTO HOCPHAN values('" + ma +"',N'" + ten+ "'," + tc + "," + hk + "," + null + "," + "\'" + mh + "\'" +")";
     }
     else
         sql = "INSERT INTO HOCPHAN values('" + ma +"',N'" + ten+ "'," + tc + "," + hk + "," + pt + "," + "\'" + mh + "\'" +")";
    con.UpdateData(sql);
 }
 //Dieu chinh 1 dong du lieu vao table LoaiSP
 public void EditData(String ma, String ten, int tc, int hk,int pt,String mh) throws SQLException{
    String sql =null;
     if(pt==0){
        sql = "Update HOCPHAN set TENHP=N'" + ten + "'," + "TINCHI=" + tc + ",HOCKY="+hk+",PTQUATRINH="+null
            + ",MAMH='"+mh+"'" +  "where MAHP='" + ma +"'";}
     else
         sql = "Update HOCPHAN set TENHP=N'" + ten + "'," + "TINCHI=" + tc + ",HOCKY="+hk+",PTQUATRINH="+pt
            + ",MAMH='"+mh+"'" +  "where MAHP='" + ma +"'";
     
    con.UpdateData(sql);
 }
 //Xoa 1 dong du lieu vao table LoaiSP
 public void DeleteData(String ma) throws SQLException{
    String sql = "Delete from HOCPHAN where MAHP='" + ma +"'";
    con.UpdateData(sql);
 }
}
