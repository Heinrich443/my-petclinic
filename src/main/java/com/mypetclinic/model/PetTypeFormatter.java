package com.mypetclinic.model;

import com.mypetclinic.repository.PetTypeRepository;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;
import java.util.Objects;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

	private final PetTypeRepository types;

	public PetTypeFormatter(PetTypeRepository types) {
		this.types = types;
	}

	@Override
	public String print(PetType petType, Locale locale) {
		String name = petType.getName();
		return (name != null) ? name : "<null>";
	}

	@Override
	public PetType parse(String text, Locale locale) throws ParseException {
		Collection<PetType> findPetTypes = this.types.selectList(null);
		for (PetType type : findPetTypes) {
			if (Objects.equals(type.getName(), text)) {
				return type;
			}
		}
		throw new ParseException("type not found: " + text, 0);
	}
}
