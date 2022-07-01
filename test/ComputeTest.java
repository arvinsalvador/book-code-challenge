/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import codechallenge.Book;
import codechallenge.Compute;

import static org.junit.Assert.*;
import static util.IsSimilarTo.*;
import org.junit.Test;
/**
 *
 * @author USER
 */
public class ComputeTest {
    
    Book book = new Book();
    
    private final float BOOK_PRICE = book.BOOK_PRICE;
    private static final int BOOK_ONE = 0;
    private static final int BOOK_TWO = 1;
    private static final int BOOK_THREE = 2;
    private static final int BOOK_FOUR = 3;
    private static final int BOOK_FIVE = 4;
    
    
    private static final double DISCOUNT_SET_TWO_BOOKS = 0.95d;
    private static final double DISCOUNT_SET_THREE_BOOKS = 0.90d;
    private static final double DISCOUNT_SET_FOUR_BOOKS = 0.80d;
    private static final double DISCOUNT_SET_FIVE_BOOKS = 0.75d;
    
    @Test public void 
            oneBookShouldNotHaveAnyDiscount() {
                assertThat(priceOf(BOOK_ONE), IsSimilarTo(bookPrice(1)));
                assertThat(priceOf(BOOK_TWO), IsSimilarTo(bookPrice(1)));
                assertThat(priceOf(BOOK_THREE), IsSimilarTo(bookPrice(1)));
                assertThat(priceOf(BOOK_FOUR), IsSimilarTo(bookPrice(1)));
                assertThat(priceOf(BOOK_FIVE), IsSimilarTo(bookPrice(1)));
            }
            
    @Test public void
            plentyOfBooksShouldNotHaveDiscount() {
                assertThat(priceOf(BOOK_ONE, BOOK_ONE), IsSimilarTo(2 * bookPrice(1)));
                assertThat(priceOf(BOOK_FOUR, BOOK_FOUR, BOOK_FOUR), IsSimilarTo(3 * bookPrice(1)));
            }
    
    @Test public void
            twoDifferentBooksWithDiscount() {
                assertThat(priceOf(BOOK_ONE, BOOK_TWO), IsSimilarTo(bookPrice(2)));
            }
    @Test public void
            threeDifferentBooksWithDiscount() {
                assertThat(priceOf(BOOK_ONE, BOOK_TWO, BOOK_THREE), IsSimilarTo(bookPrice(3)));
            }
    @Test public void
            fourDifferentBooksWithDiscount() {
                assertThat(priceOf(BOOK_ONE, BOOK_TWO, BOOK_THREE, BOOK_FOUR), IsSimilarTo(bookPrice(4)));
            }
    @Test public void
            fiveDifferentBooksWithDiscount() {
                assertThat(priceOf(BOOK_ONE, BOOK_TWO, BOOK_THREE, BOOK_FOUR, BOOK_FIVE), IsSimilarTo(bookPrice(5)));
            }
    
    @Test public void
            testCase() {
                //
                assertThat(
                    priceOf(
                        BOOK_ONE, BOOK_ONE,    
                        BOOK_TWO, BOOK_TWO,
                        BOOK_THREE, BOOK_THREE,
                        BOOK_FOUR, BOOK_FOUR,
                        BOOK_FIVE, BOOK_FIVE
                    ),
                    IsSimilarTo(
                        60
                    )
                );
            }
    private double bookPrice(Integer numOfBooks) {
        return switch (numOfBooks) {
            case 1 -> 1 * BOOK_PRICE;
            case 2 -> 2 * (BOOK_PRICE * DISCOUNT_SET_TWO_BOOKS);
            case 3 -> 3 * (BOOK_PRICE * DISCOUNT_SET_THREE_BOOKS);
            case 4 -> 4 * (BOOK_PRICE * DISCOUNT_SET_FOUR_BOOKS);
            case 5 -> 5 * (BOOK_PRICE * DISCOUNT_SET_FIVE_BOOKS);
            default -> 1 * BOOK_PRICE;
        };
    }

    private double priceOf(Integer... books) {
        return new Compute().priceOfBooks(books);
    }
    
    
}
