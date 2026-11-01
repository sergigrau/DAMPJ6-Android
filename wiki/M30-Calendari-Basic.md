# M30 – Afegir Esdeveniments al Calendari via Intent

## Objectiu
Obrir l'aplicació de calendari del sistema per afegir un nou esdeveniment mitjançant un `Intent` explícit.

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M30_CalendariBasicActivity.java` | Activitat emissora de l'intent de calendari |

## Conceptes Clau
```java
var intent = new Intent(Intent.ACTION_EDIT);
intent.setType("vnd.android.cursor.item/event");
intent.putExtra("title", "ESDEVENIMENT PROGRAMAT");
startActivityForResult(intent, EVENT_AFEGIT);
```

---
[Home](Home) | [M29](M29-Base-De-Dades-Assets) | [M31](M31-Calendari-Ampliat)
