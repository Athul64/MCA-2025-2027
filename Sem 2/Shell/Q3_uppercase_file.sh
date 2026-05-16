
#!/bin/bash

echo "Enter file name:"
read file

tr 'a-z' 'A-Z' < $file
