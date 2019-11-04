package fordring;

import java.util.HashMap;
import java.util.Map;

public class Processor {
	public Map<String, Executer> map = new HashMap<String, Executer>();
	public void insertExecuter(Executer e) {
		map.put(e.getName(), e);
	}
	public String exec(Command cmd) {
		if(cmd.hasInited()) {
			Executer e = map.get(cmd.cmds[0]);
			if(e==null) {
				return "ERR!COMMAND NOT FOUND!";
			}
			return e.exec(cmd);
		}else {
			return "ERR!WRONG INPUT!";
		}
	}
}
