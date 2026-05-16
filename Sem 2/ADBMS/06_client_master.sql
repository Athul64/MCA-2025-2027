CREATE TABLE Client_master(
    ClientNO VARCHAR2(10),
    Name VARCHAR2(30),
    Address VARCHAR2(50),
    City VARCHAR2(30),
    State VARCHAR2(30),
    Bal_due NUMBER
);

INSERT INTO Client_master VALUES('C510','RAM','ABC','CHENNAI','TN',6000);
INSERT INTO Client_master VALUES('C511','ASWIN','DEF','KOCHI','KL',4000);
INSERT INTO Client_master VALUES('C512','KRISHNA','GHI','TRICHY','TN',8000);
INSERT INTO Client_master VALUES('C513','SUMAYYA','JKL','MYSORE','KA',3000);
INSERT INTO Client_master VALUES('C514','LAKSHMI','MNO','MADURAI','TN',7000);

SELECT Name FROM Client_master WHERE Bal_due>5000;

UPDATE Client_master SET Bal_due=5100 WHERE ClientNO='C510';

ALTER TABLE Client_master RENAME TO Clienttable;

SELECT Bal_due AS BALANCE FROM Clienttable;