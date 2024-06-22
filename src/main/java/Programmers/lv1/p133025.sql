-- p133025 과일로 만든 아이스크림 고르기

SELECT a.FLAVOR
from FIRST_HALF as a
         inner join ICECREAM_INFO as b
                    on a.FLAVOR = b.FLAVOR
where a.TOTAL_ORDER > 3000 and b.INGREDIENT_TYPE = 'fruit_based'
order by a.TOTAL_ORDER DESC


--     서브쿼리형태
-- SELECT FLAVOR
--                  FROM FIRST_HALF
--                             WHERE TOTAL_ORDER > 3000
--           AND FLAVOR IN (SELECT FLAVOR FROM ICECREAM_INFO WHERE INGREDIENT_TYPE = 'fruit_based')
-- ORDER BY TOTAL_ORDER DESC;