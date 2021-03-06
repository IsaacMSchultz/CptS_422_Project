public class HalseadEffortTester {
	public HalseadEffortTester() {
		// Halstead Effort: The effort (E) to implement or understand a program is propotional to the volume and the difficulty. 
		// Halstead Volume (V): V = N log2 (n)
		// Halstead Difficult (D): D = (n1 / 2) * (N2 / n2)

		// N2 = 2, N1 = 4, n1 = 1, n2 = 3
		int operand1 = 1;
		int operand2 = 2;

		// Mathematical operators should increase the Halstead Volume
		// N2 = 7, N1 = 12, n1 = 6, n2 = 3
		operand1 = (operand1 + operand2) - (operand1 * operand2);

		// Halstead Volume Calculation: N = 19 and  n = 9
		// V = 19 log2 (9) 
		// V = 19(3.1169925001)
		// V = 60.22857502	

		//Halstead Difficulty Calculation:
		// D = (6 / 2) * (7 / 3)
		// D = 3 * 2.33333
		// D = 7
	}
}