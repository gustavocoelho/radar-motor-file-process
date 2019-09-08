
package br.com.boavista.radarmotor.radarmotorfileprocess.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.boavista.radarmotor.radarmotorfileprocess.application.entity.RdarFileProcessEntity;

@Repository
public interface RdarFileProcessRepository extends JpaRepository<RdarFileProcessEntity, Long> {

	List<RdarFileProcessEntity> findByTipoArquivo(String tipoArquivo);
	
}