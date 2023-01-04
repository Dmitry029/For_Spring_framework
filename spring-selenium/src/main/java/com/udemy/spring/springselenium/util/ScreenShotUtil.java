package com.udemy.spring.springselenium.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
@Lazy
@Component
public class ScreenShotUtil {

    @Autowired
    private ApplicationContext ctx;

    @Value("${screenshot.path}")
    private Path path;


    public void takeScreenshot() throws IOException {
        String imageName = new SimpleDateFormat("yyyyMMddHHmm'.png'").format(new Date());
        File sourceFile = ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(sourceFile, this.path.resolve(imageName).toFile());
    }
}
