--Chương 2
-- Câu 1
Select * from SALGRADE;
  -- câu 2
select * from emp;
-- Câu 3
select job from emp;
--Câu 4
SELECT ENAME || ' HAS HELP THE POSITION OF' || JOB || 'IN DEPT '|| DEPTNO || 'SINCE' || HIREDATE
 FROM emp;
-- Câu 5
select ENAME , SAL * 12 REMUNERATION
From emp;


-- Chương 3
    --Câu1
SELECT ENAME,DEPTNO,SAL FROM EMP WHERE SAL BETWEEN 1000 AND 2000;
--Câu 2
SELECT DEPTNO, ENAME
FROM EMP
ORDER BY ENAME ASC;
--CÂU 3
SELECT EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO
FROM EMP WHERE DEPTNO = 10 or DEPTNO = 20
ORDER BY ENAME ASC;
-- CÂU 4
SELECT ENAME,JOB
FROM EMP WHERE JOB = N'CLERK'AND DEPTNO = 20;

-- CÂU 5

SELECT ENAME
FROM EMP WHERE ENAME LIKE N'%TH%' OR ENAME LIKE N'%LL%';

-- CÂU 6
SELECT ENAME,JOB,SAL
FROM EMP where JOB not in('PRESIDENT');

-- CÂU 7
select ENAME,DEPTNO,HIREDATE
from EMP where trunc(HIREDATE)
    between to_date('01/01/1983','dd/mm/yyyy')
    and to_date('31/12/1983','dd/mm/yyyy');

-- Câu 8
select ename,sal *12 ANUAL_SAL,comm
from emp where job ='SALESMAN' and comm < SAL
order by ANUAL_SAL DESC