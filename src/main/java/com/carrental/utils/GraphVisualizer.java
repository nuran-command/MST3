package com.carrental.utils;

import com.carrental.model.Graph;
import com.carrental.model.MSTResult;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;

public class GraphVisualizer {
    public static void displayGraph(Graph g, MSTResult mst) {
        System.setProperty("org.graphstream.ui", "swing"); // enable Swing UI

        org.graphstream.graph.Graph gs = new SingleGraph("City Graph");

        // Add nodes
        for (String node : g.getNodes()) {
            if (gs.getNode(node) == null) {
                Node n = gs.addNode(node);
                n.setAttribute("ui.label", node);
                n.setAttribute("ui.style", "fill-color: blue; size: 20px; text-size: 14px;");
            }
        }

        // Add edges
        for (com.carrental.model.Edge e : g.getEdges()) {
            String id = e.getFrom() + "_" + e.getTo();
            if (gs.getEdge(id) == null) { // only add if edge does not exist
                org.graphstream.graph.Edge gsEdge = gs.addEdge(id, e.getFrom(), e.getTo(), false);
                gsEdge.setAttribute("ui.label", e.getWeight());

                // Highlight MST edges
                boolean inMST = mst.getMstEdges().stream().anyMatch(me ->
                        (me.getFrom().equals(e.getFrom()) && me.getTo().equals(e.getTo())) ||
                                (me.getFrom().equals(e.getTo()) && me.getTo().equals(e.getFrom()))
                );
                if (inMST) {
                    gsEdge.setAttribute("ui.style", "fill-color: red; size: 3px;");
                } else {
                    gsEdge.setAttribute("ui.style", "fill-color: black; size: 2px;");
                }
            }
        }

        // Display the graph
        gs.display();
    }
}