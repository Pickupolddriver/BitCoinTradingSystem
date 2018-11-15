/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organizaiton;

import Business.Role.CashierRole;
import Business.Role.MinerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author lijianxi
 */
public class MinerOrganization extends Organization{

    public MinerOrganization( ) {
        super(Organization.Type.Digger.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new MinerRole());
        return roles;
       
    }
    
    
}
