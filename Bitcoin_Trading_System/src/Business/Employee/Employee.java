/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

/**
 *
 * @author lijianxi
 */
public class Employee {
    private String name;
    private static int id;

    public Employee() {
        this.id = id + 1;
    }
  


    public Employee(String name) {
     this.name=name;
    }


    public void setName(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
