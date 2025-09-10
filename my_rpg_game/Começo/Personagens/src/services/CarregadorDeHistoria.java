package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import story.Historia;
import java.io.File;
import java.io.IOException;

public class CarregadorDeHistoria {
    public static Historia carregarHistoria(String caminhoDoArquivo) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(caminhoDoArquivo), Historia.class);
        } catch (IOException e) {
            // Se der algum erro na leitura do arquivo, mostra uma mensagem clara no console
            System.err.println("Erro ao carregar o arquivo de história: " + e.getMessage());
            e.printStackTrace(); // Mostra mais detalhes técnicos do erro
            return null;
        }
    }
}