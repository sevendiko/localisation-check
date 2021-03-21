package com.sevendiko.main.java;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SamplePOM extends BasePOM {

  @ExpectedLabel(label = "title")
  @FindBy(id = "consent_cookies_title")
  WebElement consent_cookies_title;

  public SamplePOM() {
    super();
    driver.get("https://www.facebook.com/");
    PageFactory.initElements(driver, this);
    validateLabels(this);
  }

}
