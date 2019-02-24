package com.yvan.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.Set;

/**
 * Function：
 *
 * @author yawa1hz1
 * @date 2019/2/24
 * Created by yawa1hz1 on 2019/2/24 10:32.
 */
public class SeleniumUtils {
    public static boolean switchWindow(WebDriver driver, long time, Set<String> handles){
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.numberOfWindowsToBe(handles.size()+1));
        for (String handle:driver.getWindowHandles()){
            if (!handles.contains(handle)){
                driver.switchTo().window(handle);
                Reporter.log("切换到窗口"+handle,true);
                return true;
            }
        }
        return false;
    }
}
