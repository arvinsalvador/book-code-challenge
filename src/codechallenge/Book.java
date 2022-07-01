/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codechallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author USER
 */
public class Book {
    public final float BOOK_PRICE = 8.0f;
    public final Map<Integer, Double> BOOK_DISCOUNTS = new HashMap<>();
    public final List<Set<Integer>> bookSet = new ArrayList<>(10);
    
    public void addNewBookSet(final Integer book) {
        bookSet.add(new HashSet<Integer>(5) {
            {
                add(book);
            }
        });
    }
    
    public boolean addBookToSet(Integer book) {
        for (Set<Integer> bookSets : bookSet) {
            if (!bookSets.contains(book)) {
                bookSets.add(book);
                return true;
            }
        }
        return false;
    }
}
