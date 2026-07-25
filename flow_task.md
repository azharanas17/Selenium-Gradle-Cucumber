Langkah-Langkah Mengerjakan Tugas:

1. Buat Proyek Gradle
Buat folder proyek baru

Tambahkan build.gradle dengan dependensi berikut:

Cucumber (untuk menjalankan test)

Selenium WebDriver (untuk otomatisasi browser)

JUnit (untuk menjalankan test di Java)

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

