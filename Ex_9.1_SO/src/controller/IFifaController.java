
package controller;

import java.io.IOException;
import br.edu.fateczl.pilhaString.Pilha;
import model.Lista;

public interface IFifaController {
    
    public Pilha empilhaBrasileiros(String caminho, String nome) throws IOException;
    public void desempilhaBonsBrasileiros(Pilha pilha) throws IOException;
    public Lista<String> listaRevelacoes(String caminho, String nome) throws IOException;
    public void buscaListaBonsJovens(Lista<String> lista) throws IOException;
}
