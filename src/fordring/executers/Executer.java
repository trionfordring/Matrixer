package fordring.executers;

import fordring.msg.Command;

public interface Executer {
	String getName();
	String exec(Command cmd);
}
