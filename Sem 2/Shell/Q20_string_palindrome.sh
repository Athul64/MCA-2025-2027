
#!/bin/bash

echo "Enter a string:"
read str

rev=$(echo $str | rev)

echo "Reverse String = $rev"

if [ "$str" = "$rev" ]
then
    echo "String is Palindrome"
else
    echo "String is not Palindrome"
fi
