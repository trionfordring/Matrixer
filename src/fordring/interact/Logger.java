package fordring.interact;

import java.io.PrintStream;

public class Logger {
	private static boolean hasInited = false;
	private static Logger stdPrinter;
	public static Logger getPrinter() {
		if(hasInited)
			return stdPrinter;
		return null;
	}
	public final PrintStream out;
	public Logger(PrintStream out){
		if(!hasInited) {
			hasInited = true;
			stdPrinter = this;
		}
		this.out = out;
	}
	public static void println(String str) {
		getPrinter().out.println("sys>> "+str);
	}
}
