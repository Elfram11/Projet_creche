<?php
require_once "../Connecteur/BDD.php";

$requete=$conn->prepare("CALL listerAtelier()");
$requete->execute();
$donnees =$requete->fetchAll();
$requete->closeCursor();


?>
<!doctype html>
<?php
include("header.php");
?>

<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="../CSS/style.css" rel="stylesheet">

    <title>atelier proposer</title>
</head>
<body>

<table>
    <thead>
        <th>nom atelier</th>
        <th>date</th>
        <th>heure de début</th>
        <th>heure de fin</th>
        <th>nombre de place</th>
        <th>age appropriée</th>

    </thead>
<tbody>
<?php
    foreach($donnees as $unatelier){
        echo "<tr>";
            echo "<td>".$unatelier["atelier_propose"]."</td>";
            echo "<td>".$unatelier["date_atelier"]."</td>";
            echo "<td>".$unatelier["heure_depart"]."</td>";
            echo "<td>".$unatelier["heure_depart"]."</td>";
            echo "<td>".$unatelier["nb_places"]."</td>";
            echo "<td>".$unatelier["age_enfant"]."</td>";

        echo "</tr>";
    }


    ?>
  
</tbody>
</table>
<a href="inscription_enfant.php"><button>inscrire votre enfant a un atelier</button></a>


</body>
</html>

