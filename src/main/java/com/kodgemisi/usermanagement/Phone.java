package com.kodgemisi.usermanagement;

/**
 * Represents a phone number, never stores a null value. If constructed with a null value stores an empty string.
 */

public class Phone implements CharSequence {


    private final String phoneNumber;

    public Phone(String phoneNumber) {
        if (phoneNumber == null) {
            throw new IllegalArgumentException("Phone number cannot be null!");
        } else if (phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty!");
        } else if (phoneNumber.startsWith("+90") && phoneNumber.length() != 13) {
            throw new IllegalArgumentException("Phone number should be 13-char long");
        } else if (phoneNumber.startsWith("+") && !(phoneNumber.length() >= 5)) {
            throw new IllegalArgumentException("Phone number that starts with '+' should be 5-char long");
        } else if (!phoneNumber.startsWith("+") && !(phoneNumber.equals("911") || phoneNumber.equals("112"))) {
            throw new IllegalArgumentException("Phone number that doesn't start with '+' ");
        }

        this.phoneNumber = phoneNumber;
    }

    public String number() {
        return phoneNumber;
    }

    @Override
    public int length() {
        return phoneNumber.length();
    }

    @Override
    public char charAt(int index) {
        return phoneNumber.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return phoneNumber.subSequence(start, end);
    }

    @Override
    public String toString() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Phone phone = (Phone) o;

        return phoneNumber.equals(phone.phoneNumber);
    }

    @Override
    public int hashCode() {
        return phoneNumber.hashCode();
    }
}
