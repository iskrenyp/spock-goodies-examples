import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.Dimension
import org.openqa.selenium.chrome.ChromeDriver

driver = {
    // default browser -> Chrome, last version
    // download latest chromedriver binaries
    WebDriverManager.chromedriver().setup()
    def driverInstance = new ChromeDriver(options)
    driverInstance.manage().window().size = new Dimension(1920, 1080)
    return driverInstance
}