import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
public class HTML {
	private String balise;
	public HTML(String fileName,int temps,int jeu,String nouveauFichier)throws HtmlException{
		preparerBailse(fileName, temps, jeu);
		executer(nouveauFichier);
	}
	
	private void preparerBailse(String filename, int temps,int jeu) throws HtmlException{
		balise = "<html>" +
				"	<head>" +
				"		<title> Jeu de la vie" +
							
				"		</title>" +
						css() +
				"	</head>" +
				"	<body> " + 
						resultat(filename,jeu,temps)
				+"	</body>" +
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
				"" +
				"" +
				"" +
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
															lesFichiers[i].getAbsolutePath());
							body+=nouveauRec.Resultat();
						} catch (FileNotFoundException e) {}
						
				}return body;
			}else{throw new 
					HtmlException("Aucun fichier Lif dans " +
							      "le dossier " +fileName);}
		}else 
			throw new HtmlException("Le chemin : << "+fileName+" << n'est pas un dossier");
	}
	
	public static void main(String []args){
		try {
			new HTML("html", 1, 2, "nouveau teste");
		} catch (HtmlException e) {
		}
	}
}
