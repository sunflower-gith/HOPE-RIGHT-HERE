/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import phuongtien.JDBCHelper;
import thucthe.DanhMucSach;
import java.sql.ResultSet;

/**
 *
 * @author Thanh Lam
 */
public class DanhMucSachDAO extends DAO<DanhMucSach, String> {

    final String INSERT_SQL = "INSERT INTO LoaiSach(MaLS, TenLS) VALUES (?, ?)";
    final String UPDATE_SQL = "UPDATE LoaiSach SET TenLS = ? WHERE MaLS = ?";
    final String DELETE_SQL = "DELETE FROM LoaiSach WHERE MaLS = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM LoaiSach";
    final String SELECT_BY_ID_SQL = "SELECT * FROM LoaiSach WHERE MaLS = ?";

    @Override
    public void insert(DanhMucSach entity) {
        JDBCHelper.update(INSERT_SQL, entity.getMaLoaiSach(), entity.getTenLoaiSach());
    }

    @Override
    public void update(DanhMucSach entity) {
        JDBCHelper.update(UPDATE_SQL, entity.getTenLoaiSach(), entity.getMaLoaiSach());
    }

    @Override
    public void delete(String id) {
        JDBCHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<DanhMucSach> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public DanhMucSach selectById(String id) {
        List<DanhMucSach> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<DanhMucSach> selectBySql(String sql, Object... args) {
        List<DanhMucSach> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                DanhMucSach entity = new DanhMucSach();
                entity.setMaLoaiSach(rs.getString("MaLS"));
                entity.setTenLoaiSach(rs.getString("TenLS"));
                list.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }
}
