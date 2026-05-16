
<!DOCTYPE html>
<html>
<head>
    <title>Book Information System</title>
</head>
<body>

<h1>Book Information Form</h1>

<form method="post">
    Book ID: <input type="text" name="bookid"><br><br>

    Title: <input type="text" name="title"><br><br>

    Author: <input type="text" name="author"><br><br>

    Edition: <input type="text" name="edition"><br><br>

    Publisher: <input type="text" name="publisher"><br><br>

    <input type="submit" name="save" value="Save Book">
</form>

<hr>

<h2>Search Book by Title</h2>

<form method="post">
    Enter Book Title:
    <input type="text" name="searchtitle">

    <input type="submit" name="search" value="Search">
</form>

<?php

$conn = mysqli_connect("localhost", "root", "", "library");

if(!$conn) {
    die("Database Connection Failed");
}

if(isset($_POST['save'])) {

    $bookid = $_POST['bookid'];
    $title = $_POST['title'];
    $author = $_POST['author'];
    $edition = $_POST['edition'];
    $publisher = $_POST['publisher'];

    $sql = "INSERT INTO books
            VALUES('$bookid','$title','$author','$edition','$publisher')";

    if(mysqli_query($conn, $sql)) {
        echo "<h3>Book Information Saved Successfully!</h3>";
    }
    else {
        echo "Error: " . mysqli_error($conn);
    }
}

if(isset($_POST['search'])) {

    $searchtitle = $_POST['searchtitle'];

    $sql = "SELECT * FROM books WHERE title='$searchtitle'";

    $result = mysqli_query($conn, $sql);

    echo "<h2>Search Results</h2>";

    echo "<table border='1' cellpadding='10'>";
    echo "<tr>
            <th>Book ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Edition</th>
            <th>Publisher</th>
          </tr>";

    while($row = mysqli_fetch_assoc($result)) {

        echo "<tr>";
        echo "<td>" . $row['BookID'] . "</td>";
        echo "<td>" . $row['title'] . "</td>";
        echo "<td>" . $row['author'] . "</td>";
        echo "<td>" . $row['edition'] . "</td>";
        echo "<td>" . $row['publisher'] . "</td>";
        echo "</tr>";
    }

    echo "</table>";
}

mysqli_close($conn);

?>

</body>
</html>
