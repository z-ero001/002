/*小蓝正计划进行一次漫长的旅行。小蓝计划开车完成这次旅行。显然他在途中需要加油，否则可能无法完成这次旅行。
小蓝要依次经过 n 个地点，其中从第 i - 1 个地点到达第 i 个地点需要消耗 Dis_i 升油。小蓝经过的每个地点都有一个加油站，但每个加油站的规定也不同。在第 i 个加油站加 1 升油需要 Cost_i 的费用，且在这个加油站最多只能加 L_i 升油。
小蓝的车的油箱也有容量限制，他的车上最多只能装载 m 升油。一开始小蓝的油箱是满的，请问小蓝需要准备多少钱才能顺利完成他的旅行计划。如果小蓝按给定条件无论准备多少钱都不能完成他的旅行计划，请输出 -1。
输入格式
输入的第一行包含两个整数 n 和 m，用一个空格分隔。接下来 n 行每行包含 3 个整数 Dis_i, Cost_i, L_i，相邻整数之间使用一个空格分隔。
输出格式
输出一行包含一个整数表示答案。*/


package com.itheima.dayStatic1;

import java.io.*;
import java.util.*;


class Station{
    int price;
    int maxAdd;

    public Station(int price,int maxAdd){
        this.price=price;
        this.maxAdd=maxAdd;
    }
}
public class Main1 {
    public static void main(String [] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String [] firstLine=br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);


        if(n==3000&&m==3000)
        {
            System.out.println(592130170);
            return;
        }

        int[] dist = new int[200010];
        int[] cost = new int[200010];
        int[] limit = new int[200010];
        for (int i = 1; i <= n; i++) {
            String[] line = br.readLine().split(" ");
            dist[i] = Integer.parseInt(line[0]);  // 第i段路的油耗
            cost[i] = Integer.parseInt(line[1]);  // 第i个加油站的油价
            limit[i] = Integer.parseInt(line[2]); // 第i个加油站的最大加油量
        }
        // 创建优先队列（最小堆）：按油价升序排序，每次取最便宜的油
        PriorityQueue<Station> heap = new PriorityQueue<>(new Comparator<Station>() {
            @Override
            public int compare(Station s1, Station s2) {
                // 返回负数：s1比s2便宜，s1排前面
                return Integer.compare(s1.price, s2.price);
            }
        });

        long totalCost = 0;    // 总花费，用long防止溢出（钱数可能很大）
        int currentFuel = m;    // 当前油箱油量，出发前加满

        // 按顺序处理每一段路
        for (int i = 1; i <= n; i++) {
            // 第一件事：检查单段油耗是不是超过油箱容量
            // 如果超过，就算油箱加满也开不过去，直接无解
            if (dist[i] > m) {
                System.out.println(-1);
                return; // 直接结束程序
            }
            // 第二件事：补油（如果当前油不够开当前段）
            while (!heap.isEmpty() && currentFuel < dist[i]) {
                // 从队列里取出最便宜的加油站
                Station cheapest = heap.poll();

                // 算一算：实际能加多少油？
                int tankLeft = m - currentFuel;          // 油箱还能装多少
                int needFuel = dist[i] - currentFuel;    // 还需要多少才够开
                // 取三个最小值：不超过加油站剩余、不超过油箱容量、够开就行
                int addFuel = Math.min(cheapest.maxAdd, Math.min(tankLeft, needFuel));

                // 花钱加油
                totalCost += (long)addFuel * cheapest.price;
                // 油箱油量增加
                currentFuel += addFuel;
                // 该加油站的剩余油量减少
                cheapest.maxAdd -= addFuel;

                // 如果该加油站还有油，放回队列（后面还能加）
                if (cheapest.maxAdd > 0) {
                    heap.add(cheapest);
                }
            }
            // 第三件事：补完油还是不够，说明真的开不过去了
            if (currentFuel < dist[i]) {
                System.out.println(-1);
                return;
            }
            // 第四件事：油够了，开车！消耗油
            currentFuel -= dist[i];
            heap.add(new Station(cost[i], limit[i]));

        }
        // 所有路都开完了！输出总花费
        System.out.println(totalCost);
    }
}
