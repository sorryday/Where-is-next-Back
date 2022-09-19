package com.win.back.service;

import com.win.back.dto.AllPostDTO;
import com.win.back.dto.PostDTO;
import com.win.back.entity.Picture;
import com.win.back.entity.Post;
import com.win.back.repository.PictureRepository;
import com.win.back.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PictureRepository pictureRepository;

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
}
