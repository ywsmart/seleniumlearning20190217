package com.yvan.seleniumutils;

import org.openqa.selenium.WebDriver;

/**
 * Function：
 *
 * @author yawa1hz1
 * @date 2019/2/17
 * Created by yawa1hz1 on 2019/2/17 15:36.
 */
public class SeleniumUtils {
    static void swichToWiindow(String title, WebDriver driver) {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(title)) {
                break;
            }
        }
    }
}
