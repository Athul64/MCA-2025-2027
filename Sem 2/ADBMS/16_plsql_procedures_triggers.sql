CREATE TABLE account(
    account_no NUMBER PRIMARY KEY,
    account_holder VARCHAR2(20),
    balance NUMBER
);

-- Procedure for sum
CREATE OR REPLACE PROCEDURE add_numbers(a NUMBER,b NUMBER) IS
c NUMBER;
BEGIN
    c:=a+b;
    DBMS_OUTPUT.PUT_LINE(c);
END;
/

-- Student Insert Procedure
CREATE OR REPLACE PROCEDURE insert_student(rno NUMBER,name VARCHAR2) IS
BEGIN
    INSERT INTO Student VALUES(rno,name);
END;
/

-- Cursor Example
DECLARE
CURSOR c1 IS SELECT sid,rating FROM Sailors;
BEGIN
    FOR r IN c1 LOOP
        DBMS_OUTPUT.PUT_LINE(r.sid||' '||r.rating);
    END LOOP;
END;
/

-- Restrict Delete Trigger
CREATE OR REPLACE TRIGGER no_delete_professor
BEFORE DELETE ON Professor
BEGIN
    RAISE_APPLICATION_ERROR(-20000,'Deletion Restricted');
END;
/