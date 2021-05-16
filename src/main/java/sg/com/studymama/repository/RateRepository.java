package sg.com.studymama.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.com.studymama.Entity.RateEntity;


public interface RateRepository extends JpaRepository<RateEntity, Integer> {
	
	

}
