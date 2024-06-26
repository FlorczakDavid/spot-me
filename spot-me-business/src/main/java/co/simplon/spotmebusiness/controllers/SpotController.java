package co.simplon.spotmebusiness.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.simplon.spotmebusiness.dtos.SpotCreate;
import jakarta.validation.Valid;

// /spots -> collection of resources
@RequestMapping("/spots") // lower case kebab-case
@RestController
public class SpotController {

	// @RequestBody => TXT/JSON
	@PostMapping
	void create(@Valid @ModelAttribute SpotCreate inputs) { // naming convention: just create
		System.out.println(inputs);
		MultipartFile image = inputs.image();
		System.out.println(image.getName());
		System.out.println(image.getContentType());
		System.out.println(image.getSize());
		System.out.println(image.getOriginalFilename());
	}
}
