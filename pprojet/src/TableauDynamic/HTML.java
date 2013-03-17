package TableauDynamic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;

public class HTML {
	public HTML(String Dossier,int time) throws IOException{
		try{
			File [] fichiers = FichiersLif(Dossier);
			String body = "";
			for(File f : fichiers){
				try {
					ReconnaissanceType re = new ReconnaissanceType(f.getAbsolutePath());
					for(int i=0;i<time;i++){
						if(!re.isInconnu()){
							break;
						}
						re.getPrimoG().Evolution(1);
						re.getSeconG().Evolution(2);
						re.structure();
					}
					body += re.Resultat(f.getName(), time);
				} catch (Exception e) {
				}
			}createHTML(Dossier, body);
		}catch(NotDossierException e){
			System.out.println(e.getMessage());
		}
	}
	
	private final File[] FichiersLif(String Dossier )throws NotDossierException{
		File Doc = new File(Dossier);

		if(Doc.isDirectory()){
			File [] lesFichiersLif = Doc.listFiles(new FileFilter() {

				@Override
				public boolean accept(File arg0) {
					// TODO Auto-generated method stub
					if(arg0.isFile() && arg0.getName().endsWith(".LIF")){
						return true;
					}
					return false;
				}
			});

			if(lesFichiersLif.length == 0){
				throw new NullLifException("Aucun Fichier Lif");
			}else{
				return lesFichiersLif;
			}
		}else{
			throw new NotDossierException(Dossier+" n'est pas un dossier");
		}
	}
	private void createHTML(String dossier,String body) throws IOException{
		String balise = "<html>" +
				"<head> " + 
				"	<title>Resultat du dossier : "+dossier+"</title>" +
				"" +Css()+
				"</head> <body>" +
				body +
				"</body><html>";
		String j = "";
		
		for(int i=dossier.length()-1;i>=0;i--){
			if(i!=dossier.length()-1&&dossier.charAt(i)=='/' || dossier.charAt(i)=='\\' )
					break;
			if(dossier.charAt(i)=='/' || dossier.charAt(i)=='\\')
				i--;
			j=dossier.charAt(i)+j;
		}
		File fichier = new File(j+".html");
		FileWriter f1 = new FileWriter(fichier);
		BufferedWriter f2 = new BufferedWriter(f1);
		f2.write(balise);
		f2.close();
		
		System.out.println("Le fichier a été crée dans le dossier courant \n" +
				"sous le nom de  : "+j+".html");
	}
	private final String Css(){
		return "<style>" +
				"body{background : #EFF;}" +
				".titre{width : 100%; text-align:center;font-size:20;font-weight:bold;background:#CEF;margin:auto;border-raduis:10 20 30;}" +
				".resultat{background:#DDE;text-align:center;}" +
				"" +
				" </style>";
	}
}
