package listener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.EnqBeans;

/**
 * Application Lifecycle Listener implementation class EnqBeanslistener
 *
 */
@WebListener
public class EnqBeanslistener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public EnqBeanslistener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContext application = sce.getServletContext();
		EnqBeans Udon = (EnqBeans) application.getAttribute("Udon");
		EnqBeans Soba = (EnqBeans) application.getAttribute("Soba");
		EnqBeans Nodle = (EnqBeans) application.getAttribute("Nodle");

		try {
			@SuppressWarnings("resource")
			String realPath = sce.getServletContext().getRealPath("/WEB-INF/file/vote.txt");
			PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter(realPath)));

			fout.println(Udon.getCount() + "," + Soba.getCount() + "," + Nodle.getCount());
			fout.println(Udon.getComent());
			fout.println(Soba.getComent());
			fout.println(Nodle.getComent());

			fout.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContext application = sce.getServletContext();

		String ss, record[];

		EnqBeans Udon = new EnqBeans();
		Udon.setName("うどん");
		EnqBeans Soba = new EnqBeans();
		Soba.setName("そば");
		EnqBeans Nodle = new EnqBeans();
		Nodle.setName("ラーメン");

		try {
			@SuppressWarnings("resource")
			String realPath = sce.getServletContext().getRealPath("/WEB-INF/file/vote.txt");
			BufferedReader fin = new BufferedReader(new FileReader(realPath));
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
				System.out.println(cnt);
			}
			fin.close();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		application.setAttribute("Udon", Udon);
		application.setAttribute("Soba", Soba);
		application.setAttribute("Nodle", Nodle);

		System.out.println(Soba.getName() + Soba.getCount() + "  " + Soba.getComent());
		System.out.println(Udon.getName() + Udon.getCount() + "  " + Udon.getComent());
		System.out.println(Nodle.getName() + Nodle.getCount() + "  " + Nodle.getComent());

	}

}
