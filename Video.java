//Clase Video
public class Video{
    //Atributos
    private int id;
    private String titulo;
    private String clasificacion;
    private int vecesRentado;
    private int califRecibidas;
    private float calPromedioClientes;
    private float sumaCalificaciones;

    //Constructor de la clase Video
    public Video(int iden, String title, String clasif)
    {
        id = iden;
        titulo = title;
        clasificacion = clasif;
        vecesRentado = 0;
        califRecibidas = 0;
        calPromedioClientes = 0;
        sumaCalificaciones = 0;
    }

    //Métodos getter's
    public int getId()
    {
        return id;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public String getClasificacion()
    {
        return clasificacion;
    }

    public int getVecesRentado()
    {
        return vecesRentado;
    }    

    public int getCalifRecibidas()
    {
        return califRecibidas;
    }

    public float getCalPromedioClientes()
    {
        return calPromedioClientes;
    }

    //Métodos de escritura
    public void rentarVideo()
    {
        vecesRentado = vecesRentado + 1;
    }

    //Método para calificar un video
    public void calificar(float calificacion)
    {
        sumaCalificaciones = sumaCalificaciones + calificacion;
        califRecibidas++;
    }

    //Método para obtener el promedio de calificaciones de un video
    public float obtenerPromedio()
    {
        if(califRecibidas == 0)
            return 0;
        else
        {
            calPromedioClientes = sumaCalificaciones / califRecibidas;
            return calPromedioClientes;
        }
        
    }
}