package kadai_018;

public class KatoExec_Chapter18 {
	public static void main(String[] args) {
		//KatoTaro_Chapter18クラスのオブジェクトを作る
		KatoTaro_Chapter18 katoTaro = new KatoTaro_Chapter18();
		//加藤太郎の名をセットする
		katoTaro.setGivenName();
		//加藤太郎の紹介を実行する
		katoTaro.execIntroduce();

		//KatoIchiro_Chapter18クラスのオブジェクトを作る
		KatoIchiro_Chapter18 katoIchiro = new KatoIchiro_Chapter18();
		//加藤一郎の名をセットする
		katoIchiro.setGivenName();
		//加藤一郎の紹介を実行する
		katoIchiro.execIntroduce();

		//KatoHanako_Chapter18クラスのオブジェクトを作る
		KatoHanako_Chapter18 katoHanako = new KatoHanako_Chapter18();
		//加藤花子の名をセットする
		katoHanako.setGivenName();
		//加藤花子の紹介を実行する
		katoHanako.execIntroduce();
	}

}
