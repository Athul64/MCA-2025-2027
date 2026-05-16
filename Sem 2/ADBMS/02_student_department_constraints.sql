CREATE TABLE Student(
    Student_ID NUMBER PRIMARY KEY,
    Student_Name VARCHAR2(50)
);

CREATE TABLE Department(
    Department_ID NUMBER PRIMARY KEY,
    Name VARCHAR2(50),
    Student_ID NUMBER,
    CONSTRAINT fk_student FOREIGN KEY(Student_ID)
    REFERENCES Student(Student_ID)
);