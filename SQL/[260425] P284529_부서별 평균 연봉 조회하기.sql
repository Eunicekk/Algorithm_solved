-- 부서별로 부서 ID, 영문 부서명, 평균 연봉을 조회
-- 평균연봉은 소수점 첫째 자리에서 반올림하고 컬럼명은 AVG_SAL
-- 부서별 평균 연봉을 기준으로 내림차순 정렬
SELECT HD.DEPT_ID, DEPT_NAME_EN, ROUND(AVG(SAL), 0) AS AVG_SAL
FROM HR_DEPARTMENT HD
INNER JOIN HR_EMPLOYEES HE
    ON HD.DEPT_ID = HE.DEPT_ID
GROUP BY HD.DEPT_ID
ORDER BY AVG_SAL DESC;
