package com.aphiwe.resources;
import com.aphiwe.api.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
public class StudentRecordResource {
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)

    public Student getStudent(@PathParam("id") long id){
        Student student;
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        student= (Student) session.get(Student.class,id);
        tx.commit();
        return student;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addToDB(Student student){
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        tx.commit();
        return Response.ok().build();
    }


}
