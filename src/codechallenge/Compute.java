/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codechallenge;

import java.util.Collections;
import java.util.Set;

/**
 *
 * @author USER
 */
public class Compute {
    Book book;
    
    public Compute() {
        book = new Book();
        book.BOOK_DISCOUNTS.put(1, 0.0d);
        book.BOOK_DISCOUNTS.put(2, 0.05d);
        book.BOOK_DISCOUNTS.put(3, 0.10d);
        book.BOOK_DISCOUNTS.put(4, 0.20d);
        book.BOOK_DISCOUNTS.put(5, 0.25d);
    }
    
    public double priceOfBooks(Integer... books) {
        book.bookSet.clear();
        processBookSet(books);
        return computePrice();
    }
    
    private double computePrice() {
        double totalPrice = 0.0d;
        for (Set<Integer> setOfBooks : book.bookSet) {
            totalPrice += priceBookSet(setOfBooks.size());
        }
        return totalPrice;
    }

    private void processBookSet(Integer[] books) {
        for (Integer bookInfo : books) {
            if (!book.addBookToSet(bookInfo)) {
                book.addNewBookSet(bookInfo);
            }
            sortBookSetPricing();
        }
    }

    private void sortBookSetPricing() {
        Collections.sort(book.bookSet, (Set<Integer> bookSetOne, Set<Integer> bookSetTwo) -> {
            if (compMoreBook(bookSetOne)) return -1;
            if (compMoreBook(bookSetTwo)) return 1;
            return ((Integer) bookSetTwo.size()).compareTo(bookSetOne.size());
        });
    }

    private boolean compMoreBook(final Set<Integer> bookSets) {
        return bookSets.size() == 3;
    }

    private double priceBookSet(int bookCount) {
        double discountValue = book.BOOK_DISCOUNTS.get(bookCount); 
        double priceNoDiscount = bookCount * book.BOOK_PRICE;
        return priceNoDiscount - (priceNoDiscount * discountValue);
    }
}
