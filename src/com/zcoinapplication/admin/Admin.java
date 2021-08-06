package com.zcoinapplication.admin;

import com.zcoinapplication.transaction.CoinConversion;
import com.zcoinapplication.transaction.CoinTransaction;
import com.zcoinapplication.transaction.ZCoinTransaction;
import com.zcoinapplication.user.User;

import java.util.LinkedHashMap;
import java.util.Map;

public enum Admin{
//    private Admin(){
//
//    }
    //private static Admin admin = null;
    admin;
    private Map<Long, User> userMap = new LinkedHashMap<>();
    private Map<Integer, CoinTransaction> coinTransactionMap = new LinkedHashMap<>();
    private Map<Integer, ZCoinTransaction> zCoinTransactionMap = new LinkedHashMap<>();
    private Map<Integer, CoinConversion> coinConversionMap = new LinkedHashMap<>();
    private String adminName = "vishnu", adminPassword = "vishnu";
    private static int coinTransactionId =1,zCoinTransactionId=1,coinConversionId=1;
//    public static Admin getInstance() {
//        if(admin==null)
//            admin = new Admin();
//        return admin;
//    }

    public void setUserMap(User user){
        userMap.put(user.getHId(),user);
    }
    public void setCoinTransactionMap(CoinTransaction coinTransaction){
        coinTransaction.setTransactionId(coinTransactionId);
        coinTransactionMap.put(coinTransactionId,coinTransaction);
        coinTransactionId++;
    }
    public void setZCoinTransactionMap(ZCoinTransaction zCoinTransaction){
        zCoinTransaction.setTransactionId(zCoinTransactionId);
        zCoinTransactionMap.put(zCoinTransactionId,zCoinTransaction);
        zCoinTransactionId++;
    }
    public void setCoinConversionMap(CoinConversion coinConversion){
        coinConversion.setCoinConversionId(coinConversionId);
        coinConversionMap.put(coinConversionId,coinConversion);
        coinConversionId++;
    }
    public Map<Long,User> getUserMap(){
        return userMap;
    }
    public Map<Integer,CoinTransaction> getCoinTransactionMap(){
        return coinTransactionMap;
    }
    public Map<Integer, ZCoinTransaction> getZCoinTransactionMap() {
        return zCoinTransactionMap;
    }
    public Map<Integer, CoinConversion> getCoinConversionMap(){ return coinConversionMap;}
    public String getAdminName(){
        return adminName;
    }
    public String getAdminPassword(){
        return adminPassword;
    }
}