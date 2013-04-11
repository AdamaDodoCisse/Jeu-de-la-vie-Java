package Evolution;

import interface_.StructureDeDonnee;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import code_du_jeu.Grille;

import Exception.HtmlException;
public class HTML {
	private String balise;
	private StructureDeDonnee structure;
	public HTML(String fileName,int temps,int jeu,String nouveauFichier,StructureDeDonnee structure )throws HtmlException{
		this.structure = structure;
		preparerBailse(fileName, temps, jeu);
		executer(nouveauFichier);
	}

	private void preparerBailse(String filename, int temps,int jeu) throws HtmlException{
		balise = "<html>" +
				"	<head>" +
				"		<title> Jeu de la vie" +

				"		</title>" +
				css() +
				"	</head> " +
				"	<body>" +
				"<form> " +
				"<table border=1>" +
				"<caption>RESULTAT D'ANALYSE DES FICHIERS LIF DU DOSSIER "+filename+" </caption>" +
				"<tr>" +
				"<th>Nom du fichier</th>" +
				"<th>Inconnu</th>" +
				"<th>Mort</th>" +
				"<th>Stabilité</th>" +
				"<th>Oscillation</th>" +
				"<th>Vaisseau</th>" +
				"<th>Periode</th>" +
				"<th>Taille de la queue</th>" +
				"</tr>" + 
				resultat(filename,jeu,temps)
				+"	</table></form></body>" +
				"</html>";
	}

	private void executer(String nouveau){
		try{
			File f1 = new File(nouveau+".html");
			FileWriter f2 =new FileWriter(f1) ;
			BufferedWriter f3 = new BufferedWriter(f2);
			f3.write(balise);
			f3.close();
			System.out.println("Fichier creer sous le nom de : "+nouveau+".html");
			System.out.println("Terminer");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private String css(){
		return "<style>" +
				"table{" +
				"	"+

				"}" +
				"table tr td{" +
				"	width:10%;" +
				"	background:red;" +
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
				"color:white;"+
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

	private String resultat(String fileName,int jeu,int temps)throws HtmlException {
		File dossier = new File(fileName); 
		String body ="";
		if(dossier.isDirectory()){
			//			récupperation des fichiers Lif dans un tableau 
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
					try {
						ReconnaissanceType nouveauRec = new ReconnaissanceType(
								jeu,
								temps,
								lesFichiers[i].getAbsolutePath(),structure);
						body+=Resultat(nouveauRec,lesFichiers[i].getName());
					} catch (FileNotFoundException e) {}

				}return body;
			}else{throw new 
				HtmlException("Aucun fichier Lif dans " +
						"le dossier " +fileName);}
		}else 
			throw new HtmlException("Le chemin : << "+fileName+" << n'est pas un dossier");
	}

	public String Resultat(ReconnaissanceType re,String file){
		if(re.isInconnu())
			return  "<tr>" +
			"	<th>"+file+"</th>" +
			"<td> X </td>" +
			"<td> - </td>" +
			"<td> - </td>" +
			"<td> - </td>" +
			"<td> - </td>" +
			"<td> - </td>" +
			"<td> - </td>"+
			"</tr>" ; 

		else if(re.isMort())
			return "<tr>" +
			"	<th>"+file+"</th>" +
			"<td> - </td>" +
			"<td> X </td>" +
			"<td> X </td>" +
			"<td> X </td>" +
			"<td> X </td>" +
			"<td> 0 </td>" +
			"<td> 0 </td>" +
			"</tr>" ; 
		else if(re.isStabilite())
			return  "<tr>" +
			"	<th>"+file+"</th>" +
			"<td> - </td>" +
			"<td> - </td>" +
			"<td> X </td>" +
			"<td> X </td>" +
			"<td> X </td>" +
			"<td> "+re.getPeriodeFinal()+" </td>" +
			"<td> "+re.getTailleQueue()+" </td>" +
			"</tr>" ; 
		else if(re.isOscillation())
			return  "<tr>" +
			"	<th>"+file+"</th>" +
			"<td> - </td>" +
			"<td> - </td>" +
			"<td> - </td>" +
			"<td> X </td>" +
			"<td> X </td>" +
			"<td> "+re.getPeriodeFinal()+" </td>" +
			"<td> "+re.getTailleQueue()+" </td>" +
			"</tr>" ; 
		else
			return  "<tr>" +
			"	<td>"+file+"</td>" +
			"<td> - </td>" +
			"<td> - </td>" +
			"<td> - </td>" +
			"<td> - </td>" +
			"<td> X </td>" +
			"<td> "+re.getPeriodeFinal()+" </td>" +
			"<td> "+re.getTailleQueue()+" </td>" +
			"</tr>" ; 
	}

}
