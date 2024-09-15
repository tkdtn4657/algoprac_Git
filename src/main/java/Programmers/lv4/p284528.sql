-- 연간 평가점수에 해당하는 평가 등급 및 성과금 조회하기

select
    he.EMP_NO as EMP_NO,
    he.EMP_NAME as EMP_NAME,
    (
        case
            when floor(avg(hg.SCORE)) >= 96 then 'S'
            when floor(avg(hg.SCORE)) >= 90 then 'A'
            when floor(avg(hg.SCORE)) >= 80 then 'B'
            else 'C'
            end
        ) as GRADE,
    (
        case
            when FLOOR(avg(hg.SCORE)) >= 96 then FLOOR(he.SAL * 0.2)
            when FLOOR(avg(hg.SCORE)) >= 90 then FLOOR(he.SAL * 0.15)
            when FLOOR(avg(hg.SCORE)) >= 80 then FLOOR(he.SAL * 0.1)
            else 0
            end
        ) as BONUS
from HR_DEPARTMENT as hd
         join HR_EMPLOYEES as he on he.DEPT_ID = hd.DEPT_ID
         join HR_GRADE as hg on hg.EMP_NO = he.EMP_NO
group by he.EMP_NO, he.EMP_NAME
order by he.EMP_NO asc;

-- gpt정답
-- SELECT
--     sub.EMP_NO,
--     sub.EMP_NAME,
--     sub.GRADE,
--     (
--         CASE
--             WHEN sub.GRADE = 'S' THEN FLOOR(he.SAL * 0.2)
--             WHEN sub.GRADE = 'A' THEN FLOOR(he.SAL * 0.15)
--             WHEN sub.GRADE = 'B' THEN FLOOR(he.SAL * 0.1)
--             ELSE 0
--             END
--         ) AS BONUS
-- FROM (
--          SELECT
--              he.EMP_NO,
--              he.EMP_NAME,
--              (
--                  CASE
--                      WHEN FLOOR(AVG(hg.SCORE)) >= 96 THEN 'S'
--                      WHEN FLOOR(AVG(hg.SCORE)) >= 90 THEN 'A'
--                      WHEN FLOOR(AVG(hg.SCORE)) >= 80 THEN 'B'
--                      ELSE 'C'
--                      END
--                  ) AS GRADE
--          FROM HR_DEPARTMENT AS hd
--                   JOIN HR_EMPLOYEES AS he ON he.DEPT_ID = hd.DEPT_ID
--                   JOIN HR_GRADE AS hg ON hg.EMP_NO = he.EMP_NO
--          GROUP BY he.EMP_NO, he.EMP_NAME
--      ) sub
--          JOIN HR_EMPLOYEES AS he ON sub.EMP_NO = he.EMP_NO
-- ORDER BY sub.EMP_NO ASC;