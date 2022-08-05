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

