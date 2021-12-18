package com.example.demosecurity.constant.common;

public enum SeatStatus {
    AVAILABLE(0),
    NOTAVAILABLE(1);

    private int value;

    SeatStatus(int value) {
        this.value = value;
    }
    public boolean compareValue(int compare) {
        if (compare == this.value) {
            return true;
        } else {
            return false;
        }
    }
}
