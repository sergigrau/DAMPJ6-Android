# M40 – Comunicació Bluetooth RFCOMM i Lego NXT

## Objectiu
Establir una connexió Bluetooth RFCOMM amb un dispositiu extern (Lego NXT) per enviar comandes de so i control.

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M40_ConnexioBluetooth.java` | Activitat per descobrir i aparellar dispositius |
| `M40_ConnexioBlueToothFilClient.java` | Fil client per enviar el protocol LPC a Lego NXT |
| `M40_ConnexioBlueToothFilServidor.java` | Fil servidor que escolta connexions entrants Bluetooth |

## Conceptes Clau
- `BluetoothAdapter`, `BluetoothDevice`, `BluetoothSocket`
- Permisos `BLUETOOTH` i `BLUETOOTH_ADMIN`.

---
[Home](Home) | [M38](M38-GridView) | [M41](M41-Resultat)
