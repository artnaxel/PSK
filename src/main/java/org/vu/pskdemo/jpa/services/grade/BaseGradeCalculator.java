package org.vu.pskdemo.jpa.services.grade;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BaseGradeCalculator implements GradeCalculator {

    @Override
    public double calculateFinalGrade(double assignmentScore, double examScore) {
        System.out.println("Using default implementation of GradeCalculator.");
        return (assignmentScore * 0.4) + (examScore * 0.6);
    }
}

