package kadai_021;

public class DictionaryExec_Chapter21 {
	public static void main(String[] args) {
		//辞書クラスのインスタンスを作成する
		Dictionary_Chapter21 dictionary = new Dictionary_Chapter21();

		//意味を調べる英単語を配列にセットする 
		String[] word = new String[] { "apple", "banana", "grape", "orange" };

		//辞書を調べる
		dictionary.referer(word);
	}
}
