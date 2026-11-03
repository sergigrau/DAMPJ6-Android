# M43 – Retrofit amb OkHttp i Memòria Cau en Disc

## Objectiu
Configurar OkHttp amb cau en disc (`okhttp3.Cache`) i integrar-lo amb Retrofit.

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M43_RetrofitCacheActivity.java` | Activitat amb configuració avançada d'OkHttp i Retrofit |

## Conceptes Clau
```java
Cache cache = new Cache(cacheDir, 1024 * 1024);
OkHttpClient okHttpClient = new OkHttpClient.Builder()
        .cache(cache)
        .build();
```

---
[Home](Home) | [M42](M42-Retrofit-Basic) | [M44](M44-Retrofit-JSON)
