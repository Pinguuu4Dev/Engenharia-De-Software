package Componentes_Principais;

import Entidades.*;
import Itens.*;

import java.io.*;

public class Mapa {
    private char matriz[][];
    private int numLinhas;
    private int numColunas;

    private Heroi heroi;

    Mapa(String nomeArquivo, int linhas, int colunas){

        numLinhas = linhas;
        numColunas = colunas;
        this.heroi = new Heroi(1,2,3);
        this.matriz = new char[linhas][colunas];

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))){
            int c;
            int i = 0, j = 0;

            while((c = br.read()) != -1 && i < linhas){
                if(c == '\n' || c == '\r'){
                    continue;
                }
                this.matriz[i][j] = (char) c; //Cast
                j++;
                if (j == colunas){
                    j = 0;
                    i++;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void alocaMatriz(){
        this.matriz = new char[this.numLinhas][this.numColunas];
    }

    public void imprimeMapa(int x, int y){
        for (int i = 0; i < this.numLinhas; i++){
            for (int j = 0; j < this.numColunas; j++){
                System.out.println(this.matriz[i][j]);
            }
        }
    }

    public boolean encontraSaida(int x, int y){
        if (this.heroi.getVida() <= 0) {
            return false;
        }

        switch(this.matriz[x][y]){

            case '=':
                return true;

            // --- Encontros (Combate) ---

            case '?':   // Batalha com Bicho Papão
                Bicho_Papao bichoPapao = new Bicho_Papao(2, 2, 5);
                break;
            case '*':   // Batalha com Curupira
                Curupira curupira = new Curupira(3, 1, 3);
                break;


            // --- Encontros (Ajudantes) ---

            case '^':   // Interage com Duente
                Duende duende = new Duende();
                break;
            case '&':   // Interage com Anão
                Anao anao = new Anao();
                break;


            // --- Equipamentos ---

            case 'e':   // Encontra espada
                Espada espada = new Espada(BonusItem.Bonus_Espada);
            case 'd':   // Encontra escudo
                Escudo escudo = new Escudo(BonusItem.Bonus_Escudo);
            case 'c':   // Encontra cura
                Cura cura = new Cura(BonusItem.Bonus_Cura);
        }

        // Atualiza posição atual do jogador;
        this.matriz[y][x] = '○';

        // Imprime o mapa
        this.imprimeMapa(x, y);

        // Fazer com que a tela atualize em intervalos
        try{
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

        // Backtracking
        // Política de Visitas:
            //1. Vou para a direita
            //2. Vou para baixo
            //3. Vou para esquerda
            //4. Vou para cima

        // 1
        if (this.matriz[x+1][y] != '#' && this.matriz[x+1][y] != '•'){
            this.matriz[y][x] = '•';

            if(encontraSaida(x+1, y) == true)
                return true;
        }

        if (this.matriz[x][y+1] != '#' && this.matriz[x][y+1] != '•'){
            this.matriz[y][x] = '•';

            if(encontraSaida(x, y+1) == true){
                return true;
            }
        }

        if (this.matriz[x-1][y] != '#' && this.matriz[x-1][y] != '•'){
            this.matriz[y][x] = '•';

            if(encontraSaida(x-1, y) == true){
                return true;
            }
        }

        if (this.matriz[x][y-1] != '#' && this.matriz[x][y-1] != '•'){
            this.matriz[y][x] = '•';

            if(encontraSaida(x, y+1) == true){
                return true;
            }
        }

        System.out.println("Não encontrou saída");
        return false;
    }
}
