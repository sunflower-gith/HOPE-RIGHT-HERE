/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thucthe;

/**
 *
 * @author ACER
 */
public class DonHangCT {
    int maDHCT;
    String maDH;
    String maLs;
    int maS;
    String tenS;
    int soLuong;
    double giaBan;
    String ghiChu;
  
    public double getTongTienCT() {
        return this.soLuong*this.giaBan;
    } 
 
   
    public DonHangCT() {
    }

    public DonHangCT(int maDHCT, String maDH, String maLs, int maS, String tenS, int soLuong, double giaBan, String ghiChu) {
        this.maDHCT = maDHCT;
        this.maDH = maDH;
        this.maLs = maLs;
        this.maS = maS;
        this.tenS = tenS;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.ghiChu = ghiChu;
    
    }

    public int getMaDHCT() {
        return maDHCT;
    }

    public void setMaDHCT(int maDHCT) {
        this.maDHCT = maDHCT;
    }

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public String getMaLs() {
        return maLs;
    }

    public void setMaLs(String maLs) {
        this.maLs = maLs;
    }

    public int getMaS() {
        return maS;
    }

    public void setMaS(int maS) {
        this.maS = maS;
    }

    public String getTenS() {
        return tenS;
    }

    public void setTenS(String tenS) {
        this.tenS = tenS;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

   
}
