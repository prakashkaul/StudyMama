package sg.com.studymama.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.com.studymama.DTO.RateDTO;
import sg.com.studymama.Entity.RateEntity;
import sg.com.studymama.repository.RateRepository;
import sg.com.studymama.service.RateService;

@Service
@Transactional
public class RateServiceImpl implements RateService{
	
	@Autowired
	RateRepository rateRepository;
	

	@Override
	public RateEntity save(RateDTO rateDTO) {
		// TODO Auto-generated method stub
		RateEntity entity = convertToEntity(rateDTO);
	
		return rateRepository.save(entity);
		
	}


	private RateEntity convertToEntity(RateDTO rateDTO) {
		// TODO Auto-generated method stub
		RateEntity entity = new RateEntity();
		entity.setAccountId(rateDTO.getAccountId());
		entity.setPostId(rateDTO.getPostId());
		entity.setRateId(rateDTO.getRateId());
		entity.setrateScore(rateDTO.getRateScore());
		
		entity.setRateDate(Timestamp.valueOf(LocalDateTime.now()));
		
		return entity;
	}

}
