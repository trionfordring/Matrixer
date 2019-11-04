package fordring;

import java.util.Scanner;

public class Command {
	private boolean inited = false;
	public String[] cmds;
	
	public boolean hasInited() {
		return inited;
	}
	public boolean init(String[] cmds,Scanner in) {
		this.cmds = cmds;
		inited = true;
		return inited;
	}
}
