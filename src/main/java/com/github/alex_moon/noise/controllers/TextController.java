package com.github.alex_moon.noise.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.alex_moon.noise.entities.Text;
import com.github.alex_moon.noise.repositories.TextRepository;
import com.github.alex_moon.noise.resources.MessageResource;

@RestController
@ExposesResourceFor(Text.class)
@RequestMapping("/noise/texts")
public class TextController {
    @Autowired
    private TextRepository textRepository;

    @Autowired
    private EntityLinks entityLinks;

    @RequestMapping
    public MessageResource index() {
        MessageResource resource = new MessageResource();
        resource.setMessage("Use this controller to do stuff with texts");
        resource.add(entityLinks.linkToCollectionResource(Text.class));
        return resource;
    }

    @RequestMapping(value = "{id}/tokenize/", method = RequestMethod.POST)
    public Text tokenize(@PathVariable Long id) {
        Text text = textRepository.findOne(id);
        return text;
    }
}
