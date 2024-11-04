package com.example.e2e;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.example.pawcare.PawcareApplication;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(classes = PawcareApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Profile("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UseCaseTest2 {
    
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
    public void CaseTest_addMedicamento_listSize() {

    // 1. Veterinario ingresa al sistema
    driver.get("http://localhost:4200");

    // Iniciar sesión como veterinario
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnLogin")));
    WebElement btnLogin = driver.findElement(By.id("btnLogin"));
    btnLogin.click();

    // Ingresar credenciales del veterinario
    WebElement inputCedula = driver.findElement(By.id("cedula"));
    WebElement inputClave = driver.findElement(By.id("clave"));

    inputCedula.sendKeys("777");
    inputClave.sendKeys("clave777");

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnIngresar")));
    WebElement btnIngresar = driver.findElement(By.id("btnIngresar"));
    btnIngresar.click();

    // 2. Navegar directamente a la página de detalles de la mascota
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imgMascotas")));
    WebElement imgMascotas = driver.findElement(By.id("imgMascotas"));
    imgMascotas.click();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnEditarMascota")));
    WebElement btnEditarMascota = driver.findElement(By.id("btnEditarMascota"));
    btnEditarMascota.click();
    

    // 3. Asignar un nuevo tratamiento a la mascota
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnAddTreatment")));
    WebElement btnAddTreatment = driver.findElement(By.id("btnAddTreatment"));
    btnAddTreatment.click();

    // Seleccionar el tratamiento en el menú desplegable
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("treatmentSelect")));
    Select selectTreatment = new Select(driver.findElement(By.id("treatmentSelect")));
    selectTreatment.selectByVisibleText("Nuevo Medicamento"); // Cambia al nombre del tratamiento correcto

    // Guardar el tratamiento
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnGuardarTratamiento")));
    WebElement btnGuardarTratamiento = driver.findElement(By.id("btnGuardarTratamiento"));
    btnGuardarTratamiento.click();

    // 4. Verificar que el tratamiento se guardó correctamente
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("treatmentDetails")));
    WebElement treatmentDetails = driver.findElement(By.id("treatmentDetails"));
    assertTrue(treatmentDetails.getText().contains("Nuevo Medicamento")); // Verifica que el tratamiento está en los detalles

    // 5. Cerrar sesión del veterinario
    WebElement btnLogout = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnLogoutHeader")));
    btnLogout.click();

    // 6. Ingresar como administrador y verificar el reporte de medicamentos
    inputCedula = driver.findElement(By.id("cedula"));
    inputCedula.sendKeys("adminID");
    inputClave = driver.findElement(By.id("clave"));
    inputClave.sendKeys("claveAdmin");

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnIngresar")));
    btnIngresar = driver.findElement(By.id("btnIngresar"));
    btnIngresar.click();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("reportMenu")));
    WebElement reportMenu = driver.findElement(By.id("reportMenu"));
    reportMenu.click();

    WebElement medicationCount = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("medicationCount")));
    assertTrue(medicationCount.getText().contains("Cantidad correcta")); // Cambia al valor esperado

    WebElement earnings = driver.findElement(By.id("totalEarnings"));
    assertTrue(earnings.getText().contains("Ganancia correcta")); // Cambia al valor esperado
    }
}