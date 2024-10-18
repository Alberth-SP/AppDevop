package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
@RestController
@RequestMapping("/api/v1/saludo")
public class Controller {
	
	@GetMapping("/{name}")
	public ResponseEntity<?> saludar(@PathVariable String name){
		return ResponseEntity.ok("Hola mundo, te damos la bienvenida " + name);
	}
	
	@GetMapping("/date")
	public ResponseEntity<?> getFecha(){
		return ResponseEntity.ok("La fecha es " + (new Date()).toString() );
	}

}
