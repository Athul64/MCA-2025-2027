
#!/bin/bash

echo "Enter first file:"
read file1

echo "Enter second file:"
read file2

if [ -f $file2 ]
then
    cat $file1 >> $file2
    echo "Contents appended"
else
    cp $file1 $file2
    echo "New file created"
fi
