package gui.pages;

import com.microsoft.playwright.Page;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ContactDetailsPage extends BasePage {
    private static final Logger log = Logger.getLogger(ContactDetailsPage.class);

    public ContactDetailsPage(Page page, Properties prop) {
        super(page, prop);
    }

    public ContactDetailsPage cleanInputFields() {
        log.info("Cleaning input field before set data");
        page.fill("//label[.='Street 1']/../following-sibling::div/input", "");
        page.fill("//label[.='Street 2']/../following-sibling::div/input", "");
        page.fill("//label[.='City']/../following-sibling::div/input", "");
        page.fill("//label[.='State/Province']/../following-sibling::div/input", "");
        page.fill("//label[.='Home']/../following-sibling::div/input", "");
        return this;
    }

    public ContactDetailsPage setInputFields() {
        log.info("Set data in input field");
        page.fill("//label[.='Street 1']/../following-sibling::div/input", "street1");
        page.fill("//label[.='Street 2']/../following-sibling::div/input", "street2");
        page.fill("//label[.='City']/../following-sibling::div/input", "city");
        page.fill("//label[.='State/Province']/../following-sibling::div/input", "state");
        page.fill("//label[.='Home']/../following-sibling::div/input", "123456789");
        return this;
    }

    public List<String> getInputFields() {
        log.info("Getting data with input field");
        List<String> listContactInfo = new ArrayList<>();
        listContactInfo.add(page.inputValue("//label[.='Street 1']/../following-sibling::div/input"));
        listContactInfo.add(page.inputValue("//label[.='Street 2']/../following-sibling::div/input"));
        listContactInfo.add(page.inputValue("//label[.='City']/../following-sibling::div/input"));
        listContactInfo.add(page.inputValue("//label[.='State/Province']/../following-sibling::div/input"));
        listContactInfo.add(page.inputValue("//label[.='Home']/../following-sibling::div/input"));
        listContactInfo.add(page.locator("//label[.='Country']/../following-sibling::div/div").innerText());
        return listContactInfo;
    }

    public ContactDetailsPage setFieldCountry() {
        log.info("Set field country");
        page.click("//label[.='Country']/../following-sibling::div/div");
        page.keyboard().down("ArrowDown");
        page.keyboard().down("ArrowDown");
        page.keyboard().press("Enter");
        return this;
    }

    public void clickButtonSaveAndWaitMessageSuccessfully() {
        log.info("Click Button Save And Wait Message Successfully");
        page.click("//button[@type='submit' and normalize-space(text()='Save')]");
        page.isDisabled("//div[@id='oxd-toaster_1']");
    }

    public void reloadPage() {
        log.info("Reload page");
        page.reload();
    }

    public void waitForAppearedInputText() {
        log.info("Wait for Appeared Input Text");
        page.waitForTimeout(3000);
    }

}
