package backend.services;

import backend.dto.LoginDTO;
import backend.dto.RegistrationDTO;
import backend.entities.User;
import backend.repositories.UserRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Builder
public class UserService {
    @Autowired
    UserRepository userRepository;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String addUser(RegistrationDTO registrationDTO) {

        System.out.println(encoder.encode(registrationDTO.getPassword()));
        System.out.println(encoder.encode(registrationDTO.getPassword()));
        User user = userRepository.findByEmail(registrationDTO.getEmail());
        if(user == null){
            User u = User.builder().firstname(registrationDTO.getFirstname())
                    .lastname(registrationDTO.getLastname())
                    .email(registrationDTO.getEmail())
                    .password(encoder.encode(registrationDTO.getPassword()))
                    .build();
            userRepository.save(u);
            return "Success";
        }
        return "User already exists";
    }

    public String doLogin(LoginDTO loginDTO){
        User u = userRepository.findByEmail(loginDTO.getEmail());
        if(u == null){
            return "User does not exist";
        }else if(encoder.matches(loginDTO.getPassword(), u.getPassword())){
            return "Ok";
        }
        return "Invalid password or email";
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}