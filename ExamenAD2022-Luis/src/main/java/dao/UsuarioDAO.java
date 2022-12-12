package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Statement.RETURN_GENERATED_KEYS;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Usuario;

public class UsuarioDAO {
    
    private Connection connection;
    
    /* Completar consultas */
    static final String INSERT_QUERY ="INSERT INTO usuario(nombre,apellidos,dni) VALUES(?,?,?)";
    static final String LIST_QUERY="SELECT * FROM usuario";
    static final String GET_BY_DNI="SELECT * FROM usuario WHERE dni = ?";
    
    
    public void connect(){
        String url = "Jdbc:mysql://localhost:3306/examen.sql?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String user = "root";
        String password = "";
                
        try {
            /* completar código de conexión */
            connection = DriverManager.getConnection(url, user, password);     
            System.out.println("Conexion correcta!!!");
        }catch(Exception ex){
            System.out.println("Error al conectar a la base de datos");
            System.out.println("ex");
        }     
    }
    
    public void close(){
        try {
            connection.close();
        } catch (Exception ex) {
            System.out.println("Error al cerrar la base de datos");     
        }
    }
    
    public void save(Usuario user){
        
        /**
         * Completar código para guardar un usuario 
         * Este método no debe generar el id del usuario, ya que la base
         * de datos es la que lo genera.
         * Una vez obtenido el id del usuario tras la consulta sql,
         * hay que modificarlo en el objeto que se pasa como parámetro 
         * de forma que pase a tener el id correcto.
         */

        try{
           PreparedStatement ps = connection.prepareStatement(INSERT_QUERY,RETURN_GENERATED_KEYS);
           ps.setString(1, user.getNombre());
           ps.setString(2, user.getApellidos());
           ps.setString(3, user.getDni());
           ps.executeUpdate();
           
           ResultSet ids = ps.getGeneratedKeys();
           ids.next();
           user.setId( (long)(ids.getInt(1)) );
           System.out.println(user);
            
        }catch(Exception ex){
           Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("Error al añadir");
           System.out.println(ex);
        }
       
        System.out.println("Método save  completado");

    }

    public ArrayList<Usuario> list(){

        var salida = new ArrayList<Usuario>(0);
        
        /* Completar código para devolver un arraylist con todos los usuarios */
        
        System.out.println("Método list  completado");
       
        try(Statement st= connection.createStatement()){
            ResultSet resultado = st.executeQuery(LIST_QUERY);
            while(resultado.next()){
                Usuario user = new Usuario();
                user.setNombre(resultado.getString("nombre"));
                user.setApellidos(resultado.getString("apellidos"));
                user.setDni(resultado.getString("dni"));
                
                salida.add(user);

                
            }
            
        }catch(SQLException ex){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return salida;
    }    
    
    public Usuario getByDNI(String dni){
        
        Usuario salida = new Usuario();

        /**
         * Completar código para devolver el usuario que tenga ese dni.
         * Si no existe, se debe devolver null
         */
        
        System.out.println("Método getByDNI no completado");

        return salida;
    }    
}
