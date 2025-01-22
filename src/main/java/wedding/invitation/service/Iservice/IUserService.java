package wedding.invitation.service.Iservice;

import wedding.invitation.dto.request.UserRequestRegister;
import wedding.invitation.dto.request.UserRequetLogin;


public interface IUserService {
    Long login(UserRequetLogin user);
    Long register(UserRequestRegister user);
}
