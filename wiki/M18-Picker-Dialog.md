# M18 – Diàlegs de Selecció de Data i Hora (Picker Dialogs)

## Objectiu
Utilitzar `DatePickerDialog` i `TimePickerDialog` per permetre a l'usuari seleccionar dates i hores mitjançant diàlegs emergents.

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M18_PickerDialogActivity.java` | Activitat amb els diàlegs de data i hora |
| `res/layout/m18_picker_dialog.xml` | Layout amb botons d'obertura dels diàlegs |

## Conceptes Clau

### DatePickerDialog & TimePickerDialog amb Lambdas
```java
DatePickerDialog.OnDateSetListener d = (view, year, monthOfYear, dayOfMonth) -> {
    dataHora.set(Calendar.YEAR, year);
    dataHora.set(Calendar.MONTH, monthOfYear);
    dataHora.set(Calendar.DAY_OF_MONTH, dayOfMonth);
    actualitzarEtiqueta();
};

new DatePickerDialog(this, d, dataHora.get(Calendar.YEAR),
        dataHora.get(Calendar.MONTH),
        dataHora.get(Calendar.DAY_OF_MONTH)).show();
```

---
[Home](Home) | [M17](M17-Celles) | [M19](M19-Tabs)
