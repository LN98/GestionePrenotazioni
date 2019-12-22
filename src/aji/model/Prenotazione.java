package aji.model;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Prenotazione {
	
	public String nome; //nome
	public String tel;//numero telefono
	public int n;//numero posti

	public String orario;
	
	
	public Prenotazione(String nome, String tel, int n, String orario) {
		this.nome = nome;
		this.tel = tel;
		this.n = n;
		this.orario=orario;

	}
	
	public Prenotazione(String s,LocalDate d) {
		DateTimeFormatter formatterr = DateTimeFormatter.ofPattern("yyyyMMdd");
		String[] l;
		l=s.split(" "); //nome tel n orario attivo
		
		int n=Integer.parseInt(l[1]);
		this.nome=l[2];
		this.n=n;
		this.tel=l[3];
		this.orario=d.format(formatterr)+l[0];
		
	}


	@Override
	public String toString() {

		return nome + " " + tel + " " + n + " "+ orario;

	}
	
	public String toStringP() {
		return orario.substring(8) + " " + n + " "+ nome + " " +tel;
	}
	
	
	


	
	
	
	
	
	

}
