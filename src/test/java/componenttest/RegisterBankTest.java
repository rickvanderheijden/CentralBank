package componenttest;

import com.ark.centralbank.ICentralBankRegister;
import java.io.IOException;
import java.rmi.RemoteException;
import org.junit.AfterClass;
import utilities.CentralBankUtilities;
import org.junit.BeforeClass;
import org.junit.Test;

public class RegisterBankTest {
    private static ICentralBankRegister centralBank;
    private static CentralBankUtilities utilities;
    
    @BeforeClass
    public static void setUpClass() throws InterruptedException, IOException {
        utilities = new CentralBankUtilities();
        centralBank = utilities.startCentralBank();
    }

    @AfterClass
    public static void tearDownClass() {
        utilities.stopCentralBank();
    }
    
    @Test
    public void testRegisterDatingSiteNull() {
        boolean result = centralBank.registerBank();
    }
}
