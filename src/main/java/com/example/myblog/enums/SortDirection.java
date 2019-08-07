package com.example.myblog.enums;

import java.util.Locale;
import java.util.Optional;

public enum SortDirection {

    ASC, DESC;

    public boolean isAscending() {
        return this.equals(ASC);
    }

    public boolean isDescending() {
        return this.equals(DESC);
    }

    public static SortDirection fromString(String value) {

        try {
            return SortDirection.valueOf(value.toUpperCase(Locale.US));
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format(
                    "Invalid value '%s' for orders given! Has to be either 'desc' or 'asc' (case insensitive).", value), e);
        }
    }

    public static Optional<SortDirection> fromOptionalString(String value) {

        try {
            return Optional.of(fromString(value));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }
}