/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */
package io.atomix.vertx;

import io.atomix.catalyst.util.Assert;
import io.atomix.collections.DistributedMap;
import io.vertx.core.Vertx;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 * Atomix synchronous map.
 *
 * @author <a href="http://github.com/kuujo>Jordan Halterman</a>
 */
public class AtomixMap<K, V> implements Map<K, V> {
  private final DistributedMap<K, V> map;

  public AtomixMap(Vertx vertx, DistributedMap<K, V> map) {
    this.map = Assert.notNull(map, "map");
  }

  @Override
  public int size() {
    try {
      return map.size().get();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } catch (ExecutionException e) {
      if (e.getCause() instanceof RuntimeException) {
        throw (RuntimeException) e.getCause();
      } else {
        throw new RuntimeException(e.getCause());
      }
    }
  }

  @Override
  public boolean isEmpty() {
    try {
      return map.isEmpty().get();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } catch (ExecutionException e) {
      if (e.getCause() instanceof RuntimeException) {
        throw (RuntimeException) e.getCause();
      } else {
        throw new RuntimeException(e.getCause());
      }
    }
  }

  @Override
  public boolean containsKey(Object key) {
    try {
      return map.containsKey(key).get();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } catch (ExecutionException e) {
      if (e.getCause() instanceof RuntimeException) {
        throw (RuntimeException) e.getCause();
      } else {
        throw new RuntimeException(e.getCause());
      }
    }
  }

  @Override
  public boolean containsValue(Object value) {
    try {
      return map.containsValue(value).get();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } catch (ExecutionException e) {
      if (e.getCause() instanceof RuntimeException) {
        throw (RuntimeException) e.getCause();
      } else {
        throw new RuntimeException(e.getCause());
      }
    }
  }

  @Override
  public V get(Object key) {
    try {
      return map.get(key).get();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } catch (ExecutionException e) {
      if (e.getCause() instanceof RuntimeException) {
        throw (RuntimeException) e.getCause();
      } else {
        throw new RuntimeException(e.getCause());
      }
    }
  }

  @Override
  public V put(K key, V value) {
    try {
      return map.put(key, value).get();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } catch (ExecutionException e) {
      if (e.getCause() instanceof RuntimeException) {
        throw (RuntimeException) e.getCause();
      } else {
        throw new RuntimeException(e.getCause());
      }
    }
  }

  @Override
  @SuppressWarnings("unchecked")
  public V remove(Object key) {
    try {
      return map.remove((K) key).get();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } catch (ExecutionException e) {
      if (e.getCause() instanceof RuntimeException) {
        throw (RuntimeException) e.getCause();
      } else {
        throw new RuntimeException(e.getCause());
      }
    }
  }

  @Override
  public void putAll(Map<? extends K, ? extends V> m) {
    for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
      map.put(entry.getKey(), entry.getValue()).join();
    }
  }

  @Override
  public void clear() {
    map.clear().join();
  }

  @Override
  public Set<K> keySet() {
    try {
      return map.keySet().get();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } catch (ExecutionException e) {
      if (e.getCause() instanceof RuntimeException) {
        throw (RuntimeException) e.getCause();
      } else {
        throw new RuntimeException(e.getCause());
      }
    }
  }

  @Override
  public Collection<V> values() {
    try {
      return map.values().get();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } catch (ExecutionException e) {
      if (e.getCause() instanceof RuntimeException) {
        throw (RuntimeException) e.getCause();
      } else {
        throw new RuntimeException(e.getCause());
      }
    }
  }

  @Override
  public Set<Entry<K, V>> entrySet() {
    try {
      return map.entrySet().get();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } catch (ExecutionException e) {
      if (e.getCause() instanceof RuntimeException) {
        throw (RuntimeException) e.getCause();
      } else {
        throw new RuntimeException(e.getCause());
      }
    }
  }

}
