package com.report.hospital;

import java.util.List;

public class Hospital {
    private List<Drug> drugs;

    public Hospital(List<Drug> drugs) {
        this.drugs = drugs;
    }

    public List<Patient> runSimulation(List<Patient> patients) {
        for (Patient patient : patients) {
            patient.treat(drugs);
        }
        return patients;
    }
}