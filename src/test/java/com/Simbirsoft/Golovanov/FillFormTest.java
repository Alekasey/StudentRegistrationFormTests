package com.Simbirsoft.Golovanov;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FillFormTest {

    @BeforeAll
    static void beforeall() {
        Configuration.browser = "FireFox";
        Configuration.browserSize = "2100x1080";
    }

    @Test
    void studentFormatshow(){
        open("https://demoqa.com/automation-practice-form" );
        $("[id=firstName]").setValue("Alex11");
        $("[id=lastName]").setValue("Голова1");
        $("[id=userEmail]").setValue("Alx1@alex.ru");
        $("#gender-radio-1").parent().click();
        $("[id=userNumber]").setValue("5555555555");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2005");
        $(".react-datepicker__day--013").click();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("img/DZ.png");
        $("#currentAddress").setValue("Суворова 1-1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Gurgaon")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Alex11 Голова1"));
        $(".table-responsive").shouldHave(text("Alx1@alex.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("5555555555"));
        $(".table-responsive").shouldHave(text("13 July,2005"));
        $(".table-responsive").shouldHave(text("Reading"));
        $(".table-responsive").shouldHave(text("DZ.png"));
        $(".table-responsive").shouldHave(text("Суворова 1-1"));
        $(".table-responsive").shouldHave(text("NCR"));
        $(".table-responsive").shouldHave(text("Gurgaon"));
    }
}
