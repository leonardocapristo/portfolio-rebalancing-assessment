package com.leonardocapristo.rebalance.service;

import com.leonardocapristo.rebalance.model.Asset;
import com.leonardocapristo.rebalance.model.RebalanceResult;
import com.leonardocapristo.rebalance.model.TradeAction;

import java.util.ArrayList;
import java.util.List;

public class RebalanceCalculator {

    public List<RebalanceResult> calculate(List<Asset> assets, double totalPortfolioValue) {
        List<RebalanceResult> results = new ArrayList<>();

        for (Asset asset : assets) {
            double targetValue = totalPortfolioValue * asset.getTargetPercentage() / 100;
            double currentValue = totalPortfolioValue * asset.getCurrentPercentage() / 100;
            double difference = targetValue - currentValue;

            int numberOfShares = (int) Math.round(Math.abs(difference) / asset.getUnitPrice());

            TradeAction action;

            if (difference > 0) {
                action = TradeAction.BUY;
            } else if (difference < 0) {
                action = TradeAction.SELL;
            } else {
                action = TradeAction.HOLD;
                numberOfShares = 0;
            }

            results.add(new RebalanceResult(
                    asset.getSymbol(),
                    action,
                    numberOfShares
            ));
        }

        return results;
    }
}