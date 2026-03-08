import java.util.Scanner;

public class paixur {
    public static void main(String [] args){
        Scanner sc=new Scanner (System.in );





    }
    //十种排序方法

    //==========================1.冒泡排序================================
    /**
     * 原理：相邻元素比较，逆序则交换，每轮将最大元素"冒泡"到末尾（优化：无交换则提前退出）
     * 时间：最好O(n)，最坏/平均O(n²) | 空间：O(1) | 稳定
     */
    public static void bubbleSort(int []arr){
        //判断
        if(arr==null|| arr.length <=1) return ;
        int n=arr.length ;
        for(int i=0;i<n-1;i++){

            for(int j=0;j<n-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

    }
    //=========================2.选择排序（Selection Sort）====================
    /**
     * 原理：每轮选择未排序区最小元素，与未排序区首个元素交换
     * 时间：最好/最坏/平均O(n²) | 空间：O(1) | 不稳定（交换破坏稳定性）
     */
    public static void selectionSort(int []arr){
        if(arr==null|| arr.length <=1)return ;
        int n=arr.length ;
        for(int i=0;i<n-1;i++){
            int min=i;
            for(int j=i+1;j<n-1;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
                int temp=arr[min];
                arr[min]=arr[j];
                arr[j]=temp;

            }

        }
    }
    //=========================3. 插入排序（Insertion Sort）====================
    /**
     * 原理：将元素逐个插入到已排序区的正确位置（类似整理扑克牌）
     * 时间：最好O(n)，最坏/平均O(n²) | 空间：O(1) | 稳定
     */
    public static void insertionSort(int []arr){
        if(arr==null|| arr.length <=1)return ;

        int n=arr.length ;

        for(int i=1;i<n;i++){
            int temp=arr[i];
            int j=i-1;
            while(j>=0&&arr[j]>temp){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
    }
    // ====================== 4. 归并排序（Merge Sort） ======================
    /**
     * 原理：分治思想，将数组拆分为子数组排序，再合并两个有序子数组
     * 时间：最好/最坏/平均O(n log n) | 空间：O(n)（辅助数组） | 稳定
     */
    public static void shellSort(int []arr,int left,int right,int []temp){
        if(left>right)return;
        //从中间拆分数组
        int mid=left+(right-left)>>1;
        shellSort(arr,left,mid,temp);
        shellSort(arr,mid+1,right,temp);
        int i=left;
        int j=mid+1;
        int index=0;
        //合并数组

        while(i<=mid&&j<=right){
            if(arr[i]<arr[j]){
                temp[index++]=arr[i]++;
            }else{
                temp[index++]=arr[j--];
            }
        }
        //判断那个数组还剩一个数
        while(i<=mid){
            temp[index++]=arr[i++];

        }
        while(j<=right){
            temp[index++]=arr[j++];
        }

        for(int k=left; k<=right; k++){
            arr[k]=temp[k];

        }

    }
    // ====================== 5. 快速排序 ======================
    public static void quickSort(int []arr ,int left ,int right){
        if(left>right)return ;
        int mid=left+(right-left)>>1;
        int i=left;
        int j=right;
        while(i<=j){
            while(arr[i]<arr[mid]){i++;
            }
            while(arr[j]>arr[mid]){j--;}
        }
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        if(i<right)quickSort(arr,left,i-1);
        if(j>left) quickSort(arr,i+1,right);
    }
    // ====================== 6. 哈希排序 ======================
    public static void mergeSort(int []arr){
        //gas 为增量
        for(int gas=arr.length/2;gas>0;gas=gas/2){
            for(int i=gas;i<arr.length;i++){
                int target=arr[gas];
                int j=i-gas;
                while(j>=0&&arr[j]<target){
                    arr[j+gas]=arr[j];
                    j-=gas;
                }
                arr[j+gas]=target;
            }
        }
    }
    // ====================== 7. 堆排序 ======================
    public class MinHeapSort {
        // 构建小顶堆：从最后一个非叶子节点开始向下调整
        public static void buildMinHeap(int[] A) {
            int n = A.length;
            // 最后一个非叶子节点索引：(n/2)-1
            for (int i = (n / 2) - 1; i >= 0; i--) {
                minHeapFixDown(A, i, n); // 传入堆大小n
            }
        }

        // 小顶堆向下调整（核心）：调整以i为根的子树为小顶堆，heapSize为当前堆的有效大小
        public static void minHeapFixDown(int[] A, int i, int heapSize) {
            int left = 2 * i + 1; // 左孩子索引
            int right = 2 * i + 2; // 右孩子索引
            int minIndex = i; // 最小元素的索引（初始为当前节点）

            // 找当前节点、左孩子、右孩子中的最小值
            if (left < heapSize && A[left] < A[minIndex]) {
                minIndex = left;
            }
            if (right < heapSize && A[right] < A[minIndex]) {
                minIndex = right;
            }

            // 若最小值不是当前节点，交换并递归调整子树
            if (minIndex != i) {
                swap(A, i, minIndex);
                minHeapFixDown(A, minIndex, heapSize); // 递归调整交换后的子树
            }
        }

        // 小顶堆排序（最终得到降序数组，小顶堆特性：堆顶是最小值）
        public static void sort(int[] A) {
            if (A == null || A.length <= 1) {
                return;
            }
            int n = A.length;
            buildMinHeap(A); // 第一步：构建小顶堆

            // 第二步：逐个取出堆顶（最小值），放到数组末尾，缩小堆范围并调整
            for (int heapSize = n - 1; heapSize > 0; heapSize--) {
                swap(A, 0, heapSize); // 堆顶（最小值）与当前堆最后一个元素交换
                minHeapFixDown(A, 0, heapSize); // 调整剩余堆（大小为heapSize）
            }
        }

        // 辅助方法：交换数组两个元素
        private static void swap(int[] A, int i, int j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }

        // 测试示例
        public static void main(String[] args) {
            int[] arr = {5, 2, 9, 3, 7, 6, 1, 8, 4};
            System.out.println("排序前：");
            for (int num : arr) {
                System.out.print(num + " ");
            }

            sort(arr); // 小顶堆排序（结果为降序）

            System.out.println("\n排序后（降序）：");
            for (int num : arr) {
                System.out.print(num + " ");
            }
        }
    }


}

