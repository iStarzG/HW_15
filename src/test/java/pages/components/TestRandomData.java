package test.java.pages.components;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Locale;

public class TestRandomData {
    static Faker faker = new Faker(new Locale("ru"));
    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            inputEmail = faker.internet().emailAddress(String.valueOf(new Locale("en"))),
            inputGender = faker.options().option("Male", "Female", "Other"),
            inputPhone = faker.phoneNumber().subscriberNumber(10),
            setRandomDay = Integer.toString(faker.number().numberBetween(1, 31)),
            dayRandom = ((Integer.parseInt(setRandomDay) < 10) ? "00" + setRandomDay : "0" + setRandomDay),
            randomMonth = faker.options().option("January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December"),
            randomYear = String.valueOf(faker.number().numberBetween(1900, 2050)),
            inputSubject = faker.options().option("Maths", "Arts", "English", "Biology", "Hindi", "Commerce"),
            inputHobby = faker.options().option("Sports", "Reading", "Music"),
            pictureName = "1.jpeg",
            inputAddress = faker.address().fullAddress(),
            inputAddress2 = faker.address().fullAddress(),
            inputCity = faker.options().option("Delhi", "Agra", "Karnal", "Gurgaon", "Lucknow", "Panipat", "Jaipur", "Jaiselmer"),
            inputState = getState(inputCity),
            findColor = "border-color",
            colorName = "rgb(220, 53, 69)";

    public String getState(String value) {
        HashMap<String, String> cityAndState = new HashMap<>();
        cityAndState.put("Delhi", "NCR");
        cityAndState.put("Gurgaon", "NCR");
        cityAndState.put("Noida", "NCR");
        cityAndState.put("Agra", "Uttar Pradesh");
        cityAndState.put("Lucknow", "Uttar Pradesh");
        cityAndState.put("Merrut", "Uttar Pradesh");
        cityAndState.put("Karnal", "Haryana");
        cityAndState.put("Panipat", "Haryana");
        cityAndState.put("Jaipur", "Rajasthan");
        cityAndState.put("Jaiselmer", "Rajasthan");
        return cityAndState.get(value);
    }
}



