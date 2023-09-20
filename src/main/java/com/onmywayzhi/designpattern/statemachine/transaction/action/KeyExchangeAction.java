package com.onmywayzhi.designpattern.statemachine.transaction.action;

import com.onmywayzhi.designpattern.statemachine.transaction.EventQueue;
import com.onmywayzhi.designpattern.statemachine.transaction.TransactionStateMachine;
import com.onmywayzhi.designpattern.statemachine.transaction.event.ExchangeKeyEvent;

public class KeyExchangeAction implements Action{

    private TransactionStateMachine stateMachine;

    private EventQueue events;

    public KeyExchangeAction(EventQueue eventQueue) {
        events = eventQueue;
    }

    @Override
    public void process() throws InterruptedException {
        events.putEvent(new ExchangeKeyEvent());
    }
}
