package com.baskent.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.baskent.entity.HibernateUtil;
import com.baskent.entity.Ogrenci;
import com.baskent.service.OgrenciService;


@ManagedBean
@ViewScoped
public class OgrenciView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7659418665892058583L;
	
	@ManagedProperty(value="#{ogrenciService}")
	OgrenciService ogrenciService;
	
	List<Ogrenci> ogrenciListesi;
	
	Ogrenci ogrenci;
	
	@PostConstruct
	private void init(){
		ogrenci = new Ogrenci();
		getOgrenci();
		
	}
	public List <Ogrenci> getOgrenci(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		ogrenciListesi=session.createSQLQuery("select *from gnl_ogrenci").addEntity(Ogrenci.class).list();
		return ogrenciListesi;
	}
	public void setService(OgrenciService ogrenciService) {
        this.ogrenciService = ogrenciService;;
    }
	public void kaydet(Ogrenci ogrenci){
	
		ogrenciService.save(ogrenci);
		ogrenci=new Ogrenci();
          getOgrenci();
	                   }
	/*public Ogrenci getOgrenci(){
		return ogrenci;
	}*/
	public void setOgrenci(Ogrenci ogrenci){
		this.ogrenci=ogrenci;
	}
	
}
