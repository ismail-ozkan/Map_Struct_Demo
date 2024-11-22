package com.mapstruct.personMapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    // Bu maplemede aynı alan ismini paylaşmayan(Dto) ve paylaşan(Entity) objeleri biribiyle değiştirme

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(source = ".", target = "fullName", qualifiedByName = "concatenateNames")
    @Mapping(source = ".", target = "age", qualifiedByName = "parseIntToString")
    PersonDto personToPersonDto(Person person);

    @Named("concatenateNames")
    default String concatenateNames(Person person) {
        return person.getFirstName() + " " + person.getLastName();
    }
    @Named("parseIntToString")
    default String parseIntToString(Person person) {
        return person.getAge() + " ";
    }

    //Aynı ismi taşıyorsa Mapping'e gerek kalmıyor.
    PersonEntity mapToEntity(Person person);

    @Mappings({
            @Mapping(target = "First_Name", source = "firstName"),
            @Mapping(target = "Last_Name", source = "lastName")
    })
    PersonObject mapToObject(Person person);

}
