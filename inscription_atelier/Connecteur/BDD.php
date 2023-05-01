<?php
// Page connection pour se connecter à la base de donnée
try {

    $conn = new PDO('mysql:host=localhost;dbname=fripouille;charset=utf8',
        'root',
        'root');
}
catch(Exception $e) {
    die('Erreur : '.$e->getMessage());
}
?>