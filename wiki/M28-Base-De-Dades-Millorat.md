# M28 – SQLite amb OpenHelper, Contracts i Records

## Objectiu
Estructurar l'accés a SQLite utilitzant `SQLiteOpenHelper`, una classe Contracte, i representar dades immutables amb Java **`record`**.

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M28_BaseDeDadesMilloratActivity.java` | Activitat principal, helper `AlumneDbUtilitat` i `record AlumneRecord` |

## Conceptes Clau

### Java Record (Java 25)
```java
record AlumneRecord(String codi, String nom, int nota) {
    public ContentValues toContentValues() {
        var valors = new ContentValues();
        valors.put(AlumneContract.TaulaAlumne.COLUMNA_CODI, codi);
        valors.put(AlumneContract.TaulaAlumne.COLUMNA_NOM, nom);
        valors.put(AlumneContract.TaulaAlumne.COLUMNA_NOTA, nota);
        return valors;
    }
}
```

---
[Home](Home) | [M27](M27-WebView) | [M29](M29-Base-De-Dades-Assets)
