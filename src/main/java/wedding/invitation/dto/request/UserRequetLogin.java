package wedding.invitation.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import wedding.invitation.dto.validator.StrongPassword;

import java.io.Serializable;


@Getter
@Setter
public class UserRequetLogin implements Serializable {

    @NotNull(message = "UserName not null")
    private String userName;

    @NotNull(message = "Email not null")
    private String email;

    @StrongPassword
    @NotNull(message = "password not null")
    private String password;
}
