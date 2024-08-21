//Librerías necesarias para trabajar con listas
import java.util.ArrayList;
import java.util.List;

//Clase SistemaVideo
public class SistemaVideo {
    //Atributos
    private List<Video> videos = new ArrayList<Video>();

    //Métodos

    //Método para agregar un video al sistema
    public void agregarVideo(Video videoActual)
    {
        //Falta hacer búsqueda para que no haya duplicados
        videos.add(videoActual);
    }

    //Método para eliminar un video del sistema
    public void eliminarVideo(int id)
    {
        int posicionEliminar = -1;
        boolean encontrado = false;

        for(int i=0;i < videos.size(); i++)
            if(videos.get(i).getId() == id)
            {
                posicionEliminar = i;
                encontrado = true;
                break;
            }

        if(encontrado)
        {
            videos.remove(posicionEliminar);
            System.out.println("El video con el id " + id + " ha sido eliminado con exito");
        }
        else
            System.out.println("El video con el id " + id + " no se encuentra en el inventario");

    }

    //Método para registrar una renta de un video
    public void registrarRenta(int id)
    {
        int videoRentar = -1;
        boolean encontrado = false;

        for(int i=0;i < videos.size(); i++)
        {
            if(videos.get(i).getId() == id)
            {
                videoRentar = i;
                encontrado = true;
                break;
            }
        }

        if(encontrado)
            rentar(videos.get(videoRentar));
        else
            System.out.println("El video con el ID " + id + " no se encuentra en el inventario");

    }

    private void rentar(Video videoRentar)
    {
        videoRentar.rentarVideo();
        System.out.println("Se ha rentado el video");
    }


    //Método para asignar una calificación a un video
    public void asignarCalificacion(int id, float calificacion)
    {
        int videoCalificar = -1;
        boolean encontrado = false;

        for(int i=0;i < videos.size(); i++)
        {
            if(videos.get(i).getId() == id)
            {
                videoCalificar = i;
                encontrado = true;
                break;
            }
        }

        if(encontrado) 
        {
            enviarVideoCalificar(videos.get(videoCalificar), calificacion);
        }
        else
            System.out.println("El video con identificador " + id + " no se encuentra en el inventario");
    }


    private void enviarVideoCalificar(Video videoCalificar, float calif)
    {   
        videoCalificar.calificar(calif);
        System.out.println("El video " + videoCalificar.getTitulo() + " ha sido calificado de manera exitosa");
    }

    //Método para mostrar calificación promedio de un video
    public void mostrarCalifPromedio(int id)
    {
        int videoObtenerPromedio = -1;
        boolean encontrado = false;

        for(int i=0;i < videos.size(); i++)
        {
            if(videos.get(i).getId() == id)
            {
                videoObtenerPromedio = i;
                encontrado = true;
                break;
            }
        }

        if(encontrado)
        {
            videoObtenerPromedio(videos.get(videoObtenerPromedio));
        }
        else
        {
            System.out.println("EL video con id " + id + " no se encuentra en el inventario");
        }
    }

    private void videoObtenerPromedio(Video videoPromedio)
    {
        System.out.println("El promedio de calificaciones recibidas del video: " + videoPromedio.getTitulo() + " es " + videoPromedio.obtenerPromedio());
    }

    //Método para mostrar la información de todos los videos del inventario
    public void mostrarInventario()
    {
        //Realizar salto de línea
        System.out.println("\n");

        //Ciclo que recorre la lista de objetos
        for(Video videoActual : videos)
        {
            videoActual.obtenerPromedio();
            //Impresión de la información de cada video
            System.out.println("**************************************************************");
            System.out.println("ID del video: " + videoActual.getId());
            System.out.println("Nombre del video: " + videoActual.getTitulo());
            System.out.println("Clasificacion: " + videoActual.getClasificacion());
            System.out.println("Cantidad de veces rentado: " + videoActual.getVecesRentado());
            System.out.println("Cantidad de calificaciones recibidas: " + videoActual.getCalifRecibidas());
            System.out.println("Promedio de calificaciones: " + videoActual.getCalPromedioClientes());
            System.out.println("\n");
        }

    }

}