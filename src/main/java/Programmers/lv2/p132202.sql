-- 진료과별 총 예약 횟수 출력하기 (group by)

SELECT MCDP_CD as '진료과코드', COUNT(DAY(APNT_YMD)) as '5월예약건수'
FROM APPOINTMENT
WHERE YEAR(APNT_YMD) = 2022 AND MONTH(APNT_YMD) = 5
GROUP BY MCDP_CD
ORDER BY COUNT(DAY(APNT_YMD)) ASC, MCDP_CD ASC