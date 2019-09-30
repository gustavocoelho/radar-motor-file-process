package br.com.boavista.radarmotor.radarmotorfileprocess.application.layout;

public class TrailerField {
	
	private String tipoArquivo;
	
	public TrailerField() {
	}

	public String getTipoArquivo() {
		return tipoArquivo;
	}

	public void setTipoArquivo(String tipoArquivo) {
		this.tipoArquivo = tipoArquivo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		TrailerField other = (TrailerField) obj;
		if (tipoArquivo == null) {
			if (other.tipoArquivo != null)
				return false;
		} else if (!tipoArquivo.equals(other.tipoArquivo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrailerField [tipoArquivo=" + tipoArquivo + "]";
	}
	
}
