package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("What is your starting amount? ");
		int startAmount = in.nextInt();
		System.out.println("What is your win chance? ");
		double winChance = in.nextDouble();
		System.out.println("What is your win limit? ");
		int winLimit = in.nextInt();
		System.out.println("how many days are you playing? ");
		int totalSimulations = in.nextInt();
		int realstartamount = startAmount;
		int wins = 0;
		double a = (1 - winChance) / winChance;
		double losses = 0;
		for (int i = 0; i < totalSimulations; i++) {
			while (startAmount < winLimit && startAmount > 0) {
				boolean win;
				win = Math.random() < winChance;
				if (win == true) {
					startAmount = startAmount + 1;

				} else {
					startAmount = startAmount - 1;

				}
			}
			if (startAmount == winLimit) {
				// System.out.println("Success!");
				wins = wins + 1;
				startAmount = realstartamount;
			}
			if (startAmount == 0) {
				// System.out.println("Ruin!");
				losses = losses + 1;
				startAmount = realstartamount;
			}
		}System.out.println("you won " + wins + " times");
		System.out.println("you lost " + losses + " times");
		System.out.println("expected ruin rate: " + ((Math.pow(a,realstartamount) - Math.pow(a, winLimit))/
				(1-Math.pow(a, winLimit))));
		System.out.println("ruin rate: " + (losses/totalSimulations)*100 + "%");
	}

}
