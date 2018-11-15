/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blockchain;

import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author lijianxi
 */
public class Head {
    private Date timestamp;
    private int target;
    private int nonce;
    private int hashcode;
    private int prevhashcode;

    public int getPrevhashcode() {
        return prevhashcode;
    }

    public void setPrevhashcode(int prevhashcode) {
        this.prevhashcode = prevhashcode;
    }

    
    
    

    public void refreshHashcode(){
        
    }

    public int getHashcode() {
        return hashcode;
    }

    public void setHashcode(int hashcode) {
        this.hashcode = hashcode;
    }
   
    
    
    
    
    public Head(){
        this.timestamp=new Date();
        this.target=0;
        this.nonce=1;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

   
    
    
    
        
}
