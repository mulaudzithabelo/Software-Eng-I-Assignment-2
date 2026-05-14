# Software-Eng-I-Assignment-2

# Software-Engineering-Assignment2-From-Behavioural-Models-To-Optimised-Implemetation

# Intelligent Submission and Review System

A software engineering assignment (COS730) that translates a behavioural sequence diagram into a working Java system, analyses its design weaknesses, and refactors it into an optimised, maintainable architecture.

## Overview

This repository contains two implementations of an **Intelligent Submission and Review System**:

1. **Baseline** – a direct, faithful translation of the provided sequence diagram, including all redundant interactions and design flaws.
2. **Optimised** – a refactored version that improves cohesion, reduces coupling, centralises decision logic, and introduces interface-based services, while preserving full functional equivalence.

The project demonstrates the full cycle from behavioural modelling to empirical evaluation, following GRASP principles and structured refactoring.

---

## Key Features (Both Versions)

- A researcher submits an artefact.
- The system validates the submission format.
- If invalid, an error is returned; if valid, the artefact is saved.
- Reviewers are automatically selected (with conflict filtering and workload checking).
- Reviewers submit scores.
- A final outcome is determined (**Accept / Request Revision / Reject**).
- The researcher is notified of the outcome.

The **optimised** version additionally offers:

- Thin controller (`SubmissionController` delegates work to specialised services).
- Encapsulated reviewer assignment (`ReviewerAssignmentService`).
- Centralised decision engine (`DecisionRuleEngine` based on a decision table).
- Repository interfaces for persistence.
- Cleaner separation of concerns and higher testability.

---

## Technology Stack

- **Language:** Java (JDK 17+)
- **Build:** No external build tools – plain Java with manual compilation (see below)
- **Testing:** Benchmarks via `BenchmarkApp`
- **Logging:** Custom `Logger` class (can be toggled on/off for traces)

---

## Project Structure
```
src/
├── task1baseline/
│   ├── App.java
│   ├── BaselineSequenceDiagram.png
│   ├── BenchmarkApp.java
│   ├── Database.java
│   ├── EvaluationManager.java
│   ├── Logger.java
│   ├── NotificationService.java
│   ├── Researcher.java
│   ├── Reviewer.java
│   ├── ReviewerManager.java
│   ├── SubmissionController.java
│   ├── SubmissionData.java
│   ├── UI.java
│   └── Validator.java
│
├── task4architecture/
│   └── OptimisedSequenceDiagram.PNG
│
└── task5optimised/
    ├── App.java
    ├── BenchmarkApp.java
    ├── ConsoleNotificationService.java
    ├── DecisionRuleEngine.java
    ├── DefaultReviewerAssignmentService.java
    ├── EvaluationService.java
    ├── FormatSubmissionValidator.java
    ├── InMemoryReviewRepository.java
    ├── InMemorySubmissionRepository.java
    ├── Logger.java
    ├── NotificationService.java
    ├── Outcome.java
    ├── Researcher.java
    ├── Reviewer.java
    ├── ReviewerAssignmentService.java
    ├── ReviewRepository.java
    ├── SubmissionController.java
    ├── SubmissionData.java
    ├── SubmissionRepository.java
    ├── SubmissionValidator.java
    ├── TableDecisionRuleEngine.java
    └── UI.java
```
