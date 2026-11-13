/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class ConnectSQL {
public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://KHANHHUNG\\SQLSERVER102;databaseName=iPhoneQCStore;encrypt=true;trustServerCertificate=true;";
            String user = "sa";
            String password = "28042009";

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Kết nối thành công!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    public static void main(String[] args) {
        getConnection();
    }
}
