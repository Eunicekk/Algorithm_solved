-- ID와 자식의 수를 출력
-- 자식이 없다면 자식의 수는 0으로 출력
-- 개체의 ID 에 대해 오름차순 정렬
SELECT ID, (SELECT COUNT(*) FROM ECOLI_DATA WHERE PARENT_ID = E.ID) AS CHILD_COUNT
FROM ECOLI_DATA E
ORDER BY ID ASC;
