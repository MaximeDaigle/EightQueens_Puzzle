
public class EightQueens {
	 static int[][] echiquier = new int[8][8];  // valeurs initialiseés à 0     
	 public boolean securitaire(int x, int y){         
		 for (int i=0; i<8; i++) {             
			 if (echiquier[x][i]==1 || echiquier[i][y]==1) return false;             
			 if ((x-i)>=0 && (y-i)>=0 && echiquier[x-i][y-i]==1) return false;             
			 if ((x+i)<=7 && (y+i)<=7 && echiquier[x+i][y+i]==1) return false;             
			 if ((x-i)>=0 && (y+i)<=7 && echiquier[x-i][y+i]==1) return false;             
			 if ((x+i)<=7 && (y-i)>=0 && echiquier[x+i][y-i]==1) return false;         
		}         
		return true; 
	 }     
	 public boolean placer(int y)     
	 // Cette méthode tente de placer une reine dans la colonne y,     
	 // et continue par la suite récursivement.     
	 {   
		 if(y==8) {
			 y = 0;
			 placer(y);
		 }
		 for(int x = 0; x < 8; x++){
			 if(securitaire(x,y)){ 
				 echiquier[x][y] = 1;
				 if(complete()){ 
					 return true;
				 }
				 else if(placer(y+1)){
					 return true;
				 }
				 else{
					 //System.out.println("efface");
					 echiquier[x][y] = 0;
				 }
			 }
		 }
		 //System.out.println("echec");
		 return false;
		 
	 }
	 public boolean complete(){
		 int count = 0;
		 for(int i = 0; i < 8; i++){
			 for(int j = 0; j < 8; j++){
				 count += echiquier[i][j];
			 }
		 }
		 if(count == 8){ 
			 System.out.println("Solution:");
			 afficher();
			 System.out.println();
			 return true;
		 }
		 else return false;
	 }
	 public void afficher(){         
		 for (int i=0; i<8; i++) {             
			 for (int j=0; j<8; j++)                 
				 System.out.print(echiquier[i][j]+" ");             
			 System.out.println();         
		 } 
	 }
	public static void main(String[] args){   
		EightQueens reines = new EightQueens();   
		for(int i=0; i <=7; i++){
			System.out.println("Première reine placée dans la colonne: " + i);
			reines.placer(i); 
			echiquier = new int[8][8];
		}
	} 
}
