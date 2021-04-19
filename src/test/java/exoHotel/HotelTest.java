package exoHotel;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HotelTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		// chemin du driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		// Initialisation du navigateur Chrome
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://192.168.1.15:8090/HotelWebapp/");
		
		String stringH2PageHotel = driver.findElement(By.xpath("//h2")).getText();
		
		assertEquals("le nom de la page web ne corresponde pas", "Application Tutoriel pour la base de données des hotels", stringH2PageHotel);
		
		WebElement nameVille = driver.findElement(By.name("ville"));
		
		Select select = new Select(nameVille);
		select.selectByValue("New York");
		
		WebElement btSubmit = driver.findElement(By.tagName("button"));
		btSubmit.submit();
		
		String stringH3 = driver.findElement(By.xpath("//h3")).getText();
		
		assertEquals("le titre de l'hotel n'est pas le même", "Hôtels disponibles à New York ",stringH3);
		
		
		
	}

}
