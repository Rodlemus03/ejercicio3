public class vehiculo {
    private String marca,placa,color;
    private int modelo;
    public vehiculo(String marca, String placa, String color, int modelo){
        this.marca=marca;
        this.placa=placa;
        this.color=color;
        this.modelo=modelo;
    }
    //gets
    public String getMarca(){return this.marca;}
    public String getPlaca(){return this.placa;}
    public String getColor(){return this.color;}
    public int getModelo(){return this.modelo;}
    public String toString(){
        String cadena="";
        cadena+="\nMarca: "+this.marca;
        cadena+="\nplaca: "+this.placa;
        cadena+="\ncolor: "+this.color;
        cadena+="\nmodelo: "+this.modelo;
        return cadena;
    }
}
