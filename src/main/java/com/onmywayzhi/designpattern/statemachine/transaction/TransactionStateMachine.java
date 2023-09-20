package com.onmywayzhi.designpattern.statemachine.transaction;

import com.onmywayzhi.designpattern.statemachine.transaction.event.Event;
import com.onmywayzhi.designpattern.statemachine.transaction.event.StartEvent;
import com.onmywayzhi.designpattern.statemachine.transaction.state.InitState;
import com.onmywayzhi.designpattern.statemachine.transaction.state.State;
import com.onmywayzhi.designpattern.statemachine.transaction.state.StopState;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

@Component
public class TransactionStateMachine implements Runnable {

    private State initState;
    private State currentState;
    private State finalState;

    private EventQueue events;

    public TransactionStateMachine(EventQueue eventQueue) {
        this.initState = new InitState();
        this.currentState = new InitState();
        this.finalState = new StopState();
        this.events = eventQueue;
    }

    @Override
    public void run() {
        try {
            while(true) {
                Event event = events.takeEvent();
                State targetState = currentState.process(event);
                if(targetState == currentState) {
                    continue;
                }
                this.transit(targetState);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void transit(State targetState) throws InterruptedException {
        this.currentState = targetState;
        this.currentState.doEntryAction();
    }
}
