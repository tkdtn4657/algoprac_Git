-- 조건에 부합하는 중고거래 상태 조회하기 (string, date 문제)

SELECT BOARD_ID, WRITER_ID, TITLE, PRICE,
       CASE
           WHEN STATUS = 'SALE' THEN '판매중'
           WHEN STATUS = 'RESERVED' THEN '예약중'
           WHEN STATUS = 'DONE' THEN '거래완료'
           ELSE '알 수 없음'
           END AS TRADE_STATUS
FROM USED_GOODS_BOARD
WHERE CREATED_DATE = '2022-10-05'
ORDER BY BOARD_ID DESC;