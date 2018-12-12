package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class SearchResultPage {

    private WebDriver driver;

    //Defining web element which shows how many results were found
    @FindBy(how = How.XPATH, using = "//*[@id=\"autoplius\"]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/h1/span")
    private WebElement result_count;

    //Defining web element which shows which make and model
    //were chosen. In this case Audi A6
    @FindBy(how = How.XPATH, using = "//*[@id=\"selected-filters\"]/li[1]/a")
    private WebElement search_criteria_make_model;

    //Defining web element which shows what was entered
    //in text search. In this case it was 'geras'
    @FindBy(how = How.XPATH, using = "//*[@id=\"selected-filters\"]/li[2]/a")
    private WebElement search_criteria_text_search;

    //Method which shows total result count
    //Since I needed to strip result from brackets, so I used
    //regular expression (help found in google :))
    public void resultCountActualResult() {
        String str = result_count.getText();
        String numbers;
        numbers = str.replaceAll("[^0-9]", "");
        System.out.println("Total result count is: " + numbers);
    }

    //Method returning which make and model were chosen. In this case 'Audi A6'
    public String getSearchCriteriaMakeAndModel() {
        return search_criteria_make_model.getText();
    }

    //Method returning which text search was used. In this case 'geras'
    public String getSearchCriteriaTextSearch() {
        return search_criteria_text_search.getText();
    }

    //Constructor which calls PageFactory.initElements() method
    //to initialize the elements in the class
    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }




}
