package listener;

import java.io.BufferedReader;
import java.io.FileReader;

import model.EnqBeans;

public class listenerTest {
	public static void main(String[] args) {
		String ss, record[];

		EnqBeans Udon = new EnqBeans();
		Udon.setName("うどん");
		EnqBeans Soba = new EnqBeans();
		Soba.setName("そば");
		EnqBeans Nodle = new EnqBeans();
		Nodle.setName("ラーメン");

		try {
			@SuppressWarnings("resource")

			BufferedReader fin = new BufferedReader(new FileReader("/WEB-INF/file/vote.txt"));
			System.out.println("a");
			int cnt = 0;
			while ((ss = fin.readLine()) != null) {
				// 文字列ssの内容を","ごとに分割して配列recordに格納

				switch (cnt) {
				case 0://票数
					record = ss.split(",");
					Udon.setCount(Integer.parseInt(record[0]));
					Soba.setCount(Integer.parseInt(record[1]));
					Nodle.setCount(Integer.parseInt(record[2]));
					break;

				case 1://うどんコメント
					Udon.setComent(ss);
					break;

				case 2://そばコメント
					Soba.setComent(ss);
					break;

				case 3://ラーメンコメント
					Nodle.setComent(ss);
					break;

				default:
					break;
				}
				cnt++;
			}

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		System.out.println(Soba.getName() + Soba.getCount() + "  " + Soba.getComent());
		System.out.println(Udon.getName() + Udon.getCount() + "  " + Udon.getComent());
		System.out.println(Nodle.getName() + Nodle.getCount() + "  " + Nodle.getComent());
	}
}
