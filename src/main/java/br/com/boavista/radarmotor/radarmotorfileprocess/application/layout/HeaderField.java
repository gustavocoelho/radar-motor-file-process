package br.com.boavista.radarmotor.radarmotorfileprocess.application.layout;

public class HeaderField {

	private String tipoArquivo;
	private DtArquivoField dtArquivo;
	private NumLoteField numLote;
	
	public HeaderField() {
	}

	public String getTipoArquivo() {
		return tipoArquivo;
	}

	public void setTipoArquivo(String tipoArquivo) {
		this.tipoArquivo = tipoArquivo;
	}

	public DtArquivoField getDtArquivoField() {
		return dtArquivo;
	}

	public void setDtArquivoField(DtArquivoField dtArquivoField) {
		this.dtArquivo = dtArquivoField;
	}

	public NumLoteField getNumLoteField() {
		return numLote;
	}

	public void setNumLoteField(NumLoteField numLoteField) {
		this.numLote = numLoteField;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtArquivo == null) ? 0 : dtArquivo.hashCode());
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
		HeaderField other = (HeaderField) obj;
		if (dtArquivo == null) {
			if (other.dtArquivo != null)
				return false;
		} else if (!dtArquivo.equals(other.dtArquivo))
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
		return "HeaderField [tipoArquivo=" + tipoArquivo + ", dtArquivoField=" + dtArquivo + ", numLoteField="
				+ numLote + "]";
	}
	
}
