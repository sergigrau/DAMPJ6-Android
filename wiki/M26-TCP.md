# M26 – Comunicació per Sòcols TCP Client i Servidor

## Objectiu
Establir una comunicació en xarxa punt a punt utilitzant sòcols TCP (`Socket` i `ServerSocket`).

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M26_ClientTCPActivity.java` | Activitat client que es connecta al port TCP 12345 |
| `M26_ServidorTCPActivity.java` | Activitat servidor que escolta connexions |

## Conceptes Clau

### Gestió de Sòcols amb try-with-resources (Java 25)
```java
try (var s = new Socket("192.168.1.13", 12345);
     var out = new PrintWriter(s.getOutputStream(), true);
     var in = new BufferedReader(new InputStreamReader(s.getInputStream()))) {

    out.println("SERGI");
    String res = in.readLine();
} catch (IOException e) {
    e.printStackTrace();
}
```

---
[Home](Home) | [M25](M25-Loader) | [M27](M27-WebView)
