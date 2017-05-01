package com.baskent.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.baskent.service.OgrenciService;

public class Main {

	public static void main(String[] args) {
		System.out.println("Application Started..");
		Ogrenci ogrenci = new Ogrenci();
		OgrenciService ogrenciService = new OgrenciService();
		ogrenci.setAd("sadas");
		ogrenci.setSoyad("asdasdas");
		ogrenci.setProgram("bil müh");
		ogrenci.setDerece(45.00);
		ogrenciService.save(ogrenci);
		ogrenciService.update(ogrenci);
		ogrenciService.getOgrenciById(1);

		

	}

}
