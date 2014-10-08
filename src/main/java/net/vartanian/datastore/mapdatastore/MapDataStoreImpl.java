package main.java.net.vartanian.datastore.mapdatastore;

import main.java.net.vartanian.datastore.DataStore;
import main.java.net.vartanian.entity.Product;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by i.vartanian on 08.10.2014.
 */
public class MapDataStoreImpl implements DataStore<Product>{

    private final ConcurrentHashMap<String, Product> productsMap = new ConcurrentHashMap<>();

    public MapDataStoreImpl() {
        productsMap.put("1", new Product("1", "Solt"));
        productsMap.put("2", new Product("2", "Beer"));
        productsMap.put("3", new Product("3", "Bread"));
        productsMap.put("4", new Product("4", "Tea"));
    }

    @Override
    public void add(Product product) {

        if (product == null) {
            return;
        }

        productsMap.put(product.getId(), product);

    }

    @Override
    public Product searchById(String id) {

        if (!productsMap.containsKey(id)) {
            return null;
        }

        return productsMap.get(id);
    }

    @Override
    public List<Product> searchAll() {
        List<Product> products = Collections.emptyList();
        products.addAll(productsMap.values());
        return products;
    }

}
