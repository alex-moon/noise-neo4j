package com.github.alex_moon.noise.entities.texts;

import java.util.List;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class Text {
    @GraphId
    private Long id;
    
    @Indexed
    private String uuid;

    private String rawText;

    @RelatedTo(type="IS_TOKENIZED_BY")
    private List<Tokenization> tokenizations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRawText() {
        return rawText;
    }

    public void setRawText(String rawText) {
        this.rawText = rawText;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
