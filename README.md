# Clojure JSON Parser
This project demonstrates how to create a JSON parser using the Leiningen build tool.

## Input Format
The input file represents the students and their grades in a given course. The format should be in the following JSON format:
```
{"title" : "CSCI 3055U",
 "students" : [{"name": "Mary", "grade": 89.3},
               {"name": "Joe", "grade": 80.4},
               {"name": "Jill", "grade": 88.0}]}
```

## Expect Output
The statistics of the input course will be printed after the program has been run.
```
CSCI 3055U
Range: 80.40 to 89.30
Average: 85.90
Best student: Mary
```
