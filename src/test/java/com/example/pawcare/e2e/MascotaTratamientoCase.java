package com.example.pawcare.e2e;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MascotaTratamientoCase {

    private final String BASE_URL = "http://localhost:4200";

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-extensions");
        this.driver = new ChromeDriver(chromeOptions);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void CaseTest_addTratamiento_listSize() {

        driver.get(BASE_URL);
    
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnLogin")));
        WebElement btnLogin = driver.findElement(By.id("btnLogin"));
        btnLogin.click();

        WebElement inputCedula1 = driver.findElement(By.id("cedula"));
        WebElement inputClave1 = driver.findElement(By.id("clave"));
        
        inputCedula1.sendKeys("9991234");
        inputClave1.sendKeys("clave123");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnIngresar")));
        WebElement btnIngresar = driver.findElement(By.id("btnIngresar"));
        btnIngresar.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("botonDetalles")));
        WebElement botonDetalles = driver.findElement(By.className("botonDetalles"));
        botonDetalles.click();


        WebElement inputDescripcion = driver.findElement(By.id("descripcion"));
        WebElement inputFecha = driver.findElement(By.id("fecha"));


        inputFecha.sendKeys("09-11-2024");
        inputDescripcion.sendKeys("Droga para obtener la supercarita ;)");
        

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombreDroga")));
        Select selectDroga = new Select(driver.findElement(By.id("nombreDroga")));
        selectDroga.selectByVisibleText("AMOXAL");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("botonAgregar")));
        WebElement btnAgregar = driver.findElement(By.className("botonAgregar"));
        btnAgregar.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnVerDetalles")));
        WebElement btnDetalles = driver.findElement(By.id("btnVerDetalles"));
        btnDetalles.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("botonHistorial")));
        WebElement btnHistorial = driver.findElement(By.className("botonHistorial"));
        btnHistorial.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("btnlogout")));
        WebElement btnLogout = driver.findElement(By.className("btnlogout"));
        btnLogout.click();

        
        WebElement inputCedula2 = driver.findElement(By.id("cedula"));
        WebElement inputClave2 = driver.findElement(By.id("clave"));
        
        inputCedula2.sendKeys("777");
        inputClave2.sendKeys("clave777");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnIngresar")));
        WebElement btnIngresar2 = driver.findElement(By.id("btnIngresar"));
        btnIngresar2.click();

        // Esperar a que la sección de clientes esté completamente cargada y hacer clic en el botón de clientes
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imgMascotas")));
        WebElement imgMascotas = driver.findElement(By.id("imgMascotas"));
        imgMascotas.click();
        
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}