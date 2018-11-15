/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Blockchain.Block;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;

import static Business.Enterprise.Enterprise.EnterpriseType.Investor;
import static Business.Enterprise.Enterprise.EnterpriseType.Miner;
import Business.Network.Network;
import Business.Organizaiton.MinerOrganization;
import Business.Organizaiton.Organization;
import Business.Organizaiton.OrganizationDirectory;
import Business.Role.EnterpriseAdminRole;
import Business.Role.MinerRole;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author lijianxi
 */
public class ConfigureASystem {

    public static EcoSystem configure() {

        EcoSystem system = EcoSystem.getInstance();

        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        Employee employee = system.getEmployeeDirectory().createEmployee("CNM");

        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());

        

        return system;
    }

}
