# M42 – Peticions HTTP Bàsiques amb Retrofit + OkHttp

## Objectiu
Utilitzar Retrofit per gestionar peticions asíncrones de xarxa amb `Call<String>`.

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M42_RetrofitBasicActivity.java` | Activitat que executa la petició HTTP amb Retrofit |

## Conceptes Clau
```java
Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("http://192.168.1.14:8000/")
        .addConverterFactory(ScalarsConverterFactory.create())
        .build();
```

---
[Home](Home) | [M41](M41-Resultat) | [M43](M43-Retrofit-Cache)
