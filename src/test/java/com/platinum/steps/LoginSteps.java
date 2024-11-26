package com.platinum.steps;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class LoginSteps {

    WebDriver driver;

    @Before
    public void setUp() {
        // Establecer la propiedad del sistema para GeckoDriver
        System.setProperty("webdriver.gecko.driver", "C:\\WebDriver\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Given("el ejecutivo está en la página de inicio de sesión")
    public void elEjecutivoEstaEnLaPaginaDeInicioDeSesion() {
        driver.get("http://localhost:8081/CtaCorriente/login.jsp");
    }

    @When("el ejecutivo ingresa {string} y {string}")
    public void elEjecutivoIngresaY(String usuario, String password) {
        // Enter username
        driver.findElement(By.name("rut_ejecutivo")).sendKeys(usuario);
        // Enter password
        driver.findElement(By.name("password")).sendKeys(password);
        // Click the submit button
        driver.findElement(By.xpath("//input[@value='Iniciar Sesión']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.or(
            ExpectedConditions.urlContains("home.jsp"),
            ExpectedConditions.urlContains("login.jsp?error=1")
        ));
    }
    @Then("el ejecutivo debería ver la página principal")
    public void elEjecutivoDeberiaVerLaPaginaPrincipal() {
        assertTrue(driver.getCurrentUrl().contains("home.jsp"));
    }

    @Then("el ejecutivo debería ver un mensaje de error")
    public void elEjecutivoDeberiaVerUnMensajeDeError() {
        assertTrue(driver.getCurrentUrl().contains("login.jsp?error=1"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
