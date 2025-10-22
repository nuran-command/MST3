package com.carrental;

import com.carrental.model.Graph;
import com.carrental.model.MSTResult;
import com.carrental.algorithms.PrimMST;
import com.carrental.algorithms.KruskalMST;
import com.carrental.utils.JSONReader;
import com.carrental.utils.JSONWriter;
import org.json.JSONObject;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // --- Configurable file paths ---
        String inputPath = args.length > 0 ? args[0] : "data/input.json";
        String outputPath = args.length > 1 ? args[1] : "data/output.json";

        System.out.println("=== Minimum Spanning Tree Comparison ===");
        System.out.println("Input file: " + inputPath);
        System.out.println("Output file: " + outputPath);

        // --- Load graphs from JSON ---
        List<Graph> graphs;
        try {
            graphs = JSONReader.loadGraphs(inputPath);
        } catch (Exception e) {
            System.err.println("Error loading graphs from JSON: " + e.getMessage());
            return;
        }

        if (graphs.isEmpty()) {
            System.err.println("No graphs found in " + inputPath);
            return;
        }

        // --- Initialize algorithms ---
        PrimMST prim = new PrimMST();
        KruskalMST kruskal = new KruskalMST();

        List<JSONObject> results = new ArrayList<>();
        int index = 1;

        for (Graph g : graphs) {
            System.out.println("\n--- Graph " + index + " (" + g.getVertices().size() + " vertices, "
                    + g.getEdges().size() + " edges) ---");

            try {
                MSTResult primRes = prim.run(g);
                MSTResult kruskalRes = kruskal.run(g);

                JSONObject graphResult = JSONWriter.createGraphResult(g, primRes, kruskalRes);
                results.add(graphResult);

                // Console summary
                System.out.printf("Prim: cost=%.2f, time=%.3f ms, ops=%d%n",
                        primRes.getTotalCost(), primRes.getExecutionTimeMs(), primRes.getOperationsCount());
                System.out.printf("Kruskal: cost=%.2f, time=%.3f ms, ops=%d%n",
                        kruskalRes.getTotalCost(), kruskalRes.getExecutionTimeMs(), kruskalRes.getOperationsCount());
            } catch (Exception e) {
                System.err.println("Error processing graph " + index + ": " + e.getMessage());
            }

            index++;
        }

        // --- Save results ---
        try {
            JSONWriter.writeResults(outputPath, results);
            System.out.println("\nMST results successfully written to " + outputPath);
        } catch (Exception e) {
            System.err.println("Error writing output file: " + e.getMessage());
        }

        System.out.println("=== Processing Complete ===");
    }
}