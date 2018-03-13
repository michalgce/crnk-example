package me.witkowski.example;

import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class AnimalsResourceRepositoryImpl extends ResourceRepositoryBase<AnimalDTO, String> {

    private static final Map<String, AnimalDTO> ANIMALS = new ConcurrentHashMap<>();

    public AnimalsResourceRepositoryImpl() {
        super(AnimalDTO.class);
        AnimalDTO animalDTO = new AnimalDTO();
        animalDTO.setAge("10");
        animalDTO.setId("1");
        animalDTO.setName("Kuba");
        save(animalDTO);
        animalDTO = new AnimalDTO();
        animalDTO.setAge("12");
        animalDTO.setId("2");
        animalDTO.setName("Jarek");
        save(animalDTO);

    }

    @Override
    public <S extends AnimalDTO> S save(final S resource) {
        ANIMALS.put(resource.getId(), resource);

        return resource;
    }

    @Override
    public AnimalDTO findOne(final String id, final QuerySpec querySpec) {
        return ANIMALS.get(id);
    }

    @Override
    public ResourceList<AnimalDTO> findAll(final QuerySpec querySpec) {
        return querySpec.apply(ANIMALS.values());
    }
}
