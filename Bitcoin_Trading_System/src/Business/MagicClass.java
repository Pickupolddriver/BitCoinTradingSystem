/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Blockchain.Block;
import Blockchain.BlockChain;
import Blockchain.Transaction;
import Business.Enterprise.Enterprise;
import java.util.Date;

/**
 *
 * @author lijianxi
 */
public class MagicClass {

    public Block firstBlock(Enterprise santoshi, Enterprise minerOrg) {
        BlockChain blockchain = new BlockChain();
        santoshi.getWallet().setBlockChaine(blockchain);
        //blockchain.addBlock(blc, minerOrg);
        Block firstblock = new Block();
        //add a block 
        firstblock.getHead().setPrevhashcode(0000);
        firstblock.getHead().setNonce(0);
        firstblock.getHead().setTarget(10);
        firstblock.getHead().setTimestamp(new Date());
        //add the first block to the blockchain
        //it will automatically set the hashmap: the index and add the block chaine
        blockchain.addFirstBlock(firstblock, minerOrg);
        //santoshi is a special Enterprise, it's the constructer of the Blockchain;
        //So may be every time to count the coins in Santoshi's wallet, the way need to be different
        return firstblock;
    }
public void secondTrans(Enterprise sysent, Enterprise recieventerprise, Enterprise minerOrg, Block firstblock) {
        //add a transaction
        Transaction secTran = new Transaction();
        firstblock.getBody().addTransaction(secTran, minerOrg);
        secTran.setFrom(sysent.getenterpriseId());
        System.out.println("From Magic Class initTrans: SentID : " + sysent.getenterpriseId());
        System.out.println("From Magic Class initTrans: recieventerpriseID : " + recieventerprise.getenterpriseId());
        secTran.setTo(recieventerprise.getenterpriseId());
        secTran.setBtcAmount(100);
        secTran.setID(1);
        secTran.setLocktime("2018-04-16");
        secTran.setMinerOrganization(minerOrg);
        secTran.refreshTranHashcode();
        secTran.setTransactionDate(new Date());
        firstblock.getBody().refreshBodyHashcode();
        firstblock.getHead().refreshHashcode();
        //now we has transfer 100 btc to the firstrecieve enterprise;

    }
    public void initalTrans(Enterprise sysent, Enterprise recieventerprise, Enterprise minerOrg, Block firstblock) {
        //add a transaction
        Transaction firstTran = new Transaction();
        firstblock.getBody().addTransaction(firstTran, minerOrg);
        firstTran.setFrom(sysent.getenterpriseId());
        System.out.println("From Magic Class initTrans: SentID : " + sysent.getenterpriseId());
        System.out.println("From Magic Class initTrans: recieventerpriseID : " + recieventerprise.getenterpriseId());
        firstTran.setTo(recieventerprise.getenterpriseId());
        firstTran.setBtcAmount(2100);
        firstTran.setID(0);
        firstTran.setLocktime("2018-04-16");
        firstTran.setMinerOrganization(minerOrg);
        firstTran.refreshTranHashcode();
        firstTran.setTransactionDate(new Date());

        firstblock.getBody().refreshBodyHashcode();
        firstblock.getHead().refreshHashcode();
        //now we has transfer 100 btc to the firstrecieve enterprise;

    }

}
