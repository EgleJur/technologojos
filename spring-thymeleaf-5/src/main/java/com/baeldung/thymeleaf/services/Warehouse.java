package com.baeldung.thymeleaf.services;

import com.baeldung.thymeleaf.expression.Dino;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class Warehouse {
    private List<Dino> dinos;

    public Warehouse() {
        this.dinos = new ArrayList<>();
    }
    public  List<Dino> getAll(){
        return dinos;
    }
    public void addDino(Dino dino){
        dinos.add(dino);
    }

    public Dino getDino(Integer id){
        return dinos.stream()
                .filter(dino ->id.equals(dino.getId()))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("neradau "+id));
    }
    public void deleteDino(Integer id) {
        Dino dinoToDelete = dinos.stream()
                .filter(dino -> id.equals(dino.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Neradau: " + id));

        dinos.remove(dinoToDelete);
    }


}
