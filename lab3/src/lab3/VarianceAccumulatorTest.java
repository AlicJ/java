package lab3;

import static org.junit.Assert.*;
import org.junit.Test;

public class VarianceAccumulatorTest {
	
	int n;
	VarianceAccumulator a;
	double[] v;
	double total;
	double mean;
	double s;
	double stddev;
	double x;
	double d;

	public void test() {
		n = 10000;
		a = new VarianceAccumulator();
		v = new double[n];
		total = 0;
		
		for (int i = 0; i < n; i++) {
			x = StdRandom.uniform();
			v[i] = x;
			total += x;
			a.addDataValue(x);
		}
		
		mean = total / n;
		s = 0;
		
		for (int i = 0; i < n; i++) {
			d = v[i] - mean;
			s += d * d;
		}
		
		stddev = Math.sqrt(s / (n-1));
		
		assertEquals(mean, a.mean(), 1e-10);
		assertEquals(stddev, a.stddev(), 1e-10);
	}
	
	@Test
	public void realTest() {
		for (int i=0; i<10000; i++) {
			test();
		}
	}

}
