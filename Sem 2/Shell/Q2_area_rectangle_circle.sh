
#!/bin/bash

echo "Enter length of rectangle:"
read l

echo "Enter breadth of rectangle:"
read b

rect_area=$((l*b))

echo "Area of Rectangle = $rect_area"

echo "Enter radius of circle:"
read r

circle_area=$(echo "3.14 * $r * $r" | bc)

echo "Area of Circle = $circle_area"
