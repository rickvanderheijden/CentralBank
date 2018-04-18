package utilities;

import com.ark.centralbank.ICentralBankRegister;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import static java.lang.Thread.sleep;

public class CentralBankUtilities {

    static final String JARPATH = "out\\artifacts\\CentralBank_jar\\";
    static final String JARFILE = "CentralBank.jar";
    Process processCentralBank;
    
    public ICentralBankRegister startCentralBank() throws InterruptedException, IOException {

        String cmd = "java -jar " + JARPATH + JARFILE;
        
        processCentralBank = Runtime.getRuntime().exec(cmd);

        sleep(1000);
        
        URL wsdlURL = null;
        try {
            wsdlURL = new URL("http://localhost:8080/CentralBank?wsdl");
        } catch (MalformedURLException e) {
        }
        
        QName qname = new QName("http://centralbank.ark.com/", "CentralBankService");
        Service service = Service.create(wsdlURL, qname);
        QName qnamePort = new QName("http://centralbank.ark.com/", "CentralBankPort");

        return service.getPort(qnamePort, ICentralBankRegister.class);
    }

    public void stopCentralBank() {
        if (processCentralBank != null) {
            processCentralBank.destroy();
        }
    }
}
