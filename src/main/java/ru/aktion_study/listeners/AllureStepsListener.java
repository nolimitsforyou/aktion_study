package ru.aktion_study.listeners;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import io.qameta.allure.model.TestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureStepsListener implements StepLifecycleListener {

    Status status;

    @Override
    public void beforeStepStop(StepResult result) {
        status = new StepResult().getStatus();
        checkOnFailure(status);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    private static byte[] getScreenshotBytes() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    private void getStatusStep() {

    }

    private void checkOnFailure(Status stat) {
        if(stat == status.FAILED) {
            getScreenshotBytes();
        }
    }
}
