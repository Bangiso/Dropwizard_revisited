package com.aphiwe.resources;
import com.aphiwe.api.Student;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;
@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
public class StudentRecordResource {
    List<Student> students =new ArrayList<>();
    public StudentRecordResource (){
        students.add(new Student(1,"Sam",88));
        students.add(new Student(2,"Lia",50));
        students.add(new Student(8,"Anele",90));
        students.add(new Student(5,"Aphiwe",30));
    }

    @GET
    public List<Student> getStudent(){
        return students;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStudent(Student stud){
        if(!students.contains(stud)){
            students.add(stud);
            return Response.ok().build();
        }
        return Response.ok().build();

    }





}
