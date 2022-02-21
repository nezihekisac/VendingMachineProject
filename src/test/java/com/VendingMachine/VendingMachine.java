package com.VendingMachine;

import java.util.*;

public class VendingMachine {

    public Scanner scanner=new Scanner(System.in);
    public HashMap<String,Product>products;
    public HashMap<String,Product>purchasedProducts;
    public Integer totalPurchaseAmount=0;
    public Integer availableBalance=0;

    public VendingMachine(){

        initialize();

    }
    private void initialize(){

      Product Coke=new Product("Coke",10,25);
      Product Pepsi=new Product("Pepsi",10,35);
      Product Soda=new Product("Soda",10,45);

      products=new HashMap();
      products.put("Coke",Coke);
      products.put("Soda",Soda);
      products.put("Pepsi",Pepsi);
      purchasedProducts=new HashMap();

    }
    public void selectProduct(String proName){

        Product product=products.get(proName);

        if(product.getCount()< 1){
            System.out.println("!!! Chosen Product Is Out Of Stock !!!");
            return;
        }

        int price=product.getPrice();

        if(price + totalPurchaseAmount>availableBalance){
            System.out.println("!!! Not Available Balance !!!");
            return;
        }

        totalPurchaseAmount +=price;
        availableBalance -=price;

        product.reduceCount(1);

        updateAllPurchasedProducts(proName);
        System.out.println(proName+" is to the basket");
    }

    private void updateAllPurchasedProducts(String proName){

        if(purchasedProducts.containsKey(proName)){

            Product product=purchasedProducts.get(proName);
            product.increaseAmount();
            purchasedProducts.put(proName,product);

        }else{
            int price=products.get(proName).getPrice();
            Product product=new Product(proName,1,price);
            purchasedProducts.put(proName,product);
        }
    }

    public void purchase(){

        for(String proName : purchasedProducts.keySet()){
            Product product=purchasedProducts.get(proName);
            System.out.println(product.getName() + " " + product.getCount() + " amount " + "product total price: " + product.getCount()*product.getPrice());

        }

        int amount = availableBalance;
        Change(amount);
        System.out.println(amount + " is remained");

    }

    public void addingAvailableBalance(int money){

        availableBalance+=money;
    }

    private void Change(int amount){

        int[] moneys ={0,0,0,0};
        String[] strMoneys={"Quarter","Dime","Nickel","Penny"};

        while(amount>0){
            if(amount>=25){
                amount-=25;
                moneys[0] +=1;
            }else if(amount>=10){
                amount-=10;
                moneys[1]+=1;
            }else if(amount>=5){
                amount-=5;
                moneys[2]+=1;
            }else if(amount<5){
                amount-=1;
                moneys[3]+=1;
            }
        }

        for(int i=0;i< strMoneys.length;i++){
            if(moneys[i]>0){
                System.out.println(moneys[i] + " " + strMoneys[i]);
            }
        }


    }

    public void Refund(){

        System.out.println("\n---------------------------");
        System.out.println("!!! Here is your REFUND !!!");


        Change(availableBalance);

        initialize();

    }



}
