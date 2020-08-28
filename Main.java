
public class Main {
	public static void main(String[] args) {
		double[][] data = {{1,1.5,0}, {3,2,1}, {4,4,1}, {.5,1,0}, {3.5,.5,1}, {1,5.5,0}, {.1,1,0}, {.01,5,0}};
		
		NeuralNetwork n1 = new NeuralNetwork();
		
		n1.train(.5, 999999, data);
		
		System.out.println(n1);
		System.out.println();
		System.out.println("Prediction: " + n1.predict(2, 2));
	}
}
