package me.witkowski.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;

@Data
@JsonApiResource(type = "animals")
public class AnimalDTO {
    @JsonApiId
    private String id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String age;
}
