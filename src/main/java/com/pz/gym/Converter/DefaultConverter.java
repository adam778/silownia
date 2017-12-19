package com.pz.gym.Converter;

public interface DefaultConverter <Entity, Dto> {
    Entity convertToEntity(Dto dto);

    Dto convertToDto(Entity entity);
}
