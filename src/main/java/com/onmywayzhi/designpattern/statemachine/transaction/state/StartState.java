package com.onmywayzhi.designpattern.statemachine.transaction.state;

import com.onmywayzhi.designpattern.statemachine.transaction.EventQueue;
import com.onmywayzhi.designpattern.statemachine.transaction.action.Action;
import com.onmywayzhi.designpattern.statemachine.transaction.action.KeyExchangeAction;
import com.onmywayzhi.designpattern.statemachine.transaction.event.Event;
import com.onmywayzhi.designpattern.statemachine.transaction.event.ExchangeKeyEvent;
import com.onmywayzhi.designpattern.statemachine.transaction.transition.Transition;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StartState implements State {

    private Map<Event, Transition> transitions;

    private List<Action> entryActions;

    public StartState(EventQueue eventQueue) {
        Event exchangeKeyEvent = new ExchangeKeyEvent();
        this.transitions = new HashMap<Event, Transition>();
        this.transitions.put(exchangeKeyEvent, new Transition(exchangeKeyEvent, new ExchangeKeyState()));
        this.entryActions = Arrays.asList(new KeyExchangeAction(eventQueue));
    }

    @Override
    public State process(Event event) {
        Transition transition = transitions.get(event);
        if (transition == null) {
            return this;
        }
        transition.process();
        return transition.getState();
    }

    public void doEntryAction() throws InterruptedException {
        if (this.entryActions == null || entryActions.isEmpty()) {
            return;
        }
        for (Action action: entryActions) {
            action.process();
        }
    }
}
