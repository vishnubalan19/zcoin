package com.zcoinapplication.user;

import java.util.Map;
import java.util.LinkedHashMap;

import com.zcoinapplication.transaction.CoinConversion;
import com.zcoinapplication.transaction.CoinTransaction;
import com.zcoinapplication.transaction.ZCoinTransaction;


public class User {
    //Data data =null;

//    public Data getData() {
//        if(data==null)
//            data = new Data();
//        return data;
//    }
    private String name;
    private String password;
    private String email;
    private String mobileNo;
    private long hId;
    private int  zId;
    private float zCoin, coin;
    private Map<Integer, CoinTransaction> coinTransactionMap = new LinkedHashMap<>();
    private Map<Integer, ZCoinTransaction> zCoinTransactionMap = new LinkedHashMap<>();
    private Map<Integer, CoinConversion> coinConversionMap = new LinkedHashMap<>();
    //private  int cId = 1;
    //private  int zCId = 1;
    //private  int cCId = 1;
    public void setName(String name){
        this.name = name;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setMobileNo(String mobileNo){
        this.mobileNo = mobileNo;
    }
    public void setHId(long hId){
        this.hId = hId;
    }
    public void setZId(int zId){
        this.zId = zId;
    }
    public void setZCoin(float zCoin){
        this.zCoin = zCoin;
    }
    public void setCoin(float coin) {
        this.coin = coin;
    }
    public void setCoinTransactionMap(CoinTransaction coinTransaction){
        coinTransactionMap.put(coinTransaction.getTransactionId(),coinTransaction);
    }
    public void setZCoinTransactionMap(ZCoinTransaction zCoinTransaction){
        zCoinTransactionMap.put(zCoinTransaction.getTransactionId(),zCoinTransaction);
    }
    public void setCoinConversionMap(CoinConversion coinConversion){
        coinConversionMap.put(coinConversion.getCoinConversionId(),coinConversion);
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getMobileNo() {
        return mobileNo;
    }
    public String getPassword(){
        return password;
    }
    public long getHId() {
        return hId;
    }
    public int getZId() {
        return zId;
    }
    public float getCoin() {
        return coin;
    }
    public float getZCoin() {
        return zCoin;
    }
    public Map<Integer,CoinTransaction> getCoinTransactionMap(){
        return coinTransactionMap;
    }
    public Map<Integer,ZCoinTransaction> getZCoinTransactionMap(){
        return zCoinTransactionMap;
    }
    public Map<Integer,CoinConversion> getCoinConversionMap(){ return coinConversionMap;}
}
