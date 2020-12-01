<?php
   // Connect to database, and print error message if it fails

      $dbhandle = new PDO('mysql:host=dragon.kent.ac.uk; dbname=co323',
                          'co323', 'pa33word');

   // Run the SQL query, and print error message if it fails.
   $query = $dbhandle ->prepare( "SELECT * FROM Student");
   $query->execute();
$results = $query->fetchAll();
?>
   <h2>Task 6</h2>

     <?php
     $ddlist = "<form method = 'get' action = 'task7.php'><select name= 'task6ID'> ";
     foreach ($results as $row) {
       //echo
        $ddlist.="<option value = \"".$row['sid']."\">" .$row['sid']." ".$row['forename']." ".$row['surname']." ".$row['gender'].'</option>';

     }

     $ddlist.="</select>";
     $ddlist.="<input type='submit' value = 'Submit' id = 'SubmitBtn'></form>";
     print $ddlist;
      ?>
