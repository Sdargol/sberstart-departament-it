package org.sdargol.core;

import java.util.ArrayList;
import java.util.List;

public class Storage <T>{
    private List<T> storage;

    private Storage(){
        storage = new ArrayList<>();
    }

    public static <S> Storage<S> create(){
        return new Storage<>();
    }

    public List<T> getStorage() {
        return storage;
    }

    public void setStorage(List<T> storage) {
        this.storage = storage;
    }
}
