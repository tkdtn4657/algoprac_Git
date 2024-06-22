-- 대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기 (group by, subQuery)

SELECT MONTH(START_DATE) as MONTH, CAR_ID, COUNT(*) RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID IN
    (SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE DATE_FORMAT(START_DATE, '%Y-%m') BETWEEN '2022-08' AND '2022-10'
    GROUP BY CAR_ID
    HAVING COUNT(*) >= 5)
  AND DATE_FORMAT(START_DATE, '%Y-%m') BETWEEN '2022-08' AND '2022-10'
GROUP BY MONTH(START_DATE), CAR_ID
HAVING COUNT(*) > 0
ORDER BY MONTH, CAR_ID DESC