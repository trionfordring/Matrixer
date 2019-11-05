package fordring.executers;

import java.util.HashMap;
import java.util.Map;

import fordring.msg.Command;
import fordring.utils.Matrix;;

public class MatrixExec implements Executer {
	private static String name = "matrix";
	private Map<String,Matrix> map = new HashMap<String,Matrix>();
	public MatrixExec() {
		double d[][] = {
				{1,0},
				{0,1}
		};
		double d3[][] = {
				{1,0,0},
				{0,1,0},
				{0,0,1}
		};
		Matrix e = new Matrix(2, 2, d);
		map.put("E2", e);
		map.put("E3", new Matrix(3,3,d3));
		map.put("ans", e);
		
	}
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String exec(Command cmd) {
		
		return "exec!"+cmd.toString();
	}

}
