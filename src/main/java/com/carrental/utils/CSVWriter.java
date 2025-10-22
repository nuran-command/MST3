package com.carrental.utils;

import com.carrental.model.Graph;
import com.carrental.model.MSTResult;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {
    public static void writeResults(String filePath, List<Graph> graphs,
                                    List<MSTResult> primResults,
                                    List<MSTResult> kruskalResults) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("GraphID,Vertices,Edges,Algorithm,TotalCost,Operations,ExecutionTimeMs\n");

            for (int i = 0; i < graphs.size(); i++) {
                Graph g = graphs.get(i);
                MSTResult prim = primResults.get(i);
                MSTResult kruskal = kruskalResults.get(i);

                writer.write(String.format("%d,%d,%d,Prim,%.2f,%d,%.3f\n",
                        g.getId(), g.vertexCount(), g.edgeCount(),
                        prim.getTotalCost(), prim.getOperationsCount(), prim.getExecutionTimeMs()));

                writer.write(String.format("%d,%d,%d,Kruskal,%.2f,%d,%.3f\n",
                        g.getId(), g.vertexCount(), g.edgeCount(),
                        kruskal.getTotalCost(), kruskal.getOperationsCount(), kruskal.getExecutionTimeMs()));
            }

            System.out.println("CSV results written to " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing CSV: " + e.getMessage());
        }
    }
}