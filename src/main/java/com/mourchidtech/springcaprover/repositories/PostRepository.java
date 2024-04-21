package com.mourchidtech.springcaprover.repositories;


import com.mourchidtech.springcaprover.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
