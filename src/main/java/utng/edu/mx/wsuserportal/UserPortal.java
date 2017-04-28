package utng.edu.mx.wsuserportal;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

/**
 * Created by danie on 26/04/2017.
 */

public class UserPortal implements KvmSerializable{

    private int id;
    private String  portal;
    private String  userPotall;
    private String  createDate;
    private String  autorised;
    private String  isdeleted;
    private String   refreshRoles;


    public UserPortal(int id, String portal, String userPotall, String createDate, String autorised, String isdeleted, String refreshRoles) {
        this.id = id;
        this.portal = portal;
        this.userPotall = userPotall;
        this.createDate = createDate;
        this.autorised = autorised;
        this.isdeleted = isdeleted;
        this.refreshRoles = refreshRoles;
    }
    public UserPortal() {

        this(0,"","","","","","");
    }
    @Override
    public Object getProperty(int i) {
        switch (i) {
            case 0:
                return id;
            case 1:
                return portal;
            case 2:
                return userPotall;
            case 3:
                return createDate;
            case 4:
                return  autorised;
            case 5:
                return  isdeleted;
            case 6:
                return  refreshRoles;



        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 7;
    }

    @Override
    public void setProperty(int i, Object o) {
        switch (i) {
            case 0:
                id = Integer.parseInt(o.toString());
                break;
            case 1:
                portal = o.toString();
                break;
            case 2:
                userPotall = o.toString();
                break;
            case 3:
                createDate = o.toString();
                break;
            case 4:
                autorised = o.toString();
                break;
            case 5:
                isdeleted= o.toString();
                break;
            case 6:
                refreshRoles = o.toString();




        }

    }

    @Override
    public void getPropertyInfo(int i, Hashtable hashtable, PropertyInfo propertyInfo) {
        switch (i) {
            case 0:
                propertyInfo.type = PropertyInfo.INTEGER_CLASS;
                propertyInfo.name = "id";
                break;
            case 1:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "portal";
                break;
            case 2:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "userPortall";
                break;

            case 3:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "createDate";
                break;
            case 4:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "autorised";
                break;
            case 5:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "isdeleted";
                break;

            case 6:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "refreshRoles";
                break;


            default:
                break;
        }

    }



}