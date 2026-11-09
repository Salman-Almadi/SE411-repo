package psu.se411.practice2.model;

import org.springframework.data.annotation.Id;

public record Course(
		@Id Long id,
		String Code,
		String Name,
		String Description,
		Integer Credits
		) {
	
	
}
