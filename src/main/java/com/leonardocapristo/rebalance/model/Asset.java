package com.leonardocapristo.rebalance.model;

public class Asset {

    private final String symbol;
    private final double targetPercentage;
    private final double currentPercentage;
    private final double unitPrice;

    public Asset(String symbol,
                 double targetPercentage,
                 double currentPercentage,
                 double unitPrice) {

        this.symbol = symbol;
        this.targetPercentage = targetPercentage;
        this.currentPercentage = currentPercentage;
        this.unitPrice = unitPrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getTargetPercentage() {
        return targetPercentage;
    }

    public double getCurrentPercentage() {
        return currentPercentage;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}