package com.referatapi.app.service;

import com.referatapi.app.api.model.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    private List<Tag> tagList;

    public List<Tag> getTags() {
        return tagList;
    }

}
