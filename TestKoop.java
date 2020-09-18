import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * TODO : change chromedriver.exe path
 *
 * @author <Tomas Chvatal>
 */

public class TestKoop {

    //variables
    String person = "2"; //works only for 10...Jiná osoba, 2...Poškozený z povinného ručení
    String name = "Tomas";
    String surname = "Chvatal";
    String phoneNumber = "608239239";
    String mail = "chvatal@gmail.com";
    String harmDate = "25112019";
    String contractNumber = "9876543210";

    @Test
    public void fillForm(){

        //open Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //open website
        driver.get(" https://insure.koop.cz/hlasenky-web/faces/vstup_info.xhtml");

        //show form...with css, everything else with xpath
        driver.findElement(By.cssSelector(".ui-button-text")).click();

        //wait
        WebDriverWait wait = new WebDriverWait(driver, 15);

        //fill in form
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"vstupInfo:PanelVstupniInfo:VI_HLASIL:inpVI_HLASIL_label\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"vstupInfo:PanelVstupniInfo:VI_HLASIL:inpVI_HLASIL_" + person + "\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"vstupInfo:PanelVstupniInfo:VI_JMENO:inpVI_JMENO\"]")));
        driver.findElement(By.xpath("//*[@id=\"vstupInfo:PanelVstupniInfo:VI_JMENO:inpVI_JMENO\"]")).sendKeys(name);
        driver.findElement(By.xpath("//*[@id=\"vstupInfo:PanelVstupniInfo:VI_HLASIL_EMAIL:inpVI_HLASIL_EMAIL\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"vstupInfo:PanelVstupniInfo:VI_PRIJMENI:inpVI_PRIJMENI\"]")).sendKeys(surname);
        driver.findElement(By.xpath("//*[@id=\"vstupInfo:PanelVstupniInfo:VI_HLASIL_MOBIL:inpVI_HLASIL_MOBIL\"]")).sendKeys(phoneNumber);
        driver.findElement(By.xpath("//*[@id=\"vstupInfo:PanelVstupniInfo:VI_HLASIL_EMAIL:inpVI_HLASIL_EMAIL\"]")).sendKeys(mail);
        driver.findElement(By.xpath("//*[@id=\"vstupInfo:PanelVstupniInfo:VI_DATUM_VZNIKU_NEBO_ZJISTENI_SKODY:inpVI_DATUM_VZNIKU_NEBO_ZJISTENI_SKODY_input\"]")).sendKeys(harmDate);
        driver.findElement(By.xpath("//*[@id=\"vstupInfo:PanelVstupniInfo:VI_CPS:inpVI_CPS\"]")).sendKeys(contractNumber);

        //confirm & close
        driver.findElement(By.xpath("//*[@id=\"vstupInfo:j_idt197\"]/span")).click();
        driver.close();
    }
}
