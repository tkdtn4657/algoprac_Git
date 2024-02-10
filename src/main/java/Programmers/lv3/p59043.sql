-- 있었는데요 없었습니다 (join)

SELECT a.ANIMAL_ID, b.name
FROM ANIMAL_INS as a
         JOIN ANIMAL_OUTS as b
              ON a.ANIMAL_ID = b.ANIMAL_ID
WHERE a.DATETIME > b.DATETIME
ORDER BY a.DATETIME ASC;