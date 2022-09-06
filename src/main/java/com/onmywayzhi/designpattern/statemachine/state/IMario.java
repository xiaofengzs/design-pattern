package com.onmywayzhi.designpattern.statemachine.state;

public interface IMario {
    State getName();
    void obtainMushRoom();
    void obtainCape();
    void obtainFireFlower();
    void meetMonster();
}
