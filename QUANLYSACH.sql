CREATE TABLE DANHVINH_NHASANXUAT(
    NSX_ID NUMBER(4) NOT NULL PRIMARY KEY ,
    NXB_MA NUMBER(4) UNIQUE ,
    NXB_TEN VARCHAR2(30),
    TRANGTHAI NUMBER(1,0) ,
    NXB_DIACHI VARCHAR2(50),
    NXB_MOTA VARCHAR(50)

);
CREATE TABLE DANHVINH_TACGIA(
    TG_ID NUMBER(4) NOT NULL PRIMARY KEY,
    TG_MA NUMBER(4) UNIQUE,
    TG_TEN VARCHAR2(30),
    TG_SDT VARCHAR2(10),
    TG_DIACHI VARCHAR2(50),
    TG_MOTA VARCHAR2(50)
);
CREATE TABLE DANHVINH_SACH(
    SACH_ID NUMBER(4) NOT NULL PRIMARY KEY,
    SACH_MA NUMBER(4) UNIQUE,
    SACH_TEN VARCHAR2(50),
    SACH_CHUDE VARCHAR2(50),
    NSX_ID NUMBER(4),
    TG_ID NUMBER(4),
    NAMXUATBAN DATE,
    SACH_MOTA VARCHAR2(50),
    SO_LUONG_CON NUMBER(4),
    SO_LUONG_MUON NUMBER(4),
    TONG_SO_LUONG NUMBER(4),
    CONSTRAINT FK_NHASANXUAT_SACH FOREIGN KEY (NSX_ID) REFERENCES DANHVINH_NHASANXUAT(NSX_ID),
    CONSTRAINT FK_TACGIA_SACH FOREIGN KEY (TG_ID) REFERENCES DANHVINH_TACGIA(TG_ID)
);
CREATE TABLE DANHVINH_BANDOC(
    BD_ID NUMBER(4) NOT NULL PRIMARY KEY ,
    BD_MA NUMBER(4) UNIQUE,
    BD_TEN VARCHAR2(30),
    BD_SDT VARCHAR2(10),
    BD_DIACHI VARCHAR2(50),
    NGAY_SINH DATE,
    NGAY_TAO DATE,
    HANG NUMBER(1)
);
CREATE TABLE DANHVINH_MUONSACH(
    MS_ID NUMBER(4) NOT NULL PRIMARY KEY,
    BD_ID NUMBER(4),
    SACH_ID NUMBER(4),
    SO_LUONG NUMBER(4),
    NGAY_MUON DATE,
    NGAY_TRA DATE,
    MS_TRANG_THAI NUMBER(1,0),
    GHICHU VARCHAR2(100),
    CONSTRAINT FK_SACH_MUONSACH FOREIGN KEY (SACH_ID) REFERENCES DANHVINH_SACH(SACH_ID),
    CONSTRAINT FK_BANDOC_MUONSACHSACH FOREIGN KEY (BD_ID) REFERENCES DANHVINH_BANDOC(BD_ID)
);
-- BẢNG NHÀ XUẤT BẢN
INSERT INTO DANHVINH_NHASANXUAT(NSX_ID, NXB_MA, NXB_TEN, TRANGTHAI, NXB_DIACHI, NXB_MOTA)
            VALUES(1,1,N'SÁCH 1',0,N'HÀ NỘI','HAY');
INSERT INTO DANHVINH_NHASANXUAT(NSX_ID, NXB_MA, NXB_TEN, TRANGTHAI, NXB_DIACHI, NXB_MOTA)
VALUES(2,2,N'SÁCH 2',0,N'HÀ NỘI','HAY');
INSERT INTO DANHVINH_NHASANXUAT(NSX_ID, NXB_MA, NXB_TEN, TRANGTHAI, NXB_DIACHI, NXB_MOTA)
VALUES(3,3,N'SÁCH 3',0,N'HÀ NỘI','HAY');
INSERT INTO DANHVINH_NHASANXUAT(NSX_ID, NXB_MA, NXB_TEN, TRANGTHAI, NXB_DIACHI, NXB_MOTA)
VALUES(4,4,N'SÁCH 4',0,N'HÀ NỘI','HAY');
INSERT INTO DANHVINH_NHASANXUAT(NSX_ID, NXB_MA, NXB_TEN, TRANGTHAI, NXB_DIACHI, NXB_MOTA)
VALUES(5,5,N'SÁCH 5',0,N'HÀ NỘI','HAY');

-- BẢNG TÁC GIẢ
INSERT INTO DANHVINH_TACGIA(TG_ID, TG_MA, TG_TEN, TG_SDT, TG_DIACHI, TG_MOTA)
            VALUES(1,1,N'NGUYEN VAN A','0382385725',N'HÀ NỘI','ĐẸP');
INSERT INTO DANHVINH_TACGIA(TG_ID, TG_MA, TG_TEN, TG_SDT, TG_DIACHI, TG_MOTA)
            VALUES(2,2,N'NGUYEN VAN B','0345876985',N'PHÚ THỌ','KHÔNG');
INSERT INTO DANHVINH_TACGIA(TG_ID, TG_MA, TG_TEN, TG_SDT, TG_DIACHI, TG_MOTA)
            VALUES(3,3,N'NGUYEN VAN C','0387569875',N'HẢI PHÒNG','RẤT ĐẸP');
INSERT INTO DANHVINH_TACGIA(TG_ID, TG_MA, TG_TEN, TG_SDT, TG_DIACHI, TG_MOTA)
            VALUES(4,4,N'NGUYEN THI D','0365987562',N'VĨNH PHÚC','ĐẸP');
INSERT INTO DANHVINH_TACGIA(TG_ID, TG_MA, TG_TEN, TG_SDT, TG_DIACHI, TG_MOTA)
            VALUES(5,5,N'NGUYEN THI E','0587654236',N'THANH HÓA','ĐẸP');

-- BẢNG SÁCH
INSERT INTO DANHVINH_SACH(SACH_ID, SACH_MA, SACH_TEN, SACH_CHUDE, NSX_ID,
            TG_ID, NAMXUATBAN, SACH_MOTA, SO_LUONG_CON, SO_LUONG_MUON, TONG_SO_LUONG)
VALUES (1,1,N'TÊN SÁCH 1',N'TÌNH CẢM',1,1, TO_DATE('2020-10-10','YYYY-MM-DD'),N'HAY',100,50,150);
INSERT INTO DANHVINH_SACH(SACH_ID, SACH_MA, SACH_TEN, SACH_CHUDE, NSX_ID,
                          TG_ID, NAMXUATBAN, SACH_MOTA, SO_LUONG_CON, SO_LUONG_MUON, TONG_SO_LUONG)
VALUES (2,2,N'TÊN SÁCH 2',N'TÌNH CẢM 1',2,2,TO_DATE('2020-09-09','YYYY-MM-DD'),N'HAY',110,60,170);
INSERT INTO DANHVINH_SACH(SACH_ID, SACH_MA, SACH_TEN, SACH_CHUDE, NSX_ID,
                          TG_ID, NAMXUATBAN, SACH_MOTA, SO_LUONG_CON, SO_LUONG_MUON, TONG_SO_LUONG)
VALUES (3,3,N'TÊN SÁCH 3',N'TÌNH CẢM 2',3,3,TO_DATE('2020-09-09','YYYY-MM-DD'),N'HAY',101,52,153);
INSERT INTO DANHVINH_SACH(SACH_ID, SACH_MA, SACH_TEN, SACH_CHUDE, NSX_ID,
                          TG_ID, NAMXUATBAN, SACH_MOTA, SO_LUONG_CON, SO_LUONG_MUON, TONG_SO_LUONG)
VALUES (4,4,N'TÊN SÁCH 4',N'TÌNH CẢM 3',4,4,TO_DATE('2020-09-09','YYYY-MM-DD'),N'HAY',50,40,90);
INSERT INTO DANHVINH_SACH(SACH_ID, SACH_MA, SACH_TEN, SACH_CHUDE, NSX_ID,
                          TG_ID, NAMXUATBAN, SACH_MOTA, SO_LUONG_CON, SO_LUONG_MUON, TONG_SO_LUONG)
VALUES (5,5,N'TÊN SÁCH 5',N'TÌNH CẢM 4',5,5,TO_DATE('2020-09-09','YYYY-MM-DD'),N'HAY',100,80,180);

-- BẢNG BẠN ĐỌC
INSERT INTO DANHVINH_BANDOC(BD_ID, BD_MA, BD_TEN, BD_SDT,
                            BD_DIACHI, NGAY_SINH, NGAY_TAO, HANG)
VALUES (1,1,N'NGUYEN THI A','0357895462'
,N'HÀ NỘI',TO_DATE('2000-09-09','YYYY-MM-DD'),TO_DATE('2019-09-09','YYYY-MM-DD'),1);
INSERT INTO DANHVINH_BANDOC(BD_ID, BD_MA, BD_TEN, BD_SDT,
                            BD_DIACHI, NGAY_SINH, NGAY_TAO, HANG)
VALUES (2,2,N'NGUYEN THI b','0478965236'
       ,N'HÀ NỘI',TO_DATE('2000-08-09','YYYY-MM-DD'),TO_DATE('2020-09-09','YYYY-MM-DD'),2);
INSERT INTO DANHVINH_BANDOC(BD_ID, BD_MA, BD_TEN, BD_SDT,
                            BD_DIACHI, NGAY_SINH, NGAY_TAO, HANG)
VALUES (3,3,N'NGUYEN THI C','0354896523'
       ,N'HÀ NỘI',TO_DATE('2000-07-07','YYYY-MM-DD'),TO_DATE('2021-09-09','YYYY-MM-DD'),1);

-- BẢNG MƯỢN SÁCH
INSERT INTO DANHVINH_MUONSACH(MS_ID, BD_ID, SACH_ID, SO_LUONG,
                              NGAY_MUON, NGAY_TRA, MS_TRANG_THAI, GHICHU)
VALUES (1,1,1,10,TO_DATE('2019-07-07','YYYY-MM-DD'),TO_DATE('2019-08-08','YYYY-MM-DD'),0,N'KHÔNG');
INSERT INTO DANHVINH_MUONSACH(MS_ID, BD_ID, SACH_ID, SO_LUONG,
                              NGAY_MUON, NGAY_TRA, MS_TRANG_THAI, GHICHU)
VALUES (2,2,2,20,TO_DATE('2019-08-08','YYYY-MM-DD'),TO_DATE('2019-09-09','YYYY-MM-DD'),1,N'KHÔNG');
INSERT INTO DANHVINH_MUONSACH(MS_ID, BD_ID, SACH_ID, SO_LUONG,
                              NGAY_MUON, NGAY_TRA, MS_TRANG_THAI, GHICHU)
VALUES (3,3,4,15,TO_DATE('2019-08-06','YYYY-MM-DD'),TO_DATE('2019-10-10','YYYY-MM-DD'),0,N'KHÔNG');


-- CÂU 1
CREATE INDEX BANDOC_IDX_ID ON DANHVINH_BANDOC(BD_ID);
CREATE INDEX SACH_IDX_ID ON DANHVINH_SACH(SACH_ID);

-- CÂU 2.	Viết script tạo sequence cho mỗi bảng. Sequence được dùng để insert
-- trường Id cho các bảng. Tên sequence theo cấu trúc : TENBANG_SEQ
CREATE SEQUENCE DANHVINH_NHAXUATBAN_SEQ
    INCREMENT BY  1
    START WITH 1
    MINVALUE 1
    MAXVALUE 9999
;
CREATE SEQUENCE DANHVINH_TACGIA_SEQ
    INCREMENT BY  1
    START WITH 1
    MINVALUE 1
    MAXVALUE 9999
;
CREATE SEQUENCE DANHVINH_SACH_SEQ
    INCREMENT BY  1
    START WITH 1
    MINVALUE 1
    MAXVALUE 9999
;
CREATE SEQUENCE DANHVINH_BANDOC_SEQ
    INCREMENT BY  1
    START WITH 1
    MINVALUE 1
    MAXVALUE 9999
;
CREATE SEQUENCE DANHVINH_MUONSACH_SEQ
    INCREMENT BY  1
    START WITH 1
    MINVALUE 1
    MAXVALUE 9999
;

-- CÂU 5Hiển thị dách sách tác giả và tổng số lượng sách của tác giả gồm các trường thông tin:
-- Mã Tác Giả, Tên Tác Giả, Chủ Đề, Số Lượng Sách
-- Sắp xếp theo số lượng sách giảm dần.
SELECT TG_MA,TG_TEN,SACH_CHUDE,TONG_SO_LUONG
FROM DANHVINH_TACGIA JOIN DANHVINH_SACH DS on DANHVINH_TACGIA.TG_ID = DS.TG_ID
ORDER BY TONG_SO_LUONG DESC;

-- CÂU 6.	Hiển thị 10 quyển sách có số lượng được mượn nhiều nhất gồm các trường thông tin:
-- Mã Sách, Tên Sách, Tên Nhà Xuất Bản, Tên Tác Giả, Chủ Đề, Năm Xuất Bản, Số Lượng Còn Lại,
-- Số Lượng Đã Mượn, Tổng Số
SELECT SACH_MA,SACH_TEN,NXB_TEN,TG_TEN,SACH_CHUDE,NAMXUATBAN,SO_LUONG_CON,SO_LUONG_MUON,TONG_SO_LUONG
FROM DANHVINH_TACGIA JOIN DANHVINH_SACH ON DANHVINH_TACGIA.TG_ID = DANHVINH_SACH.TG_ID
                    JOIN DANHVINH_NHASANXUAT DN on DN.NSX_ID = DANHVINH_SACH.NSX_ID
WHERE ROWNUM < 3
ORDER BY SO_LUONG_CON DESC;
-- CÂU 7.Hiển thị  thông tin bạn đọc và sách được mượn từ ngày đầu tháng hiện tại đến
-- thời điểm hiện tại.
-- Mã Bạn Đọc, Tên Bạn Đọc, Mã Sách, Tên Sách, Ngày Giờ Mượn, Số lượng
-- Sắp xếp theo ngày giờ mượn giảm dần, Tên bạn đọc tăng dần.

Select BD_MA, BD_TEN, SACH_MA, SACH_TEN,NGAY_MUON,SO_LUONG
FROM DANHVINH_BANDOC JOIN DANHVINH_MUONSACH ON DANHVINH_BANDOC.BD_ID = DANHVINH_MUONSACH.BD_ID
JOIN DANHVINH_SACH ON DANHVINH_MUONSACH.SACH_ID = DANHVINH_SACH.SACH_ID
WHERE (SELECT TO_CHAR(TRUNC(SYSDATE),'MONTH') FROM DUAL) < (SELECT TO_CHAR(SYSDATE) FROM DUAL);

-- CAU 8.Hiển thị 10 quyển sách có số lượng được mượn nhiều nhất tính từ đầu năm 2022
-- Mã Sách, Tên Sách, Số Lượng Đã Được Mượn.
SELECT SACH_MA, SACH_TEN, SO_LUONG_MUON
FROM DANHVINH_SACH
WHERE (SELECT TO_CHAR(TRUNC(SYSDATE),'YEAR') FROM DUAL) < (SELECT TO_CHAR(SYSDATE) FROM DUAL)
AND ROWNUM < 10
ORDER BY SO_LUONG_MUON DESC;


-- CÂU 9.	Hiển thị danh sách bạn đọc và số lần mượn sách tính từ đầu năm 2022 sắp xếp theo
-- tên bạn đọc tăng dần:
-- Mã Bạn Đọc, Tên Bạn Đọc, Số Lần Mượn
SELECT BD_MA, BD_TEN,COUNT(BD_ID) SOLANMUON
FROM DANHVINH_BANDOC
WHERE (SELECT TO_CHAR(TRUNC(SYSDATE),'YEAR') FROM DUAL) < (SELECT TO_CHAR(SYSDATE) FROM DUAL)
GROUP BY BD_MA, BD_TEN
ORDER BY BD_TEN ASC;

--CÂU 10: Hiển thị thông tin bạn đọc gồm có:
--Mã Bạn Đọc, Tên Bạn Đọc, Tuổi (được tính dựa vào trường ngày sinh)
SELECT BD_MA,BD_TEN, TO_NUMBER(TO_CHAR(SYSDATE,'YYYY')) - TO_NUMBER(TO_CHAR(NGAY_SINH,'YYYY')) AS TUỔI
FROM DANHVINH_BANDOC;
--CÂU 11.	Thống kê tổng số bạn đọc theo độ tuổi
-- Tuổi, Tổng số Bạn Đọc
SELECT TO_NUMBER(TO_CHAR(SYSDATE,'YYYY')) - TO_NUMBER(TO_CHAR(NGAY_SINH,'YYYY')) AS TUỔI, COUNT(BD_ID) AS TONG_SO_BAN_DOC
FROM DANHVINH_BANDOC
GROUP BY TO_NUMBER(TO_CHAR(SYSDATE,'YYYY')) - TO_NUMBER(TO_CHAR(NGAY_SINH,'YYYY'));


