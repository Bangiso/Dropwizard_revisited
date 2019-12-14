package com.aphiwe.resources;
import com.aphiwe.api.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
public class StudentRecordResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public Student getStudent(@QueryParam("id") long id){
        Student student;
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        student= (Student) session.get(Student.class,id);
        tx.commit();
        return student;
    }
    @Path("/All")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAllRecords(){
        SessionFactory sf=  new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx=session.beginTransaction();

        List<Student> student = session.createQuery("FROM Student").list();
        tx.commit();
       return  student;

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
        return Response.status(200).build();
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateToDB(Student student){
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(student);
        tx.commit();
        return Response.status(200).build();
    }
    @DELETE
    @Path("/rm")
    public Response removeFromDB(@QueryParam("id") long id){
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Student student= (Student) session.get(Student.class,id);
        session.delete(student);
        tx.commit();
        return Response.status(200).build();
    }



}
