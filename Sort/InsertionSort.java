public class InsertionSort {
    public static void sort(int a[]){
        int i;
        int key;
        int j;

        for(i =1; i<a.length;i++){
            key = a[i];
            j = i;
            while(a[j-1]>key && j>=1){
                a[j] = a[j-1];
                j--;
            }
            a[j] = key;
        }

        printArray(a);
    }

    public static void printArray(int a[]){
        for (int i : a) {
            System.out.print(i+", ");
        }
        System.out.print("\n");
    }
}

