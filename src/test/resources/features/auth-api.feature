@api
Feature: Auth API Test

  Scenario: Register dengan email yang sudah terdaftar
    Given Saya melakukan POST request register dengan nama "Anas Azhar" email "hrzpitulas17@gmail.com" dan password "Password123"
    Then Status code adalah 409
    Dan Response body memiliki field "success" dengan nilai false
    Dan Response body memiliki field "error" dengan nilai "Email sudah terdaftar"

  Scenario: Login dengan kredensial yang valid
    Given Saya melakukan POST request login dengan email "hrzpitulas17@gmail.com" dan password "APIPracticehrzpitulas17."
    Then Status code adalah 200
    Dan Response body memiliki field "success" dengan nilai true
    Dan Response body memiliki field "data.token" tidak null

  Scenario: Mendapatkan data user yang sedang login
    Given Saya melakukan login terlebih dahulu
    When Saya melakukan GET request "/api/auth/me" dengan token
    Then Status code adalah 200
    Dan Response body memiliki field "success" dengan nilai true
    Dan Response body memiliki field "data.email" dengan nilai "hrzpitulas17@gmail.com"

  Scenario: Logout dari akun
    Given Saya melakukan login terlebih dahulu
    When Saya melakukan POST request logout dengan token
    Then Status code adalah 200
    Dan Response body memiliki field "success" dengan nilai true
    Dan Response body memiliki field "message" dengan nilai "Logout berhasil"
