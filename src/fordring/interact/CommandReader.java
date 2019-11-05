package fordring.interact;

import java.io.InputStream;
import java.util.Scanner;

import fordring.msg.Command;
/**
 * CommandReader负责从输入流中读取一行，并转为Command传出
 * 
 * @author fordring
 *
 */
public class CommandReader {
	private static boolean hasInited = false;
	private static CommandReader stdCommanderReader;
	private String regix = " ";
	/**
	 * 获得初始CommandReader
	 * @return CommandReader
	 */
	public static CommandReader getCommanderReader() {
		if(hasInited)
			return stdCommanderReader;
		return null;
	}
	private final Scanner in;
	/**
	 * 根据传入的输入流，构造出CommandReader
	 * @param input
	 */
	public CommandReader(InputStream input) {
		if(!hasInited) {
			hasInited = true;
			stdCommanderReader = this;
		}
		in = new Scanner(input);
	}
	/**
	 * 从输入流读取一行，并封装为Command，会造成阻塞
	 * @return Command
	 */
	public Command getCommand() {
		Command c = new Command();
		if(in.hasNext()) {
			c.init(in.nextLine().split(regix), in);
		}
		return c;
	}
	/**
	 * 获取当前默认的分隔符
	 * @return
	 */
	public String getRegix() {
		return regix;
	}
	/**
	 * 设置当前默认的分隔符
	 * @param regix
	 */
	public void setRegix(String regix) {
		this.regix = regix;
	}
	
}
