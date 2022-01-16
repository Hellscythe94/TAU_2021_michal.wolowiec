package pl.pjwstk.s13119.tau.app;

//Since the 4th lab requires to mock 2 items and the calculator has 1 class this class is solely for the purpose of mocking it in the tests

public class MagicCalculator {

	private Number number;
	
	public int magicAdd(int a, int b) {
		return a+b;
	}
	
	public Double magicSub(Double a, Double b) {
		return a-b;
	}
	
	public String magicMultiply(int a, int b) {
		Integer result = a*b;
		return result.toString();
	}
	
	public int magicDivide(int a, int b) {
		return a/b;
	}

	public int maginAddmagic(int a){
		return a + number.getMyNumber();
	}
}
