# M23 – Base de Dades SQLite Bàsica

## Objectiu
Crear i manipular una base de dades local SQLite3 directament des de l'activitat utilitzant `openOrCreateDatabase`.

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M23_BaseDeDadesBasicActivity.java` | Activitat que executa sentències DDL i DML SQLite |

## Conceptes Clau

### Execució de SQL i Cursors amb try-with-resources
```java
try (SQLiteDatabase baseDades = openOrCreateDatabase("dam2", MODE_PRIVATE, null)) {
    baseDades.execSQL("CREATE TABLE IF NOT EXISTS usuari (nom VARCHAR, edat INT);");
    baseDades.execSQL("INSERT INTO usuari VALUES ('sergi', 38);");

    try (Cursor c = baseDades.rawQuery("SELECT nom, edat FROM usuari;", null)) {
        if (c.moveToFirst()) {
            do {
                String nom = c.getString(c.getColumnIndex("nom"));
            } while (c.moveToNext());
        }
    }
}
```

---
[Home](Home) | [M22](M22-Google-Maps) | [M24](M24-Acces-Contactes)
