package com.leeryan.book.springboot.web.web;

import com.leeryan.book.springboot.web.service.posts.PostsService;
import com.leeryan.book.springboot.web.web.dto.PostsResponseDto;
import com.leeryan.book.springboot.web.web.dto.PostsSaveRequestDto;
import com.leeryan.book.springboot.web.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostsService postsService;

    @PostMapping("api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    //@PutMapping("/api/v1/posts/{id}")
    @RequestMapping(value = "/api/v1/posts/{id}", method = {RequestMethod.PUT})
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}
