package org.vu.pskdemo.jpa.services.grade;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Specializes;

@ApplicationScoped
@Specializes
public class HonorsGradeCalculator extends BaseGradeCalculator {

    @Override
    public double calculateFinalGrade(double assignmentScore, double examScore) {
        System.out.println("Using imitation (@specializes) implementation of grade calculator.");
        double baseGrade = super.calculateFinalGrade(assignmentScore, examScore);
        return baseGrade + 0.1;
    }
}
