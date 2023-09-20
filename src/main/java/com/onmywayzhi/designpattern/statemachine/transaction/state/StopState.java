package com.onmywayzhi.designpattern.statemachine.transaction.state;

import com.onmywayzhi.designpattern.statemachine.transaction.event.Event;

public class StopState implements State{
    @Override
    public State process(Event event) {

        return null;
    }

    @Override
    public void doEntryAction() throws InterruptedException {

    }
}
