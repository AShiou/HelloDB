/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes.chia7712.hellodb.tools.LruCache;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Weli
 */
public class LRUCache {

  private final Map<Integer, ? extends Node> map;
  private int capacity;
  private Node head;
  private Node end;
//should set in value(BLOCK)  private CachePriority priority;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    map = new HashMap<>();
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      Node n = map.get(key);
      remove(n);
      setHead(n);
      return n.value();
    } else {
      return -1;
    }
  }

  public void add(int key, int value) {
    if (map.containsKey(key)) {
      Node old = map.get(key);
      remove(old);
      old.setValue(value);
      setHead(old);
    } else {
      Node newed = new Node(key, value);
      if (isOverSize()) {
        remove(end);
        this.map.remove(end.key());
        setHead(newed);
      } else {
        setHead(newed);
      }
    }
  }

  private void remove(Node n) {
    if (n.pre() == null) {
      this.head = n.next();
    } else {
      n.pre().setNext(n.next());
    }

    if (n.next() == null) {
      this.end = n.pre();
    } else {
      n.next().setPre(n.pre());
    }
  }

  private void setHead(Node n) {
    n.setNext(head);
    n.setPre(null);
    if (this.head != null) {
      head.setPre(n);
    }
    head = n;
    if (end == null) {
      end = head;
    }
  }

  public boolean isOverSize() {
    return this.map.size() > this.capacity;
  }

  public int size() {
    return this.map.size();
  }

  public void setMaxSize(int maxSize) {
    this.capacity = maxSize;
  }

  public void clear() {
    this.map.clear();
  }

}
