<?php
require_once "../../Connecteur/BDD.php";
$login = ($_POST["login"]);
$password= ($_POST["password"]);
$hash = hash("sha256", $_POST["password"]);


if (!empty($login) AND !empty($password)) {
    $test = $conn->prepare('SELECT * FROM compte_parent 
    WHERE login_parent=? AND mdp_parent=?');


    $test->execute(array($login, $hash));
    $recherche = $test->rowCount();
    echo $recherche;

    if ($recherche === 0) {
        header("Location: login.php?err=1");


    } elseif ($recherche === 1) {
        session_start();
        $compte = $test->fetch();
        $_SESSION["id_parent"] = $compte["id_parent"];

        header("Location: ../Menu.php");


    }
}
?>
