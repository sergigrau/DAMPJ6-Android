# M34 – Connexió HTTP Bàsica (HttpURLConnection)

## Objectiu
Descarregar contingut web d'Internet utilitzant la classe nativa `HttpURLConnection`.

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M34_ConnexioHTTPActivity.java` | Activitat que executa la petició HTTP |

## Conceptes Clau

### Lectura de Stream amb try-with-resources
```java
try (var reader = new BufferedReader(new InputStreamReader(in))) {
    String linia;
    var linies = new StringBuilder();
    while ((linia = reader.readLine()) != null) {
        linies.append(linia);
    }
    text.setText(linies.toString());
}
```

---
[Home](Home) | [M33](M33-Contactes-Provider) | [M36](M36-Comunicacio-JSON)
