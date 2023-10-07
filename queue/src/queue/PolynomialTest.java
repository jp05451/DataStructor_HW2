
package queue;
/**
 * 資料結構範例 - 佇列/應用於多項式函數運算
 * @author Bor-Shen Lin at National Taiwan University of Science and Technology.
 *******************************************************************************
 *	得智慧，得聰明的，這人有福了。因為智慧的獲利勝過銀子，所得的盈餘強如金子，
 *	比寶石更寶貴，你一切所喜愛的，都不足與其比較。		箴3:13-15
 */
class Polynomial extends LinkedQueue<Term> {

	static Term match = null;
	public Object clone() {
		Polynomial p = new Polynomial();
		forEach(term -> p.append((Term) term.clone()));
		return p;
	}
	public void display() {
		forEach(term -> System.out.print(" " + term));
		System.out.println("");
	}

	public Term getMatched(Term term) {
		match = null;
		forEach((Term t) -> {
			if (t.order == term.order) {
				match = t;
			}
		});
		return match;
	}

	public Polynomial add(Polynomial p2) {
		Polynomial p = (Polynomial)clone();
		p2.forEach(term -> {
			Term target = p.getMatched(term);
			if (target != null) {
				target.coefficient += term.coefficient;
			} else {
				p.append((Term)term.clone());
			}
		});
		return p;
	}
}

/**
 *
 * @author borson
 */
public class PolynomialTest {

	public static void main(String args[]) {
		Polynomial p1 = new Polynomial();
		p1.append(new Term(3.0, 5));
		p1.append(new Term(-2.0, 3));
		p1.append(new Term(1.0, 2));
		p1.append(new Term(4.0, 0));
		p1.display();
		Polynomial p2 = new Polynomial();
		p2.append(new Term(-1.0, 4));
		p2.append(new Term(3.0, 3));
		p2.append(new Term(-2.0, 2));
		p2.append(new Term(3.0, 0));
		p2.display();
		// add polynomials p1 and p2
		Polynomial p = p1.add(p2);
		p.display();
	}
}
