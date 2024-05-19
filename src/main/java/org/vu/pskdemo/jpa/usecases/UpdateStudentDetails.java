package org.vu.pskdemo.jpa.usecases;

import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.OptimisticLockException;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import org.vu.pskdemo.jpa.entities.Student;
import org.vu.pskdemo.jpa.persistence.StudentDao;

import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter
@Setter
public class UpdateStudentDetails implements Serializable {

    private Student student;

    @Inject
    private StudentDao studentDao;

    @PostConstruct
    private void init() {
        System.out.println("UpdateStudentDetails INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long studentId = Long.parseLong(requestParameters.get("studentId"));
        this.student = studentDao.findOne(studentId);
        this.student.getStudentGroup().size();
    }

    @Transactional
    public String updateStudentCardNumber() {
        try {
            studentDao.update(this.student);
        } catch (OptimisticLockException e) {
            return "/studentDetails.xhtml?faces-redirect=true&studentId=" + this.student.getId() + "&error=optimistic-lock-exception";
        }
        Long studentGroupId = this.student.getStudentGroup().get(this.student.getStudentGroup().size() - 1).getId();
        return "students.xhtml?studentGroupId=" + studentGroupId.toString() + "&faces-redirect=true";
    }
}
