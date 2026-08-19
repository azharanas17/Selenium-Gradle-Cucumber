package tests.api.models;

public class StudentRequest {
    private String nama;
    private String nis;
    private String kelas;
    private String jurusan;
    private String email;
    private String telepon;
    private String alamat;

    public StudentRequest(String nama, String nis, String kelas, String jurusan, String email, String telepon, String alamat) {
        this.nama = nama;
        this.nis = nis;
        this.kelas = kelas;
        this.jurusan = jurusan;
        this.email = email;
        this.telepon = telepon;
        this.alamat = alamat;
    }

    public StudentRequest() {
    }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getNis() { return nis; }
    public void setNis(String nis) { this.nis = nis; }
    public String getKelas() { return kelas; }
    public void setKelas(String kelas) { this.kelas = kelas; }
    public String getJurusan() { return jurusan; }
    public void setJurusan(String jurusan) { this.jurusan = jurusan; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelepon() { return telepon; }
    public void setTelepon(String telepon) { this.telepon = telepon; }
    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }
}
