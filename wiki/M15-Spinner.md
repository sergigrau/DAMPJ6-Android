# M15 – Desplegable Spinner

## Objectiu
Implementar un menú desplegable (`Spinner`) utilitzant un `ArrayAdapter` per enllaçar les dades amb la interfície.

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M15_SpinnerActivity.java` | Activitat que implementa `AdapterView.OnItemSelectedListener` |
| `res/layout/m15_spinner.xml` | Layout amb el giny `Spinner` |

## Conceptes Clau

### ArrayAdapter per Spinner
```java
Spinner spin = findViewById(R.id.spinner);
spin.setOnItemSelectedListener(this);
ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spin.setAdapter(aa);
```

---
[Home](Home) | [M14](M14-ListActivity-Intent) | [M16](M16-AutoCompleteTextView)
