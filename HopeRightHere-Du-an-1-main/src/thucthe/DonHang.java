/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thucthe;

import java.util.Date;

/**
 *
 * @author ACER
 */
public class DonHang {
    String maDH;
    Date ngayMua;
    String maNV;
    String trangThai;
    double tong;
        @Override
 public String toString() {
    return this.toString();
 }
    
    public double getTongTien() {
        return tong;   
    }

    public void setTongTien(double  tong) {
        this.tong = tong;
    }
    
    public DonHang() {
    }

    public DonHang(String maDH, Date ngayMua, String maNV, String trangThai) {
        this.maDH = maDH;
        this.ngayMua = ngayMua;
        this.maNV = maNV;
        this.trangThai = trangThai;
    }

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}