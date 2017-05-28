/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Run;

/**
 *
 * @author USER
 */
public class Run {
    public static void main(String[] args){
//        Graph graph = new Graph();
//        Vertex[] vertices = new Vertex[6];
//        
//        for(int i = 0; i < vertices.length; i++){
//            vertices[i] = new Vertex(i + "");
//            graph.addVertex(vertices[i], true);
//        }
//        
//        Edge[] edges = new Edge[9];
//        edges[0] = new Edge(vertices[0], vertices[1], 7);
//        edges[1] = new Edge(vertices[0], vertices[2], 9);
//        edges[2] = new Edge(vertices[0], vertices[5], 14);
//        edges[3] = new Edge(vertices[1], vertices[2], 10);
//        edges[4] = new Edge(vertices[1], vertices[3], 15);
//        edges[5] = new Edge(vertices[2], vertices[3], 11);
//        edges[6] = new Edge(vertices[2], vertices[5], 2);
//        edges[7] = new Edge(vertices[3], vertices[4], 6);
//        edges[8] = new Edge(vertices[4], vertices[5], 9);
//        
//        for(Edge e: edges){
//            graph.addEdge(e.getOne(), e.getTwo(), e.getWeight());
//        }

        Graph graph = new Graph("input.txt", "[: ]");
        
        Dijkstra dijkstra = new Dijkstra(graph, graph.vertices.get("1").getLabel());
        System.out.println(dijkstra.getDistanceTo("4"));
        System.out.println(dijkstra.getPathTo("4"));
    }
}
