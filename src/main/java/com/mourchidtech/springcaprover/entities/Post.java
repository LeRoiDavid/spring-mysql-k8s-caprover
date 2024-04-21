package com.mourchidtech.springcaprover.entities;


import lombok.*;

import javax.persistence.*;

@Table(name = "posts")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
   private String title;

    @Column(columnDefinition = "TEXT")
   private String content;

    @Column(columnDefinition = "boolean default false")
   private boolean isPublish;


}
