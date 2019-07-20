package com.b127.demo.service.custom.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b127.demo.dto.CommentDTO;
import com.b127.demo.entity.Comment;
import com.b127.demo.repository.CommentRepository;
import com.b127.demo.repository.UserRepository;
import com.b127.demo.service.custom.CommentServiece;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 6/26/2019
 * Time: 10:09 PM}
 */

@Service
public class CommentServiceImpl implements CommentServiece {
    @Autowired
    private CommentRepository commetRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public List<CommentDTO> findAll() {
        return commetRepository.findAll().stream().map(x ->
                new CommentDTO(x.getCommentId(),x.getUser().getUserId(),x.getFeedId(),x.getBody(),x.getLikes(),x.getCreatedTime())).collect(Collectors.toList());
    }

    @Override
    public CommentDTO getById(int id) {
        Comment x = commetRepository.getOne(id);
        return new CommentDTO(x.getCommentId(),x.getUser().getUserId(),x.getFeedId(),x.getBody(),x.getLikes(),x.getCreatedTime());
    }

    @Override
    public void update(CommentDTO commentDTO) {
        Comment subComment = new Comment(commentDTO.getCommentId(),userRepository.getOne(commentDTO.getUserId()), commentDTO.getFeedId(), commentDTO.getBody(), commentDTO.getLikes(), commentDTO.getCreatedTime());
        commetRepository.save(subComment);
    }

    @Override
    public void delete(int id) {
        commetRepository.deleteById(id);
    }

    @Override
    public void insert(CommentDTO commentDTO) {
        Comment subComment = new Comment(userRepository.getOne(commentDTO.getUserId()), commentDTO.getFeedId(), commentDTO.getBody(), commentDTO.getLikes(), commentDTO.getCreatedTime());
        commetRepository.save(subComment);
    }
}
