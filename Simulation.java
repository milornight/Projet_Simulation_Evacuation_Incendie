package travail;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import pobj.ihm.Fenetre;
import pobj.physics.MoteurPhysique;
import pobj.simuagent.factory_terrain.MapFactoryFromFile_Matrix;
import pobj.tools.Vecteur2D;

public class Simulation {
	public static void main(String[] args) throws InterruptedException{
		
		
		//Creation d'une matrice de terrains à partir du fichier terrain1.trk
		Terrain[][] map = MapFactoryFromFile_Matrix.build("ressources/terrain1.trk");  
		
		//Creation d'une salle
		Salle salle=new Salle(map);    
		
		
		//Ajouter tous les bornes exit et les cases safe de map dans la salle
		for (int i=0; i<map.length; i++) {     
			for (int j=0; j<map[i].length; j++) {
				if ((Character.isDigit(Terrain.conv(map[i][j]))) || (Terrain.conv(map[i][j])=='+'))
					salle.add(new Vecteur2D(i,j));
			}
		}

		//Creation d'une stratégie
		StrategySauveQuiPeut strs=new StrategySauveQuiPeut(salle);
		
		
		// Moteur Physique 2D (vue dessus)
        MoteurPhysique mphys = new MoteurPhysique();
        // graphiques:
        Fenetre mgraph = new Fenetre();
        //Creation d'une liste de personnes
        ArrayList<Personne> personnes=new ArrayList<Personne>();
        
        
        //mgraph ajoute 30 personnes dans mgraph, mphys et personnes
        for (int i=0; i<30; i++) {
        	double x=Math.random()*(50*10)+55;
        	double y=Math.random()*(30*10)+55;
        	Personne person=new Personne(x, y,strs);
        	mphys.add(person);
        	personnes.add(person);
        	mgraph.add(new PersonneView(person));
        }

        
        
        // Création des vues associées aux objets physiques
        int posy=50;
        for (int i=0; i<map.length; i++) {
        	
        	int posx=50;
        	for (int j=0; j<map[i].length; j++) {
        		if (map[i][j]==Terrain.Mur) {
        			Mur mur=new Mur(posx, posy, 10, 10);
        			mgraph.add(new MurView(mur));
        			mphys.add(mur);              //Ajouter les murs dans mphys
        			
        		}
        		if (map[i][j]==Terrain.Safe) {
        			mgraph.add(new TerrainView(posx,posy,10,10, Color.GREEN));
        			
        		}
        		if (Character.isDigit(Terrain.conv(map[i][j]))) {
        			mgraph.add(new TerrainView(posx,posy,10,10, Color.MAGENTA));
        			
        		}
        		posx=posx+10;
        		
        	}
        	posy=posy+10;
        }
        
  
     // boucle de mouvement + affichage
        for(int iter = 0; iter<500; iter++) {
            // mouvements
        	for (Personne pp:personnes) {
        		pp.move();
        		System.out.println(pp.getDir());
        	}
            mphys.updateMovablePosition();
            // affichage  
            mgraph.repaint();      
            // temporisation 
            Thread.sleep(50);
            
            if(!mphys.isMove()) {
                System.out.println("plus de mouvement => sortie");
                break;
            }
        }
	}
}
