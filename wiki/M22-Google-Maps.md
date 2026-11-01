# M22 – Obrir Google Maps mitjançant Intent

## Objectiu
Llançar una aplicació de mapes externa utilitzant un `Intent` amb la URI de coordinades geogràfiques (`geo:lat,lng`).

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M22_GoogleMapsActivity.java` | Activitat amb la captura de latitud/longitud |
| `res/layout/m22_google_maps.xml` | Layout amb camps de text per latitud i longitud |

## Conceptes Clau

### Intent de Geolocalització
```java
btn.setOnClickListener(view -> {
    var _lat = lat.getText().toString();
    var _lon = lng.getText().toString();
    var uri = Uri.parse("geo:" + _lat + "," + _lon);
    startActivity(new Intent(Intent.ACTION_VIEW, uri));
});
```

---
[Home](Home) | [M21](M21-Fils-Barra-Progres) | [M23](M23-Base-De-Dades-Basic)
