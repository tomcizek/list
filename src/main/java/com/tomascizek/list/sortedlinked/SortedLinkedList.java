package com.tomascizek.list.sortedlinked;

public class SortedLinkedList<T extends Comparable<T>> {

  private ListItem firstItem = null;
  private int size = 0;

  public int size() {
    return this.size;
  }

  public void insert(T insertion) {

    this.size++;

    ListItem<T> newListItem = new ListItem<>(insertion);

    if(this.firstItem == null) {
      this.firstItem = newListItem;
      return;
    }
    
    if(this.firstItem.compareTo(newListItem) > 0) {
      newListItem.next = this.firstItem;
      this.firstItem = newListItem;
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
