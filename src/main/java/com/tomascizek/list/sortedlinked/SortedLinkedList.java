package com.tomascizek.list.sortedlinked;

import com.tomascizek.list.sortedlinked.exception.InvalidItemValueException;
import java.util.Arrays;
import java.util.List;

public class SortedLinkedList<T extends Comparable<T>> {

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


  public int size() {
    return this.size;
  }

  public void insert(T itemValue) {

    if (itemValue == null) {
      throw InvalidItemValueException.becauseItemValueIsNull();
    }
    
    this.size++;

    ListItem<T> newListItem = new ListItem<>(itemValue);

    if (this.firstItem == null || this.firstItem.compareTo(newListItem) > 0) {
      newListItem.next = this.firstItem;
      this.firstItem = newListItem;
      return;
    }

    var currentItem = this.firstItem;
    ListItem<T> previousItem = null;

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
    if (this.firstItem == null) {
      return "[]";
    }
    return "[" + this.firstItem + "]";
  }

  private class ListItem<T extends Comparable<T>> implements Comparable<ListItem<T>> {
    T data;
    ListItem<T> next;

    public ListItem(T insertion) {
      this.data = insertion;
      this.next = null;
    }

    @Override
    public int compareTo(ListItem<T> comparedItem) {
      return this.data.compareTo(comparedItem.data);
    }

    @Override
    public String toString() {
      if (this.next != null) {
        return this.data.toString() + ", " + this.next.toString();
      }
      return this.data.toString();
    }
  }

}
