# M14 – ListActivity i Selecció Múltiple amb Intents

## Objectiu
Presentar una llista d'elements amb opció de selecció múltiple (`CHOICE_MODE_MULTIPLE`) i passar els elements seleccionats a una activitat secundària.

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M14_ListActivityIntentActivity.java` | Activitat amb llista i selecció múltiple |
| `M14_ListActivityIntentDepenentActivity.java` | Activitat que mostra el resultat de la selecció |
| `res/values/items.xml` | Recursos de matrius de cadenes (`R.array.fruites`) |

## Conceptes Clau

### Selecció Múltiple a ListView
```java
adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, items);
getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
getListView().setAdapter(adapter);
```

### Recull d'Elements Seleccionats
```java
SparseBooleanArray checked = parent.getCheckedItemPositions();
var itemsSeleccionats = new ArrayList<String>();
for (int i = 0; i < checked.size(); i++) {
    int pos = checked.keyAt(i);
    if (checked.valueAt(i)) itemsSeleccionats.add(adapter.getItem(pos));
}
```

---
[Home](Home) | [M13](M13-Grid-Layout) | [M15](M15-Spinner)
