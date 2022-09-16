package main.java.common;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class SetupTeardown {

    protected WebDriver drivers;
    protected DriverFactory driver;
    protected String browser="edge";
    final String carrefourURL = "https://www.carrefour.fr/";

    @BeforeMethod
    public void setup()  {

        DriverFactory driver = new DriverFactory();
        drivers = driver.getDriver(browser);

        drivers.manage().window().maximize();
        drivers.get(carrefourURL);
    }

    @AfterMethod
    public void teardown(ITestResult result) throws IOException, NoSuchAlgorithmException, KeyStoreException, InterruptedException, KeyManagementException {

        ImportResultsToXray res = new ImportResultsToXray();

        if(result.getStatus() == ITestResult.SUCCESS)
        {
            System.out.println("passed **");
            res.generateJsonResults("PASSED");


        }
        else if(result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("Failed **");
            res.generateJsonResults("FAILED");

        }
        else if(result.getStatus() == ITestResult.SKIP ){

            System.out.println("Skiped**");
            res.generateJsonResults("SKIPED");
        }
        res.RemonteResultats();
        drivers.quit();
    }
}
