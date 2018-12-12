package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.HomePage;
import pageobjects.SearchResultPage;


public class HomePageTests {

    private WebDriver driver;

    //With @Before anotation we setup Chrome for test
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://autoplius.lt/");
    }

    //Starting actual test
    @Test
    public void testAutoSelection() {

        //Creating instance of HomePage class and providing driver
        HomePage CopyOfHomePage = new HomePage(driver);

        //Selecting Audi
        CopyOfHomePage.selectMake("Audi");

        //Selecting A6
        CopyOfHomePage.selectModel("A6");

        //Deselecting new cars - only used will be searched
        CopyOfHomePage.deselectNewCars();

        //In the search field putting 'geras'
        CopyOfHomePage.searchBySpecificText("geras");

        //Clicking search button
        CopyOfHomePage.searchButtonClick();

        //Creating instance of Search Result page and providing driver
        SearchResultPage CopyOfSearchResultPage = new SearchResultPage(driver);

        //Check how many results we've got. Also showing result in console
        CopyOfSearchResultPage.resultCountActualResult();

        //Asserting if in search criteria we have Audi A6
        Assert.assertEquals("Audi A6", CopyOfSearchResultPage.getSearchCriteriaMakeAndModel());

        //Asserting if in text search we show correct text. I intentionally left error in expected:
        //to see how it fails
        Assert.assertEquals("Tekstinė paieška: gera", CopyOfSearchResultPage.getSearchCriteriaTextSearch());
    }

    //With this annotation quiting the driver.
    @After
    public void tearDown() {
        driver.quit();
    }
}