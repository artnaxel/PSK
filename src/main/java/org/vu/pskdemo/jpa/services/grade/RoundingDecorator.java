package org.vu.pskdemo.jpa.services.grade;

import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import org.vu.pskdemo.jpa.qualifiers.RoundGrade;

@Decorator
@Dependent
@RoundGrade
public class RoundingDecorator implements GradeCalculator {

    @Inject
    @Delegate
    @RoundGrade
    private GradeCalculator gradeCalculator;

    @Override
    public double calculateFinalGrade(double assignmentScore, double examScore) {
        double finalGrade = gradeCalculator.calculateFinalGrade(assignmentScore, examScore);
        double roundedGrade = Math.round(finalGrade);
        System.out.println("Using @Decorator implementation of grade calculator.");
        System.out.println("Rounding: Final grade before rounding: " + finalGrade + ", after rounding: " + roundedGrade);
        return roundedGrade;
    }
}
