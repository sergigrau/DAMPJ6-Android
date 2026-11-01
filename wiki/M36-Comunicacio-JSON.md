# M36 – Comunicació JSON amb Backend en Python

## Objectiu
Enviar i rebre dades en format JSON amb un servidor web i parsejar la resposta amb `JSONObject` i Java **`record`**.

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M36_ComunicacioJSONActivity.java` | Activitat de lectura/escriptura JSON |
| `assets/servidorweb.py` | Servidor backend en Python |

## Conceptes Clau

### Parseig de JSON i Record
```java
public record Usuari(String nom, String cognom) {}

var objecte = new JSONObject(dadesLlegides);
Log.i("JSON", objecte.getString("nom"));
```

---
[Home](Home) | [M34](M34-Connexio-HTTP) | [M37](M37-GridView-Personalitzat)
