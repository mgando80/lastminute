/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gandolfi.salestaxes;

import java.util.ArrayList;
import java.util.List;

/**
 * Main application class
 * @author m.gandolfi
 */
public class SalesTaxesApplication {
    //Given a List of List of ShoppingItem, builds ShoppingBasket objects and prints their content
    public void printReceiptDetails(List<List<ShoppingItem>> itemsLists) {
        TaxesEngine engine = new SalesTaxesEngine();
        System.out.println("OUTPUT");
        for (int i = 0; i < itemsLists.size(); i++) {
            ShoppingBasket basket = this.buildShoppingBasket(itemsLists.get(i), engine);
            System.out.println("\nOutput " + (i+1) + ":");
            basket.printContent();
        }
    }
    
    //Given a List of ShoppingItem, applies the correct taxes amount and returns a ShoppingBasket object
    public ShoppingBasket buildShoppingBasket(List<ShoppingItem> itemsList, TaxesEngine engine) {
        double basketSalesTaxes = 0;
        double basketTotal = 0;
        List<ShoppingItem> itemsWithTaxes = new ArrayList<>();
        for (ShoppingItem item : itemsList) {
            double itemTaxAmount = engine.calculateTaxesAmount(item);
            item.setTaxesAmount(itemTaxAmount);
            basketSalesTaxes += itemTaxAmount;
            basketTotal += item.getPriceWithTaxes();
            itemsWithTaxes.add(item);
        }
        return new ShoppingBasket(itemsWithTaxes, basketSalesTaxes, basketTotal);
    }
}
