package org.vu.pskdemo.jpa.usecases;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.vu.pskdemo.jpa.qualifiers.RoundGrade;
import org.vu.pskdemo.jpa.services.grade.GradeCalculator;

@Named
@RequestScoped
@Getter
@Setter
public class CalculateStudentGrade {

    @Inject
    @RoundGrade
    private GradeCalculator gradeCalculator;


    private double assignmentScore;
    private double examScore;
    private double finalGrade;
    private String gradeType;

    public void calculateFinalGrade() {
        finalGrade = gradeCalculator.calculateFinalGrade(assignmentScore, examScore);
    }
}
