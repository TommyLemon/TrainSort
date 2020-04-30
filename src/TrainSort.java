public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        trainCrossingSort(new int[]{ 1, -6, 12, 0, -3 });
        trainCrossingSort(new int[]{ 2, -1, 7, 9, 0, 120, -33 });
        trainCrossingSort(new int[]{ -2, 10, 21, 19, 0, 11, 32143, 2343, 325, -34, -3, 325, -3 });
        trainCrossingSort(new int[]{ 1, 0, -15, -1, 10, -21, 5, -3, 33, -243, 32, -4, -3, 100, -123, 353, 345, 235553, -7 });

    }

    /**火车交错排序法，对比次数从 0 递增到 length，再从 length 递减到 0，呈等腰三角形（冒泡排序、选择排序是长方形，每回对比次数固定）
     * @param arr
     * @return
     */
    private static int[] trainCrossingSort(int[] arr) {
        long start = System.currentTimeMillis();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> trainCrossingSort  start = " + start + "; arr = " + toString(arr));

        int compareCount = 0;

        for (int i = 0; i < 2*arr.length; i++) {  //头对尾 -> 尾对头
//            System.out.println("trainCrossingSort  for i = " + i + " { >>>>>>>>>>>> ");

            for (int j = 0; j <= i; j++) {  //重叠部分车厢，一对一对比
                compareCount ++;
//                System.out.println("  trainCrossingSort  for j = " + j + " { >>>>> ");

                int k = j - 1 - i + arr.length;

//                System.out.print("    trainCrossingSort i = " + i + "; j = " + j + "; k = " + k + "; compareCount = " + compareCount + " >> ");
                if (k >= 0 && k < arr.length && j < arr.length) {  //排除未重叠的车厢
//                    System.out.println("      trainCrossingSort  k >= 0 && k < arr.length && j < arr.length >> ");

                    if ((j < k && arr[j] > arr[k]) || (j > k && arr[j] < arr[k])) {
//                        System.out.println("        trainCrossingSort  (j < k && arr[j] > arr[k]) || (j > k && arr[j] < arr[k]) >> swap: arr[" + j + "] = " + arr[j] + ", arr[" + k + "] = " + arr[k]);
                        int temp = arr[j];
                        arr[j] = arr[k];
                        arr[k] = temp;
                    }

//                    System.out.println("      trainCrossingSort  swap >> arr = " + toString(arr));
                }

//                System.out.println("  trainCrossingSort  for j = " + j + " } <<<<< \n");
            }

//            System.out.println("trainCrossingSort  for i = " + i + " } <<<<<<<<<<< \n\n");
        }

        long end = System.currentTimeMillis();
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<< trainCrossingSort end = " + end + "; duration = " + (end - start) + "; compareCount = " + compareCount + "; arr = " + toString(arr) + "\n");

        return arr;
    }

    private static String toString(int[] arr) {
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            s += (i <= 0 ? "" : ", ") + arr[i];
        }
        return s;
    }
}
