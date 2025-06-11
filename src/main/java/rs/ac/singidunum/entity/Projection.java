package rs.ac.singidunum.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "projection")
@Table(name = "projection")
@NoArgsConstructor
@Getter
@Setter
public class Projection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "projection_id")
	private Integer id;
	
	@Column(nullable = false)
	private Integer movieId;
	
	@Column(nullable = false)
	private LocalDateTime time;
	
	@Column(nullable = false)
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;
	
	@JsonIgnore
	private LocalDateTime deletedAt;
}
