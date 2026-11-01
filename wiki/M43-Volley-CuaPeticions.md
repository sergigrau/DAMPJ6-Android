# M43 – Volley amb Cua, Memòria Cau i Gestió de Xarxa

## Objectiu
Personalitzar la gestió de la cua de peticions de Volley configurant la memòria cau en disc (`DiskBasedCache`) i el motor de xarxa (`BasicNetwork`).

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M43_Volley_CuaPeticions.java` | Activitat amb configuració avançada de Volley |

## Conceptes Clau
```java
Cache cau = new DiskBasedCache(getCacheDir(), 1024 * 1024);
Network xarxa = new BasicNetwork(new HurlStack());
RequestQueue cuaPeticions = new RequestQueue(cau, xarxa);
cuaPeticions.start();
```

---
[Home](Home) | [M42](M42-Volley-Basic) | [M44](M44-Volley-JSON)
