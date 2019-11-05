package fordring.interact;

import java.io.InputStream;
import java.util.Scanner;

import fordring.msg.Command;
/**
 * CommandReader������������ж�ȡһ�У���תΪCommand����
 * 
 * @author fordring
 *
 */
public class CommandReader {
	private static boolean hasInited = false;
	private static CommandReader stdCommanderReader;
	private String regix = " ";
	/**
	 * ��ó�ʼCommandReader
	 * @return CommandReader
	 */
	public static CommandReader getCommanderReader() {
		if(hasInited)
			return stdCommanderReader;
		return null;
	}
	private final Scanner in;
	/**
	 * ���ݴ�����������������CommandReader
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
	 * ����������ȡһ�У�����װΪCommand�����������
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
	 * ��ȡ��ǰĬ�ϵķָ���
	 * @return
	 */
	public String getRegix() {
		return regix;
	}
	/**
	 * ���õ�ǰĬ�ϵķָ���
	 * @param regix
	 */
	public void setRegix(String regix) {
		this.regix = regix;
	}
	
}
