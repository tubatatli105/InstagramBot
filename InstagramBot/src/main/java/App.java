import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {
    WebDriver webDriver;
    String Base_URL = "https://www.instagram.com/";
    By usernameLocator = new By.ByCssSelector("input[name='username']");
    By passwordLocator = new By.ByCssSelector("input[name='password']");
    By loginButtonLocator = new By.ByCssSelector("button[type='submit']");
    By instagramLogoLocator =new By.ByClassName("s4Iyt");
    By profileNameLocator = new By.ByClassName("nZSzR");
    By firstPost = new By.ByClassName("_9AhH0");
    By likeButtonLocator = new By.ByCssSelector("span.fr66n");
    By postCountLocator =new By.ByClassName("g47SY");
    By htmlTag = new By.ByTagName("html");


    public App(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get(Base_URL);
        webDriver.manage().window().maximize();
    }


    public void loginWith(String username, String password){
        waitFor(usernameLocator);
     webDriver.findElement(usernameLocator).sendKeys(username);
     webDriver.findElement(passwordLocator).sendKeys(password);
     webDriver.findElement(loginButtonLocator).click();

    }

    public void navigateToProfile(String profileName){
        waitFor(instagramLogoLocator);
        webDriver.navigate().to(Base_URL.concat(profileName));

    }
    public void waitFor(By locator){
        WebDriverWait wait = new WebDriverWait(webDriver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickFirstPost(){
        waitFor(profileNameLocator);
        webDriver.findElements(firstPost).get(0).click();
    }
    private int getPostCount(){
        String count = webDriver.findElement(postCountLocator).getText();
        return Integer.parseInt(count);
    }
    public void likeAllPost(){
        Integer count = getPostCount();
        while (count>0){
            waitFor(loginButtonLocator);
            webDriver.findElement(likeButtonLocator).click();
            webDriver.findElement(htmlTag).sendKeys(Keys.ARROW_RIGHT);
            count --;
        }


    }
}
