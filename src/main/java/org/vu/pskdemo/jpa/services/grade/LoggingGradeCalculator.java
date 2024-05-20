package org.vu.pskdemo.jpa.services.grade;

import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

@Decorator
@Dependent
public class LoggingGradeCalculator implements GradeCalculator {

    @Inject
    @Delegate
    private GradeCalculator gradeCalculator;

    @Override
    public double calculateFinalGrade(double assignmentScore, double examScore) {
        System.out.println("Logging: Calculating final grade. Assignment score: " + assignmentScore + ", Exam score: " + examScore);
        double finalGrade = gradeCalculator.calculateFinalGrade(assignmentScore, examScore);
        System.out.println("Logging: Final grade calculated: " + finalGrade);
        return finalGrade;
    }
}
