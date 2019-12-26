package ru.aktion_study.listeners;

import io.qameta.allure.Attachment;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AllureStepsListener implements StepLifecycleListener {

    @Override
    public void beforeStepStop(StepResult result) {
    }

   /* @Override
    public void afterStepStop(StepResult result) {
        if ( result.getStatus() == Status.FAILED ) getScreenshotBytes();
    }*/

   /* @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    private static byte[] getScreenshotBytes() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }*/
}
