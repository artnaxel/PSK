package org.vu.pskdemo.jpa.rest;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.OptimisticLockException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.*;
import org.vu.pskdemo.jpa.entities.Student;
import org.vu.pskdemo.jpa.entities.StudentGroup;
import org.vu.pskdemo.jpa.persistence.StudentDao;
import org.vu.pskdemo.jpa.rest.dto.StudentDto;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/student")
public class StudentController {

    @Inject
    @Setter @Getter
    private StudentDao studentDao;


    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Long id) {
        Student student = studentDao.findOne(id);
        if (student == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        List<StudentGroup> studentGroup = student.getStudentGroup();
        List<String> studentGroupNames = studentGroup.stream()
                .map(StudentGroup::getTitle)
                .collect(Collectors.toList());

        StudentDto studentDto = new StudentDto();
        studentDto.setName(student.getName());
        studentDto.setCardNumber(student.getCardNumber());
        studentDto.setGroupName(studentGroupNames);

        return Response.ok(studentDto).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Long studentId,
            StudentDto playerData) {
        try {
            Student existingStudent = studentDao.findOne(studentId);
            if (existingStudent == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingStudent.setName(playerData.getName());
            existingStudent.setCardNumber(playerData.getCardNumber());
            studentDao.update(existingStudent);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}