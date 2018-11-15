/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blockchain;

import Business.Enterprise.Enterprise;
import Business.Organizaiton.MinerOrganization;




/**
 *
 * @author lijianxi
 */
public class Block {
    private int index;
    private Enterprise minerOrg;
    private Head head;
    private Body body;
    public Block(){
        this.head=new Head();
        this.body=new Body();
    }

    public Enterprise getMinerOrg() {
        return minerOrg;
    }

    public void setMinerOrg(Enterprise minerOrg) {
        this.minerOrg = minerOrg;
    }

    
    
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    
    
    public void syncHashcode(){
        this.head.setHashcode(this.body.getBodyHashcode());
    }
    
    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
    
    
}
