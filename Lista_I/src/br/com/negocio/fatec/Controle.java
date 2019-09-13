package br.com.negocio.fatec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import br.com.modelo.fatec.Agenda;
import br.com.modelo.fatec.Contato;

public class Controle {
	public Scanner scanner;
//	coloquei aqui porq eu dava new contato ele resetava a lista
	public Map <String, Integer> contServicos;
	public Map <String, Integer> contServicosM;
	public Map <String, Integer> contServicosF;

	public Map<String, Integer> getContServicosM() {
		return contServicosM;
	}

	public void setContServicosM(Map<String, Integer> contServicosM) {
		this.contServicosM = contServicosM;
	}

	public Map<String, Integer> getContServicosF() {
		return contServicosF;
	}

	public void setContServicosF(Map<String, Integer> contServicosF) {
		this.contServicosF = contServicosF;
	}

	public Controle() {
		scanner = new Scanner(System.in);
		contServicos = new HashMap<String, Integer>();
		contServicos.put("Manicure", 0);
		contServicos.put("Pedicure", 0);
		contServicos.put("Design de sobrancelhas", 0);
		contServicos.put("Corte", 0);
		contServicos.put("Pintura de cabelos", 0);
		contServicos.put("Remo��o de rugas", 0);
		contServicos.put("Remo��o de manchas na pele", 0);
		contServicos.put("Aplica��o de botox", 0);
		contServicos.put("Tratamento para emagrecimento", 0);
		contServicos.put("Redu��o de medidas", 0);
		
		contServicosM = new  HashMap<String, Integer>();
		contServicosM.put("Manicure", 0);
		contServicosM.put("Pedicure", 0);
		contServicosM.put("Design de sobrancelhas", 0);
		contServicosM.put("Corte", 0);
		contServicosM.put("Pintura de cabelos", 0);
		contServicosM.put("Remo��o de rugas", 0);
		contServicosM.put("Remo��o de manchas na pele", 0);
		contServicosM.put("Aplica��o de botox", 0);
		contServicosM.put("Tratamento para emagrecimento", 0);
		contServicosM.put("Redu��o de medidas", 0);
		
		
		contServicosF = new  HashMap<String, Integer>();
		contServicosF.put("Manicure", 0);
		contServicosF.put("Pedicure", 0);
		contServicosF.put("Design de sobrancelhas", 0);
		contServicosF.put("Corte", 0);
		contServicosF.put("Pintura de cabelos", 0);
		contServicosF.put("Remo��o de rugas", 0);
		contServicosF.put("Remo��o de manchas na pele", 0);
		contServicosF.put("Aplica��o de botox", 0);
		contServicosF.put("Tratamento para emagrecimento", 0);
		contServicosF.put("Redu��o de medidas", 0);
		
	}
	
	public Map<String, Integer> getContServicos() {
		return contServicos;
	}

	public void setContServicos(Map<String, Integer> contServicos) {
		this.contServicos = contServicos;
	}

	public int opcao() {
		int op = scanner.nextInt();
		return op;
	}

	public String texto() {
		String t = scanner.nextLine();
		return t;
	}
	
	public void contatosPorGenero(ArrayList<Contato> all) {
		
//		ArrayList<Contato> ListaAux = new ArrayList<Contato>();
//		" + relatorio.getServicoMaisProcuradoGenero(getContServicosF()) + "\n");
		
		
	}
	
	public Map getContatosMap() throws IOException {
		File arq 			= new File("C:\\Users\\Aluno\\Desktop\\agenda.txt");
		FileReader rd 		= new FileReader(arq);
		BufferedReader brd 	= new BufferedReader(rd);
		String texto 		= brd.readLine();
		Map<String, Contato> contatos = new HashMap<String, Contato>();
		String aux;
		Contato c = new Contato();
		
		while(texto != null) {
			aux = texto.split(":")[0];
			if(aux.contains("Nome")) {
				c.setNome(texto.split(": ")[1]);
			}
			
			if(aux.contains("Telefone")) {
				c.setTelefone(texto.split(": ")[1]);
			}
			
			if(aux.contains("Data")) {
				c.setData_nasc(texto.split(": ")[1]);
			}
			
			if(aux.contains("Sexo")) {
				c.setGenero(texto.split(": ")[1]); 
				contatos.put(c.getNome(), c);
				c = new Contato();
			}
			texto = brd.readLine();
		}
		
		brd.close();
		return contatos;
	}
	
	public ArrayList init() throws IOException {
		
			ArrayList<Contato> contatos = new ArrayList<Contato>();
			File arq 					= new File("C:\\Users\\Aluno\\Desktop\\agenda.txt");
			FileReader rd 				= new FileReader(arq);
			BufferedReader brd 			= new BufferedReader(rd);
			String texto 				= brd.readLine();
			Contato c 					= new Contato();
			int aux;
			
			while(texto != null) {
				if(texto.split(":")[0].contains("Nome")) {
					c.setNome(texto.split(": ")[1]);
				}
				
				if(texto.split(":")[0].contains("Telefone")) {
					c.setTelefone(texto.split(": ")[1]);
				}
				
				if(texto.split(":")[0].contains("Data")) {
					c.setData_nasc(texto.split(": ")[1]);
				}
				
				if(texto.split(":")[0].contains("Sexo")) {
					c.setGenero(texto.split(": ")[1]);

					contatos.add(c);
					c = new Contato();
				}
				
				texto = brd.readLine();
			}

			brd.close();
			return contatos;
	}
	

	public void salvar(Contato c) throws IOException {
		
		File arq 			= new File("C:\\Users\\Aluno\\Desktop\\agenda.txt");
		FileWriter wr 		= new FileWriter(arq, true);
		BufferedWriter bwr 	= new BufferedWriter(wr);
		
		bwr.write("Nome: " + c.getNome());
		bwr.newLine();
		bwr.write("Telefone: " + c.getTelefone());
		bwr.newLine();
		bwr.write("Data de nascimento: " + c.getData_nasc());
		bwr.newLine();
		bwr.write("Sexo: " + c.getGenero());
		bwr.newLine();
		bwr.write("======================================");
		bwr.newLine();
		bwr.close();
		
		System.out.println("Inseriu " + c.getNome() +
				" " + c.getData_nasc() + 
				" " + c.getGenero() + 
				" " + c.getTelefone());
	}
	
	public void salvarLista(ArrayList<Contato> contatos) throws IOException {
		
		File arq 			= new File("C:\\Users\\Aluno\\Desktop\\agenda.txt");
		FileWriter wr 		= new FileWriter(arq);
		BufferedWriter bwr 	= new BufferedWriter(wr);
		
		for (Contato c : contatos) {
			
			bwr.write("Nome: " + c.getNome());
			bwr.newLine();
			bwr.write("Telefone: " + c.getTelefone());
			bwr.newLine();
			bwr.write("Data de nascimento: " + c.getData_nasc());
			bwr.newLine();
			bwr.write("Sexo: " + c.getGenero());
			bwr.newLine();
			bwr.write("======================================");
			bwr.newLine();			
		}
		bwr.close();
	}

	@Override
	protected void finalize() throws Throwable {
		scanner.close();
	}
}