package br.com.boavista.radarmotor.radarmotorfileprocess.application.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the status database table.
 * 
 */
@Entity
@Table(name="rdar_file_process")
public class RdarFileProcessEntity implements Serializable {

	private static final long serialVersionUID = 1738480324613526608L;

	@Id
	@GeneratedValue
	private Long id;

	private String tipoArquivo;
	
	private Long numLote;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_arquivo")
	private Date dtArquivo;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_inc")
	private Date dtInc;

	public RdarFileProcessEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoArquivo() {
		return tipoArquivo;
	}

	public void setTipoArquivo(String tipoArquivo) {
		this.tipoArquivo = tipoArquivo;
	}

	public Long getNumLote() {
		return numLote;
	}

	public void setNumLote(Long numLote) {
		this.numLote = numLote;
	}

	public Date getDtArquivo() {
		return dtArquivo;
	}

	public void setDtArquivo(Date dtArquivo) {
		this.dtArquivo = dtArquivo;
	}

	public Date getDtInc() {
		return dtInc;
	}

	public void setDtInc(Date dtInc) {
		this.dtInc = dtInc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtArquivo == null) ? 0 : dtArquivo.hashCode());
		result = prime * result + ((dtInc == null) ? 0 : dtInc.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numLote == null) ? 0 : numLote.hashCode());
		result = prime * result + ((tipoArquivo == null) ? 0 : tipoArquivo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RdarFileProcessEntity other = (RdarFileProcessEntity) obj;
		if (dtArquivo == null) {
			if (other.dtArquivo != null)
				return false;
		} else if (!dtArquivo.equals(other.dtArquivo))
			return false;
		if (dtInc == null) {
			if (other.dtInc != null)
				return false;
		} else if (!dtInc.equals(other.dtInc))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numLote == null) {
			if (other.numLote != null)
				return false;
		} else if (!numLote.equals(other.numLote))
			return false;
		if (tipoArquivo == null) {
			if (other.tipoArquivo != null)
				return false;
		} else if (!tipoArquivo.equals(other.tipoArquivo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RdarFileProcessEntity [id=" + id + ", tipoArquivo=" + tipoArquivo + ", numLote=" + numLote
				+ ", dtArquivo=" + dtArquivo + ", dtInc=" + dtInc + "]";
	}
	
}