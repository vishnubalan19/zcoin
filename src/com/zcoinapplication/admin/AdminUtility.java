package com.zcoinapplication.admin;

import java.util.Map;
import java.util.List;


import com.zcoinapplication.transaction.CoinConversion;
import com.zcoinapplication.user.User;
import com.zcoinapplication.transaction.CoinTransaction;
import com.zcoinapplication.transaction.ZCoinTransaction;
import com.zcoinapplication.data.Data;

public class AdminUtility {
    private static int zId =1;
    public static void approve(List <User> userList){
        for(User user : userList) {
            user.setZId(zId);
            Admin.admin.setUserMap(user);
            zId++;
        }
    }
    public static void changeRate(float rate){
        Data.data.setConversionRate(rate);
    }
    public static void viewAllCoinTransaction(Map<Integer,CoinTransaction> coinTransactionMap){
        for(int i : coinTransactionMap.keySet()){
            CoinTransaction temp = coinTransactionMap.get(i);
            System.out.println(temp.getFromUser()+" "+temp.getToUser()+" "+temp.getCoin()+" "+temp.getTransactionId());
        }
    }
    public static void viewAllZCoinTransaction(Map<Integer,ZCoinTransaction> zCoinTransactionMap){
        for(int i : zCoinTransactionMap.keySet()){
            ZCoinTransaction temp = zCoinTransactionMap.get(i);
            System.out.println(temp.getFromUser()+" "+temp.getToUser()+" "+temp.getZCoin()+" "+temp.getTransactionId());
        }
    }
    public static void viewAllCoinConversion(Map<Integer, CoinConversion> coinConversionMap){
        for(int i : coinConversionMap.keySet()){
            CoinConversion temp = coinConversionMap.get(i);
            System.out.println(temp.getCoin()+" "+temp.getConversionRate());
        }
    }
}
