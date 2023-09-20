package com.onmywayzhi.designpattern.statemachine.transaction.action;

public interface Action {
    void process() throws InterruptedException;
}
