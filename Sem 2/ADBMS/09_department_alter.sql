CREATE TABLE Department(
    Dname VARCHAR2(30),
    Location VARCHAR2(30)
);

ALTER TABLE Department RENAME TO dept_table;

ALTER TABLE dept_table
ADD PINCODE NUMBER NOT NULL;

ALTER TABLE dept_table
RENAME COLUMN Dname TO DEPT_NAME;

ALTER TABLE dept_table
MODIFY Location CHAR(10);

DROP TABLE dept_table;