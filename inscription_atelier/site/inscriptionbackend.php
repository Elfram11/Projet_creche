<?php
// connexion à la base de données
include '../Connecteur/BDD.php';

$name = $_POST['id_enfant'];
$atelierr = $_POST['id_atelier'];
var_dump($_POST);

$requete = "INSERT INTO affectation(id_enfant, id_atelier) VALUES (?, ?)";

$resultat = $conn->prepare($requete);
$resultat->execute(array($name, $atelierr));
var_dump($resultat->errorInfo());
$resultat->closeCursor();

header("location: inscription_enfant.php");

?>