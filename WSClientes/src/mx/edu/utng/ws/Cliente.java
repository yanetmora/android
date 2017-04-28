package mx.edu.utng.ws;

public class Cliente {

	private int id;
	private String apellidos;
	private String nombre;
	private String nombreCompleto;
	private String correoElectronico;
	private String compania;
	private String cargo;
	private String telefonoTrabajo;
	private String telefonoParticular;
	private String telefonoMovil;
	private String numeroFax;
	private String direccion;
	private String ciudad;
	private String estado;
	private String codigoPostal;
	
	

	
	
	
	
	public Cliente(int id, String apellidos, String nombre, String nombreCompleto, String correoElectronico,
			String compania, String cargo, String telefonoTrabajo, String telefonoParticular, String telefonoMovil,
			String numeroFax, String direccion, String ciudad, String estado, String codigoPostal) {
		super();
		this.id = id;
		this.apellidos = apellidos;
		this.nombre = nombre;
		this.nombreCompleto = nombreCompleto;
		this.correoElectronico = correoElectronico;
		this.compania = compania;
		this.cargo = cargo;
		this.telefonoTrabajo = telefonoTrabajo;
		this.telefonoParticular = telefonoParticular;
		this.telefonoMovil = telefonoMovil;
		this.numeroFax = numeroFax;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.estado = estado;
		this.codigoPostal = codigoPostal;
	}





	public Cliente(){
		this(0,"","","","","","","","","","","","","","");
		
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}










	public String getApellidos() {
		return apellidos;
	}





	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}





	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public String getNombreCompleto() {
		return nombreCompleto;
	}





	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}





	public String getCorreoElectronico() {
		return correoElectronico;
	}





	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}





	public String getCompania() {
		return compania;
	}





	public void setCompania(String compania) {
		this.compania = compania;
	}





	public String getCargo() {
		return cargo;
	}





	public void setCargo(String cargo) {
		this.cargo = cargo;
	}





	public String getTelefonoTrabajo() {
		return telefonoTrabajo;
	}





	public void setTelefonoTrabajo(String telefonoTrabajo) {
		this.telefonoTrabajo = telefonoTrabajo;
	}





	public String getTelefonoParticular() {
		return telefonoParticular;
	}





	public void setTelefonoParticular(String telefonoParticular) {
		this.telefonoParticular = telefonoParticular;
	}





	public String getTelefonoMovil() {
		return telefonoMovil;
	}





	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}





	public String getNumeroFax() {
		return numeroFax;
	}





	public void setNumeroFax(String numeroFax) {
		this.numeroFax = numeroFax;
	}





	public String getDireccion() {
		return direccion;
	}





	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}





	public String getCiudad() {
		return ciudad;
	}





	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}





	public String getEstado() {
		return estado;
	}





	public void setEstado(String estado) {
		this.estado = estado;
	}





	public String getCodigoPostal() {
		return codigoPostal;
	}





	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}





	@Override
	public String toString() {
		return "Cliente [id=" + id + ", apellidos=" + apellidos + ", nombre=" + nombre + ", nombreCompleto="
				+ nombreCompleto + ", correoElectronico=" + correoElectronico + ", compania=" + compania + ", cargo="
				+ cargo + ", telefonoTrabajo=" + telefonoTrabajo + ", telefonoParticular=" + telefonoParticular
				+ ", telefonoMovil=" + telefonoMovil + ", numeroFax=" + numeroFax + ", direccion=" + direccion
				+ ", ciudad=" + ciudad + ", estado=" + estado + ", codigoPostal=" + codigoPostal + "]";
	}





	
	
	



}