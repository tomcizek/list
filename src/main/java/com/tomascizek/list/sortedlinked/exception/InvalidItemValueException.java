package com.tomascizek.list.sortedlinked.exception;

public class InvalidItemValueException extends RuntimeException {

  private InvalidItemValueException(String message) {
    super(message);
  }

  public static InvalidItemValueException becauseItemValueIsNull() {
    return new InvalidItemValueException(
        "Item inserted into SortedLinkedList was null. " +
            "You probably want to filter out nulls from your data or fix some bug."
    );
  }

  public static InvalidItemValueException becauseRemovingItemValueIsNull() {
    return new InvalidItemValueException(
        "You are trying to remove null value from SortedLinkedList. " +
            "You probably want to filter out nulls from your data or fix some bug."
    );
  }
}
