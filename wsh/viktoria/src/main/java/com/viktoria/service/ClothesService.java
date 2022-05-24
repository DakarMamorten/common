package com.viktoria.service;

import com.viktoria.domain.Clothes;
import com.viktoria.repository.ClothesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClothesService {
    private final ClothesRepository clothesRepository;

    public void add(final String season,final String material,final String color){
        Clothes clothes = new Clothes(season,material,color);
        clothesRepository.save(clothes);
    }
    @Transactional
    public void update(final Long id,final String season,final String material,final String color){
        clothesRepository.findById(id).ifPresent(c -> {
            c.setSeason(season);
            c.setMaterial(material);
            c.setColor(color);
        });
    }

    public List<Clothes> findAll(){
       return clothesRepository.findAll();
    }

    public void deletedById(final Long id){
        clothesRepository.deleteById(id);
    }

    public Clothes findById(final Long id){
        return clothesRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

}

