package com.carrental.model;

import java.util.List;

public class MSTResult {
    private List<Edge> mstEdges;
    private double totalCost;
    private int operationsCount;
    private double executionTimeMs;
    private int vertexCount;
    private int edgeCount;
    private boolean connected;

    public MSTResult(List<Edge> mstEdges, double totalCost, int operationsCount, double executionTimeMs,
                     int vertexCount, int edgeCount, boolean connected) {
        this.mstEdges = mstEdges;
        this.totalCost = totalCost;
        this.operationsCount = operationsCount;
        this.executionTimeMs = executionTimeMs;
        this.vertexCount = vertexCount;
        this.edgeCount = edgeCount;
        this.connected = connected;
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

    public int getVertexCount() {
        return vertexCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public boolean isConnected() {
        return connected;
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

    public void setVertexCount(int vertexCount) {
        this.vertexCount = vertexCount;
    }

    public void setEdgeCount(int edgeCount) {
        this.edgeCount = edgeCount;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    // --- Utility for readable summary ---
    public String summary() {
        return String.format(
                "Vertices: %d | Edges: %d | Connected: %s | Total Cost: %.2f | Time: %.3f ms | Operations: %d",
                vertexCount, edgeCount, connected ? "Yes" : "No", totalCost, executionTimeMs, operationsCount
        );
    }
}