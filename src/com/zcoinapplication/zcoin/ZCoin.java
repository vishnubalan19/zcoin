package com.zcoinapplication.zcoin;

import java.util.Map;
import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;


import com.zcoinapplication.admin.Admin;
import com.zcoinapplication.admin.AdminUtility;
import com.zcoinapplication.data.Data;
import com.zcoinapplication.transaction.ZCoinTransaction;
import com.zcoinapplication.transaction.CoinTransaction;
import com.zcoinapplication.user.User;
import com.zcoinapplication.user.UserUtility;
import com.zcoinapplication.transaction.CoinConversion;

public class ZCoin {
    private List<User> userList = new ArrayList<>();
    private Map<Long, User> userMap = new LinkedHashMap<>();
    private Scanner scanner = new Scanner(System.in);
    private Admin admin = Admin.admin;
    public void getChoice(){
        System.out.println("ZCoin system");
        System.out.println("1.create account");
        System.out.println("2.change password");
        System.out.println("3.transact coins");
        System.out.println("4.view history");
        System.out.println("5.admin login");
        System.out.println("6.view account");
        System.out.println("7.exit");
        //System.out.println("");
        int choice = scanner.nextInt();
        boolean flag=false;
        switch(choice){
            case 1:
                String name,email,password,mobileNo;
                System.out.println("Enter sufficient details");
                System.out.println("Enter name");
                name = scanner.next();
                System.out.println("Enter email");
                email = scanner.next();
                System.out.println("Enter password");
                password = scanner.next();
                System.out.println("Enter mobileNo");
                mobileNo = scanner.next();
                flag = UserUtility.checkPassword(name, password, email, mobileNo);
                if(flag){
                    System.out.println("Enter unique id");
                    long hId = scanner.nextLong();
                    System.out.println("Enter coins");
                    float coin = scanner.nextFloat();
                    User user = new User();
                    user.setName(name);
                    user.setPassword(password);
                    user.setEmail(email);
                    user.setMobileNo(mobileNo);
                    user.setHId(hId);
                    user.setCoin(coin);
                    userList.add(user);
                }
                else{
                    System.out.println("Enter details with appropriate constraints");
                }
                getChoice();
                break;
            case 2:
                System.out.println("Enter unique id");
                long hId = scanner.nextLong();
                System.out.println("Enter password");
                password = scanner.next();
                userMap= admin.getUserMap();
                User temp = userMap.getOrDefault(hId,null);
                if(temp!=null&&temp.getPassword().equals(password)){
                    System.out.println("Enter new password");
                    String newPassword = scanner.next();
                    boolean value = UserUtility.changePassword(temp,newPassword);
                    if(value)
                        System.out.println("done");
                    else
                        System.out.println("enter appropriate password");
                }
                else
                    System.out.println("Enter appropriate details");
                getChoice();
                break;
            case 3:
                System.out.println("Enter unique id");
                hId = scanner.nextLong();
                System.out.println("Enter password");
                password = scanner.next();
                userMap = admin.getUserMap();
                temp = userMap.getOrDefault(hId,null);
                if(temp!=null&&temp.getPassword().equals(password)){
                    flag = true;
                    while(flag){
                        System.out.println("1.to another user");
                        System.out.println("2.convert own");
                        System.out.println("3.Exit");
                        int transactionChoice = scanner.nextInt();
                        switch(transactionChoice){
                            case 1 :
                                System.out.println("Enter account holder's unique id ");
                                long anotherUserHId = scanner.nextLong();
                                System.out.println("Enter r for coin transaction or enter any letter for zCoin transaction");
                                String r = scanner.next();
                                System.out.println("Enter coins");
                                float coin = scanner.nextFloat();
                                User anotherUser = userMap.getOrDefault(anotherUserHId,null);
                                if(anotherUser!=null){
                                    CoinTransaction coinTransaction;
                                    ZCoinTransaction zCoinTransaction;
                                    if(r.equals("r")){
                                        coinTransaction = new CoinTransaction();
                                        coinTransaction.setFromUser(temp.getName());
                                        coinTransaction.setToUser(anotherUser.getName());
                                        coinTransaction.setCoin(coin);
                                        admin.setCoinTransactionMap(coinTransaction);
                                        temp.setCoinTransactionMap(coinTransaction);
                                        anotherUser.setCoinTransactionMap(coinTransaction);
                                    }
                                    //t = new Transaction(temp.getName(),t2.getName(),amount,0);
                                    else {
                                        zCoinTransaction = new ZCoinTransaction();
                                        zCoinTransaction.setZCoin(coin);
                                        zCoinTransaction.setFromUser(temp.getName());
                                        zCoinTransaction.setToUser(anotherUser.getName());
                                        admin.setZCoinTransactionMap(zCoinTransaction);
                                        temp.setZCoinTransactionMap(zCoinTransaction);
                                        anotherUser.setZCoinTransactionMap(zCoinTransaction);
                                    }
                                    UserUtility.updateAccount(temp,r,-1,coin);
                                    UserUtility.updateAccount(anotherUser,r,1,coin);

                                }
                                break;
                            case 2 :
                                System.out.println("Enter coins");
                                coin = scanner.nextFloat();
                                CoinConversion coinConversion = new CoinConversion();
                                coinConversion.setCoin(coin);
                                coinConversion.setConversionRate(Data.data.getConversionRate());
                                boolean tempFlag = UserUtility.updateAccount(coin,temp);
                                temp.setCoinConversionMap(coinConversion);
                                admin.setCoinConversionMap(coinConversion);
                                break;
                            case 3:
                                flag = false;
                                break;
                            default :
                                System.out.println("enter appropriate values");
                                break;
                        }
                    }

                }
                else{
                    System.out.println("Enter appropriate details");
                }
                getChoice();
                break;
            case 4:
                System.out.println("Enter unique id");
                hId = scanner.nextLong();
                System.out.println("Enter password");
                password = scanner.next();
                userMap = admin.getUserMap();
                temp = userMap.getOrDefault(hId,null);
                if(temp!=null&&temp.getPassword().equals(password)){
                    flag = true;
                    while (flag) {
                        System.out.println("1.View Coin Transaction");
                        System.out.println("2.View ZCoin Transaction");
                        System.out.println("3.View Coin Conversion");
                        System.out.println("4.Exit");
                        int transactionMapChoice = scanner.nextInt();
                        switch (transactionMapChoice){
                            case 1:
                                UserUtility.viewCoinTransaction(temp.getCoinTransactionMap());
                                break;
                            case 2:
                                UserUtility.viewZCoinTransaction(temp.getZCoinTransactionMap());
                                break;
                            case 3:
                                UserUtility.viewCoinConversion(temp.getCoinConversionMap());
                                break;
                            case 4:
                                flag = false;
                                break;
                            default:
                                System.out.println("Enter appropriate values");
                                break;
                        }
                    }

                }
                else {
                    System.out.println("Enter appropriate details");
                }
                getChoice();
                break;
            case 5:
                System.out.println("Enter admin name");
                String adminName = scanner.next();
                System.out.println("Enter admin password");
                String adminPassword = scanner.next();
                if(adminName.equals(admin.getAdminName())&&adminPassword.equals(admin.getAdminPassword())){
                    flag = true;
                    while (flag){
                        System.out.println("1.Approve");
                        System.out.println("2.Set Rate");
                        System.out.println("3.View Transaction");
                        System.out.println("4.Exit");
                        int adminChoice = scanner.nextInt();
                        List<User>valuesList = new ArrayList<>();
                        switch(adminChoice){
                            case 1:
                                for(User user : userList){
                                    int val = scanner.nextInt();
                                    if(val==1)
                                        valuesList.add(user);
                                }
                                AdminUtility.approve(valuesList);
                                userList.clear();
                                valuesList.clear();
                                break;
                            case 2 :
                                float rate = scanner.nextFloat();
                                AdminUtility.changeRate(rate);
                                break;
                            case 3:
                                AdminUtility.viewAllCoinTransaction(admin.getCoinTransactionMap());
                                AdminUtility.viewAllZCoinTransaction(admin.getZCoinTransactionMap());
                                AdminUtility.viewAllCoinConversion(admin.getCoinConversionMap());
                                break;
                            case 4:
                                flag = false;
                                break;
                            default :
                                System.out.println("Enter appropriate value ");
                        }
                    }

                }
                else
                    System.out.println("Enter appropriate admin name or admin password");
                getChoice();
                break;
            case 6 :
                System.out.println("Enter unique id");
                hId = scanner.nextLong();
                System.out.println("Enter password");
                password = scanner.next();
                userMap = admin.getUserMap();
                temp = userMap.getOrDefault(hId,null);
                if(temp!=null&&temp.getPassword().equals(password)){
                        UserUtility.viewAccount(temp);
                }
                else{
                    System.out.println("Enter appropriate password");
                }
                getChoice();
                break;
            case 7:
                return;
            //break;
            default:
                System.out.println("Enter appropriate value");
                getChoice();
                break;
        }
    }
    public static void main(String [] args){
        new ZCoin().getChoice();
    }
}


