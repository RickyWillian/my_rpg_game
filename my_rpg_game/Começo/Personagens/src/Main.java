import java.util.Scanner;
import entities.*;
import services.Batalha;
import services.CarregadorDeHistoria;
import story.Cena;
import story.Historia;
import story.Opcao;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Carrega a história completa do arquivo JSON no início do jogo.
        Historia historia = CarregadorDeHistoria.carregarHistoria("historias.json");
        if (historia == null) {
            System.out.println("Não foi possível iniciar o jogo. Verifique o arquivo de história 'historias.json'.");
            return; 
        }

        // Cria o personagem do jogador.
        Heroi heroi = criarPersonagem(scanner);
        
        // Define a cena inicial com base no que foi carregado do JSON.
        Cena cenaAtual = historia.getCena(historia.cenaInicialId);

        // Loop principal do jogo, que avança de cena em cena.
        while (cenaAtual != null) {
            limparTela();
            // Substitui placeholders no texto para personalizar a história.
            String textoCena = cenaAtual.texto.replace("{HEROI_NOME}", heroi.getNome())
                                              .replace("{HEROI_CLASSE}", heroi.getClasse());
            System.out.println(textoCena);
            System.out.println("\n--------------------------------------------------");


            // Verifica se a cena atual tem uma ação especial, como uma batalha.
            if (cenaAtual.acao != null && !cenaAtual.acao.isEmpty()) {
                boolean vitoria = processarAcao(cenaAtual.acao, heroi, scanner);
                
                // Determina a próxima cena com base no resultado da batalha.
                if(vitoria){
                    cenaAtual = historia.getCena(cenaAtual.opcoes.get(0).proximoId); // Vitória leva para a primeira opção.
                } else {
                    cenaAtual = historia.getCena(cenaAtual.opcoes.get(1).proximoId); // Derrota leva para a segunda.
                }
                continue; 
            }
            
            // Se a cena não tiver mais opções, é um ponto final na história.
            if (cenaAtual.opcoes.isEmpty()) {
                break;
            }

            // Mostra as opções de escolha para o jogador.
            System.out.println("\nO que você faz?");
            for (int i = 0; i < cenaAtual.opcoes.size(); i++) {
                System.out.println((i + 1) + ". " + cenaAtual.opcoes.get(i).texto);
            }
            System.out.print("Sua escolha: ");
            int escolha = scanner.nextInt() - 1;
            scanner.nextLine();

            // Avança para a próxima cena com base na escolha do jogador.
            if (escolha >= 0 && escolha < cenaAtual.opcoes.size()) {
                Opcao opcaoEscolhida = cenaAtual.opcoes.get(escolha);
                cenaAtual = historia.getCena(opcaoEscolhida.proximoId);
            } else {
                System.out.println("Opção inválida.");
            }
        }
        
        System.out.println("\n--- FIM DA AVENTURA ---");
        pressioneParaContinuar(scanner);
        scanner.close();
    }

    private static Heroi criarPersonagem(Scanner scanner) {
        System.out.println("====================================");
        System.out.println("     CRIAÇÃO DE PERSONAGEM");
        System.out.println("====================================");
        System.out.println("Escolha sua classe:");
        System.out.println("1. Guerreiro\n2. Mago\n3. Arqueiro\n4. Paladino");
        System.out.print("Opção: ");
        int escolhaClasse = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o nome do seu herói: ");
        String nomeHeroi = scanner.nextLine();
        switch (escolhaClasse) {
            case 1: return new Guerreiro(nomeHeroi, 14, 18, 16, 10, 12, 9, 1, 0);
            case 2: return new Mago(nomeHeroi, 10, 9, 14, 18, 16, 12, 1, 0);
            case 3: return new Arqueiro(nomeHeroi, 18, 14, 12, 10, 16, 9, 1, 0);
            case 4: return new Paladino(nomeHeroi, 12, 16, 15, 13, 18, 14, 1, 0);
            default: return new Guerreiro(nomeHeroi, 14, 18, 16, 10, 12, 9, 1, 0);
        }
    }

    private static boolean processarAcao(String acao, Heroi heroi, Scanner scanner) {
        String[] partes = acao.split(":");
        if (partes[0].equals("BATALHA")) {
            Personagem inimigo = null;
            if (partes[1].equals("IniGoblin")) {
                inimigo = new IniGoblin("Goblin Batedor", 16, 12, 10, 8, 10, 8);
            } else if (partes[1].equals("IniOgro")) {
                inimigo = new IniOgro("Ogro Guarda-Ponte", 10, 18, 18, 6, 8, 6);
            }

            if (inimigo != null) {
                pressioneParaContinuar(scanner);
                Batalha batalha = new Batalha(heroi, inimigo);
                batalha.iniciarBatalha();
                return heroi.isAlive();
            }
        }
        return true;
    }
    
    private static void pressioneParaContinuar(Scanner scanner) {
        System.out.println("\n(Pressione Enter para continuar...)");
        scanner.nextLine();
    }

    private static void limparTela() {
        for (int i = 0; i < 1; i++) {
            System.out.println();
        }
    }
}