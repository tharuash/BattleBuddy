package com.b127.demo.service.custom.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b127.demo.dto.SubCommentDTO;
import com.b127.demo.entity.SubComment;
import com.b127.demo.repository.SubCommetRepository;
import com.b127.demo.service.custom.SubCommentService;
@Service
public class SubCommentServiceImpl implements SubCommentService {
    @Autowired
    SubCommetRepository subCommetRepository;

    @Override
    public List<SubCommentDTO> findAll() {
        return subCommetRepository.findAll().stream().map(x ->
                new SubCommentDTO(x.getSubCommentId(),x.getUser(),x.getComment(),x.getBody(),x.getLikes(),x.getCreatedTime())).collect(Collectors.toList());
    }

    @Override
    public SubCommentDTO getById(int id) {
        SubComment subComment = subCommetRepository.getOne(id);
        return new SubCommentDTO(subComment.getSubCommentId(),subComment.getUser(),subComment.getComment(),subComment.getBody(),subComment.getLikes(),subComment.getCreatedTime());
    }

    @Override
    public void update(SubCommentDTO subCommentDTO) {
        SubComment subComment = new SubComment(subCommentDTO.getSubCommentId(), subCommentDTO.getUser(), subCommentDTO.getComment(), subCommentDTO.getBody(), subCommentDTO.getLikes(), subCommentDTO.getCreatedTime());
        subCommetRepository.save(subComment);
    }

    @Override
    public void delete(int id) {
        subCommetRepository.deleteById(id);
    }

    @Override
    public void insert(SubCommentDTO subCommentDTO) {
        SubComment subComment = new SubComment(subCommentDTO.getUser(), subCommentDTO.getComment(), subCommentDTO.getBody(), subCommentDTO.getLikes(), subCommentDTO.getCreatedTime());
        subCommetRepository.save(subComment);
    }
}
