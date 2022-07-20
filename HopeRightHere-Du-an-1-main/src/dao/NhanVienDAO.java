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
import thucthe.NhanVien;

/**
 *
 * @author Thanh Lam
 */
public class NhanVienDAO extends DAO<NhanVien, String> {

    final String INSERT_SQL = "INSERT INTO NhanVien(MaNV, Matkhau, Hoten, SDT, Vaitro, Hinh) VALUES(?, ?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE NhanVien SET  MatKhau = ?, Hoten = ?, SDT = ?, Vaitro = ?, Hinh = ? WHERE MaNV = ?";
    final String DELETE_SQL = "DELETE FROM NhanVien WHERE MaNV = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM NhanVien";
    final String SELECT_BY_ID_SQL = "SELECT * FROM NhanVien WHERE MaNV = ?";

    @Override
    public void insert(NhanVien entity) {
        JDBCHelper.update(INSERT_SQL, entity.getMaNhanVien(), entity.getMatKhau(), entity.getHoTen(), entity.getSoDienThoai(), entity.isVaiTro(), entity.getHinh());
    }

    @Override
    public void update(NhanVien entity) {
        JDBCHelper.update(UPDATE_SQL, entity.getMatKhau(), entity.getHoTen(), entity.getSoDienThoai(), entity.isVaiTro(), entity.getHinh(), entity.getMaNhanVien());
    }

    @Override
    public void delete(String id) {
        JDBCHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<NhanVien> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NhanVien selectById(String id) {
        List<NhanVien> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setMaNhanVien(rs.getString("MaNV"));
                entity.setMatKhau(rs.getString("Matkhau"));
                entity.setHoTen(rs.getString("Hoten"));
                entity.setSoDienThoai(rs.getString("SDT"));
                entity.setVaiTro(rs.getBoolean("Vaitro"));
                entity.setHinh(rs.getString("Hinh"));
                list.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }

}
