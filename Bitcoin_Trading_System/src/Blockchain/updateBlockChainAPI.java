/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blockchain;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;

/**
 *
 * @author raywa
 */
public interface updateBlockChainAPI extends searchNewestBlockAPI {
    public static void updateBlockchain(EcoSystem business, Enterprise e){
        for (int i = business.getWorkQueue().getWorkRequestList().size() - 1; i>=0; i-- ){
            if (business.getWorkQueue().getWorkRequestList().get(i).getStatus().equals("Update Needed")){
                e.getWallet().setBlockChaine(business.getWorkQueue().getWorkRequestList().get(i).getBc());
                break;
            }
        }
    }
    
}
