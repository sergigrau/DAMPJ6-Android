# M16 – Autocompletat de Text (AutoCompleteTextView)

## Objectiu
Utilitzar un giny `AutoCompleteTextView` i escoltar els canvis de text en temps real amb `TextWatcher`.

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M16_AutoCompleteTextViewActivity.java` | Activitat que implementa `TextWatcher` |
| `res/layout/m16_auto_complete_text_view.xml` | Layout amb `AutoCompleteTextView` |

## Conceptes Clau

### TextWatcher
```java
entrada = findViewById(R.id.entrada);
entrada.addTextChangedListener(this);
entrada.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, items));

@Override
public void onTextChanged(CharSequence s, int start, int before, int count) {
    seleccio.setText(entrada.getText());
}
```

---
[Home](Home) | [M15](M15-Spinner) | [M17](M17-Celles)
