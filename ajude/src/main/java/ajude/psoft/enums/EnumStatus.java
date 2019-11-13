package ajude.psoft.enums;

public enum EnumStatus {
	ATIVA("Ativa"), ENCERRADA("Encerrada"), VENCIDA("Vencida"), CONCLUIDA("Concluida"); 
	private String statusCampanha;
	
	EnumStatus(String status) {
		this.statusCampanha = status;
	}
	public String getStatus() {
		return this.statusCampanha;
	}
}
