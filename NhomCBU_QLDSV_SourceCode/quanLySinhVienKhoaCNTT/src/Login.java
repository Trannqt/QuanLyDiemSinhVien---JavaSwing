
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author trannqt
 */
public class Login {
    public Connect con = new Connect();
    
    public boolean check(String TkNhap,String MkNhap) throws SQLException{
        
        String sql = "Select ID,TENTK,MATKHAU,PHANQUYEN from TAIKHOAN where Tentk = \'"+TkNhap+"\'"+ " and Matkhau = \'"+MkNhap+"\'";
        ResultSet res = con.LoadData(sql);
        int i=0;
        while(res.next()){
            i++;
        }
        if(i>0)
                return true;
        else return false;
//        return statement.executeQuery(sql);
    }
    //Truy van tat ca du lieu trong Table lop hoc
    public ResultSet getUser(String TkNhap,String MkNhap) throws SQLException{
       con.connectSQL();
//       String sql = "SELECT * FROM TAIKHOAN Where TENTK = TKNhap and MATKHAU=MKNhap";
       String sql = "Select ID,TENTK,MATKHAU,PHANQUYEN from taikhoan where Tentk = \'"+TkNhap+"\'"+ " and Matkhau = \'"+MkNhap+"\'";
        System.out.println("Login.getUser(): "+ sql);
       return con.LoadData(sql);
    }
}
