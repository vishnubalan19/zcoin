package com.zcoinapplication.transaction;

public class ZCoinTransaction {

    private String fromUser;
    private String toUser;
    private float zCoin;
    private int transactionId;

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }
    public void setToUser(String toUser) {
        this.toUser = toUser;
    }
    public void setZCoin(float zCoin) {
        this.zCoin = zCoin;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getFromUser() {
        return fromUser;
    }
    public String getToUser() {
        return toUser;
    }
    public int getTransactionId() {
        return transactionId;
    }
    public float getZCoin(){
        return zCoin;
    }



}
