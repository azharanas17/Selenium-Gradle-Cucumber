package tests.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.hooks.Hooks;
import tests.pages.InventoryPage;
import tests.pages.LoginPage;

public class LoginSteps {
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @Given("Saya berada di halaman login")
    public void sayaBeradaDiHalamanLogin() {
        loginPage = new LoginPage(Hooks.getDriver());
        inventoryPage = new InventoryPage(Hooks.getDriver());
        loginPage.open();
    }

    @When("Saya memasukkan username {string}")
    public void sayaMemasukkanUsername(String username) {
        loginPage.enterUsername(username);
    }

    @And("Saya memasukkan password {string}")
    public void sayaMemasukkanPassword(String password) {
        loginPage.enterPassword(password);
    }

    @And("Saya klik tombol login")
    public void sayaKlikTombolLogin() {
        loginPage.clickLogin();
    }

    @Then("Saya berhasil masuk ke halaman utama")
    public void sayaBerhasilMasukKeHalamanUtama() {
        assertTrue(inventoryPage.isDisplayed());
        assertEquals("Products", inventoryPage.getTitle());
    }

    @Then("Saya melihat pesan error {string}")
    public void sayaMelihatPesanError(String expectedMessage) {
        assertTrue(loginPage.isErrorMessageDisplayed());
        assertEquals(expectedMessage, loginPage.getErrorMessage());
    }
}
