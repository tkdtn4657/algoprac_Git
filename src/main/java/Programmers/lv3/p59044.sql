-- 오랜 기간 보호한 동물(1) (left outer join)

SELECT a.NAME, a.DATETIME
FROM ANIMAL_INS as a
         LEFT JOIN ANIMAL_OUTS as b
                   ON a.ANIMAL_ID = b.ANIMAL_ID
WHERE b.ANIMAL_ID IS NULL
ORDER BY a.DATETIME ASC
    LIMIT 3;