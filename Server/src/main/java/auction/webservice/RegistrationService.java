package auction.webservice;

import auction.domain.User;
import auction.service.DatabaseCleaner;
import auction.service.RegistrationManager;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class RegistrationService {

    private RegistrationManager registrationManager;

    public RegistrationService() {
        registrationManager = new RegistrationManager();
    }

    @WebMethod(operationName = "register")
    public User register(String email) {
        return registrationManager.registerUser(email);
    }


    @WebMethod(operationName = "login")
    public User login(String email) {
        return registrationManager.getUser(email);
    }
    @WebMethod(operationName = "clearDatabase")
    public void clearDatabase() {
        new DatabaseCleaner().clean();
    }
}
