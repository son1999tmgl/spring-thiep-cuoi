package wedding.invitation.dto.request;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import wedding.invitation.util.dEnum.RoleUser;

import java.util.Date;

@Getter
@Setter
public class UserRequestRegister {
    @NotNull(message = "Tên không được để trống")
    private String name;
    @Email(message = "Email ko đúng định dạng")
    @NotNull(message = "Email ko đc để trống")
    private String email;
    @NotNull(message = "password ko đc để trống")
    private String password;

    private String avatar;

    private Date dob;

    private RoleUser role = RoleUser.USER;
}
