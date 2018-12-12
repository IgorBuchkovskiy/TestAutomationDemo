package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class HomePage {

    private WebDriver driver;

    //Defining checkbox for new cars
    @FindBy(how = How.XPATH, using = "//*[@id=\"fast_search_forms\"]/div[1]/div[2]/label")
    private WebElement newCarCheckbox;

    //Defining text search field
    @FindBy(how = How.XPATH, using = "//*[@id=\"qt\"]")
    private WebElement searchTextField;

    //Defining search Button
    @FindBy(how = How.XPATH, using = "//*[@id=\"ann_fast_search\"]/div[2]/div[4]/a[1]/strong")
    private WebElement searchButton;

    //Method choosing Audi from dropdown list
    public void selectMake(String Audi) {
        Select make_id = new Select(driver.findElement(By.name("make_id")));
        make_id.selectByVisibleText(Audi);
    }

    //Method choosing A6 model from dropdown list
    public void selectModel (String A6) {
        Select model_id = new Select(driver.findElement(By.name("model_id")));
        model_id.selectByVisibleText(A6);
    }

    //Method deselecting new cars
    public void deselectNewCars(){
        if(newCarCheckbox.isSelected()){
            newCarCheckbox.click();
        }
    }

    //Method which puts specific text into search field
    public void searchBySpecificText(String specificText) {
        searchTextField.sendKeys(specificText);
    }

    //Method which allows to click on Search button
    public void searchButtonClick() {
        searchButton.click();
    }

    //Constructor which calls PageFactory.initElements() method
    //to initialize the elements in the class
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
