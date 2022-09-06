package com.onmywayzhi.designpattern.statemachine.state;

public enum State {
    SMALL(0),
    SUPER(1),
    FIRE(2),
    CAPE(3);

    private int value;

    private State(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public boolean equals(State state) {
        if (state == null) {
            return false;
        }

        return this.value == state.value;
    }

}
