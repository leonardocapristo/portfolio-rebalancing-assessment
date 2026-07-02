package com.leonardocapristo.rebalance.model;

public class RebalanceResult {

    private final String symbol;
    private final TradeAction action;
    private final int numberOfShares;

    public RebalanceResult(String symbol,
                           TradeAction action,
                           int numberOfShares) {

        this.symbol = symbol;
        this.action = action;
        this.numberOfShares = numberOfShares;
    }

    public String getSymbol() {
        return symbol;
    }

    public TradeAction getAction() {
        return action;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }
}