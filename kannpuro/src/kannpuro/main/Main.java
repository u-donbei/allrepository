package kannpuro.main;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static Scanner scanner;
	static HashMap<String,Var> varlist;
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("ヘルプは /help を入力してください");
		varlist = new HashMap<>();
		
		while(true) {
			System.out.println(">");
			String cmd = null;
			scanner = new Scanner(System.in);
			
			try {
				cmd = scanner.nextLine();
				
				if(cmd.startsWith("出力(") && cmd.endsWith(");")) {
					StringBuffer sb = new StringBuffer(cmd);
					
					sb.deleteCharAt(0);
					sb.deleteCharAt(0);
					sb.deleteCharAt(0);
					
					sb.deleteCharAt(sb.length()-1);
					sb.deleteCharAt(sb.length()-1);
				
					
					if(sb.toString().startsWith("\"") && sb.toString().endsWith("\"")) {
						System.out.println(sb.deleteCharAt(0).deleteCharAt(sb.length()-1));
					}
				}
				else if(cmd.equals("/exit")) {
					break;
				}
				else if (cmd.startsWith("変数") && cmd.endsWith("を作成;")) {
					StringBuffer sb = new StringBuffer(cmd);
					
					sb.delete(0, 2);
					sb.delete(sb.length()-4, sb.length());
					Var var = new Var("test");
					
					varlist.put(sb.toString(),var);
					System.out.println("|変数「" + sb + "」を作成しました");
				}
				else if (cmd.startsWith("変数を表示(") && cmd.endsWith(");")) {
					StringBuffer sb = new StringBuffer(cmd);
					
					sb.delete(0, 6);
					sb.delete(sb.length()-2, sb.length());
					
					try {
						Var out = varlist.get(sb.toString());
						System.out.println(out.getValue());
					}
					catch (Exception e) {
						System.err.println("構文エラー:変数" + sb + "は存在しません");
						continue;
					}
				}
				else {
					System.err.println("構文エラー:" + cmd + "は存在しません");
				}
			}
			finally {
				
			}
			
		}
		if(scanner != null) {
			scanner.close();
		}
		System.out.println("終了します");
	}

}
