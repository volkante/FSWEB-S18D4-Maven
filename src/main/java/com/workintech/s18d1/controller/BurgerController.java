package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDaoImpl;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech/burgers")
public class BurgerController {

    private BurgerDaoImpl burgerDaoImpl;

    @Autowired
    public BurgerController(BurgerDaoImpl burgerDaoImpl) {
        this.burgerDaoImpl = burgerDaoImpl;
    }

    @GetMapping
    public List<Burger> getAllBurgers(){
        return burgerDaoImpl.findAll();
    }

    @GetMapping("/{id}")
    public Burger getBurgerById(@PathVariable Long id){
        //TODO [Volkan] check if id is greater than 0
        //TODO [Volkan] check if id is found in map
        Burger BurgerFoundById = burgerDaoImpl.findById(id);
        return BurgerFoundById;
    }

    @PostMapping
    public Burger saveBurger(@RequestBody Burger burger){

        return burgerDaoImpl.save(burger);
    }

    @PutMapping("/{id}")
    public Burger updateBurgerById(@PathVariable Long id, @RequestBody Burger burger){
        Burger burgerFoundById = burgerDaoImpl.findById(id);
        return burgerDaoImpl.update(burgerFoundById);
    }

    @DeleteMapping("/{id}")
    public Burger removeBurgerById(@PathVariable Long id){
        return burgerDaoImpl.remove(id);
    }

    @GetMapping("/findByPrice")
    public List<Burger> findByPrice(@RequestBody Integer price){
        return burgerDaoImpl.findByPrice(price);
    }

    @GetMapping("/findByBreadType")
    public List<Burger> findByBreadType(@RequestBody BreadType breadType){
        return burgerDaoImpl.findByBreadType(breadType);
    }

    @GetMapping("/findByContent")
    public List<Burger> findByContent(@RequestBody String content){
        return burgerDaoImpl.findByContent(content);
    }






}
