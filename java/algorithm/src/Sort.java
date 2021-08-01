


public class Sort {


    public static void quickSort(int nums[], int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int key = nums[start];
        while (left < right) {
            while (nums[left] < key && left < right) {
                left++;
            }
            while (nums[right] > key && left < right) {
                right--;
            }
            int m = nums[left];
            nums[left] = nums[right];
            nums[right] = m;
        }
        nums[left] = key;
//        for(int i : nums){
//            System.out.print(i+"  ");
//        }
//        System.out.println();
        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);
    }

    public static void shellSort(int nums[]) {
        int step = nums.length / 2;
        while (step > 0) {
            for (int i = step; i < nums.length; i++) {
                int m = nums[i];
                for (int j = i; ; ) {
                    if (nums[j] < nums[j - step]) {
                        nums[j] = nums[j - step];
                    } else {
                        nums[j] = m;
                        break;
                    }
                    j = j - step;
                    if (j < 0 || j - step < 0) {
                        nums[j] = m;
                        break;
                    }
                }

            }
//            for (int i : nums) {
//                System.out.print(i + "  ");
//            }
//            System.out.println();
            step = step / 2;
        }
    }

    public static void toBigHeap(int nums[], int start, int end) {
        if (end < start * 2 + 1) {
            return;
        }
        for (int i = end; (i - 1) / 2 >= start; i--) {
            int head = (i - 1) / 2;
            if (nums[head] < nums[i]) {
                int j = nums[head];
                nums[head] = nums[i];
                nums[i] = j;
            }
        }
    }

    public static void heapSort(int nums[]) {

        for (int i = 0; i < nums.length; i++) {
            toBigHeap(nums, 0, nums.length - i - 1);
            int j = nums[0];
            nums[0] = nums[nums.length - i - 1];
            nums[nums.length - 1 - i] = j;
//            for (int ii : nums) {
//                System.out.print(ii + "  ");
//            }
//            System.out.println();
        }
    }


    //归并排序，需要消耗额外的内存存储另外一组作为过渡
    public static void mergeSort(int nums[], int start, int end, int temp[]) {
        if (start >= end) {
            return;
        }
        mergeSort(nums, start, (start + end) / 2, temp);
        mergeSort(nums, (start + end) / 2 + 1, end, temp);
        int mid = (start + end) / 2 + 1;
        int a= start;
        int left = start;
        int right = mid;
        while (left < mid && right <= end) {
            if (nums[left] > nums[right]) {
                temp[start] = nums[right];
                right++;
            } else {
                temp[start] = nums[left];
                left++;
            }
            start++;
        }
        while (left < mid ) {
            temp[start] = nums[left];
            start++;
            left++;
        }
        while (right <= end) {
            temp[start] = nums[right];
            start++;
            right++;
        }

        for(int i =a ;i<=end;i++){
            nums[i]=temp[i];
        }
//        for (int ii : temp) {
//            System.out.print(ii + "  ");
//        }
//        System.out.println();

    }


    public static void main(String[] args) {
        int nums[] = new int[]{5, 8, 3, 25, 1, 9, 6};

        //quickSort(nums, 0, nums.length - 1);
//        shellSort(nums);
        int temp[] = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        //heapSort(nums);
        for (int i : temp) {
            System.out.println(i);
        }
    }


}
