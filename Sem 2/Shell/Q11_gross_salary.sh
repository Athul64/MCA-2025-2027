
#!/bin/bash

echo "Enter number of employees:"
read n

for (( i=1; i<=n; i++ ))
do
    echo "Enter Basic Pay:"
    read bp

    if [ $bp -lt 15000 ]
    then
        da=$(echo "$bp * 0.30" | bc)
        hra=500
        ta=$(echo "$bp * 0.10" | bc)
    else
        da=$(echo "$bp * 0.50" | bc)
        hra=$(echo "$bp * 0.15" | bc)
        ta=1000
    fi

    gross=$(echo "$bp + $da + $hra + $ta" | bc)

    echo "Gross Salary = $gross"
done
