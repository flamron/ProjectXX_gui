package by.pvt.dto;

import by.pvt.pojo.AppRole;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class AppUserDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Set<AppRole> appRoles;
}
