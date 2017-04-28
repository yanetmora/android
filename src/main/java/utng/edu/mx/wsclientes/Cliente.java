package utng.edu.mx.wsclientes;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;



public class Cliente  implements KvmSerializable{
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

    public Cliente(int id, String apellidos, String nombre, String nombreCompleto,
                   String correoElectronico, String compania, String cargo, String telefonoTrabajo,
                   String telefonoParticular, String telefonoMovil, String numeroFax,
                   String direccion, String ciudad, String estado, String codigoPostal) {
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

    @Override
    public Object getProperty(int i) {
        switch (i){
            case 0 :
                return id;
            case 1:
                return apellidos;
            case 2:
                return nombre;
            case 3:
                return nombreCompleto;
            case 4:
                return correoElectronico;
            case 5:
                return compania;
            case 6:
                return cargo;
            case 7:
                return telefonoTrabajo;
            case 8:
                return telefonoParticular;
            case 9:
                return telefonoMovil;
            case 10:
                return numeroFax;
            case 11:
                return direccion;
            case 12:
                return ciudad;
            case 13:
                return estado;
            case 14:
                return codigoPostal;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 15;
    }

    @Override
    public void setProperty(int i, Object o) {
        switch (i){
            case 0 :
                id = Integer.parseInt(o.toString());
                break;
            case 1:
                apellidos = o.toString();
                break;
            case 2:
                nombre = o.toString();
                break;
            case 3:
                nombreCompleto = o.toString();
                break;
            case 4:
                correoElectronico = o.toString();
                break;
            case 5:
                compania = o.toString();
                break;
            case 6:
                cargo = o.toString();
                break;
            case 7:
                telefonoTrabajo = o.toString();
                break;
            case 8:
                telefonoParticular = o.toString();
                break;
            case 9:
                telefonoMovil = o.toString();
                break;
            case 10:
                numeroFax = o.toString();
                break;
            case 11:
                direccion = o.toString();
                break;
            case 12:
                ciudad = o.toString();
                break;
            case 13:
                estado = o.toString();
                break;
            case 14:
                codigoPostal = o.toString();
                break;
        }

    }

    @Override
    public void getPropertyInfo(int i, Hashtable hashtable, PropertyInfo propertyInfo) {
        switch (i){
            case 0 :
                propertyInfo.type = PropertyInfo.INTEGER_CLASS;
                propertyInfo.name = "id";
                break;
            case 1:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "apellidos";
                break;
            case 2:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "nombre";
                break;
            case 3:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "nombreCompleto";
                break;
            case 4:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "correoElectronico";
                break;
            case 5:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "compania";
                break;
            case 6:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "cargo";
                break;
            case 7:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "telefonoTrabajo";
                break;
            case 8:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "telefonoParticular";
                break;
            case 9:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "telefonoMovil";
                break;
            case 10:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "numeroFax";
                break;
            case 11:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "direccion";
                break;
            case 12:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "ciudad";
                break;
            case 13:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "estado";
                break;
            case 14:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "codigoPostal";
                break;
        }
    }
}
