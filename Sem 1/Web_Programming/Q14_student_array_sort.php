
<?php

$students = array("Rahul", "Anjali", "Vivek", "Sneha", "Arjun");

echo "<h2>Original Array</h2>";
echo "<pre>";
print_r($students);
echo "</pre>";

asort($students);

echo "<h2>Sorted Array using asort()</h2>";
echo "<pre>";
print_r($students);
echo "</pre>";

arsort($students);

echo "<h2>Reverse Sorted Array using arsort()</h2>";
echo "<pre>";
print_r($students);
echo "</pre>";

?>
