package com.onmywayzhi.designpattern.statemachine.transaction;

import com.onmywayzhi.designpattern.statemachine.transaction.event.Event;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

@Component
public class EventQueue {
    private BlockingDeque<Event> events;

    public EventQueue(BlockingDeque<Event> events) {
        this.events = new LinkedBlockingDeque<Event>();
    }

    public void putEvent(Event event) throws InterruptedException {
        events.put(event);
    }

    public Event takeEvent() throws InterruptedException {
        return events.take();
    }
}
