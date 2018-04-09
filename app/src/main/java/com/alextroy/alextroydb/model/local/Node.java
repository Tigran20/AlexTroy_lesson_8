package com.alextroy.alextroydb.model.local;

import java.util.List;

public class Node {

    private long id;
    private int value;
    private List<Node> children;

    public Node(long id, int value, List<Node> children) {
        this.id = id;
        this.value = value;
        this.children = children;
    }

    public long getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public List<Node> getChildren() {
        return children;
    }
}
