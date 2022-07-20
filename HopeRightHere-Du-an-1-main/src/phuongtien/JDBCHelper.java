/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuongtien;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Thanh Lam
 */
public class JDBCHelper {
    private static String connec = "jdbc:sqlserver://localhost:1433;database=QLCuaHangSach";
    private static String username = "demo";
    private static String passwork = "123";
    public static void main(String[] args) {
        try {  
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
        } catch (Exception ex) {
           ex.printStackTrace();
        }  
    }
    public static PreparedStatement getstmt(String sql,Object...args) throws SQLException{
        Connection con = DriverManager.getConnection(connec,username,passwork);
        PreparedStatement pstm = null;
        if(sql.trim().startsWith("{")){
            pstm = con.prepareCall(sql);
        }else{
            pstm = con.prepareStatement(sql);
        }
        for(int i=0;i<args.length;i++){
            pstm.setObject(i+1, args[i]);
        }
        return pstm;    
    }
    public static int update(String sql,Object...args){
        try {
            PreparedStatement ps = getstmt(sql, args);
                try {
                    return ps.executeUpdate();
                } finally {
                    ps.getConnection().close();
                }     
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }    
    }
    public static ResultSet query(String sql,Object...args){
        try {
            PreparedStatement ps = getstmt(sql, args);
            return ps.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
    public static Object value(String sql,Object...args){
        
        try {
            ResultSet rs = query(sql, args);
            if(rs.next()){
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return null;
    }
}
