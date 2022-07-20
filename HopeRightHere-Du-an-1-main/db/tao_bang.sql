create database QLCuaHangSach
go
use QLCuaHangSach
go

create table NhanVien 
(
	MaNV varchar(10) primary key not null,
	Matkhau varchar(50) not null,
	Hoten nvarchar(50) not null,
	SDT char(10),
	Vaitro bit not null,
	Hinh varchar(1000)
)
go

create table LoaiSach
(
	MaLS varchar(10) primary key not null,
	TenLS nvarchar(100) not null,	
)
go

create table Sach
(
	MaS int identity(1,1) primary key not null,
	MaLS varchar(10) not null,
	TenS nvarchar(300) not null,
	Tacgia nvarchar(150) not null,
	NXB nvarchar(100) not null,
	NSX date not null,
	Sotrang int not null,
	Soluong int not null,
	Gianhap float not null,
	Giaban	float not null,
	MaNV varchar(10) not null,
	Hinh nvarchar(1000),
	Mota nvarchar(1000),
	CHECK (Soluong >= 0 AND Sotrang > 0 AND Gianhap >= 0 AND Giaban >=0),
	foreign key(MaLS) references LoaiSach(MaLS) on delete no action on update cascade,
	foreign key(MaNV) references NhanVien(MaNV) on delete no action on update cascade
)
go
/*ALTER TABLE Sach 
ADD CONSTRAINT ktrSach CHECK (Soluong >= 0 AND Tiennhap >= 0 AND Tienban >=0);
ALTER TABLE Sach
ALTER COLUMN Hinh varchar(50)*/
go
create table DonHang
(
	MaDH varchar(10) primary key not null,
	Tongtien float not null,
	Ngaymua date not null,
	MaNV varchar(10) not null,
	CHECK (Tongtien >= 0),
	foreign key(MaNV) references NhanVien(MaNV) on delete no action on update cascade
)

ALTER TABLE DonHang
ALTER COLUMN Trangthai nvarchar(50)
ALTER TABLE DonHang
  DROP COLUMN TongTien;
go

create table DonHangChiTiet
(
	MaDHCT int identity(1,1) primary key not null,
	MaDH varchar(10) not null,
	MaLS varchar(10) not null,
	MaS int not null,
	Tens nvarchar(300),
	Soluong int not null,
	Giatien float not null,
	Ghichu nvarchar(1000),
	CHECK (Soluong >= 0 AND Giatien >= 0),
	foreign key(MaDH) references DonHang(MaDH) on delete cascade on update cascade,
	foreign key(MaS) references Sach(MaS) on delete no action,
	foreign key(MaLS) references LoaiSach(MaLS) on delete no action
)
go
