package fordring;

import fordring.executers.MatrixExec;

public class ProcessorInit {
	public static Processor getProcessor() {
		Processor p = new Processor();
		p.insertExecuter(new MatrixExec());
		return p;
	}
}
