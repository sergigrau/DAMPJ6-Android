# M01 – GUI Programada per Codi

## Objectiu
Aprendre a crear una interfície d'usuari directament des del codi Java sense utilitzar descriptors XML de layout.

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M01_GUIProgramadaActivity.java` | Activitat principal que crea dinàmicament un `Button` |

## Conceptes Clau

### Creació de Ginys Programàticament
En lloc d'inflar una vista des d'un fitxer XML, es crea la instància del giny directament passant el `Context`:

```java
boto = new Button(this);
boto.setOnClickListener(this);
mostrarData();
setContentView(boto);
```

### Implementació de View.OnClickListener
L'activitat implementa la interfície `View.OnClickListener` per respondre als esdeveniments de clic:

```java
@Override
public void onClick(View arg0) {
    mostrarData();
}
```

---
[Home](Home) | [M02](M02-GUI-Declarada)
