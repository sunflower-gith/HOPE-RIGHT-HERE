/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import phuongtien.JDBCHelper;

/**
 *
 * @author ACER
 */
public class ThongKeDAO {
     private List<Object[]> getListOfArray(String sql, String[] cols, Object... agrs) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = JDBCHelper.query(sql, agrs);
            
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for(int i=0; i<cols.length;i++){
                    vals[i]= rs.getObject(cols[i]);
                }
                list.add(vals);
            } 
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getDoanhThu(Integer maKH) {
        String sql = "{CALL sp_DoanhThuSACH(?)}";
        String[] cols = {"TenLS","TienLai"};
        return this.getListOfArray(sql, cols, maKH);
    }

    public List<Object[]> getTop() {
        String sql = "{CALL sp_top}";
        String[] cols = {"TenLS","TenS","Soluong"};
        return this.getListOfArray(sql, cols);
    }

}
