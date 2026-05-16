
<!DOCTYPE html>
<html>
<head>
    <title>PHP Registration Form</title>
</head>
<body>

<h1>Registration Form with Validation</h1>

<form method="post">
    Username: <input type="text" name="username"><br><br>
    Email: <input type="text" name="email"><br><br>
    Password: <input type="password" name="password"><br><br>

    <input type="submit" name="submit" value="Register">
</form>

<?php
if(isset($_POST['submit'])) {

    $username = $_POST['username'];
    $email = $_POST['email'];
    $password = $_POST['password'];

    if(empty($username) || empty($email) || empty($password)) {
        echo "<h3>All fields are required!</h3>";
    }
    elseif(!filter_var($email, FILTER_VALIDATE_EMAIL)) {
        echo "<h3>Invalid Email Format!</h3>";
    }
    elseif(strlen($password) < 8) {
        echo "<h3>Password must contain at least 8 characters!</h3>";
    }
    else {
        echo "<h3>Registration Successful!</h3>";
    }
}
?>

</body>
</html>
