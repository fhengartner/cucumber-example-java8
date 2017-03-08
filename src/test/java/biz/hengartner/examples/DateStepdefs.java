package biz.hengartner.examples;

import cucumber.api.Format;
import cucumber.api.java8.En;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

@RunWith(Cucumber.class)
public class DateStepdefs implements En {
    private String result;
    private DateCalculator calculator;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public DateStepdefs() {
        Given("^today is (.+)$", (String dateString) -> {
            // Sadly the "cucumber.api.Format" annotation is not supported for java8 step definition.
            // https://github.com/cucumber/cucumber-jvm/issues/738#issuecomment-270766523
            Date date = Date.from(LocalDate.parse(dateString, formatter).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
            this.calculator = new DateCalculator(date);
        });

        /**
         * We don't need to use @Format here, since the date string in the step
         * conforms to <code>SimpleDateFormat.SHORT</code>. Cucumber has built-in support for
         * <code>SimpleDateFormat.SHORT</code>, <code>SimpleDateFormat.MEDIUM</code>,
         * <code>SimpleDateFormat.LONG</code> and <code>SimpleDateFormat.FULL</code>.
         *
         * @see <a href="http://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html">SimpleDateFormat</a>
         */
        When("^I ask if (.+) is in the past$", (Date date) -> {
            this.result = this.calculator.isDateInThePast(date);
        });

        Then("^the result should be (.+)$", (String expectedResult) -> {
            assertEquals(expectedResult, this.result);
        });
    }
}

