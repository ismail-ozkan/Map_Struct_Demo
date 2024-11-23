package com.mapstruct.personMapping;

public class Test {

    public static void main(String[] args) {

        PersonMapper mapper = PersonMapper.INSTANCE;

        Person person = new Person();
        person.setFirstName("Ali");
        person.setLastName("Yılmaz");
        person.setAge(33);


        PersonDto dto = mapper.personToPersonDto(person);

        System.out.println("dto = " + dto);
        System.out.println(dto.getFullName());


        PersonEntity personEntity = mapper.mapToEntity(person);
        System.out.println("personEntity = " + personEntity);


        PersonObject personObject = mapper.mapToObject(person);
        System.out.println("personObject = " + personObject);

    }

}
