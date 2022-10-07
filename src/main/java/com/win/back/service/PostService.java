package com.win.back.service;

import com.win.back.dto.*;
import com.win.back.entity.Comment;
import com.win.back.entity.Picture;
import com.win.back.entity.Post;
import com.win.back.entity.User;
import com.win.back.repository.CommentRepository;
import com.win.back.repository.PictureRepository;
import com.win.back.repository.PostRepository;
import com.win.back.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PictureRepository pictureRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    // 포스트 등록
    public boolean addPost(PostDTO postDTO) {
        Post post = new Post();
        post.setId(postDTO.getId());
        post.setNickname(postDTO.getNickname());
        post.setDate(postDTO.getDate());
        post.setTitle(postDTO.getTitle());
        post.setContents(postDTO.getContents());

        Post savePost = postRepository.save(post);

        String autoNum = Long.toString(savePost.getNumber());

        if (!postDTO.getImages().isEmpty()) {
            ArrayList<Picture> picture = new ArrayList<>();
            for (int i = 0; i < postDTO.getImages().size(); i++) {
                Picture input = new Picture();
                input.setNumber(autoNum);
                input.setPicture_bitmap(postDTO.getImages().get(i));

                picture.add(input);
            }
            pictureRepository.saveAll(picture);
        }
        return true;
    }

    // 포스트가 있는지 확인
    public boolean isPost() {
        if (postRepository.findAll().isEmpty()) {
            return false;
        }
        else {
            return true;
        }
    }

    // 모든 포스트 가져오기
    public List<AllPostDTO> allPost() {
        List<AllPostDTO> allPostDTDList = new ArrayList<>();

        List<Post> allPostList = postRepository.findAll();
        List<Picture> allPicutreList = pictureRepository.findAll();

        for (Post post : allPostList) {
            AllPostDTO input_dto = new AllPostDTO();
            input_dto.setNumber(post.getNumber());
            input_dto.setId(post.getId());
            input_dto.setNickname(post.getNickname());
            input_dto.setDate(post.getDate());
            input_dto.setTitle(post.getTitle());
            input_dto.setContents(post.getContents());

            ArrayList<byte[]> input_image_arr = new ArrayList<>();

            for (Picture picture : allPicutreList) {
                if (post.getNumber() == Long.parseLong(picture.getNumber())) {
                    input_image_arr.add(picture.getPicture_bitmap());
                }
            }
            input_dto.setAllImages(input_image_arr);

            allPostDTDList.add(input_dto);
        }
        return allPostDTDList;
    }

    // 내 포스트 모두 가져오기 myPost
    public List<AllPostDTO> myPost(String id) {
        List<AllPostDTO> allPostDTDList = new ArrayList<>();

        List<Post> allPostList = postRepository.findAll();
        List<Picture> allPicutreList = pictureRepository.findAll();

        for (Post post : allPostList) {
            if (post.getId().equals(id)) {
                AllPostDTO input_dto = new AllPostDTO();
                input_dto.setNumber(post.getNumber());
                input_dto.setId(post.getId());
                input_dto.setNickname(post.getNickname());
                input_dto.setDate(post.getDate());
                input_dto.setTitle(post.getTitle());
                input_dto.setContents(post.getContents());

                ArrayList<byte[]> input_image_arr = new ArrayList<>();

                for (Picture picture : allPicutreList) {
                    if (post.getNumber() == Long.parseLong(picture.getNumber())) {
                        input_image_arr.add(picture.getPicture_bitmap());
                    }
                }
                input_dto.setAllImages(input_image_arr);

                allPostDTDList.add(input_dto);
            }
        }
        return allPostDTDList;
    }

    // 선택한 포스트의 모든 댓글을 반환
    public List<Comment> allCommnet(String selected_number) {
        List<Comment> all = commentRepository.findAll();
        List<Comment> selected_commentList = new ArrayList<>();

        for (Comment comment : all) {
            if (comment.getNumber_post().equals(selected_number)) {
                selected_commentList.add(comment);
            }
        }
        return selected_commentList;
    }

    // 댓글 등록
    public Long addComment(CommentDTO commentDTO) {
        Comment commentEntity = new Comment();
        commentEntity.setNumber_post(commentDTO.getPost_number());
        commentEntity.setNickname(commentDTO.getComment_nickname());
        commentEntity.setContents(commentDTO.getComment_contents());

        Comment save = commentRepository.save(commentEntity);

        return save.getNumber();
    }

    // 댓글 삭제
    public boolean deleteComment(CommentDeleteDTO commentDeleteDTO) {
        String userNickname = null;
        List<User> all = userRepository.findAll();

        for (User user : all) {
            if (user.getId().equals(commentDeleteDTO.getId())) {
                userNickname = user.getNickname();
            }
        }

        List<Comment> allCommnet = commentRepository.findAll();
        for (Comment comment : allCommnet) {
            if (comment.getNickname().equals(userNickname) && (comment.getNumber().equals(commentDeleteDTO.getNumber()))) {
                commentRepository.delete(comment);
                return true;
            }
        }

        return false;
    }

    // 포스트를 삭제하는 함수(댓글과 사진 모두 삭제)
    public boolean deletePost(String post_number) {
        List<Post> all = postRepository.findAll();
        for (Post post : all) {
            if (post.getNumber().equals(Long.parseLong(post_number))) {
                postRepository.delete(post);
                break;
            }
        }

        List<Picture> all2 = pictureRepository.findAll();
        for (Picture picture : all2) {
            if (picture.getNumber().equals(post_number)) {
                pictureRepository.delete(picture);
            }
        }

        List<Comment> all3 = commentRepository.findAll();
        for (Comment comment : all3) {
            if (comment.getNumber_post().equals(post_number)) {
                commentRepository.delete(comment);
            }
        }

        return true;
    }

    // 포스트를 수정하는 함수
    @Transactional
    public boolean updatePost(PostUpdateDTO postUpdateDTO) {
        Post post = new Post();
        post.setNumber(Long.parseLong(postUpdateDTO.getPost_number()));
        post.setId(postUpdateDTO.getId());
        post.setNickname(postUpdateDTO.getNickname());
        post.setDate(postUpdateDTO.getDate());
        post.setTitle(postUpdateDTO.getTitle());
        post.setContents(postUpdateDTO.getContents());

        // 제목과 타이틀은 없을 수가 없으므로 update를 한다.
        postRepository.save(post);

        // 사진은 아예 없을 수 있기에 삭제를 한 후 save를 한다.
        List<Picture> all1 = pictureRepository.findAll();
        for (Picture loop_picture : all1) {
            if (loop_picture.getNumber().equals(postUpdateDTO.getPost_number())) {
                pictureRepository.delete(loop_picture);
            }
        }

        if (!postUpdateDTO.getImages().isEmpty()) {
            ArrayList<Picture> picture = new ArrayList<>();
            for (int i = 0; i < postUpdateDTO.getImages().size(); i++) {
                Picture input = new Picture();
                input.setNumber(postUpdateDTO.getPost_number());
                input.setPicture_bitmap(postUpdateDTO.getImages().get(i));

                picture.add(input);
            }
            pictureRepository.saveAll(picture);
        }
        return true;
    }

    // 선택된 포스트의 댓글 수를 반환
    public String postCommnetCnt(String post_number) {
        int cnt = 0;
        List<Comment> all = commentRepository.findAll();
        for (Comment comment : all) {
            if (comment.getNumber_post().equals(post_number)) {
                cnt += 1;
            }
        }
        return Integer.toString(cnt);
    }
}
