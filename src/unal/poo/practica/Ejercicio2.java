package unal.poo.practica;

import becker.robots.*;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class Ejercicio2
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
            estudiante = new Robot(objetos,1, 2, Direction.WEST,0);
            for (int i = 0; i < 7; i++) {
                if((estudiante.frontIsClear()==true)&&(estudiante.canPickThing()==false)){
                    estudiante.move();
                }else if((estudiante.frontIsClear()==false)&&(estudiante.countThingsInBackpack()==0)){
                    estudiante.turnLeft();
                    estudiante.move();
                }else if((estudiante.frontIsClear()==true)&&(estudiante.canPickThing()==true)){
                    estudiante.pickThing();
                    for(int k=0;k<2;k++){
                        estudiante.turnLeft();
                    }
                }else{
                    for(int l=0;l<3;l++){
                        estudiante.turnLeft();
                    }
                    estudiante.move();
                }
            }
	} 
}

