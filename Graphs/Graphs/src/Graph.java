import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * This class models a simple, undirected graph using an 
 * incidence list representation. Vertices are identified 
 * uniquely by their labels, and only unique vertices are allowed.
 * At most one Edge per vertex pair is allowed in this Graph.
 * 
 * Note that the Graph is designed to manage the Edges. You
 * should not attempt to manually add Edges yourself.
 * 
 * @author Michael Levet
 * @date June 09, 2015
 */
public class Graph {
    
    public HashMap<String, Vertex> vertices;
    private HashMap<Integer, Edge> edges;
    
    public Graph(){
        this.vertices = new HashMap<String, Vertex>();
        this.edges = new HashMap<Integer, Edge>();
    }
    
    /**
     * This constructor accepts an ArrayList<Vertex> and populates
     * this.vertices. If multiple Vertex objects have the same label,
     * then the last Vertex with the given label is used. 
     * 
     * @param vertices The initial Vertices to populate this Graph
     */
    public Graph(ArrayList<Vertex> vertices){
        this.vertices = new HashMap<String, Vertex>();
        this.edges = new HashMap<Integer, Edge>();
        
        for(Vertex v: vertices){
            this.vertices.put(v.getLabel(), v);
        }
        
    }
    
    /**
     * 
     * This constructor is create new Graph base on file
     * @param delimiter 
     */
    public Graph(String filename, String delimiter) {
        this.vertices = new HashMap<String, Vertex>();
        this.edges = new HashMap<Integer, Edge>();
        FileReader f;
        try {
            f = new FileReader(filename);
            BufferedReader br = new BufferedReader(f);
            String line;
            while (true) {
                try {
                    line = br.readLine();
//                    if(line != null){
//                        System.out.println(line);
//                    }
                    if (line == null) // end of file
                    {
                        break;
                    }
                    String[] parameters = line.split(delimiter);
                    validateEdge(parameters[0], parameters[1], Integer.parseInt(parameters[2]));
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }
    
    /**
     * This method adds am edge between Vertices one and two
     * of weight 1, if no Edge between these Vertices already
     * exists in the Graph.
     * 
     * @param one The first vertex to add
     * @param two The second vertex to add
     * @return true iff no Edge relating one and two exists in the Graph
     */
    public boolean addEdge(Vertex one, Vertex two){
        return addEdge(one, two, 1);
    }
    
    
    /**
     * Accepts two vertices and a weight, and adds the edge 
     * ({one, two}, weight) iff no Edge relating one and two 
     * exists in the Graph.
     * 
     * @param one The first Vertex of the Edge
     * @param two The second Vertex of the Edge
     * @param weight The weight of the Edge
     * @return true iff no Edge already exists in the Graph
     */
    public boolean addEdge(Vertex one, Vertex two, int weight){
        if(one.equals(two)){
            return false;   
        }
       
        //ensures the Edge is not in the Graph
        Edge e = new Edge(one, two, weight);
        if(edges.containsKey(e.hashCode())){
            return false;
        }
       
        //and that the Edge isn't already incident to one of the vertices
        else if(one.containsNeighbor(e) || two.containsNeighbor(e)){
            return false;
        }
            
        edges.put(e.hashCode(), e);
        one.addNeighbor(e);
        two.addNeighbor(e);
        return true;
    }
    
    
    private void validateEdge(String one, String two, int weight){
        if(!containsVertex(one)){
            addVertex(new Vertex(one), true);
        }
        if(!containsVertex(two)){
            addVertex(new Vertex(two), true);
        }
        addEdge(this.vertices.get(one), this.vertices.get(two), weight);
    }
    /**
     * 
     * @param e The Edge to look up
     * @return true iff this Graph contains the Edge e
     */
    public boolean containsEdge(Edge e){
        if(e.getOne() == null || e.getTwo() == null){
            return false;
        }
        
        return this.edges.containsKey(e.hashCode());
    }
    
    
    /**
     * This method removes the specified Edge from the Graph,
     * including as each vertex's incidence neighborhood.
     * 
     * @param e The Edge to remove from the Graph
     * @return Edge The Edge removed from the Graph
     */
    public Edge removeEdge(Edge e){
       e.getOne().removeNeighbor(e);
       e.getTwo().removeNeighbor(e);
       return this.edges.remove(e.hashCode());
    }
    
    /**
     * 
     * @param vertex The Vertex to look up
     * @return true iff this Graph contains vertex
     */
    public boolean containsVertex(Vertex vertex){
        return this.vertices.get(vertex.getLabel()) != null;
    }
    
    public boolean containsVertex(String vertex){
        if(this.vertices.isEmpty())
            return false;
        return this.vertices.containsKey(vertex);
    }
    /**
     * 
     * @param label The specified Vertex label
     * @return Vertex The Vertex with the specified label
     */
    public Vertex getVertex(String label){
        return vertices.get(label);
    }
    
    /**
     * This method adds a Vertex to the graph. If a Vertex with the same label
     * as the parameter exists in the Graph, the existing Vertex is overwritten
     * only if overwriteExisting is true. If the existing Vertex is overwritten,
     * the Edges incident to it are all removed from the Graph.
     * 
     * @param vertex
     * @param overwriteExisting
     * @return true iff vertex was added to the Graph
     */
    public boolean addVertex(Vertex vertex, boolean overwriteExisting){
        Vertex current = this.vertices.get(vertex.getLabel());
        if(current != null){
            if(!overwriteExisting){
                return false;
            }
            
            while(current.getNeighborCount() > 0){
                this.removeEdge(current.getNeighbor(0));
            }
        }
        
        
        vertices.put(vertex.getLabel(), vertex);
        return true;
    }
    
    /**
     * 
     * @param label The label of the Vertex to remove
     * @return Vertex The removed Vertex object
     */
    public Vertex removeVertex(String label){
        Vertex v = vertices.remove(label);
        
        while(v.getNeighborCount() > 0){
            this.removeEdge(v.getNeighbor((0)));
        }
        
        return v;
    }
    
    /**
     * 
     * @return Set<String> The unique labels of the Graph's Vertex objects
     */
    public Set<String> vertexKeys(){
        return this.vertices.keySet();
    }
    
    /**
     * 
     * @return Set<Edge> The Edges of this graph
     */
    public Set<Edge> getEdges(){
        return new HashSet<Edge>(this.edges.values());
    }
    
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Iterable<String> vertices = this.vertices.keySet();
        for (String v : vertices) {
            s.append(v + ": ");
            ArrayList<Edge> neighbor = this.vertices.get(v).getNeighbors();
            for (Edge w : neighbor) {
                s.append(w.getTwo() + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
    
}
