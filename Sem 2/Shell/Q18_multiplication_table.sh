
#!/bin/bash

n=$1

echo "Multiplication Table for $n"

for (( i=1; i<=10; i++ ))
do
    echo "$n x $i = $((n*i))"
done
