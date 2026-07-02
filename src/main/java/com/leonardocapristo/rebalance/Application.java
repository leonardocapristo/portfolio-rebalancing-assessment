package com.leonardocapristo.rebalance;

import com.leonardocapristo.rebalance.model.Asset;
import com.leonardocapristo.rebalance.model.RebalanceResult;
import com.leonardocapristo.rebalance.service.RebalanceCalculator;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Asset> assets = List.of(
                new Asset("IBM", 20, 10, 150),
                new Asset("MSFT", 20, 20, 90),
                new Asset("ORCL", 20, 30, 220),
                new Asset("AAPL", 20, 20, 450),
                new Asset("HD", 20, 20, 70)
        );

        RebalanceCalculator calculator = new RebalanceCalculator();

        List<RebalanceResult> results = calculator.calculate(assets, 100000);

        results.forEach(result ->
                System.out.printf(
                        "%s -> %s %d shares%n",
                        result.getSymbol(),
                        result.getAction(),
                        result.getNumberOfShares()
                )
        );
    }
}