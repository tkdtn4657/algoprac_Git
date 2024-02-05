package Programmers.lv1;
        SELECT BOOK_ID, DATE_FORMAT(PUBLISHED_DATE,'%Y-%m-%d')
        FROM BOOK
        WHERE PUBLISHED_DATE BETWEEN '2021-01-01' AND '2021-12-31' AND CATEGORY = '인문'
        order by published_date asc

