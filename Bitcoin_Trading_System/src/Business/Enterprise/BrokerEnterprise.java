/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author lijianxi
 */
public class BrokerEnterprise extends Enterprise {

    public BrokerEnterprise(String name,int id) {
        super(name, EnterpriseType.Broker,id);
        
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
