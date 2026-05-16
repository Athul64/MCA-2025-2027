
<!DOCTYPE html>
<html>
<head>
    <title>Indian Cricket Players</title>

    <style>
        table {
            border-collapse: collapse;
            width: 50%;
        }

        th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: center;
        }
    </style>
</head>
<body>

<h1>Indian Cricket Players</h1>

<?php

$players = array(
    "Virat Kohli",
    "Rohit Sharma",
    "MS Dhoni",
    "Hardik Pandya",
    "Jasprit Bumrah"
);

echo "<table>";
echo "<tr><th>Player Number</th><th>Player Name</th></tr>";

for($i = 0; $i < count($players); $i++) {
    echo "<tr>";
    echo "<td>" . ($i + 1) . "</td>";
    echo "<td>" . $players[$i] . "</td>";
    echo "</tr>";
}

echo "</table>";

?>

</body>
</html>
