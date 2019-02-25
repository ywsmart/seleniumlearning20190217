package com.yvan.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Function：社区页
 *
 * @author yawa1hz1
 * @date 2019/2/24
 * Created by yawa1hz1 on 2019/2/24 14:18.
 */
public class CommunityPage extends NavBarPage {
    @FindBy(css = "#hot_teams .panel-body .media-heading a")
    List<WebElement> communityList;

    WebDriver driver;
    public CommunityPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
        wait.until(ExpectedConditions.titleContains("社团"));
    }

    public boolean clickCommunityByText(String communityName){
        for (WebElement e :
                communityList) {
            if (e.getText().trim().equalsIgnoreCase(communityName)){
                e.click();
            }
        }
        return false;
    }
    public void clickTeam(String menu){
        for(WebElement menuElement:communityList){
            if(menuElement.getText().equals(menu)){
                menuElement.click();
                System.err.println("点击了" + menu);
                break;
            }
        }
    }

}
