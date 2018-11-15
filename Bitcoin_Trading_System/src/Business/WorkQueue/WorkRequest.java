/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Blockchain.BlockChain;
import Blockchain.Transaction;
import Business.Employee.Employee;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author lijianxi
 */
public  class WorkRequest {

    @Override
    public String toString() {
        return String.valueOf(this.getT().getFrom());
    }
       ArrayList<Employee>minerList=new ArrayList();

    public ArrayList<Employee> getMinerList() {
        return minerList;
    }

    public void setMinerList(ArrayList<Employee> minerList) {
        this.minerList = minerList;
    }
         private String Status;
         private float cashTotal;
         private Transaction t;
         private BlockChain bc;

    public WorkRequest() {
        this.t = new Transaction();
        this.minerList = new ArrayList<Employee>();
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public float getCashTotal() {
        return cashTotal;
    }

    public void setCashTotal(float cashTotal) {
        this.cashTotal = cashTotal;
    }

    public Transaction getT() {
        return t;
    }

    public void setT(Transaction t) {
        this.t = t;
    }
    public void addMiner(Employee e){
        minerList.add(e);
        
        
    }

    public BlockChain getBc() {
        return bc;
    }

    public void setBc(BlockChain bc) {
        this.bc = bc;
    }

    
}
