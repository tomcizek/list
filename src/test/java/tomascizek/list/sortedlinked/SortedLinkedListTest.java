package tomascizek.list.sortedlinked;

import static org.junit.Assert.assertEquals;

import com.tomascizek.list.sortedlinked.SortedLinkedList;
import org.junit.Test;

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
  }
}
