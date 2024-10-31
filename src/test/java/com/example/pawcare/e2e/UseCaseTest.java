package com.example.pawcare.e2e;

import java.time.Duration;

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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UseCaseTest {
    
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void init() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-extensions");
        //chromeOptions.addArguments("--headless");

        this.driver = new ChromeDriver(chromeOptions);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    @Test
    public void HomeTest_addMascota_listSize() {

        // Navegar a la página de inicio
        driver.get("http://localhost:4200");
        
        // Esperar a que el botón "Iniciar Sesión" esté presente y sea clickeable
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnLogin")));
        WebElement btnLogin = driver.findElement(By.id("btnLogin"));
        btnLogin.click();

        //inicio sesion datos incorrectos
        WebElement inputCedula1 = driver.findElement(By.id("cedula"));
        inputCedula1.sendKeys("77");

        WebElement inputClave = driver.findElement(By.id("clave"));
        inputClave.sendKeys("clave777");

        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnIngresar")));
        WebElement btnIngresar1 = driver.findElement(By.id("btnIngresar"));
        btnIngresar1.click();

        //inicio sesion datos correctos
        WebElement inputCedula2 = driver.findElement(By.id("cedula"));
        inputCedula2.clear();
        inputCedula2.sendKeys("777");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnIngresar")));
        WebElement btnIngresar2 = driver.findElement(By.id("btnIngresar"));
        btnIngresar2.click();

        //primero ingresa el cliente
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imgClientes")));
        WebElement imgClientes = driver.findElement(By.id("imgClientes"));
        imgClientes.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnAgregarCliente")));
        WebElement btnAgregarCliente = driver.findElement(By.id("btnAgregarCliente"));
        btnAgregarCliente.click();

        WebElement inputNombre = driver.findElement(By.id("nombre"));
        WebElement inputCedula = driver.findElement(By.id("cedula"));
        WebElement inputCelular = driver.findElement(By.id("celular"));
        WebElement inputEmail = driver.findElement(By.id("correo"));
        WebElement inputContrasena = driver.findElement(By.id("clave"));

        inputNombre.sendKeys("Jonathan");
        inputCedula.clear();
        inputCedula.sendKeys("124578");
        inputCelular.clear();
        inputCelular.sendKeys("3208141460");
        inputEmail.sendKeys("g6rGZ@example.com");
        inputContrasena.sendKeys("contrasenaSecreta");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnCrearCliente")));
        WebElement btnCrearCliente = driver.findElement(By.id("btnCrearCliente"));
        btnCrearCliente.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnPerfilPrincipalHeader")));
        WebElement btnPerfilPrincipalHeader = driver.findElement(By.id("btnPerfilPrincipalHeader"));
        btnPerfilPrincipalHeader.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imgMascotas")));
        WebElement imgMascotas = driver.findElement(By.id("imgMascotas"));
        imgMascotas.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnAgregar")));
        WebElement btnAgregar = driver.findElement(By.id("btnAgregar"));
        btnAgregar.click();
        

        WebElement inputNombreMascota = driver.findElement(By.id("nombre"));
        WebElement inputPesoMascota = driver.findElement(By.id("peso"));
        WebElement inputRazaMascota = driver.findElement(By.id("raza"));
        WebElement inputEnfermedadMascota = driver.findElement(By.id("enfermedad"));

        // Esperar y seleccionar el valor en el menú desplegable "estado"
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("estado")));
        Select selectEstado = new Select(driver.findElement(By.id("estado")));
        selectEstado.selectByVisibleText("En tratamiento");
        WebElement inputEdad = driver.findElement(By.id("edad"));
        WebElement inputImagen = driver.findElement(By.id("imagen"));

        inputNombreMascota.sendKeys("Floresito");
        inputPesoMascota.sendKeys("40");
        inputRazaMascota.sendKeys("Schnauzer");
        inputEnfermedadMascota.sendKeys("Fiebre");
        inputEdad.sendKeys("4");
        inputImagen.sendKeys("jonathan.jpg");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnCrearMascota")));
        WebElement btnCrearMascota = driver.findElement(By.id("btnCrearMascota"));
        btnCrearMascota.click();

        
    }
}
