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
        String inputPath = "data/input.json";
        String outputPath = "data/output.json";

        // --- Load graphs from JSON ---
        List<Graph> graphs = JSONReader.loadGraphs(inputPath);
        List<JSONObject> results = new ArrayList<>();

        // --- Initialize algorithms ---
        PrimMST prim = new PrimMST();
        KruskalMST kruskal = new KruskalMST();

        // --- Run MSTs on each graph ---
        for (Graph g : graphs) {
            MSTResult primRes = prim.run(g);
            MSTResult kruskalRes = kruskal.run(g);

            JSONObject graphResult = JSONWriter.createGraphResult(g, primRes, kruskalRes);
            results.add(graphResult);
        }

        // --- Save to output file ---
        JSONWriter.writeResults(outputPath, results);
        System.out.println("MST results written to " + outputPath);
    }
}