package br.com.modelo.fatec;

import br.com.negocio.fatec.Controle;

public class Agenda {
	public Contato[] contatos = new Contato[5];
	
	public void inserirContato() {
		System.out.println("Por favor, digite um nome para o contato");
		Contato c = new Contato();
		Controle ctrl = new Controle();
		c.nome = ctrl.texto();
	}
}
