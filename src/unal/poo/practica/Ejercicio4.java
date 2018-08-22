package unal.poo.practica;

import becker.robots.*;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class Ejercicio4
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
            estudiante = new Robot(objetos,0, 1, Direction.SOUTH,0);
            estudiante.move();
            for (int i = 0; i < 4; i++) {
                    while (estudiante.canPickThing()==true) {                        
                        estudiante.pickThing();
                    };
                    estudiante.turnLeft();
                    int k = estudiante.countThingsInBackpack();
                    while (estudiante.countThingsInBackpack()>0) {                        
                        estudiante.putThing();
                        estudiante.move();
                    };
                    for(int j=0;j<2;j++){
                        estudiante.turnLeft();
                    };
                    while (0<k) {                    
                            estudiante.move();
                            k--;
                    }
                    estudiante.turnLeft();
                    estudiante.move();
            }
        }
}

