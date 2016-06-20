package com.github.alex_moon.noise.controllers;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.alex_moon.noise.resources.MessageResource;

@RestController
@RequestMapping("/noise")
public class NoiseController {
    @RequestMapping("")
    public MessageResource index() {
        MessageResource resource = new MessageResource();
        resource.setMessage("Welcome to fuckin Noise bitches");
        resource.add(
            ControllerLinkBuilder
            .linkTo(TextController.class)
            .withRel("texts")
        );
        return resource;
    }
}
