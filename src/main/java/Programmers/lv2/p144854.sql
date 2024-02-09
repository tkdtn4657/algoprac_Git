-- 조건에 맞는 도서와 저자 리스트 출력하기 ( join 문제 )

SELECT a.BOOK_ID, b.AUTHOR_NAME, DATE_FORMAT(a.PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE
FROM BOOK as a
         JOIN AUTHOR as b
              ON a.AUTHOR_ID = b.AUTHOR_ID
WHERE a.CATEGORY = '경제'
ORDER BY PUBLISHED_DATE ASC;