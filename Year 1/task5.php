<?php

      $dbhandle = new PDO('mysql:host=dragon.kent.ac.uk; dbname=co323',
                          'co323', 'pa33word');

   // Run the SQL query, and print error message if it fails.
   $query = $dbhandle ->prepare ($sql = "SELECT cid, name, AVG(mark) AS avg
FROM Grade g JOIN Assessment a ON g.aid = a.aid
GROUP BY cid, name");
if($query->execute() === FALSE){
  die('Error Running Query: '. implode($query->errorInfo().' '));
}

$results = $query->fetchAll();
?>
   <h2>Task 5</h2>
<?php
$Tresults = "<table border = '1'>";

foreach ($results as $row) {
   $Tresults.= "<tr>";
   $Tresults.="<td>".$row['cid']."</td> <td>".$row['name']."</td> <td> ".$row['avg']."</td>";
   $Tresults.= "</tr>";
}

$Tresults.= "</table>";
print $Tresults;
?>
