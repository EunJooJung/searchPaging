
select * from emp;

SELECT B.*FROM(SELECT ROWNUM AS RNUM, A.* FROM(SELECT * FROM EMP) A) B WHERE RNUM BETWEEN 2 AND 4;

SELECT B.*FROM(SELECT ROWNUM AS RNUM, A.* FROM(SELECT * FROM EMP) A) B WHERE RNUM BETWEEN 11 AND 14;