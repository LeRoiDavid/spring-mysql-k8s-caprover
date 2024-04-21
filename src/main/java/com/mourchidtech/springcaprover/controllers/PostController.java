package com.mourchidtech.springcaprover.controllers;

import com.mourchidtech.springcaprover.entities.Post;
import com.mourchidtech.springcaprover.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService service;


    @PostMapping
    public Post create(@RequestBody Post post) {
        return this.service.create(post);
    }

    @GetMapping("/{id}")
    public Post findOne(@PathVariable("id") Long id) {
        return this.service.findOne(id);
    }

    @GetMapping
    public List<Post> fetchAll() {
        return this.service.fetchAll();
    }

    @PutMapping("/{id}")
    public Post update(@PathVariable("id") Long id, @RequestBody Post post) {
        return this.service.update(id, post);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.service.delete(id);
    }


}
