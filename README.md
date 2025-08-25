## Pengujian Otomatis Web & API

Repositori ini berisi tes otomatis Final Project Jayjay. 
Pengujian ini berupa tes otomatis Web UI dan API dalam satu proyek. 
Proyek ini dibangun dengan Java, Gradle, Behavior-Driven Development (BDD) menggunakan Cucumber

## Prasyarat

Sebelum melakukan automated test, pastikan Anda telah menginstal perangkat lunak berikut:

* **Java Development Kit (JDK):** Proyek ini menggunakan JDK 23.0.2
* **Maven:** Alat otomatisasi build.
* **ChromeDriver:** Pastikan versi ChromeDriver kompatibel dengan browser Chrome Anda.
* **Cucumber untuk Java:** Dependensi Maven.
* **Selenium WebDriver:** Dependensi Maven.
* **Gradle** versi 8.10
* **Browser web:** Google Chrome (versi 136.0.7103.114)
* **RestAssured: Untuk menguji dan memvalidasi REST API.

## Cara Menjalankan Program
* Clone Repository dari Github (Menggunakan Bash Code): git clone https://github.com/junnhoo/FinalProject-Jayjay.git cd FinalProject-Jayjay
* Buka Terminal
* Downlaod Dependencies: ./gradlew build
* Clean Gradle: ./gradlew clean
* Run WEB UI Test: ./gradlew executeWebTests
* Run API Test: ./gradlew executeAPITests


