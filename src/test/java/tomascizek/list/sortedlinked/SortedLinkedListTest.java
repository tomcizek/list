package tomascizek.list.sortedlinked;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.tomascizek.list.sortedlinked.SortedLinkedList;
import com.tomascizek.list.sortedlinked.exception.SortedListIndexException;
import com.tomascizek.list.sortedlinked.exception.SortedListItemValueException;
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
    var exception = assertThrows(
        SortedListItemValueException.class,
        runnableInsert
    );
    assertEquals(
        "Item inserted into SortedLinkedList was null. " +
            "You probably want to filter out nulls from your data or fix some bug.",
        exception.getMessage()
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
    var exception = assertThrows(
        SortedListItemValueException.class,
        runnableRemove
    );
    assertEquals(
        "You are trying to remove null value from SortedLinkedList, which it cannot contain." +
            "You probably want to filter out nulls from your data or fix some bug.",
        exception.getMessage()
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
    ThrowingRunnable runnableIndexOf = () -> list.indexOf(null);
    var exception = assertThrows(
        SortedListItemValueException.class,
        runnableIndexOf
    );
    assertEquals(
        "You are trying to search null value in SortedLinkedList, which it cannot contain." +
            "You probably want to filter out nulls from your data or fix some bug.",
        exception.getMessage()
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

  @Test
  public void itShouldNotAllowCheckingContainsByNullValue() {
    SortedLinkedList<Integer> list = new SortedLinkedList<>(
        10, 20, 30
    );
    ThrowingRunnable runnableContains = () -> list.contains(null);
    var exception = assertThrows(
        SortedListItemValueException.class,
        runnableContains
    );
    assertEquals(
        "You are trying to check whether SortedLinkedList contains null value, " +
            "which it can never contain." +
            "You probably want to filter out nulls from your data or fix some bug.",
        exception.getMessage()
    );
  }

  @Test
  public void itCanCheckIfContainsFirstValue() {
    SortedLinkedList<Integer> list = new SortedLinkedList<>(
        10, 20, 30
    );
    var actualContains = list.contains(10);
    assertEquals(
        true,
        actualContains
    );
  }

  @Test
  public void itCanCheckIfContainsMiddleValue() {
    SortedLinkedList<Integer> list = new SortedLinkedList<>(
        10, 20, 30
    );
    var actualContains = list.contains(20);
    assertEquals(
        true,
        actualContains
    );
  }

  @Test
  public void itCanCheckIfContainsLastValue() {
    SortedLinkedList<Integer> list = new SortedLinkedList<>(
        10, 20, 30
    );
    var actualContains = list.contains(30);
    assertEquals(
        true,
        actualContains
    );
  }

  @Test
  public void itCanCheckIfContainsNotExistingValue() {
    SortedLinkedList<Integer> list = new SortedLinkedList<>(
        10, 20, 30
    );
    var actualContains = list.contains(40);
    assertEquals(
        false,
        actualContains
    );
  }

  @Test
  public void itCanRemoveFirstElementByIndex() {
    SortedLinkedList<Integer> list = new SortedLinkedList<>(
        10, 20, 30
    );
    list.removeIndex(0);
    assertEquals(
        "[20, 30]",
        list.toString()
    );
    assertEquals(2, list.size());
  }

  @Test
  public void itCanRemoveMiddleElementByIndex() {
    SortedLinkedList<Integer> list = new SortedLinkedList<>(
        10, 20, 30
    );
    list.removeIndex(1);
    assertEquals(
        "[10, 30]",
        list.toString()
    );
    assertEquals(2, list.size());
  }

  @Test
  public void itCanRemoveLastElementByIndex() {
    SortedLinkedList<Integer> list = new SortedLinkedList<>(
        10, 20, 30
    );
    list.removeIndex(2);
    assertEquals(
        "[10, 20]",
        list.toString()
    );
    assertEquals(2, list.size());
  }

  @Test
  public void itShouldNotAllowRemovingByNonExistingIndex() {
    SortedLinkedList<Integer> list = new SortedLinkedList<>(
        10, 20, 30
    );
    ThrowingRunnable runnableRemove = () -> list.removeIndex(3);
    var exception = assertThrows(
        SortedListIndexException.class,
        runnableRemove
    );
    assertEquals(
        "You are trying to remove element at non existing index '3'." +
            "You probably want to use contains(...) method before you attempt to delete the item.",
        exception.getMessage()
    );
  }

  @Test
  public void itShouldNotAllowRemovingByInvalidIndex() {
    SortedLinkedList<Integer> list = new SortedLinkedList<>(
        10, 20, 30
    );
    ThrowingRunnable runnableRemove = () -> list.removeIndex(-1);
    var exception = assertThrows(
        SortedListIndexException.class,
        runnableRemove
    );
    assertEquals(
        "You are trying to remove element at non existing index '-1'." +
            "You probably want to use contains(...) method before you attempt to delete the item.",
        exception.getMessage()
    );
  }
}
