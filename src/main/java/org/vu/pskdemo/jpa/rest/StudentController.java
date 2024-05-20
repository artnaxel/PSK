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
import org.vu.pskdemo.jpa.persistence.StudentGroupDao;
import org.vu.pskdemo.jpa.rest.dto.StudentDto;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/student")
public class StudentController {

    @Inject
    @Setter @Getter
    private StudentDao studentDao;

    @Inject
    @Getter @Setter
    private StudentGroupDao studentGroupDao;


    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Long id) {
        System.out.println("GET /student/" + id);
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
        studentDto.setPassNumber(student.getPassNumber());
        studentDto.setGroupName(studentGroupNames);

        return Response.ok(studentDto).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Long studentId,
            StudentDto studentData) {
        try {
            Student existingStudent = studentDao.findOne(studentId);
            if (existingStudent == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            existingStudent.setName(studentData.getName());
            existingStudent.setSurname(studentData.getSurname());
            existingStudent.setPassNumber(studentData.getPassNumber());

            if (studentData.getGroupName() != null) {
                List<StudentGroup> updatedGroups = studentGroupDao.findGroupsByNames(studentData.getGroupName());
                existingStudent.setStudentGroup(updatedGroups);
            }

            studentDao.update(existingStudent);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(StudentDto studentData) {
        try {
            Student newStudent = new Student();
            newStudent.setName(studentData.getName());
            newStudent.setSurname(studentData.getSurname());
            newStudent.setPassNumber(studentData.getPassNumber());
            studentDao.persist(newStudent);
            return Response.status(Response.Status.CREATED).entity(newStudent).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Failed to create student").build();
        }
    }
}