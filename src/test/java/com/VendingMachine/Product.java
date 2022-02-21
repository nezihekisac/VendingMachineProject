package com.VendingMachine;

public class Product {

    String prName;
    int prCount;
    int prPrice;

    public Product(String name,int count,int price){
        this.prName=name;
        this.prCount=count;
        this.prPrice=price;
    }
    public  String getName(){
        return prName;
    }
    public int getPrice(){
        return prPrice;
    }
    public int getCount(){
        return prCount;
    }
    public void reduceCount(int amount){
        prCount-=amount;
    }
    public void increaseAmount(){
        prCount+=1;
    }


}
