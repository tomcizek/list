package com.tomascizek.list.sortedlinked.exception;

public class SortedListIndexException extends IndexOutOfBoundsException {

  private SortedListIndexException(String message) {
    super(message);
  }

  public static SortedListIndexException becauseIndexToRemoveDoesNotExist(int indexToRemove,
                                                                          int size) {
    return new SortedListIndexException(
        String.format(
            "You are trying to remove item at non existing index '%s'. Available index range: 0-%s\n" +
                "You probably want to use contains(...) method before you attempt to remove the item.",
            indexToRemove,
            size - 1
        )
    );
  }

  public static SortedListIndexException becauseIndexToGetDoesNotExist(int indexToRemove,
                                                                       int size) {
    return new SortedListIndexException(
        String.format(
            "You are trying to get item at non existing index '%s'. Available index range: 0-%s\n" +
                "You probably want to use contains(...) method before you attempt to get the item.",
            indexToRemove,
            size - 1
        )
    );
  }
}
