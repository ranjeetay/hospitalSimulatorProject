# Hospital Simulator
You were asked by a doctor friend to prepare for her a “Hospital simulator”, which can
simulate the future patients’ state, based on their current state and a list of drugs they take.
Patients can have one of these states:
- F: Fever
- H: Healthy
- D: Diabetes
- T: Tuberculosis
- X: Dead

In the “Hospital simulator” drugs are provided to all patients. It is not possible to target a
specific patient. This is the list of available drugs:
- As: Aspirin
- An: Antibiotic
- I: Insulin
- P: Paracetamol

Drugs can change patients’ states. They can cure, cause side effects or even kill a patient if
not properly prescribed.
Drugs effects are described by the following rules:
- Aspirin cures Fever;
- Antibiotic cures Tuberculosis;
- Insulin prevents diabetic subject from dying, does not cure Diabetes;
- If insulin is mixed with antibiotic, healthy people catch Fever;
- Paracetamol cures Fever;
- Paracetamol kills subject if mixed with aspirin;

### Input

Parameter 1
- List of patients' health status codes, separated by a comma. e.g. “D,F,F” means we have 3
  patients, one with diabetes and two with fever.

Parameter 2
- List of drugs codes, separated by a comma, e.g. “As,I” means patients will be treated with
  Aspirin and Insulin.

### Output

The result should be sent to stdout.

It should be a comma separated string with number of patients with a given state, following
the format:

```F:NP,H:NP,D:NP,T:NP,X:NP```

Where:
- F, H, D, T, X are patients’ health status codes;
- NP is a number of patients for a given state;
- E.g. “F:0,H:2,D:0,T:0,X:1” means there are two healthy patients and one that is dead.

### Examples

Example 1
- Input: “F,D,T,T”
- Output: “F:0,H:0,D:0,T:0,X:2” (diabetic patients die without insulin)
- ```$ java -jar hospitalSimulatorProject-1.0-SNAPSHOT.jar "F,D,T,T" "P,An,I"```
- ```F:1,H:0,D:0,T:2,X:1```

Example 2
- Input: “F” “P”
- Output: “F:0,H:1,D:0,T:0,X:0” (paracetamol cures fever)
- ```$java -jar hospitalSimulatorProject-1.0-SNAPSHOT.jar F P```
- ```F:0,H:1,D:0,T:0,X:0```

##### Compiled Output Result ########

### Build the project,please execute the below command #######

mvn clean install

### Jar is created in Target folder,Please execute the below command to validate the output. ####

java -jar hospitalSimulatorProject-1.0-SNAPSHOT.jar "D,D" ""       
May 25, 2023 1:04:49 PM com.report.hospital.Main report

### Input: "D,D" ""
#### output 
INFO: F:0,H:0,D:0,T:0,X:2

java -jar hospitalSimulatorProject-1.0-SNAPSHOT.jar "F" "P"        
May 25, 2023 1:05:00 PM com.report.hospital.Main report

### Input: "F" "P"
#### output 
INFO: F:0,H:1,D:0,T:0,X:0

java -jar hospitalSimulatorProject-1.0-SNAPSHOT.jar "T,F,D"  "An,I"
May 25, 2023 1:05:10 PM com.report.hospital.Main report

### Input: "T,F,D"  "An,I"
#### output 
INFO: F:2,H:0,D:1,T:0,X:0
