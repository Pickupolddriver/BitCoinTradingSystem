/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blockchain;

import Business.Enterprise.Enterprise;
import java.util.HashMap;

/**
 *
 * @author lijianxi
 */
public class BlockChain {

    //private static int count=1;
    private HashMap<Integer, Block> hm;
    //We should use a singleton 
    // And we need to use this in configurebusiness

    public BlockChain() {
        //count = 1;
        hm = new HashMap<Integer, Block>();
    }
    //Actually we need to configure the First Block;
    //In the real-world the first block still need to be add manully

    //to add a new block in blockchaine
    //whenever we add a block I will help it to initialize in this area.
    //We need to manully add the first Block--->genius block;
    public HashMap<Integer, Block> getHm() {
        return hm;
    }

    public void addBlock(Block blc, Enterprise minerOrg) {
        blc.setMinerOrg(minerOrg);
        hm.put(hm.size()+1, blc);
        blc.setIndex(hm.size());
        blc.getHead().setPrevhashcode(hm.get(hm.size()-1).getHead().getHashcode());
        
        //so we can know the prev one's index and the self index;
    }

    public void addFirstBlock(Block blc, Enterprise minerOrg) {
        blc.setMinerOrg(minerOrg);
        hm.put(1, blc);
        blc.setIndex(1);
        blc.getHead().setPrevhashcode(0000);
        
        //so we can know the prev one's index and the self index;
    }
}
