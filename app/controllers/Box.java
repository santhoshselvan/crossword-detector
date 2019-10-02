package controllers;

import java.math.BigInteger;

/**
 * Created by tsanthosh on 27/09/2016.
 */
public class Box implements Comparable<Box>{


    private int x, y, w, h;
    private BigInteger area;

    @Override
    public String toString() {
        return "Box{" +
                "x=" + x +
                ", y=" + y +
                ", w=" + w +
                ", h=" + h +
                '}';
    }


    public BigInteger getArea() {
        return BigInteger.valueOf(w * h);
    }
    @Override
    public int compareTo(Box o) {
        return this.getArea().compareTo(o.getArea());
    }
}
