/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package graph;

import java.util.*;

/**
 * An implementation of Graph.
 * 
 * <p>PS2 instructions: you MUST use the provided rep.
 */
public class ConcreteEdgesGraph<L> implements Graph<L> {
    
    private final Set<L> vertices = new HashSet<>();
    private final List<Edge<L>> edges = new ArrayList<>();

    
    // Abstraction function:
    //   TODO
    // Representation invariant:
    //   TODO
    // Safety from rep exposure:
    //   TODO
    
    // TODO constructor

    public ConcreteEdgesGraph() {}

    // TODO checkRep
    private void checkRep(){
        Set<L> edgeVertices = new HashSet<>();
        for (Edge<L> edge : edges) {
            assert edge.getWeight() >= 0;
            edgeVertices.add(edge.getSource());
            edgeVertices.add(edge.getTarget());
        }
        assert vertices.containsAll(edgeVertices);
    }
    
    @Override
    public boolean add(L vertex) {
        if(!vertices.contains(vertex)){
            vertices.add(vertex);
            // checkRep
            checkRep();
            return true;
        }else{
            return false;
        }
//        throw new RuntimeException("not implemented");
    }
    
    @Override
    public int set(L source, L target, int weight) {
        if(weight < 0){
            throw new IllegalArgumentException("weight must be non-negative value");
        }

        int idx;
        // add vertex
        if(!vertices.contains(source)){
            vertices.add(source);
        }
        if(!vertices.contains(target)){
            vertices.add(target);
        }

        // check if edge exists
        for(idx = 0;idx < edges.size(); idx++){
            if(edges.get(idx).getSource().equals(source) &&
            edges.get(idx).getTarget().equals(target)){
                break;
            }
        }

        // the edge does not exist
        if(idx == edges.size() || idx == -1){
            edges.add(new Edge<>(source,target,weight));
        }

        // the edge exists
        int preWeight = edges.get(idx).getWeight();
        edges.set(idx,new Edge<>(source,target,weight));

        // check Rep
        checkRep();
        return preWeight;
    }
    
    @Override public boolean remove(L vertex) {
        if(vertex == null){
            throw new IllegalArgumentException("vertex should not be null");
        }

        // remove these vertexes
        if(vertices.contains(vertex)){
            vertices.remove(vertex);
        }else{
            return false;
        }

        // remove edge
        for(Edge edge:edges){
            if(edge.getSource().equals(vertex) || edge.getTarget().equals(vertex)){
                edges.remove(edge);
            }
        }
        return true;
    }
    
    @Override public Set<L> vertices() {
        Set<L> hashset=new HashSet<>();
        for(L vertex:vertices){
            hashset.add(vertex);
        }
        return hashset;
    }
    
    @Override public Map<L, Integer> sources(L target) {
        Map<L,Integer> source=new HashMap<>();
        for(Edge edge:edges){
            if(edge.getTarget().equals(target)){
                source.put((L)edge.getSource(),edge.getWeight());
            }
        }
        return source;
    }
    
    @Override public Map<L, Integer> targets(L source) {
        Map<L,Integer> target=new HashMap<>();
        for(Edge edge:edges){
            if(edge.getSource().equals(source)){
                target.put((L)edge.getTarget(),edge.getWeight());
            }
        }
        return target;
    }
    
    // TODO toString()
    @Override
    public String toString() {
        return "ConcreteEdgesGraph{" +
                "vertices=" + vertices +
                ", edges=" + edges +
                '}';
    }
}

/**
 * TODO specification
 * Immutable.
 * This class is internal to the rep of ConcreteEdgesGraph.
 * 
 * <p>PS2 instructions: the specification and implementation of this class is
 * up to you.
 */
class Edge<L> {
    
    // TODO fields
    private L source;
    private L target;
    private int weight;

    // Abstraction function:
    //   TODO
    // Representation invariant:
    //   TODO
    // Safety from rep exposure:
    //   TODO
    
    // TODO constructor

    public Edge(L source, L target, int weight) {
        if(source == null || target == null || weight < 0){
            throw new IllegalArgumentException("from and to can not be null and w must be non-negative!");
        }
        this.source = source;
        this.target = target;
        this.weight = weight;
        checkRep();
    }

    // TODO checkRep
    private void checkRep(){
        assert this.source != null && this.target != null && this.weight >= 0: "source and target must be non-null string";
    }
    
    // TODO methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?> edge = (Edge<?>) o;
        return weight == edge.weight && Objects.equals(source, edge.source) && Objects.equals(target, edge.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, target, weight);
    }

    // TODO toString()
    @Override
    public String toString() {
        return "Edge{" +
                "source=" + source +
                ", target=" + target +
                ", weight=" + weight +
                '}';
    }

    public L getSource() {
        return source;
    }

    public void setSource(L source) {
        this.source = source;
    }

    public L getTarget() {
        return target;
    }

    public void setTarget(L target) {
        this.target = target;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
