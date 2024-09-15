-- 부서별 평균 연봉 조회하기 group by

select hd.DEPT_ID as `DEPT_ID`, hd.DEPT_NAME_EN as `DEPT_NAME_EN`, ROUND(AVG(he.SAL), 0) as `AVG_SAL`
from HR_DEPARTMENT as hd
         inner join HR_EMPLOYEES as he on hd.DEPT_ID = he.DEPT_ID
group by hd.DEPT_ID
order by `AVG_SAL` desc;
