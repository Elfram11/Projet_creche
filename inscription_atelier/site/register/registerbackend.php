<?php
var_dump($_POST);
if(isset($_POST["envoyer"])){
    include("../../Connecteur/BDD.php");
    $sql= "INSERT INTO compte_parent(login_parent, mdp_parent, mail, tel) VALUES (:login, :password, :mail, :tel)";

    $statement = $conn->prepare($sql);
    $statement->bindParam("login",$_POST["login"]);
    $passwordhash = hash("sha256", $_POST["pass"]);
    $statement->bindParam("password",$passwordhash);
    $statement->bindParam("mail",$_POST["mail"]);
    $statement->bindParam("tel",$_POST["tel"]);
    $statement->execute();

    header("location:../login/login.php");
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