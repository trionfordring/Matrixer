package fordring.msg;

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
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(String s:cmds) {
			sb.append(s+" ");
		}
		return sb.toString();
	}
}
