package br.com.boavista.radarmotor.radarmotorfileprocess.application.service;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.boavista.radarmotor.radarmotorfileprocess.application.entity.RdarFileProcessEntity;
import br.com.boavista.radarmotor.radarmotorfileprocess.application.layout.A01_XXXXXXLayout;
import br.com.boavista.radarmotor.radarmotorfileprocess.application.layout.A02_XXXXXXLayout;
import br.com.boavista.radarmotor.radarmotorfileprocess.application.layout.A03_XXXXXXLayout;
import br.com.boavista.radarmotor.radarmotorfileprocess.application.layout.DtArquivoField;
import br.com.boavista.radarmotor.radarmotorfileprocess.application.layout.HeaderField;
import br.com.boavista.radarmotor.radarmotorfileprocess.application.layout.NumLoteField;
import br.com.boavista.radarmotor.radarmotorfileprocess.application.layout.TrailerField;
import br.com.boavista.radarmotor.radarmotorfileprocess.application.repository.RdarFileProcessRepository;
	
@Service
public class RdarFileProcessService  {	
	private static final Logger log = LoggerFactory.getLogger(RdarFileProcessService.class);
	
	@Autowired
	private RdarFileProcessRepository rdarFileProcessRepository;
	
	private A01_XXXXXXLayout a01_XXXXXXLayout; 
	private A02_XXXXXXLayout a02_XXXXXXLayout; 
	private A03_XXXXXXLayout a03_XXXXXXLayout; 
	
	public void readPayloadFileProcessLayouts(String json) {
	    try {
	        ObjectMapper mapper = new ObjectMapper();
	        JsonNode root = mapper.readTree(json);
	        
	        root.at("/A01_XXXXXXLayout").forEach(node -> {
	        	a01_XXXXXXLayout = getA01_XXXXXXLayoutFromNode(node);
	        });

	        root.at("/A02_XXXXXXLayout").forEach(node -> {
	        	a02_XXXXXXLayout = getA02_XXXXXXLayoutFromNode(node);
	        });
	        
	        root.at("/A03_XXXXXXLayout").forEach(node -> {
	        	a03_XXXXXXLayout = getA03_XXXXXXLayoutFromNode(node);
	        });
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	private A01_XXXXXXLayout getA01_XXXXXXLayoutFromNode(JsonNode node) {
		a01_XXXXXXLayout = new A01_XXXXXXLayout();
		
		a01_XXXXXXLayout.setHeaderField(loadHeaderField(node));
		a01_XXXXXXLayout.setTrailerField(loadTrailerField(node));
		
	    return a01_XXXXXXLayout;
	}

	private A02_XXXXXXLayout getA02_XXXXXXLayoutFromNode(JsonNode node) {
		a02_XXXXXXLayout = new A02_XXXXXXLayout();
		
		a02_XXXXXXLayout.setHeaderField(loadHeaderField(node));
		a02_XXXXXXLayout.setTrailerField(loadTrailerField(node));
		
	    return a02_XXXXXXLayout;
	}

	private A03_XXXXXXLayout getA03_XXXXXXLayoutFromNode(JsonNode node) {
		a03_XXXXXXLayout = new A03_XXXXXXLayout();
		
		a03_XXXXXXLayout.setHeaderField(loadHeaderField(node));
		a03_XXXXXXLayout.setTrailerField(loadTrailerField(node));
		
	    return a03_XXXXXXLayout;
	}

	private HeaderField loadHeaderField(JsonNode node) {
		HeaderField headerField = new HeaderField();
		
		headerField.setTipoArquivo(node.at("/tipoArquivo").asText());
		
		NumLoteField numLoteField = new NumLoteField();
		numLoteField.setStart(node.at("/start").intValue());
		numLoteField.setEnd(node.at("/end").intValue());
		numLoteField.setType(node.at("/type").asText());
		headerField.setNumLoteField(numLoteField);
		
		DtArquivoField dtArquivoField = new DtArquivoField();
		dtArquivoField.setStart(node.at("/start").intValue());
		dtArquivoField.setEnd(node.at("/end").intValue());
		dtArquivoField.setType(node.at("/type").asText());
		dtArquivoField.setPattern(node.at("/pattern").asText());
		headerField.setDtArquivoField(dtArquivoField);
		
		return headerField;
	}
	
	private TrailerField loadTrailerField(JsonNode node) {
		TrailerField trailerField = new TrailerField();

		trailerField.setTipoArquivo(node.at("/tipoArquivo").asText());

		return trailerField;
	}

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