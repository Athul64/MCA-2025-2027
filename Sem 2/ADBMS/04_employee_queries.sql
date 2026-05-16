CREATE TABLE Employees(
    Employee_Id VARCHAR2(10),
    First_Name VARCHAR2(30),
    Last_Name VARCHAR2(30),
    Email VARCHAR2(50),
    Phone_Number VARCHAR2(15),
    Hire_Date DATE,
    Job_Id VARCHAR2(20),
    Salary NUMBER,
    Commission_Pct NUMBER,
    Manager_Id VARCHAR2(10),
    Department_Id VARCHAR2(10)
);

SELECT Employee_Id, First_Name, Salary FROM Employees;

SELECT * FROM Employees WHERE Manager_Id='M215';

SELECT First_Name FROM Employees WHERE Salary>=5000;

SELECT * FROM Employees WHERE Last_Name='MICHAEL';

SELECT First_Name FROM Employees 
WHERE Department_Id IN ('C21','F70','H80');

SELECT DISTINCT Manager_Id FROM Employees;