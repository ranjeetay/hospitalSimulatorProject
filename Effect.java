package com.report.hospital;

import java.util.List;
import java.util.Random;

public enum Effect {
    DEATH(List.of()) {
        @Override
        public State apply(State state) {
            return checkDead(state) ? State.DEAD : state;
        }
    },

    SIDE(List.of()) {
        @Override
        public State apply(State state) {
            return checkSideEffect(state) ? State.FEVER : state;
        }
    },

    CURE(List.of()) {
        @Override
        public State apply(State state) {
            return checkCured(state) ? State.HEALTHY : state;
        }
    },
    CURETu(List.of()) {
        @Override
        public State apply(State state) {
            return checkCuredT(state) ? State.FEVER : state;
        }
    };

    private final List<Drug> drugs;

    Effect(List<Drug> drugs) {
        this.drugs = drugs;
    }

    public abstract State apply(State state);

    public boolean checkDead(State state) {
        return deathByDrugMix() || deathByDiabetes(state);
    }

    public  boolean checkSideEffect(State state) {
        return sideEffectByDrugMix(state);
    }

    public  boolean checkCured(State state) {
        return isFeverCured1(state) || isFeverCured2(state)|| isResurrected(state);
    }

    public  boolean checkCuredT(State state) {
        return isTuberculosisCured(state) || isResurrected(state);
    }
    private boolean deathByDiabetes(State state) {
        return !drugs_consumed.contains(Drug.INSULIN) && state == State.DIABETES;
    }

    private boolean deathByDrugMix() {
        return drugs_consumed.contains(Drug.PARACETAMOL) && drugs.contains(Drug.ASPIRIN);
    }
    private  boolean sideEffectByDrugMix(State state) {
        return drugs_consumed.contains(Drug.INSULIN) && drugs.contains(Drug.ANTIBIOTIC) ;//&& state == State.HEALTHY;
    }
    private  boolean isFeverCured1(State state) {
        return drugs_consumed.contains(Drug.ASPIRIN) && state == State.FEVER;
    }
    private  boolean isFeverCured2(State state) {
        return drugs_consumed.contains(Drug.PARACETAMOL) && state == State.FEVER;
    }
    private  boolean isTuberculosisCured(State state) {
        return drugs_consumed.contains(Drug.ANTIBIOTIC) && state == State.TUBERCULOSIS;
    }

    private static boolean isResurrected(State state) {
        return state == State.DEAD && random.nextDouble() <= RESURRECTION_RATIO;
    }

    private static final Random random = new Random();
    private static final double RESURRECTION_RATIO = 0.000001;

    public List<Drug> drugs_consumed;
	public void setDrugs(List<Drug> drugs) {
            drugs_consumed = drugs;
	}
}