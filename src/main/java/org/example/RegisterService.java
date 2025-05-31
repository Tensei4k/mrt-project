package org.example;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@Transactional
public class RegisterService {

    private final RegisterRepository registerRepository;
    private final UserRepository userRepository;


    public RegisterService(RegisterRepository registerRepository,
                           UserRepository userRepository) {
        this.registerRepository = registerRepository;
        this.userRepository = userRepository;
    }

    public String saveRegister(OffsetDateTime dateTime, String doctorName, String patientName) {
        Register register = new Register();
        register.setDoctor(userRepository.findById(doctorName).orElse(null));
        register.setPatient(userRepository.findById(patientName).orElse(null));
        register.setDate(dateTime);
         registerRepository.save(register);
         return "Register successfully saved";
    }
}
