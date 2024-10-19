package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
@RestController
@RequestMapping("/api/v1")
public class Controller {
	
	@GetMapping("/saludar/{name}")
	public ResponseEntity<?> saludar(@PathVariable String name){
		return ResponseEntity.ok("Hola mundo, te damos la bienvenida " + name);
	}
	
	@GetMapping("/date/current")
	public ResponseEntity<?> getFecha(){
		return ResponseEntity.ok("La fecha es " + (new Date()).toString() );
	}
	
	@GetMapping("/date/calcularNacimiento/{anio}")
	public ResponseEntity<?> calcularNacimiento(@PathVariable Integer anio){
		LocalDate dateCurrent = LocalDate.now();
		Integer edad = dateCurrent.getYear() - anio;
		return ResponseEntity.ok("Tienes " + edad + " años");
	}

}
