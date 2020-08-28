public class NN {
	private float[][] w = new float[4][2];
    private float[] b = new float[4];

    public float fitness;

    public NN() {
        for (int i = 0; i < w.length; i++)
            for (int k = 0; k < w[0].length; k++)
                w[i][k] = (float)Math.random()*1f-.1f;
        
        for(int i = 0; i < b.length; i++)
            b[i] = (float)Math.random()*1f-.1f;
    }

    public NN(float[] dna) {
        int n = 0;

        for (int i = 0; i < w.length; i++, n++)
            for (int k = 0; k < w[0].length; k++, n++)
                w[i][k] = dna[n];

        for (int i = 0; i < b.length; i++, n++)
            b[i] = dna[n];
    }

    public void SetWeights(float[] dna) {
        int n = 0;

        for (int i = 0; i < w.length; i++, n++)
            for (int k = 0; k < w[0].length; k++, n++)
                w[i][k] = dna[n];

        for (int i = 0; i < b.length; i++, n++)
            b[i] = b[n];
    }

    public float[] GetDNA() {
        float[] dna = new float[13];
        int n = 0;

        for(int i = 0; i < w.length; i++, n++)
            for (int k = 0; k < w[0].length; k++, n++)
                dna[n] = w[i][k];
        
        for (int i = 0; i < b.length; i++, n++)
            dna[n] = b[i];

        return dna;
    }
	
    public String toString() {
    	String description = "";
    	
    	for (int i = 0; i < w.length; i++)
            for (int k = 0; k < w[0].length; k++)
                description += w[i][k];

        for(int i = 0; i < b.length; i++)
            description += b[i];
    	
    	return description;
    }
    
}
