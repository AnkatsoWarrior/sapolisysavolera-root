# sapolisysavolera-root 

## Présentation

Vous trouvez ici la premiere version jouable de Sa Polisy Sa Volera. Il s'agit d'un petit jeu 2D développé en Java.
Cela signifie que ce jeu requiert une installation préalable de [la machine virtuelle Java](http://www.oracle.com/technetwork/java/javase/downloads/index.html) sur votre machine.

## Principe du jeu

Il y a principalement 4 acteurs dans ce jeu : 3 policiers et un voleur.
L'objectif est de se servir des 3 policiers pour coincer le voleur.

![](https://raw.githubusercontent.com/Andriantomanga/sapolisysavolera-root/master/sapolisysavolera.PNG)

## Informations complémentaires

Pour toute information ou critique concernant ce petit jeu, n'hesitez pas pour [me contacter](http://nabil.zz.mu).

## Piste d'améliorations possibles :

- Améliorer l'intelligence artificielle du voleur
- Implémenter la version 2 joeurs et l'intégrer

## Release

Vous pouvez voir les releases dans le repertoire ```sapolisysavolera-root\releases```. Pour lancer spsv :

- Sur Linux : ```sh spsv```

- Sur Windows : ```spsv.bat```

## Build

Pour creer un executable, sur le module ``` sapolisysavolera-core``` la commande suivante :

```
mvn package appassembler:assemble 

```

Ensuite, copiez le repertoire ```spsv-pix``` dans le repertoire ```bin```  (à côté des scripts de lancement).


========

Meilleures salutations,

========

Le développeur

