import java.util.ArrayList;

public class Heap {
  private ArrayList<Integer> heap;

  public Heap() {
    heap = new ArrayList<>();
  }

  private int p(int pos) {
    return (pos - 1) / 2;
  }

  private int l(int pos) {
    return (2 * pos) + 1;
  }

  private int r(int pos) {
    return (2 * pos) + 2;
  }

  private boolean leaf(int pos) {
    if (pos > (heap.size() / 2) && pos <= heap.size())
      return true;

    return false;
  }

  public void add(int num) {
    heap.add(num);

    int cur = heap.size() - 1;

    while (heap.get(cur) > heap.get(p(cur))) {
      swap(cur, p(cur));
      cur = p(cur);
    }
  }

  public int pop() {
    int top = heap.get(0);
    swap(0, heap.size());
    heapify(0);
    
    return top;
  }

  private void heapify(int pos) {
    if (leaf(pos))
      return;

    int max = pos;

    if (heap.get(l(pos)) > heap.get(max)) {
      max = l(pos);
    }

    if (heap.get(r(pos)) > heap.get(max)) {
      max = r(pos);
    }

    swap(pos, max);
    heapify(max);
  }

  private void swap(int one, int two) {
    int temp = heap.get(one);
    heap.set(one, heap.get(two));
    heap.set(two, temp);
  }
}
