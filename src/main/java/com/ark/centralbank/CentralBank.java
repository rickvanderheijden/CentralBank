package com.ark.centralbank;

import javax.jws.WebService;

@WebService
public class CentralBank implements ICentralBankRegister {

    public CentralBank() {
        super();
    }
    
    @Override
    public boolean registerBank() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean unregisterBank() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
