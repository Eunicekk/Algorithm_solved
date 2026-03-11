-- 만원 단위의 가격대 별로 상품 개수를 출력
-- 컬럼명은 PRICE_GROUP, PRODUCTS로 지정하고 가격대 정보는 각 구간의 최소금액으로 표시
-- 가격대를 기준으로 오름차순 정렬
SELECT FLOOR(PRICE / 10000) * 10000 AS PRICE_GROUP, COUNT(*) AS PRODUCTS
FROM PRODUCT
GROUP BY FLOOR(PRICE / 10000) * 10000
ORDER BY PRICE_GROUP ASC;
