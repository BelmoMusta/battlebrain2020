package musta.belmo.cody.mapper;

import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL, withIgnoreNullValue = true, withCustom = CharArrayToStringMapper.class)
public interface DomainDTOMapper extends DTOMapperE, DomainMapper {


}