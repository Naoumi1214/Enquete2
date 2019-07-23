package model;

public class modelTest {
	public static void main(String[] args) {
		Vote V = new Vote();
		EnqBeans Soba = new EnqBeans();
		EnqBeans Udon = new EnqBeans();
		EnqBeans NODLE = new EnqBeans();

		Soba.setName("そば");
		NODLE.setName("ラーメン");
		Udon.setName("うどん");

		V.inCount(NODLE);
		V.inCount(NODLE);//2
		V.inCount(Udon);//1
		//そばは0

		V.inComent(NODLE, "aaaaa");
		V.inComent(NODLE, "1");//aaaaa,1

		V.inComent(Udon, "vvvvv");
		V.inComent(Udon, "1");//vvvvv,1

		int inAll = Udon.getCount() + Soba.getCount() + NODLE.getCount();

		//そばはコメントなし

		System.out.println(Soba.getName() + Soba.getCount() + "  " + Soba.getComent());
		System.out.println(Udon.getName() + Udon.getCount() + "  " + Udon.getComent());
		System.out.println(NODLE.getName() + NODLE.getCount() + "  " + NODLE.getComent());

		System.out.println(inAll);
		System.out.println((double)Udon.getCount() / inAll);
		System.out.println((double)Soba.getCount() / inAll);
		System.out.println((double)NODLE.getCount() / inAll);
		System.out.println((int)((double)Udon.getCount() / inAll * 100));
		System.out.println((double)Soba.getCount() / inAll * 100);
		System.out.println((double)NODLE.getCount() / inAll * 100);
	}
}
