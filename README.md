# Tugas Membuat Web UI Automation

Framework otomasi testing web menggunakan **Cucumber**, **Selenium WebDriver**, dan **JUnit 5** dengan pendekatan **Page Object Model (POM)**.

## Teknologi

- **Java 17**
- **Gradle 9.4.1**
- **Cucumber 7.21.1** - BDD test framework
- **Selenium 4.29.0** - Browser automation
- **JUnit 5.11.4** - Test runner
- **WebDriverManager 5.9.3** - Otomatisasi ChromeDriver

## Struktur Proyek

```
tugas_cucumber_selenium/
├── build.gradle                    # Konfigurasi dependensi Gradle
├── settings.gradle                 # Pengaturan proyek
├── testing.xml                     # Konfigurasi test suite
├── src/
│   └── test/
│       ├── java/tests/
│       │   ├── LoginTest.java      # Cucumber test runner
│       │   ├── pages/
│       │   │   ├── LoginPage.java      # Page Object: halaman login
│       │   │   └── InventoryPage.java  # Page Object: halaman produk
│       │   ├── steps/
│       │   │   └── LoginSteps.java     # Step definitions
│       │   └── hooks/
│       │       └── Hooks.java          # Setup & teardown browser
│       └── resources/features/
│           └── login.feature       # Skenario tes (Gherkin syntax)
```

## Website yang Diuji

[SauceDemo](https://www.saucedemo.com/) - Website demo untuk testing login dengan berbagai skenario.

## Skenario Tes

| No | Skenario | Tipe |
|----|----------|------|
| 1 | Login dengan kredensial valid | Positif |
| 2 | Login dengan password salah | Negatif |
| 3 | Login dengan username salah | Negatif |
| 4 | Login dengan username kosong | Batas |
| 5 | Login dengan password kosong | Batas |
| 6 | Login dengan username sangat panjang | Batas |
| 7 | Login dengan username dan password kosong | Batas |

## Cara Menjalankan

### Prasyarat

- Java 17 atau lebih tinggi
- Google Chrome terinstall

### Jalankan Semua Tes

```bash
./gradlew test
```

### Lihat Laporan Hasil

```bash
# Laporan Cucumber (HTML)
open reports/cucumber.html

# Laporan Gradle
open build/reports/tests/test/index.html
```

### Jalankan Ulang Bersih

```bash
./gradlew clean test
```

### Jika ChromeDriver Bermasalah

```bash
rm -rf ~/.cache/selenium
./gradlew clean test
```

## Cara Kerja

1. **Hooks** (`Hooks.java`) - Menjalankan ChromeDriver headless sebelum dan sesudah setiap skenario
2. **Page Object** (`LoginPage.java`, `InventoryPage.java`) - Mengambil elemen halaman dan operasi yang tersedia
3. **Step Definitions** (`LoginSteps.java`) - Menghubungkan langkah Gherkin dengan kode Selenium
4. **Feature File** (`login.feature`) - Menuliskan skenario tes dalam bahasa Gherkin yang mudah dibaca
5. **Runner** (`LoginTest.java`) - Menjalankan semua tes dan menghasilkan laporan
