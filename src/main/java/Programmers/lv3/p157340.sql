-- 자동차 대여 기록에서 대여중 / 대여 가능 여부 구분하기 (group by, case when than)

SELECT CAR_ID, CASE
                   WHEN CAR_ID IN(
                       SELECT CAR_ID
                       FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                       WHERE START_DATE <= '2022-10-16' AND END_DATE >= '2022-10-16'
                   ) THEN '대여중'
                   ELSE '대여 가능'
    END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC;