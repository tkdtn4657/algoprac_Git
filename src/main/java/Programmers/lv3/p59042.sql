-- p59042 없어진 기록 찾기 outer join

SELECT a.ANIMAL_ID, a.NAME
FROM ANIMAL_OUTS as a
         LEFT OUTER JOIN ANIMAL_INS as b
                         ON a.ANIMAL_ID = b.ANIMAL_ID
WHERE b.ANIMAL_ID IS NULL
ORDER BY a.ANIMAL_ID asc;