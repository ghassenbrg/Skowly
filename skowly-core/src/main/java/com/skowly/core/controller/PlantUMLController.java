package com.skowly.core.controller;

import java.io.ByteArrayOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skowly.core.service.PlantUMLService;

import net.sourceforge.plantuml.SourceStringReader;

@RestController
@RequestMapping("/uml")
public class PlantUMLController {

	@Autowired
	PlantUMLService plantUMLService;

	@PreAuthorize("hasRole('SKOWLY_ADMIN')")
	@GetMapping(value = "/generate", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> generateUML() {
		try {
			String plantUMLCode = plantUMLService.generatePlantUMLCode("com.skowly.core.domain.model");
			SourceStringReader reader = new SourceStringReader(plantUMLCode);
			ByteArrayOutputStream os = new ByteArrayOutputStream();

			reader.outputImage(os);
			os.close();

			return new ResponseEntity<>(os.toByteArray(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
