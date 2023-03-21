import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
  public static void main(String[] args) {
    ArrayList<Long> timeOrdered = new ArrayList<>();
    ArrayList<Long> timeReversed = new ArrayList<>();
    ArrayList<Long> timeMid = new ArrayList<>();
    ArrayList<Long> timeRandom = new ArrayList<>();
    ArrayList<Long> total = new ArrayList<>();

    int[] arrOrdered = new int[10000];
    int[] arrReversed = new int[10000];
    int[] arrMid = new int[10000];
    int[] arrRandom = new int[10000];

    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 10000; j++) {
        arrOrdered[j] = j;
        arrReversed[j] = 10000 - 1 - j;

        int randomPos = (int) (Math.random() * 1000 + 4500);

        if (j == randomPos) {
          arrMid[j] = 50000;
        } else {
          arrMid[j] = j;
        }

        int randomInt = (int) (Math.random() * 100);
        arrRandom[j] = randomInt;
      }

      long base = System.currentTimeMillis();
      Sort.insertionSort(arrOrdered);
      timeOrdered.add(System.currentTimeMillis() - base);

      base = System.currentTimeMillis();
      Sort.insertionSort(arrReversed);
      timeReversed.add(System.currentTimeMillis() - base);

      base = System.currentTimeMillis();
      Sort.insertionSort(arrMid);
      timeMid.add(System.currentTimeMillis() - base);

      base = System.currentTimeMillis();
      Sort.insertionSort(arrRandom);
      timeRandom.add(System.currentTimeMillis() - base);

      total.add(timeOrdered.get(i) + timeReversed.get(i) + timeMid.get(i) + timeRandom.get(i));
    }

    try (
        FileWriter writer = new FileWriter("runtimes.csv");
        BufferedWriter csv = new BufferedWriter(writer)) {
      csv.append(
          "\"Ordered\",\"Reversed\",\"Middle Random\",\"All Random\",\"Total\"\n");

      for (int i = 0; i < 100; i++) {
        csv.append(String.valueOf(timeOrdered.get(i))).append(",").append(String.valueOf(timeReversed.get(i)))
            .append(",").append(String.valueOf(timeMid.get(i))).append(",").append(String.valueOf(timeRandom.get(i)))
            .append(",").append(String.valueOf(total.get(i))).append("\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
