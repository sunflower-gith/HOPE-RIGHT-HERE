/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import phuongtien.JDBCHelper;
import thucthe.Sach;
import java.sql.ResultSet;

/**
 *
 * @author Thanh Lam
 */
public class SachDAO extends DAO<Sach, Integer> {

    final String INSERT_SQL = "INSERT INTO Sach (MaLS, TenS, Tacgia, NXB, NSX, Sotrang, Soluong, Gianhap, Giaban, MaNV, Hinh, Mota) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE Sach SET MaLS = ?, TenS = ?, NXB = ?, NSX = ?, Sotrang = ?, Soluong = ?, Gianhap = ?, Giaban = ?, MaNV = ?, Hinh = ?, Mota = ? WHERE MaS = ?";
    final String DELETE_SQL = "DELETE FROM Sach WHERE MaS = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM Sach";
    final String SELECT_BY_ID_SQL = "SELECT * FROM  Sach WHERE MaS = ?";
    final String UPDATE_SOLUONG_BY_ID_SQL = "update sach set soluong = soluong - ?  WHERE MaS = ?";
    @Override
    public void insert(Sach entity) {
        JDBCHelper.update(INSERT_SQL, entity.getMaLoaiSach(), entity.getTenSach(), entity.getTacGia(), entity.getNhaXuatBan(), entity.getNgayXuatBan(), entity.getSoTrang(), entity.getSoLuong(), entity.getGiaNhap(), entity.getGiaBan(), entity.getMaNhanVien(), entity.getHinh(), entity.getMoTa());
    }

    @Override
    public void update(Sach entity) {
        JDBCHelper.update(UPDATE_SQL, entity.getMaLoaiSach(), entity.getTenSach(), entity.getNhaXuatBan(), entity.getNgayXuatBan(), entity.getSoTrang(), entity.getSoLuong(), entity.getGiaNhap(), entity.getGiaBan(), entity.getMaNhanVien(), entity.getHinh(), entity.getMoTa(), entity.getMaSach());
    }
    public void update(int soluongMua, int masach) {
        JDBCHelper.update(UPDATE_SOLUONG_BY_ID_SQL, soluongMua, masach);
    }

    @Override
    public void delete(Integer id) {
        JDBCHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<Sach> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public Sach selectById(Integer id) {
        List<Sach> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Sach> selectBySql(String sql, Object... args) {
        List<Sach> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                Sach entity = new Sach();
                entity.setMaSach(rs.getInt("MaS"));
                entity.setMaLoaiSach(rs.getString("MaLS"));
                entity.setTenSach(rs.getString("TenS"));
                entity.setTacGia(rs.getString("Tacgia"));
                entity.setNhaXuatBan(rs.getString("NXB"));
                entity.setNgayXuatBan(rs.getDate("NSX"));
                entity.setSoTrang(rs.getInt("Sotrang"));
                entity.setSoLuong(rs.getInt("Soluong"));
                entity.setGiaNhap(rs.getDouble("Gianhap"));
                entity.setGiaBan(rs.getDouble("Giaban"));
                entity.setMaNhanVien(rs.getString("MaNV"));
                entity.setHinh(rs.getString("Hinh"));
                entity.setMoTa(rs.getString("Mota"));
                list.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Sach> selectByLoaiSach(String maLS, String keyword) {
        String sql = "SELECT * FROM Sach WHERE MaLS = ? AND TenS LIKE ?";
        return this.selectBySql(sql, maLS,'%'+keyword+'%');
    }
    
    public List<Sach> selectByLoaiSachDH(String maLS) {
        String sql = "SELECT * FROM Sach WHERE MaLS=?";
        return this.selectBySql(sql, maLS);
    }
    
    /* public List<Sach> selectByUpdate(int maS) {
        String sql = "update Sach set Soluong = 100 - (select SUm(Soluong) from DonHangChiTiet where DonHangChiTiet.MaS=Sach.MaS)\n" +
"where Sach.MaS = ?";
        return this.selectBySql(sql, maS);
    }*/
}
