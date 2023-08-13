package tomascizek.list.sortedlinked;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.tomascizek.list.sortedlinked.SortedLinkedList;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

public class SortedLinkedListTest {

  @Test
  public void itCanCreateEmptyList() {
    SortedLinkedList<String> list = new SortedLinkedList<>();
    assertEquals(0, list.size());
  }

  @Test
  public void itCanInsertSingleElement() {
    SortedLinkedList<String> list = new SortedLinkedList<>();
    list.insert("apple");
    assertEquals(1, list.size());
    assertEquals("[apple]", list.toString());
  }

  @Test
  public void itShouldNOtAllowNullValues() {
    SortedLinkedList<String> list = new SortedLinkedList<>();
    ThrowingRunnable runnableInsert = () -> list.insert(null);
    assertThrows(
        Exception.class,
        runnableInsert
    );
  }

  @Test
  public void itShouldKeepTwoElementsInOrder() {
    SortedLinkedList<String> list = new SortedLinkedList<>();
    list.insert("banana");
    list.insert("apple");
    assertEquals("[apple, banana]", list.toString());
  }

  @Test
  public void itShouldInsertAtStartCorrectly() {
    SortedLinkedList<Integer> list = new SortedLinkedList<>();
    list.insert(30);
    list.insert(20);
    list.insert(10);
    assertEquals("[10, 20, 30]", list.toString());
  }

  @Test
  public void itShouldInsertInTheMiddleCorrectly() {
    SortedLinkedList<Integer> list = new SortedLinkedList<>();
    list.insert(30);
    list.insert(10);
    list.insert(20);
    assertEquals("[10, 20, 30]", list.toString());
  }

  @Test
  public void itShouldInsertAtEndCorrectly() {
    SortedLinkedList<Integer> list = new SortedLinkedList<>();
    list.insert(20);
    list.insert(10);
    list.insert(30);
    assertEquals("[10, 20, 30]", list.toString());
  }

  @Test
  public void itShouldKeepSeveralElementsInOrder() {
    SortedLinkedList<String> list = new SortedLinkedList<>();
    list.insert("something5");
    list.insert("something2");
    list.insert("something3");
    list.insert("something1");
    list.insert("something6");
    list.insert("something4");
    assertEquals(
        "[something1, something2, something3, something4, something5, something6]",
        list.toString()
    );
  }

}
