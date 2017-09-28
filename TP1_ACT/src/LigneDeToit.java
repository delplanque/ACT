import java.awt.Point;


public class LigneDeToit {
	
	protected PointLigneDeToit [] mTab;
	public LigneDeToit(PointLigneDeToit [] tab){
		this.mTab = tab;
		
	}
	public static PointLigneDeToit [] fusionListLigneDeToit(PointLigneDeToit [] tab1,PointLigneDeToit [] tab2){
		PointLigneDeToit [] tabtmp= new PointLigneDeToit[tab1.length+tab2.length];
		PointLigneDeToit [] tabfinal = new PointLigneDeToit[tab1.length+tab2.length];
		
		tabtmp=triLigneDeToit(tab1,tab2);
		tabfinal[0]=tabtmp[0];
		for(int i=1;i<tabtmp.length;i++){
			if( tabtmp[i-1].getX() < tabtmp[i].getX() && tabtmp[i-1].getY()> tabtmp[i].getY() ){
				tabfinal[i]=new PointLigneDeToit(tabtmp[i].getX(), tabtmp[i-1].getY());
			}else{
				tabfinal[i]=new PointLigneDeToit(tabtmp[i].getX(), tabtmp[i].getY());
			}
			
			if(tabfinal[i].getY()==tabfinal[i-1].getY()){
				tabfinal[i]= new PointLigneDeToit(-1, -1);
}
			
		}
		
		return tabfinal;
	}
	
	public static PointLigneDeToit [] triLigneDeToit(PointLigneDeToit [] tab1,PointLigneDeToit [] tab2){
		int fintab1,fintab2;
		PointLigneDeToit [] tabfinal= new PointLigneDeToit[tab1.length+tab2.length];

		fintab1=0;
		fintab2=0;
		while(fintab1<tab1.length && fintab2<tab2.length){
			if(tab1[fintab1].getX() < tab2[fintab2].getX()){
				tabfinal[fintab1+fintab2]=tab1[fintab1];
				fintab1++;
			}
			else if(tab1[fintab1].getX() > tab2[fintab2].getX()){
				tabfinal[fintab1+fintab2]=tab2[fintab2];
				fintab2++;
			}
			else if(tab1[fintab1].getX() == tab2[fintab2].getX()){
				if(tab1[fintab1].getY() < tab2[fintab2].getY()){
					tabfinal[fintab1+fintab2]=tab1[fintab1];
					fintab1++;
				}
				else{
					tabfinal[fintab1+fintab2]=tab2[fintab2];
					fintab2++;
				}
			}
			
		}
		if(fintab2<fintab1)
			tabfinal[fintab1+fintab2]=tab2[fintab2];
		else
			tabfinal[fintab1+fintab2]=tab1[fintab1];

		return tabfinal;
		
	}
	
	public static void main(String[] args) {
		PointLigneDeToit [] tabfinal = null;
		PointLigneDeToit [] tab2 = {new PointLigneDeToit(1, 10),new PointLigneDeToit(5, 6),new PointLigneDeToit(8, 0),new PointLigneDeToit(10, 8),new PointLigneDeToit(12, 0)};
		PointLigneDeToit [] tab1 = {new PointLigneDeToit(2, 12),new PointLigneDeToit(7, 0),new PointLigneDeToit(9, 4),new PointLigneDeToit(11, 2),new PointLigneDeToit(14, 0)};
		
		tabfinal=fusionListLigneDeToit(tab1,tab2);

		for(int n=0;n<tabfinal.length;n++){
			if(tabfinal[n].getX() != -1)
				System.out.println(tabfinal[n].getX() +","+ tabfinal[n].getY());
		}
	}
	


}
