package Blockchain;


import Blockchain.Block;
import Blockchain.BlockChain;
import Business.EcoSystem;
import Business.Network.Network;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raywa
 */
public interface searchNewestBlockAPI {
    /**
     * The purpose of this method is to compare and find the most updated blockchain and return it to the method which invokes it
     * @param business
     * @return: the newest blockchain
     */
     public static BlockChain searchNewestBlock(EcoSystem business) {
        BlockChain bc = new BlockChain();
        for (Network n : business.getNetworkList()) {
            for (int i = 0; i < n.getEnterpriseDirectory().getEnterpriseList().size(); i++) {
                //System.out.println("\n" + "test:"  + n.getEnterpriseDirectory().getEnterpriseList().get(i).getWallet().getBlockChaine());
                if (n.getEnterpriseDirectory().getEnterpriseList().get(i).getWallet().getBlockChaine().getHm().size() > bc.getHm().size()) {
                    bc = n.getEnterpriseDirectory().getEnterpriseList().get(i).getWallet().getBlockChaine();
                } else if (n.getEnterpriseDirectory().getEnterpriseList().get(i).getWallet().getBlockChaine().getHm().size() == bc.getHm().size()) {
                    BlockChain bc1 = n.getEnterpriseDirectory().getEnterpriseList().get(i).getWallet().getBlockChaine();
                    Block block1 = bc1.getHm().get(bc1.getHm().size()); 
                    //System.out.println(bc1.getHm().size());
                    //System.out.println(block1);
                    Block block2 = bc.getHm().get(bc.getHm().size());
                    int size1 = block1.getBody().getTransactions().size();
                    int size2 = block2.getBody().getTransactions().size();
                    if (size1 > size2) {
                        bc = bc1;
                    }else if (size1 == size2){
                        bc = bc1;
                    }
                }
            }
        }
        return bc;
    }
}
