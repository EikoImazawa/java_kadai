package kadai_018;

public abstract class Kato_Chapter18 {
	public	String	familyName1 = "加藤";	//姓を表す
	public	String	givenName	 = "";	//名を表す
	public	String	address = "東京都中野区〇×";		//住所を表す
	int age=20;
	
	// 共通の紹介を出力する
	public void	commonIntroduce(){
		System.out.println("名前は" + this.familyName1 + this.givenName + "です");
		System.out.println("住所は" + this.address + "です");
	}
	
	// 	個別の紹介を出力する
	abstract public	void	eachIntroduce() ;
	//	紹介を実行する
	public	void	execIntroduce() {
		this.commonIntroduce();
		this.eachIntroduce();
		System.out.println();
	}
}
