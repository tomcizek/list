package com.tomascizek.list.sortedlinked;

public interface SortedList<T extends Comparable<T>> {
  int size();

  void insert(T itemValue);

  void remove(T valueToDelete);

  int indexOf(T searchedValue);

  boolean contains(T searchedValue);

  void removeIndex(int indexToDelete);

  T get(int index);
}
