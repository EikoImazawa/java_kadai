package kadai_015;

public class CarExec_Chapter15 {
	public static void main(String[] args) {
		System.out.println(args[0]);
		int intArgs = Integer.parseInt(args[0]);
//		System.out.println(args[1]);
		// 車クラスのインスタンスを作成する
		Car_Chapter150 car = new Car_Chapter150();
		System.out.println("こんにちは");
        System.out.println("今日はいい天気ですね");
        System.out.println('a');
        System.out.println('あ');
		
		int gear = car.getGear();
		System.out.println("gear=" + gear);
		
		car.setGear(intArgs);
		gear = car.getGear();
		System.out.println("変更後のgear=" + gear);
		
		// 車クラスのgearChangeメソッドを実行する
		car.gearChange(5);
		car.gearChange(4);
		
		Car_Chapter150 car1 = new Car_Chapter150();
		car1.setGear(gear);

		// 車クラスのrunメソッドを実行する
		car.run();
	}
}

