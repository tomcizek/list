package tomascizek.list.sortedlinked;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.tomascizek.list.sortedlinked.SortedLinkedList;
import com.tomascizek.list.sortedlinked.exception.InvalidItemValueException;
import java.util.List;
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
        "Item inserted into SortedLinkedList was null. " +
            "You probably want to filter out nulls from your data or fix some bug.",
        InvalidItemValueException.class,
        runnableInsert
    );
  }

  @Test
  public void itShouldKeepTwoElementsInOrder() {
    SortedLinkedList<String> list = new SortedLinkedList<>();
    list.insert("banana");
    list.insert("apple");
    assertEquals("[apple, banana]", list.toString());
    assertEquals(2, list.size());
  }

  @Test
  public void itShouldInsertAtStartCorrectly() {
    SortedLinkedList<Integer> list = new SortedLinkedList<>();
    list.insert(30);
    list.insert(20);
    list.insert(10);
    assertEquals("[10, 20, 30]", list.toString());
    assertEquals(3, list.size());
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
    assertEquals(6, list.size());
  }

  @Test
  public void itCanBeCreatedFromList() {
    SortedLinkedList<Integer> list = new SortedLinkedList<>(
        List.of(20, 10, 30)
    );
    assertEquals(
        "[10, 20, 30]",
        list.toString()
    );
  }

  @Test
  public void itCanBeCreatedFromVariadicParameters() {
    SortedLinkedList<Integer> list = new SortedLinkedList<>(
        20, 10, 30
    );
    assertEquals(
        "[10, 20, 30]",
        list.toString()
    );
  }

  @Test
  public void itShouldNotAllowRemoveByNullValue() {
    SortedLinkedList<Integer> list = new SortedLinkedList<>(
        10, 20, 30
    );
    ThrowingRunnable runnableRemove = () -> list.remove(null);
    assertThrows(
        "You are trying to remove null value from SortedLinkedList, which it cannot contain." +
            "You probably want to filter out nulls from your data or fix some bug.",
        InvalidItemValueException.class,
        runnableRemove
    );
  }

  @Test
  public void itCanRemoveFirstElementByValue() {
    SortedLinkedList<Integer> list = new SortedLinkedList<>(
        10, 20, 30
    );
    list.remove(10);
    assertEquals(
        "[20, 30]",
        list.toString()
    );
    assertEquals(2, list.size());
  }

  @Test
  public void itCanRemoveMiddleElementByValue() {
    SortedLinkedList<Integer> list = new SortedLinkedList<>(
        10, 20, 30
    );
    list.remove(20);
    assertEquals(
        "[10, 30]",
        list.toString()
    );
    assertEquals(2, list.size());
  }

  @Test
  public void itCanRemoveLastElementByValue() {
    SortedLinkedList<Integer> list = new SortedLinkedList<>(
        10, 20, 30
    );
    list.remove(30);
    assertEquals(
        "[10, 20]",
        list.toString()
    );
    assertEquals(2, list.size());
  }

  @Test
  public void itShouldIgnoreRemovingByNonExistingValue() {
    SortedLinkedList<Integer> list = new SortedLinkedList<>(
        10, 20, 30
    );
    list.remove(40);
    assertEquals(
        "[10, 20, 30]",
        list.toString()
    );
    assertEquals(3, list.size());
  }

  @Test
  public void itShouldNotAllowFindingIndexByNullValue() {
    SortedLinkedList<Integer> list = new SortedLinkedList<>(
        10, 20, 30
    );
    ThrowingRunnable runnableRemove = () -> list.indexOf(null);
    assertThrows(
        "You are trying to search null value in SortedLinkedList, which it cannot contain." +
            "You probably want to filter out nulls from your data or fix some bug.",
        InvalidItemValueException.class,
        runnableRemove
    );
  }

  @Test
  public void itCanFindIndexOfFirstValue() {
    SortedLinkedList<Integer> list = new SortedLinkedList<>(
        10, 20, 30
    );
    var actualIndex = list.indexOf(10);
    assertEquals(
        0,
        actualIndex
    );
  }

  @Test
  public void itCanFindIndexOfMiddleValue() {
    SortedLinkedList<Integer> list = new SortedLinkedList<>(
        10, 20, 30
    );
    var actualIndex = list.indexOf(20);
    assertEquals(
        1,
        actualIndex
    );
  }

  @Test
  public void itCanFindIndexOfLastValue() {
    SortedLinkedList<Integer> list = new SortedLinkedList<>(
        10, 20, 30
    );
    var actualIndex = list.indexOf(30);
    assertEquals(
        2,
        actualIndex
    );
  }

}
