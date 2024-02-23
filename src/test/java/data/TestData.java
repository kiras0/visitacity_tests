package data;

import com.github.javafaker.Faker;
import config.TestDataConfig;
import org.aeonbits.owner.ConfigFactory;

public class TestData {
    private static final TestDataConfig config = ConfigFactory.create(TestDataConfig.class, System.getProperties());
    Faker faker = new Faker();
    public String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            subject = faker.educator().course(),
            message = faker.shakespeare().hamletQuote(),
            presetCity = config.getPopularCity(),
            streetName = faker.address().streetAddress();
}
