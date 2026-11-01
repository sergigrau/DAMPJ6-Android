# M31 – Gestió del Calendari via ContentProvider

## Objectiu
Consulta i creació d'esdeveniments directament sobre el proveïdor de continguts del calendari d'Android (`CalendarContract`).

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M31_CalendariAmpliatActivity.java` | Activitat amb consultes `ContentResolver` a `CalendarContract` |

## Conceptes Clau
- `CalendarContract.Events.CONTENT_URI`
- Permisos `WRITE_CALENDAR` i `READ_CALENDAR`.

---
[Home](Home) | [M30](M30-Calendari-Basic) | [M32](M32-Contactes)
