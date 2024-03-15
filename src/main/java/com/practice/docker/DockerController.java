package com.practice.docker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {
	
	@Autowired
	private BookRepository bookRepository;

	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks(){
		
		Book b= new Book();
		b.setBookId(1);
		b.setBookName("Philosophy");
		b.setBookPrice(200L);
		
		Book b1= new Book();
		b1.setBookId(1);
		b1.setBookName("Common Sense");
		b1.setBookPrice(200L);
		List<Book> saveAll = bookRepository.saveAll(List.of(b,b1));
		
		return new ResponseEntity<>(saveAll,HttpStatus.OK);
			
		
	}
}
