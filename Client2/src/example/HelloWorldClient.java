package example;

import java.net.MalformedURLException;
import mypackage.*;

/**
 * Created by wouter on 5-6-2016.
 */
public class HelloWorldClient {
  public static void main(String[] argv) throws MalformedURLException {
    mypackage.RegistrationService service = new RegistrationServiceService().getPort(RegistrationService.class);

      User a = service.register("wouter@msn.com");
      User b = service.login("wouter@msn.com");
      if(a.getId() == b.getId()){
          System.out.println("Horay");
      }else {
          System.out.println("Kanker kut shit");

      }

  }
}
