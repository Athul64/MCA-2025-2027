
<?php

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "college";

$conn = mysqli_connect($servername, $username, $password, $dbname);

if(!$conn) {
    die("Connection Failed: " . mysqli_connect_error());
}

$sql = "SELECT * FROM students";

$result = mysqli_query($conn, $sql);

echo "<h1>Student Details</h1>";

echo "<table border='1' cellpadding='10'>";
echo "<tr>
        <th>ID</th>
        <th>Name</th>
        <th>Course</th>
      </tr>";

while($row = mysqli_fetch_assoc($result)) {
    echo "<tr>";
    echo "<td>" . $row['id'] . "</td>";
    echo "<td>" . $row['name'] . "</td>";
    echo "<td>" . $row['course'] . "</td>";
    echo "</tr>";
}

echo "</table>";

mysqli_close($conn);

?>
