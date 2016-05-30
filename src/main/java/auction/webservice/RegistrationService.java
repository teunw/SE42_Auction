package auction.webservice;

import auction.domain.User;
import auction.service.RegistrationManager;

import javax.jws.WebService;

@WebService
public class RegistrationService {

    private RegistrationManager registrationManager;

    public RegistrationService() {
        registrationManager = new RegistrationManager();
    }

    public User register(String email) {
        return registrationManager.registerUser(email);
    }


    public User login(String email) {
        return registrationManager.getUser(email);
    }
}
