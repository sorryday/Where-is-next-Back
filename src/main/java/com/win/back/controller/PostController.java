package com.win.back.controller;

import com.win.back.dto.*;
import com.win.back.entity.Comment;
import com.win.back.entity.Location;
import com.win.back.service.PostService;
import com.win.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import retrofit2.http.Body;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    // 포스트를 저장
    @PostMapping("add_post")
    @ResponseBody
    public boolean AddPost(@RequestBody PostDTO postDTO) {
        return postService.addPost(postDTO);
    }

    // 포스트가 있는지 확인
    @GetMapping("post_check")
    @ResponseBody
    public boolean isPostResponse() {
        return postService.isPost();
    }

    // 모든 포스트 정보를 반환
    @GetMapping("all_post")
    @ResponseBody
    public List<AllPostDTO> getAllPostResponse() {
        return postService.allPost();
    }

    // 현재 로그인한 사용자의 포스트 정보를 반환
    @GetMapping("my_post/{id}")
    @ResponseBody
    public List<AllPostDTO> getMyPostResponse(@PathVariable String id) {
        id = id.replaceAll("\"", "");
        return postService.myPost(id);
    }

    // 선택한 포스트의 모든 댓글 정보를 반환
    @GetMapping("all_comment/{selected_number}")
    @ResponseBody
    public List<Comment> getAllComment(@PathVariable String selected_number) {
        selected_number = selected_number.replaceAll("\"", "");
        return postService.allCommnet(selected_number);
    }

    // 선택한 포스트에 댓글 등록
    @PostMapping("add_comment")
    @ResponseBody
    public Long setAddComment(@RequestBody CommentDTO commentDTO) {
        return postService.addComment(commentDTO);
    }

    // 선택한 포스트에 댓글 등록
    @PostMapping("delete_comment")
    @ResponseBody
    public boolean setDeleteComment(@RequestBody CommentDeleteDTO commentDeleteDTO) {
        return postService.deleteComment(commentDeleteDTO);
    }
}