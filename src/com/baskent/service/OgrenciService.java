package com.baskent.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Entity;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.primefaces.component.messages.Messages;
import org.primefaces.context.RequestContext;

import com.baskent.entity.HibernateUtil;
import com.baskent.entity.Kullanici;
import com.baskent.entity.Ogrenci;

@ManagedBean(name="OgrenciService")
@ViewScoped
@Transactional
public class OgrenciService implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = -7145375643250767095L;
	public static Session getSession() {
	        return HibernateUtil.getSessionFactory().openSession();
	    }
	@Transactional
	public void save(Ogrenci ogrenci)
	{
		if(ogrenci.getAd()!=null&ogrenci.getDogumTarihi()!=null&ogrenci.getSoyad()!=null&ogrenci.getEmail()!=null&ogrenci.getPassword()!=null)
		{	
		Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(ogrenci);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
        //    e.printStackTrace();
        } finally {
          //  session.flush();
            session.close();
        }
        showMessage1();
		}
		else
			showMessage2();
	}
	public void update(Ogrenci ogrenci) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(ogrenci);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
          
            session.close();
        }
    }

	 public void deleteById(int id) {
	      Transaction transaction=null;
	      Session session = HibernateUtil.getSessionFactory().openSession();
	      try {
	            transaction = session.beginTransaction();
	            Ogrenci ogrenci = (Ogrenci) session.load(Ogrenci.class,id);
	            session.delete(ogrenci);
	            session.getTransaction().commit();
	        } catch (RuntimeException e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	           // session.flush();
	            session.close();
	        }
	      
	    }
	 public Ogrenci getOgrenciById(int id) {
	        Ogrenci ogrenci = null;
	        Transaction transaction = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        try {
	            transaction = session.beginTransaction();
	            String queryString = "from Ogrenci where id = :id";
	            Query query = session.createQuery(queryString);
	            query.setInteger("id", id);
	            ogrenci = (Ogrenci) query.uniqueResult();
	        } catch (RuntimeException e) {
	            e.printStackTrace();
	        } finally {
	            session.flush();
	            session.close();
	        }
	        return ogrenci;
	    }
	        public List<Ogrenci> Listele(int size) {
	        List<Ogrenci> list = new ArrayList<Ogrenci>();
	        for(int i = 0 ; i < size ; i++) {
	            list.add(new Ogrenci());
	        }
	         
	        return list;
	    }
	        
	      public void showMessage1(){
	    	  FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Durum ", "Kayýt baþarý ile eklendi.");
	          
	          RequestContext.getCurrentInstance().showMessageInDialog(message);
	      }
	      public void showMessage2(){
	    	  FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Durum ", "Lütfen alanlarý eksiksiz doldurunuz!");
	          
	          RequestContext.getCurrentInstance().showMessageInDialog(message);
	      }
	      public Ogrenci getOgrenciByNameSurname(String ad,String soyad) {
		        Ogrenci ogrenci = null;
		        Transaction transaction = null;
		        Session session = HibernateUtil.getSessionFactory().openSession();
		        try {
		            transaction = session.beginTransaction();
		            String queryString = "from Ogrenci where ad = :ad and soyad = :soyad ";
		            Query query = session.createQuery(queryString);
		            query.setString("ad", ad);
		            query.setString("soyad",soyad);
		            
		            ogrenci = (Ogrenci) query.uniqueResult();
		        } catch (RuntimeException e) {
		            e.printStackTrace();
		        } finally {
		         //   session.flush();
		            session.close();
		        }
		        return ogrenci;
		    }
	      @Transactional
	      public boolean authenticateUser(Kullanici kullanici) {
	    	 Ogrenci ogrenci1=null;
	    	  
	          ogrenci1= getOgrenciByNameSurname(ogrenci1.getAd(), ogrenci1.getSoyad());         
	          if(kullanici!=null && ogrenci1.getAd().equals(kullanici.getAd()) && ogrenci1.getSoyad().equals(kullanici.getSoyad()) && ogrenci1.getPassword().equals(kullanici.getPassword())){
	              return true;
	          }else{
	              return false;
	          }
	      }

	      public Ogrenci getByName(String Ogrenciadi)
	      {
	    	  Session session = null;
	    	  Ogrenci ogrenci=null;
	    	  try {
	              session = HibernateUtil.getSessionFactory().openSession();
	              ogrenci =  (Ogrenci) session.get(Ogrenci.class,Ogrenciadi);
	              Hibernate.initialize(ogrenci);
	              System.out.println(ogrenci.getAd());
	          } catch (Exception e) {
	        	  e.printStackTrace();
	          } finally {
	        	  if (session != null && session.isOpen()) {
	                  session.close();
	          }
	      }
	    	  return ogrenci;

}
}