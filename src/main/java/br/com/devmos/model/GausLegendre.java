package br.com.devmos.model;

public class GausLegendre {
	
	public static double a(int n) {
		if(n == 0)
			return 1;
		return (a(n - 1) + b(n - 1))/2.0;
	}

	private static double b(int n) {
		if(n == 0)
			return 1.0/Math.sqrt(2.0);
		return Math.sqrt(a(n - 1) * b(n - 1));
	}
	
	private static double t(int n) {
		if(n == 0)
			return 1.0/4.0;
		return t(n - 1) - p(n - 1) * Math.pow(a(n -1) - a(n), 2);
	}

	private static double p(int n) {
		if(n == 0)
			return 1;		
		return 2 * p(n - 1);
	}
	
	public static double pi(int n) {
		return Math.pow(a(n) + b(n), 2)/ (4 * t(n));
	}

}
