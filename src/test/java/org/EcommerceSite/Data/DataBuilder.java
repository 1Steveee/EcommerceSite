package org.EcommerceSite.Data;

import net.datafaker.Faker;

public class DataBuilder {

    private static Faker FAKER = new Faker();

    public static RegisterUserData getRegisterUserData() {
        return RegisterUserData.builder().firstName(FAKER.name().firstName())
                .lastName(FAKER.name().lastName())
                .telephone(Integer.toString(FAKER.number().numberBetween(99900000, 99988888)))
                .email(FAKER.internet().emailAddress())
                .password(FAKER.internet().password(8,12)).build();

    }

    public static BillingUserData getBillingUserData() {
        return BillingUserData.builder()
                .firstName(FAKER.name().firstName())
                .lastName(FAKER.name().lastName())
                .streetAddress(FAKER.address().streetAddress())
                .city(FAKER.address().city())
                .postalCode(FAKER.address().postcode())
                .country("United States")
                .state("Florida")
                .build();
    }

}
