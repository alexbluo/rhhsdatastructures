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

  public static void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] > arr[j]) {
          swap(arr, i, j);
        }
      }
    }
  }

  public static void selectionSort(int[] arr) {
    // One by one move boundary of unsorted subarray
    for (int i = 0; i < arr.length - 1; i++) {
      // Find the minimum element in unsorted array
      int min_idx = i;
      for (int j = i + 1; j < arr.length; j++)
        if (arr[j] < arr[min_idx])
          min_idx = j;

      int temp = arr[min_idx];
      arr[min_idx] = arr[i];
      arr[i] = temp;
    }
  }

  public static void mergeSort(int[] arr, int l, int r) {
    if (l < r) {
      int m = l + (r - l) / 2;

      mergeSort(arr, l, m);
      mergeSort(arr, m + 1, r);

      merge(arr, l, m, r);
    }
  }

  private static void merge(int arr[], int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;

    int L[] = new int[n1];
    int R[] = new int[n2];

    for (int i = 0; i < n1; ++i)
      L[i] = arr[l + i];
    for (int j = 0; j < n2; ++j)
      R[j] = arr[m + 1 + j];

    int i = 0, j = 0;

    int k = l;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        arr[k] = L[i];
        i++;
      } else {
        arr[k] = R[j];
        j++;
      }
      k++;
    }

    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }

    while (j < n2) {
      arr[k] = R[j];
      j++;
      k++;
    }
  }

  public static void quickSort(int[] arr, int l, int r) {
    if (l < r) {
      int i = partition(arr, l, r);

      quickSort(arr, l, i - 1);
      quickSort(arr, i + 1, r);
    }
  }

  private static int partition(int arr[], int l, int r) {
    int cur = l - 1;

    for (int i = l; i < r; i++) {
      if (arr[i] < arr[r]) {
        cur++;
        swap(arr, cur, i);
      }
    }

    swap(arr, cur + 1, r);

    return cur + 1;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void heapSort(int[] arr) {

  }

  private static void print(int[] arr) {
    for (Integer i : arr) {
      System.out.print(i + ", ");
    }
    System.out.println("");
  }

}