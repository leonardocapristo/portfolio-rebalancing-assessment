package com.leonardocapristo.rebalance.service;

import com.leonardocapristo.rebalance.model.Asset;
import com.leonardocapristo.rebalance.model.RebalanceResult;
import com.leonardocapristo.rebalance.model.TradeAction;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RebalanceCalculatorTest {

    private final RebalanceCalculator calculator = new RebalanceCalculator();

    @Test
    void shouldCalculatePortfolioRebalancingCorrectly() {
        List<Asset> assets = List.of(
                new Asset("IBM", 20, 10, 150),
                new Asset("MSFT", 20, 20, 90),
                new Asset("ORCL", 20, 30, 220),
                new Asset("AAPL", 20, 20, 450),
                new Asset("HD", 20, 20, 70)
        );

        List<RebalanceResult> results = calculator.calculate(assets, 100000);

        assertEquals(5, results.size());
        assertEquals(TradeAction.BUY, results.get(0).getAction());
        assertEquals(67, results.get(0).getNumberOfShares());
        assertEquals(TradeAction.SELL, results.get(2).getAction());
        assertEquals(45, results.get(2).getNumberOfShares());
    }

    @Test
    void shouldBuySharesWhenCurrentPercentageIsLowerThanTarget() {
        List<Asset> assets = List.of(new Asset("IBM", 20, 10, 150));

        List<RebalanceResult> results = calculator.calculate(assets, 100000);

        assertEquals(TradeAction.BUY, results.get(0).getAction());
        assertEquals(67, results.get(0).getNumberOfShares());
    }

    @Test
    void shouldSellSharesWhenCurrentPercentageIsHigherThanTarget() {
        List<Asset> assets = List.of(new Asset("ORCL", 20, 30, 220));

        List<RebalanceResult> results = calculator.calculate(assets, 100000);

        assertEquals(TradeAction.SELL, results.get(0).getAction());
        assertEquals(45, results.get(0).getNumberOfShares());
    }

    @Test
    void shouldHoldWhenCurrentPercentageEqualsTarget() {
        List<Asset> assets = List.of(new Asset("MSFT", 20, 20, 90));

        List<RebalanceResult> results = calculator.calculate(assets, 100000);

        assertEquals(TradeAction.HOLD, results.get(0).getAction());
        assertEquals(0, results.get(0).getNumberOfShares());
    }

    @Test
    void shouldReturnEmptyListWhenThereAreNoAssets() {
        List<RebalanceResult> results = calculator.calculate(List.of(), 100000);

        assertTrue(results.isEmpty());
    }
}