package com.company;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Receipt {
    private int numberOfProductsSold;
    private double totalTax;
    private double totalPrice;
    private Set<String> medicalProducts = new HashSet<String>();
    private Set<String> foodProducts = new HashSet<String>();

    public void addMedicalProducts(){
        medicalProducts.add("Medicine");
        medicalProducts.add("Syringe");
        medicalProducts.add("Paracetamol");
        medicalProducts.add("Sanitizer");
    }

    public void addFoodProducts(){
        foodProducts.add("Chocolate Bar");
        foodProducts.add("Ice Cream");
        foodProducts.add("Imported Chocolate");
        foodProducts.add("Biscuits");
    }

    public void getNumberOfProductsSold(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of Products sold:");
        numberOfProductsSold = input.nextInt();
    }

    public boolean checkIsProductFood(String productNameToCheck){ //To prevent multiple dots i.e receipt.foodProducts.contains(productName)
        return foodProducts.contains(productNameToCheck);
    }

    public boolean checkIsProductMedical(String productNameToCheck){
        return medicalProducts.contains(productNameToCheck);
    }

    public boolean checkIsProductBook(String productNameToCheck){
        return productNameToCheck.equalsIgnoreCase("Book");
    }

    public boolean checkIsProductImported(String productNameToCheck){
        int isImported = productNameToCheck.indexOf("Imported");  //Finding the word "Imported" in the Product Name
        if(isImported == -1){
            return false;
        }
        else
            return true;
    }

    public void calculateTotalTax(double[] taxesForEachProduct){
        this.totalTax = 0.0;
        for(int i=0; i<numberOfProductsSold; i++){
            this.totalTax = this.totalTax + taxesForEachProduct[i];
        }
    }

    public void calculateTotalPrice(Product[] productsSold){
        this.totalPrice=0.0;
        for(int i=0; i<numberOfProductsSold; i++){
            this.totalPrice = this.totalPrice + productsSold[i].getProductPrice();
        }
    }

    public void printReceipt(Product[] productsSold){
        for(int i=0; i<numberOfProductsSold; i++){
            System.out.println(productsSold[i].getProductName() +
                    " : " + productsSold[i].getProductQuantity() +
                    " : " + productsSold[i].getProductPrice());
        }

        System.out.println("TOTAL TAX :" + this.totalTax);
        System.out.println("TOTAL AMOUNT :" + this.totalPrice);
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        double[] taxesForEachProduct;
        Scanner input = new Scanner(System.in);
        receipt.getNumberOfProductsSold();
        Product[] productsSold = new Product[receipt.numberOfProductsSold];
        taxesForEachProduct = new double[receipt.numberOfProductsSold];    //tax for productsSold[i] = taxesForEachProduct[i]
        for(int i=0; i<receipt.numberOfProductsSold; i++){
            productsSold[i] = new Product();

            System.out.println("Enter Product " + i+1 + " Name: ");
            String productName = input.nextLine();
            productsSold[i].setProductName(productName);

            System.out.println("Enter Product " + i+1 + " Quantity: ");
            int productQuantity = input.nextInt();
            productsSold[i].setProductQuantity(productQuantity);

            System.out.println("Enter Product " + i+1 + " Price:  ");
            double productPrice = input.nextDouble();
            productsSold[i].setProductPrice(productPrice);

            if( receipt.checkIsProductFood(productsSold[i].productName)
                || receipt.checkIsProductMedical(productsSold[i].productName)
                || receipt.checkIsProductBook(productsSold[i].productName)) {

                    taxesForEachProduct[i] = 0.0;
            }
            else{
                taxesForEachProduct[i] = 0.1 * productsSold[i].getProductPrice();
                taxesForEachProduct[i] = taxesForEachProduct[i] * productsSold[i].getProductQuantity();//Total tax on that Product
            }

            if(receipt.checkIsProductBook(productsSold[i].productName)){
                double additionalTaxOnImported = 0.05 * productsSold[i].getProductPrice();
                taxesForEachProduct[i] = taxesForEachProduct[i] + additionalTaxOnImported;
            }

            productsSold[i].updateAndRoundOffPrice(taxesForEachProduct[i]);

        }
        receipt.calculateTotalTax(taxesForEachProduct);
        receipt.calculateTotalPrice(productsSold);
        receipt.printReceipt(productsSold);

    }

}
