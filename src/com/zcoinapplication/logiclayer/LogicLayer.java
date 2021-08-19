package com.zcoinapplication.logiclayer;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

import com.zcoinapplication.admin.AdminUtility;
import com.zcoinapplication.transaction.CoinConversion;
import com.zcoinapplication.transaction.CoinTransaction;
import com.zcoinapplication.transaction.ZCoinTransaction;
import com.zcoinapplication.user.UserUtility;
import com.zcoinapplication.user.User;
import com.zcoinapplication.admin.Admin;

public class LogicLayer {
    private Admin admin = Admin.admin;
    private List<User> userList = new ArrayList<>();
    public boolean checkPassword(String name, String password, String email,String mobileNo){
        return UserUtility.checkPassword(name,password,email,mobileNo);
    }
    public Map<Long,User> getUserMap(){
        return admin.getUserMap();
    }
    public boolean changePassword(User user, String newPassword){
        return UserUtility.changePassword(user,newPassword);
    }
    public void setUserList(User user){
        userList.add(user);
    }
    public List<User> getUserList(){
        return userList;
    }
    public void setCoinTransactionMap(CoinTransaction coinTransaction){
        admin.setCoinTransactionMap(coinTransaction);
    }
    public void setZCoinTransactionMap(ZCoinTransaction zCoinTransaction){
        admin.setZCoinTransactionMap(zCoinTransaction);
    }
    public void setCoinConversionMap(CoinConversion coinConversion){
        admin.setCoinConversionMap(coinConversion);
    }
    public String getAdminName(){
        return admin.getAdminName();
    }
    public String getAdminPassword(){
        return admin.getAdminPassword();
    }
    public void viewAdminTransaction(){
        AdminUtility.viewAllCoinTransaction(admin.getCoinTransactionMap());
        AdminUtility.viewAllZCoinTransaction(admin.getZCoinTransactionMap());
        AdminUtility.viewAllCoinConversion(admin.getCoinConversionMap());
    }
    public void adminApprove(List<User> valuesList){
        AdminUtility.approve(valuesList);
    }
    public void adminChangeRate(float rate){
        AdminUtility.changeRate(rate);
    }
}
