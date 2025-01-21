package wedding.invitation.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class UserRequetDTO implements Serializable {

    @NotNull(message = "UserName not null")
    private String userName;

    @NotNull(message = "Email not null")
    private String email;


    @NotNull(message = "password not null")
    private String password;
}
