package br.com.boavista.radarmotor.radarmotorfileprocess.application.schedule;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import br.com.boavista.radarmotor.radarmotorfileprocess.application.entity.RdarFileProcessEntity;
import br.com.boavista.radarmotor.radarmotorfileprocess.application.service.RdarFileProcessService;

@Configuration
@EnableScheduling
public class RdarFileProcessBatch {
	private Logger log = LoggerFactory.getLogger(RdarFileProcessBatch.class);	
	private static final String TIME_ZONE = "America/Sao_Paulo";
	
	@Autowired
	private RdarFileProcessService rdarFileProcessService;
	
	@Scheduled(cron = "${CRON_TIMER}", zone = TIME_ZONE)
	private void monitoringHCMExtractFiles()  throws ServiceException, Exception {
		List<RdarFileProcessEntity> rdarFileProcessList = rdarFileProcessService.findByDescription("A01");
		
		StringBuilder str = new StringBuilder();
		str.append(currentDate() + " - found " + rdarFileProcessList.size() + " saved on database for the filter informed.");
		log.info(str.toString());
	}
	
	private String currentDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); 
		Date date = new Date(); 
		return dateFormat.format(date);
	}
	
}