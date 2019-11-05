package fordring.init;

import fordring.executers.MatrixExec;
import fordring.process.Processor;

public class ProcessorInit {
	public static Processor getProcessor() {
		Processor p = new Processor();
		p.insertExecuter(new MatrixExec());
		return p;
	}
}
