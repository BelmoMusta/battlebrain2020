package musta.belmo.cody.data.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Converter(autoApply = true)
public class TimeStampAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {
	
	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime locDate) {
		
		return locDate == null ? null : Timestamp.valueOf(locDate);
	}
	
	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp sqlDate) {
		final LocalDateTime localDateTime;
		if (sqlDate == null) {
			localDateTime = null;
		} else {
			localDateTime = LocalDateTime.ofInstant(sqlDate.toInstant(),
					ZoneId.systemDefault());
		}
		return localDateTime;
	}
	
	
}