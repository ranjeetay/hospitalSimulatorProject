package com.report.hospital;

public enum State {
    FEVER("F"), HEALTHY("H"), DIABETES("D"), TUBERCULOSIS("T"), DEAD("X");

    private final String code;

    State(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static State of(String input) {
        String[] codes = input.split(",");
        State[] states = State.values();
        State[] selectedStates = new State[codes.length];
        int index = 0;
        for (String code : codes) {
            if (!code.isEmpty()) {
                for (State state : states) {
                    if (state.getCode().equals(code)) {
                        selectedStates[index] = state;
                        index++;
                        break;
                    }
                }
            }
        }
        return selectedStates[0];
    }
}