-- 카테고리 별 도서 판매량 집계하기 ( join, group by )

# SELECT a.CATEGORY, SUM(b.SALES) as TOTAL_SALES
      # FROM BOOK as a
      # JOIN BOOK_SALES as b
# ON a.BOOK_ID = b.BOOK_ID
      # WHERE b.SALES_DATE >= '2022-01-01' AND b.SALES_DATE <= '2022-01-31'
      # GROUP BY a.CATEGORY
      # ORDER BY a.CATEGORY ASC;

SELECT a.CATEGORY, SUM(b.SALES) as TOTAL_SALES
FROM BOOK as a
         JOIN BOOK_SALES as b
              ON a.BOOK_ID = b.BOOK_ID
WHERE b.SALES_DATE LIKE '2022-01%'
GROUP BY a.CATEGORY
ORDER BY a.CATEGORY ASC;