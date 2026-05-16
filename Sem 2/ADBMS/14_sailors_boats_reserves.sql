CREATE TABLE Sailors(
    sid NUMBER,
    sname VARCHAR2(30),
    rating NUMBER,
    age NUMBER
);

CREATE TABLE Boats(
    bid NUMBER,
    bname VARCHAR2(30),
    color VARCHAR2(20)
);

CREATE TABLE Reserves(
    sid NUMBER,
    bid NUMBER,
    day DATE
);

SELECT * FROM Sailors
WHERE sid IN (
SELECT sid FROM Reserves WHERE bid=101);

SELECT bname FROM Boats
WHERE bid IN (
SELECT bid FROM Reserves
WHERE sid IN (
SELECT sid FROM Sailors WHERE sname='Bob'));

SELECT DISTINCT s.sname
FROM Sailors s, Boats b, Reserves r
WHERE s.sid=r.sid AND b.bid=r.bid
AND b.color='red'
ORDER BY s.age;

SELECT DISTINCT sname FROM Sailors
WHERE sid IN (SELECT sid FROM Reserves);

SELECT sid,sname FROM Sailors
WHERE sid IN (
SELECT sid FROM Reserves
GROUP BY sid,day
HAVING COUNT(DISTINCT bid)>=2);

SELECT DISTINCT sid FROM Reserves
WHERE bid IN (
SELECT bid FROM Boats
WHERE color IN ('red','green'));

SELECT sname, age FROM Sailors
WHERE age=(SELECT MIN(age) FROM Sailors);

SELECT COUNT(DISTINCT sname) FROM Sailors;

SELECT rating, AVG(age)
FROM Sailors
GROUP BY rating;

SELECT rating, AVG(age)
FROM Sailors
GROUP BY rating
HAVING COUNT(*)>=2;