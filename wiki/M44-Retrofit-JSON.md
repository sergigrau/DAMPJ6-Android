# M44 – Retrofit amb Objectes JSON i Gson

## Objectiu
Realitzar peticions i parsejar respostes en format JSON utilitzant Retrofit amb Gson Converter.

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M44_RetrofitJsonActivity.java` | Activitat principal amb `JsonObject` i Gson |

## Conceptes Clau
```java
Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("http://192.168.1.14:8000/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();
```

---
[Home](Home) | [M43](M43-Retrofit-Cache)
