package com.nealford.ft.adaptor;

public class RoundPeg implements Circularity {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public RoundPeg(int radius) {
        this.radius = radius;
    }
}
