/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author PC
 */
public class HB {
    public Connect con = new Connect();
    
    public ResultSet getDiemSV() throws SQLException{
        String sql = "Select MASV,MAMH,MAHP, DIEMQT, DIEMTHI, DIEMTK,KQ From KETQUA";
        System.err.println("getDiemSV: "+sql );
        return con.LoadData(sql);
    }
    
    public ResultSet getSVTop1() throws SQLException{
        String sql = "select TOP 1 sv.MASV,sv.HOTEN,sv.URLANH, kq.MAMH, kq.MAHP, kq.DIEMQT,kq.DIEMTHI,kq.DIEMTK,kq.KQ\n" +
" from SINHVIEN sv join KETQUA kq on sv.MASV = kq.MASV";
        System.err.println("getTop1: "+sql );
        return con.LoadData(sql);
    }
    
        public ResultSet getSV() throws SQLException{
        String sql = "select sv.MASV,sv.HOTEN,sv.URLANH, kq.MAMH, kq.MAHP, kq.DIEMQT,kq.DIEMTHI,kq.DIEMTK,kq.KQ\n" +
" from SINHVIEN sv join KETQUA kq on sv.MASV = kq.MASV";
        System.err.println("getTop1: "+sql );
        return con.LoadData(sql);
    }
    
    
    public ResultSet getKetQua(String masv) throws SQLException{
        String sql = "Select MASV,MAMH,MAHP, DIEMQT, DIEMTHI, DIEMTK,KQ From KETQUA  where MASV='"+masv+"'";
        System.err.println("getKetQua: "+sql );
        return con.LoadData(sql);
    }
    
    public ResultSet SearchData(String txtSearch) throws SQLException{
        String sql = "select sv.MASV,sv.HOTEN,sv.URLANH, kq.MAMH, kq.MAHP, kq.DIEMQT,kq.DIEMTHI,kq.DIEMTK,kq.KQ\n" +
" from SINHVIEN sv join KETQUA kq on sv.MASV = kq.MASV where sv.MASV like '%"+txtSearch+"%' or sv.HOTEN like N'%"+txtSearch+"%'";
        System.err.println("getTop1: "+sql );
        return con.LoadData(sql);
    }
                

    ResultSet showDiemSV() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
