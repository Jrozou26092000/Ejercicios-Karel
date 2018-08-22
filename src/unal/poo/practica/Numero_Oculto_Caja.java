package unal.poo.practica;

import becker.robots.*;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class Numero_Oculto_Caja
{    
       //Declaracion de Variables -- Forma temporal - No es buena practica tener
       //variables estaticas
        public static City objetos;
        public static Robot estudiante;
        
	public static void main (String[] args){
            //Declarar la creacion de la ciudad
            objetos = new City("Field.txt");
	    objetos.showThingCounts(true);
            
            //Direction.NORTH, EAST, SOUTH, WEST
            //Definicion de la ubicacion del robot, Ciudad, posicion, Direccion, Numero things en el bolso.
            estudiante = new Robot(objetos,6, 2, Direction.NORTH,0);
            boolean[]x;
            x = new boolean[16];
            int N1= recorrer(x);
            int N2= recorrer(x);
            int N3= recorrer(x);
            System.out.println(N1);
            System.out.println(N2);
            System.out.println(N3);
        }
        public static int recorrer(boolean[] x){
            int c =0;
            for(int i=0;i<5;i++){
                while(estudiante.frontIsClear()==true){
                    estudiante.move();
                    if(estudiante.canPickThing()==true){
                        x[c]=true;
                        c++;
                        estudiante.pickThing();
                    }else{
                        x[c]=false;
                        c++;
                    }
                }
                estudiante.turnLeft();
            }
            estudiante.move();
            estudiante.turnLeft();
            for(int i=0;i<5;i++){
                estudiante.move();
            }
            estudiante.turnLeft();
            for(int i=0;i<3;i++){
                estudiante.move();
            }
            estudiante.turnLeft();
            int k = estudiante.countThingsInBackpack();
            while(estudiante.countThingsInBackpack()!=0){
                estudiante.putThing();
            }
            switch(k){
                case 5: return 1;
                case 9: return 4;
                case 7: return 7;
                case 13: return 8;
                case 11: return compara2(x);
                case 12: return compara1(x);
                default: break;
            }
            return -1;
        }
        public static int compara1(boolean[]x){
            boolean cero[]={true,false,false,false,true,true,true,true,true,true};
            boolean seis[]={true,false,true,false,true,true,true,true,true,true};
            boolean nueve[]={true,false,true,false,true,true,true,true,false,true};
            int a=comparar(x,cero);
            int b=comparar(x,seis);
            int c=comparar(x,nueve);
            if (0<a) {
                return 0;
            }
            if(0<b){
                return 6;
            }
            if (0<c) {
                return 9;
            }
            return -1;
        }
        public static int compara2(boolean[]x){
            boolean dos[]={true,false,true,false,true,true,false,true,true,true};
            boolean tres[]={true,false,true,false,true,true,false,true,false,true};
            boolean cinco[]={true,false,true,false,true,true,true,true,false,true};
            int a=comparar(x,dos);
            int b=comparar(x,tres);
            int c=comparar(x,cinco);
            if (0<a) {
                return 2;
            }
            if(0<b){
                return 3;
            }
            if (0<c) {
                return 5;
            }
            return -1;
        }
        public static int comparar(boolean[] x,boolean y[]){
            int c=0;
            for (int j = 0; j < 10; j++) {
                if (x[j]==y[j]) {
                    c++;
                }
            }
            if(c==10){
                return 1;
            }
            return -1;
        }
}
