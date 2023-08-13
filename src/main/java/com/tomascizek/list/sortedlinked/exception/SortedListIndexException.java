package com.tomascizek.list.sortedlinked.exception;

public class SortedListIndexException extends IndexOutOfBoundsException {

  private SortedListIndexException(String message) {
    super(message);
  }

  public static SortedListIndexException becauseIndexDoesNotExist(int indexToRemove) {
    return new SortedListIndexException(
        String.format(
            "You are trying to remove element at non existing index '%s'." +
                "You probably want to use contains(...) method before you attempt to delete the item.",
            indexToRemove
        )
    );
  }
}
