package controller;

import br.edu.fateczl.pilhaString.Pilha;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import model.Lista;

public class FifaController implements IFifaController {

    Pilha pilha = new Pilha();

    public FifaController() {
        super();
    }

    @Override
    public Pilha empilhaBrasileiros(String caminho, String nome) throws IOException {
        File arq = new File(caminho, nome);
        if (arq.exists() && arq.isFile()) {
            FileInputStream fluxo = new FileInputStream(arq);
            InputStreamReader leitor = new InputStreamReader(fluxo);
            BufferedReader buffer = new BufferedReader(leitor);
            String linha;
            while ((linha = buffer.readLine()) != null) {
                String[] partes = linha.split(",");
                String nacionalidade = partes[5];
                if (nacionalidade.equals("Brazil")) {
                    pilha.push(linha);
                }
            }
            buffer.close();
            leitor.close();
            fluxo.close();
        }
        return pilha;
    }

    @Override
    public void desempilhaBonsBrasileiros(Pilha pilha) throws IOException {
        while (!pilha.isEmpty()) {
            try {
                String info = pilha.pop();
                String[] partes = info.split(",");
                int overall = Integer.parseInt(partes[7]);
                if (overall > 80) {
                    String nome = partes[2];
                    System.out.println("Nome: " + nome + ", Overall: " + overall);
                }
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    @Override
    public Lista<String> listaRevelacoes(String caminho, String nome) throws IOException {
        Lista<String> lista = new Lista<>();
        File arq = new File(caminho, nome);
        if (arq.exists() && arq.isFile()) {
            FileInputStream fluxo = new FileInputStream(arq);
            InputStreamReader leitor = new InputStreamReader(fluxo);
            BufferedReader buffer = new BufferedReader(leitor);
            String linha;
            buffer.readLine();
            int passo = 0;
            while ((linha = buffer.readLine()) != null) {
                String[] partes = linha.split(",");
                int idade = Integer.parseInt(partes[3]);
                if (idade <= 20) {
                    try {
                        if (passo == 0) {
                            lista.addFirst(linha);
                            passo += 1;
                        }
                        lista.addLast(linha);
                    } catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }
                }
            }
            buffer.close();
            leitor.close();
            fluxo.close();
        }
        return lista;
    }

    @Override
    public void buscaListaBonsJovens(Lista<String> lista) throws IOException {
        for (int i = lista.size() - 1; i >= 0; i--) {
            try {
                String info = lista.get(i);
                String[] partes = info.split(",");
                int overall = Integer.parseInt(partes[7]);
                int idade = Integer.parseInt(partes[3]);
                if (overall > 80 && idade <= 20) {
                    String nome = partes[2];
                    System.out.println("Nome: " + nome + ", Idade: " + idade + ", Overall: " + overall);
                }
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

}
