# Portfolio Rebalancing Assessment

## Overview

This project implements a portfolio rebalancing algorithm and automated unit tests as part of a QA Automation technical assessment.

The application calculates how many shares should be bought or sold in order to rebalance a portfolio according to the target allocation percentages.

---

## Technologies

- Java 21
- Maven
- JUnit 5

---

## Project Structure

```
src
├── main
│   └── java
│       └── com.leonardocapristo.rebalance
│           ├── model
│           ├── service
│           └── Application.java
│
└── test
    └── java
        └── com.leonardocapristo.rebalance.service
```

---

## Business Rules

For each security:

1. Calculate the target value based on the target percentage.
2. Calculate the current value based on the current percentage.
3. Calculate the difference.
4. Divide the difference by the unit price.
5. Round the result to the nearest whole share.
6. Determine the action:
    - BUY
    - SELL
    - HOLD

---

## Assumptions

- Total portfolio value is **100,000 USD**.
- Shares are rounded using `Math.round()`.
- A positive difference means **BUY**.
- A negative difference means **SELL**.
- Zero difference means **HOLD**.

---

## Manual Test Cases

### Test Case 1 - Buy Shares

| Input | Expected Result |
|--------|-----------------|
| Target 20%, Current 10%, Price 150 | BUY 67 shares |

---

### Test Case 2 - Sell Shares

| Input | Expected Result |
|--------|-----------------|
| Target 20%, Current 30%, Price 220 | SELL 45 shares |

---

### Test Case 3 - Hold Position

| Input | Expected Result |
|--------|-----------------|
| Target 20%, Current 20%, Price 90 | HOLD 0 shares |

---

### Test Case 4 - Empty Portfolio

| Input | Expected Result |
|--------|-----------------|
| Empty asset list | Empty result list |

---

## Automated Tests

The project contains automated unit tests covering:

- Portfolio rebalancing calculation
- Buy scenario
- Sell scenario
- Hold scenario
- Empty portfolio

---

## Running the Application

Run the application:

```bash
mvn compile
mvn exec:java
```

Or execute:

```
Application.java
```

from your IDE.

---

## Running the Tests

```bash
mvn test
```

---

## Sample Output

```
IBM -> BUY 67 shares
MSFT -> HOLD 0 shares
ORCL -> SELL 45 shares
AAPL -> HOLD 0 shares
HD -> HOLD 0 shares
```

---

## Author

Leonardo Capristo
