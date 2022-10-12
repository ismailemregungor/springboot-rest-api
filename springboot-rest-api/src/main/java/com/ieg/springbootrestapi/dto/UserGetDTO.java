package com.ieg.springbootrestapi.dto;

import com.ieg.springbootrestapi.model.User;
import lombok.Getter;
import java.io.Serializable;
@Getter
public final class UserGetDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String firstName;
    private final String lastName;
    private UserGetDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public static UserGetDTO of(User user) {
        return new UserGetDTO(user.getFirstName(), user.getLastName());
    }
}
