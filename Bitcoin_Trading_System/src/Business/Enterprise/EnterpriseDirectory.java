/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Employee.Employee;
import Business.Organizaiton.Organization;
import Business.Organizaiton.OrganizationDirectory;
import Business.Role.CashierRole;
import Business.Role.EnterpriseAdminRole;
import Business.Role.TraderRole;
import java.util.ArrayList;

/**
 *
 * @author lijianxi
 */
public class EnterpriseDirectory {

    private ArrayList<Enterprise> enterpriseList;

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<Enterprise>();
    }

    //Create enterprise
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type) {
        Enterprise enterprise = null;
        int count=this.enterpriseList.size()-1;
        if (type == Enterprise.EnterpriseType.Investor) {
            enterprise = new InvestorEnterprise(name,count);
            enterprise.setBalance(10000);
            enterpriseList.add(enterprise);
            OrganizationDirectory od = enterprise.getOrganizationDirectory();
            //Create EnterpriseOrganization and put create EnterpriseAdmin in this organization;
            Organization enterpriseAdminOrg = od.createOrganization(Organization.Type.EnterpriseAdmin);
            Employee admin = enterpriseAdminOrg.getEmployeeDirectory().createEmployee(enterprise.getName() + "admin");
            enterpriseAdminOrg.getUserAccountDirectory().createUserAccount(enterprise.getName() + "admin", "admin", admin, new EnterpriseAdminRole());
            //Crate Traderorganization inside the Enterprise
            Organization traderorg = od.createOrganization(Organization.Type.Trader);
            Employee Emp1 = traderorg.getEmployeeDirectory().createEmployee(enterprise.getName() + "emp");
            traderorg.getUserAccountDirectory().createUserAccount(Emp1.getName(), Emp1.getName(), Emp1, new TraderRole());

        } else if (type == Enterprise.EnterpriseType.Miner) {
            enterprise = new MinerEnterprise(name,count);
            enterprise.setBalance(10000);
            enterpriseList.add(enterprise);
            OrganizationDirectory od = enterprise.getOrganizationDirectory();
            //Create EnterpriseOrganization and put create EnterpriseAdmin in this organization;
            Organization enterpriseAdminOrg = od.createOrganization(Organization.Type.EnterpriseAdmin);
            Employee admin = enterpriseAdminOrg.getEmployeeDirectory().createEmployee(enterprise.getName() + "admin");
            enterpriseAdminOrg.getUserAccountDirectory().createUserAccount(enterprise.getName() + "admin", "admin", admin, new EnterpriseAdminRole());

        } else if (type == Enterprise.EnterpriseType.Broker) {
            enterprise = new BrokerEnterprise(name,count);
            enterprise.setBalance(10000);
            enterpriseList.add(enterprise);
            OrganizationDirectory od = enterprise.getOrganizationDirectory();
            //Create EnterpriseOrganization and put create EnterpriseAdmin in this organization;
            Organization enterpriseAdminOrg = od.createOrganization(Organization.Type.EnterpriseAdmin);
            Employee admin = enterpriseAdminOrg.getEmployeeDirectory().createEmployee(enterprise.getName() + "admin");
            enterpriseAdminOrg.getUserAccountDirectory().createUserAccount(enterprise.getName() + "admin", "admin", admin, new EnterpriseAdminRole());
             //Crate Traderorganization inside the Enterprise
            Organization cashierOrg = od.createOrganization(Organization.Type.Cashier);
            Employee Emp1 = cashierOrg.getEmployeeDirectory().createEmployee(enterprise.getName() + "emp");
            cashierOrg.getUserAccountDirectory().createUserAccount(Emp1.getName(), Emp1.getName(), Emp1, new CashierRole());
        }
        return enterprise;
    }
}
