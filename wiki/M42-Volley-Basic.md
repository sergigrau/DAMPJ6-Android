# M42 – Peticions HTTP Bàsiques amb Volley

## Objectiu
Utilitzar la llibreria Google Volley per gestionar peticions asíncrones de xarxa amb `StringRequest`.

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M42_VolleyBasicActivity.java` | Activitat que executa la petició Volley |

## Conceptes Clau
```java
RequestQueue cuaPeticions = Volley.newRequestQueue(this);
var cadenaPeticio = new StringRequest(Request.Method.GET, url,
        resposta -> textSortida.setText("La resposta és: " + resposta),
        error -> textSortida.setText("no funciona!"));
cuaPeticions.add(cadenaPeticio);
```

---
[Home](Home) | [M41](M41-Resultat) | [M43](M43-Volley-CuaPeticions)
