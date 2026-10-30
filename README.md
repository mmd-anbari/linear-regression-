# Gold Price Prediction: Custom Linear Regression from Scratch

This repository contains a fully custom, object-oriented implementation of a **Linear Regression** model written entirely in Java from scratch, without relying on any external machine learning or math libraries. It is designed to predict the next day's closing price of SPDR Gold Shares (GLD) based on historical market data.

## 📌 Project Highlights

- **Zero-Dependency ML:** Built strictly using Core Java.
- **Custom Matrix Operations:** Features a dedicated `MatrixMath` class handling matrix transposition, vector dot products, and multi-dimensional array processing.
- **Gauss-Jordan Elimination Solver:** Implements a custom linear system solver to calculate weights directly using the closed-form **Normal Equation**.
- **Bias/Intercept Handling:** Incorporates mathematical dummy features ($x_0 = 1.0$) to seamlessly calculate the model's bias within the matrix.
- **Time-Series Preprocessing:** Dynamically shifts target variables (Next-Day Close Price) mapping them to current-day features (Open, High, Low, Close, Volume).

## 🧮 Mathematical Foundation

Instead of using iterative methods like Gradient Descent, this engine calculates the exact analytical solution by solving the Normal Equation:

$$W = (X^T X)^{-1} X^T Y$$

The equations are mapped into an augmented matrix (representing $N$ equations with $N$ unknowns) and solved via custom Gauss-Jordan elimination to extract the optimal weights (including $w_0$ for bias).

## 🚀 Architecture

The project follows a clean Object-Oriented structure:
- `Main.java`: Handles CSV parsing, data preprocessing, and model execution.
- `Regression.java`: Core engine that calculates cross-sigmas, constructs the analytical matrix, and manages the feature dimensions.
- `MatrixMath.java`: Mathematical utility class responsible for executing matrix multiplications and the Gauss-Jordan elimination algorithm.

## 📊 Dataset
The model uses historical CSV data for **SPDR Gold Shares (GLD)** downloaded from Yahoo Finance.
*Features used:* `Open`, `High`, `Low`, `Close`, `Volume`.
*Target:* `Next Day's Close`.

## 🛠️ How to Run

1. Clone this repository.
2. Ensure you have the `gld_price_only.csv` dataset in the root directory of the project.
3. Run the `Main.java` class.
4. The console will output the optimally calculated weights ($w_0$ to $w_5$) for the features.

