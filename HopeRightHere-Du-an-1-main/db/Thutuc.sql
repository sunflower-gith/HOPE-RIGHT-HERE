Use QLCuaHangSach
go
create proc sp_DoanhThuSACH(@Year int)
as begin
	select
		--ct.MaLS as Loaisach,
		ls.TenLS,
		SUM(( ct.Giatien  *ct.Soluong ) - ( s.Gianhap * ct.Soluong )) as TienLai
	from DonHangChiTiet ct 
	join DonHang d on ct.MaDH = d.MaDH
	join Sach s on s.MaS=ct.MaS
	join LoaiSach ls on ls.MaLS=ct.MaLS
	where YEAR(d.Ngaymua) = @Year
	Group by ct.MaLS,ls.TenLS
	order by TienLai desc
end
go

create proc sp_top
as 
begin
	Select Top 5 ls.TenLS,
				s.TenS, 
				Count(ct.Soluong) as Soluong
	from  DonHangChiTiet ct
	join Sach s on s.MaS = ct.MaS
	join LoaiSach ls on ls.MaLS = s.MaLS
	group by ls.TenLS,s.TenS
	order by Soluong desc
end

