import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int limiteVelocità;
		int velocità;
		int differenza;
		float tolleranza;
		String risp;
		Scanner sc=new Scanner(System.in);
		do {	//avvio il ciclo di controllo del valore limite di velocità
			System.out.println("Inserire il limite di velocità:");
			limiteVelocità=sc.nextInt();
			sc.nextLine();
			
			if (limiteVelocità<=0) {
				System.out.println("Limite non valido, inserire un valore corretto.");
			}
			
		}while(limiteVelocità<=0);
		
		//avvio il loop per calcolare una nuova multa in seguito
		do {
			
			do {	//controllo della variabile velocità
				System.out.println("Inserire la velocità rilevata:");
				velocità=sc.nextInt();
				sc.nextLine();
				
				if (velocità<=0) {
					System.out.println("Valore di velocità non valido, inserire un valore corretto.");
				}
			} while (velocità<=0);
			
			/*
			 calcolo la tolleranza considerando 
			 i due casi in cui la velocità rilevata
			 sia superiore o inferiore a 100 km/h
			 */
			if (velocità<=100) {
				tolleranza=limiteVelocità+5f;
			} else {
				tolleranza=limiteVelocità/100f*105f;
			}
			
			if (velocità>tolleranza) {	//controllo se è stata presa la multa o meno
				
				differenza=velocità-limiteVelocità; //calcolo di quanto è stato superato il limite
				
				if (differenza<10) { //considero i vari casi di eccedenza del limite
					System.out.println("La multa prevista è compresa tra i 42 e i 173 euro e hai superato il limite di "+differenza+" km/h.");
				}else if (differenza<40) {
					System.out.println("La multa prevista è compresa tra i 173 e i 694 euro insieme alla perdita di 3 punti della patente.");
					System.out.println("Hai superato il limite di "+differenza+" km/h.");
				}else if (differenza<60) {
					System.out.println("La multa prevista è compresa tra i 543 e 2170 euro insieme a una perdita di 6 punti della patente.");
					System.out.println("Hai superato il limite di "+differenza+" km/h.");
				}else {
					System.out.println("La multa prevista è compresa tra 845 e 3382 euro insieme alla sospensione della patente e la revoca di 10 punti dalla stessa.");
					System.out.println("Hai superato il limite di "+differenza+" km/h.");
				}
				
			} else { //considero il caso in cui la multa non è stata presa
				
				System.out.println("Non hai preso alcuna multa.");
			}
			
			//adesso chiedo se vuole ripetere l'operazione per questo limite di velocità
			System.out.println("Vuoi calcolare un'altra multa per questo limite di velocità? (S/N)");
			risp=sc.nextLine();
			
		}while (risp.equals("s")||risp.equals("S"));
		sc.close();
	}

}
