<?php
include("header.php");
?>
<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="stylesheet" href="../style.css">
    <title>Création de compte</title>
</head>
<body>
<div id="container">
    <form name="formulaire-enfant" action="creabackend.php" method="post">

        <p>
            Nom enfants :<br />
            <input type="text" name="nom" value="" />
        </p>

        <p>
            Prenom enfant :<br />
            <input type="text" name="prenom" value="" />
        </p>
        <p>
            age :<br />
            <input type="numbers" name="age" value="" />
        </p>
        <p>
            votre id de compte :<br />
            <input type="numbers" name="idparent" value="" />
        </p>

        <p>
            <input type="submit" name="envoyer" value="Envoyer" />
        </p>
    </form>
</div>
</body>
</html>