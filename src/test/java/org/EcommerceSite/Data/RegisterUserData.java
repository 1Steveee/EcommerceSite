package org.EcommerceSite.Data;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegisterUserData {


    private String email;
    private String firstName;
    private String lastName;
    private String telephone;
    private String password;

}
