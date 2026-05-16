CREATE TABLE Department(
    dno NUMBER PRIMARY KEY,
    dname VARCHAR2(30)
);

CREATE TABLE Student(
    Sid NUMBER PRIMARY KEY,
    sname VARCHAR2(30),
    sex VARCHAR2(10),
    dob DATE,
    dno NUMBER REFERENCES Department(dno)
);

CREATE TABLE Faculty(
    F_id NUMBER PRIMARY KEY,
    fname VARCHAR2(30),
    designation VARCHAR2(30),
    salary NUMBER,
    dno NUMBER REFERENCES Department(dno)
);

SELECT * FROM Student ORDER BY dob;

SELECT s.* FROM Student s
JOIN Department d ON s.dno=d.dno
WHERE d.dname='Computer';

SELECT * FROM Faculty ORDER BY salary DESC;

SELECT dno, COUNT(*) FROM Student GROUP BY dno;

SELECT dno, COUNT(*) FROM Faculty
WHERE salary>25000
GROUP BY dno;