<?php
var_dump($_POST);
if(isset($_POST["envoyer"])){
    include("../Connecteur/BDD.php");
    $sql= "INSERT INTO suivie_enfant(nom_enfant, age, prenom_enfant, id_compte_parent) VALUES (:nom, :age, :prenom, :idparent)";

    $statement = $conn->prepare($sql);
    $statement->bindParam("nom",$_POST["nom"]);
    $statement->bindParam("age",$_POST["age"]);
    $statement->bindParam("prenom",$_POST["prenom"]);
    $statement->bindParam("idparent",$_POST["idparent"]);
    $statement->execute();
    header("location: crea_enfant.php");
}
?>

<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Chargement</title>
</head>
<body>

</body>
</html>