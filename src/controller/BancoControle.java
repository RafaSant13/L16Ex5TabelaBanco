package controller;

import model.Conta;
import model.Lista;

@SuppressWarnings("unchecked")
public class BancoControle {

	
	Lista<Conta> [] cont = new Lista [10];
	
	public BancoControle() {
		int tamanho = cont.length;
		for (int i = 0; i < tamanho; i++) {
			cont[i] = new Lista<Conta>();
		}
	}
	
	public void add(Conta conta) throws Exception {
		int hash = conta.hashCode();
		cont[hash].addLast(conta);
	}

	public void search(Conta conta) throws Exception {
		int hash = conta.hashCode();
		Lista<Conta> l = cont[hash];
		int tamanho = l.size();
		for (int i = 0; i<tamanho;i++) {
			Conta c = l.get(i);
			if (Integer.parseInt(conta.numero) == Integer.parseInt(c.numero)) {
				System.out.printf("Número da conta: " + c.numero + "; Nome do cliente: " + c.nome + "; Saldo: R%%.2f%n", c.saldo);
			}
		}
	}
	
	public void list() throws Exception {
		int tamanhoV =  cont.length;
		for (int i = 0; i < tamanhoV; i++) {
			Lista<Conta> l = cont[i];
			int tamanhoL = l.size();
			for (int j = 0; j < tamanhoL; j++) {
				Conta c = l.get(j);
				System.out.printf("Número da conta: " + c.numero + "; Nome do cliente: " + c.nome + "; Saldo: R$%.2f%n", c.saldo);
			}
		}
	}
	
	public void remove(Conta conta) throws Exception {
		int hash = conta.hashCode();
		Lista<Conta> l = cont[hash];
		int tamanho = l.size();
		for (int i = 0; i<tamanho;i++) {
			Conta c = l.get(i);
			if (Integer.parseInt(conta.numero) == Integer.parseInt(c.numero)) {
				l.remove(i);
			}
		}
	}
}
