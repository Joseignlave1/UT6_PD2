package uy.edu.ucu.aed;

import java.util.HashMap;

public class THash implements IHash {
    private HashMap<Integer, Integer> map;
    int capacidad;

    public THash(int capacidad) throws Exception {
        if(capacidad <= 0) {
            throw new Exception("La capacidad debe ser mayor a 0");
        }
        this.capacidad = capacidad;
        this.map = new HashMap<>();

    }
    @Override
    public int buscar(int unaClave) {

    }

    @Override
    public int insertar(int unaClave) {
        return 0;
    }

    @Override
    public int funcionHashing(int unaClave) {
        return 0;
    }
}
