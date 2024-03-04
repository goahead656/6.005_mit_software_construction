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
public class ConcreteVerticesGraph<L> implements Graph<L> {
    
    private final List<Vertex<L>> vertices = new ArrayList<>();
    
    // Abstraction function:
    //   TODO
    // Representation invariant:
    //   TODO
    // Safety from rep exposure:
    //   TODO
    
    // TODO constructor

    public ConcreteVerticesGraph() {}


    // TODO checkRep
    private void checkRep(){
        assert vertices == null:"vertices is not supposed to be null";
    }
    
    @Override public boolean add(L vertex) {
        for (Vertex<L> v : vertices) {
            if (v.getLabel().equals(vertex))
                return false;
        }
        vertices.add(new Vertex<L>(vertex));
        return true;
    }
    
    @Override
    public int set(L source, L target, int weight) {
        boolean findSource = false;
        Vertex<L> s = null;
        for (Vertex<L> v : vertices) {
            if (v.getLabel().equals(source)) {
                findSource = true;
                s = v;
                break;
            }
        }
        if (!findSource) {
            s = new Vertex<L>(source);
            vertices.add(s);
        }
        return s.set(target, weight);

    }
    
    @Override public boolean remove(L vertex) {
        int idx;
        for (idx = 0; idx < vertices.size(); idx++) {
            if (vertices.get(idx).getLabel().equals(vertex)) {
                break;
            }
        }
        if (idx == vertices.size()) return false;
        vertices.remove(idx);
        for (Vertex<L> v : vertices) {
            if (v.targetAt(vertex)) {
                v.set(vertex, 0);
            }
        }
        return true;
    }
    
    @Override public Set<L> vertices() {
        Set<L> s = new HashSet<>();
        for (Vertex<L> v : vertices) {
            s.add(v.getLabel());
        }
        return s;
    }
    
    @Override public Map<L, Integer> sources(L target) {
        Map<L, Integer> s = new HashMap<>();
        for (Vertex<L> v : vertices) {
            if (v.targetAt(target)) {
                s.put(v.getLabel(), v.targetWeight(target));
            }
        }
        return s;
    }
    
    @Override public Map<L, Integer> targets(L source) {
        Map<L, Integer> t = new HashMap<>();
        Vertex<L> sourceV = null;
        for (Vertex<L> v : vertices) {
            if (v.getLabel().equals(source)){
                sourceV = v;
                break;
            }
        }
        if (sourceV == null) return t;
        Set<L> targetLabels = sourceV.targets();
        for (L target : targetLabels) {
            t.put(target, sourceV.targetWeight(target));
        }
        return t;
    }
    
    // TODO toString()
    @Override
    public String toString() {
        return "ConcreteVerticesGraph{" +
                "vertices=" + vertices +
                '}';
    }
}

/**
 * TODO specification
 * Mutable.
 * This class is internal to the rep of ConcreteVerticesGraph.
 * 
 * <p>PS2 instructions: the specification and implementation of this class is
 * up to you.
 */
class Vertex<L> {
    
    // TODO fields
    private L label;
    private Map<L,Integer> targets = new HashMap<>();
    
    // Abstraction function:
    //   AF(label,targetVertices) = a vertex named label that points to target vertices with corresponding weights.
    // Representation invariant:
    //   label is not null.
    // Safety from rep exposure:
    //   The targetVertices is also mutable
    
    // TODO constructor

    /**
     *
     * @param label a new vertex
     */
    public Vertex(L label) {
        this.label = label;
    }

    // TODO checkRep
    private void checkRep(){
        assert this.label != null;
        for(int weight : targets.values()){
            assert weight > 0;
        }
    }
    // TODO methods
    /**
     * get all the target vertices from current vertex
     *
     * @return a set of all the target vertices from current vertex
     */
    public Set<L> targets(){
        return this.targets.keySet();
    }

    public int set(L label, int weight){
        if(weight < 0){
            throw new IllegalArgumentException("weight must be nonnegtive");
        }
        int preWeight = 0;
        if (targets.containsKey(label)) {
            preWeight = targets.get(label);
        }

        if (weight == 0) {
            if (targets.containsKey(label)) {
                targets.remove(label);
                return preWeight;
            }
        }

        targets.put(label, weight);
        checkRep();
        return preWeight;
    }

    public L getLabel(){
        return label;
    }

    public boolean targetAt(L target){
        return targets.containsKey(target);
    }

    /**
     * Get the weight of the edge from this vertex to target
     * @param target the label of the target vertex
     * @return zero if the target is not in the targets, or
     * the weight of the edge from this vertex to target.
     */
    public int targetWeight(L target) {
        if (!targets.containsKey(target)) {
            return 0;
        }
        return targets.get(target);
    }


    // TODO toString()
    @Override
    public String toString() {
        return "Vertex{" +
                "label=" + label +
                ", targetVertices=" + targets +
                '}';
    }
}
