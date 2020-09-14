package StepDefinitions;

import cucumber.api.java.en.Given;

import java.sql.*;
import java.util.Properties;




public class DBConnectionAndQueryDB {

    @Given("^Connect to postgres DB Server$")
     public static void connect_to_postgres_DB_Server() throws SQLException, Throwable {
        String url = "jdbc:postgresql://10.149.213.77:8443/idfs";
        Properties props = new Properties();
        props.setProperty("user","identityservice");
        props.setProperty("password","Abcd1234!");
        //props.setProperty("ssl","true");
        Connection conn = DriverManager.getConnection(url, props);
        System.out.println("BD Conexion start....");
    }

    @Given("^Run Query Reset Password$")
    public static void run_Query_Reset_Password() throws SQLException, Throwable {
        String url = "jdbc:postgresql://10.149.213.77:8443/idfs";
        Properties props = new Properties();
        props.setProperty("user","identityservice");
        props.setProperty("password","Abcd1234!");
        connect_to_postgres_DB_Server();
        Connection conn = DriverManager.getConnection(url, props);
        //Creando el Statement
        Statement stmt = conn.createStatement();
        String SelectQuery = "select su.userid,su.userstatus,su.failedlogins,su.password,su.securityuserid from securityuser su,organization o where o.code='systemtronik' and su.organizationid=o.id";
        //String SelectQuery = "select resetpassword('PruebaTEST','password')";
        ResultSet rs = stmt.executeQuery(SelectQuery);
        while (rs.next()){
            String name = rs.getString(1);
            System.out.println(name);
            break;
        }
        //close Conexion
        conn.close();

    }

    @Given("^Runnig Query Add new Users, user=\"([^\"]*)\", password=\"([^\"]*)\", firstname= \"([^\"]*)\", lastname = \"([^\"]*)\", email= \"([^\"]*)\", systemcode = \"([^\"]*)\", clientcode = \"([^\"]*)\", role = \"([^\"]*)\"$")
    public void runnig_Query_Add_new_Users_user_password_firstname_lastname_email_systemcode_clientcode_role(String user, String password, String firstname, String lastname, String email, String systemcode, String clientcode, String rol) throws SQLException, Throwable {
        String url = "jdbc:postgresql://10.149.213.77:8443/idfs";
        Properties props = new Properties();
        props.setProperty("user","identityservice");
        props.setProperty("password","Abcd1234!");
        connect_to_postgres_DB_Server();
        Connection conn = DriverManager.getConnection(url, props);
        //Creando el Statement
        Statement stmt = conn.createStatement();
        String SelectQuery = "select su.userid,su.userstatus,su.failedlogins,su.password,su.securityuserid from securityuser su,organization o where o.code='systemtronik' and su.organizationid=o.id";
        //String SelectQuery = "SELECT addNewUserToAnySystem('"+user+"','"+password+"', '"+firstname+"','"+lastname+"','"+email+"','"+systemcode+"','"+clientcode+"','"+rol+"')";
        ResultSet rs = stmt.executeQuery(SelectQuery);
    }

    @Given("^adding rol on Users user = \"([^\"]*)\", clientcode=\"([^\"]*)\",systemcode = \"([^\"]*)\", rol=\"([^\"]*)\"$")
    public void adding_rol_on_Users_user_clientcode_systemcode_rol(String user, String clientcode, String systemcode, String rol) throws SQLException, Throwable {
        String url = "jdbc:postgresql://10.149.213.77:8443/idfs";
        Properties props = new Properties();
        props.setProperty("user","identityservice");
        props.setProperty("password","Abcd1234!");
        connect_to_postgres_DB_Server();
        Connection conn = DriverManager.getConnection(url, props);
        //Creando el Statement
        Statement stmt = conn.createStatement();
        String SelectQuery = "SELECT addRoleToUser('"+user+"','"+clientcode+"', '"+systemcode+"','"+rol+"')";
        ResultSet rs = stmt.executeQuery(SelectQuery);
    }

    @Given("^Remove rol on Users user = \"([^\"]*)\", clientcode=\"([^\"]*)\",systemcode = \"([^\"]*)\", rol=\"([^\"]*)\"$")
    public void remove_rol_on_Users_user_clientcode_systemcode_rol(String user, String clientcode, String systemcode, String rol) throws SQLException, Throwable {
        String url = "jdbc:postgresql://10.149.213.77:8443/idfs";
        Properties props = new Properties();
        props.setProperty("user","identityservice");
        props.setProperty("password","Abcd1234!");
        connect_to_postgres_DB_Server();
        Connection conn = DriverManager.getConnection(url, props);
        //Creando el Statement
        Statement stmt = conn.createStatement();
        String SelectQuery = "SELECT removeRoleFromUser('"+user+"','"+clientcode+"', '"+systemcode+"','"+rol+"')";
        ResultSet rs = stmt.executeQuery(SelectQuery);
    }

    @Given("^Adding Group Rol on User IdGroup=\"([^\"]*)\",clientcode=\"([^\"]*)\",systemcode = \"([^\"]*)\", user = \"([^\"]*)\"$")
    public void adding_Group_Rol_on_User_IdGroup_clientcode_systemcode_user(Integer idgroup, String clientcode, String systemcode, String user) throws SQLException, Throwable {
        String url = "jdbc:postgresql://10.149.213.77:8443/idfs";
        Properties props = new Properties();
        props.setProperty("user","identityservice");
        props.setProperty("password","Abcd1234!");
        connect_to_postgres_DB_Server();
        Connection conn = DriverManager.getConnection(url, props);
        //Creando el Statement
        Statement stmt = conn.createStatement();
        String SelectQuery = "select assigngroupwithclientcodesystemcodeforuser("+idgroup+",'"+clientcode+"','"+systemcode+"', '"+user+"')";
        ResultSet rs = stmt.executeQuery(SelectQuery);
    }

    @Given("^Remove Group Rol on User IdGroup=\"([^\"]*)\",clientcode=\"([^\"]*)\",systemcode = \"([^\"]*)\", user = \"([^\"]*)\"$")
    public void remove_Group_Rol_on_User_IdGroup_clientcode_systemcode_user(Integer idgroup, String clientcode, String systemcode, String user) throws SQLException, Throwable {
        String url = "jdbc:postgresql://10.149.213.77:8443/idfs";
        Properties props = new Properties();
        props.setProperty("user","identityservice");
        props.setProperty("password","Abcd1234!");
        connect_to_postgres_DB_Server();
        Connection conn = DriverManager.getConnection(url, props);
        //Creando el Statement
        Statement stmt = conn.createStatement();
        String SelectQuery = "select removegroupwithclientcodesystemcodeforuser("+idgroup+",'"+clientcode+"','"+systemcode+"', '"+user+"')";
        ResultSet rs = stmt.executeQuery(SelectQuery);
    }

}
