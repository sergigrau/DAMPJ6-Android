# M02 – GUI Declarada en XML

## Objectiu
Aprendre a definir la interfície d'usuari de manera declarativa mitjançant un descriptor XML i vincular els vistes amb el codi Java.

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M02_GUIDeclaradaActivity.java` | Activitat que infla el layout declaratiu |
| `res/layout/m02_gui_declarada.xml` | Fitxer de disseny XML amb la definició del botó |

## Conceptes Clau

### Inflar el Layout XML
S'utilitza `setContentView(R.layout.m02_gui_declarada)` per associar la vista definida en XML amb l'activitat.

### Obtenció de la Referència a la Vista
S'utilitza `findViewById` per obtenir l'objecte botó definit a l'XML:

```java
boto = findViewById(R.id.boto);
```

---
[Home](Home) | [M01](M01-GUI-Programada) | [M03](M03-Comunicacio-Intent)
