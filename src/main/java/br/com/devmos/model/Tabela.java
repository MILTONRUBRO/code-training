package br.com.devmos.model;

import java.util.ArrayList;
import java.util.List;

public class Tabela {
	private String j1;
	private String j2;
	private String msg;
	
	private static final String PAPEL = "papel";
	private static final String PEDRA = "pedra";
	private static final String TESOURA = "tesoura";
	private static final String SPOCK = "Spock";
	private static final String LAGARTO = "lagarto";
	private static final String BAZINGA = "Bazinga!";
	private static final String RAJ = "Raj trapaceou!";
	public String getJ1() {
		return j1;
	}

	public void setJ1(String j1) {
		this.j1 = j1;
	}

	public String getJ2() {
		return j2;
	}

	public void setJ2(String j2) {
		this.j2 = j2;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
    public Tabela(String j1, String j2, String msg) {
		this.j1 = j1;
		this.j2 = j2;
		this.msg = msg;
	}

	public static List<Tabela> getTabelaGames() {
		List<Tabela> tabelas = new ArrayList<>();
		
		tabelas.add(new Tabela(TESOURA, PAPEL, BAZINGA));
		tabelas.add(new Tabela(PAPEL, TESOURA, RAJ));
		tabelas.add(new Tabela(PAPEL, PEDRA, BAZINGA));
		tabelas.add(new Tabela(PEDRA, PAPEL, RAJ));
		tabelas.add(new Tabela(PEDRA, LAGARTO, BAZINGA));
		tabelas.add(new Tabela(LAGARTO, PEDRA, RAJ));
		tabelas.add(new Tabela(LAGARTO, SPOCK, BAZINGA));
		tabelas.add(new Tabela(SPOCK, LAGARTO, RAJ));
		tabelas.add(new Tabela(SPOCK, TESOURA, BAZINGA));
		tabelas.add(new Tabela(TESOURA, SPOCK, RAJ));
		tabelas.add(new Tabela(TESOURA, LAGARTO, BAZINGA));
		tabelas.add(new Tabela(LAGARTO, TESOURA, RAJ));
		tabelas.add(new Tabela(LAGARTO, PAPEL, BAZINGA));
		tabelas.add(new Tabela(PAPEL, LAGARTO, RAJ));
		tabelas.add(new Tabela(PAPEL, SPOCK, BAZINGA));
		tabelas.add(new Tabela(SPOCK, PAPEL, RAJ));
		tabelas.add(new Tabela(SPOCK, PEDRA, BAZINGA));
		tabelas.add(new Tabela(PEDRA, SPOCK, RAJ));
		tabelas.add(new Tabela(PEDRA, TESOURA, BAZINGA));
		tabelas.add(new Tabela(TESOURA, PEDRA, RAJ));

		return tabelas;
	}

}
