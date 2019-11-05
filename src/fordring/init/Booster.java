package fordring.init;

import fordring.interact.CommandReader;
import fordring.interact.Logger;
import fordring.process.Processor;
/**
 * ³ÌÐòµÄÆô¶¯Æ÷
 * @author fordring
 *
 */
public class Booster {
	public static boolean isContinue = true;
	public static void main(String[] args) {
		CommandReader reader = new CommandReader(System.in);
		Logger out = new Logger(System.out);
		Processor p = ProcessorInit.getProcessor();
		while(isContinue) {
			Logger.println(p.exec(reader.getCommand()));
		}
	}

}
