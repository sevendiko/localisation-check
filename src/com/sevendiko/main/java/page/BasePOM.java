package com.sevendiko.main.java.page;

import com.sevendiko.main.java.util.PropertyLoader;
import com.sevendiko.main.java.annotation.ExpectedLabel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BasePOM {

  Map<String, String> localisationBugs = new HashMap<>();
  ChromeDriver driver = new ChromeDriver();

  public Map<String, String> getLocalisationBugs() {
    return localisationBugs;
  }

  void validateLabels(Object object) {
    Class<?> validationClass = object.getClass();

    for (Field field : validationClass.getDeclaredFields()) {
      if (field.isAnnotationPresent(ExpectedLabel.class)) {
        field.setAccessible(true);
        ExpectedLabel expectedLabel = field.getAnnotation(ExpectedLabel.class);
        try {
          WebElement element = (WebElement) field.get(object);

          String actualText = element.getText();
          String expectedText = PropertyLoader.get(expectedLabel.label());

          System.out.println("a.text " + actualText);
          System.out.println("e.text " + expectedText);

          System.out.println("a.text.bytes " + Arrays.toString(actualText.getBytes(StandardCharsets.UTF_8)));
          System.out.println("e.text.bytes " + Arrays.toString(expectedText.getBytes(StandardCharsets.UTF_8)));

          if (!actualText.equals(expectedText)) {
            localisationBugs.put(field.getDeclaringClass().getSimpleName(), field.getName());
          }
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
