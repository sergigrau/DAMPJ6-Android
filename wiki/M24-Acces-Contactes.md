# M24 – Accés als Contactes del Dispositiu

## Objectiu
Accedir a la llista de contactes del dispositiu sol·licitant permisos en temps d'execució (`Manifest.permission.READ_CONTACTS`).

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M24_AccesContactesActivity.java` | Activitat amb petició de permís i lectura de contactes |
| `res/layout/m24_acces_contactes.xml` | Layout amb botó de selecció |

## Permisos Requerits
`<uses-permission android:name="android.permission.READ_CONTACTS" />`

---
[Home](Home) | [M23](M23-Base-De-Dades-Basic) | [M25](M25-Loader)
