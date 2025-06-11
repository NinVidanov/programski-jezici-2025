package rs.ac.singidunum.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rs.ac.singidunum.entity.Projection;
import rs.ac.singidunum.repo.ProjectionRepository;

@Service
@RequiredArgsConstructor
public class ProjectionService {
	
	private final ProjectionRepository repo;
	
	public List<Projection> getProjections() {
        return repo.findAllByDeletedAtIsNull();
    }
    
    public ResponseEntity<Projection> getProjectionById(Integer id){
    	return ResponseEntity.of(this.repo.findByIdAndDeletedAtIsNull(id));
    }
    
    public void deleteProjectionById(Integer id) {
    	Projection c = repo.findById(id).orElseThrow();
    	c.setDeletedAt(LocalDateTime.now());
    	this.repo.save(c);
    }
    
    public Projection saveProjection(Projection projection) {
    	Projection p = new Projection();
    	p.setMovieId(projection.getMovieId());
    	p.setTime(projection.getTime());
    	p.setCreatedAt(LocalDateTime.now());
    	
    	return this.repo.save(p);
    }
    
    public Projection updateProjection(Integer id, Projection projection) {
    	Projection p = this.repo.findByIdAndDeletedAtIsNull(id).orElseThrow();
    	p.setMovieId(projection.getMovieId());
    	p.setTime(projection.getTime());
    	p.setUpdatedAt(LocalDateTime.now());
    	return repo.save(p);
    }
    
    public List<Projection> getFutureProjectionsByMovieId(Integer id){
    	return repo.findAllByMovieIdAndTimeAfterAndDeletedAtIsNull(id, LocalDateTime.now());
    }
}
