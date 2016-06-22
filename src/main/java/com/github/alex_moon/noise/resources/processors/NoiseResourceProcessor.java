package com.github.alex_moon.noise.resources.processors;

import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;

import com.github.alex_moon.noise.controllers.NoiseController;

@Component
public class NoiseResourceProcessor
    implements ResourceProcessor<RepositoryLinksResource> {

    public RepositoryLinksResource process(RepositoryLinksResource resource) {
        resource.add(
            ControllerLinkBuilder
            .linkTo(NoiseController.class)
            .withRel("noise")
        );
        return resource;
    }
}
