
package queue;

public class Term {
	double coefficient;
	int order;
	public Term(double c, int o) {
		coefficient = c;
		order = o;
	}
	public Object clone() {
		return new Term(coefficient, order);
	}
	public String toString() {
		return coefficient+" X^"+order;
	}
}
