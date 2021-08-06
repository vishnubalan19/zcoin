package com.zcoinapplication.transaction;

public class CoinTransaction {
    private String fromUser;
    private String toUser;
    private float coin;
    private int transactionId;

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }
    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public void setCoin(float coin) {
        this.coin = coin;
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
    public float getCoin(){
        return coin;
    }

}
