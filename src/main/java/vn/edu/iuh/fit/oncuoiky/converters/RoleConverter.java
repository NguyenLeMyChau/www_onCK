package vn.edu.iuh.fit.oncuoiky.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.oncuoiky.enums.Roles;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Roles, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Roles attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();    }

    @Override
    public Roles convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }

        return Stream.of(Roles.values())
                .filter(c -> c.getValue() == dbData)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

