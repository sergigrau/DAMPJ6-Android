# M25 – Càrrega Asíncrona de Dades amb Loader

## Objectiu
Carregar dades de manera asíncrona des d'un ContentProvider utilitzant `CursorLoader` i `LoaderManager`.

## Fitxers Implicats
| Fitxer | Descripció |
|--------|------------|
| `M25_LoaderActivity.java` | Fragment amb la implementació de `LoaderCallbacks` |
| `M25_LoaderMilloratActivity.java` | Activitat amb indicador de carregar per al Loader |

## Conceptes Clau
- `LoaderManager.LoaderCallbacks<Cursor>`
- `onCreateLoader`, `onLoadFinished`, `onLoaderReset`

---
[Home](Home) | [M24](M24-Acces-Contactes) | [M26](M26-TCP)
