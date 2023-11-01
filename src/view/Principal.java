package view;

import javax.swing.JOptionPane;

import controller.BancoControle;
import model.Conta;

public class Principal {

	public static void main(String[] args) {
		BancoControle b = new BancoControle();
		for (int i = 1; i<= 10;i++) {
			int numero = (int)(Math.random()*10000);
			float saldo = (float)((Math.random()*9900)+100);
			Conta c = new Conta(numero, "Cliente "+i, saldo);
			try {
				b.add(c);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		int x = 0;
		while(x!=9) {
			x = Integer.parseInt(JOptionPane.showInputDialog("Menu\n1 - Adicionar conta\n2 - Pesquisar conta\n3 - Remover conta\n4 - Listar contas\n9 - Fim"));
			switch(x) {
			case 1:
				int numero = Integer.parseInt(JOptionPane.showInputDialog("Insira o número da conta: "));
				String nome = JOptionPane.showInputDialog("Insira o nome do cliente: ");
				float saldo = Float.parseFloat(JOptionPane.showInputDialog("Insira o saldo: "));
				Conta cont = new Conta(numero, nome, saldo);
				try {
					b.add(cont);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				int numeroP = Integer.parseInt(JOptionPane.showInputDialog("Insira o número da conta a ser pesquisada: "));
				Conta contP = new Conta(numeroP); 
				try {
					b.search(contP);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 3:
				int numeroR = Integer.parseInt(JOptionPane.showInputDialog("Insira o número da conta a ser removida: "));
				Conta contR = new Conta(numeroR); 
				try {
					b.remove(contR);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					b.list();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 9:
				System.exit(0);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Valor Inválido");
				break;
			}
		}
		
		
		

	}

}
