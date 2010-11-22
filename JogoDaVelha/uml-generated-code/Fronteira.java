package jogo_velha;

import java.util.Scanner; //Pra poder ler a entrada do console

public class Fronteira {

	
/**
 * Class Fronteira
 */
public class Fronteira {

 public static Controle controle = new Controle();
	static MenuJogoVelha menu = new MenuJogoVelha();
	static Scanner input = new Scanner(System.in);

  public Fronteira () { };
  
 
	public static boolean verificarPosicaoInvalida(int i, int j) {
		if ((i == 1 && j == 1) || (i == 1 && j == 2) || (i == 1 && j == 3)
				|| (i == 2 && j == 1) || (i == 2 && j == 2)
				|| (i == 2 && j == 3) || (i == 3 && j == 1)
				|| (i == 3 && j == 2) || (i == 3 && j == 3))
			return false;
		else
			return true;
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
	
	

	public static void imprimirTabuleiro(char matriz[][]) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(matriz[i][j]);
			}
			System.out.println();
		}
	}
	


	public static void iniciarPartida(int opcao) {

		Controle.iniciarTabuleiro();
		if (opcao == 1)
			jogarHumano();
		else
			jogarRobo();
	}

	
	
	
	public static void jogarHumano() {
		int i, j;
		char simbolo = 'x';
		Controle.iniciarTabuleiro();
		while ((controle.jogoTerminado() != true)
				&& (controle.verificaTabuleiroCheio() != true)) {
			imprimirTabuleiro(Controle.getMatriz());

			if (simbolo == 'x')
				System.out.println("\n\nJogador 1\n");
			else
				System.out.println("\n\nJogador 2\n");

			System.out.println("Digite a linha e a coluna de sua jogada: ");
			i = input.nextInt();
			j = input.nextInt();

			if (jogar(i, j, simbolo)) {
				if (simbolo == 'x')
					simbolo = 'o';
				else
					simbolo = 'x';
			}
		}
		imprimirTabuleiro(Controle.getMatriz());

		

	}

	public static void jogarRobo() {

		
	}
	
	public static boolean jogar(int i, int j, char simbolo) {

		if (verificarPosicaoInvalida(i, j) == false) {
			if (controle.posicaoOcupada(i, j) == false) {
				controle.fazerJogada(i, j, simbolo);
				return true;
			} else
				System.out
						.println("\n\nPosicao ja ocupada! Jogue novamente...\n\n");
			return false;
		} else
			System.out.println("\n\nPosicao invalida\n\n");
		return false;
	}


	public static void main(String[] args) {

		gerarMenuPrincipal();
	}

}
