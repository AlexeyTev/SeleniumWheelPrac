package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {

        ChromeDriver chromeDriver = new ChromeDriver();
        System.setProperty("webdriver.openqa.driver", "chrome/chromedriver.exe");
        chromeDriver.get("https://wheelofnames.com/");
        WebElement searchBox;
        WebElement click;
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        WebElement wheel=chromeDriver.findElement(By.id("parentDiv"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int loop = 3;
        int counter = 0;
            searchBox = chromeDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[3]/div/div[2]/div/div/div[2]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[3]/div/div[2]/div/div/div[2]")));
            if (searchBox != null) {
                searchBox.clear();
                searchBox.sendKeys("Dani\nMoshe\nHezi\nDana");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Next step");
                if (searchBox != null) {
                        while (counter<loop) {
                           click = pressWheel(chromeDriver,wheel,wait);
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            if (click != null) {
                                click.click();
                                counter++;
                            } else pressWheel(chromeDriver,wheel,wait);
                        }
                }

            }

        }


    private static WebElement pressWheel(ChromeDriver chromeDriver, WebElement webElement, WebDriverWait wait) {
        webElement.click();
        WebElement winner;
        winner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("winner-text")));
        System.out.println(winner.getText());
        return chromeDriver.findElement(By.cssSelector(".q-dialog .q-btn"));
    }
}