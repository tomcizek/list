package com.tomascizek.list.sortedlinked.exception;

public class SortedListItemValueException extends RuntimeException {

  private SortedListItemValueException(String message) {
    super(message);
  }

  public static SortedListItemValueException becauseItemValueIsNull() {
    return new SortedListItemValueException(
        "Item inserted into SortedLinkedList was null. " +
            "You probably want to filter out nulls from your data or fix some bug."
    );
  }

  public static SortedListItemValueException becauseRemovingItemValueIsNull() {
    return new SortedListItemValueException(
        "You are trying to remove null value from SortedLinkedList, which it cannot contain." +
            "You probably want to filter out nulls from your data or fix some bug."
    );
  }

  public static SortedListItemValueException becauseSearchItemValueIsNull() {
    return new SortedListItemValueException(
        "You are trying to search null value in SortedLinkedList, which it cannot contain." +
            "You probably want to filter out nulls from your data or fix some bug."
    );
  }

  public static SortedListItemValueException becauseContainsItemValueIsNull() {
    return new SortedListItemValueException(
        "You are trying to check whether SortedLinkedList contains null value, " +
            "which it can never contain." +
            "You probably want to filter out nulls from your data or fix some bug."
    );
  }

}
