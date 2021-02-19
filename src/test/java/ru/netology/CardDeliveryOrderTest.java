package ru.netology;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryOrderTest {

    @Test
    void shouldSucсessOrder() {
        open("http://localhost:9999/");
        $("[data-test-id=city] input").setValue("Санкт-Петербург");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Calendar today = Calendar.getInstance();
        today.add(Calendar.DAY_OF_MONTH,4);
        String visitDate=(String)(dateFormat.format(today.getTime()));
        $("[data-test-id=date] input").sendKeys(Keys.CONTROL+"A"+Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(visitDate);
        $("[data-test-id=name] input").setValue("Васильев Евгений");
        $("[data-test-id=phone] input").setValue("+79231765501");
        $("[data-test-id=agreement]").click();
        $(withText("Забронировать")).click();
        $(withText("Успешно!")).waitUntil(visible,15000);
    }


}
