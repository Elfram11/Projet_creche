<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../../CSS/form.css">

    <title>login</title>
</head>
<br>
<br>

<form method="post" action="loginbackend.php">
    <h1>Connexion RAM</h1>

    Nom d'utilisateur: <input type='text' name='login' required="required">

    <br><br>

    mot de passe: <input type='text' name='password' required="required"><br><br>
    <a href="../register/Register.php" class="button">Si vous n'avez pas de compte</a>

    <input type="submit" value="connexion">
    <br>
    <br>

</form>
<?php
if(isset($_GET["err"]) && (!empty($_GET["err"]))){
    if($_GET["err"]==="1"){
        echo "identifiants incorrect";
    }

}

?>

<br>
<br>

</body>
</html>