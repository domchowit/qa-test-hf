package com.hellofresh.challenge.framework.util;

import com.hellofresh.challenge.framework.configuration.ConfigFeeder;
import com.hellofresh.challenge.framework.model.User;

import java.time.LocalDate;
import java.util.Date;

public class TestHelper {

    private static String email = ConfigFeeder.INSTANCE.config.getString("maven.user.email");
    private static String password = ConfigFeeder.INSTANCE.config.getString("maven.user.password");
    private static String name = ConfigFeeder.INSTANCE.config.getString("maven.user.name");
    private static String surname = ConfigFeeder.INSTANCE.config.getString("maven.user.surname");

    public static User generateRandomUser() {
        return User.builder()
                .name("FirstName")
                .surname("Surname")
                .email(generateRandomEmail())
                .password("Qwerty")
                .dateOfBirth(createRandomDate(1900, 2000))
                .company("Company")
                .address("address1")
                .city("city")
                .state("Colorado")
                .postCode(createRandomIntBetween(10000, 99999))
                .phone("12345123123")
                .phoneMobile("12345123123")
                .other("other")
                .addressAlias("hf")
                .build();
    }

    public static User generateExistingUser() {
        return User.builder().name(name).surname(surname).email(email).password(password).build();
    }


    public static LocalDate createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }

    public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    private static String generateRandomEmail(){
        String timestamp = String.valueOf(new Date().getTime());
        return "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
    }

}
