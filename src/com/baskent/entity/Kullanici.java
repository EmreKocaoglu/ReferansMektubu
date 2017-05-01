package com.baskent.entity;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;

import com.baskent.entity.Ogrenci;
import com.baskent.service.OgrenciService;

@ManagedBean(name="kullanici")
@RequestScoped
public class Kullanici implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9185587737376605579L;
	private String ad;
	private String soyad;
	private String password;
	Ogrenci ogrenci1;
	
	public Kullanici(){
		
	}
	public Kullanici(String ad, String soyad, String password) {
		super();
		this.ad = ad;
		this.soyad = soyad;
		this.password = password;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	@Transactional
 /*   public String authenticateUser(Ogrenci ogrenci1) {
  	 
  	  Kullanici kullanici = new Kullanici();
  	  kullanici.getOgrenciByNameSurname(ad, soyad, password);
  	  
        ogrenci1= getOgrenciByNameSurname(ogrenci1.getAd(), ogrenci1.getSoyad(),ogrenci1.getPassword());         
        if(ogrenci1!=null && ogrenci1.getAd().equals(kullanici.getAd()) && ogrenci1.getSoyad().equals(kullanici.getSoyad()) && ogrenci1.getPassword().equals(kullanici.getPassword()))
        {
            
        	return 	"baþarýlý";
        }else{
            return "baþarýsýz" ;
        }

}*/
	 public Kullanici getOgrenciByNameSurname(String ad,String soyad,String password) {
	        Ogrenci ogrenci = null;
	        Kullanici kullanici=null;
	        Transaction transaction = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        try {
	            transaction = session.beginTransaction();
	            String queryString = "from Ogrenci where ad = :ad and soyad = :soyad and password = :password";
	            Query query = session.createQuery(queryString);
	            query.setString("ad", ad);
	            query.setString("soyad",soyad);
	            query.setString("password",password);
	            
	            ogrenci = (Ogrenci) query.uniqueResult();
	            
	        } catch (RuntimeException e) {
	            e.printStackTrace();
	        } finally {
	         //   session.flush();
	            session.close();
	        }
	        
	        return kullanici;
	    }
	    
		public void login(ActionEvent event) {
	    	OgrenciService ogrenciService = new OgrenciService();
	    	Ogrenci ogrenci = ogrenciService.getByName(ad);
	        Kullanici kullanici = new Kullanici();
	        Transaction transaction = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();
	       
	        FacesMessage message = null;
	        
	      
	        if(kullanici.getAd() != null && kullanici.getAd().equals(ogrenci.getAd()))
			System.out.println("Doðru");
	        else
	        	System.out.println("Yanlýþ");
	        		
	    	
	    }
}
