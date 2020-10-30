package pt.mleiria;

/**
 * Lego Mindstorms Back Propagation Network
 * 
 * @author manuel
 *
 */
public class LMbpn {

	public static int[][] data1 = { { 0, 0, 0 }, { 1, 1 } };
	public static int[][] data2 = { { 1, 0, 0 }, { 1, 0 } };
	public static int[][] data3 = { { 0, 0, 1 }, { 0, 1 } };
	public static int[][] data4 = { { 0, 1, 0 }, { 0, 0 } };

	public static double[] input = { 0, 0, 0, 1 };
	public static double[][] w1 = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
	public static double[] hidden = { 0, 0, 1 };
	public static double[][] w2 = { { 0, 0 }, { 0, 0 }, { 0, 0 } };
	public static double[] output = { 0, 0 };
	public static double[] delta2 = { 0, 0 };
	public static double[] delta1 = { 0, 0, 0 };

	public static int trainedEpochs = 0;

	public LMbpn() {
		initWeights();
	}

	/**
	 * Initialize weights randomly [0.1 0.9]
	 */
	private void initWeights() {
		byte i, j;

		for (i = 0; i < w1.length; i++) {
			for (j = 0; j < w1[i].length; j++) {
				w1[i][j] = Math.random() * 0.8 + 0.1;
			}
		}
		for (i = 0; i < w2.length; i++) {
			for (j = 0; j < w2[i].length; j++) {
				w2[i][j] = Math.random() * 0.8 + 0.1;
			}
		}
	}

	/**
	 * 
	 * @param e
	 */
	public static void train(final int e) {
		for (int i = 0; i < e; i++) {
			learn(data1[0], data1[1]);
			learn(data2[0], data2[1]);
			learn(data3[0], data3[1]);
			learn(data4[0], data4[1]);
			trainedEpochs++;
		}
	}

	/**
	 * 
	 * @param is
	 * @param is2
	 */
	private static void learn(final int[] inp, final int[] out) {
		int i;
		int j;
		double sum;
		double out_j;

		// Initialize input units
		for (i = 0; i < inp.length; i++) {
			input[i] = inp[i];
		}

		// Calculate hidden units
		for (j = 0; j < hidden.length - 1; j++) {
			sum = 0;
			for (i = 0; i < input.length; i++) {
				sum = sum + w1[i][j] * input[i];
			}
			hidden[j] = 1 / (1 + Math.exp(-sum));
		}
		
		//Calculate output units
		for(j = 0; j < output.length; j++) {
			sum = 0;
			for(i = 0; i < hidden.length; i++) {
				sum = sum + w2[i][j] * hidden[i];
			}
			output[j] = 1 / (1 + Math.exp(-sum));
		}
		
		//Calculate delta2 errors
		for(j = 0; j < output.length; j++) {
			if(out[j] == 0) {
				out_j = 0.1;
			}else if(out[j] == 1) {
				out_j = 0.9;
			}else {
				out_j = out[j];
			}
			delta2[j] = output[j] * (1 - output[j]) * (out_j - output[j]);
		} 
		
		//Calculate delta1 errors
		for(j = 0; j < hidden.length; j++) {
			sum = 0;
			for(i = 0; i < output.length; i++) {
				
			}
		}

	}

}
