package com.referatapi.app.api.controller;

import com.referatapi.app.api.model.Tag;
import com.referatapi.app.api.repository.TagRepository;
import com.referatapi.app.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TagController {

    private TagService tagService;
    private TagRepository tagRepository;

    @Autowired
    public TagController(TagService tagService, TagRepository tagRepository) {
        this.tagService = tagService;
        this.tagRepository = tagRepository;
    }

    @GetMapping("/tags")
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @PostMapping(value = "/tag", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
        Tag toCreate = new Tag(tag.getName(), tag.getColor());
        tagRepository.save(toCreate);

        return new ResponseEntity<>(toCreate, HttpStatus.CREATED);
    }

    @PostMapping(value = "/tag/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tag> updateTag(@RequestBody Tag tag) {
        Tag updatedTag = new Tag(tag.getId(), tag.getName(), tag.getColor());
        tagRepository.save(updatedTag);

        return new ResponseEntity<>(updatedTag, HttpStatus.ACCEPTED);
    }

}
