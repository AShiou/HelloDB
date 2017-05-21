/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes.chia7712.hellodb.tools.LruCache;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 *
 * @author Weli
 */
public class LruCacheCallAPI extends LinkedHashMap<Integer, String> {

  private int cacheSize;

  public LruCacheCallAPI(int size) {
    super(size, 0.75f, true);
    this.cacheSize = size;
  }

  @Override
  protected boolean removeEldestEntry(Entry<Integer, String> eldest) {
    // remove the oldest element when size limit is reached
    return size() > cacheSize;
  }
}
