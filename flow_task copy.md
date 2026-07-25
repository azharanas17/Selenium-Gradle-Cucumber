Langkah-Langkah Mengerjakan Tugas:

1. Buat Proyek Gradle
Buat folder proyek baru

Tambahkan build.gradle dengan dependensi berikut:

Cucumber (untuk menjalankan test)

Selenium WebDriver (untuk otomatisasi browser)

JUnit (untuk menjalankan test di Java)

```
$ gradle init --type java-application --dsl groovy --project-name tugas-cucumber-selenium --package tugas.cucumber.selenium --no-incubating --split-project 2>&1

> Task :init FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':init'.
> Aborting build initialization due to existing files in the project directory: '/Users/naz/Downloads/JayJay/tugas_cucumber_selenium'.

* Try:
> Remove any existing files in the project directory and run the init task again.
> Enable the --overwrite option to allow existing files to be overwritten.
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights from a Build Scan (powered by Develocity).
> Get more help at https://help.gradle.org.

BUILD FAILED in 991ms
1 actionable task: 1 executed
```

```
2>&1
> Task :init
Learn more about Gradle by exploring our Samples at https://docs.gradle.org/9.4.1/samples/sample_building_java_applications.html

BUILD SUCCESSFUL in 1s
1 actionable task: 1 executed
```
```
# Create all required directories
$ mkdir -p app/src/main/java/tugas/cucumber/selenium/pages && mkdir -p app/src/test/java/tugas/cucumber/selenium/runner && mkdir -p app/src/test/java/tugas/cucumber/selenium/steps && mkdir -p app/src/test/java/tugas/cucumber/selenium/hooks && mkdir -p app/src/test/resources/features
(no output)
```



2. Gunakan Page Object Model (POM)
Buat 1 file Java untuk setiap halaman website yang diuji

Di dalam file tersebut, buat fungsi-fungsi untuk klik tombol, isi formulir, dan baca teks dari halaman

Contoh: LoginPage.java → untuk halaman login

Ini membantu agar kode tetap rapi dan mudah dirawat

3. Tulis Test Case dengan Gherkin
Buat file .feature dengan format cerita (Gherkin syntax)

4. Implementasikan Step Definitions
Buat file Java untuk menghubungkan baris di .feature dengan perintah Java/Selenium

Contoh: Baris When saya memasukkan username akan dijalankan dengan kode untuk mengetik di kolom login


5. Buat Tes Positif, Negatif, dan Batas
Positif: login dengan username dan password yang benar

Negatif: login dengan data salah

Batas: coba masukkan username yang sangat panjang, atau kosong

6. Jalankan Tes & Buat Laporan
Jalankan semua test dan pastikan berjalan lancar

Pastikan muncul laporan hasil tes (Cucumber akan membuat laporan otomatis)

