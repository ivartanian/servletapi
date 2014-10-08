package main.java.net.vartanian.datastore;

import main.java.net.vartanian.entity.Product;

import java.util.List;

/**
 * Created by i.vartanian on 08.10.2014.
 */
public interface DataStore<T> {

    public void add(T t);
    public T searchById(String id);
    public List<T> searchAll();

}
