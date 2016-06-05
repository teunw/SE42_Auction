import auction.webservice.AuctionService;
import auction.webservice.RegistrationService;

import javax.xml.ws.Endpoint;

/**
 * Created by Teun on 1-6-2016.
 */
public class Main {

    public static final String URL = "http://localhost:8080/";

    public static void main(String[] args) {
        Endpoint.publish(URL + "auction", new AuctionService());
        Endpoint.publish(URL + "registration", new RegistrationService());
    }

}
