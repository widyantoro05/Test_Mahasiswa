package edii.test.project.assembler;

public interface Assembler <Entity,Dto>{
    Entity fromDtoData (Dto dto, Long idMatkul, Long idM);
    Entity fromDto(Dto dto);
    Dto fromEntity(Entity ent);
}
