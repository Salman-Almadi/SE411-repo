package psu.se411.lab14Practice.model;

import org.springframework.data.annotation.Id;

public record Course(
		@Id Long id,
		String Code,
		String Name,
		String Description,
		Integer Credits
		) {

}
