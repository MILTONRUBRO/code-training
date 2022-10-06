package br.com.devmos.model;

import java.util.Objects;

public class Car {

	private String cor;
	private String modelo;

	public Car(String cor, String modelo) {
		this.cor = Objects.requireNonNull(cor, "A cor do carro não pode ser nulla");
		this.modelo = Objects.requireNonNull(modelo, "O modelo do carro não pode ser nullo");
	}
	
	
	public String getCor() {
		return cor;
	}

	public String getModelo() {
		return modelo;
	}

}
