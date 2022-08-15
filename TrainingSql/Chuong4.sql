-- Chuong 4
--CAu 1:Liệt kê tên nhân viên, mã phòng ban và lương nhân viên được tăng 15% (PCTSAL)

select DEPTNO, ENAME, ((SAL *0.15) + SAL) AS PCTSAL
from emp;
--CAU 2:Viết câu lệnh hiển thị như sau
-- EMPLOYEE_AND_JOB
-- KING*** *PRESIDENT
-- BLAKE*** **MANAGER
-- CLARK*** **MANAGER
-- JONES*** **MANAGER
-- MARTIN******SALESMAN
-- ALLEN*** *SALESMAN
-- TURNER******SALESMAN
-- JAMES*** *CLERK
-- WARD*** **SALESMAN
-- FORD*** ***ANALYST
-- SMITH*** *CLERK
-- SCOTT*** **ANALYST
-- ADAMS*** *CLERK
-- MILLER*** ***CLERK
select RPAD(ENAME,8,'*'), LPAD(JOB,10,'*')
from emp;
-- Cau 3 : Viết câu lệnh hiển thị như sau:
-- EMPLOYEE
-- KING (President)
-- BLAKE (Manager)
-- CLARK (Manager)
-- JONES (Manager)
-- MARTIN (Salesman)
-- ALLEN (Salesman)
-- TURNER (Salesman)
-- JAMES (Clerk)
-- WARD (Salesman)
-- FORD (Analyst)
-- SMITH (Clerk)
-- SCOTT (Analyst)
-- ADAMS (Clerk)
-- MILLER (Clerk)
select ename || ' ' || '('|| INITCAP(JOB)||')' AS EMPLOYEE
From emp;
-- Cau 4:Viết câu lệnh hiển thị như sau:
-- ENAME DEPTNO JOB
-- BLAKE 30 Manager
-- MARTIN 30 Salesperson
-- ALLEN 30 Salesperson
-- TURNER 30 Salesperson
-- JAMES 30 Clerk
-- WARD 30 Salesperson
select ename,deptno,INITCAP(JOB)
from emp where DEPTNO = 30;
-- Cau 5:Tìm ngày thứ 6 đầu tiên cách 2 tháng so với ngày hiện tại hiển thị ngày dưới dạng 09
-- February 1990.
SELECT to_char(NEXT_DAY(ADD_MONTHS(SYSDATE,2),'FRIDAY'),'dd,MONTH,yyyy') as NEXTMONTH2
FROM DUAL;

-- Cau 6:Tìm thông itn về tên nhân viên, ngày gia nhập công ty của nhân viên phòng số 20,
-- sao cho hiển thị như sau:
-- ENAME DATE_HIRED
-- JONES april,SECOND 1981
-- FORD december,THIRD 1981
-- SMITH december,SEVENTEENTH 1980
-- SCOTT december,NINTH 1982
-- ADAMS january,TWELFTH 1983
select ENAME, NVL(TO_CHAR(HIREDATE,'month,DAY,yyyy'),0) as DATE_HIRED
from emp where DEPTNO = 20;

-- Cau 7:Hiển thị tên nhân viên, ngày gia nhập công ty, ngày xét nâng lương (sau ngày gia
-- nhập công ty 1 năm), sắp xếp theo thứ tự ngày xét nâng lương.
-- ENAME HIREDATE REVIEW
-- SMITH 17-12-1980 17-12-1981
-- ALLEN 20-02-1981 20-02-1982
-- WARD 22-02-1981 22-02-1982
-- JONES 02-04-1981 02-04-1982
-- BLAKE 01-05-1981 01-05-1982
-- CLARK 09-06-1981 09-06-1982
-- TURNER 08-09-1981 08-09-1982
-- MARTIN 28-09-1981 28-09-1982
-- KING 17-11-1981 17-11-1982
-- JAMES 03-12-1981 03-12-1982
-- FORD 03-12-1981 03-12-1982
-- MILLER 23-01-1982 23-01-1983
-- SCOTT 09-12-1982 09-12-1983
-- ADAMS 12-01-1983 12-01-1984
select ENAME,to_char(HIREDATE,'dd/mm/yyyy'),to_char(ADD_MONTHS(HIREDATE,12), 'dd/mm/yyyy') as REVIEW
from emp
order by HIREDATE asc;
-- Cau 8:Hiển thị tên nhân viên và lương dưới dạng

SELECT ENAME,(CASE
            WHEN SAL <1500 THEN 'BELOW 1500'
            WHEN SAL =1500 THEN 'On Target '
            ELSE to_char(SAL)
           END )  AS SALARY
FROM EMP;
-- Câu 9 Cho biết thứ của ngày hiện tại
SELECT To_char (sysdate, 'day') as THUHIENTAI from dual;
-- CÂU 10: Đưa chuỗi dưới dạng nn/nn, kiểm tra nếu khúng khuôn dạng trả lời là YES, ngược lại
-- là NO. Kiểm tra với các chuỗi 12/34, 01/1a, 99\88
select DECODE('12/34','12/34','yes','01/1a','no','98\88','no','under')AS VALUEVALID FROM DUAL;

-- Câu 11 Hiển thị tên nhân viên, ngày gia nhập công ty, ngày lĩnh lương sao cho ngày lĩnh
-- lương phải vào thứ 6, nhân viên chỉ được nhận lương sau ít nhất 15 ngày làm việc tại
-- công ty, sắp xếp theo thứ tự ngày gia nhập công ty
SELECT ENAME,HIREDATE,NEXT_DAY(HIREDATE+15,'FRIDAY')
FROM EMP WHERE (SYSDATE - EMP.HIREDATE > 15)
ORDER BY HIREDATE ASC;
-- 4.5.2. Hàm trên nhóm dữ liệu
--1: Tìm lương thấp nhất, lớn nhất và lương trung bình của tất cả các nhân viên
SELECT MIN(SAL)  , MAX(SAL),AVG(SAL)
FROM EMP;
--2:Tìm lương nhỏ nhất và lớn của mỗi loại nghề nghiệp
SELECT JOB , MIN(SAL),MAX(SAL)
FROM EMP
GROUP BY JOB;
--3:Tìm xem có bao nhiêu giám đốc trong danh sách nhân viên
SELECT COUNT(JOB) JOB
FROM EMP WHERE JOB='MANAGER';
--4: Tìm tất cả các phòng ban mà số nhân viên trong phòng >3
SELECT EMP.DEPTNO,COUNT(*) as SOLUONGNHANVIEN
FROM EMP
GROUP BY DEPTNO
HAVING COUNT(DEPTNO) > 3;
-- CÂU 5:Tìm ra mức lương nhỏ nhất của mỗi nhân viên làm việc cho một giám đốc nào đó
-- sắp xếp theo thứ tự tăng dần của mức lương.
SELECT MIN(SAL)
FROM EMP WHERE JOB NOT IN ('PERSIDENT')
ORDER BY SAL ASC