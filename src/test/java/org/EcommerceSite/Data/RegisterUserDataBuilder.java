package org.EcommerceSite.Data;

import net.datafaker.Faker;

public class RegisterUserDataBuilder {


    public static RegisterUserData getRegisterUserData() {
        Faker faker = new Faker();
        return RegisterUserData.builder().firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .telephone(Integer.toString(faker.number().numberBetween(99900000, 99988888)))
                .email(faker.internet().emailAddress())
                .password(faker.internet().password(8,12)).build();

    }


}
