package fordring;

public class Booster {
	public static boolean isContinue = true;
	public static void main(String[] args) {
		CommandReader reader = new CommandReader(System.in);
		Processor p = ProcessorInit.getProcessor();
		while(isContinue) {
			System.out.println("sys>>"+p.exec(reader.getCommand()));
		}
	}

}
