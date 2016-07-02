import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Graph {
	static ArrayList<Node> nodes = new ArrayList<Node>();
	
	public static void main(String[] args) {
		
		
		Scanner s = new Scanner(System.in);
		String[] nodesName = s.nextLine().split(" ");
		
		for (int i=0; i< nodesName.length; i++) {
			Node temporary = new Node(nodesName[i]); 
			nodes.add(temporary);
		}
		
		
		String starter = s.nextLine();
		
		String lines = s.nextLine();
		
		//read input
		while (!lines.equals("***")){
			String[] input = lines.split(" ");
			Node firstNode = giveNodebyName(input[0]);
			Node secondNode = giveNodebyName(input[1]);
			secondNode.addNeigbor(firstNode);
			firstNode.addNeigbor(secondNode);
			lines = s.nextLine();
		}
		
		//print neighbors of each node
		System.out.println("Node Neighbors:");
		
		for(int i = 0; i < nodes.size(); i++){
			Node node = nodes.get(i);
			
			Collections.sort(node.neighbors);
			
			System.out.print(node.name + ":");
			for(int j = 0; j < node.neighbors.size(); j++){
				Node neighbor = node.neighbors.get(j);
				System.out.print(" " + neighbor.name);
			}
			System.out.println();
		}
		System.out.println();
		
		//Depth-First Search:
		Node first = giveNodebyName(starter);
		System.out.println("Depth-First Search:");
		depthFirst(nodes,first);
		
		// Reset them as not visited
		for(Node n: nodes){
			n.visited = false;
		}
		
		System.out.println();
		
		// Breadth-First Search:
		System.out.println("Breadth-First Search");
		breadthFirst(nodes,first);
		
	}
	
	//breadth-First
	public static void breadthFirst(ArrayList<Node> g, Node a){
		LinkedList<Node> queue = new LinkedList<>();
		
		a.visited = true;
		System.out.print(a.name + " ");
		queue.add(a);
		
		while(!queue.isEmpty()){
			for(Node node: queue.getFirst().neighbors){
				if(!node.visited){
					node.visited = true;
					System.out.print(node.name + " ");
					queue.add(node);
				}
			}
			queue.remove();
		}
	}
	
	//depth first
	public static void depthFirst(ArrayList<Node> n, Node a) {
		a.visited = true;
		System.out.print(a.name+" ");
		for (Node no: a.neighbors) {
			if (no.visited == false) {
				depthFirst(nodes, no);
			}
		}
	}
	
	//get node using name
	public static Node giveNodebyName(String name){
		for (int i=0; i< nodes.size(); i++){
			Node node = nodes.get(i);
			
			if (node.name.equals(name)){
			  return node;
			}
		}
		return null;
	}
}


