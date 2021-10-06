package com.leeryan.book.springboot.web.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query(value = "SELECT p.* FROM POSTS p ORDER BY p.id DESC", nativeQuery = true)
    List<Posts> findAllDesc();
}
