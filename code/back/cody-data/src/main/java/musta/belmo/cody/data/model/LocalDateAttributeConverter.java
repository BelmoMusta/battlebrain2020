package musta.belmo.cody.data.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDate;

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {
	
	@Override
	public Date convertToDatabaseColumn(LocalDate locDate) {
		
		return locDate == null ? null : Date.valueOf(locDate);
	}
	
	@Override
	public LocalDate convertToEntityAttribute(Date sqlDate) {
		final LocalDate localDateTime;
		if (sqlDate == null) {
			localDateTime = null;
		} else {
			localDateTime = sqlDate.toLocalDate();
		}
		return localDateTime;
	}
	
	
}