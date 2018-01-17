
class Compte{
 private int solde;
 public Compte(int solde){this.solde=solde;}
 int getSolde(){ return solde;}
 void setSolde(int solde){this.solde=solde;}
}

class Distributeur extends Thread{
 private int montant;
 private int nbRetrait;
 private Compte c;
 public Distributeur(Compte c, int montant, int nbRetrait){
  this.c=c;
  this.montant=montant;
  this.nbRetrait=nbRetrait;
 }
 public void run(){
  for(int j=1; j<=nbRetrait ; j++){
   int temp;
   temp=c.getSolde();
   temp=temp-montant;
   c.setSolde(temp);
 }
 } 
}


public class Banque00{

public static void main(String[] arg){

  Compte c = new Compte(700000);
  Distributeur d1=new Distributeur(c,10,10000);
  Distributeur d2=new Distributeur(c,50,10000);

  d1.start();
  d2.start();

try{
  d1.join();
  d2.join();
}catch (InterruptedException e){e.printStackTrace();}

 System.out.println("Solde final="+c.getSolde());
}
}
