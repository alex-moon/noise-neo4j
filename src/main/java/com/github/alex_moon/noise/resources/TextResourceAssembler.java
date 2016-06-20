package com.github.alex_moon.noise.resources;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.github.alex_moon.noise.controllers.TextController;
import com.github.alex_moon.noise.entities.Text;

@Component
class TextResourceAssembler
    extends ResourceAssemblerSupport<Text, TextResource> {
    public TextResourceAssembler() {
        super(TextController.class, TextResource.class);
    }

    public TextResource toResource(Text text) {
        TextResource resource = createResourceWithId(
            text.getId(), text
        );
        resource.add(ControllerLinkBuilder.linkTo(
            ControllerLinkBuilder.methodOn(
                TextController.class
            ).tokenize(text.getId())
        ).withRel("tokenize"));
        return resource;
    }
}
