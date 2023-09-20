//package com.onmywayzhi.designpattern.statemachine.transaction.state;
//
//import com.onmywayzhi.designpattern.statemachine.transaction.action.Action;
//import com.onmywayzhi.designpattern.statemachine.transaction.event.Event;
//import com.onmywayzhi.designpattern.statemachine.transaction.event.StartEvent;
//import com.onmywayzhi.designpattern.statemachine.transaction.transition.Transition;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class InitState implements State{
//    private Map<Event, Transition> transitions;
//
//    private List<Action> entryActions;
//
//    public InitState() {
//        Event startEvent = new StartEvent();
//        this.transitions = new HashMap<>();
//        this.transitions.put(startEvent, new Transition(startEvent, new StartState()));
//    }
//
//    @Override
//    public State process(Event event) {
//        Transition transition = transitions.get(event);
//        if (transition == null) {
//            return this;
//        }
//        transition.process();
//        return transition.getState();
//    }
//
//    @Override
//    public void doEntryAction() throws InterruptedException {
//        if(this.entryActions == null || this.entryActions.isEmpty()) {
//            return;
//        }
//    }
//}
