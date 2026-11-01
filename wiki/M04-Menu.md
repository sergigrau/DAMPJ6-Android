# M04 – Menús a l'Action Bar i Snackbar

## Objectiu
Implementar un menú d'opcions a la barra d'acció (`Toolbar`) i mostrar notificacions breus utilitzant `Snackbar`.

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M04_Menu.java` | Activitat amb gestió de Toolbar i Menú |
| `res/menu/m04_menu.xml` | Descriptor XML del menú d'opcions |
| `res/layout/m04_menu.xml` | Layout principal amb `CoordinatorLayout` i `Toolbar` |

## Conceptes Clau

### Inflar el Menú d'Opcions
```java
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.m04_menu, menu);
    return true;
}
```

### Snackbar Notificació
```java
Snackbar.make(coordinatorLayout, "AJUSTOS", Snackbar.LENGTH_SHORT)
        .setAction("Action", null).show();
```

---
[Home](Home) | [M03](M03-Comunicacio-Intent) | [M05](M05-Ginys-Basics)
