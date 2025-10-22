package com.carrental.model;

import java.util.List;

public class MSTResult {
    private List<Edge> mstEdges;
    private double totalCost;
    private int operationsCount;
    private double executionTimeMs;

    public MSTResult(List<Edge> mstEdges, double totalCost, int operationsCount, double executionTimeMs) {
        this.mstEdges = mstEdges;
        this.totalCost = totalCost;
        this.operationsCount = operationsCount;
        this.executionTimeMs = executionTimeMs;
    }

    // --- Getters ---
    public List<Edge> getMstEdges() {
        return mstEdges;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public int getOperationsCount() {
        return operationsCount;
    }

    public double getExecutionTimeMs() {
        return executionTimeMs;
    }

    // --- Utility for summary display ---
    public String summary() {
        return String.format("Cost: %.2f | Time: %.3f ms | Operations: %d",
                totalCost, executionTimeMs, operationsCount);
    }

    // --- Setters ---
    public void setMstEdges(List<Edge> mstEdges) {
        this.mstEdges = mstEdges;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setOperationsCount(int operationsCount) {
        this.operationsCount = operationsCount;
    }

    public void setExecutionTimeMs(double executionTimeMs) {
        this.executionTimeMs = executionTimeMs;
    }
}