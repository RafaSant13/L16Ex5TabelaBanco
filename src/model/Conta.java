package model;

public class Conta {
	
	public String numero;
	public String nome;
	public float saldo;

	public Conta(int n, String nome, float saldo) {
		this.numero = String.format("%04d", n);
		this.nome = nome;
		this.saldo = saldo;
	}
	
	public Conta(int n) {
		this.numero = String.format("%04d", n);
	}

	@Override
	public int hashCode() {
		int hash = Integer.parseInt(numero) % 10;
		return hash;
	}

	
	
}
