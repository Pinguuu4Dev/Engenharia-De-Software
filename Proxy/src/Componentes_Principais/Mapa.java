package Componentes_Principais;

import Entidades.*;
import Entidades.Factory.*;
import Itens.*;

import java.io.*;

public class Mapa {
    private char matriz[][];
    private int numeroLinhas;
    private int numeroColunas;

    private Heroi heroi;

    public Mapa(String nomeArquivo, int linhas, int colunas) {
        this.numeroLinhas = linhas;
        this.numeroColunas = colunas;
        this.heroi = new Heroi();
        this.matriz = new char[linhas][colunas];

        try (
                InputStream inputStream = getClass().getResourceAsStream("/" + nomeArquivo);
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))
        ) {
            if (inputStream == null) {
                throw new RuntimeException("Arquivo não encontrado no resources: " + nomeArquivo);
            }

            int c;
            int i = 0, j = 0;

            while ((c = br.read()) != -1 && i < linhas) {
                if (c == '\n' || c == '\r') continue;
                this.matriz[i][j] = (char) c;
                j++;
                if (j == colunas) {
                    j = 0;
                    i++;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void limpaConsole() {
        for (int i = 0; i < 30; i++) System.out.println();
    }


    public void imprimeMapa(int heroiX, int heroiY) {
        limpaConsole();
        for (int i = 0; i < this.numeroLinhas; i++) {
            for (int j = 0; j < this.numeroColunas; j++) {
                // Se as coordenadas (i, j) são as do herói, desenha o herói
                if (i == heroiX && j == heroiY) {
                    System.out.print('O'); // Caractere do herói
                } else {
                    // Caso contrário, desenha o que está no mapa
                    System.out.print(this.matriz[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean encontraSaida(int x, int y) {
        if (this.heroi.getVida() <= 0) {
            System.out.println("💀 O herói morreu!");
            return false;
        }

        char simbolo = this.matriz[x][y];

        SpawnService spawnService = null;

        switch (simbolo) {
            case '=':
                System.out.println("🏆 O herói encontrou a saída!");
                return true;

            // --- Monstros ---
            case '?':
                spawnService = new SpawnService(new BichoPapaoFactory());
                break;
            case '*':
                spawnService = new SpawnService(new CurupiraFactory());
                break;

            // --- Ajudantes ---
            case '^':
                spawnService = new SpawnService(new DuendeFactory());
                break;
            case '&':
                spawnService = new SpawnService(new AnaoFactory());
                break;

            // --- Itens ---
            case 'e':
                spawnService = new SpawnService(new EspadaFactory());
                break;
            case 'd':
                spawnService = new SpawnService(new EscudoFactory());
                break;
            case 'c':
                spawnService = new SpawnService(new CuraFactory());
                break;
        }

        if (spawnService != null)
            spawnService.spawn(heroi);


        // this.matriz[x][y] = '○';
        this.imprimeMapa(x, y);
        heroi.imprimirStatus();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

        // Backtracking
        if (this.matriz[x + 1][y] != '#' && this.matriz[x + 1][y] != '•') {
            this.matriz[x][y] = '•';
            if (encontraSaida(x + 1, y)) return true;
        }
        if (this.matriz[x][y + 1] != '#' && this.matriz[x][y + 1] != '•') {
            this.matriz[x][y] = '•';
            if (encontraSaida(x, y + 1)) return true;
        }
        if (this.matriz[x - 1][y] != '#' && this.matriz[x - 1][y] != '•') {
            this.matriz[x][y] = '•';
            if (encontraSaida(x - 1, y)) return true;
        }
        if (this.matriz[x][y - 1] != '#' && this.matriz[x][y - 1] != '•') {
            this.matriz[x][y] = '•';
            if (encontraSaida(x, y - 1)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Mapa mapa = new Mapa("mapa2.txt", 17, 21);
        mapa.encontraSaida(1, 1);
    }
}