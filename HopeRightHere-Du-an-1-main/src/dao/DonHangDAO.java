/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import phuongtien.JDBCHelper;
import thucthe.DonHang;
import java.sql.ResultSet;

/**
 *
 * @author ACER
 */
public class DonHangDAO extends DAO<DonHang, String> {
    
    final String INSERT_SQL = "INSERT INTO DonHang (MaDH, Ngaymua, MaNV, Trangthai) VALUES (?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE DonHang SET Ngaymua=?, MaNV=?, Trangthai=? WHERE MaDH=?";
    final String DELETE_SQL = "DELETE FROM DonHang WHERE MaDH=?";
    final String SELECT_ALL_SQL = "SELECT * FROM DonHang";
    final String SELECT_BY_ID_SQL = "SELECT * FROM DonHang WHERE MaDH = ?";
    @Override
    public void insert(DonHang entity) {
       JDBCHelper.update(INSERT_SQL, entity.getMaDH(),entity.getNgayMua(),entity.getMaNV(),entity.getTrangThai());
    }

    @Override
    public void update(DonHang entity) {
       JDBCHelper.update(UPDATE_SQL, entity.getNgayMua(), entity.getMaNV(), entity.getTrangThai(), entity.getMaDH());
    }

    @Override
    public void delete(String id) {
        JDBCHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<DonHang> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public DonHang selectById(String id) {
       List<DonHang> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<DonHang> selectBySql(String sql, Object... args) {
            List<DonHang> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                DonHang entity = new DonHang();
                entity.setMaDH(rs.getString("MaDH"));
                entity.setNgayMua(rs.getDate("Ngaymua"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setTrangThai(rs.getString("Trangthai"));
                entity.setTongTien(rs.getDouble("TongTien"));
                list.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }
       
     public List<DonHang> selectByKeyword(String keyword){
        String sql = "Select * from DonHang where MaDH like ?";
        return this.selectBySql(sql, "%"+keyword+"%");
    }
     
      public List<Integer> selectYears(){
         //truy vấn ds năm các khóa học được tạo ra
         String sql = "select distinct year(Ngaymua) from DonHang order by year(Ngaymua) desc";
         List<Integer> list = new ArrayList<>();
         try {
             ResultSet rs = JDBCHelper.query(sql);
             while(rs.next()){
                 list.add(rs.getInt(1));
             }
             rs.getStatement().getConnection().close();
             return list;
         } catch (Exception e) {
             e.printStackTrace();
             throw new RuntimeException(e);
         }
     }
      
       public List<DonHang> selectByTong(String maDH){
        String sql = "select d.MaDH, SUM(ct.Giatien*ct.Soluong) as TongTien, d.Ngaymua, d.MaNV, d.Trangthai " +
                        "from DonHang d " +
                        "join DonHangChiTiet ct on ct.MaDH = d.MaDH " +
                        "where d.MaDH like ? " +
                        "Group by d.MaDH,d.Ngaymua,d.MaNV,d.Trangthai ";
        return this.selectBySql(sql, "%"+maDH+"%");
    }
      
    
}
