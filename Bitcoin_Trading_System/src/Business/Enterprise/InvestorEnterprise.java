/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import static Business.Role.Role.RoleType.trader;
import java.util.ArrayList;

/**
 *
 * @author lijianxi
 */
public class InvestorEnterprise extends Enterprise {

    public InvestorEnterprise(String name,int id) {
        super(name, EnterpriseType.Investor,id);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

}
