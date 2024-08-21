//Librerías necesarias para el proyecto
import java.util.Scanner;//Lectura de datos desde el teclado

//Clase principal del Sistema de Renta de videos, es decir, será el gestor de las dos clases
//donde se pedirán los datos para hacer los ingresos de nuevos videos, rentas, eliminaciones etc
public class Main {
    public static void main(String args[])
    {
        //Variables
        int otro=1;
        int opcion, identificador;
        float calif;
        String nombre, clasificacion;
        

        //Creación de un objeto de tipo Scanner para leer datos desde el teclado
        Scanner leer = new Scanner(System.in);


        //Creación de objetos de tipo Video
        Video video1 = new Video(1,"Perros de reserva", "A");
        Video video2 = new Video(2, "Star Wars Episodio III: La venganza de los Sith", "B");
        Video video3 = new Video(3, "El señor de los anillos II: Las 2 torres", "C");
        Video video4 = new Video(4, "El eterno resplandor", "D");  
    
        
        //Creación de un objeto de tipo SistemaVideo
        SistemaVideo sistema = new SistemaVideo();


        //Agregando los videos al sistema
        sistema.agregarVideo(video1);
        sistema.agregarVideo(video2);
        sistema.agregarVideo(video3);
        sistema.agregarVideo(video4);


        System.out.println("\nSistema de renta de videos");

        //Código del menú del sistema de renta de videos
        while(otro==1) 
        {
            System.out.println("\nOpcion\tAccion a realizar");
            System.out.println("1\tAgregar nuevo video al sistema");
            System.out.println("2\tEliminar video");
            System.out.println("3\tRegistrar una renta de un video");
            System.out.println("4\tCalificar un video");
            System.out.println("5\tMostrar calificacion promedio de un cliente");
            System.out.println("6\tMostrar el inventario");
            System.out.println("7\tSalir");

            System.out.println("\nIngrese el numero de la opcion que desea realizar: ");
            opcion = leer.nextInt();

            switch(opcion) 
            {
                case 1:
                    //Pedir información del video para agregarlo al sistema
                    System.out.println("\nIngrese el identificador del video: ");
                    identificador = leer.nextInt();
                    leer.nextLine();
                    System.out.println("Ingrese el nombre del video: ");
                    nombre = leer.nextLine();
                    System.out.println("Ingrese la clasificacion del video: ");
                    clasificacion = leer.nextLine();

                    Video nuevoVideo = new Video(identificador, nombre, clasificacion);
                    
                    sistema.agregarVideo(nuevoVideo);
                    break;
                
                case 2:
                    //Solicitando ID del video para poder eliminarlo
                    System.out.println("\nIngrese el identificador del video: ");
                    identificador = leer.nextInt();
                    
                    sistema.eliminarVideo(identificador);
                    break;

                case 3:
                    //Solicitando ID del video para poder rentarlo
                    System.out.println("Ingrese el ID del video que desea rentar: ");
                    identificador = leer.nextInt();
                    
                    sistema.registrarRenta(identificador);
                    break;

                case 4:
                    //Solicitando ID del video para poder calificarlo
                    System.out.println("Ingrese el identificador del video que desea calificar: ");
                    identificador = leer.nextInt();
                    System.out.println("Ingrese la calificacion que quiere dar al video: ");
                    calif = leer.nextFloat();

                    sistema.asignarCalificacion(identificador, calif);
                    break;

                case 5:
                    //Solicitando el ID del video para conocer el promedio de calificaciones
                    System.out.println("Ingrese el id del video que desea saber el promedio de calificaciones recibidas: ");
                    identificador = leer.nextInt();
                    
                    sistema.mostrarCalifPromedio(identificador);
                    break;

                case 6:
                    //Mostrar el inventario de los videos que hay en el sistema
                    sistema.mostrarInventario();
                    break;

                case 7:
                    //Fin de la ejecución del programa
                    otro = 2;
                    break;

                default:
                    //Opción ingresada es errónea
                    System.out.println("La opcion ingresada no es valida");
            }
        }    
    }
}