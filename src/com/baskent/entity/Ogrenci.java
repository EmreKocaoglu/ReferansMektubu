package com.baskent.entity;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@ManagedBean
@RequestScoped
@Entity
@Table(name="gnl_ogrenci")
public class Ogrenci{
        private String ad;
        private String soyad;
        private int id;
        private Date dogumTarihi;
        private double derece;
        private String program;
        private String adres;
        private String sehir;
        private String ders;
        private int postaKodu;
        private String password;
        private String message1,message2,message3;
        private String email;
        public Ogrenci() {
        }

        public Ogrenci(String ad, String soyad, Date dogumTarihi, double derece, String program, String adres, String sehir, String ders, int postaKodu) {
                this.ad = ad;
                this.soyad = soyad;
                this.dogumTarihi = dogumTarihi;
                this.derece = derece;
                this.program = program;
                this.adres = adres;
                this.sehir = sehir;
                this.ders = ders;
                this.postaKodu = postaKodu;
        }

        @Column(length = 100, name= "ad")
        public String getAd() {
                return ad;
        }

        public void setAd(String ad) {
                this.ad = ad;
        }
        public String getDers() {return ders;}

        public void setDers(String ders) {this.ders = ders;}

        @Column(length = 100, name = "soyad")
        public String getSoyad() {
                return soyad;
        }

        public void setSoyad(String soyad) {
                this.soyad = soyad;
        }

        @Id
        @Column(name = "id")
        @SequenceGenerator(allocationSize = 1, name = "seq_ogrenci_id", sequenceName = "seq_ogrenci_id")
        @GeneratedValue(generator = "seq_ogrenci_id", strategy = GenerationType.SEQUENCE)
        private int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        @Temporal(TemporalType.DATE)
        @Column(name = "dogum_tarihi")
        public Date getDogumTarihi() {
                return dogumTarihi;
        }

        public void setDogumTarihi(Date dogumTarihi) {
                this.dogumTarihi = dogumTarihi;
        }

        public double getDerece() {
                return derece;
        }

        public void setDerece(double derece) {
                this.derece = derece;
        }

        public String getProgram() {
                return program;
        }

        public void setProgram(String program) {
                this.program = program;
        }

        public String getAdres() {
                return adres;
        }

        public void setAdres(String adres) {
                this.adres = adres;
        }

        public String getSehir() {
                return sehir;
        }

        public void setSehir(String sehir) {
                this.sehir = sehir;
        }

        @Column(name="postaKodu")
        public int getPostaKodu() {
                return postaKodu;
        }

        public void setPostaKodu(int postaKodu) {
                this.postaKodu = postaKodu;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getMessage1() {
                return message1;
        }

        public void setMessage1(String message1) {
                this.message1 = message1;
        }

        public String getMessage2() {
                return message2;
        }

        public void setMessage2(String message2) {
                this.message2 = message2;
        }

        public String getMessage3() {
                return message3;
        }

        public void setMessage3(String message3) {
                this.message3 = message3;
        }

        @java.lang.Override
        public java.lang.String toString() {
                return "Ogrenci{" +
                        "ad='" + ad + '\'' +
                        ", soyad='" + soyad + '\'' +
                        ", id=" + id +
                        ", dogumTarihi=" + dogumTarihi +
                        ", derece=" + derece +
                        ", program='" + program + '\'' +
                        ", adres='" + adres + '\'' +
                        ", sehir='" + sehir + '\'' +
                        ", postaKodu=" + postaKodu +
                        '}';
        }

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

}