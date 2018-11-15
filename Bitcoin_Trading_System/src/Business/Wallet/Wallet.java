/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Wallet;

import Blockchain.Block;
import Blockchain.BlockChain;
import Blockchain.Transaction;
import java.util.ArrayList;
import java.util.Map;
import Blockchain.searchNewestBlockAPI;

/**
 *
 * @author lijianxi
 */
public class Wallet implements Counting, searchNewestBlockAPI {

    private int enterpriseID;
    private BlockChain blockChain;
    private int btcNum = 0;
    //???
    private float buyPrice;
    private float sellPrice;

    public Wallet(int a) {
        this.enterpriseID = a;
        blockChain = new BlockChain();
        // need to loop through all enterprises for the newest blockchain, then assign this blockchain to the new one
        //To change body of generated methods, choose Tools | Templates.
    }

    public float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BlockChain getBlockChaine() {
        return blockChain;
    }

    public void setBlockChaine(BlockChain blockChain) {
        this.blockChain = blockChain;
    }

    //This method is very important in validating the transactions; 
    //Please check it carefully
    @Override
    public Integer refreshCount() {
        btcNum = 0;
        Map map = blockChain.getHm();
        for (int i = 1; i <= map.size(); i++) {
            Block block = (Block) map.get(i);
            ArrayList<Transaction> transactionList = block.getBody().getTransactions();
            for (Transaction transaction : transactionList) {
                if (transaction.getFrom() == enterpriseID) {
                    btcNum = btcNum - transaction.getBtcAmount();
                } else if (transaction.getTo() == enterpriseID) {
                    btcNum = btcNum + transaction.getBtcAmount();
                }
            }

        }
        return btcNum;
    }
}
