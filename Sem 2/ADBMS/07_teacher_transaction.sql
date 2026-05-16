CREATE TABLE Teacher(
    Name VARCHAR2(30),
    DeptNo NUMBER,
    Date_of_joining DATE,
    DeptName VARCHAR2(30),
    Location VARCHAR2(30),
    Salary NUMBER
);

INSERT INTO Teacher VALUES('RAM',1,SYSDATE,'Mathematics','CHENNAI',30000);
INSERT INTO Teacher VALUES('ASWIN',2,SYSDATE,'Commerce','KERALA',25000);
INSERT INTO Teacher VALUES('KRISHNA',3,SYSDATE,'Physics','TRICHY',28000);
INSERT INTO Teacher VALUES('SUMAYYA',4,SYSDATE,'Mathematics','MYSORE',35000);
INSERT INTO Teacher VALUES('LAKSHMI',5,SYSDATE,'Commerce','MADURAI',27000);

UPDATE Teacher
SET Salary = Salary + Salary*0.25
WHERE DeptName='Mathematics';

ROLLBACK;

UPDATE Teacher
SET Salary = Salary + Salary*0.15
WHERE DeptName='Commerce';

COMMIT;