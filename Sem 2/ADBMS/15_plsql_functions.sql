-- Prime Number Function
CREATE OR REPLACE FUNCTION is_prime(n NUMBER)
RETURN VARCHAR2 IS
i NUMBER;
BEGIN
    FOR i IN 2..n-1 LOOP
        IF MOD(n,i)=0 THEN
            RETURN 'NOT PRIME';
        END IF;
    END LOOP;
    RETURN 'PRIME';
END;
/

-- Factorial Function
CREATE OR REPLACE FUNCTION factorial(n NUMBER)
RETURN NUMBER IS
f NUMBER:=1;
BEGIN
    FOR i IN 1..n LOOP
        f:=f*i;
    END LOOP;
    RETURN f;
END;
/

-- Sum Function
CREATE OR REPLACE FUNCTION sum_two(a NUMBER,b NUMBER)
RETURN NUMBER IS
BEGIN
    RETURN a+b;
END;
/

-- Palindrome Function
CREATE OR REPLACE FUNCTION palindrome(str VARCHAR2)
RETURN VARCHAR2 IS
BEGIN
    IF str = REVERSE(str) THEN
        RETURN 'PALINDROME';
    ELSE
        RETURN 'NOT PALINDROME';
    END IF;
END;
/