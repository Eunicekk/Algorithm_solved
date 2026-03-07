-- Python이나 C# 스킬을 가진 개발자의 정보를 조회
-- ID를 기준으로 오름차순 정렬
SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS
WHERE SKILL_CODE & (
        SELECT SUM(CODE)
        FROM SKILLCODES
        WHERE NAME = 'Python' OR NAME = 'C#'
    ) != 0
ORDER BY ID ASC;
