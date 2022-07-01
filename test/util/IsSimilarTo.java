/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
/**
 *
 * @author USER
 */
public class IsSimilarTo extends BaseMatcher<Double>{
    private final double delta;
    private final double value;

    public IsSimilarTo(double value, double error) {
        this.delta = error;
        this.value = value;
    }

    @Override
    public boolean matches(Object item) {
        final Double itemValue = (Double) item;
        return actualDelta(itemValue) <= 0.0;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Total Price is not the same with your test case.");
    }

    private double actualDelta(Double item) {
        return (Math.abs((item - this.value)) - delta);
    }


    public static Matcher<Double> IsSimilarTo(double operand, double error) {
        return new IsSimilarTo(operand, error);
    }

    public static Matcher<Double> IsSimilarTo(double operand) {
        return new IsSimilarTo(operand, 0.001d);
    }
}
