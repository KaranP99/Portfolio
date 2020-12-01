<!--Reference: https://stackoverflow.com/questions/871858/php-pass-variable-to-next-page-->
<?php
   // Connect to database, and print error message if it fails
$stuID=$_GET["task6ID"];
      $dbhandle = new PDO('mysql:host=dragon.kent.ac.uk; dbname=co323',
                          'co323', 'pa33word');

   // Run the SQL query, and print error message if it fails.
   $query = $dbhandle ->prepare( "SELECT c.cid, title, name, weighting, mark
FROM Grade g JOIN Assessment a ON g.aid = a.aid
 JOIN Course c ON a.cid = c.cid
WHERE sid = :k");
   $query->execute(array(":k"=>$stuID));
$results = $query->fetchAll();

?>

<?php
$Tresults = "<table border = '1'>";
$Tresults.= '<tr>';
$Tresults.= '<th>'."Title".'</th>';
$Tresults.= '<th>'."Name".'</th>';
$Tresults.= '<th>'."Weighting".'</th>';
$Tresults.= '<th>'."Mark".'</th>';


foreach ($results as $row) {
   $Tresults.= "<tr>";
   $Tresults.="<td>".$row['cid']."</td> <td>".$row['name']."</td> <td> ".$row['weighting']."</td> <td>".$row['mark']."</td>";
   $Tresults.= "</tr>";
}
$Tresults.= '</table>';
print $Tresults;
?>
<br>
<br>

<?php

$Finalquery = $dbhandle ->prepare( "SELECT cid,
 SUM(mark*weighting)/100 AS Final
FROM Grade g JOIN Assessment a ON g.aid = a.aid
WHERE sid = :k
GROUP BY cid");
$Finalquery->execute(array(":k"=>$stuID));
$Finalresults = $Finalquery->fetchAll();

?>

<?php
$Tfinalresults = "<table border = '1'>";
$Tfinalresults.= '<tr>';
$Tfinalresults.= '<th>'."CID".'</th>';
$Tfinalresults.= '<th>'."Mark".'</th>';


foreach ($Finalresults as $row) {
$Tfinalresults.= "<tr>";
$Tfinalresults.="<td>".$row['cid']."</td> <td>".$row['Final']."</td>";
$Tfinalresults.= "</tr>";
}
$Tfinalresults.= '</table>';
print $Tfinalresults;
?>
