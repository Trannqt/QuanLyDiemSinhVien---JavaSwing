
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
public class ChiTietSV {
    public Connect con = new Connect();

    public ResultSet showDiemSVs(String masv) throws SQLException{
        con.connectSQL();
//        String sql = "SELECT hp.MAHP,mh.MAMH,k.DIEMQT,k.DIEMTHI,k.DIEMTK,k.KQ,k.MASV from KETQUA k "
//                + "join MONHOC mh on k.MAMH=mh.MAMH join HOCPHAN hp on mh.MAMH = hp.MAMH WHERE k.MASV like \'"+masv+"\'";

        String sql = "Select * from KETQUA where MASV = '"+masv+"\'" ;
        return con.LoadData(sql);
    }
    public ResultSet ShowSV() throws SQLException{
       con.connectSQL();
       String sql = "SELECT * FROM SinhVien";
       return con.LoadData(sql);
    }
    //Theo moi 1 dong du lieu vao table LoaiSP
    public void InsertData(String ma, String mamh,String mahp,float diemqt, float diemthi, float diemtk,int kq) throws SQLException{
       String sql = "INSERT INTO KETQUA values('" + ma +"','" + mamh+ "','" + mahp+"'," + diemqt + "," + "" + diemthi + ","
              + diemtk+"," + kq +")";
       System.err.println("Insert: " +sql);
       con.UpdateData(sql);
    }
    //Dieu chinh 1 dong du lieu vao table LoaiSP
    public void EditData(String ma, String mamh,String mahp,float diemqt, float diemthi, float diemtk,int kq) throws SQLException{
       String sql = "Update KETQUA set DIEMQT=" + diemqt + ",DIEMTHI="+diemthi+",DIEMTK="+diemtk+",KQ="
               +kq+ " where MASV='" + ma +"' and MAMH='"+mamh+"' and MAHP='"+mahp+"\'";
       System.err.println("Edit: "+sql);
       con.UpdateData(sql);
    }
   
    
    public void DeleteData(String masv,String mamh, String mahp) throws SQLException{
        String sql = "Delete from KETQUA Where MASV='"+masv+"' and MAMH='"+mamh+"' and MAHP='"+mahp+"'";
        System.err.println("DeleteData: "+sql);
        con.UpdateData(sql);
    }
    
    
     public ResultSet getSVByID(String masv,String mamh, String mahp) throws SQLException{
       con.connectSQL();
//       String sql = "SELECT  FROM SINHVIEN where MASV ="+"\'" + masv +"\'";
       
       String sql = "select sv.MASV,sv.HOTEN, sv.URLANH, mh.mamh, hp.MAHP, kq.DIEMQT,kq.DIEMTHI,kq.DIEMTK,kq.KQ " +
"from ketqua kq join sinhvien sv on kq.masv = sv.masv " +
"join monhoc mh on kq.mamh=mh.mamh join hocphan hp on kq.mahp = hp.mahp " +
"where sv.MASV =" + "\'" + masv + "\'" + " and mh.MAMH=" + "\'" + mamh +"\'" + "and hp.MAHP=" + "\'"+ mahp +"\'";
       System.err.println(sql);
       return con.LoadData(sql);
    }

}
