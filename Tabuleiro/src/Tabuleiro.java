import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Dado {
    private int numeroAtual;
    private Random random = new Random();

    public int rolar() {
        numeroAtual = random.nextInt(6) + 1;
        return numeroAtual;
    }
}

class Tabuleiro {
    private int numeroCasas;

    public Tabuleiro(int numeroCasas) {
        this.numeroCasas = numeroCasas;
    }

    public int getNumeroCasas() {
        return numeroCasas;
    }
}

class Jogador {
    private int casaAtual;
    private int meuNumero;

    public Jogador(int meuNumero) {
        this.meuNumero = meuNumero;
        this.casaAtual = 0;
    }

    public void jogar(int valorDado, int limiteCasas) {
        casaAtual += valorDado;
        if (casaAtual > limiteCasas) {
            casaAtual = limiteCasas;
        }
    }

    public int getCasaAtual() {
        return casaAtual;
    }

    public int getMeuNumero() {
        return meuNumero;
    }
}

class Jogo {
    private Tabuleiro meuTabuleiro;
    private ArrayList<Jogador> meusJogadores;
    private Dado meuDado;

    public Jogo(int numeroCasas, int numJogadores) {
        meuTabuleiro = new Tabuleiro(numeroCasas);
        meusJogadores = new ArrayList<>();
        meuDado = new Dado();

        for (int i = 1; i <= numJogadores; i++) {
            meusJogadores.add(new Jogador(i));
        }
    }

    public void proximaJogada() {
        for (Jogador jogador : meusJogadores) {
            int valorDado = meuDado.rolar();
            jogador.jogar(valorDado, meuTabuleiro.getNumeroCasas());
            System.out.println("Jogador " + jogador.getMeuNumero() + " está na casa " + jogador.getCasaAtual());
        }
    }

    public void informarPosicoes() {
        for (Jogador jogador : meusJogadores) {
            System.out.println("Jogador " + jogador.getMeuNumero() + " está na casa " + jogador.getCasaAtual());
        }
    }
}

public class Tabuleiro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número de casas do tabuleiro: ");
        int numCasas = scanner.nextInt();
        System.out.print("Digite o número de jogadores: ");
        int numJogadores = scanner.nextInt();
        
        Jogo jogo = new Jogo(numCasas, numJogadores);
        int opcao;
        do {
            System.out.println("\nMENU");
            System.out.println("1 - Iniciar nova partida");
            System.out.println("2 - Executar jogada");
            System.out.println("3 - Informar posições");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    jogo = new Jogo(numCasas, numJogadores);
                    System.out.println("Nova partida iniciada!");
                    break;
                case 2:
                    jogo.proximaJogada();
                    break;
                case 3:
                    jogo.informarPosicoes();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        
        scanner.close();
    }
}
