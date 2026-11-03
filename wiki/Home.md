# DAM2.PJ6 – Android Application Development

Benvingut/da a la wiki del projecte **DAMPJ6-Android**, una col·lecció d'exercicis pràctics de desenvolupament d'aplicacions Android en **Java (JDK 25)** per al mòdul del Projecte DAM2.

---

## Taula de Continguts

| Mòdul | Títol | Conceptes Clau |
|-------|-------|----------------|
| [M01](M01-GUI-Programada) | GUI Programada | `Button`, `setContentView`, `OnClickListener` |
| [M02](M02-GUI-Declarada) | GUI Declarada | `setContentView(R.layout...)`, XML Layout |
| [M03](M03-Comunicacio-Intent) | Comunicació entre Activities | `Intent`, `putExtra`, `getStringExtra` |
| [M04](M04-Menu) | Menús i Action Bar | `Toolbar`, `onCreateOptionsMenu`, `Snackbar` |
| [M05](M05-Ginys-Basics) | Ginys Bàsics | `EditText`, XML layouts, Formularis |
| [M06](M06-Casella-Verificacio) | Casella de Verificació | `CheckBox`, `OnCheckedChangeListener` |
| [M07](M07-Botons-Radio) | Botons de Ràdio | `RadioButton`, `RadioGroup` |
| [M08](M08-Botons-Radio-Orientacio) | Orientació i Gravetat | `LinearLayout`, `setOrientation`, `setGravity` |
| [M09](M09-Relative-Layout) | RelativeLayout | `RelativeLayout`, posicionament relatiu |
| [M10](M10-Superposicio-Ginys) | Superposició de Ginys | `RelativeLayout`, capes de la interfície |
| [M11](M11-Table-Layout) | TableLayout | `TableLayout`, `TableRow` |
| [M12](M12-Scroll-View) | ScrollView | `ScrollView`, contingut desplaçable |
| [M13](M13-Grid-Layout) | GridLayout | `GridLayout`, graella de ginys |
| [M14](M14-ListActivity-Intent) | ListActivity i Selecció Múltiple | `ListActivity`, `CHOICE_MODE_MULTIPLE` |
| [M15](M15-Spinner) | Desplegable Spinner | `Spinner`, `OnItemSelectedListener`, `ArrayAdapter` |
| [M16](M16-AutoCompleteTextView) | Autocompletat de Text | `AutoCompleteTextView`, `TextWatcher` |
| [M17](M17-Celles) | GridView i Cel·les | `GridView`, `OnItemClickListener` |
| [M18](M18-Picker-Dialog) | Picker Dialogs | `DatePickerDialog`, `TimePickerDialog` |
| [M19](M19-Tabs) | Pestanyes TabHost | `TabHost`, `TabSpec` |
| [M20](M20-Menus-Emergents) | Menús Emergents | Context Menu, `registerForContextMenu` |
| [M21](M21-Fils-Barra-Progres) | Fils i Barra de Progrés | `Thread`, `Handler`, `ProgressBar` |
| [M22](M22-Google-Maps) | Maps via Intent | `Intent.ACTION_VIEW`, `geo:lat,lng` |
| [M23](M23-Base-De-Dades-Basic) | Base de Dades SQLite Bàsica | `SQLiteDatabase`, `execSQL`, `rawQuery` |
| [M24](M24-Acces-Contactes) | Accés a Contactes | `ContactsContract`, Permisos en temps d'execució |
| [M25](M25-Loader) | Càrrega Asíncrona amb Loader | `LoaderManager`, `CursorLoader`, `SimpleCursorAdapter` |
| [M26](M26-TCP) | Comunicació TCP Sòcols | `Socket`, `ServerSocket`, `StrictMode` |
| [M27](M27-WebView) | Navegador Webkit | `WebView`, `WebChromeClient`, HTML5 |
| [M28](M28-Base-De-Dades-Millorat) | SQLite amb Helper i Contracts | `SQLiteOpenHelper`, `BaseColumns`, `record` |
| [M29](M29-Base-De-Dades-Assets) | Còpia de BD des d'Assets | `getAssets()`, `SQLiteDatabase.openDatabase` |
| [M30](M30-Calendari-Basic) | Calendari via Intent | `Intent.ACTION_EDIT`, `Calendar` |
| [M31](M31-Calendari-Ampliat) | Calendari Provider | `CalendarContract.Events`, `ContentResolver` |
| [M32](M32-Contactes) | Selecció de Contactes | `Intent.ACTION_PICK`, `ContactsContract` |
| [M33](M33-Contactes-Provider) | Proveïdor de Contactes | `ContentResolver.query`, `SimpleCursorAdapter` |
| [M34](M34-Connexio-HTTP) | Connexió HTTP Bàsica | `HttpURLConnection`, `ConnectivityManager` |
| [M36](M36-Comunicacio-JSON) | Comunicació JSON | `HttpURLConnection`, `JSONObject`, `record` |
| [M37](M37-GridView-Personalitzat) | GridView Personalitzat | `BaseAdapter`, `LayoutInflater`, `ImageView` |
| [M38](M38-GridView) | GridView Estàndard | `GridView`, `ArrayAdapter` |
| [M39](M39-Scrolling-Infinit) | Scrolling Infinit | `RecyclerView`, `LinearLayoutManager`, paginació |
| [M40](M40-Bluetooth) | Comunicació Bluetooth RFCOMM | `BluetoothAdapter`, `BluetoothSocket`, Lego NXT |
| [M41](M41-Resultat) | Retorn de Resultats | `startActivityForResult`, `setResult` |
| [M42](M42-Retrofit-Basic) | Retrofit HTTP Bàsic | `Retrofit`, `ScalarsConverterFactory`, `Call` |
| [M43](M43-Retrofit-Cache) | Retrofit amb Memòria Cau | `OkHttpClient`, `Cache`, `Retrofit` |
| [M44](M44-Retrofit-JSON) | Retrofit JSON | `GsonConverterFactory`, `JsonObject` |

---

## Tecnologies del Projecte

- **Llenguatge:** Java 25 (JDK 25 toolchain)
- **Min SDK:** Android 8.1 (API 27)
- **Target SDK:** Android 16 (API 36)
- **Eina de construcció:** Android Gradle Plugin 8.9.0 / Gradle 9.8.2
- **Llibreries:** AppCompat, Material Design, Retrofit, OkHttp, Gson

---

> **Autor:** sergi.grau@fje.edu | **Curs:** 2026-27
