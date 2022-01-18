package travail;


import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import pobj.ihm.Fenetre;
import pobj.physics.CerclePhysique;
import pobj.physics.MoteurPhysique;
import pobj.physics.RectanglePhysique;
import pobj.simuagent.factory_terrain.MapFactoryFromFile_Matrix;
import pobj.tools.Vecteur2D;


public class Test {
	public static void main(String[] args) throws InterruptedException {
		Terrain m =Terrain.Mur;         // Creation d'un Mur
		Terrain s =Terrain.Scene;        // Creation d'une Scene
		System.out.println(Terrain.conv(m));      //Afficher le mur en symbole
		System.out.println(Terrain.conv('+'));    //Trouver la signification de '+' dans l'affichage
		System.out.println(Terrain.isTarget(s));  //identification des terrains qui attirent les personnes
		
		
		Terrain[][] map = MapFactoryFromFile_Matrix.build("ressources/terrain1.trk");  //Creation d'une matrice de terrains à partir du fichier terrain1.trk
		Terrain.display(map);   // Controler le map, le faire afficher
		
		Salle salle=new Salle(map);    //Creation d'une salle
		
		
		//Ajouter tous les bornes exit et les cases safe de map dans la salle
		for (int i=0; i<map.length; i++) {     
			for (int j=0; j<map[i].length; j++) {
				if ((Character.isDigit(Terrain.conv(map[i][j]))) || (Terrain.conv(map[i][j])=='+'))
					salle.add(new Vecteur2D(i,j));
			}
		}
		
		
		
		System.out.println("Liste cibles: " + salle.getListeCibles()); //Tester les fonctionnements des méthodes de Salle
		System.out.println(salle.get(5,5));
		Vecteur2D c1=(salle.getListeCibles()).get(0);
		Vecteur2D c2=(salle.getListeCibles()).get(1);
		System.out.println("Position c2: "+ salle.get(c2));
		System.out.println("Hauteur de la salle: " + salle.getHaut());
		System.out.println("Largeur de la salle: "+ salle.getLarg());
		System.out.println("c1 et c2 visibles: " +salle.isVisible(c2, c1));
		
		
		
		
		Personne p=new Personne(22,14);       //Creation d'une Personne
		System.out.println(("Personne p: "+p.getPos()));     //Afficher la position de cette personne
		
		MoteurPhysique moteur= new MoteurPhysique();   //Creation d'un moteur physique
		System.out.println("Personne p: "+p.getPos());
		
		p.setDir(c1);    //Set la direction et la vitesse de personne
		System.out.println("p a pour target:" +(p.getTarget()).toString());
		moteur.add(p);   //Ajouter personne p dans la liste des objets du moteur
		moteur.updateMovablePosition();   //actualise la position de l'objet p
		System.out.println("Personne p: "+p.getPos());
		System.out.println(moteur.isMove());  //Vérifier si la le moteur Physique a fait bouger
		
		
		
		StrategyFonceur str=new StrategyFonceur(salle);   //Creation d'une strategy fonceur
		Personne ps=new Personne(21, 45, str);  //Creation d'une personne avec strategie str
		System.out.println("Personne ps: "+ps.getPos());
		moteur.add(ps);   //Ajouter personne ps dans la liste des objets du moteur
		moteur.remove(p); //Supprimer personne p dans la liste des objets du moteur
		ps.move();
		moteur.updateMovablePosition();   //actualise la position de l'objet ps
		System.out.println(moteur.isMove());  //Vérifier si la le moteur Physique a fait bouger
		
		
		
		Vecteur2D cibleOpt = Collections.min(salle.getListeCibles(),new ComparateurPosition(salle, p.getPos()));
		System.out.println("le minimum de la liste Cible avec p:" +cibleOpt);
		
		StrategySauveQuiPeut strs=new StrategySauveQuiPeut(salle);
		Personne pstr=new Personne(12, 23, strs);
		moteur.remove(ps);
		moteur.add(pstr);
		moteur.updateMovablePosition();
		

		
	}

	
	
}
