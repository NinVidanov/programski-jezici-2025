package rs.ac.singidunum.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import rs.ac.singidunum.entity.Projection;
import rs.ac.singidunum.service.ProjectionService;

@RestController
@RequestMapping(path = "/api/projection")
@CrossOrigin
@RequiredArgsConstructor
public class ProjectionController {

	private final ProjectionService service;
	
	@GetMapping
	public List<Projection> getProjections(){
		return service.getProjections();
	}
	
	@GetMapping(path = "/movie/{id}")
	public List<Projection> getFutureProjections(@PathVariable Integer id){
		return service.getFutureProjectionsByMovieId(id);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Projection> getById(@PathVariable Integer id){
		return service.getProjectionById(id);
	}
	
	@PostMapping()
	public Projection create(@RequestBody Projection model) {
		return service.saveProjection(model);
	}
	
	@PutMapping(path = "/{id}")
	public Projection update(@PathVariable Integer id, @RequestBody Projection model) {
		return service.updateProjection(id, model);
	}
	
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProjection(@PathVariable Integer id) {
		System.out.print(id);
		service.deleteProjectionById(id);
	}
	
}
