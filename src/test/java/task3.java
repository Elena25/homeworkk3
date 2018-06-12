import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class task3 {
            public static void main(String[] args) {

            WebDriver driver = initChromeDriver();

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
// Войти в Админ Панель.
            WebElement email;
            email = driver.findElement(By.id("email"));
            email.sendKeys("webinar.test@gmail.com");
            WebElement password = driver.findElement(By.id("passwd"));
            password.sendKeys("Xcg7299bnSmMuRLp9ITw");
            WebElement submitbutton = driver.findElement(By.name("submitLogin"));
            submitbutton.submit();
//Выбрать пункт меню Каталог -> категории и дождаться загрузки страницы управления
//категориями.
            Actions act = new Actions(driver);
            act.moveToElement(driver.findElement(By.xpath("//*[@id=\"subtab-AdminCatalog\"]/a")));
            act.perform();
            WebElement category = driver.findElement(By.xpath("//*[@id=\"subtab-AdminCategories\"]/a"));
            category.click();
//Нажать «Добавить категорию» для перехода к созданию новой категории.
            WebElement addbutton = driver.findElement(By.xpath("//*[@id=\"page-header-desc-category-new_category\"]/div"));
            addbutton.click();
//После загрузки страницы ввести название новой категории и сохранить изменения. На
//странице управления категориями должно появиться сообщение об успешном
//создании категории.
            WebElement namefield = driver.findElement(By.xpath("//*[@id=\"name_1\"]"));
            namefield.sendKeys("Children");
            WebElement savebutton = driver.findElement(By.xpath("//*[@id=\"category_form_submit_btn\"]"));
            savebutton.click();
//Отфильтровать таблицу категорий по имени и дождаться там появления записи
//созданной категории.
            WebElement queryInput = driver.findElement(By.xpath("//*[@id=\"table-category\"]/thead/tr[2]/th[3]/input"));
            queryInput.sendKeys("Children");
            queryInput.submit();
        }

        public static WebDriver initChromeDriver() {
            System.setProperty("webdriver.chrome.driver", task3.class.getResource
                    ("chromedriver.exe").getPath());
            return new ChromeDriver();
        }

    }

