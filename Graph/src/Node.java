import java.util.ArrayList;
import java.util.List;


public class Node implements Comparable<Node>{
	
	String name;
	List<Node> neighbors = new ArrayList<Node>();
	public boolean visited;
	
	public Node(String n){
		name = n;
		visited = false;
	}
	
	//add a node to neighbor
	public void addNeigbor(Node newNeighbor){
		neighbors.add(newNeighbor);
	}

	@Override
	public int compareTo(Node other) {
		return name.compareTo(other.name);
	}
	
}
