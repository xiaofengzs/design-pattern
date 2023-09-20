package com.onmywayzhi.designpattern.statemachine.transaction.event;

import java.util.Objects;

public class StartEvent implements Event{

    private String name;

    public StartEvent() {
        this.name = "START";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StartEvent that = (StartEvent) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
