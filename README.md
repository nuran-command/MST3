# MST3
# City Transportation Network Optimization with MST

**Author:** _Nurdan Zhanabayev_  
**Language:** _Java_  
**Dependencies:** _org.json_, optional _GraphStream_ for visualization

---

## Introduction
The goal is to optimize a city’s transportation network by connecting all districts with the **lowest possible construction cost**.  
This is achieved using **Minimum Spanning Tree (MST)** algorithms — **Prim’s** and **Kruskal’s** — applied to weighted undirected graphs where:
- **Vertices** represent city districts
- **Edges** represent potential roads
- **Weights** represent construction costs

---

## Overview

Optimize a city’s transportation network using **Minimum Spanning Tree (MST) algorithms**:

- **Prim’s Algorithm**
- **Kruskal’s Algorithm**

Graphs are represented with **vertices** _(districts)_ and **edges** _(roads with costs)_.

---

## Features

- Compute MSTs for multiple graph datasets
- Compare **execution time** and **operation counts** between algorithms
- Optional **graph visualization** with MST edges highlighted
- Export results in **JSON** and **CSV** formats

---

## 1. Summary of Input Data and Algorithm Results

| Graph ID | Vertices | Edges | Connected | Algorithm | Total Cost | Operations | Execution Time (ms) |
|-----------|-----------|-------|------------|------------|-------------|-------------|----------------------|
| 1 | 4 | 5 | true | Prim | 7.00 | 7 | 2.784 |
| 1 | 4 | 5 | true | Kruskal | 7.00 | 28 | 0.389 |
| 2 | 5 | 7 | true | Prim | 16.00 | 10 | 0.061 |
| 2 | 5 | 7 | true | Kruskal | 16.00 | 40 | 0.040 |
| 3 | 7 | 8 | true | Prim | 17.00 | 13 | 0.068 |
| 3 | 7 | 8 | true | Kruskal | 17.00 | 50 | 0.042 |
| 4 | 8 | 9 | true | Prim | 20.00 | 15 | 0.062 |
| 4 | 8 | 9 | true | Kruskal | 20.00 | 57 | 0.047 |

**Observations**
- All graphs are connected (`true`).
- Both algorithms produced the same **Total Cost**, confirming correctness.
- **Kruskal** performed faster in milliseconds.
- **Prim** required fewer operations as graph size increased.

---
## 2. Practical Comparison of Efficiency and Performance

| Criteria | Prim’s Algorithm | Kruskal’s Algorithm |
|-----------|------------------|---------------------|
| **Time complexity** | O(V²) or O(E log V) | O(E log E) or O(E log V) |
| **Observed execution time (ms)** | 0.06–0.18 (slightly higher) | 0.04–0.10 (slightly lower) |
| **Operations count** | ~3–4× fewer | ~4× more (due to edge sorting) |
| **Graph density handling** | Better for **dense** graphs | Better for **sparse** graphs |
| **Implementation** | Adjacency matrix or list | Sorting + DSU |
| **Memory usage** | Lower | Higher |
| **Practical results** | Fewer operations, simpler code | Faster on small graphs |

---

### 📈 Metric Analysis

| Metric | Derived From | Meaning |
|--------|---------------|----------|
| **Ops-to-Time Ratio** | `OperationsCount / ExecutionTimeMs` | How many operations executed per ms |
| **Scaling Behavior** | Compare Ops and Time as Vertices ↑ | Shows performance growth with graph size |

**Complexity Derivations:**
- Prim (matrix): O(V²)
- Prim (heap):   O(E log V)
- Kruskal:       O(E log E) ≈ O(E log V)

**Example (Graph 10):**
- Prim → 47 ops, 0.186 ms
- Kruskal → 171 ops, 0.108 ms

**Interpretation:**
- Kruskal is faster but does ~3.6× more work.
- Prim’s operations are heavier but fewer.
- Prim is more efficient per operation.

**Summary:**
- Kruskal → better for **sparse graphs (E ≈ V)**
- Prim → better for **dense graphs (E ≈ V²)**

---
## 3. Conclusions

1. **Correctness:** Both algorithms found identical MST costs.
2. **Efficiency:**
    - Kruskal was faster in raw time on small datasets.
    - Prim executed fewer operations, better for dense or large graphs.
3. **Performance by Graph Type:**
    - Sparse → Kruskal preferred
    - Dense → Prim preferred
4. **Scalability:**
    - For large networks, Prim with a **min-heap** scales better.
5. **Implementation Complexity:**
    - Kruskal → needs DSU + sorting
    - Prim → integrates easily with adjacency structures

**Overall Summary:**
- Kruskal → slightly faster on small sparse networks
- Prim → superior for dense networks and scalable with heaps

---

## 4. References

1. [FreeCodeCamp (2021) – Prim’s Algorithm Explained](https://www.freecodecamp.org/news/prims-algorithm-explained-with-pseudocode/)
2. [GeeksforGeeks – Prim’s vs Kruskal’s Algorithm](https://www.geeksforgeeks.org/)
3. [OpenStax (2020) – Data Structures and Algorithms](https://openstax.org/books/introduction-computer-science/pages/3-1-introduction-to-data-structures-and-algorithms)
4. [Programiz – Kruskal’s Algorithm](https://www.programiz.com/dsa/kruskal-algorithm)
5. [Programiz – Prim’s Algorithm](https://www.programiz.com/dsa/prim-algorithm)

## Usage

1. Build project with _Maven_
2. Run `Main` with optional input/output paths
3. Check results in `data/results.csv` and `data/output.json`

---

**full report is in report package**

