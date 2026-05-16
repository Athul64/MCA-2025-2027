-- Salesman table queries
SELECT salesman_id,name,city,commission
FROM salesman
WHERE commission > 0.10
AND commission < 0.12;

SELECT * FROM salesman
WHERE city IN ('Paris','Rome');

SELECT * FROM salesman
WHERE name LIKE '[A-K]%';