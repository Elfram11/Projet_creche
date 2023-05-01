-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Lun 01 Mai 2023 à 13:01
-- Version du serveur :  5.7.11
-- Version de PHP :  7.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `fripouille`
--

DELIMITER $$
--
-- Procédures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `affectation_enfant` (IN `enfant` INT, IN `atelier` INT)  NO SQL
INSERT INTO affectation(id_enfant, id_atelier) VALUES (enfant, atelier)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `creation_atelier` (IN `atelier` VARCHAR(30), IN `atelier_date` VARCHAR(10), IN `heureDebut` VARCHAR(5), IN `heureFin` VARCHAR(5), IN `nombreP` INT, IN `age` INT)  INSERT INTO atelier (atelier_propose, date_atelier, heure_depart, heure_fin, nb_places, age_enfant) VALUES (atelier, atelier_date, heureDebut, heureFin, nombreP, age)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `création_enfant` (IN `nom` VARCHAR(30), IN `age` INT, IN `prenom` VARCHAR(30), IN `idparent` INT)  NO SQL
INSERT INTO suivie_enfant(nom_enfant, age, prenom_enfant, id_compte_parent) VALUES (nom, age, prenom, idparent)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `creation_parent` (IN `id` INT(11), IN `login` VARCHAR(50), IN `mdp` VARCHAR(50), IN `mail_p` VARCHAR(50), IN `tel_p` VARCHAR(50))  NO SQL
INSERT INTO compte_parent(id_parent, login_parent, mdp_parent, mail, tel)
VALUES(id, login, mdp, mail_p, tel_p)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `enfants_inscrit` (IN `param_id` INT(11))  NO SQL
SELECT suivie_enfant.nom_enfant, suivie_enfant.prenom_enfant, atelier.atelier_propose
FROM affectation 
INNER JOIN suivie_enfant ON affectation.id_enfant = suivie_enfant.id_suivi_enfant
INNER JOIN atelier ON affectation.id_atelier = atelier.id_atelier
WHERE atelier.id_atelier = param_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listerAtelier` ()  BEGIN
    SELECT * FROM atelier;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `login` (IN `login` VARCHAR(30), IN `mdp` VARCHAR(30))  NO SQL
SELECT * FROM compte_parent WHERE login_parent = 'login' AND mdp_parent = 'mdp'$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `affectation`
--

CREATE TABLE `affectation` (
  `id_enfant` int(11) NOT NULL,
  `id_atelier` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `affectation`
--

INSERT INTO `affectation` (`id_enfant`, `id_atelier`) VALUES
(1, 7),
(3, 7),
(4, 8),
(6, 8),
(6, 12);

-- --------------------------------------------------------

--
-- Structure de la table `atelier`
--

CREATE TABLE `atelier` (
  `id_atelier` int(11) NOT NULL,
  `atelier_propose` varchar(30) NOT NULL,
  `date_atelier` varchar(10) NOT NULL,
  `heure_depart` varchar(5) NOT NULL,
  `heure_fin` varchar(5) NOT NULL,
  `nb_places` int(3) NOT NULL,
  `age_enfant` int(11) NOT NULL,
  `enfant_inscrit` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `atelier`
--

INSERT INTO `atelier` (`id_atelier`, `atelier_propose`, `date_atelier`, `heure_depart`, `heure_fin`, `nb_places`, `age_enfant`, `enfant_inscrit`) VALUES
(7, 'dessins', '22/03/2023', '10:00', '12:00', 7, 4, 1),
(8, 'eau', '11/11/1111', '11:11', '12:11', 1, 1, 0),
(12, 'cirque', '31/03/2023', '14:00', '16:00', 4, 5, 0);

-- --------------------------------------------------------

--
-- Structure de la table `compte_assistante`
--

CREATE TABLE `compte_assistante` (
  `id_assistante` int(11) NOT NULL,
  `login_assistante` varchar(40) NOT NULL,
  `password_assistante` varchar(255) NOT NULL,
  `id_suivi_enfant` int(11) NOT NULL,
  `id_creche` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `compte_parent`
--

CREATE TABLE `compte_parent` (
  `id_parent` int(11) NOT NULL,
  `login_parent` varchar(30) NOT NULL,
  `mdp_parent` varchar(255) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `tel` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `compte_parent`
--

INSERT INTO `compte_parent` (`id_parent`, `login_parent`, `mdp_parent`, `mail`, `tel`) VALUES
(3, 'b', '92eb5ffee6ae2fec3ad71c777531578f', '', 0),
(4, 'aaa', '9834876dcfb05cb167a5c24953eba58c4ac89b1adf57f28f2f9d09af107ee8f0', 'aaa@aaa.de', 1234567891),
(5, 'aaa', '9834876dcfb05cb167a5c24953eba58c4ac89b1adf57f28f2f9d09af107ee8f0', 'aaa@aaa.de', 1234567891),
(6, 'aaa', '9834876dcfb05cb167a5c24953eba58c4ac89b1adf57f28f2f9d09af107ee8f0', 'aaa@gmail.com', 0),
(7, 'aaa', '9834876dcfb05cb167a5c24953eba58c4ac89b1adf57f28f2f9d09af107ee8f0', 'aaa@gmail.com', 0),
(8, 'aaa', '9834876dcfb05cb167a5c24953eba58c4ac89b1adf57f28f2f9d09af107ee8f0', 'aaa@aaa.de', 1234567891),
(9, 'aaa', '9834876dcfb05cb167a5c24953eba58c4ac89b1adf57f28f2f9d09af107ee8f0', 'aaa@aaa.de', 1234567891),
(10, 'zzz', '17f165d5a5ba695f27c023a83aa2b3463e23810e360b7517127e90161eebabda', 'zzz@ooo.ki', 1234567890),
(11, 'test', '9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', 'test@gmail.com', 0),
(14, 'bastien', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'test@test.com', 0);

-- --------------------------------------------------------

--
-- Structure de la table `creche`
--

CREATE TABLE `creche` (
  `id_enfant` int(11) NOT NULL,
  `nb_utilisation_creche` int(3) NOT NULL,
  `id_suivi_enfant` int(11) NOT NULL,
  `id_compte_assistante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `historique`
--

CREATE TABLE `historique` (
  `id_historique` int(11) NOT NULL,
  `table_modifier` varchar(50) NOT NULL,
  `modifieur` varchar(50) NOT NULL,
  `id_information_garde` int(11) NOT NULL,
  `id_historique_parent` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `information_garde`
--

CREATE TABLE `information_garde` (
  `id_information_garde` int(11) NOT NULL,
  `heure_arrivee` time NOT NULL,
  `heure_depart` time NOT NULL,
  `nb_repas` int(4) NOT NULL,
  `frais_sup` double NOT NULL,
  `id_assistante` int(11) NOT NULL,
  `id_parent` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `salaire_nurse`
--

CREATE TABLE `salaire_nurse` (
  `id_salaire_nurse` int(11) NOT NULL,
  `nb_heure_garde_sup` double NOT NULL,
  `nb_repas` int(4) NOT NULL,
  `nb_heure_sup` int(3) NOT NULL,
  `frais_entretien` int(4) NOT NULL,
  `frais_transport` int(4) NOT NULL,
  `montant_caf` int(4) NOT NULL,
  `id_assistante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `suivie_enfant`
--

CREATE TABLE `suivie_enfant` (
  `id_suivi_enfant` int(11) NOT NULL,
  `nom_assistante` varchar(30) DEFAULT NULL,
  `prenom_assistante` varchar(30) DEFAULT NULL,
  `nom_enfant` varchar(30) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `prenom_enfant` varchar(30) NOT NULL,
  `comportement_enfant` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `id_compte_parent` int(11) NOT NULL,
  `atelier_inscrit` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `suivie_enfant`
--

INSERT INTO `suivie_enfant` (`id_suivi_enfant`, `nom_assistante`, `prenom_assistante`, `nom_enfant`, `age`, `prenom_enfant`, `comportement_enfant`, `date`, `id_compte_parent`, `atelier_inscrit`) VALUES
(1, 'test', 'test', 'cellier', NULL, 'patrick', 'test', '2023-03-15', 8, 0),
(3, 'test', 'test', 'cellier', NULL, 'pat', 'test', '2023-03-15', 8, 0),
(4, 'test', 'test', 'cellier', NULL, 'bapas', 'test', '2023-03-15', 8, 8),
(6, NULL, NULL, 'd', 45, 'd', NULL, NULL, 14, NULL),
(7, NULL, NULL, 'test', 2, 'test', NULL, NULL, 14, NULL);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `affectation`
--
ALTER TABLE `affectation`
  ADD PRIMARY KEY (`id_enfant`,`id_atelier`),
  ADD KEY `id_atelier` (`id_atelier`);

--
-- Index pour la table `atelier`
--
ALTER TABLE `atelier`
  ADD PRIMARY KEY (`id_atelier`),
  ADD KEY `id_suivi_enfant` (`enfant_inscrit`);

--
-- Index pour la table `compte_assistante`
--
ALTER TABLE `compte_assistante`
  ADD PRIMARY KEY (`id_assistante`),
  ADD KEY `id_suivi_enfant` (`id_suivi_enfant`),
  ADD KEY `compte_assistante_ibfk_2` (`id_creche`);

--
-- Index pour la table `compte_parent`
--
ALTER TABLE `compte_parent`
  ADD PRIMARY KEY (`id_parent`);

--
-- Index pour la table `creche`
--
ALTER TABLE `creche`
  ADD PRIMARY KEY (`id_enfant`),
  ADD KEY `id_suivi_enfant` (`id_suivi_enfant`),
  ADD KEY `id_compte_assistante` (`id_compte_assistante`);

--
-- Index pour la table `historique`
--
ALTER TABLE `historique`
  ADD PRIMARY KEY (`id_historique`),
  ADD KEY `id_information_garde` (`id_information_garde`),
  ADD KEY `id_historique_parent` (`id_historique_parent`);

--
-- Index pour la table `information_garde`
--
ALTER TABLE `information_garde`
  ADD PRIMARY KEY (`id_information_garde`),
  ADD KEY `information_garde_ibfk_1` (`id_assistante`),
  ADD KEY `id_parent` (`id_parent`);

--
-- Index pour la table `salaire_nurse`
--
ALTER TABLE `salaire_nurse`
  ADD PRIMARY KEY (`id_salaire_nurse`),
  ADD KEY `id_assistante` (`id_assistante`);

--
-- Index pour la table `suivie_enfant`
--
ALTER TABLE `suivie_enfant`
  ADD PRIMARY KEY (`id_suivi_enfant`),
  ADD KEY `id_compte_parent` (`id_compte_parent`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `atelier`
--
ALTER TABLE `atelier`
  MODIFY `id_atelier` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT pour la table `compte_assistante`
--
ALTER TABLE `compte_assistante`
  MODIFY `id_assistante` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `compte_parent`
--
ALTER TABLE `compte_parent`
  MODIFY `id_parent` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT pour la table `creche`
--
ALTER TABLE `creche`
  MODIFY `id_enfant` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `historique`
--
ALTER TABLE `historique`
  MODIFY `id_historique` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `information_garde`
--
ALTER TABLE `information_garde`
  MODIFY `id_information_garde` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `salaire_nurse`
--
ALTER TABLE `salaire_nurse`
  MODIFY `id_salaire_nurse` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `suivie_enfant`
--
ALTER TABLE `suivie_enfant`
  MODIFY `id_suivi_enfant` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `affectation`
--
ALTER TABLE `affectation`
  ADD CONSTRAINT `affectation_ibfk_1` FOREIGN KEY (`id_atelier`) REFERENCES `atelier` (`id_atelier`),
  ADD CONSTRAINT `affectation_ibfk_2` FOREIGN KEY (`id_enfant`) REFERENCES `suivie_enfant` (`id_suivi_enfant`);

--
-- Contraintes pour la table `compte_assistante`
--
ALTER TABLE `compte_assistante`
  ADD CONSTRAINT `compte_assistante_ibfk_1` FOREIGN KEY (`id_suivi_enfant`) REFERENCES `suivie_enfant` (`id_suivi_enfant`),
  ADD CONSTRAINT `compte_assistante_ibfk_2` FOREIGN KEY (`id_creche`) REFERENCES `creche` (`id_enfant`);

--
-- Contraintes pour la table `creche`
--
ALTER TABLE `creche`
  ADD CONSTRAINT `creche_ibfk_1` FOREIGN KEY (`id_suivi_enfant`) REFERENCES `suivie_enfant` (`id_suivi_enfant`),
  ADD CONSTRAINT `creche_ibfk_2` FOREIGN KEY (`id_compte_assistante`) REFERENCES `compte_assistante` (`id_assistante`);

--
-- Contraintes pour la table `historique`
--
ALTER TABLE `historique`
  ADD CONSTRAINT `historique_ibfk_1` FOREIGN KEY (`id_information_garde`) REFERENCES `information_garde` (`id_information_garde`),
  ADD CONSTRAINT `historique_ibfk_2` FOREIGN KEY (`id_historique_parent`) REFERENCES `compte_parent` (`id_parent`);

--
-- Contraintes pour la table `information_garde`
--
ALTER TABLE `information_garde`
  ADD CONSTRAINT `information_garde_ibfk_1` FOREIGN KEY (`id_assistante`) REFERENCES `compte_assistante` (`id_assistante`),
  ADD CONSTRAINT `information_garde_ibfk_2` FOREIGN KEY (`id_parent`) REFERENCES `compte_parent` (`id_parent`);

--
-- Contraintes pour la table `salaire_nurse`
--
ALTER TABLE `salaire_nurse`
  ADD CONSTRAINT `salaire_nurse_ibfk_1` FOREIGN KEY (`id_assistante`) REFERENCES `compte_assistante` (`id_assistante`);

--
-- Contraintes pour la table `suivie_enfant`
--
ALTER TABLE `suivie_enfant`
  ADD CONSTRAINT `suivie_enfant_ibfk_1` FOREIGN KEY (`id_compte_parent`) REFERENCES `compte_parent` (`id_parent`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
