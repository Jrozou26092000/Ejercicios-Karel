package unal.poo.practica;

import becker.robots.*;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class Ejecicio_6_Orden
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
            estudiante = new Robot(objetos,6, 1, Direction.EAST,0);
            while (estudiante.canPickThing()==true){
                estudiante.pickThing();
                estudiante.move();
            };
            int k = estudiante.countThingsInBackpack();
            for (int i = 0; i < 2; i++) {
                    estudiante.turnLeft();
                }
            estudiante.move();
            for (int i = k-1; 0 < i; i--) {
                estudiante.putThing();
                estudiante.move();
            };
            for (int i = 0; i < 3; i++) {
                estudiante.turnLeft();
            }
            estudiante.putThing();
            estudiante.move();
            ordenar(k);
        }
        public static int ordenar(int k){
            while (estudiante.canPickThing()==true) {                
                int c = k-1;
                for (int i = 0; i < 3; i++) {
                    estudiante.turnLeft();
                }
                for (int i = c; 0 < i; i--) {
                    if (estudiante.canPickThing()==true) {
                        estudiante.pickThing();
                    }
                    estudiante.move();
                }
                for (int i = 0; i < 2; i++) {
                    estudiante.turnLeft();
                }
                for (int j = c; 0 < j; j--) {
                    if (estudiante.countThingsInBackpack()!=0) {
                        estudiante.putThing();
                    }
                    estudiante.move();
                }
                for (int i = 0; i < 3; i++) {
                    estudiante.turnLeft();
                }
                c--;
                estudiante.move();
            }
            return 0;
        }
}

