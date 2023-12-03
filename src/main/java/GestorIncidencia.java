
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class GestorIncidencia {

	public static void main(String[] args) {
		
		try {
						
			ConexionDB.conexionDB();
	       
           //**hacer un menu con opciones para: ABM cliente -- Repotar  Incidente--listar técnicos - salir
	      int op=0;
              do{
               op = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. RRHH\n"+
                                "2. Area Comercial\n"+
                                "3. Mesa de Ayuda\n"+
                                "4. Area Tecnica\n"+
                                "5. Salir\n", "Sistema Reporte Incidentes 2023", JOptionPane.QUESTION_MESSAGE));
               switch(op){
                  case 1:
                     Tecnico t= new Tecnico();
                     int opRRHH = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1.Alta de Tecnicos\n"
                                + "2.Baja de Tecnicos\n"
                                + "3.Modificar Tecnicos ", JOptionPane.QUESTION_MESSAGE)); 
                        switch (opRRHH){
                            case 1:
                                 t= Tecnico.altaTecnico();
                                 ConexionDB.altaTecnicoDB(t);
                        }
                  case 2:
                      Cliente c= new Cliente();
                      int opAreaComercial = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1.Alta de Clientes\n"
                                + "2.Baja Clientes\n"
                                + "3.Modificar Clientes ", JOptionPane.QUESTION_MESSAGE)); 
                        switch (opAreaComercial){
                            case 1:
                                 c= Cliente.altaCliente();
                                 ConexionDB.altaClienteDB(c);
                        }
                  case 3:
                    Incidente i= Incidente.altaIncidente();
                    ConexionDB.altaIncidenteDB(i);
               }
              }while(op!=5);
              
	     
		}catch(Exception obj) {
		    	
		    System.out.println("Error en ABM de la base de datos MAIN");
		    System.out.println(obj.fillInStackTrace());
		    }

	}

	
}
        

