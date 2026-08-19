@api
Feature: Student API Test

  Scenario: Mendapatkan semua data siswa
    Given Saya melakukan login terlebih dahulu
    When Saya melakukan GET request "/api/siswa" dengan token
    Then Status code adalah 200
    Dan Response body memiliki field "success" dengan nilai true

  Scenario: Menambahkan siswa baru
    Given Saya melakukan login terlebih dahulu
    When Saya melakukan POST request "/api/siswa" dengan token dan body siswa:
      | nama              | nis    | kelas    | jurusan | email              | telepon     | alamat             |
      | Automation Student | 123454 | X-IPA-1  | TI      | auto4@test.com     | 0812345674  | Jl. Automation     |
    Then Status code adalah 201
    Dan Response body memiliki field "success" dengan nilai true
    Dan Response body memiliki field "message" dengan nilai "Siswa berhasil ditambahkan"
