# RPG
 
## Initialisation

> Au lancement du jeu, la map est générée aléatoirement. Chaque emplacement est complété soit par une zone de combat, par une zone de soin, par un marchand d'arme ou par un piège.
> 
> Le joueur choisi sa caste (Barbare, Magicien et archer).
> 
> La map a une dimension de 4 * 4 et le joueur peut se déplacer à l'intérieur. Son but est d'arriver dans le coin supérieur droit.

## Partie

### Combat

>Les zones de combat sont générées aléatoirement avec des monstres différents à chaque fois.
> Les monstres ont des patterns d'attaques représentés par une liste d'action.
> Le joueur quand à lui choisie une arme au début du combat parmis celles qu'il possède et se bat avec.

### Piège

>Lorsque le joueur tombe sur un piège au cours de son aventure, il perd 20 PV.

### Marchant

>Ce dernier propose une liste d'arme à acheter au joueur. Elles sont différentes en fonction de la caste choisie. Le joueur ne peut les acheter seulement s'il possède assez d'argent.

### Feu de camp

>Lorsque le joueur tombe sur un feu de camp, il récupère 20 PV.

La partie se termine lorsque le joueur meurt ou s'il arrive à atteindre le coin supérieur droit de la map.