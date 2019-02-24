package com.yvan.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Function：
 *
 * @author yawa1hz1
 * @date 2019/2/17
 * Created by yawa1hz1 on 2019/2/17 14:35.
 */
public class SearchResultPage extends NavBarPage {
    @FindBy(css = ".topic a")
    private List<WebElement> topics;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> returnTopics() {
        return topics;
    }

    public List<String> returnTopicsTitle() {
        List<String> list = new ArrayList<>();
        for (WebElement topic : topics) {
            list.add(topic.getText().trim().toLowerCase());
        }
        return list;
    }
}
