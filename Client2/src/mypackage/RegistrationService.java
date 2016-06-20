
package mypackage;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "RegistrationService", targetNamespace = "http://webservice.auction/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface RegistrationService {


    /**
     * 
     * @param arg0
     * @return
     *     returns mypackage.User
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "register", targetNamespace = "http://webservice.auction/", className = "mypackage.Register")
    @ResponseWrapper(localName = "registerResponse", targetNamespace = "http://webservice.auction/", className = "mypackage.RegisterResponse")
    @Action(input = "http://webservice.auction/RegistrationService/registerRequest", output = "http://webservice.auction/RegistrationService/registerResponse")
    public User register(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "clearDatabase", targetNamespace = "http://webservice.auction/", className = "mypackage.ClearDatabase")
    @ResponseWrapper(localName = "clearDatabaseResponse", targetNamespace = "http://webservice.auction/", className = "mypackage.ClearDatabaseResponse")
    @Action(input = "http://webservice.auction/RegistrationService/clearDatabaseRequest", output = "http://webservice.auction/RegistrationService/clearDatabaseResponse")
    public void clearDatabase();

    /**
     * 
     * @param arg0
     * @return
     *     returns mypackage.User
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "login", targetNamespace = "http://webservice.auction/", className = "mypackage.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://webservice.auction/", className = "mypackage.LoginResponse")
    @Action(input = "http://webservice.auction/RegistrationService/loginRequest", output = "http://webservice.auction/RegistrationService/loginResponse")
    public User login(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
