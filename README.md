# Jeu de Domino

## Présentation

Ce jeu est un jeu de dominos programmé en Java 17, utilisant les librairies Swing et AWT. Il s'inspire largement du jeu de société d'origine chinoise "Dominos", qui utilise 28 pièces.

Le principe est simple : dans un espace de jeu, les joueurs doivent placer des dominos. Le jeu se joue à deux, chaque joueur pouvant déplacer son domino pour le placer de part et d'autre de la chaîne. Pour placer un domino, les faces des dominos qui se touchent doivent être équivalentes. Le but est d'obtenir le plus de points pour gagner la partie.

# Jeu de Carcassonne

## Présentation

Ce jeu est une adaptation programmée en Java 17 du jeu de société "Carcassonne", utilisant les librairies Swing et AWT. Inspiré par le jeu original de Klaus-Jürgen Wrede édité par Hans im Glück, son thème est la construction d'un paysage médiéval à travers la pose de tuiles, incluant des villes fortifiées comme Carcassonne.

Le principe est de construire le plateau de jeu en posant des tuiles. Des points sont attribués pour les combinaisons de villes, champs, routes et abbayes. Le jeu commence avec une tuile et les autres sont piochées au fur et à mesure. Les joueurs doivent poser les tuiles en respectant les connexions avec celles déjà en place. Le jeu se termine lorsque toutes les tuiles ont été posées, et les points sont alors comptabilisés.

## Exécution et compilation

Après avoir téléchargé et décompressé le dépôt, dans une console, placez-vous dans le répertoire `pooig` et tapez les commandes suivantes :

```bash
javac Domino/gui/HomePage.java
java Domino/gui/HomePage
```

## Jouer

Pour naviguer dans l'application, tout se fait à l'aide de la souris. Vous serez d'abord sur la page d'accueil "HomePage" sur laquelle vous pouvez choisir de jouer aux dominos ou bien à
Carcassonne. Une fois redirigé sur l'une ou l'autre des pages le principe reste le même. Vous pourez choisir de jouer, de voir les instructions du jeu en question ou de revenir sur la
page d'accueil. Amusez vous !


**Jeu de domino :**

Cliquer sur votre domino pour le déplacer. Si vous ne pouvez pas le placer, passer votre tour. Le joueur ayant marqué le plus de points à la fin du jeu remport la partie.

**Carcassonne :**

Appuyer sur une case du plateau afin de placer votre tuile. Il vous sera ensuite demandé si vous voulez placer un partisan (un pion), répondez par les propositions qui vous sont faites.
Dans de très rares cas ou vous ne pouriez pas placer votre tuile, piochez en une autre.
