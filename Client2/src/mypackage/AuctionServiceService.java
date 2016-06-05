
package mypackage;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "AuctionServiceService", targetNamespace = "http://webservice.auction/", wsdlLocation = "http://localhost:8080/auction?wsdl")
public class AuctionServiceService
    extends Service
{

    private final static URL AUCTIONSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException AUCTIONSERVICESERVICE_EXCEPTION;
    private final static QName AUCTIONSERVICESERVICE_QNAME = new QName("http://webservice.auction/", "AuctionServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/auction?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        AUCTIONSERVICESERVICE_WSDL_LOCATION = url;
        AUCTIONSERVICESERVICE_EXCEPTION = e;
    }

    public AuctionServiceService() {
        super(__getWsdlLocation(), AUCTIONSERVICESERVICE_QNAME);
    }

    public AuctionServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), AUCTIONSERVICESERVICE_QNAME, features);
    }

    public AuctionServiceService(URL wsdlLocation) {
        super(wsdlLocation, AUCTIONSERVICESERVICE_QNAME);
    }

    public AuctionServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, AUCTIONSERVICESERVICE_QNAME, features);
    }

    public AuctionServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AuctionServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AuctionService
     */
    @WebEndpoint(name = "AuctionServicePort")
    public AuctionService getAuctionServicePort() {
        return super.getPort(new QName("http://webservice.auction/", "AuctionServicePort"), AuctionService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AuctionService
     */
    @WebEndpoint(name = "AuctionServicePort")
    public AuctionService getAuctionServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservice.auction/", "AuctionServicePort"), AuctionService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (AUCTIONSERVICESERVICE_EXCEPTION!= null) {
            throw AUCTIONSERVICESERVICE_EXCEPTION;
        }
        return AUCTIONSERVICESERVICE_WSDL_LOCATION;
    }

}
