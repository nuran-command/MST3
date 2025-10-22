package com.carrental.utils;

import com.carrental.model.Graph;
import com.carrental.model.MSTResult;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class CSVWriter {
    public static void writeResults(String filePath, List<Graph> graphs,
                                    List<MSTResult> primResults,
                                    List<MSTResult> kruskalResults) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("GraphID,Vertices,Edges,Connected,Algorithm,TotalCost,Operations,ExecutionTimeMs,CheaperAlgorithm,FasterAlgorithm\n");

            for (int i = 0; i < graphs.size(); i++) {
                Graph g = graphs.get(i);
                MSTResult prim = primResults.get(i);
                MSTResult kruskal = kruskalResults.get(i);

                String cheaper = prim.getTotalCost() < kruskal.getTotalCost() ? "Prim" :
                        prim.getTotalCost() > kruskal.getTotalCost() ? "Kruskal" : "Equal";
                String faster = prim.getExecutionTimeMs() < kruskal.getExecutionTimeMs() ? "Prim" :
                        prim.getExecutionTimeMs() > kruskal.getExecutionTimeMs() ? "Kruskal" : "Equal";

                // Prim result line
                writer.write(String.format(Locale.US,
                        "%d,%d,%d,%b,Prim,%.2f,%d,%.3f,%s,%s\n",
                        g.getId(), g.vertexCount(), g.edgeCount(), prim.isConnected(),
                        prim.getTotalCost(), prim.getOperationsCount(), prim.getExecutionTimeMs(),
                        cheaper, faster));

                // Kruskal result line
                writer.write(String.format(Locale.US,
                        "%d,%d,%d,%b,Kruskal,%.2f,%d,%.3f,%s,%s\n",
                        g.getId(), g.vertexCount(), g.edgeCount(), kruskal.isConnected(),
                        kruskal.getTotalCost(), kruskal.getOperationsCount(), kruskal.getExecutionTimeMs(),
                        cheaper, faster));
            }

            System.out.println("CSV results written to " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing CSV: " + e.getMessage());
        }
    }
}