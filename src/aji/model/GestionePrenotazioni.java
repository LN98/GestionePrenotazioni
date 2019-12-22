package aji.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class GestionePrenotazioni {
	

	public ArrayList<Prenotazione> prenotazioni=new ArrayList<>();
	private DateTimeFormatter formatterr = DateTimeFormatter.ofPattern("yyyyMMdd");
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");


	public void caricaPrenitazioni() {
		
		
		
		try {
			

			BufferedReader reader=new BufferedReader(new FileReader(new File("prenotazioni.txt")));
			String l;
			while((l=reader.readLine())!=null) {

				String[] s;
				s=l.split(" "); //nome tel n orario attivo
				
				int n=Integer.parseInt(s[2]);

				Prenotazione p=new Prenotazione(s[0],s[1],n,s[3]);
				if(LocalDateTime.parse(p.orario, formatter).isAfter(LocalDate.now().atStartOfDay())) {
				prenotazioni.add(p);
				}

			}
			reader.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public void addPrenotazione(String s,LocalDate d) {
		
		String[] l;
		l=s.split(" "); //nome tel n orario attivo
		
		int n=Integer.parseInt(l[1]);
		Prenotazione p=new Prenotazione(l[2],l[3],n,d.format(formatterr)+l[0]);
		
		if(p.orario.length()==12) {
			
			prenotazioni.add(p);
			agg();
		} else {
			int[] j=new int[2];
			int k=j[2];
		}
		
		
	}
	
	private void agg()  {
		try {
			sort();
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("prenotazioni.txt")));
			String l = "";
			for (int i = 0; i < prenotazioni.size(); i++) {

				l += (prenotazioni.get(i) + "\n");

			}
			writer.write(l);
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private void sort(){
		ArrayList<Prenotazione> pre1=new ArrayList<>();

	
		LocalDateTime dateTime;
		LocalDateTime t;
		int index=0;
		while (prenotazioni.size()!=0) {
			dateTime = LocalDateTime.MAX;
			for (int i = 0; i < prenotazioni.size(); i++) {
				t = LocalDateTime.parse(prenotazioni.get(i).orario, formatter);
				
				if (t.isBefore(dateTime)) {
					dateTime=t;
					index=i;
				}
				
			}
			
			pre1.add(prenotazioni.get(index));
			prenotazioni.remove(index);
			
		}
		prenotazioni=pre1;
	}
	
public void elimina(String s,LocalDate d) {
		
		String[] l;
		l=s.split(" "); //nome tel n orario attivo
		
		int n=Integer.parseInt(l[1]);
		Prenotazione p=new Prenotazione(l[2],l[3],n,d.format(formatterr)+l[0]);
		for (int i = 0; i < prenotazioni.size(); i++) {
			if (prenotazioni.get(i).toString().equals(p.toString())) {
				
				prenotazioni.remove(i);
				agg();break;
			}

		}
		
		
	}

	public ArrayList<Prenotazione> mattina(LocalDate d){
		ArrayList<Prenotazione> mattina=new ArrayList<>();
		
		for(int i=0;i<prenotazioni.size();i++) {
			if(LocalDateTime.parse(prenotazioni.get(i).orario, formatter).isAfter(d.atStartOfDay())&&LocalDateTime.parse(prenotazioni.get(i).orario, formatter).isBefore(d.atTime(15, 00))) {
				mattina.add(prenotazioni.get(i));
			}
		}
		return mattina;
	}
	
	public ArrayList<Prenotazione> primo(LocalDate d){
		ArrayList<Prenotazione> primo=new ArrayList<>();
		
		for(int i=0;i<prenotazioni.size();i++) {
			if(LocalDateTime.parse(prenotazioni.get(i).orario, formatter).isAfter(d.atTime(17, 59))&&LocalDateTime.parse(prenotazioni.get(i).orario, formatter).isBefore(d.atTime(21, 29))) {
				primo.add(prenotazioni.get(i));
			}
		}
		return primo;
	}

	public ArrayList<Prenotazione> secondo(LocalDate d){
		ArrayList<Prenotazione> secondo=new ArrayList<>();
		
		for(int i=0;i<prenotazioni.size();i++) {
			if(LocalDateTime.parse(prenotazioni.get(i).orario, formatter).isBefore(d.atTime(23, 59))&&LocalDateTime.parse(prenotazioni.get(i).orario, formatter).isAfter(d.atTime(21, 29))) {
				secondo.add(prenotazioni.get(i));
			}
		}
		return secondo;
	}

	public int postiM(LocalDate d) {
		int n=0;
		for(int i=0;i<mattina(d).size();i++) {
			n+=mattina(d).get(i).n;
		}
		return n;
	}
	public int postiP(LocalDate d) {
		int n=0;
		for(int i=0;i<primo(d).size();i++) {
			n+=primo(d).get(i).n;
		}
		return n;
	}
	public int postiS(LocalDate d) {
		int n=0;
		for(int i=0;i<secondo(d).size();i++) {
			n+=secondo(d).get(i).n;
		}
		return n;
	}
}












