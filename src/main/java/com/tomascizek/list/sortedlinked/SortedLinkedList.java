package com.tomascizek.list.sortedlinked;

public class SortedLinkedList<T> {
  
  private int size = 0;
  
  public int size() {
    return this.size;
  }

  public void insert(T apple) {
    this.size++;
  }
}
