


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
                    j=j-step;
                    if(j < 0 ||  j - step < 0){
                        nums[j] =m;
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

    public static void main(String[] args) {
        int nums[] = new int[]{5, 8, 3, 25, 1, 9, 6};
        //quickSort(nums, 0, nums.length - 1);
        shellSort(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }


}
