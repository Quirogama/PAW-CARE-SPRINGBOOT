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

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)

public class MascotaDetailCase {

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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void CaseTest_addMascota_listSize() {

        // Navegar a la página de inicio
        driver.get(BASE_URL);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    
        // Esperar a que el botón "Iniciar Sesión" esté presente y sea clickeable
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnLogin")));
        WebElement btnLogin = driver.findElement(By.id("btnLogin"));
        btnLogin.click();

        // Intento de inicio de sesión con datos incorrectos
        WebElement inputCedula1 = driver.findElement(By.id("cedula"));
        //inputCedula1.sendKeys("777");

        WebElement inputClave1 = driver.findElement(By.id("clave"));
        //inputClave1.sendKeys("clave666");

        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnIngresar")));
        //WebElement btnIngresar1 = driver.findElement(By.id("btnIngresar"));
        //btnIngresar1.click();

        // Inicio sesión con datos correctos
        //inputCedula1.clear();
        inputCedula1.sendKeys("777");

        inputClave1.clear();
        inputClave1.sendKeys("clave777");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnIngresar")));
        WebElement btnIngresar2 = driver.findElement(By.id("btnIngresar"));
        btnIngresar2.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Esperar a que la sección de clientes esté completamente cargada y hacer clic en el botón de clientes
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imgClientes")));
        WebElement imgClientes = driver.findElement(By.id("imgClientes"));
        imgClientes.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Agregar un nuevo cliente
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
        inputCedula.sendKeys("1234");
        inputCelular.clear();
        inputCelular.sendKeys("5678");
        inputEmail.sendKeys("jonathan@example.com");
        inputContrasena.sendKeys("contrasena");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnCrearCliente")));
        WebElement btnCrearCliente = driver.findElement(By.id("btnCrearCliente"));
        btnCrearCliente.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        // Agregar un nuevo cliente 2
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnAgregarCliente")));
        WebElement btnAgregarCliente2 = driver.findElement(By.id("btnAgregarCliente"));
        btnAgregarCliente2.click();
    
        WebElement inputNombre2 = driver.findElement(By.id("nombre"));
        WebElement inputCedula2 = driver.findElement(By.id("cedula"));
        WebElement inputCelular2 = driver.findElement(By.id("celular"));
        WebElement inputEmail2 = driver.findElement(By.id("correo"));
        WebElement inputContrasena2 = driver.findElement(By.id("clave"));

        inputNombre2.sendKeys("DePana");
        inputCedula2.clear();
        inputCedula2.sendKeys("12340987");
        inputCelular2.clear();
        inputCelular2.sendKeys("32081414");
        inputEmail2.sendKeys("Depana@example.com");
        inputContrasena2.sendKeys("depana");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnCrearCliente")));
        WebElement btnCrearCliente2 = driver.findElement(By.id("btnCrearCliente"));
        btnCrearCliente2.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Verificar que la tabla de clientes tenga exactamente 51 elementos tras añadir el nuevo cliente
        //wait.until(ExpectedConditions.numberOfElementsToBe(By.className("liNombreCliente"), 51));
        //List<WebElement> updatedClientList = driver.findElements(By.className("liNombreCliente"));
        //Assertions.assertThat(updatedClientList.size()).isEqualTo(51);

        // Navegar a la sección de mascotas
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnPerfilPrincipalHeader")));
        WebElement btnPerfilPrincipalHeader = driver.findElement(By.id("btnPerfilPrincipalHeader"));
        btnPerfilPrincipalHeader.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imgMascotas")));
        WebElement imgMascotas = driver.findElement(By.id("imgMascotas"));
        imgMascotas.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

        // Agregar una nueva mascota
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnAgregar")));
        WebElement btnAgregar = driver.findElement(By.id("btnAgregar"));
        btnAgregar.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Llenar formulario de mascota
        WebElement inputNombreMascota = driver.findElement(By.id("nombre"));
        WebElement inputPesoMascota = driver.findElement(By.id("peso"));
        WebElement inputRazaMascota = driver.findElement(By.id("raza"));
        WebElement inputEnfermedadMascota = driver.findElement(By.id("enfermedad"));

        inputNombreMascota.sendKeys("Floresito");
        inputPesoMascota.sendKeys("40");
        inputRazaMascota.sendKeys("Schnauzer");
        inputEnfermedadMascota.sendKeys("Fiebre");

        // Seleccionar "Estado" como "En tratamiento"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estado")));
        Select selectEstado = new Select(driver.findElement(By.id("estado")));
        selectEstado.selectByVisibleText("En tratamiento");

        WebElement inputEdad = driver.findElement(By.id("edad"));
        WebElement inputImagen = driver.findElement(By.id("imagen"));

        inputEdad.sendKeys("4");
        inputImagen.sendKeys("jonathan.jpg");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Seleccionar "Cédula del Cliente" usando el valor en CEDULA_CLIENTE
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cedulaCliente")));
        Select selectCedulaCliente = new Select(driver.findElement(By.id("cedulaCliente")));
        selectCedulaCliente.selectByVisibleText("1234");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Crear la mascota
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnCrearMascota")));
        WebElement btnCrearMascota = driver.findElement(By.id("btnCrearMascota"));
        btnCrearMascota.click();

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Logout
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("btnlogout")));
        WebElement btnlogout = driver.findElement(By.className("btnlogout"));
        btnlogout.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Iniciar sesión para verificar cliente
        WebElement inputCedula3 = driver.findElement(By.id("cedula"));
        inputCedula3.sendKeys("1234");

        WebElement inputClave3 = driver.findElement(By.id("clave"));
        inputClave3.sendKeys("contrasena");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnIngresar")));
        WebElement btnIngresar3 = driver.findElement(By.id("btnIngresar"));
        btnIngresar3.click();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }


    /*@AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }*/
}
