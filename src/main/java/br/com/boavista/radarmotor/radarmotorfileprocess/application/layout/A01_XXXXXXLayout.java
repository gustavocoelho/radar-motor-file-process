package br.com.boavista.radarmotor.radarmotorfileprocess.application.layout;

public class A01_XXXXXXLayout {
	
	private HeaderField header;
	private TrailerField trailer;
	
	public A01_XXXXXXLayout() {		
	}

	public HeaderField getHeaderField() {
		return header;
	}

	public void setHeaderField(HeaderField headerField) {
		this.header = headerField;
	}

	public TrailerField getTrailerField() {
		return trailer;
	}

	public void setTrailerField(TrailerField trailerField) {
		this.trailer = trailerField;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((header == null) ? 0 : header.hashCode());
		result = prime * result + ((trailer == null) ? 0 : trailer.hashCode());
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
		A01_XXXXXXLayout other = (A01_XXXXXXLayout) obj;
		if (header == null) {
			if (other.header != null)
				return false;
		} else if (!header.equals(other.header))
			return false;
		if (trailer == null) {
			if (other.trailer != null)
				return false;
		} else if (!trailer.equals(other.trailer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "A01_XXXXXXLayout [headerField=" + header + ", trailerField=" + trailer + "]";
	}

}
