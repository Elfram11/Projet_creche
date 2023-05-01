<?php
// connexion bdd
$user = "root";
$pass = "root";
$pdo = 'mysql:dbname=fripouille;host=localhost;charset=utf8';
$bdd = new PDO($pdo, $user, $pass);

// recuperation données triées en ordre alphabétique
$requete1 = 'SELECT * FROM suivie_enfant ORDER BY prenom_enfant ASC';

// preparation (avec le execute) est comme un query mais beaucoup plus sécurisé
$resultat = $bdd->prepare($requete1);
$resultat->execute();

if (!$resultat) {
    echo "Problème de requete appareil";
} else {

    ?>
    <?php
    include("header.php");
    ?>

<form action="inscriptionbackend.php" method="post">
    <br><br>Enfant :
<select name="id_enfant">
        <?php
        while($ligne = $resultat->fetch()) {
            echo "<option value='".$ligne['id_suivi_enfant']."'>" .$ligne['prenom_enfant']."</option>";

        }
        ?>
    </select>
    <?php
}
$resultat->closeCursor();
?>

<?php
$requete2 = 'SELECT * FROM atelier ORDER BY atelier_propose ASC';

// preparation (avec le execute) est comme un query mais beaucoup plus sécurisé
$resultat = $bdd->prepare($requete2);
$resultat->execute();

if (!$resultat) {
    echo "Problème de requete marque";
} else {
    ?>

    <!-- Affichage des marques liste déroulante -->
    <br><br>atelier :
    <select name="id_atelier">
        <?php
        while($ligne = $resultat->fetch()) {
            echo "<option value='".$ligne['id_atelier']."'>".$ligne['atelier_propose']."</option>";
        }
        ?>
    </select>
    <?php
}
$resultat->closeCursor();
?>

<br><br><input type="submit"  name="valider" value="inscrire l'enfants">
</form>