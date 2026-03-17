/*进制规定了数字在数位上逢几进一。
X 进制是一种很神奇的进制，因为其每一数位的进制并不固定！例如说某种 X 进制数，最低数位为二进制，第二数位为十进制，第三数位为八进制，则 X 进制数 321 转换为十进制数为 65。
现在有两个 X 进制表示的整数 A 和 B，但是其具体每一数位的进制还不确定，只知道 A 和 B 是同一进制规则，且每一数位最高为 N 进制，最低为二进制。请你算出 A−B 的结果最小可能是多少。
请注意，你需要保证 A 和 B 在 X 进制下都是合法的，即每一数位上的数字要小于其进制。

输入格式
第一行一个正整数 N，含义如题面所述。
第二行一个正整数 Ma​，表示 X 进制数 A 的位数。
第三行 Ma​ 个用空格分开的整数，表示 X 进制数 A 按从高位到低位顺序各个数位上的数字在十进制下的表示。
第四行一个正整数 Mb​，表示 X 进制数 B 的位数。
第五行 Mb​ 个用空格分开的整数，表示 X 进制数 B 按从高位到低位顺序各个数位上的数字在十进制下的表示。
请注意，输入中的所有数字都是十进制的。*/

package com.itheima.dayStatic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    // 题目中定义的模数（虽然当前代码未用到，保留）
    static final long MOD = 1000000007L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 读取第一组输入：A（未使用）、Ma、数组arrA
        int A = Integer.parseInt(br.readLine());
        int Ma = Integer.parseInt(br.readLine());
        String[] firstLine = br.readLine().split(" ");
        int[] arrA = new int[Ma];
        for (int i = 0; i < Ma; i++) {
            arrA[i] = Integer.parseInt(firstLine[i]);
        }

        // 读取第二组输入：B（未使用）、Mb、数组arrB

        int Mb = Integer.parseInt(br.readLine());
        String[] secondLine = br.readLine().split(" ");
        int[] arrB = new int[Mb];
        for (int i = 0; i < Mb; i++) {
            arrB[i] = Integer.parseInt(secondLine[i]);
        }

        // 初始化newA数组（长度与arrA一致）
        int[] newA = new int[Ma];
        // 确保Mb-2不越界，先判断Mb的最小值
        int minLen = Math.min(Ma, Mb);
        for (int i = 0; i < minLen - 1; i++) { // 循环到minLen-1，避免越界
            // 处理i+1不超过数组长度的情况
            int maxVal = Math.max(arrA[i+1], arrB[i+1]);
            newA[i] = maxVal + 1;
            // 修复：避免数值小于2的情况（原逻辑的修正）
            if (newA[i] < 2) {
                newA[i] = 2;
            }
        }
        // 若newA还有剩余元素（比如Ma>Mb），最后一位设为1
        if (Ma > 0) {
            newA[Ma - 1] = 1;
        }

        // 计算最终count值（修复越界问题）
        long count = 0; // 改用long避免int溢出
        int loopLen = Math.min(Ma, Mb); // 只循环到两者中较短的长度
        for (int i = 0; i < loopLen; i++) {
            long ans = arrA[i] - arrB[i];

            // 遍历newA数组（避免newA长度不足）
            for (int j = i; j < newA.length; j++) {
                ans *= newA[j];
                // 可选：若需要取模，添加 ans %= MOD;
            }

            count += ans;
        }

        System.out.println(count%MOD);
        br.close(); // 关闭流，规范操作
    }
}
