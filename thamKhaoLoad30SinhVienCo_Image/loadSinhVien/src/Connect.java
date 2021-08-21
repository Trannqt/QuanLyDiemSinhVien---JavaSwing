
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author trannqt
 */
public class Connect {
    Connection con;
    public Connect() {
        connectSQL();
    }

    public boolean connectSQL() {
       try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databaseName=_DB_QLSV; integratedSecurity=true");
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex.getMessage());
            con = null;
            return false;
        }
        return true;
    }

//    Phuong thuc dung de truy van CSDL
    public ResultSet LoadData(String sql) throws SQLException {
         Statement statement = con.createStatement();
        return statement.executeQuery(sql);
    }
    //Phuong thuc thuc hien Them, Xoa, Sua du lieu

    public int UpdateData(String sql) throws SQLException {
        PreparedStatement stm = con.prepareStatement(sql);
        return stm.executeUpdate();
    }
}
