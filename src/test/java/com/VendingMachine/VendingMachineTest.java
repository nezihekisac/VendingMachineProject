package com.VendingMachine;

import java.util.Scanner;

public class VendingMachineTest {


    static Scanner scanner=new Scanner(System.in);
    private static VendingMachine vendingMachine;

    public static void main(String[] args){

        vendingMachine=new VendingMachine();

        boolean quit=false;
        int inserted=0;

        System.out.println("--------------------------------");
        System.out.println("===WELCOME TO VENDING MACHINE===");


        while(!quit){
            System.out.println("\n ---Please Insert Coin---");

            insertingCoin();

            inserted=scanner.nextInt();
            scanner.nextLine();

            switch(inserted){
                case 1:
                    vendingMachine.addingAvailableBalance(1);
                    System.out.println("\nTotal Balance: " + vendingMachine.availableBalance + " Cents");
                    break;
                case 5:
                    vendingMachine.addingAvailableBalance(5);
                    System.out.println("\nTotal Balance: " + vendingMachine.availableBalance + " Cents");
                    break;
                case 10:
                    vendingMachine.addingAvailableBalance(10);
                    System.out.println("\nTotal Balance: " + vendingMachine.availableBalance + " Cents");
                    break;
                case 25:
                    vendingMachine.addingAvailableBalance(25);
                    System.out.println("\nTotal Balance: " + vendingMachine.availableBalance + " Cents");
                    break;
                case 9:
                    selectingProduct();
                    quit=true;
                    break;
                case 0:
                    quit=true;
                    vendingMachine.Refund();
                    break;
                default:
                    System.out.println("\n!!! Insert VALID COIN PLEASE !!!");
                    break;

            }

        }

    }
    public static void insertingCoin(){
        System.out.println("\n**Please Press**");
        System.out.println("\t1   -> to Insert Penny");
        System.out.println("\t5   -> to Insert Nickel");
        System.out.println("\t10  -> to Insert Dime");
        System.out.println("\t25  -> to Insert Quarter");
        System.out.println("\t9   -> to Proceed to the products");
        System.out.println("\t0   -> to Reset");

    }

    public static void selectingProduct(){

        boolean quit=false;
        int choice =0;

        System.out.println("\nYour Current Balance Is: " + vendingMachine.availableBalance + " Cents");

        while (!quit){

            System.out.println("\nPlease Choose the Products");

            listOfProducts();

            choice=scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    vendingMachine.selectProduct("Coke");
                    System.out.println("\nYour Remaining Balance: " + vendingMachine.availableBalance + " Cents");
                    break;
                case 2:
                    vendingMachine.selectProduct("Pepsi");
                    System.out.println("\nYour Remaining Balance: " + vendingMachine.availableBalance + " Cents");
                    break;
                case 3:
                    vendingMachine.selectProduct("Soda");
                    System.out.println("\nYour Remaining Balance: " + vendingMachine.availableBalance + " Cents");
                    break;
                case 8:
                    vendingMachine.purchase();
                    quit=true;
                    break;
                case 9:
                    vendingMachine.Refund();
                    quit=true;
                    break;
                default:
                    System.out.println("\n!!!Invalid Choice--Try Again!!!");
                    break;

            }

        }

    }
    public static void listOfProducts(){

        System.out.println("\n***Please Press***");
        System.out.println("\t1  -> to select COKE (25 Cents)");
        System.out.println("\t2  -> to select PEPSI (35 Cents)");
        System.out.println("\t3  -> to select SODA (45 Cents)");
        System.out.println("\t8  -> to Complete the Purchase");
        System.out.println("\t1  -> to Cancel and Get Refund");

    }



}
