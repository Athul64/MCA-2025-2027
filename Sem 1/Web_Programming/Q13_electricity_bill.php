
<!DOCTYPE html>
<html>
<head>
    <title>Electricity Bill Calculator</title>
</head>
<body>

<h1>Electricity Bill Generator</h1>

<form method="post">
    Enter Units Consumed:
    <input type="number" name="units"><br><br>

    <input type="submit" name="calculate" value="Calculate Bill">
</form>

<?php
if(isset($_POST['calculate'])) {

    $units = $_POST['units'];
    $bill = 0;

    if($units <= 100) {
        $bill = $units * 3;
    }
    elseif($units <= 200) {
        $bill = (100 * 3) + (($units - 100) * 5);
    }
    else {
        $bill = (100 * 3) + (100 * 5) + (($units - 200) * 7);
    }

    echo "<h2>Total Electricity Bill: Rs. $bill</h2>";
}
?>

</body>
</html>
