package ru.aktion_study.listeners;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureStepsListener implements StepLifecycleListener {

    @Override
    public void beforeStepStop(StepResult result) {
        getScreenshotBytes();
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    private static byte[] getScreenshotBytes() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
