/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes.chia7712.hellodb.tools.LruCache;

/**
 *
 * @author Weli
 */
public class Node {

  private Node pre;
  private Node next;
  private int key;
  private int value;
  private CachePriority priority;

  public Node(int key, int value) {
    this(key, value, false);
  }

  public Node(int key, int value, boolean isMemory) {
    this.key = key;
    this.value = value;
    if (isMemory) {
      this.priority = CachePriority.MEMORY;
    } else {
      this.priority = CachePriority.SINGLE;
    }
  }

  public void access() {
    if (this.priority == CachePriority.SINGLE) {
      this.priority = CachePriority.MULTI;
    }
  }

  public Node pre() {
    return this.pre;
  }

  public Node next() {
    return this.next;
  }

  public void setPre(Node pre) {
    this.pre = pre;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public int key() {
    return this.key;
  }

  public int value() {
    return this.value;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public CachePriority getPriority() {
    return this.priority;
  }

}
