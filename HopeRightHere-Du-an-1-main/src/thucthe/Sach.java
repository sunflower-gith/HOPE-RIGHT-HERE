/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thucthe;

import java.awt.font.OpenType;
import java.util.Date;

/**
 *
 * @author Thanh Lam
 */
public class Sach {

    @Override
    public boolean equals(Object obj) {
        Sach target = (Sach) obj;
        if (target == null) return false;
        return target.getMaSach() == getMaSach();
    }
    private int maSach, soTrang, soLuong;
    private String maLoaiSach, tenSach, tacGia, nhaXuatBan, maNhanVien, hinh, moTa;
    private Date ngayXuatBan;
    private double giaNhap, giaBan;

    public Sach(int maSach) {
        this.maSach = maSach;
    }

    public Sach() {
    }

    public Sach(int maSach, int soTrang, int soLuong, String maLoaiSach, String tenSach, String tacGia, String nhaXuatBan, String maNhanVien, String hinh, String moTa, Date ngayXuatBan, double giaNhap, double giaBan) {
        this.maSach = maSach;
        this.soTrang = soTrang;
        this.soLuong = soLuong;
        this.maLoaiSach = maLoaiSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.nhaXuatBan = nhaXuatBan;
        this.maNhanVien = maNhanVien;
        this.hinh = hinh;
        this.moTa = moTa;
        this.ngayXuatBan = ngayXuatBan;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMaLoaiSach() {
        return maLoaiSach;
    }

    public void setMaLoaiSach(String maLoaiSach) {
        this.maLoaiSach = maLoaiSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Date getNgayXuatBan() {
        return ngayXuatBan;
    }

    public void setNgayXuatBan(Date ngayXuatBan) {
        this.ngayXuatBan = ngayXuatBan;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }
    @Override
    public String toString(){
        return this.tenSach;
    }
}
