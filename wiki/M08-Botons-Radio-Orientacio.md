# M08 – Modificació d'Orientació i Gravetat amb RadioGroup

## Objectiu
Utilitzar un `RadioGroup` per canviar dinàmicament l'orientació i la gravetat d'un contenidor `LinearLayout`.

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M08_BotonsRadioOrientacioActivity.java` | Activitat que modifica les propietats del layout |
| `res/layout/m08_botons_radio_orientacio.xml` | Layout amb RadioGroups per orientació i gravetat |

## Conceptes Clau

### Modificació de Propietats de Layout Dinàmicament
```java
if (checkedId == R.id.horizontal) orientacio.setOrientation(LinearLayout.HORIZONTAL);
if (checkedId == R.id.vertical) orientacio.setOrientation(LinearLayout.VERTICAL);
if (checkedId == R.id.left) gravetat.setGravity(Gravity.LEFT);
if (checkedId == R.id.center) gravetat.setGravity(Gravity.CENTER_HORIZONTAL);
if (checkedId == R.id.right) gravetat.setGravity(Gravity.RIGHT);
```

---
[Home](Home) | [M07](M07-Botons-Radio) | [M09](M09-Relative-Layout)
