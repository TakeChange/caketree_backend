package com.caketree_backend.caketree_backend.service;


import com.caketree_backend.caketree_backend.model.AddCakeEntity;
import com.caketree_backend.caketree_backend.repository.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CakeService {

    @Autowired
    private CakeRepository cakeRepository;

    public List<AddCakeEntity> getAllCakes() {
        return cakeRepository.findAll();
    }

    public AddCakeEntity saveCake(AddCakeEntity cake) {
        return cakeRepository.save(cake);
    }
}