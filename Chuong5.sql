--Chương 5
-- CÂU 1: Hiển thị toàn bộ tên nhân viên và tên phòng ban làm việc sắp xếp theo tên phòng
-- ban
SELECT ENAME, DNAME
FROM EMP join DEPT on EMP.DEPTNO = DEPT.DEPTNO
ORDER BY DNAME asc;

--CÂU 2 Hiển thị tên nhân viên, vị trí địa lý, tên phòng với điều kiện lương >1500.
SELECT ENAME, LOC,DNAME
FROM EMP join DEPT on EMP.DEPTNO = DEPT.DEPTNO
WHERE SAL > 1500;
-- Câu 3: Hiển thị tên nhân viên, nghề nghiệp, lương và mức lương
SELECT ENAME,JOB, GRADE
From EMP E, SALGRADE S
WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL;

-- Câu 4: Hiển thị tên nhân viên, nghề nghiệp, lương và mức lương, với điều kiện mức
-- lương=3
SELECT ENAME,JOB, GRADE
From EMP E, SALGRADE S
WHERE S.GRADE =3;

-- Câu 5: Hiển thị những nhân viên tại DALLAS
SELECT ENAME, LOC,SAL
FROM EMP join DEPT D on EMP.DEPTNO = D.DEPTNO
WHERE LOC = 'DALLAS';


--Câu 6: Hiển thị tên nhân viên , nghề nghiệp, lương, mức lương, tên phòng làm việc trừ nhân
--viên có nghề là cleck và sắp xếp theo chiều giảm.
SELECT ENAME,JOB,DNAME,SAL,GRADE
FROM EMP JOIN DEPT on EMP.DEPTNO = DEPT.DEPTNO,SALGRADE
WHERE JOB NOT IN 'CLERK' AND  SAL  BETWEEN  LOSAL AND HISAL
ORDER BY JOB DESC;
-- CÂU 7: Hiển thị chi tiết về những nhân viên kiếm được 36000 $ 1 năm hoặc nghề là cleck.
-- (gồm các trường tên, nghề, thu nhập, mã phòng, tên phòng, mức lương)
SELECT ENAME, JOB,DNAME,(SAL*12),EMP.DEPTNO,DNAME,GRADE
FROM EMP join DEPT on EMP.DEPTNO = DEPT.DEPTNO , SALGRADE
WHERE (SAL * 12) = 36000 OR JOB = 'CLERK'
AND SAL BETWEEN LOSAL AND HISAL;

-- Câu 8: Hiển thị những phòng không có nhân viên nào làm việc.
SELECT ENAME,JOB ,DNAME
FROM EMP join DEPT ON EMP.DEPTNO = DEPT.DEPTNO
where JOB is  null;
-- Câu 9:Hiển thị mã nhân viên, tên nhân viên, mã người quản lý, tên người quản lý
select E.EMPNO, E.ENAME, M.ENAME MGR_NAME, M.MGR
From EMP E, EMP M
WHERE M.MGR = E.EMPNO;

-- Câu 10:Như câu 9 hiển thị thêm thông tin về ông KING
select E.EMPNO, E.ENAME, M.ENAME MGR_NAME, M.MGR
From EMP E, EMP M
WHERE M.MGR = E.EMPNO;

-- Câu 11: Hiển thị nghề nghiệp được tuyển dụng vào năm 1981 và không được tuyển dụng vào
-- năm 1994.
SELECT DISTINCT JOB
FROM EMP WHERE (EXTRACT(YEAR FROM HIREDATE) = 1981)
AND JOB NOT IN (SELECT JOB FROM EMP WHERE EXTRACT(YEAR FROM HIREDATE) = 1994);
-- CÂU 12 Tìm những nhân viên gia nhập công ty trước giám đốc của họ.
SELECT E.ENAME,M.ENAME, TO_CHAR(E.HIREDATE,'dd/MM/yyyy') NV, TO_CHAR(M.HIREDATE,'dd/MM/yyyy') QL
FROM EMP E, EMP M
WHERE  M.EMPNO = E.MGR AND E.HIREDATE < M.HIREDATE;
-- Câu 13: Tìm tất cả các nhân viên, ngày gia nhập công ty, tên nhân viên, tên người giám đốc
-- và ngày gia nhập công ty của người giám đốc ấy.
SELECT E.ENAME,M.ENAME, TO_CHAR(E.HIREDATE,'dd/MM/yyyy') NV, TO_CHAR(M.HIREDATE,'dd/MM/yyyy') QL
FROM EMP E, EMP M
WHERE  M.EMPNO = E.MGR;
-- Câu 14: Tìm những nhân viên kiếm được lương cao nhất trong mỗi loại nghề nghiệp.
SELECT JOB, MAX(SAL)
FROM EMP
GROUP BY JOB;
-- CÂU 15: Tìm mức lương cao nhất trong mỗi phòng ban, sắp xếp theo thứ tự phòng ban
SELECT ENAME, DEPTNO, MAX(SAL)
FROM EMP WHERE SAL IN (SELECT MAX(SAL) FROM EMP GROUP BY DEPTNO)
GROUP BY DEPTNO,ENAME
ORDER BY DEPTNO;
-- Câu 16: Tìm nhân viên gia nhập vào phòng ban sớm nhất
SELECT ENAME, DEPTNO,TO_CHAR(HIREDATE,'dd/MM/yyyy') SOMNHAT,HIREDATE
FROM EMP
WHERE HIREDATE IN (SELECT MIN(HIREDATE) FROM EMP GROUP BY DEPTNO);

-- Câu 17:Hiển thị những nhân viên có mức lương lớn hơn lương TB của phòng ban mà họ làm
-- việc.
SELECT EMP.ENAME,EMP.EMPNO,EMP.DEPTNO,SAL FROM EMP
inner join (select DEPTNO,AVG(SAL) TB FROM EMP GROUP BY DEPTNO) TRUNGBINH
ON EMP.DEPTNO = TRUNGBINH.DEPTNO
WHERE SAL > TRUNGBINH.TB;
-- Câu 18:Hiển thị tên nhân viên, mã nhân viên, mã giám đốc, tên giám đốc, phòng ban làm
-- việc của giám đốc, mức lương của giám đốc.
SELECT E.EMPNO,E.ENAME,M.EMPNO MGR_NUMBER,M.ENAME MGR_NAME,M.SAL,E.DEPTNO,GRADE
FROM EMP E JOIN EMP M on E.MGR = M.EMPNO , SALGRADE
WHERE  (M.SAL BETWEEN LOSAL AND HISAL)
-- Chương 7
-- Câu 1: Tạo bảng PROJECT với các column được chỉ ra dưới đây, PROJID là promary key, và
-- P_END_DATE > P_START_DATE.
CREATE TABLE PROJECT_V(
    PROJID NUMBER(4) NOT NULL CONSTRAINT PK_PROJECT_V PRIMARY KEY,
    P_DESC VARCHAR2(20),
    P_START_DATE DATE,
    P_END_DATE DATE,
    BUDGET_AMOUNT NUMBER(7,2),
    MAX_NO_STAFF NUMBER(2),
    check (P_END_DATE > P_START_DATE)
);
--Câu 2:Tạo bảng ASSIGNMENTS với các column được chỉ ra dưới đây, đồng thời cột
--PROJID là foreign key tới bảng PROJECT, cột EMPNO là foreign key tới bảng EMP.
CREATE TABLE ASSIGNMENTS_VINH(
    PROJID NUMBER(4) NOT NULL CONSTRAINT FK_ASSIGNMENTS_VINH_PROJECT_V REFERENCES PROJECT_V(PROJID),
    EMPNO NUMBER(4) NOT NULL CONSTRAINT FK_ASSIGNMENTS_VINH_EMP REFERENCES EMP(EMPNO),
    A_START_DATE DATE,
    A_END_DATE DATE,
    BILL_AMOUNT NUMBER(4,2),
    ASSIGN_TYPE VARCHAR2(2)
);
-- Câu 3:Thêm column COMMENTS kiểu LONG vào bảng PROJECTS. Thêm column HOURS kiểu
-- NUMBER vào bảng ASSIGNMENTS.
ALTER TABLE PROJECT_V ADD (COMMENTS_V LONG),
ALTER TABLE ASSIGNMENTS_VINH ADD (HOURS_V NUMBER)

-- Câu 4: Sử dụng view USER_OBJECTS hiển thị tất cả các đối tượng user sở hữu.
DESCRIBE USER_OBJECT;
-- Câu 5: Thêm ràng buộc duy nhất (UNIQUE) cho 2 column PROJECT_ID và EMPNO của bảng
-- ASSIGNMENTS
ALTER TABLE ASSIGNMENTS_VINH MODIFY  (PROJID UNIQUE );

ALTER TABLE ASSIGNMENTS_VINH MODIFY  (EMPNO UNIQUE );

DROP TABLE ASSIGNMENTS_VINH;
-- Câu 6: Xem các thông tin về các ràng buộc trong USER_CONSTRAINTS.
SELECT * FROM USER_CONSTRAINTS;
-- Câu 7: Xem trong USER hiện tại có tất cả bao nhiêu bảng.
SELECT TABLE_NAME FROM USER_TABLES;

-- Chương 8
--Câu 1: Thêm dữ liệu vào bảng PROJECTS.
-- PROJID 1 2
-- P_DESC WRITE C030 COURSE PROOF READ NOTES
-- P_START_DATE 02-JAN-88 01-JAN-89
-- P_END_DATE 07-JAN-88 10-JAN-89
-- BUDGET_AMOUNT 500 600
-- MAX_NO_STAFF 1 1
INSERT INTO PROJECT_V (PROJID,P_DESC,P_START_DATE,P_END_DATE,BUDGET_AMOUNT,MAX_NO_STAFF) VALUES(1,'WRITE C030 COURSE','02-JAN-88','07-JAN-88',500,1);
INSERT INTO PROJECT_V (PROJID,P_DESC,P_START_DATE,P_END_DATE,BUDGET_AMOUNT,MAX_NO_STAFF) VALUES(2,'PROOF READ NOTES','01-JAN-89','10-JAN-89',600,1);
-- Câu 2: Thêm dữ liệu vào bảng ASSIGNMENTS.
-- PROJID 1 1 2
-- EMPNO 7369 7902 7844
-- A_START_DATE 01-JAN-88 04-JAN-88 01-JAN-89
-- A_END_DATE 03-JAN-88 07-JAN-88 10-JAN-89
-- BILL_RATE 50.00 55.00 45.50
-- ASSIGN_TYPE WR WR PF
-- HOURS 15 20 30
INSERT INTO ASSIGNMENTS_VINH(PROJID, EMPNO, A_START_DATE, A_END_DATE, BILL_AMOUNT, ASSIGN_TYPE,HOURS_V) VALUES(1,7369,'01-JAN-88','03-JAN-88',50,'WR',15);
INSERT INTO ASSIGNMENTS_VINH(PROJID, EMPNO, A_START_DATE, A_END_DATE, BILL_AMOUNT, ASSIGN_TYPE,HOURS_V) VALUES(1,7902,'04-JAN-88','07-JAN-88',55,'WR',20);
INSERT INTO ASSIGNMENTS_VINH(PROJID, EMPNO, A_START_DATE, A_END_DATE, BILL_AMOUNT, ASSIGN_TYPE,HOURS_V) VALUES(2,7844,'01-JAN-89','10-JAN-89',45.5,'PF',30);
-- Câu 3:Cập nhật trường ASIGNMENT_TYPE từ WT thành WR.
UPDATE ASSIGNMENTS_VINH SET ASSIGN_TYPE ='WT' WHERE PROJID = 1
-- CÂU 4:Nhập thêm số liệu vào bảng ASSIGNMENTS.
INSERT INTO ASSIGNMENTS_VINH(PROJID, EMPNO, A_START_DATE, A_END_DATE, BILL_AMOUNT, ASSIGN_TYPE,HOURS_V) VALUES(2,7844,'02-JAN-89','11-JAN-89',45.5,'PF',20);
