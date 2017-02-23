/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gandolfi.salestaxes;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author m.gandolfi
 */
public class SalesTaxesTest {
    
    @Test
    public void printSample() {
        List<List<ShoppingItem>> itemsLists = new ArrayList<>();
        
        List<ShoppingItem> list1 = new ArrayList<>();
        list1.add(new ShoppingItem("book", "book", 1, false, 12.49));
        list1.add(new ShoppingItem("music", "music CD", 1, false, 14.99));
        list1.add(new ShoppingItem("food", "chocolate bar", 1, false, 0.85));
        itemsLists.add(list1);
        
        List<ShoppingItem> list2 = new ArrayList<>();
        list2.add(new ShoppingItem("food", "imported box of chocolates", 1, true, 10.00));
        list2.add(new ShoppingItem("perfume", "imported bottle of perfume", 1, true, 47.50));
        itemsLists.add(list2);
        
        List<ShoppingItem> list3 = new ArrayList<>();
        list3.add(new ShoppingItem("perfume", "imported bottle of perfume", 1, true, 27.99));
        list3.add(new ShoppingItem("perfume", "bottle of perfume", 1, false, 18.99));
        list3.add(new ShoppingItem("medical", "packet of headache pills", 1, false, 9.75));
        list3.add(new ShoppingItem("food", "box of imported chocolates", 1, true, 11.25));
        itemsLists.add(list3);
        
        SalesTaxesApplication application = new SalesTaxesApplication();
        application.printReceiptDetails(itemsLists);
    }
}
