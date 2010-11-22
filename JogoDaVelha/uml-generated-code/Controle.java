

/**
 * Class Controle
 */
public class Controle {


  public Controle () { };
  
  static char[][] matriz = new char[5][5];

	static Entidade entidade = new Entidade();

	public static char[][] getMatriz() {
		matriz = Entidade.getMatriz();
		return matriz;
	}

	public static void iniciarTabuleiro() {
		Entidade.inicializarTabuleiro(getMatriz());
	}

	public boolean jogoTerminado() {

		return false;

	}

	
	public void fazerJogada(int i, int j, char simbolo) {
		entidade.marcarJogada(i, j, simbolo);
	}


	public boolean posicaoOcupada(int i, int j) {
		if (entidade.verificaPosicaoOcupada(i, j) == true)
			return true;
		else
			return false;
	}

	public boolean verificaTabuleiroCheio() {
		if (entidade.verificaTabuleiroOcupado() == true)
			return true;
		else
			return false;

	}


}
