
#!/bin/bash

echo "Enter file name:"
read file

if [ -w $file ]
then
    echo "File is writable"
else
    echo "File is not writable"
fi
