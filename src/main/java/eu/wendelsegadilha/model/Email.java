package eu.wendelsegadilha.model;

public class Email {
	
	private String email;
	private String senha;
	private String remetente;
	private String destinatario;
	private String assunto;
	private String mensagem;
	
	public Email() {
	}

	public Email(String email, String senha, String remetente, String destinatario, String assunto, String mensagem) {
		super();
		this.email = email;
		this.senha = senha;
		this.remetente = remetente;
		this.destinatario = destinatario;
		this.assunto = assunto;
		this.mensagem = mensagem;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getRemetente() {
		return remetente;
	}
	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
