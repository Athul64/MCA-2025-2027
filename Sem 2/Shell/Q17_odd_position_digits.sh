
#!/bin/bash

echo "Enter a 5 digit number:"
read num

echo "Digits in odd positions are:"

echo $num | cut -c1,3,5
