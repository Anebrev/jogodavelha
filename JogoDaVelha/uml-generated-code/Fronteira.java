package jogo_velha;

import java.util.Scanner; //Pra poder ler a entrada do console

public class Fronteira {

	public static Controle controle = new Controle();
	static MenuJogoVelha menu = new MenuJogoVelha();
	static Scanner input = new Scanner(System.in);

	
	public static void imprimirTabuleiro(char matriz[][]) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(matriz[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void gerarMenuInterface(){
		int opcao;
		do {
			MenuJogoVelha.mostrarMenuInterface();
			opcao = input.nextInt();

			switch (opcao) {

			case MenuJogoVelha.INTERFACE_GRAFICA:
				System.out.println("Interface nao disponivel\n");
				break;

			case MenuJogoVelha.INTERFACE_TEXTO:
				System.out.println("Interface de Texto Selecionada");
				gerarMenuOponente();
				break;

			case MenuJogoVelha.VOLTAR:
				break;

			default:

				System.out.println("OPCAO INVALIDA!");
				break;
			}
		} while (opcao != MenuJogoVelha.VOLTAR);
	}
	

	public static void gerarMenuPrincipal() {

		int opcao;

		do {
			MenuJogoVelha.mostrarMenuPrincipal();
			opcao = input.nextInt();

			switch (opcao) {

			case MenuJogoVelha.TIPO_INTERFACE:
				gerarMenuInterface();
				break;

			case MenuJogoVelha.SAIR:
				break;

			default:
				System.out.println("OPCAO INVALIDA!");
				break;
			}
		} while (opcao != MenuJogoVelha.SAIR);
	}
	
	public static void gerarMenuOponente() {
		int opcao;

		do {
			MenuJogoVelha.mostrarMenuOponente();// aqui o jogador vai escolher o
			// tipo de oponente
			opcao = input.nextInt();

			switch (opcao) {
			case MenuJogoVelha.OPONENTE_HUMANO:
				iniciarPartida(1);
				break;

			case MenuJogoVelha.OPONENTE_ROBO:
				break;

			case MenuJogoVelha.VOLTAR:
				break;

			default:

				System.out.println("OPCAO INVALIDA!");
				break;
			}

		} while (opcao != MenuJogoVelha.VOLTAR);
	}

	public static void iniciarPartida(int opcao) {

		Controle.iniciarTabuleiro();
		if (opcao == 1)
			jogarHumano();
		else
			jogarRobo();
	}
	
	
	
	public static void jogarHumano(){
		imprimirTabuleiro(Controle.getMatriz());
	}

	public static void jogarRobo(){
		
	}

	public static void main(String[] args) {

		gerarMenuPrincipal();
	}

}
