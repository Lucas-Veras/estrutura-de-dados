package aStar;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;


class NoStar {
    int x;
    int y;
    int g;
    int h;
    int f;
    NoStar parent;

    public NoStar(int x, int y, int g, int h, NoStar parent) {
        this.x = x;
        this.y = y;
        this.g = g;
        this.h = h;
        this.f = g + h;
        this.parent = parent;
    }
}

class NodeForDijkstra implements Comparable<NodeForDijkstra> {
    int x;
    int y;
    int dist;
    public NodeForDijkstra(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public int compareTo(NodeForDijkstra other) {
        return this.dist - other.dist;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\labirinto.dat");
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<ArrayList<String>> matriz = new ArrayList<>();

        String line;
        int auxline = 0;

        while ((line = br.readLine()) != null) {
            String[] values = line.split("");
            matriz.add(new ArrayList<String>());
            for (String value : values) {
                matriz.get(auxline).add(value);
            }
            auxline++;
        }

        int rows = matriz.size();
        int cols = matriz.get(0).size();
        int[][] matrizDijskstra = new int[rows][cols];
        int[][] matrizAstar = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrizAstar[i][j] = Integer.parseInt(matriz.get(i).get(j));
                matrizDijskstra[i][j] = Integer.parseInt(matriz.get(i).get(j));
            }
        }

        System.out.println("\n---->> Matriz inicial <<----");

        for (int i = 0; i < matrizDijskstra.length; i++) {
            for (int j = 0; j < matrizDijskstra[i].length; j++) {
                System.out.print(matrizDijskstra[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("****** A* ******\n");
        System.out.println("Caminho do Node (2,1) para (5,9): ");

        long startTime = System.currentTimeMillis();
        aStar(matrizAstar, 2, 1, 5, 9);
        long endTime = System.currentTimeMillis();

        System.out.println("Tempo gasto: " + (endTime - startTime) + "ms\n");

        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("---->> DIJSKSTRA <<----\n");
        System.out.println("Caminho do Node (2,1) para (5,9): ");
        long startTime2 = System.currentTimeMillis();
        dijkstra(matrizDijskstra, 2, 1, 5, 9);
        long endTime2 = System.currentTimeMillis();

        System.out.println();
        System.out.println("Tempo gasto: " + (endTime2 - startTime2) + "ms");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");

        System.out.println("* => MenorCaminho");
        for (int i = 0; i < matrizDijskstra.length; i++) {
            for (int j = 0; j < matrizDijskstra[i].length; j++) {
            	if (matrizDijskstra[i][j] == 7) {
            		System.out.print("* ");
            	} else {
            		System.out.print(matrizDijskstra[i][j] + " ");	
            	}
            }
            System.out.println();
        }

        br.close();

    }
// A ESTRELA ----------------------------------------------------------------------------------------------
    public static void aStar(int[][] matriz, int inicioX, int inicioY, int fimX, int fimY) {
        PriorityQueue<NoStar> naoVisitados = new PriorityQueue<>((NoStar n1, NoStar n2) -> {
            return n1.f - n2.f;
        });
        Set<NoStar> visitados = new HashSet<>();
        NoStar inicio = new NoStar(inicioX, inicioY, 0, 0, null);
        naoVisitados.add(inicio);

        while (!naoVisitados.isEmpty()) {
            NoStar atual = naoVisitados.poll();
            visitados.add(atual);

            if (atual.x == fimX && atual.y == fimY) {
                System.out.println("Node final encontrado!");
                mostrarAstar(atual, matriz);
                return;
            }

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    int x = atual.x + i;
                    int y = atual.y + j;
                    if (x < 0 || x >= matriz.length || y < 0 || y >= matriz[0].length) {
                        continue;
                    }
                    if (matriz[x][y] == 1 || visitados.contains(new NoStar(x, y, 0, 0, null))) {
                        continue;
                    }
                    int g = atual.g + 1;
                    int h = Math.abs(fimX - x) + Math.abs(fimY - y);
                    NoStar neighbor = new NoStar(x, y, g, h, atual);
                    naoVisitados.add(neighbor);

                }
            }
        }
        System.out.println("Node final não encontrado!");
    }

    private static void mostrarAstar(NoStar fim, int[][] matriz) {
        NoStar atual = fim;

        while (atual != null) {
            System.out.print("(" + atual.x + "," + atual.y + ") <- ");
            matriz[atual.x][atual.y] = 7;
            atual = atual.parent;

        }
        System.out.println("Começo");

        System.out.println();
    }
// ----------------------------------------------------------------------------------------------
// dijstra ----------------------------------------------------------------------------------------------

    public static void dijkstra(int[][] matriz, int inicioX, int inicioY, int fimX, int fimY) {
        int rows = matriz.length;
        int cols = matriz[0].length;
        int[][] distancia = new int[rows][cols];
        boolean[][] visitados = new boolean[rows][cols];
        PriorityQueue<NodeForDijkstra> queue = new PriorityQueue<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                distancia[i][j] = Integer.MAX_VALUE;
                visitados[i][j] = false;
            }
        }

        queue.add(new NodeForDijkstra(inicioX, inicioY, 0));
        distancia[inicioX][inicioY] = 0;

        while (!queue.isEmpty()) {
            NodeForDijkstra curr = queue.poll();

            visitados[curr.x][curr.y] = true;

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue;
                    if (curr.x + i < 0 || curr.x + i >= rows || curr.y + j < 0 || curr.y + j >= cols) continue; 
                    if (matriz[curr.x + i][curr.y + j] == 1) continue;
                    if (visitados[curr.x + i][curr.y + j]) continue; 

                    int novaDistancia = distancia[curr.x][curr.y] + 1;
                    if (novaDistancia < distancia[curr.x + i][curr.y + j]) {
                        distancia[curr.x + i][curr.y + j] = novaDistancia;
                        queue.add(new NodeForDijkstra(curr.x + i, curr.y + j, novaDistancia));
                    }
                }
            }
        }
        mostrarDijkstra(matriz, distancia, inicioX, inicioY, fimX, fimY);
    }

    public static void mostrarDijkstra(int[][] matriz, int[][] distancia, int inicioX, int inicioY, int fimX, int fimY) {
        int atualX = fimX;
        int atualY = fimY;

        while (atualX != inicioX || atualY != inicioY) {
            int minDist = Integer.MAX_VALUE;
            int minX = 0;
            int minY = 0;

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue; 
                    if (atualX + i < 0 || atualX + i >= matriz.length || atualY + j < 0 || atualY + j >= matriz[0].length) continue; 
                    if (matriz[atualX + i][atualY + j] == 1) continue; 
                    if (distancia[atualX + i][atualY + j] < minDist) {
                        minDist = distancia[atualX + i][atualY + j];
                        minX = atualX + i;
                        minY = atualY + j;
                    }
                }
            }

            atualX = minX;
            atualY = minY;
            System.out.print("(" + atualX + "," + atualY + ") <- ");
            matriz[atualX][atualY] = 7;
        }
        System.out.println("Começo");
        System.out.println();
    }
}

