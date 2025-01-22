package wedding.invitation.service.Impservice;

import org.springdoc.core.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wedding.invitation.dto.request.UserRequestRegister;
import wedding.invitation.dto.request.UserRequetLogin;
import wedding.invitation.model.entity.MUser;
import wedding.invitation.model.reponsitory.UserReponsitory;
import wedding.invitation.service.Iservice.IUserService;
import wedding.invitation.util.dEnum.RoleUser;
import wedding.invitation.util.dEnum.service.SSecurity;


@Service
public class UserService implements IUserService {
    @Autowired
    private UserReponsitory userReponsitory;
    @Autowired
    private SSecurity ssecurity;

    @Override
    public Long register(UserRequestRegister user) {
        if (userReponsitory.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email đã tồn tại.");
        }else{
            MUser new_user = MUser.builder()
                    .name(user.getName())
                    .avatar(user.getAvatar())
                    .password(ssecurity.encoder(user.getPassword()))
                    .role(user.getRole() != null ? user.getRole() : RoleUser.USER)
                    .dob(user.getDob())
                    .email(user.getEmail())
                    .build();
            Long user_id = userReponsitory.save(new_user).getId();
            return user_id;
        }
    }

    @Override
    public Long login(UserRequetLogin user) {
        System.out.println("user: "+user);
        MUser userr = MUser.builder()
                .name(user.getUserName())
                .role(RoleUser.USER)
                .email(user.getEmail())
                .name(user.getUserName())
                .build();
        return null;
    }
}
