
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
public class ThongKe {
    public Connect con = new Connect();
    
    public ResultSet getDSSV(String masv) throws SQLException{
       con.connectSQL();
       
        String sql = "select DISTINCT  sv.MASV,sv.HOTEN, KHOA.TENKHOA, avg(kq.DIEMTK), sv.DIEMRENLUYEN\n" +
"from SINHVIEN sv join KETQUA kq on sv.MASV = kq.MASV \n" +
"join KHOA on sv.MAKHOA = KHOA.MAKHOA\n" +
"where sv.MASV='"+masv+"'\n" +
"group by sv.MASV,sv.HOTEN, KHOA.TENKHOA, sv.DIEMRENLUYEN";
        System.err.println("nhanhocbong: "+sql);
       return con.LoadData(sql);
    }
    
    

    public ResultSet getSVNhanHocBong(int hocky) throws SQLException{
       con.connectSQL();
       
        String sql = "select  sv.MASV,sv.HOTEN, KHOA.TENKHOA, avg(kq.DIEMTK), sv.DIEMRENLUYEN\n" +
"from SINHVIEN sv join KETQUA kq on sv.MASV = kq.MASV \n" +
"join MONHOC mh on kq.MAMH = mh.MAMH \n" +
"join HOCPHAN hp on hp.MAHP = kq.MAHP \n" +
"join KHOA on sv.MAKHOA = KHOA.MAKHOA\n" +
"where kq.KQ = 1 and hp.HOCKY="+hocky+" and sv.DIEMRENLUYEN>=70 \n" +
"group by sv.MASV,sv.HOTEN, KHOA.TENKHOA,sv.DIEMRENLUYEN\n" +
"having avg(kq.DIEMTK)>=8.0";
        System.err.println("kiemtra: "+sql);
       return con.LoadData(sql);
    }
    
    
    public ResultSet getSVRot(String makhoa) throws SQLException{
       con.connectSQL();
        String sql = "SELECT DISTINCT sv.MASV\n" +
 " from KHOA k join SINHVIEN sv on k.MAKHOA = sv.MAKHOA join KETQUA kq on sv.MASV = kq.MASV\n" +
" where k.MAKHOA='"+makhoa+"' and kq.KQ=0";
        System.err.println("getSVRot: "+sql);
       return con.LoadData(sql);
    }
    
    public ResultSet getSV(String makhoa) throws SQLException{
        con.connectSQL();
        String sql="select DISTINCT * from SINHVIEN where MAKHOA='"+makhoa+"'";
        System.err.println("tong: "+sql);
        return con.LoadData(sql);
    }
    
}
