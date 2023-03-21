public class Sort {
  public static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int key = arr[i];
      int j = i - 1;

      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j = j - 1;
      }
      arr[j + 1] = key;
    }
  }

  // public static void bubbleSort(int[] arr) {

  // }

  // public static void selectionSort(int[] arr) {

  // }

  // public static void mergeSort(int[] arr) {

  // }

  // public static void quickSort(int[] arr) {

  // }

  // public static void heapSort(int[] arr) {

  // }
}