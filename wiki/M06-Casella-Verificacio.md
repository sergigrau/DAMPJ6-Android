# M06 – Casella de Verificació (CheckBox)

## Objectiu
Aprendre a gestionar la selecció i el canvi d'estat d'una casella de verificació (`CheckBox`).

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M06_CasellaVerificacioActivity.java` | Activitat que gestiona l'esdeveniment `OnCheckedChangeListener` |
| `res/layout/m06_casella_verificacio.xml` | Layout amb el giny `CheckBox` |

## Conceptes Clau

### OnCheckedChangeListener
```java
cb = findViewById(R.id.check);
cb.setOnCheckedChangeListener(this);

@Override
public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    if (isChecked) {
        cb.setText("el checkbox està marcat");
    } else {
        cb.setText("el checkbox està desmarcat");
    }
}
```

---
[Home](Home) | [M05](M05-Ginys-Basics) | [M07](M07-Botons-Radio)
