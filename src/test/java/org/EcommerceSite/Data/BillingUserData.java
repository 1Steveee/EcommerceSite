package org.EcommerceSite.Data;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BillingUserData {
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String postalCode;
    private String country;
    private String state;
}
