/**
 * MIT License
 *
 * Copyright (c) 2020 TommyLemon
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/**火车交错排序法
 * @author TommyLemon(tommylemon@qq.com)
 */
public class TrainSort {

    public static void main(String[] args) {
        System.out.println("火车交错排序法 by TommyLemon：开始测试");

        assertEquals(trainCrossingSort(null), null);
        assertEquals(trainCrossingSort(new int[]{}), new int[]{});
        assertEquals(trainCrossingSort(new int[]{1}), new int[]{1});

        assertEquals(trainCrossingSort(new int[]{1, 2}), new int[]{1, 2});
        assertEquals(trainCrossingSort(new int[]{2, 1}), new int[]{1, 2});
        assertEquals(trainCrossingSort(new int[]{-3, -2, -1}), new int[]{-3, -2, -1});
        assertEquals(trainCrossingSort(new int[]{-1, -2, -3}), new int[]{-3, -2, -1});

        assertEquals(trainCrossingSort(new int[]{ 1, -6, 12, 0, -3 }), new int[]{-6, -3, 0, 1, 12});
        assertEquals(trainCrossingSort(new int[]{ 2, -1, 7, 9, 0, 120, -33 }), new int[]{-33, -1, 0, 2, 7, 9, 120});

        assertEquals(
                trainCrossingSort(new int[]{ -2, 10, 21, 19, 0, 11, 32143, 2343, 325, -34, -3, 325, -3 })
                , new int[]{-34, -3, -3, -2, 0, 10, 11, 19, 21, 325, 325, 2343, 32143}
        );
        assertEquals(
                trainCrossingSort(new int[]{ 1, 0, -15, -1, 10, -21, 5, -3, 33, -243, 32, -4, -3, 100, -123, 353, 345, 235553, -7 })
                , new int[]{-243, -123, -21, -15, -7, -4, -3, -3, -1, 0, 1, 5, 10, 32, 33, 100, 345, 353, 235553}
        );

        System.out.println("火车交错排序法 by TommyLemon：测试通过");
    }

    /**火车交错排序法，对比次数从 0 递增到 length，再从 length 递减到 0，呈等腰三角形（冒泡排序、选择排序是长方形，每回对比次数固定）
     * @param arr
     * @return
     */
    public static int[] trainCrossingSort(int[] arr) {
        long start = System.currentTimeMillis();
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<< trainCrossingSort  start = " + start + "; arr = " + toString(arr));

        int compareCount = 0;

        if (arr != null && arr.length > 1) {
            for (int i = 0; i < arr.length - 1; i++) {  //头对尾 -> 头对头(差一个位，因为不需要相同下标元素（自己和自己）对比)
//                            System.out.println("  <<<<<<<<<<< trainCrossingSort  for i = " + i + " {");

//                int innerSize = i%arr.length; //完全正对时，自己比较自己没有意义 (i + 1)%arr.length;
                //boolean isClosing = i <arr.length;

                for (int j = 0; j <= i; j++) {  //重叠部分车厢，一对一对比
                    compareCount++;
//                                    System.out.println("   <<<<< trainCrossingSort  for j = " + j + " {");

                    int k = j - 1 - i + arr.length;

//                                    System.out.print("    trainCrossingSort i = " + i + "; j = " + j + "; k = " + k + "; compareCount = " + compareCount + " >> ");
//                                            System.out.println("      trainCrossingSort  k >= 0 && k < arr.length && j < arr.length >> ");

//                        if ((j < k && arr[j] > arr[k]) || (j > k && arr[j] < arr[k])) {
                    if (arr[j] > arr[k]) {  //先靠近，后远离，靠近时 (j < k && arr[j] > arr[k])，远离时 (j > k && arr[j] < arr[k])
                        //                        System.out.println("        trainCrossingSort  (j < k && arr[j] > arr[k]) || (j > k && arr[j] < arr[k]) >> swap: arr[" + j + "] = " + arr[j] + ", arr[" + k + "] = " + arr[k]);
                        int temp = arr[j];
                        arr[j] = arr[k];
                        arr[k] = temp;

//                            System.out.println("      trainCrossingSort  swap >> arr = " + toString(arr));
                    }

//                                    System.out.println("   >>>>> trainCrossingSort  for j = " + j + " }\n");
                }

//                            System.out.println(" >>>>>>>>>>>> trainCrossingSort  for i = " + i + " } \n\n");
            }
        }

        long end = System.currentTimeMillis();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> trainCrossingSort end = " + end + "; duration = " + (end - start) + "; compareCount = " + compareCount + "; arr = " + toString(arr) + "\n");

        return arr;
    }

    public static String toString(int[] arr) {
        if (arr == null) {
            return "null";
        }

        String s = "[";
        for (int i = 0; i < arr.length; i++) {
            s += (i <= 0 ? "" : ", ") + arr[i];
        }
        return s + "]";
    }

    public static boolean assertEquals(int[] arr1, int[] arr2) throws RuntimeException {
        if (arr1 == null) {
            //            return arr2 == null;
            if (arr2 == null) {
                return true;
            }
            throw new RuntimeException("arr1 not equals arr2: arr1 == null && arr2 != null");
        }
        if (arr2 == null) {
            //            return false;
            throw new RuntimeException("arr1 not equals arr2: arr1 != null && arr2 == null");

        }
        if (arr1.length != arr2.length) {
            //            return false;
            throw new RuntimeException("arr1 not equals arr2: arr1.length != arr2.length");
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                //                return false;
                throw new RuntimeException("arr1 not equals arr2: arr1[" + i + "] = " + arr1[i] + "; arr2[" + i + "] = " + arr2[i]);
            }
        }

        return true;
    }

}
