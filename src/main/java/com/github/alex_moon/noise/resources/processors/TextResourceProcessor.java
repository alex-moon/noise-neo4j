package com.github.alex_moon.noise.resources.processors;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;

import com.github.alex_moon.noise.controllers.TextController;
import com.github.alex_moon.noise.entities.Text;

@Component
public class TextResourceProcessor
    implements ResourceProcessor<Resource<Text>> {
    
    public Resource<Text> process(Resource<Text> resource) {
        Text text = resource.getContent();
        resource.add(ControllerLinkBuilder.linkTo(
            ControllerLinkBuilder.methodOn(
                TextController.class
            ).tokenize(text.getId())
        ).withRel("tokenize"));
        return resource;
    }
}
