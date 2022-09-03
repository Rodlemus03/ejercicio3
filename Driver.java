
import java.text.StringCharacterIterator;
import java.util.Scanner;
public class Driver{
    public static void main(String[] args) {
        int contadorGlobal=0;
        Scanner teclado=new Scanner(System.in);
        Crud consultas=new Crud();
        
        int seleccion=0;
        while(seleccion!=6){
            System.out.println("\n\n\n");
            System.out.println("1. Ampliar parqueo");
            System.out.println("2. Verificar espacio");
            System.out.println("3. Asignar parqueo");
            System.out.println("4. Carro salir");
            System.out.println("5. Analisis");
            System.out.println("6. Salir");
            System.out.println("Ingresa la opcion que deseas ");
            seleccion=teclado.nextInt();
            if(seleccion==1){
                double ancho,largo,alto;
                boolean aereo;
                String tipo,entradaAereo;
                int eleccionTipo=3;
                System.out.println("Es aereo? y/n");
                entradaAereo=teclado.next();
                if(entradaAereo.equalsIgnoreCase("y")){
                    aereo=true;
                    System.out.println("Ingresa la altura ");
                    alto=teclado.nextDouble();
                }else{
                    aereo=false;
                    alto=0;
                }
                System.out.println("1. us. compact");
                System.out.println("2. us standar");
                System.out.println("3. us. standar large");
                eleccionTipo=teclado.nextInt();
                if(eleccionTipo==1){
                    ancho=2.44;
                    largo=4.88;
                    tipo="us. compact";
                }else if(eleccionTipo==2){
                    tipo="us. standar";
                    ancho=2.59;
                    largo=5.48;
                }else if(eleccionTipo==3){
                    tipo="us. standar large";
                    ancho=2.74;
                    largo=6.1;
                }else{
                    tipo="us. standar";
                    ancho=2.59;
                    largo=5.48;
                }
                consultas.Create(ancho, largo, alto, aereo, tipo,false,"estacionamiento");
            }else if(seleccion==2){
                consultas.readDisponibles();
            }else if(seleccion==3){
                

                int cantidad=consultas.disponiblesCantidad();
                System.out.println("Hay "+cantidad+" de carros");
                String marca="",placa="",color="";
                int modelo=0;
                System.out.println("Ingrese la marca ");
                marca=teclado.next();
                System.out.println("Ingrese la placa");
                placa=teclado.next();
                System.out.println("Ingresa el color ");
                color=teclado.next();
                System.out.println("Ingresa el modelo");
                modelo=teclado.nextInt();
                vehiculo carro=new vehiculo(marca, placa, color, modelo);
                consultas.CreateCarro(carro.getMarca(), carro.getPlaca(), carro.getColor(), carro.getModelo());
                contadorGlobal++;




            }else if(seleccion==4){
                consultas.readOcupados();
                int id;
                System.out.println("Ingresa el numero de parqueo que se va a vaciar");
                id=teclado.nextInt();
                consultas.Modificar(id);
            }else if(seleccion==5){
                int cantidad=0,cantidadLlenos=0;
                int[] llenos=new int[cantidadLlenos];
                int[] vacios=new int[cantidad];
                cantidad=consultas.disponiblesCantidad();
                System.out.println("Hay "+cantidad+" parqueos disponibles");
                String cadena1="",cadena2="";
                for(int i=0;i<vacios.length;i++){cadena1+="| ";}cadena1+="|";
                System.out.println(cadena1);
                cantidadLlenos=(consultas.cantidadRegistrosOcupado());
                for(int k=0;k<llenos.length;k++){cadena2+="|o";}cadena1+="|";
                System.out.println("Hay "+cantidadLlenos+" llenos");
                System.out.println("Cantidad de carros ingresados: "+contadorGlobal);
                System.out.println(cadena2);
            }else if(seleccion==6){
                System.out.println("Feliz dia");
            }else{
                System.out.println("Ingresa una opcion correcta porfavor");
            }
        }
    }
}