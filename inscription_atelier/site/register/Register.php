<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="stylesheet" href="../../CSS/form.css">
    <title>Création de compte</title>
</head>
<body>


<div id="container">

    <form name="formulaire-compte" action="registerbackend.php" method="post">
        <h1>Inscription</h1>
        <p>
            Votre identifiant :<br />
            <input type="text" name="login" value="" />
        </p>

        <p>
            Votre mot de passe :<br />
            <input type="password" name="pass" value="" />
        </p>
        <p>
            Votre adresse mail :<br />
            <input type="email" name="mail" value="" />
        </p>
        <p>
            Votre numéro de téléphone:<br />
            <input type="tel" name="tel" value="" />
        </p>

        <p>
            <input type="submit" name="envoyer" value="Envoyer" />
        </p>
    </form>
</div>
</body>
</html>