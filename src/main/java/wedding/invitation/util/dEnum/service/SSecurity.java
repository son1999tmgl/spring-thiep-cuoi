package wedding.invitation.util.dEnum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class SSecurity {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public String encoder(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public boolean verify(String password, String encodedPassword){
        return bCryptPasswordEncoder.matches(password, encodedPassword);
    }

}
