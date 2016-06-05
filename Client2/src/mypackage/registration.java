package mypackage;/**
 * Created by wouter on 5-6-2016.
 */
public class registration {
  public static void main(String[] argv) {
    mypackage.RegistrationService service = new RegistrationServiceService().getPort();
    //invoke business method
    service.register();  
  }
}
