package br.com.boavista.radarmotor.radarmotorfileprocess.application.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.boavista.radarmotor.radarmotorfileprocess.application.entity.RdarFileProcessEntity;
import br.com.boavista.radarmotor.radarmotorfileprocess.application.repository.RdarFileProcessRepository;
	
@Service
public class RdarFileProcessService  {	
	private static final Logger log = LoggerFactory.getLogger(RdarFileProcessService.class);
	@Autowired
	private RdarFileProcessRepository rdarFileProcessRepository;
	
	public List<RdarFileProcessEntity> findByDescription(String tipoArquivo){
		StringBuilder str = new StringBuilder("Searching on database for entity ").append(RdarFileProcessEntity.class.getSimpleName()).append(" by filter ").append(tipoArquivo);
		log.info(str.toString());
		
		List<RdarFileProcessEntity> rdarFileProcessEntityList = null;		
		try {
			rdarFileProcessEntityList = rdarFileProcessRepository.findByTipoArquivo(tipoArquivo);		
			log.info("Filter applied with success.");
		} catch(Exception e){
			str = new StringBuilder("");
			str.append("Error searching entity with informed filter on database.").append(" Message error: ").append(e.getMessage());
			log.error(str.toString());
			e.printStackTrace();
		}

		return rdarFileProcessEntityList;
	}

}