use QLCHSach
go
--Bảng NhanVien
--Thêm mới
INSERT INTO NhanVien (MaNV, Matkhau, Hoten, SĐT, Vaitro, Hinh) VALUES (?, ?, ?, ?, ?.?)
 --1 là quản lý --0 là nhân viên
--Cập nhật theo mã 
UPDATE NhanVien SET Matkhau=?, Hoten=?, Vaitro=? WHERE MaNV=?
--Xóa theo mã 
DELETE FROM NhanVien WHERE MaNV=?
--Truy vấn tất cả 
SELECT * FROM NhanVien
--Truy vấn theo mã 
SELECT * FROM NhanVien WHERE MaNV=?

go
--Bảng LoaiSach
--Thêm mới
INSERT INTO LoaiSach(MaLS,TenLS) VALUES (?, ?)
--Cập nhật theo mã 
UPDATE LoaiSach SET TenLS MaLS=?
--Xóa theo mã 
DELETE FROM LoaiSach WHERE MaLS=?
--Truy vấn tất cả 
SELECT * FROM LoaiSach
--Truy vấn theo mã 
SELECT * FROM LoaiSach WHERE MaLS=?

go
--Bảng Sach
--Thêm mới
INSERT INTO Sach (MaLS, TenS, Tacgia, NXB, NSX, Sotrang, Soluong, Gianhap, Giaban, MaNV, Hinh, Mota) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
--Cập nhật theo mã 
UPDATE Sach SET MaLS=?, TenS=?, Tacgia=?, NXB=?, NSX=?, Sotrang=?, Soluong=?, Tiennhap=?, Tienban=?, MaNV=?, Hinh=?, Mota=? WHERE MaS=?
--Xóa theo mã 
DELETE FROM Sach WHERE MaS=?
--Truy vấn tất cả 
SELECT * FROM Sach
--Truy vấn theo mã 
SELECT * FROM Sach WHERE MaLS= ?

go
--Bảng DonHang
--Thêm mới
INSERT INTO DonHang (MaDH, Tongtien, Ngaymua, MaNV,Trangthai) VALUES (?, ?, ?, ?)
--Cập nhật theo mã 
UPDATE DonHang SET Tongtien=? , Ngaymua=? , MaNV=? , Trangthai=?  WHERE MaDH=?
--Xóa theo mã 
DELETE FROM DonHang WHERE MaDH=?
--Truy vấn tất cả 
SELECT * FROM DonHang
--Truy vấn theo mã 
SELECT * FROM DonHang WHERE MaDH=?
go
--Bảng DonHangChiTiet
--Thêm mới
INSERT INTO DonHangChiTiet (MaDH, MaLS, MaS, Tens, Soluong, Giatien, Ghichu) VALUES (?, ?, ?, ?, ?, ?, ?)
--Cập nhật theo mã 
UPDATE DonHangChiTiet SET MaDH=?, MaLS=?, MaS=? , Soluong=? , Giatien=?, Ghichu=?  WHERE MaDHCT=?
--Xóa theo mã 
DELETE FROM DonHangChiTiet WHERE MaDH=?
--Truy vấn tất cả 
SELECT * FROM DonHangChiTiet
--Truy vấn theo mã 
Select * from DonHangChiTiet where MaDH=?





