package ajude.psoft.enumStatus;

public enum StatusEnum {
	ATIVA("Ativa"), 
	ENCERRADA("Encerrada"), 
	VENCIDA("Vencida"), 
	CONCLUIDA("Concluida");
	
	private String status;
	
	 StatusEnum(String status) {
	     this.status = status;
	  }

	 public String getStatus() {
	     return status;
	  }
}
