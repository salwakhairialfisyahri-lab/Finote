# Finote

Finote merupakan aplikasi pencatatan keuangan sederhana berbasis Android yang dikembangkan menggunakan Kotlin dan Jetpack Compose. Aplikasi ini dirancang untuk membantu pengguna dalam mengelola pemasukan dan pengeluaran sehari-hari dengan cara yang mudah, praktis, dan efisien.

Melalui Finote, pengguna dapat mencatat setiap transaksi keuangan yang dilakukan sehingga kondisi keuangan dapat dipantau dengan lebih teratur. Selain itu, aplikasi ini juga menyediakan informasi saldo secara otomatis berdasarkan data pemasukan dan pengeluaran yang telah dicatat.

## Latar Belakang

Banyak mahasiswa maupun masyarakat umum masih mencatat keuangan secara manual atau bahkan tidak melakukan pencatatan sama sekali. Akibatnya, pengeluaran sering kali tidak terkontrol dan sulit untuk mengetahui kondisi keuangan secara akurat.

Berdasarkan permasalahan tersebut, Finote dikembangkan sebagai solusi sederhana untuk membantu pengguna mencatat transaksi keuangan harian secara digital. Dengan tampilan yang sederhana dan mudah digunakan, aplikasi ini diharapkan dapat membantu pengguna membangun kebiasaan mengelola keuangan dengan lebih baik.

## Fitur Utama

* Login pengguna
* Menambahkan data transaksi
* Mencatat pemasukan dan pengeluaran
* Menampilkan riwayat transaksi
* Menghitung total saldo secara otomatis
* Menampilkan total pemasukan
* Menampilkan total pengeluaran

## Teknologi yang Digunakan

Aplikasi Finote dibangun menggunakan beberapa teknologi berikut:

* Kotlin
* Jetpack Compose
* Material Design 3
* Android Studio
* Git dan GitHub

## Struktur Proyek

```text
app
├── data
│   ├── Transaction.kt
│   └── TransactionRepository.kt
│
├── screen
│   ├── LoginScreen.kt
│   ├── AddTransactionScreen.kt
│   └── EditTransactionScreen.kt
│
├── ui
│   └── theme
│
└── MainActivity.kt
```

## Cara Menjalankan Aplikasi

1. Clone repository ini ke komputer.
2. Buka project menggunakan Android Studio.
3. Tunggu proses Gradle Sync hingga selesai.
4. Jalankan aplikasi melalui emulator atau perangkat Android.
5. Aplikasi siap digunakan.

## Tim Pengembang

Proyek ini dikembangkan secara berkelompok sebagai bagian dari pembelajaran pengembangan aplikasi Android.

* Anggota 1 : Pengembangan Login dan Antarmuka Pengguna (UI)
* Anggota 2 : Pengembangan Fitur Transaksi
* Anggota 3 : Pengembangan Perhitungan Saldo dan Riwayat Transaksi

## Penutup

Finote diharapkan dapat menjadi aplikasi sederhana yang membantu pengguna dalam mengelola keuangan pribadi secara lebih teratur. Meskipun masih dalam tahap pengembangan dan memiliki fitur yang sederhana, aplikasi ini dapat menjadi dasar untuk pengembangan fitur-fitur yang lebih lengkap di masa mendatang.

## Cara Penggunaan

1. Buka aplikasi Finote.
2. Login menggunakan akun yang telah tersedia pada aplikasi.
3. Setelah berhasil login, pengguna akan masuk ke halaman Dashboard.
4. Pada Dashboard, pengguna dapat melihat total saldo, total pemasukan, dan total pengeluaran.
5. Tekan tombol **(+)** untuk menambahkan transaksi baru.
6. Isi informasi transaksi seperti:

   * Judul transaksi
   * Nominal
   * Jenis transaksi (Pemasukan atau Pengeluaran)
   * Kategori
   * Tanggal transaksi
7. Tekan tombol **Simpan** untuk menyimpan data transaksi.
8. Transaksi yang telah ditambahkan akan muncul pada bagian Riwayat Transaksi.
9. Saldo akan diperbarui secara otomatis berdasarkan data transaksi yang tersimpan.

## Cara Mendapatkan Aplikasi

Saat ini Finote masih berada pada tahap pengembangan dan digunakan untuk kebutuhan pembelajaran. Untuk mencoba aplikasi ini, pengguna dapat:

1. Mengunjungi repository GitHub proyek Finote.
2. Mengunduh (Download ZIP) source code yang tersedia.
3. Membuka proyek menggunakan Android Studio.
4. Melakukan proses Gradle Sync hingga selesai.
5. Menjalankan aplikasi menggunakan emulator Android atau perangkat Android yang terhubung.

Pada pengembangan selanjutnya, aplikasi Finote dapat didistribusikan dalam bentuk file APK sehingga pengguna dapat menginstal aplikasi secara langsung tanpa perlu menggunakan Android Studio.
