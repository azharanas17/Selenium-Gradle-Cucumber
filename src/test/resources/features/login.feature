@ui
Feature: Login

  Scenario: Login dengan kredensial valid
    Given Saya berada di halaman login
    When Saya memasukkan username "standard_user"
    And Saya memasukkan password "secret_sauce"
    And Saya klik tombol login
    Then Saya berhasil masuk ke halaman utama

  Scenario: Login dengan password salah
    Given Saya berada di halaman login
    When Saya memasukkan username "standard_user"
    And Saya memasukkan password "wrong_password"
    And Saya klik tombol login
    Then Saya melihat pesan error "Epic sadface: Username and password do not match any user in this service"

  Scenario: Login dengan username salah
    Given Saya berada di halaman login
    When Saya memasukkan username "invalid_user"
    And Saya memasukkan password "secret_sauce"
    And Saya klik tombol login
    Then Saya melihat pesan error "Epic sadface: Username and password do not match any user in this service"

  Scenario: Login dengan username kosong
    Given Saya berada di halaman login
    When Saya memasukkan username ""
    And Saya memasukkan password "secret_sauce"
    And Saya klik tombol login
    Then Saya melihat pesan error "Epic sadface: Username is required"

  Scenario: Login dengan password kosong
    Given Saya berada di halaman login
    When Saya memasukkan username "standard_user"
    And Saya memasukkan password ""
    And Saya klik tombol login
    Then Saya melihat pesan error "Epic sadface: Password is required"

  Scenario: Login dengan username sangat panjang
    Given Saya berada di halaman login
    When Saya memasukkan username "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    And Saya memasukkan password "secret_sauce"
    And Saya klik tombol login
    Then Saya melihat pesan error "Epic sadface: Username and password do not match any user in this service"

  Scenario: Login dengan username dan password kosong
    Given Saya berada di halaman login
    When Saya memasukkan username ""
    And Saya memasukkan password ""
    And Saya klik tombol login
    Then Saya melihat pesan error "Epic sadface: Username is required"
