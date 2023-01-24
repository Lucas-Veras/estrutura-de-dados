package trabalhoTheStar;

public class NodeForDijkstra implements Comparable<NodeForDijkstra> {
    int x, y, dist;
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
