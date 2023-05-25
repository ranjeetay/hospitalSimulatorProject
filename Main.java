package com.report.hospital;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Main extends Exception {

    static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        report(args);
    }
    private static String buildReport(List<Patient> patients) {
        return Arrays.stream(State.values())
                .map(stateToPoint -> stateToPoint.getCode() + ":" + patients.stream().filter(patient ->
                        stateToPoint == patient.state).count())
                .collect(Collectors.joining(","));
    }

    public static String report(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Needs exactly two arguments: list of states and list of drugs");
        }

        List<Patient> patients = Arrays.stream(args[0].split(","))
                .map(State::of)
                .map(Patient::new)
                .collect(Collectors.toList());

        List<Drug> drugs = Arrays.asList(Drug.all(args[1]));

        List<Patient> treatedPatients = new Hospital(drugs).runSimulation(patients);

        String report = buildReport(treatedPatients);

        log.info(report);

        return report;
    }
}




