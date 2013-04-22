package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import affichage.Simulation;

import structureDeDonnee.PlateauCirculaire;
import structureDeDonnee.PlateauFini;
import structureDeDonnee.PlateauInfini;
import structureDeDonnee.StructureDeDonneeFactory;

import jeuDeLaVie.JeuDeLaVie;
import evolution.HTMLGenerateur;
import evolution.ReconnaissanceType;
import exception.CommandeException;
import exception.HTMLException;
import exception.LectureException;
import interface_.Matrice;

/**
 * <b>Commande est la classe qui gère les paramètre de lencement du jeu de la vie.</b>
 * <p>
 * Un objet Commande est caractérisé par :
 * <ul>
 * <li>Un plateau du jeu de la vie .</li>
 *</ul>
 * </p>
 * @see PlateauFini
 * @see PlateauInfini
 * @see PlateauCirculaire
 * @see JeuDeLaVie
 * @author kouyate
 *
 */
public class Commande {
	/**
	 * 
	 */
	private Matrice plateau;
	/**
	 * Constructeur Commande.
	 * @param args
	 * 				Un tableau de chaine de caractère conténant les commandes.
	 * @throws LectureException 
	 * @throws FileNotFoundException 
	 * @see Commande
	 */
	public Commande(String []args) throws LectureException, FileNotFoundException{
		
		try {
			executer(args);
			
		} catch (CommandeException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Affiche les options du programme.
	 * @throws FileNotFoundException 
	 */
	private void aider() throws FileNotFoundException{
		BufferedReader reader = new BufferedReader(
								new FileReader(
								new File("Dossier_Teste/aide.txt")));
		//affichage du contenu du fichier aide.txt
		String ligne = null;
		try {
			while((ligne = reader.readLine())!=null){
				System.out.println(ligne);
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/**
	 * Affiche la liste des réalisateurs du jeu
	 */
	
	private void groupe(){
		System.out.println(
				"Kouyaté Sory\n" +
				"Melaine\n" +
				"Diallo Youssouf\n" +
				"Cissé Adama Dodo\n");
	}
	/**
	 * Execute une simulation d'un jeu de la vie sur une durrée donné.
	 * @param nomFichier
	 * 				Un nom fichier en chaine de caractère.
	 * @param temps
	 * 				Un entier correspondant au nombre d'évolution à éffectuer.
	 * @param typePlateau
	 * 				Un entier coorespondant au type de plateau du jeu de la vie.
	 * @throws LectureException 
	 * @see JeuDeLaVie
	 * @see PlateauFini
	 * @see PlateauInfini
	 * @see PlateauCirculaire
	 */
	private void simuler(String nomFichier,int temps,int typePlateau) throws LectureException{
		JeuDeLaVie jeu;
		try {
			plateau = StructureDeDonneeFactory.getPlateau(typePlateau, nomFichier);
			jeu = new JeuDeLaVie(plateau);
			new Simulation(temps, jeu);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	
	}
	/**
	 * Genere une page HTML caractérisant l'ensemble des fichiers contenuent dans le dossier passer en paramètre.
	 * @param nomDossier
	 * 				Un nom de dossier en chaine de caractère.
	 * @param temps
	 * 				Un entier correspondant au nombre d'évolution à éffectuer.
	 * @param typePlateau
	 * 				Un entier coorespondant au type de plateau du jeu de la vie.
	 * 				
	 * @param nomFichierHtml
	 * 				Une chaine de caractère qui correspond au nom du fichier HTML à générer.
	 * @throws LectureException 
	 * @see HTMLGenerateur
	 * @see JeuDeLaVie
	 */
	private void genererHTML(String nomDossier,int temps,int typePlateau,String nomFichierHtml) throws LectureException {
		try {
			new HTMLGenerateur(nomDossier, temps, typePlateau, nomFichierHtml);
		} catch (HTMLException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Affiche les caractèristique d'un jeu sur une durée donner.
	 * @param typePlateau
	 * 				Un entier coorespondant au type de plateau du jeu de la vie.
	 * @param temps
	 * 				Un entier correspondant au nombre d'évolution à éffectuer.
	 * @param nomFichier
	 * 				Un nom fichier en chaine de caractère.
	 * @throws LectureException 
	 * @see ReconnaissanceType
	 * @see JeuDeLaVie
	 * 				
	 */
	private void analyserFichier(int typePlateau,int temps,String nomFichier) throws LectureException{
		try {
			plateau = StructureDeDonneeFactory.getPlateau(typePlateau, nomFichier);
			ReconnaissanceType re = new ReconnaissanceType(temps, plateau);
			System.out.println(re);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Executer la commande passer en paramètre
	 * @param args
	 * 				Un tableau de chaine de caractère conténant les commandes.
	 * @throws CommandeException
	 * 				Lève une exception lorsque la commande est invalide.
	 * @throws LectureException 
	 * @throws FileNotFoundException 
	 * @see CommandeException
	 */
	
	private void executer(String []args)throws CommandeException, LectureException, FileNotFoundException{
		if(args.length==0){
			System.out.println("Veuillez saisir une des commandes");
			System.out.println();
				aider();
		}
			
		if(args.length ==1  ||( args.length ==3 || args.length ==4)){
			if(args.length==1){
				
				if(args[0].equals("-name")){
						groupe();
				} else if (args[0].equals("-h")){
						aider();
				} else {
					throw new CommandeException("Commande inconnu !");
				}
					
			} else if (args.length == 3 || args.length == 4){
				
				if(args[1].matches("^[0-9]+$")){
					int temps = Integer.parseInt(args[1]);
					String nomRepertoire = args[2];
					if(args[0].equals("-s") && args.length==3){
						simuler(nomRepertoire,temps,StructureDeDonneeFactory.PLATEAU_INFINI);
					} else if (args[0].equals("-s")){
						try{
							int typePlateau = Integer.parseInt(args[3]);
							if(typePlateau >=1 && typePlateau<=3){
								simuler(nomRepertoire,temps,typePlateau);
							} else {
								throw new CommandeException("l'entier doit être entre 1 et 3");
							}
						}catch(Exception e){
							throw new CommandeException("le quatrième arguments est un entier");
						}
					}
					
					if(args[0].equals("-c") && args.length==3){
						analyserFichier(StructureDeDonneeFactory.PLATEAU_INFINI, 
										temps, nomRepertoire);
					} else if(args[0].equals("-c")) {
						try{
							int typePlateau = Integer.parseInt(args[3]);
							if(typePlateau>=1 && typePlateau<=3){
								analyserFichier(typePlateau, temps, nomRepertoire);
							} else {
								throw new CommandeException("l'entier doit etre entre 1 et 3");
							}
								
						}catch(Exception e){
							throw new CommandeException("le quatrième arguments est un entier");
						}
					}
					if(args[0].equals("-w") && args.length==3){
						genererHTML(nomRepertoire, temps, 
								StructureDeDonneeFactory.PLATEAU_INFINI, "Jeu de la vie");
					} else if (args[0].equals("-w")){
						try{
							int a = Integer.parseInt(args[3]);
							if(a >=1 && a<=3){
								genererHTML(nomRepertoire, temps, a, "Jeu de la vie");
							} else {
								throw new CommandeException("l'entier doit etre entre 1 et 3");
							}
								
						}catch(Exception e){
							throw new CommandeException("le quatrième arguments est un entier");
						}
					}
				} else {
					throw new CommandeException("Le deuxième Argument n'est pas un entier");
				}
					
			} else {
				
			}
		} else {
			throw new CommandeException("Commande invalide");
		}
	}
}
