package ru.aktion_study.listeners;

import io.qameta.allure.Attachment;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import io.qameta.allure.model.TestResult;
import net.lightbody.bmp.core.har.Har;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.aktion_study.test.TestBase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AllureStepsListener implements StepLifecycleListener, TestLifecycleListener {

    @Override
    public void beforeStepStop(StepResult result) {
        getHar();
    }

    @Override
    public void beforeTestStop(TestResult result) {
        getHar();
    }
    /* @Override
    public void afterStepStop(StepResult result) {
        if ( result.getStatus() == Status.FAILED ) getScreenshotBytes();
    }*/

   /* @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    private static byte[] getScreenshotBytes() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }*/

    @Override
    public void beforeTestStart(TestResult result) {

    }

    @Attachment(value = "Http log", type = "application/json", fileExtension = "har")
    public static void getHar() {

        Har har = TestBase.proxyServer.getHar();
        try {
            File file = new File("results\\Test.har");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            try {
                har.writeTo(fos);
            }
            finally {
                fos.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
