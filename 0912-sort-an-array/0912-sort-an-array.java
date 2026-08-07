class Solution {
    public int[] sortArray(int[] arr) {
         int n = arr.length;

        // Step 1: Build Max Heap
        for(int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Move maximum to the end
        for(int i = n - 1; i > 0; i--) {
            
            // Swap root with last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify remaining part
            heapify(arr, i, 0);
        }

        return arr;
    }

    public void heapify(int[] arr, int n, int i) {
        
        int largest = i;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if(right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if(largest != i) {
            
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }
}