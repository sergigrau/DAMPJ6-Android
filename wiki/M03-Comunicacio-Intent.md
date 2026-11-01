# M03 – Comunicació entre Activities amb Intent

## Objectiu
Demostrar com passar dades d'una `Activity` a una altra utilitzant un `Intent` explícit.

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M03_ComunicacioIntentActivity.java` | Activitat emissora que crea l'intent |
| `M03_ComunicacioIntentDepenentActivity.java` | Activitat receptora que mostra el missatge |
| `res/layout/m03_comunicacio_intent_depenent.xml` | Layout de l'activitat receptora |

## Conceptes Clau

### Enviament de Dades amb Intent
```java
var intent = new Intent(this, M03_ComunicacioIntentDepenentActivity.class);
var missatge = boto.getText().toString();
intent.putExtra(MISSATGE_CLAU, missatge);
startActivity(intent);
```

### Recepció de Dades
```java
var intent = getIntent();
var missatge = intent.getStringExtra(M03_ComunicacioIntentActivity.MISSATGE_CLAU);
TextView textView = findViewById(R.id.textData);
textView.setText(missatge);
```

---
[Home](Home) | [M02](M02-GUI-Declarada) | [M04](M04-Menu)
