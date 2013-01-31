package TableauDynamic;

public class VerifScene {
	private static Scene scene;
	
	public static void main(String []args){
	     setScene(new Scene());
		
	}

	public static Scene getScene() {
		return scene;
	}

	public static void setScene(Scene scene) {
		VerifScene.scene = scene;
	}
}
