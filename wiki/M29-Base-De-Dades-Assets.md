# M29 – Còpia de Base de Dades des d'Assets

## Objectiu
Copiar un fitxer de base de dades SQLite precarregat a la carpeta `assets/` cap al directori privat de bases de dades de l'aplicació.

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M29_BaseDeDadesCopiaAssets.java` | Activitat i classe `UtilitatCopia` |

## Conceptes Clau
- `context.getDatabasePath(DB_NAME)`
- Còpia de fitxer binari des d' `InputStream` d'assets a `FileOutputStream`.

---
[Home](Home) | [M28](M28-Base-De-Dades-Millorat) | [M30](M30-Calendari-Basic)
