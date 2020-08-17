package co.com.practica.page.mapeos;

    import net.serenitybdd.core.annotations.findby.FindBy;
    import net.serenitybdd.core.pages.PageObject;
    import net.serenitybdd.core.pages.WebElementFacade;
    import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://gorest.co.in/")
public class GoRestPage extends PageObject {

    @FindBy(xpath = "//*[contains(text(), 'Login')]")
    public WebElementFacade btnLoguin;

    @FindBy(xpath = "//a[@class='btn btn-sm-block btn-xs-block mb-3 btn-outline-success mr-2']")
    public WebElementFacade btnGmail;

    @FindBy(xpath = "//input[@id='dynamicmodel-reset_access_token']")
    public WebElementFacade cbxActualizarToken;

    @FindBy(xpath = "//a[@class='btn btn-success']")
    public WebElementFacade btnActualizarToken;


    @FindBy(xpath = "//samp[@class='user-select-all text-break']")
    public WebElementFacade lblToken;
}
