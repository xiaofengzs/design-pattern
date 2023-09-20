package com.onmywayzhi.designpattern.statemachine.transaction.state;

import com.onmywayzhi.designpattern.statemachine.transaction.event.Event;

public interface State {
    State process(Event event);
    void doEntryAction() throws InterruptedException;
}
