# M44 – Volley amb Objectes JSON

## Objectiu
Realitzar peticions i parsejar respostes en format JSON utilitzant `JsonObjectRequest` de la llibreria Volley.

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M44_Volley_JSON.java` | Activitat principal amb `JsonObjectRequest` |

## Conceptes Clau
```java
JsonObjectRequest peticioJSON = new JsonObjectRequest(
        Request.Method.GET, url, json,
        resposta -> {
            try {
                textSortida.setText("resposta: " + resposta.getString("data"));
            } catch (JSONException e) { e.printStackTrace(); }
        },
        error -> textSortida.setText("problema:")
);
```

---
[Home](Home) | [M43](M43-Volley-CuaPeticions)
