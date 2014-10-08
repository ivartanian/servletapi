package main.java.net.vartanian.dao.impl;

import main.java.net.vartanian.dao.ProductDao;
import main.java.net.vartanian.datastore.mapdatastore.MapDataStoreImpl;
import main.java.net.vartanian.entity.Product;

import java.util.List;

/**
 * Created by i.vartanian on 08.10.2014.
 */
public class MapProductDaoImpl implements ProductDao<Product>{

    private final MapDataStoreImpl dataStore;

    public MapProductDaoImpl(MapDataStoreImpl dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public void add(Product product) {
        dataStore.add(product);
    }

    @Override
    public Product searchById(String id) {
        return dataStore.searchById(id);
    }

    @Override
    public List<Product> searchAll() {
        return dataStore.searchAll();
    }

}
