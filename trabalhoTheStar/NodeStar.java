package trabalhoTheStar;

public class NodeStar {
	int x, y, g, h, f;
    NodeStar parent;

    public NodeStar(int x, int y, int g, int h, NodeStar parent) {
        this.x = x;
        this.y = y;
        this.g = g;
        this.h = h;
        this.f = g + h;
        this.parent = parent;
    }
}
