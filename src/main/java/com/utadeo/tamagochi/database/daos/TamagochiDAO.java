/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utadeo.tamagochi.database.daos;

import org.hibernate.Session;

import com.utadeo.tamagochi.database.entities.Tamagochi;
      
import com.utadeo.tamagochi.database.HibernateUtil;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import org.hibernate.Criteria;
/**
 *
 * @author USUARIO
 */
public class TamagochiDAO {
 
    public void insert(Tamagochi tamagochi) {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(tamagochi);
        session.getTransaction().commit();
    }
    
    public List<Tamagochi> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Tamagochi.class);
        
        session.getTransaction().commit();
        return criteria.list();
    }
    
    public Long readLetestId(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Long lastId = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).longValue();
        session.getTransaction().commit();
        return lastId;
    }

    
    public void update(Tamagochi tamagochi) {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(tamagochi);
        session.getTransaction().commit();
    }

    public void delete(Integer id) {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Tamagochi tamagochi = (Tamagochi) session.load(Tamagochi.class, id);
        session.delete(tamagochi);
        session.getTransaction().commit();
    }

    public Tamagochi read(Long id) {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Tamagochi tamagochi = (Tamagochi) session.load(Tamagochi.class, id);
        session.getTransaction().commit();
        return tamagochi;
    }
    
    public void restaEnergia(Integer id) throws Exception {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Tamagochi tamagochi = (Tamagochi) session.load(Tamagochi.class, id);
        if(tamagochi==null){
            throw new Exception("Tamagochi no existe");
        }
        
        int energia = tamagochi.getEnergia();
        if(energia==0){
            throw new Exception("La energia esta en cero");
        }
        energia -= 20;
        tamagochi.setEnergia(energia);
        
        session.save(tamagochi);
        session.getTransaction().commit();
    }
   
    
    public void sumaEnergia(Long id) throws Exception {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Tamagochi tamagochi = (Tamagochi) session.load(Tamagochi.class, id);
        if(tamagochi==null){
            throw new Exception("Tamagochi no existe");
        }
        
        int energia = tamagochi.getEnergia();
        if(energia==100){
            throw new Exception("La energia esta al 100%");
        }
        energia += 10;
        tamagochi.setEnergia(energia);
        
        session.save(tamagochi);
        session.getTransaction().commit();
    }
    
    public void sumaAnimo(Integer id) throws Exception {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Tamagochi tamagochi = (Tamagochi) session.load(Tamagochi.class, id);
        if(tamagochi==null){
            throw new Exception("Tamagochi no existe");
        }
        
        int animo = tamagochi.getBaño();
        if(animo==100){
            throw new Exception("El animo esta lleno");
        }
        animo += 10;
        tamagochi.setBaño(animo);
        
        session.save(tamagochi);
        session.getTransaction().commit();
    }
    
    public void feed(Long id) throws Exception {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Tamagochi tamagochi = (Tamagochi) session.load(Tamagochi.class, id);
        if(tamagochi==null){
            throw new Exception("Tamagochi no existe");
        }
        
        int hambre = tamagochi.getHambre();
        if(hambre==100){
            throw new Exception("No tiene hambre");
        }
        hambre += 10;
        tamagochi.setHambre(hambre);
        
        session.save(tamagochi);
        session.getTransaction().commit();
    }
    
    public void sleep(Long id,boolean sleep) throws Exception {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Tamagochi tamagochi = (Tamagochi) session.load(Tamagochi.class, id);
        if(tamagochi==null){
            throw new Exception("Tamagochi no existe");
        }
        
        tamagochi.setDormido(sleep);
        session.save(tamagochi);
        session.getTransaction().commit();
    }
    
    public void dead(Integer id) throws Exception {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Tamagochi tamagochi = (Tamagochi) session.load(Tamagochi.class, id);
        if(tamagochi==null){
            throw new Exception("Tamagochi no existe");
        }
        
        tamagochi.setMuerte(true);
        
        session.save(tamagochi);
        session.getTransaction().commit();
    }
}
