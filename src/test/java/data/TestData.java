package data;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();
    public String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            subject = faker.educator().course(),
            message = faker.shakespeare().hamletQuote(),
            presetCity = "Rome",
            popularCity =  faker.options().option("Rome", "Amsterdam", "Tokyo"),
            city = faker.options().option("Lexington", "Portocolom", "Crystal"),
            streetName = faker.name().username();
}
