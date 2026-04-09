package com.itheima.dayStatic1;

import java.util.*;

public class mofazhen {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            // 使用三个数组分别存储 x, y, r
            double[] x = new double[n];
            double[] y = new double[n];
            double[] r = new double[n];

            // 读入每个魔法阵的参数
            for (int i = 0; i < n; i++) {
                x[i] = sc.nextDouble();
                y[i] = sc.nextDouble();
                r[i] = sc.nextDouble();
            }

            // 特判：只有一个魔法阵，无需连接
            if (n == 1) {
                System.out.println("0.00");
                return;
            }

            // 构建邻接矩阵 graph[i][j] 表示 i 和 j 之间的魔法回路长度
            double[][] graph = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    // 计算圆心之间的欧几里得距离
                    double dx = x[i] - x[j];
                    double dy = y[i] - y[j];
                    double centerDist = Math.sqrt(dx * dx + dy * dy);

                    // 边权 = max(圆心距 - 半径和, 0)
                    double weight = Math.max(centerDist - (r[i] + r[j]), 0.0);

                    // 无向图，对称赋值
                    graph[i][j] = weight;
                    graph[j][i] = weight;
                }
            }

            // 使用 Prim 算法求最小生成树的总权重
            double totalLength = prim(graph, n);

            // 输出结果，保留两位小数
            System.out.printf("%.2f\n", totalLength);
        }

        /**
         * Prim 算法求最小生成树（MST）的总权重
         * @param graph 邻接矩阵，graph[i][j] 表示节点 i 和 j 之间的边权
         * @param n 节点总数
         * @return MST 的总边权
         */
        private static double prim(double[][] graph, int n) {
            // minEdge[i]：当前 MST 到节点 i 的最小边权
            double[] minEdge = new double[n];
            // used[i]：节点 i 是否已加入 MST
            boolean[] used = new boolean[n];

            // 初始化：从节点 0 开始构建 MST
            Arrays.fill(minEdge, Double.MAX_VALUE);
            minEdge[0] = 0.0;

            double totalWeight = 0.0;

            // 共需加入 n 个节点
            for (int iter = 0; iter < n; iter++) {
                // 在未加入 MST 的节点中，找到 minEdge 最小的节点 u
                int u = -1;
                for (int i = 0; i < n; i++) {
                    if (!used[i] && (u == -1 || minEdge[i] < minEdge[u])) {
                        u = i;
                    }
                }

                // 将 u 加入 MST
                used[u] = true;
                totalWeight += minEdge[u];

                // 用 u 更新其他未加入节点到 MST 的最小边权
                for (int v = 0; v < n; v++) {
                    if (!used[v] && graph[u][v] < minEdge[v]) {
                        minEdge[v] = graph[u][v];
                    }
                }
            }

            return totalWeight;
        }
    }
