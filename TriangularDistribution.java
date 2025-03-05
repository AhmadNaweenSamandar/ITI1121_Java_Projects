/**
 * This class provides an implementation of a triangular probabilistic
 * distribution. A simple mathematical explanation of this probability
 * distribution is available on Wikipedia at:
 * https://en.wikipedia.org/wiki/Triangular_distribution
 * 
 * @author Mehrdad Sabetzadeh, University of Ottawa
 *
 */
public class TriangularDistribution {

	/**
	 * a, c, b are the three parameters on the x axis of
	 * https://en.wikipedia.org/wiki/File:Triangular_distribution_PMF.png
	 */
	int a, c, b;

	/**
	 * Constructor for TriangularDistribution. You need to verify that the following
	 * condition holds: a < c AND c < b
	 * 
	 * @param a is the lower limit of the distribution
	 * @param c is the mode
	 * @param b is the upper limit of the distribution
	 */
	public TriangularDistribution(int a, int c, int b) {
	
		// WRITE YOUR CODE HERE!
		this.a = a;
		this.c = c;
		this.b = b;

	}

	/**
	 * @param x is a point on the x axis
	 * @return the probability density at point x
	 */
	public Rational pdf(int x) {
		Rational result = new Rational(0, 1);

		// WRITE YOUR CODE HERE!
		if (x < a){
			result = new Rational (0,1);
		} else if (a <= x && x < c){
			result = new Rational (2*(x-a), (b-a)*(c-a));
		} else if (x == c){
			result = new Rational (2, (b-a));
		} else if (c < x && x <= b){
			result = new Rational (2*(b-x), (b-a)*(b-c));
		} else if (b < x){
			result = new Rational (0 , 1);
		} else if (x == a || x == b){
			result = new Rational (1,1);
		}
		return result;

		 // Remove this statement when your implementation is complete.
	}
}

	/**
	 * 
	 * This method provides two examples to help you test your implementation of
	 * triangular distribution. The output obtained from running this main method in
	 * the reference solution is provided to you alongside the starter code for A2.
	 * 
	 * @param args command lines parameters (not used in the body of the method)
	 */