package gui.pages;

import com.microsoft.playwright.Page;

import java.util.Properties;

public abstract class BasePage {
    Page page;
    Properties prop;

    public BasePage(Page page, Properties prop) {
        this.page = page;
        this.prop = prop;
    }

    public String getTitle() {
        return page.title();
    }

    public String getUrl() {
        return page.url();
    }


}
