
public class NeuralNetwork {
	private double w1, w2, b;
	
	public NeuralNetwork() {}
	
	private double sigmoid(double x) {
		return 1/(1+Math.exp(-x));
	}
	
	public void train(double learningRate, int generations, double[][] data) {
		w1 = Math.random()*1;
		w2 = Math.random()*1;
		b = Math.random()*1;
		
		for(int i = 0; i < generations; i++) {
			
			int randIndex = (int)Math.floor(Math.random()*data.length);
			double[] point = data[randIndex];
			double target = point[2];
			
			double z = w1*point[0] + w2*point[1] + b;
			double dz_dw1 = point[0];
			double dz_dw2 = point[1];
			double dz_db = 1;
			
			double prediction = sigmoid(z);
			double dprediction_dz = sigmoid(z)*(1-sigmoid(z));
			
			double cost = Math.pow((prediction - target), 2);
			double dcost_dprediction = 2*(prediction - target);;
			
			double dcost_dw1 = dcost_dprediction * dprediction_dz * dz_dw1;
			double dcost_dw2 = dcost_dprediction * dprediction_dz * dz_dw2;
			double dcost_b = dcost_dprediction * dprediction_dz * dz_db;
			
			w1 -= learningRate * dcost_dw1;
			w2 -= learningRate * dcost_dw2;
			b -= learningRate * dcost_b;
		}
		
	}
	
	public double predict(double input1, double input2) {
		return sigmoid(w1*input1 + w2*input2 + b);
	}
	
	public void clearWeights() {
		w1 = 0;
		w2 = 0;
		b = 0;
	}
	
	public String toString() {
		return "Weight1: " + w1 + "\nWeight2: " + w2 + "\nB: " + b;
	}
	
}
