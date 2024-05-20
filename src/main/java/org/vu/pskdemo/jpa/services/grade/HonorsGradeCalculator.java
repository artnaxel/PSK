package org.vu.pskdemo.jpa.services.grade;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Specializes;

@ApplicationScoped
@Specializes
public class HonorsGradeCalculator extends BaseGradeCalculator {

    @Override
    public double calculateFinalGrade(double assignmentScore, double examScore) {
        double grade = super.calculateFinalGrade(assignmentScore, examScore) + 0.5;
        System.out.println("Using imitation (@specializes) implementation of grade calculator. Honors grade: " + grade);
        return grade;
    }
}
