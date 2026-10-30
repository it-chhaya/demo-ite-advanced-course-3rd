package co.istad.chanchhaya.ecommerce.user.dto;

import java.util.Date;

public record UserUpdateRequest(
        String familyName,
        String givenName,
        String gender,
        String address,
        Date birthday,
        String mobilePhone
) {
}
