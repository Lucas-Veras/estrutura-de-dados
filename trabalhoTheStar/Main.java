package trabalhoTheStar;
import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws MazeException {
		try {
            File file = new File("C:\\labirinto.dat");
            BufferedReader br = new BufferedReader(new FileReader(file));
            ArrayList<ArrayList<String>> matriz = new ArrayList<ArrayList<String>>();
            
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
            int[][] matrizAStarAndPrintSolution = new int[rows][cols];
            int[][] matrizForDijkstra = new int[rows][cols];
            
        	for (int i = 0; i < rows; i++) {
        		for (int j = 0; j < cols; j++) {
        			matrizAStarAndPrintSolution[i][j] = Integer.parseInt(matriz.get(i).get(j));
        			matrizForDijkstra[i][j] = Integer.parseInt(matriz.get(i).get(j));
        		}
    		}
        	
        	System.out.println("-- Matriz inicial --");
        	
        	for (int i = 0; i < matrizAStarAndPrintSolution.length; i++) {
                for (int j = 0; j < matrizAStarAndPrintSolution[i].length; j++) {
                    System.out.print(matrizAStarAndPrintSolution[i][j] + " ");
                }
                System.out.println();
            }
        	
        	System.out.println();
        	
        	long startTime = System.currentTimeMillis();
        	aStar(matrizAStarAndPrintSolution, 2, 1, 5, 9);       	
        	long endTime = System.currentTimeMillis();
 
        	System.out.println("Tempo gasto: " + (endTime - startTime) + "ms");
        	System.out.println();
        	
        	long startTime2 = System.currentTimeMillis();
        	int[][] dist = dijkstra(matrizForDijkstra, 2, 1, 5, 9);
        	printPathDijkstra(matrizForDijkstra, dist, 2, 1, 5, 9);
        	long endTime2 = System.currentTimeMillis();
        	
        	System.out.println("Tempo gasto: " + (endTime2 - startTime2) + "ms");
        	System.out.println();
        	
        	
        	System.out.println("Caminho encontrado!");
        	for (int i = 0; i < matrizAStarAndPrintSolution.length; i++) {
                 for (int j = 0; j < matrizAStarAndPrintSolution[i].length; j++) {
                	 if (matrizAStarAndPrintSolution[i][j] == 9) {
                		 System.out.print("* ");
                	 }else {
                		 System.out.print(matrizAStarAndPrintSolution[i][j] + " ");
                	 }
                     
                 }
                 System.out.println();
             }
      
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void aStar(int[][] matrix, int startX, int startY, int endX, int endY) throws MazeException {
	    PriorityQueue<NodeStar> openList = new PriorityQueue<>((NodeStar n1, NodeStar n2) -> n1.f - n2.f);
	    boolean[][] closedList = new boolean[matrix.length][matrix[0].length];
	    NodeStar startNode = new NodeStar(startX, startY, 0,(int) euclideanDistance(startX, startY, endX, endY), null);
	    openList.add(startNode);
	    
	    if(matrix[startX][startY] != 2) {
	    	throw new MazeException("A coordenada inicial não corresponde ao valor 2 (Ponto de partida)");
	    }
	    else if (matrix[endX][endY] != 3) {
	    	throw new MazeException("A coordenada final não corresponde ao valor 3 (Ponto de saída)");
	    }

	    while (!openList.isEmpty()) {
	        NodeStar currentNode = openList.poll();
	        closedList[currentNode.x][currentNode.y] = true;

	        if (currentNode.x == endX && currentNode.y == endY) {
	        	System.out.println("-- Algoritmo A* --");
	        	System.out.println("Menor caminho do Node "+ "("+startX+","+startY+")" +" para " + "("+endX+","+endY+"):");
	            printPath(currentNode, matrix);
	            return;
	        }

	        for (int i = -1; i <= 1; i++) {
	            for (int j = -1; j <= 1; j++) {
	                if (i == 0 && j == 0) {
	                    continue;
	                }
	                int x = currentNode.x + i;
	                int y = currentNode.y + j;
	                if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) {
	                    continue;
	                }
	                if (matrix[x][y] == 0 || closedList[x][y]) {
	                    continue;
	                }
	                int g = currentNode.g + 1;
	                int h = (int) euclideanDistance(x, y, endX, endY);
	                NodeStar neighbor = new NodeStar(x, y, g, h, currentNode);
	                if (!openList.contains(neighbor)) {
	                    openList.add(neighbor);
	                }
	            }
	        }
	    }
	    System.out.println("Node final não foi encontrado!");
	}

	private static double euclideanDistance(int x1, int y1, int x2, int y2) {
	    return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

	private static void printPath(NodeStar endNode, int[][] matrix) {
	    StringBuilder path = new StringBuilder();
	    NodeStar current = endNode;
	    

	    while (current != null) {
	        path.insert(0, "(" + current.x + "," + current.y + ") <- ");
	        matrix[current.x][current.y] = 9;
	        current = current.parent;
	    }

	    path.append("Começo");
	    System.out.println(path);
	}
	
	public static int[][] dijkstra(int[][] matriz, int startX, int startY, int endX, int endY) throws MazeException {
	    int rows = matriz.length;
	    int cols = matriz[0].length;
	    int[][] dist = new int[rows][cols];
	    boolean[][] visited = new boolean[rows][cols];
	    PriorityQueue<NodeForDijkstra> queue = new PriorityQueue<>();
	 
	    if(matriz[startX][startY] != 2) {
	    	throw new MazeException("A coordenada inicial não corresponde ao valor 2 (Ponto de partida)");
	    }
	    else if (matriz[endX][endY] != 3) {
	    	throw new MazeException("A coordenada final não corresponde ao valor 3 (Ponto de saída)");
	    }
	    
	    // Initialize distance and visited arrays
	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < cols; j++) {
	            dist[i][j] = Integer.MAX_VALUE;
	            visited[i][j] = false;
	        }
	    }

	    // Add starting node to queue and set distance to 0
	    queue.add(new NodeForDijkstra(startX, startY, 0));
	    dist[startX][startY] = 0;

	    // Loop until queue is empty
	    while (!queue.isEmpty()) {
	    	NodeForDijkstra curr = queue.poll();

	        // Mark current node as visited
	        visited[curr.x][curr.y] = true;

	        // Check neighbors of current node
	        for (int i = -1; i <= 1; i++) {
	            for (int j = -1; j <= 1; j++) {
	                if (i == 0 && j == 0) continue; // Skip current node
	                if (curr.x + i < 0 || curr.x + i >= rows || curr.y + j < 0 || curr.y + j >= cols) continue; // Skip out of bounds nodes
	                if (matriz[curr.x + i][curr.y + j] == 0) continue; // Skip walls
	                if (visited[curr.x + i][curr.y + j]) continue; // Skip visited nodes

	                // Update distance if a shorter path is found
	                int newDist = dist[curr.x][curr.y] + 1;
	                if (newDist < dist[curr.x + i][curr.y + j]) {
	                    dist[curr.x + i][curr.y + j] = newDist;
	                    queue.add(new NodeForDijkstra(curr.x + i, curr.y + j, newDist));
	                }
	            }
	        }
	    }
	    // print the shortest distance from start to end
	    //System.out.println("The shortest distance from ("+startX+","+startY+") to ("+endX+","+endY+") is : " + dist[endX][endY]);
	    return dist;
	}
	
	public static void printPathDijkstra(int[][] matriz, int[][] dist, int startX, int startY, int endX, int endY) {
	    ArrayList<NodeForDijkstra> path = new ArrayList<>();
	    path.add(new NodeForDijkstra(endX, endY, dist[endX][endY]));
	    int currX = endX;
	    int currY = endY;

	    while (currX != startX || currY != startY) {
	        int minDist = Integer.MAX_VALUE;
	        int minX = 0;
	        int minY = 0;

	        // Check neighbors of current node
	        for (int i = -1; i <= 1; i++) {
	            for (int j = -1; j <= 1; j++) {
	                if (i == 0 && j == 0) continue; // Skip current node
	                if (currX + i < 0 || currX + i >= matriz.length || currY + j < 0 || currY + j >= matriz[0].length) continue; // Skip out of bounds nodes
	                if (matriz[currX + i][currY + j] == 0) continue; // Skip walls
	                if (dist[currX + i][currY + j] < minDist) {
	                    minDist = dist[currX + i][currY + j];
	                    minX = currX + i;
	                    minY = currY + j;
	                }
	            }
	        }

	        currX = minX;
	        currY = minY;
	        path.add(new NodeForDijkstra(currX, currY, minDist));
	    }
	    System.out.println("-- Algoritmo de Dijkstra --");
	    System.out.println("Menor caminho do Node ("+startX+","+startY+") para ("+endX+","+endY+"): ");
	    for (int i = path.size()-1; i >= 0; i--) {
	        System.out.print("(" + path.get(i).x + "," + path.get(i).y + ") <- ");
	    }
	    System.out.print("Começo");
	    System.out.println();
	}
}
