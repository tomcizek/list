package com.tomascizek.list.sortedlinked;

import com.tomascizek.list.sortedlinked.exception.SortedListIndexException;
import com.tomascizek.list.sortedlinked.exception.SortedListItemValueException;
import java.util.Arrays;
import java.util.List;

public class SortedLinkedList<T extends Comparable<T>> implements SortedList<T> {

  private ListItem firstItem = null;
  private int size = 0;

  public SortedLinkedList() {
  }

  public SortedLinkedList(List<T> itemValues) {
    itemValues.forEach(this::insert);
  }

  public SortedLinkedList(T... itemValues) {
    Arrays.stream(itemValues).forEach(this::insert);
  }


  @Override
  public int size() {
    return this.size;
  }

  @Override
  public void insert(T itemValue) {

    if (itemValue == null) {
      throw SortedListItemValueException.becauseItemValueIsNull();
    }

    this.size++;

    ListItem newListItem = new ListItem(itemValue);

    if (this.firstItem == null || this.firstItem.compareTo(newListItem) > 0) {
      newListItem.next = this.firstItem;
      this.firstItem = newListItem;
      return;
    }

    var currentItem = this.firstItem;
    ListItem previousItem = null;

    while (currentItem != null && currentItem.compareTo(newListItem) <= 0) {
      previousItem = currentItem;
      currentItem = currentItem.next;
    }

    newListItem.next = currentItem;
    if (previousItem != null) {
      previousItem.next = newListItem;
    }
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("[");
    var current = this.firstItem;

    while (current != null) {
      result.append(current.data);
      current = current.next;
      if (current != null) {
        result.append(", ");
      }
    }

    result.append("]");
    return result.toString();
  }

  @Override
  public void remove(T valueToDelete) {
    if (valueToDelete == null) {
      throw SortedListItemValueException.becauseRemovingItemValueIsNull();
    }

    var currentItem = this.firstItem;
    ListItem previousItem = null;

    while (currentItem != null && currentItem.data.compareTo(valueToDelete) != 0) {
      previousItem = currentItem;
      currentItem = currentItem.next;
    }

    if (currentItem == null) {
      return;
    }

    if (previousItem == null) {
      this.firstItem = currentItem.next;
    } else {
      previousItem.next = currentItem.next;
    }

    this.size--;
  }

  @Override
  public int indexOf(T searchedValue) {
    if (searchedValue == null) {
      throw SortedListItemValueException.becauseSearchItemValueIsNull();
    }

    var currentItem = this.firstItem;
    int index = 0;

    while (currentItem != null && currentItem.data.compareTo(searchedValue) != 0) {
      currentItem = currentItem.next;
      index++;
    }

    if (currentItem == null) {
      return -1;
    }

    return index;
  }

  @Override
  public boolean contains(T searchedValue) {
    if (searchedValue == null) {
      throw SortedListItemValueException.becauseContainsItemValueIsNull();
    }
    return this.indexOf(searchedValue) != -1;
  }

  @Override
  public void removeIndex(int indexToDelete) {
    if (indexToDelete < 0 || indexToDelete >= this.size) {
      throw SortedListIndexException.becauseIndexToRemoveDoesNotExist(indexToDelete, this.size);
    }

    var currentItem = this.firstItem;
    ListItem previousItem = null;
    int currentIndex = 0;

    while (currentIndex != indexToDelete) {
      previousItem = currentItem;
      currentItem = currentItem.next;
      currentIndex++;
    }

    if (previousItem == null) {
      this.firstItem = currentItem.next;
    } else {
      previousItem.next = currentItem.next;
    }

    this.size--;
  }

  @Override
  public T get(int index) {
    if (index < 0 || index >= this.size) {
      throw SortedListIndexException.becauseIndexToGetDoesNotExist(index, this.size);
    }

    var currentItem = this.firstItem;
    int currentIndex = 0;

    while (currentItem != null) {
      if (currentIndex == index) {
        return currentItem.data;
      }
      currentItem = currentItem.next;
      currentIndex++;
    }

    return null;
  }

  private class ListItem implements Comparable<ListItem> {

    T data;
    ListItem next;

    public ListItem(T insertion) {
      this.data = insertion;
      this.next = null;
    }

    @Override
    public int compareTo(ListItem comparedItem) {
      return this.data.compareTo(comparedItem.data);
    }

    @Override
    public String toString() {
      return this.data.toString();
    }
  }

}
