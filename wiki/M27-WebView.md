# M27 – Navegador Webkit i HTML5 (WebView)

## Objectiu
Integrar contingut web i executar Javascript dins de l'aplicació mitjançant el giny `WebView`.

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M27_WebViewActivity.java` | Activitat amb la configuració de `WebView` |
| `res/layout/m27_webview.xml` | Layout amb el giny `WebView` |

## Conceptes Clau
- `navegador.getSettings().setJavaScriptEnabled(true);`
- `navegador.setWebChromeClient(new WebChromeClient() { ... });`

---
[Home](Home) | [M26](M26-TCP) | [M28](M28-Base-De-Dades-Millorat)
