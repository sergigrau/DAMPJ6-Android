# M21 – Fils d'Execució i Barra de Progrés (Thread i Handler)

## Objectiu
Executar tasques en segon pla mitjançant `Thread` i comunicar-se amb el fil principal de la interfície d'usuari (UI Thread) utilitzant un `Handler` per actualitzar una `ProgressBar`.

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M21_FilsBarraProgresActivity.java` | Activitat amb la lògica del fil i el Handler |
| `res/layout/m21_fils_barra_progres.xml` | Layout amb el giny `ProgressBar` |

## Conceptes Clau

### Comunicació de Fils amb Handler
```java
Handler handler = new Handler() {
    @Override
    public void handleMessage(Message msg) {
        barraProgress.incrementProgressBy(5);
    }
};

Thread background = new Thread(() -> {
    try {
        for (int i = 0; i < 20 && isExecutant; i++) {
            Thread.sleep(1000);
            handler.sendMessage(handler.obtainMessage());
        }
    } catch (Throwable t) {}
});
background.start();
```

---
[Home](Home) | [M20](M20-Menus-Emergents) | [M22](M22-Google-Maps)
