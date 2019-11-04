package fordring;

import java.io.InputStream;
import java.util.Scanner;

public class CommandReader {
	Scanner in;
	public CommandReader(InputStream input) {
		in = new Scanner(input);
	}
	public Command getCommand() {
		Command c = new Command();
		if(in.hasNext()) {
			c.init(in.nextLine().split(" "), in);
		}
		return c;
	}
}
