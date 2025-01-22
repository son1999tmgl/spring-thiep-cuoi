package wedding.invitation.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import wedding.invitation.util.dEnum.RoleUser;

import java.util.Date;

@Getter
@Setter
@Builder
@Entity
public class MUser extends AbstractEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "avatar")
    private String avatar;


    @Temporal(TemporalType.DATE)
    @Column(name = "dob")
    private Date dob;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleUser role = RoleUser.USER;
}
