package com.report.hospital;

import java.util.List;

public enum Drug {
    ASPIRIN("As"),
    ANTIBIOTIC("An"),
    INSULIN("I"),
    PARACETAMOL("P");

    private final String code;

    Drug(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

//    public static Drug of(String input) {
//        String[] codes = input.split(",");
//        Drug[] drugs = Drug.values();
//        Drug[] selectedDrugs = new Drug[codes.length];
//        int count = 0;
//        for (String code : codes) {
//            if (!code.isEmpty()) {
//                for (Drug drug : drugs) {
//                    if (drug.getCode().equals(code)) {
//                        selectedDrugs[count] = drug;
//                        count++;
//                        break;
//                    }
//                }
//            }
//        }
//        return selectedDrugs[0];
//    }
    public static Drug[] all(String input) {
        String[] codes = input.split(",");
        Drug[] drugs = Drug.values();
        Drug[] selectedDrugs = new Drug[codes.length];
        int count = 0;
        for (String code : codes) {
            if (!code.isEmpty()) {
                for (Drug drug : drugs) {
                    if (drug.getCode().equals(code)) {
                        selectedDrugs[count] = drug;
                        count++;
                    }
                }
            }
        }
        return selectedDrugs;
    }
}