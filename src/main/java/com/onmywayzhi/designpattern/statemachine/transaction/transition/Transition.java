package com.onmywayzhi.designpattern.statemachine.transaction.transition;


import com.onmywayzhi.designpattern.statemachine.transaction.action.Action;
import com.onmywayzhi.designpattern.statemachine.transaction.event.Event;
import com.onmywayzhi.designpattern.statemachine.transaction.state.State;

public class Transition {
    private Event on;
    private State to;

    public Transition(Event on, State to) {
        this.on = on;
        this.to = to;
    }

    public State getState() {
        return to;
    }

    public void process(){

    }
}
