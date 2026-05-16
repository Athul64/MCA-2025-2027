
#!/bin/bash

echo "Enter marks of three subjects:"
read m1 m2 m3

total=$((m1+m2+m3))
avg=$((total/3))

echo "Average = $avg"

if [ $avg -ge 80 ]
then
    echo "A Grade"
elif [ $avg -ge 70 ]
then
    echo "B Grade"
elif [ $avg -ge 60 ]
then
    echo "C Grade"
else
    echo "Failed"
fi
