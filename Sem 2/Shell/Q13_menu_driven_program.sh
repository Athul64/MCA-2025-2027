
#!/bin/bash

echo "Enter a number:"
read n

echo "1. Sum of digits"
echo "2. Reverse of number"
echo "3. Palindrome check"

echo "Enter your choice:"
read ch

case $ch in

1)
sum=0
temp=$n

while [ $temp -gt 0 ]
do
    rem=$((temp%10))
    sum=$((sum+rem))
    temp=$((temp/10))
done

echo "Sum of digits = $sum"
;;

2)
rev=0
temp=$n

while [ $temp -gt 0 ]
do
    rem=$((temp%10))
    rev=$((rev*10+rem))
    temp=$((temp/10))
done

echo "Reverse = $rev"
;;

3)
rev=0
temp=$n
original=$n

while [ $temp -gt 0 ]
do
    rem=$((temp%10))
    rev=$((rev*10+rem))
    temp=$((temp/10))
done

if [ $original -eq $rev ]
then
    echo "Palindrome"
else
    echo "Not Palindrome"
fi
;;

*)
echo "Invalid Choice"
;;

esac
