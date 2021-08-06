package com.zcoinapplication.user;

import com.zcoinapplication.data.Data;
import com.zcoinapplication.transaction.CoinConversion;
import com.zcoinapplication.transaction.CoinTransaction;
import com.zcoinapplication.transaction.ZCoinTransaction;

import java.util.Map;
import java.util.regex.Pattern;

public class UserUtility {
    private static boolean value;
    public static boolean checkPassword(String name, String password, String email, String mobileNo){
        value = false;
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\W).+$";
        value = Pattern.matches(regex,password);
        if(!value)
            return false;
        if(password.length()<8)
            value=false;
        if(!value)
            return false;
        value = password.contains(name);
        if(value)
            return false;
        value = password.contains(email.substring(0,email.indexOf('@')));
        if(value)
            return false;
        value = password.contains(mobileNo);
        if(value)
            return false;
        return true;
    }

    public static boolean changePassword(User user, String newPassword){
        boolean value = false;
        value = checkPassword(user.getName(),newPassword,user.getEmail(), user.getMobileNo());
        if(value)
            user.setPassword(newPassword) ;
        return value;
    }
    public static void viewCoinTransaction(Map<Integer,CoinTransaction> coinTransactionMap){
        for(int i : coinTransactionMap.keySet()){
            CoinTransaction temp = coinTransactionMap.get(i);
            System.out.println(temp.getFromUser()+" "+temp.getToUser()+" "+temp.getCoin()+" "+temp.getTransactionId());
        }
    }
    public static void viewZCoinTransaction(Map<Integer,ZCoinTransaction> zCoinTransactionMap){
        for(int i : zCoinTransactionMap.keySet()){
            ZCoinTransaction temp = zCoinTransactionMap.get(i);
            System.out.println(temp.getFromUser()+" "+temp.getToUser()+" "+temp.getZCoin()+" "+temp.getTransactionId());
        }
    }
    public static void viewCoinConversion(Map<Integer, CoinConversion> coinConversionMap){
        for(int i : coinConversionMap.keySet()){
            CoinConversion temp = coinConversionMap.get(i);
            System.out.println(temp.getCoin()+" "+temp.getConversionRate()+" "+temp.getCoinConversionId());
        }
    }
    public static void viewAccount(User user){
        System.out.println(user.getName()+" "+user.getEmail()+" "+user.getCoin()+" "+user.getZCoin());
    }
    public static boolean updateAccount(float coin,User user){
        float rate =  Data.data.getConversionRate();
        user.setCoin(user.getCoin() - coin);
        user.setZCoin(user.getZCoin()+rate*coin);
        return true;
    }
    public static boolean updateAccount(User user,String a, int flag, float coin){
        if(a.equals("r")){
            if(flag==1)
                user.setCoin(user.getCoin()+ coin) ;
            else
                user.setCoin(user.getCoin()- coin); ;
        }
        else{
            if(flag==1)
                user.setZCoin(user.getZCoin()+coin);
            else
                user.setZCoin(user.getZCoin()-coin);
        }
        return true;
        //return false;
    }

}
