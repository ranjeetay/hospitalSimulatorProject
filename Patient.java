package com.report.hospital;

import java.util.List;

public class Patient {
    public State state;
    public boolean isTreated = false;

    public Patient(State state) {
        this.state = state;
    }

    public void treat(List<Drug> drugs) {
        for (Effect effect : Effect.values()) {
            effect.setDrugs(drugs);
            if (!isTreated) {
                State newState = effect.apply(state);
                if (newState != state) {
                    state = newState;
                    isTreated = true;
                    break;
                }
            }
        }
        isTreated = false;
    }
}