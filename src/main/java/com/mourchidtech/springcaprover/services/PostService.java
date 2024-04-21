package com.mourchidtech.springcaprover.services;


import com.mourchidtech.springcaprover.entities.Post;
import com.mourchidtech.springcaprover.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository repository;

    public Post create(Post post) {
        return repository.save(post);
    }

    public Post findOne(Long id){
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Post with id "+ id + " not find"));
    }

    public Post update(Long id, Post post){
        findOne(id);
        post.setId(id);
        return repository.save(post);
    }

    public void delete(Long id){
        Post post =  findOne(id);
        repository.delete(post);
    }


    public List<Post> fetchAll(){
        return repository.findAll();
    }






}
