package fordring.executers;

import java.util.HashMap;
import java.util.Map;

import fordring.Command;
import fordring.Executer;
import fordring.utils.Matrix;;

public class MatrixExec implements Executer {
	private static String name = "martix";
	private Map<String,Matrix> map = new HashMap<String,Matrix>();
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String exec(Command cmd) {
		
		return null;
	}

}
