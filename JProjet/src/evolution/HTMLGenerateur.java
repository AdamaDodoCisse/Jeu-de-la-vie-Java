package evolution;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import structureDeDonnee.PlateauCirculaire;
import structureDeDonnee.PlateauFini;
import structureDeDonnee.PlateauInfini;
import structureDeDonnee.StructureDeDonneeFactory;

import jeuDeLaVie.JeuDeLaVie;
import exception.HTMLException;
import exception.LectureException;
import interface_.Matrice;

/**
 * <b>HTMLGenerateur est la classe qui calcule le type d’évolution de tous les
 * jeux contenus dans le dossier passé en paramètre et affiche les résultats sous la forme d’un fichier
 * html.</b>
 * <p>
 * Un Générateur HTML est caractérisée par :
 * <ul>
 * <li>Une chaine de caractère (contenu du fichier HTML à générer).</li>
 * <li>Un type de plateau du jeu de la vie.</li>
 * </ul>
 * </p>
 * @see JeuDeLaVie
 * @see PlateauFini
 * @see PlateauInfini
 * @see PlateauCirculaire
 * @author kouyate
 *
 */
public class HTMLGenerateur {
	/**
	 * Contenu du fichier HTML à générer.
	 */
	private String balise;
	/**
	 * Type de Plateau du jeu de la vie.
	 * @see StructureDeDonneeFactory
	 * @see PlateauFini
	 * @see PlateauInfini
	 * @see PlateauCirculaire
	 * @see JeuDeLaVie
	 */
	private int typePlateau;
	/**
	 * Constructeur HTMLGenerateur.
	 * @param fileName
	 * 				Un nom de dossier en chaine de caractère.
	 * @param temps
	 * 				Un entier correspondant au nombre d'évolution à éffectuer.
	 * @param nomPage
	 * 				Le nom de la page à générer en chaine de caractère.
	 * @param typePlateau
	 * 				Un entier correspondant au type de plateau du jeu de la vie.
	 * @throws HTMLException
	 * 				Lève une exception lorsque le dossier est vide ou inexistant.
	 * @throws LectureException 
	 * 				Lève une exception lorsque le fichier n'existe pas.
	 * @throws IOException 
	 * @see PlateauFini
	 * @see PlateauInfini
	 * @see PlateauCirculaire
	 * @see JeuDeLaVie
	 */
	public HTMLGenerateur(String fileName,int temps,int typePlateau,
						  String nomPage
						   )throws HTMLException, LectureException, IOException{
		this.typePlateau = typePlateau;
		//Genere le contenu de la page HTML
		preparerBalise(fileName, temps);
		//Genere la page HTML
		generer(nomPage);
	}
	/**
	 * Calcule le type d'évolution de l'ensemble des fichiers du dossier passer en paramètre.
	 * @param fileName
	 * 				Un nom de dossier en chaine de caractère.
	 * @param temps
	 * 				Un entier correspondant au nombre d'évolution à éffectuer.
	 * @return Une chaine de caractère qui contient les informations de toutes les fichiers du dossier.
	 * @throws HTMLException
	 * 				Lève une exception lorsque le dossier est vide ou inexistant.
	 * @throws LectureException 
	 * @throws IOException 
	 */
	public String analyser(String fileName,int temps)throws HTMLException, LectureException, IOException {
		File dossier = new File(fileName); 
		String body ="";
		if(dossier.isDirectory()){
			//récuperation des fichiers Lif dans un tableau 
			File []lesFichiers = dossier.listFiles(new FileFilter() {
				@Override
				public boolean accept(File pathname) {
					if(pathname.isFile()){
						return pathname.getAbsolutePath().endsWith(".LIF");
					}return false;
				}
			}) ;
			if(lesFichiers.length > 0){
				for(int i=0;i<lesFichiers.length;i++){
					System.out.println(lesFichiers[i].getName()+" en cours d'analyse...");
					//calcule du type d'évolution du fichier courant.
					Matrice plateau;
					try {
						plateau = StructureDeDonneeFactory.
													getPlateau(typePlateau, lesFichiers[i].getAbsolutePath());
						ReconnaissanceType nouveauRec = new ReconnaissanceType(
								temps,
								plateau);
						nouveauRec.calculerTypeEvolution(temps);
						System.out.println(lesFichiers[i].getName()+" traité...");
						//ajout des informations du fichier courant à la chaine body.
						body+=parser(nouveauRec,lesFichiers[i].getName(),lesFichiers[i].getAbsolutePath());
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			return body;
			
			} else { //Si le dossier ne comporte aucun fichier LIF on lève une exception.
				throw new HTMLException("Aucun fichier Lif dans " +
						"le dossier " +fileName);
			}
		} else { //Si le chemin est incorrecte on lève une exception.
			throw new HTMLException("Le chemin : << "+fileName+" << n'est pas un dossier");
		}
	}
	/**
	 * Générateur du contenu d'un fichier CSS pour la mise en forme de la page à générer.
	 * @return Une chaine de caractère 
	 * @see HTMLGenerateur
	 */
	private String css(){
		return "<style>" +
				"table{" +
				"	"+

				"}" +
				"table tr td{" +
				"	width:10%;" +
				"	background:#FF358B;" +
				"	text-align:center;" +
				"-webkit-border-top-left-radius: 10px"+
				"-webkit-border-top-right-radius: 219px;"+
				"-webkit-border-bottom-right-radius: 33px;"+
				"-webkit-border-bottom-left-radius: 20px;"+
				"-moz-border-radius-topleft: 10px;"+
				"-moz-border-radius-topright: 219px;"+
				"-moz-border-radius-bottomright: 33px;"+
				"-moz-border-radius-bottomleft: 20px;"+
				"border-top-left-radius: 10px;"+
				"border-top-right-radius: 219px;"+
				"border-bottom-right-radius: 33px;"+
				"border-bottom-left-radius: 20px;" +
				"color:white;" +
				"transition:3s;" +
				"-o-transition:3s;" +
				"-moz-transition:3s;" +
				"-ms-transition:3s;" +
				"-webkit-transition:3s;"+
				"}" +
				"table tr td:hover{" +
				"	background:blue;" +
				"	font-size:22px;" +
				"	font: bold;" +
				"-webkit-border-top-left-radius: 10px;"+
				"-webkit-border-top-right-radius: 20px;"+
				"-webkit-border-bottom-right-radius: 10px;"+
				"-webkit-border-bottom-left-radius: 100px;"+
				"-moz-border-radius-topleft: 10px;"+
				"-moz-border-radius-topright: 20px;"+
				"-moz-border-radius-bottomright: 10px;"+
				"-moz-border-radius-bottomleft: 100px;"+
				"border-top-left-radius: 10px;"+
				"border-top-right-radius: 20px;"+
				"border-bottom-right-radius: 10px;"+
				"border-bottom-left-radius: 100px;" +
				"color:#EEE8AA;"+
				"-moz-box-shadow: 6px 6px 40px 1px #ccc;"+
				"-webkit-box-shadow: 6px 6px 40px 1px #ccc;"+
				"-o-box-shadow: 6px 6px 40px 1px #ccc;"+
				"box-shadow: 6px 6px 40px 1px #ccc;"+
				"filter:progid:DXImageTransform.Microsoft.Shadow(color=#ccc, Direction=135, Strength=40);"+
				"}" +
				"caption{" +
				"	background:green;" +
				"" +
				"}" +
				"" +
				"</style>";
	}
	/**
	 * Genere le contenu du fichier HTML à générer dans une chaine de caractère.
	 * @param filename
	 * 				Un nom de dossier en chaine de caractère.
	 * @param temps
	 * 				Un entier correspondant au nombre d'évolution à éffectuer.
	 * @throws HTMLException
	 * 				Lève une exception lorsque le dossier est vide ou inexistant.
	 * @throws LectureException 
	 * @throws IOException 
	 * @see HTMLGenerateur
	 * @see HTMLException
	 */
	private void preparerBalise(String filename, int temps) throws HTMLException, LectureException, IOException{
		balise = "<html>" +
				"	<head>" +
				"		<title> Jeu de la vie" +

				"		</title>" +
				css() +
				"	</head> " +
				"	<body>" +
				"<form> " +
				"<table border=1>" +
				"<caption>JEU DE LA VIE</br> RESULTAT D'ANALYSE DES FICHIERS LIF DU DOSSIER "+filename +"</caption>" +
				"<tr>" +
				"<th>Nom du fichier</th>" +
				"<th>Inconnu</th>" +
				"<th>Mort</th>" +
				"<th>Stabilite</th>" +
				"<th>Oscillation</th>" +
				"<th>Vaisseau</th>" +
				"<th>Periode</th>" +
				"<th>Taille de la queue</th>" +
				"<th>Déplacement(ligne,colonne)</th>"+
				"</tr>" + 
				analyser(filename,temps)
				+"	</table></form></body>" +
				"</html>";
	}
	/**
	 * Génere la page HTML.
	 * @param nomPage
	 * 				Le nom de la page à générer en chaine de caractère.
	 * @see HTMLGenerateur
	 */
	public void generer(String nomPage){
		try{
			File f1 = new File(nomPage+".html");
			FileWriter f2 =new FileWriter(f1) ;
			BufferedWriter f3 = new BufferedWriter(f2);
			f3.write(balise);
			f3.close();
			System.out.println("Fichier HTML créer sous le nom de : "+nomPage+".html");
			System.out.println("Terminer");
			Desktop.getDesktop().open(f1);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Genere un contenu de la page HTML .
	 * @param re
	 * 				Une ReconnaissanceType qui contient les informations sur le fichier.
	 * @param file
	 * 				Un nom de fichier en chaine de caractère.
	 * @param link
	 * 				Un lien HTML en chaine de caractère.
	 * @return Une chaine de caractère.
	 * @see ReconnaissanceType
	 * @see HTMLGenerateur
	 */
	public String parser(ReconnaissanceType re,String file,String link){
		if(re.isInconnu()){
			return  "<tr>" +
					"	<th> <a href="+link+">"+file+"</a></th>" +
					"<td> <img src=Dossier_Teste/valide.png /> </td>" +
					"<td> <img src=Dossier_Teste/error.png />  </td>" +
					"<td> <img src=Dossier_Teste/error.png />  </td>" +
					"<td> <img src=Dossier_Teste/error.png />  </td>" +
					"<td> <img src=Dossier_Teste/error.png />   </td>" +
					"<td> <img src=Dossier_Teste/error.png />   </td>" +
					"<td> <img src=Dossier_Teste/error.png />   </td>"+
					"<td> (0,0) </td>"+
					"</tr>" ; 

		}else if(re.isMort()){
			return "<tr>" +
					"	<th><a href="+link+">"+file+"</a></th>" +
					"<td> <img src=Dossier_Teste/error.png />  </td>" +
					"<td> <img src=Dossier_Teste/valide.png /> </td>" +
					"<td> <img src=Dossier_Teste/valide.png /> </td>" +
					"<td> <img src=Dossier_Teste/valide.png /> </td>" +
					"<td> <img src=Dossier_Teste/valide.png /> </td>" +
					"<td> 0 </td>" +
					"<td> 0 </td>" +
					"<td> (0,0) </td>"+
					"</tr>" ; }
		else if(re.isStabilite()){
			return  "<tr>" +
					"	<th><a href="+link+">"+file+"</a></th>" +
					"<td> <img src=Dossier_Teste/error.png />  </td>" +
					"<td> <img src=Dossier_Teste/error.png /> </td>" +
					"<td> <img src=Dossier_Teste/valide.png /> </td>" +
					"<td> <img src=Dossier_Teste/valide.png /></td>" +
					"<td> <img src=Dossier_Teste/valide.png /> </td>" +
					"<td> "+re.getPeriodeFinal()+" </td>" +
					"<td> "+re.getTailleQueue()+" </td>" +
					"<td> ("+re.getLignes()+","+re.getColonnes()+") </td>"+
					"</tr>" ; }
		else if(re.isOscillation()){
			return  "<tr>" +
					"	<th><a href="+link+">"+file+"</a></th>" +
					"<td> <img src=Dossier_Teste/error.png /> </td>" +
					"<td> <img src=Dossier_Teste/error.png /> </td>" +
					"<td> <img src=Dossier_Teste/error.png />  </td>" +
					"<td> <img src=Dossier_Teste/valide.png /> </td>" +
					"<td> <img src=Dossier_Teste/valide.png /> </td>" +
					"<td> "+re.getPeriodeFinal()+" </td>" +
					"<td> "+re.getTailleQueue()+" </td>" +
					"<td> ("+re.getLignes()+","+re.getColonnes()+") </td>"+
					"</tr>" ; }
		else{
			return  "<tr>" +
					"	<th><a href="+link+">"+file+"</a></th>" +
					"<td> <img src=Dossier_Teste/error.png />  </td>" +
					"<td> <img src=Dossier_Teste/error.png />  </td>" +
					"<td> <img src=Dossier_Teste/error.png />  </td>" +
					"<td> <img src=Dossier_Teste/valide.png />  </td>" +
					"<td> <img src=Dossier_Teste/valide.png /> </td>" +
					"<td> "+re.getPeriodeFinal()+" </td>" +
					"<td> "+re.getTailleQueue()+" </td>" +
					"<td> ("+re.getLignes()+","+re.getColonnes()+") </td>"+
					"</tr>" ; 
			}
	}

}
